package com.xbb.controller;

import com.xbb.common.RespResult;
import com.xbb.constant.SessionConstant;
import com.xbb.entity.User;
import com.xbb.entity.Follow;
import com.xbb.service.FollowService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * 关注Controller
 */
@RestController
@CrossOrigin
@RequestMapping("/follow")
public class FollowController {

    @Resource
    private FollowService followService;

    // 根据条件查询分页数据及条数
    @RequestMapping("/data")
    public RespResult data(@RequestParam("page") int page,
                           @RequestParam("limit") int limit,
                           @RequestParam(value = "userId", required = false) Integer userId,
                           @RequestParam(value = "followUserId", required = false) Integer followUserId,
                           @RequestParam(value = "name", required = false) String name,
                           HttpSession session) {
        User user = (User) session.getAttribute(SessionConstant.KEY_USER);
        List<Follow> followList = followService.selectListByPaging(
                page,
                limit,
                userId,
                followUserId,
                name
        );
        int count = followService.selectCountByPaging(
                userId,
                followUserId,
                name
        );
        RespResult respResult = new RespResult();
        respResult.success(followList, count);
        return respResult;
    }

    // 查询全部数据
    @RequestMapping("/all")
    public RespResult all() {
        List<Follow> followList = followService.selectAll();
        RespResult respResult = new RespResult();
        respResult.success(followList);
        return respResult;
    }

    // 根据条件查询列表数据
    @RequestMapping("/list")
    public RespResult list(@RequestBody Follow follow) {
        List<Follow> followList = followService.selectList(follow);
        RespResult respResult = new RespResult();
        respResult.success(followList);
        return respResult;
    }

    // 根据字段、排序方式、limit条 查询列表数据
    @RequestMapping("/list/limit")
    public RespResult selectListByLimit(@RequestParam(value = "field", required = false) String field,
                                        @RequestParam(value = "sort", required = false) String sort,
                                        @RequestParam(value = "limit", required = false) Integer limit) {
        List<Follow> followList = followService.selectListByLimit(
                 field, sort, limit
        );
        RespResult respResult = new RespResult();
        respResult.success(followList);
        return respResult;
    }

    // 根据字段查询列表数据
    @RequestMapping("/list/field")
    public RespResult selectListByField(@RequestParam(value = "field", required = false) String field,
                                        @RequestParam(value = "value", required = false) Object value) {
        List<Follow> followList = followService.selectListByField(
                field, value
        );
        RespResult respResult = new RespResult();
        respResult.success(followList);
        return respResult;
    }

    // 根据条件查询单个数据
    @RequestMapping("/info/dynamic")
    public RespResult infoDynamic(@RequestBody Follow data) {
        Follow follow = followService.selectOne(data);
        RespResult respResult = new RespResult();
        respResult.success(follow);
        return respResult;
    }

    // 根据ID查询单个数据
    @RequestMapping("/info")
    public RespResult info(@RequestParam("id") Integer id) {
        Follow follow = followService.selectByPrimaryKey(id);
        RespResult respResult = new RespResult();
        respResult.success(follow);
        return respResult;
    }

    // 根据ID查询数据详情
    @RequestMapping("/details")
    public RespResult details(@RequestParam("id") Integer id) {
        Follow follow = followService.selectOneByDetails(id);
        RespResult respResult = new RespResult();
        respResult.success(follow);
        return respResult;
    }

    // 全部条数
    @RequestMapping("/count")
    public RespResult count() {
        int count = followService.selectAllCount();
        RespResult respResult = new RespResult();
        respResult.success(count);
        return respResult;
    }

    // 根据条件查询数据条数
    @RequestMapping("/count/dynamic")
    public RespResult countDynamic(@RequestBody Follow follow) {
        int count = followService.selectCount(follow);
        RespResult respResult = new RespResult();
        respResult.success(count);
        return respResult;
    }

    // 根据条件修改全部数据
    @RequestMapping("/update/all")
    public RespResult updateAll(@RequestBody Follow follow) {
        followService.updateAll(follow);
        RespResult respResult = new RespResult();
        return respResult;
    }

    // 添加数据
    @RequestMapping("/add")
    public RespResult add(@RequestBody Follow follow) {
        followService.insertSelective(follow);
        RespResult respResult = new RespResult();
        respResult.success(follow);
        return respResult;
    }

    // 修改数据
    @RequestMapping("/edit")
    public RespResult edit(@RequestBody Follow follow) {
        followService.updateByPrimaryKeySelective(follow);
        RespResult respResult = new RespResult();
        respResult.success(follow);
        return respResult;
    }

    // 单个删除
    @RequestMapping("/delete")
    public RespResult delete(@RequestParam("id") Integer id) {
        followService.deleteByPrimaryKey(id);
        return new RespResult();
    }

    // 批量删除
    @RequestMapping("/delete/list")
    public RespResult deleteList(@RequestBody Integer[] idList) {
        for (Integer id : idList) {
            followService.deleteByPrimaryKey(id);
        }
        return new RespResult();
    }

}
