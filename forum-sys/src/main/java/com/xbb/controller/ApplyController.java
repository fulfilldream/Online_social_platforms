package com.xbb.controller;

import com.xbb.common.RespResult;
import com.xbb.constant.SessionConstant;
import com.xbb.entity.User;
import com.xbb.entity.Apply;
import com.xbb.service.ApplyService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * 小组加入Controller
 */
@RestController
@CrossOrigin
@RequestMapping("/apply")
public class ApplyController {

    @Resource
    private ApplyService applyService;

    // 根据条件查询分页数据及条数
    @RequestMapping("/data")
    public RespResult data(@RequestParam("page") int page,
                           @RequestParam("limit") int limit,
                           @RequestParam(value = "userId", required = false) Integer userId,
                           @RequestParam(value = "groupsId", required = false) Integer groupsId,
                           @RequestParam(value = "name", required = false) String name,
                           HttpSession session) {
        User user = (User) session.getAttribute(SessionConstant.KEY_USER);
        List<Apply> applyList = applyService.selectListByPaging(
                page,
                limit,
                userId,
                groupsId,
                name
        );
        int count = applyService.selectCountByPaging(
                userId,
                groupsId,
                name
        );
        RespResult respResult = new RespResult();
        respResult.success(applyList, count);
        return respResult;
    }

    // 查询全部数据
    @RequestMapping("/all")
    public RespResult all() {
        List<Apply> applyList = applyService.selectAll();
        RespResult respResult = new RespResult();
        respResult.success(applyList);
        return respResult;
    }

    // 根据条件查询列表数据
    @RequestMapping("/list")
    public RespResult list(@RequestBody Apply apply) {
        List<Apply> applyList = applyService.selectList(apply);
        RespResult respResult = new RespResult();
        respResult.success(applyList);
        return respResult;
    }

    // 根据字段、排序方式、limit条 查询列表数据
    @RequestMapping("/list/limit")
    public RespResult selectListByLimit(@RequestParam(value = "field", required = false) String field,
                                        @RequestParam(value = "sort", required = false) String sort,
                                        @RequestParam(value = "limit", required = false) Integer limit) {
        List<Apply> applyList = applyService.selectListByLimit(
                 field, sort, limit
        );
        RespResult respResult = new RespResult();
        respResult.success(applyList);
        return respResult;
    }

    // 根据字段查询列表数据
    @RequestMapping("/list/field")
    public RespResult selectListByField(@RequestParam(value = "field", required = false) String field,
                                        @RequestParam(value = "value", required = false) Object value) {
        List<Apply> applyList = applyService.selectListByField(
                field, value
        );
        RespResult respResult = new RespResult();
        respResult.success(applyList);
        return respResult;
    }

    // 根据条件查询单个数据
    @RequestMapping("/info/dynamic")
    public RespResult infoDynamic(@RequestBody Apply data) {
        Apply apply = applyService.selectOne(data);
        RespResult respResult = new RespResult();
        respResult.success(apply);
        return respResult;
    }

    // 根据ID查询单个数据
    @RequestMapping("/info")
    public RespResult info(@RequestParam("id") Integer id) {
        Apply apply = applyService.selectByPrimaryKey(id);
        RespResult respResult = new RespResult();
        respResult.success(apply);
        return respResult;
    }

    // 根据ID查询数据详情
    @RequestMapping("/details")
    public RespResult details(@RequestParam("id") Integer id) {
        Apply apply = applyService.selectOneByDetails(id);
        RespResult respResult = new RespResult();
        respResult.success(apply);
        return respResult;
    }

    // 全部条数
    @RequestMapping("/count")
    public RespResult count() {
        int count = applyService.selectAllCount();
        RespResult respResult = new RespResult();
        respResult.success(count);
        return respResult;
    }

    // 根据条件查询数据条数
    @RequestMapping("/count/dynamic")
    public RespResult countDynamic(@RequestBody Apply apply) {
        int count = applyService.selectCount(apply);
        RespResult respResult = new RespResult();
        respResult.success(count);
        return respResult;
    }

    // 根据条件修改全部数据
    @RequestMapping("/update/all")
    public RespResult updateAll(@RequestBody Apply apply) {
        applyService.updateAll(apply);
        RespResult respResult = new RespResult();
        return respResult;
    }

    // 添加数据
    @RequestMapping("/add")
    public RespResult add(@RequestBody Apply apply) {
        applyService.insertSelective(apply);
        RespResult respResult = new RespResult();
        respResult.success(apply);
        return respResult;
    }

    // 修改数据
    @RequestMapping("/edit")
    public RespResult edit(@RequestBody Apply apply) {
        applyService.updateByPrimaryKeySelective(apply);
        RespResult respResult = new RespResult();
        respResult.success(apply);
        return respResult;
    }

    // 单个删除
    @RequestMapping("/delete")
    public RespResult delete(@RequestParam("id") Integer id) {
        applyService.deleteByPrimaryKey(id);
        return new RespResult();
    }

    // 批量删除
    @RequestMapping("/delete/list")
    public RespResult deleteList(@RequestBody Integer[] idList) {
        for (Integer id : idList) {
            applyService.deleteByPrimaryKey(id);
        }
        return new RespResult();
    }

}
