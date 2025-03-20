package com.xbb.controller;

import com.xbb.common.RespResult;
import com.xbb.constant.SessionConstant;
import com.xbb.entity.User;
import com.xbb.entity.InformationComment;
import com.xbb.service.InformationCommentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * 动态评论Controller
 */
@RestController
@CrossOrigin
@RequestMapping("/informationComment")
public class InformationCommentController {

    @Resource
    private InformationCommentService informationCommentService;

    // 根据条件查询分页数据及条数
    @RequestMapping("/data")
    public RespResult data(@RequestParam("page") int page,
                           @RequestParam("limit") int limit,
                           @RequestParam(value = "userId", required = false) Integer userId,
                           @RequestParam(value = "informationId", required = false) Integer informationId,
                           @RequestParam(value = "content", required = false) String content,
                           @RequestParam(value = "title", required = false) String title,
                           HttpSession session) {
        User user = (User) session.getAttribute(SessionConstant.KEY_USER);
        List<InformationComment> informationCommentList = informationCommentService.selectListByPaging(
                page,
                limit,
                userId,
                informationId,
                content,
                title
        );
        int count = informationCommentService.selectCountByPaging(
                userId,
                informationId,
                content,
                title
        );
        RespResult respResult = new RespResult();
        respResult.success(informationCommentList, count);
        return respResult;
    }

    // 查询全部数据
    @RequestMapping("/all")
    public RespResult all() {
        List<InformationComment> informationCommentList = informationCommentService.selectAll();
        RespResult respResult = new RespResult();
        respResult.success(informationCommentList);
        return respResult;
    }

    // 根据条件查询列表数据
    @RequestMapping("/list")
    public RespResult list(@RequestBody InformationComment informationComment) {
        List<InformationComment> informationCommentList = informationCommentService.selectList(informationComment);
        RespResult respResult = new RespResult();
        respResult.success(informationCommentList);
        return respResult;
    }

    // 根据字段、排序方式、limit条 查询列表数据
    @RequestMapping("/list/limit")
    public RespResult selectListByLimit(@RequestParam(value = "field", required = false) String field,
                                        @RequestParam(value = "sort", required = false) String sort,
                                        @RequestParam(value = "limit", required = false) Integer limit) {
        List<InformationComment> informationCommentList = informationCommentService.selectListByLimit(
                 field, sort, limit
        );
        RespResult respResult = new RespResult();
        respResult.success(informationCommentList);
        return respResult;
    }

    // 根据字段查询列表数据
    @RequestMapping("/list/field")
    public RespResult selectListByField(@RequestParam(value = "field", required = false) String field,
                                        @RequestParam(value = "value", required = false) Object value) {
        List<InformationComment> informationCommentList = informationCommentService.selectListByField(
                field, value
        );
        RespResult respResult = new RespResult();
        respResult.success(informationCommentList);
        return respResult;
    }

    // 根据条件查询单个数据
    @RequestMapping("/info/dynamic")
    public RespResult infoDynamic(@RequestBody InformationComment data) {
        InformationComment informationComment = informationCommentService.selectOne(data);
        RespResult respResult = new RespResult();
        respResult.success(informationComment);
        return respResult;
    }

    // 根据ID查询单个数据
    @RequestMapping("/info")
    public RespResult info(@RequestParam("id") Integer id) {
        InformationComment informationComment = informationCommentService.selectByPrimaryKey(id);
        RespResult respResult = new RespResult();
        respResult.success(informationComment);
        return respResult;
    }

    // 根据ID查询数据详情
    @RequestMapping("/details")
    public RespResult details(@RequestParam("id") Integer id) {
        InformationComment informationComment = informationCommentService.selectOneByDetails(id);
        RespResult respResult = new RespResult();
        respResult.success(informationComment);
        return respResult;
    }

    // 全部条数
    @RequestMapping("/count")
    public RespResult count() {
        int count = informationCommentService.selectAllCount();
        RespResult respResult = new RespResult();
        respResult.success(count);
        return respResult;
    }

    // 根据条件查询数据条数
    @RequestMapping("/count/dynamic")
    public RespResult countDynamic(@RequestBody InformationComment informationComment) {
        int count = informationCommentService.selectCount(informationComment);
        RespResult respResult = new RespResult();
        respResult.success(count);
        return respResult;
    }

    // 根据条件修改全部数据
    @RequestMapping("/update/all")
    public RespResult updateAll(@RequestBody InformationComment informationComment) {
        informationCommentService.updateAll(informationComment);
        RespResult respResult = new RespResult();
        return respResult;
    }

    // 添加数据
    @RequestMapping("/add")
    public RespResult add(@RequestBody InformationComment informationComment) {
        informationComment.setCreatTime(new Date());
        informationCommentService.insertSelective(informationComment);
        RespResult respResult = new RespResult();
        respResult.success(informationComment);
        return respResult;
    }

    // 修改数据
    @RequestMapping("/edit")
    public RespResult edit(@RequestBody InformationComment informationComment) {
        informationCommentService.updateByPrimaryKeySelective(informationComment);
        RespResult respResult = new RespResult();
        respResult.success(informationComment);
        return respResult;
    }

    // 单个删除
    @RequestMapping("/delete")
    public RespResult delete(@RequestParam("id") Integer id) {
        informationCommentService.deleteByPrimaryKey(id);
        return new RespResult();
    }

    // 批量删除
    @RequestMapping("/delete/list")
    public RespResult deleteList(@RequestBody Integer[] idList) {
        for (Integer id : idList) {
            informationCommentService.deleteByPrimaryKey(id);
        }
        return new RespResult();
    }

}
