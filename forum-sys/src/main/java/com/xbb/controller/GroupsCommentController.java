package com.xbb.controller;

import com.xbb.common.RespResult;
import com.xbb.constant.SessionConstant;
import com.xbb.entity.User;
import com.xbb.entity.GroupsComment;
import com.xbb.service.GroupsCommentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * 小组交流Controller
 */
@RestController
@CrossOrigin
@RequestMapping("/groupsComment")
public class GroupsCommentController {

    @Resource
    private GroupsCommentService groupsCommentService;

    // 根据条件查询分页数据及条数
    @RequestMapping("/data")
    public RespResult data(@RequestParam("page") int page,
                           @RequestParam("limit") int limit,
                           @RequestParam(value = "groupsId", required = false) Integer groupsId,
                           @RequestParam(value = "userId", required = false) Integer userId,
                           @RequestParam(value = "content", required = false) String content,
                           @RequestParam(value = "types", required = false) Integer types,
                           HttpSession session) {
        User user = (User) session.getAttribute(SessionConstant.KEY_USER);
        List<GroupsComment> groupsCommentList = groupsCommentService.selectListByPaging(
                page,
                limit,
                groupsId,
                userId,
                content,
                types
        );
        int count = groupsCommentService.selectCountByPaging(
                groupsId,
                userId,
                content,
                types
        );
        RespResult respResult = new RespResult();
        respResult.success(groupsCommentList, count);
        return respResult;
    }

    // 查询全部数据
    @RequestMapping("/all")
    public RespResult all() {
        List<GroupsComment> groupsCommentList = groupsCommentService.selectAll();
        RespResult respResult = new RespResult();
        respResult.success(groupsCommentList);
        return respResult;
    }

    // 根据条件查询列表数据
    @RequestMapping("/list")
    public RespResult list(@RequestBody GroupsComment groupsComment) {
        List<GroupsComment> groupsCommentList = groupsCommentService.selectList(groupsComment);
        RespResult respResult = new RespResult();
        respResult.success(groupsCommentList);
        return respResult;
    }

    // 根据字段、排序方式、limit条 查询列表数据
    @RequestMapping("/list/limit")
    public RespResult selectListByLimit(@RequestParam(value = "field", required = false) String field,
                                        @RequestParam(value = "sort", required = false) String sort,
                                        @RequestParam(value = "limit", required = false) Integer limit) {
        List<GroupsComment> groupsCommentList = groupsCommentService.selectListByLimit(
                 field, sort, limit
        );
        RespResult respResult = new RespResult();
        respResult.success(groupsCommentList);
        return respResult;
    }

    // 根据字段查询列表数据
    @RequestMapping("/list/field")
    public RespResult selectListByField(@RequestParam(value = "field", required = false) String field,
                                        @RequestParam(value = "value", required = false) Object value) {
        List<GroupsComment> groupsCommentList = groupsCommentService.selectListByField(
                field, value
        );
        RespResult respResult = new RespResult();
        respResult.success(groupsCommentList);
        return respResult;
    }

    // 根据条件查询单个数据
    @RequestMapping("/info/dynamic")
    public RespResult infoDynamic(@RequestBody GroupsComment data) {
        GroupsComment groupsComment = groupsCommentService.selectOne(data);
        RespResult respResult = new RespResult();
        respResult.success(groupsComment);
        return respResult;
    }

    // 根据ID查询单个数据
    @RequestMapping("/info")
    public RespResult info(@RequestParam("id") Integer id) {
        GroupsComment groupsComment = groupsCommentService.selectByPrimaryKey(id);
        RespResult respResult = new RespResult();
        respResult.success(groupsComment);
        return respResult;
    }

    // 根据ID查询数据详情
    @RequestMapping("/details")
    public RespResult details(@RequestParam("id") Integer id) {
        GroupsComment groupsComment = groupsCommentService.selectOneByDetails(id);
        RespResult respResult = new RespResult();
        respResult.success(groupsComment);
        return respResult;
    }

    // 全部条数
    @RequestMapping("/count")
    public RespResult count() {
        int count = groupsCommentService.selectAllCount();
        RespResult respResult = new RespResult();
        respResult.success(count);
        return respResult;
    }

    // 根据条件查询数据条数
    @RequestMapping("/count/dynamic")
    public RespResult countDynamic(@RequestBody GroupsComment groupsComment) {
        int count = groupsCommentService.selectCount(groupsComment);
        RespResult respResult = new RespResult();
        respResult.success(count);
        return respResult;
    }

    // 根据条件修改全部数据
    @RequestMapping("/update/all")
    public RespResult updateAll(@RequestBody GroupsComment groupsComment) {
        groupsCommentService.updateAll(groupsComment);
        RespResult respResult = new RespResult();
        return respResult;
    }

    // 添加数据
    @RequestMapping("/add")
    public RespResult add(@RequestBody GroupsComment groupsComment) {
        groupsComment.setCreatTime(new Date());
        groupsCommentService.insertSelective(groupsComment);
        RespResult respResult = new RespResult();
        respResult.success(groupsComment);
        return respResult;
    }

    // 修改数据
    @RequestMapping("/edit")
    public RespResult edit(@RequestBody GroupsComment groupsComment) {
        groupsCommentService.updateByPrimaryKeySelective(groupsComment);
        RespResult respResult = new RespResult();
        respResult.success(groupsComment);
        return respResult;
    }

    // 单个删除
    @RequestMapping("/delete")
    public RespResult delete(@RequestParam("id") Integer id) {
        groupsCommentService.deleteByPrimaryKey(id);
        return new RespResult();
    }

    // 批量删除
    @RequestMapping("/delete/list")
    public RespResult deleteList(@RequestBody Integer[] idList) {
        for (Integer id : idList) {
            groupsCommentService.deleteByPrimaryKey(id);
        }
        return new RespResult();
    }

}
