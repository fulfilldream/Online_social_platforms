package com.xbb.controller;

import com.xbb.common.RespResult;
import com.xbb.constant.SessionConstant;
import com.xbb.entity.User;
import com.xbb.entity.ArticleType;
import com.xbb.service.ArticleTypeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * 文章类型Controller
 */
@RestController
@CrossOrigin
@RequestMapping("/articleType")
public class ArticleTypeController {

    @Resource
    private ArticleTypeService articleTypeService;

    // 根据条件查询分页数据及条数
    @RequestMapping("/data")
    public RespResult data(@RequestParam("page") int page,
                           @RequestParam("limit") int limit,
                           @RequestParam(value = "name", required = false) String name,
                           HttpSession session) {
        User user = (User) session.getAttribute(SessionConstant.KEY_USER);
        List<ArticleType> articleTypeList = articleTypeService.selectListByPaging(
                page,
                limit,
                name
        );
        int count = articleTypeService.selectCountByPaging(
                name
        );
        RespResult respResult = new RespResult();
        respResult.success(articleTypeList, count);
        return respResult;
    }

    // 查询全部数据
    @RequestMapping("/all")
    public RespResult all() {
        List<ArticleType> articleTypeList = articleTypeService.selectAll();
        RespResult respResult = new RespResult();
        respResult.success(articleTypeList);
        return respResult;
    }

    // 根据条件查询列表数据
    @RequestMapping("/list")
    public RespResult list(@RequestBody ArticleType articleType) {
        List<ArticleType> articleTypeList = articleTypeService.selectList(articleType);
        RespResult respResult = new RespResult();
        respResult.success(articleTypeList);
        return respResult;
    }

    // 根据字段、排序方式、limit条 查询列表数据
    @RequestMapping("/list/limit")
    public RespResult selectListByLimit(@RequestParam(value = "field", required = false) String field,
                                        @RequestParam(value = "sort", required = false) String sort,
                                        @RequestParam(value = "limit", required = false) Integer limit) {
        List<ArticleType> articleTypeList = articleTypeService.selectListByLimit(
                 field, sort, limit
        );
        RespResult respResult = new RespResult();
        respResult.success(articleTypeList);
        return respResult;
    }

    // 根据字段查询列表数据
    @RequestMapping("/list/field")
    public RespResult selectListByField(@RequestParam(value = "field", required = false) String field,
                                        @RequestParam(value = "value", required = false) Object value) {
        List<ArticleType> articleTypeList = articleTypeService.selectListByField(
                field, value
        );
        RespResult respResult = new RespResult();
        respResult.success(articleTypeList);
        return respResult;
    }

    // 根据条件查询单个数据
    @RequestMapping("/info/dynamic")
    public RespResult infoDynamic(@RequestBody ArticleType data) {
        ArticleType articleType = articleTypeService.selectOne(data);
        RespResult respResult = new RespResult();
        respResult.success(articleType);
        return respResult;
    }

    // 根据ID查询单个数据
    @RequestMapping("/info")
    public RespResult info(@RequestParam("id") Integer id) {
        ArticleType articleType = articleTypeService.selectByPrimaryKey(id);
        RespResult respResult = new RespResult();
        respResult.success(articleType);
        return respResult;
    }

    // 根据ID查询数据详情
    @RequestMapping("/details")
    public RespResult details(@RequestParam("id") Integer id) {
        ArticleType articleType = articleTypeService.selectOneByDetails(id);
        RespResult respResult = new RespResult();
        respResult.success(articleType);
        return respResult;
    }

    // 全部条数
    @RequestMapping("/count")
    public RespResult count() {
        int count = articleTypeService.selectAllCount();
        RespResult respResult = new RespResult();
        respResult.success(count);
        return respResult;
    }

    // 根据条件查询数据条数
    @RequestMapping("/count/dynamic")
    public RespResult countDynamic(@RequestBody ArticleType articleType) {
        int count = articleTypeService.selectCount(articleType);
        RespResult respResult = new RespResult();
        respResult.success(count);
        return respResult;
    }

    // 根据条件修改全部数据
    @RequestMapping("/update/all")
    public RespResult updateAll(@RequestBody ArticleType articleType) {
        articleTypeService.updateAll(articleType);
        RespResult respResult = new RespResult();
        return respResult;
    }

    // 添加数据
    @RequestMapping("/add")
    public RespResult add(@RequestBody ArticleType articleType) {
        articleTypeService.insertSelective(articleType);
        RespResult respResult = new RespResult();
        respResult.success(articleType);
        return respResult;
    }

    // 修改数据
    @RequestMapping("/edit")
    public RespResult edit(@RequestBody ArticleType articleType) {
        articleTypeService.updateByPrimaryKeySelective(articleType);
        RespResult respResult = new RespResult();
        respResult.success(articleType);
        return respResult;
    }

    // 单个删除
    @RequestMapping("/delete")
    public RespResult delete(@RequestParam("id") Integer id) {
        articleTypeService.deleteByPrimaryKey(id);
        return new RespResult();
    }

    // 批量删除
    @RequestMapping("/delete/list")
    public RespResult deleteList(@RequestBody Integer[] idList) {
        for (Integer id : idList) {
            articleTypeService.deleteByPrimaryKey(id);
        }
        return new RespResult();
    }

}
