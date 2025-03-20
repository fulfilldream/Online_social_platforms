package com.xbb.controller;

import com.xbb.common.RespResult;
import com.xbb.constant.SessionConstant;
import com.xbb.entity.User;
import com.xbb.entity.InformationLike;
import com.xbb.service.InformationLikeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * 动态点赞Controller
 */
@RestController
@CrossOrigin
@RequestMapping("/informationLike")
public class InformationLikeController {

    @Resource
    private InformationLikeService informationLikeService;

    // 根据条件查询分页数据及条数
    @RequestMapping("/data")
    public RespResult data(@RequestParam("page") int page,
                           @RequestParam("limit") int limit,
                           @RequestParam(value = "informationId", required = false) Integer informationId,
                           @RequestParam(value = "userId", required = false) Integer userId,
                           HttpSession session) {
        User user = (User) session.getAttribute(SessionConstant.KEY_USER);
        List<InformationLike> informationLikeList = informationLikeService.selectListByPaging(
                page,
                limit,
                informationId,
                userId
        );
        int count = informationLikeService.selectCountByPaging(
                informationId,
                userId
        );
        RespResult respResult = new RespResult();
        respResult.success(informationLikeList, count);
        return respResult;
    }

    // 查询全部数据
    @RequestMapping("/all")
    public RespResult all() {
        List<InformationLike> informationLikeList = informationLikeService.selectAll();
        RespResult respResult = new RespResult();
        respResult.success(informationLikeList);
        return respResult;
    }

    // 根据条件查询列表数据
    @RequestMapping("/list")
    public RespResult list(@RequestBody InformationLike informationLike) {
        List<InformationLike> informationLikeList = informationLikeService.selectList(informationLike);
        RespResult respResult = new RespResult();
        respResult.success(informationLikeList);
        return respResult;
    }

    // 根据字段、排序方式、limit条 查询列表数据
    @RequestMapping("/list/limit")
    public RespResult selectListByLimit(@RequestParam(value = "field", required = false) String field,
                                        @RequestParam(value = "sort", required = false) String sort,
                                        @RequestParam(value = "limit", required = false) Integer limit) {
        List<InformationLike> informationLikeList = informationLikeService.selectListByLimit(
                 field, sort, limit
        );
        RespResult respResult = new RespResult();
        respResult.success(informationLikeList);
        return respResult;
    }

    // 根据字段查询列表数据
    @RequestMapping("/list/field")
    public RespResult selectListByField(@RequestParam(value = "field", required = false) String field,
                                        @RequestParam(value = "value", required = false) Object value) {
        List<InformationLike> informationLikeList = informationLikeService.selectListByField(
                field, value
        );
        RespResult respResult = new RespResult();
        respResult.success(informationLikeList);
        return respResult;
    }

    // 根据条件查询单个数据
    @RequestMapping("/info/dynamic")
    public RespResult infoDynamic(@RequestBody InformationLike data) {
        InformationLike informationLike = informationLikeService.selectOne(data);
        RespResult respResult = new RespResult();
        respResult.success(informationLike);
        return respResult;
    }

    // 根据ID查询单个数据
    @RequestMapping("/info")
    public RespResult info(@RequestParam("id") Integer id) {
        InformationLike informationLike = informationLikeService.selectByPrimaryKey(id);
        RespResult respResult = new RespResult();
        respResult.success(informationLike);
        return respResult;
    }

    // 根据ID查询数据详情
    @RequestMapping("/details")
    public RespResult details(@RequestParam("id") Integer id) {
        InformationLike informationLike = informationLikeService.selectOneByDetails(id);
        RespResult respResult = new RespResult();
        respResult.success(informationLike);
        return respResult;
    }

    // 全部条数
    @RequestMapping("/count")
    public RespResult count() {
        int count = informationLikeService.selectAllCount();
        RespResult respResult = new RespResult();
        respResult.success(count);
        return respResult;
    }

    // 根据条件查询数据条数
    @RequestMapping("/count/dynamic")
    public RespResult countDynamic(@RequestBody InformationLike informationLike) {
        int count = informationLikeService.selectCount(informationLike);
        RespResult respResult = new RespResult();
        respResult.success(count);
        return respResult;
    }

    // 根据条件修改全部数据
    @RequestMapping("/update/all")
    public RespResult updateAll(@RequestBody InformationLike informationLike) {
        informationLikeService.updateAll(informationLike);
        RespResult respResult = new RespResult();
        return respResult;
    }

    // 添加数据
    @RequestMapping("/add")
    public RespResult add(@RequestBody InformationLike informationLike) {
        informationLikeService.insertSelective(informationLike);
        RespResult respResult = new RespResult();
        respResult.success(informationLike);
        return respResult;
    }

    // 修改数据
    @RequestMapping("/edit")
    public RespResult edit(@RequestBody InformationLike informationLike) {
        informationLikeService.updateByPrimaryKeySelective(informationLike);
        RespResult respResult = new RespResult();
        respResult.success(informationLike);
        return respResult;
    }

    // 单个删除
    @RequestMapping("/delete")
    public RespResult delete(@RequestParam("id") Integer id) {
        informationLikeService.deleteByPrimaryKey(id);
        return new RespResult();
    }

    // 批量删除
    @RequestMapping("/delete/list")
    public RespResult deleteList(@RequestBody Integer[] idList) {
        for (Integer id : idList) {
            informationLikeService.deleteByPrimaryKey(id);
        }
        return new RespResult();
    }

}
