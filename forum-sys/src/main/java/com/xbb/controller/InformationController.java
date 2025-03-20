package com.xbb.controller;

import com.xbb.common.RespResult;
import com.xbb.constant.SessionConstant;
import com.xbb.entity.User;
import com.xbb.entity.Information;
import com.xbb.service.InformationService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * 动态Controller
 */
@RestController
@CrossOrigin
@RequestMapping("/information")
public class InformationController {

    @Resource
    private InformationService informationService;

    // 根据条件查询分页数据及条数
    @RequestMapping("/data")
    public RespResult data(@RequestParam("page") int page,
                           @RequestParam("limit") int limit,
                           @RequestParam(value = "title", required = false) String title,
                           @RequestParam(value = "userId", required = false) Integer userId,
                           HttpSession session) {
        User user = (User) session.getAttribute(SessionConstant.KEY_USER);
        List<Information> informationList = informationService.selectListByPaging(
                page,
                limit,
                title,
                userId
        );
        int count = informationService.selectCountByPaging(
                title,
                userId
        );
        RespResult respResult = new RespResult();
        respResult.success(informationList, count);
        return respResult;
    }

    // 查询全部数据
    @RequestMapping("/all")
    public RespResult all() {
        List<Information> informationList = informationService.selectAll();
        RespResult respResult = new RespResult();
        respResult.success(informationList);
        return respResult;
    }

    // 根据条件查询列表数据
    @RequestMapping("/list")
    public RespResult list(@RequestBody Information information) {
        List<Information> informationList = informationService.selectList(information);
        RespResult respResult = new RespResult();
        respResult.success(informationList);
        return respResult;
    }

    // 根据字段、排序方式、limit条 查询列表数据
    @RequestMapping("/list/limit")
    public RespResult selectListByLimit(@RequestParam(value = "field", required = false) String field,
                                        @RequestParam(value = "sort", required = false) String sort,
                                        @RequestParam(value = "limit", required = false) Integer limit) {
        List<Information> informationList = informationService.selectListByLimit(
                 field, sort, limit
        );
        RespResult respResult = new RespResult();
        respResult.success(informationList);
        return respResult;
    }

    // 根据字段查询列表数据
    @RequestMapping("/list/field")
    public RespResult selectListByField(@RequestParam(value = "field", required = false) String field,
                                        @RequestParam(value = "value", required = false) Object value) {
        List<Information> informationList = informationService.selectListByField(
                field, value
        );
        RespResult respResult = new RespResult();
        respResult.success(informationList);
        return respResult;
    }

    // 根据条件查询单个数据
    @RequestMapping("/info/dynamic")
    public RespResult infoDynamic(@RequestBody Information data) {
        Information information = informationService.selectOne(data);
        RespResult respResult = new RespResult();
        respResult.success(information);
        return respResult;
    }

    // 根据ID查询单个数据
    @RequestMapping("/info")
    public RespResult info(@RequestParam("id") Integer id) {
        Information information = informationService.selectByPrimaryKey(id);
        RespResult respResult = new RespResult();
        respResult.success(information);
        return respResult;
    }

    // 根据ID查询数据详情
    @RequestMapping("/details")
    public RespResult details(@RequestParam("id") Integer id) {
        Information information = informationService.selectOneByDetails(id);
        information.setReadCount(information.getReadCount() + 1);
        informationService.updateByPrimaryKeySelective(information);
        RespResult respResult = new RespResult();
        respResult.success(information);
        return respResult;
    }

    // 全部条数
    @RequestMapping("/count")
    public RespResult count() {
        int count = informationService.selectAllCount();
        RespResult respResult = new RespResult();
        respResult.success(count);
        return respResult;
    }

    // 根据条件查询数据条数
    @RequestMapping("/count/dynamic")
    public RespResult countDynamic(@RequestBody Information information) {
        int count = informationService.selectCount(information);
        RespResult respResult = new RespResult();
        respResult.success(count);
        return respResult;
    }

    // 根据条件修改全部数据
    @RequestMapping("/update/all")
    public RespResult updateAll(@RequestBody Information information) {
        informationService.updateAll(information);
        RespResult respResult = new RespResult();
        return respResult;
    }

    // 添加数据
    @RequestMapping("/add")
    public RespResult add(@RequestBody Information information) {
        information.setCreatTime(new Date());
        informationService.insertSelective(information);
        RespResult respResult = new RespResult();
        respResult.success(information);
        return respResult;
    }

    // 修改数据
    @RequestMapping("/edit")
    public RespResult edit(@RequestBody Information information) {
        informationService.updateByPrimaryKeySelective(information);
        RespResult respResult = new RespResult();
        respResult.success(information);
        return respResult;
    }

    // 单个删除
    @RequestMapping("/delete")
    public RespResult delete(@RequestParam("id") Integer id) {
        informationService.deleteByPrimaryKey(id);
        return new RespResult();
    }

    // 批量删除
    @RequestMapping("/delete/list")
    public RespResult deleteList(@RequestBody Integer[] idList) {
        for (Integer id : idList) {
            informationService.deleteByPrimaryKey(id);
        }
        return new RespResult();
    }

}
