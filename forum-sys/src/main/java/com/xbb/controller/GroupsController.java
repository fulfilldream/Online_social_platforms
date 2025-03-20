package com.xbb.controller;

import com.xbb.common.RespResult;
import com.xbb.constant.SessionConstant;
import com.xbb.entity.Apply;
import com.xbb.entity.User;
import com.xbb.entity.Groups;
import com.xbb.service.ApplyService;
import com.xbb.service.GroupsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * 小组Controller
 */
@RestController
@CrossOrigin
@RequestMapping("/groups")
public class GroupsController {

    @Resource
    private GroupsService groupsService;
    @Resource
    private ApplyService applyService;

    // 根据条件查询分页数据及条数
    @RequestMapping("/data")
    public RespResult data(@RequestParam("page") int page,
                           @RequestParam("limit") int limit,
                           @RequestParam(value = "userId", required = false) Integer userId,
                           @RequestParam(value = "name", required = false) String name,
                           @RequestParam(value = "label", required = false) String label,
                           @RequestParam(value = "status", required = false) Integer status,
                           HttpSession session) {
        User user = (User) session.getAttribute(SessionConstant.KEY_USER);
        List<Groups> groupsList = groupsService.selectListByPaging(
                page,
                limit,
                userId,
                name,
                label,
                status
        );
        int count = groupsService.selectCountByPaging(
                userId,
                name,
                label,
                status
        );
        RespResult respResult = new RespResult();
        respResult.success(groupsList, count);
        return respResult;
    }

    // 查询全部数据
    @RequestMapping("/all")
    public RespResult all() {
        List<Groups> groupsList = groupsService.selectAll();
        RespResult respResult = new RespResult();
        respResult.success(groupsList);
        return respResult;
    }

    // 根据条件查询列表数据
    @RequestMapping("/list")
    public RespResult list(@RequestBody Groups groups) {
        List<Groups> groupsList = groupsService.selectList(groups);
        RespResult respResult = new RespResult();
        respResult.success(groupsList);
        return respResult;
    }

    // 根据字段、排序方式、limit条 查询列表数据
    @RequestMapping("/list/limit")
    public RespResult selectListByLimit(@RequestParam(value = "field", required = false) String field,
                                        @RequestParam(value = "sort", required = false) String sort,
                                        @RequestParam(value = "limit", required = false) Integer limit) {
        List<Groups> groupsList = groupsService.selectListByLimit(
                 field, sort, limit
        );
        RespResult respResult = new RespResult();
        respResult.success(groupsList);
        return respResult;
    }

    // 根据字段查询列表数据
    @RequestMapping("/list/field")
    public RespResult selectListByField(@RequestParam(value = "field", required = false) String field,
                                        @RequestParam(value = "value", required = false) Object value) {
        List<Groups> groupsList = groupsService.selectListByField(
                field, value
        );
        RespResult respResult = new RespResult();
        respResult.success(groupsList);
        return respResult;
    }

    // 根据条件查询单个数据
    @RequestMapping("/info/dynamic")
    public RespResult infoDynamic(@RequestBody Groups data) {
        Groups groups = groupsService.selectOne(data);
        RespResult respResult = new RespResult();
        respResult.success(groups);
        return respResult;
    }

    // 根据ID查询单个数据
    @RequestMapping("/info")
    public RespResult info(@RequestParam("id") Integer id) {
        Groups groups = groupsService.selectByPrimaryKey(id);
        RespResult respResult = new RespResult();
        respResult.success(groups);
        return respResult;
    }

    // 根据ID查询数据详情
    @RequestMapping("/details")
    public RespResult details(@RequestParam("id") Integer id) {
        Groups groups = groupsService.selectOneByDetails(id);
        RespResult respResult = new RespResult();
        respResult.success(groups);
        return respResult;
    }

    // 全部条数
    @RequestMapping("/count")
    public RespResult count() {
        int count = groupsService.selectAllCount();
        RespResult respResult = new RespResult();
        respResult.success(count);
        return respResult;
    }

    // 根据条件查询数据条数
    @RequestMapping("/count/dynamic")
    public RespResult countDynamic(@RequestBody Groups groups) {
        int count = groupsService.selectCount(groups);
        RespResult respResult = new RespResult();
        respResult.success(count);
        return respResult;
    }

    // 根据条件修改全部数据
    @RequestMapping("/update/all")
    public RespResult updateAll(@RequestBody Groups groups) {
        groupsService.updateAll(groups);
        RespResult respResult = new RespResult();
        return respResult;
    }

    // 添加数据
    @RequestMapping("/add")
    public RespResult add(@RequestBody Groups groups) {
        groups.setCreatTime(new Date());
        groupsService.insertSelective(groups);
        RespResult respResult = new RespResult();
        respResult.success(groups);
        return respResult;
    }

    // 修改数据
    @RequestMapping("/edit")
    public RespResult edit(@RequestBody Groups groups) {
        groupsService.updateByPrimaryKeySelective(groups);
        RespResult respResult = new RespResult();
        respResult.success(groups);
        return respResult;
    }

    // 单个删除
    @RequestMapping("/delete")
    public RespResult delete(@RequestParam("id") Integer id) {
        groupsService.deleteByPrimaryKey(id);
        return new RespResult();
    }

    // 批量删除
    @RequestMapping("/delete/list")
    public RespResult deleteList(@RequestBody Integer[] idList) {
        for (Integer id : idList) {
            groupsService.deleteByPrimaryKey(id);
        }
        return new RespResult();
    }

    @RequestMapping("/user")
    public RespResult user(@RequestParam("userId") Integer userId) {
        List<Groups> groupsList = groupsService.selectListByField("user_id", userId);
        List<Apply> applyList = applyService.selectListByField("user_id", userId);
        for (Apply apply : applyList) {
            Groups groups = groupsService.selectByPrimaryKey(apply.getGroupsId());
            groupsList.add(groups);
        }
        RespResult respResult = new RespResult();
        respResult.success(groupsList);
        return respResult;
    }

}
