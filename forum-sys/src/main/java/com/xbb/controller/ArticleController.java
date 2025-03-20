package com.xbb.controller;

import com.xbb.common.RespResult;
import com.xbb.constant.SessionConstant;
import com.xbb.entity.Statistics;
import com.xbb.entity.User;
import com.xbb.entity.Article;
import com.xbb.service.ArticleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * 文章Controller
 */
@RestController
@CrossOrigin
@RequestMapping("/article")
public class ArticleController {

    @Resource
    private ArticleService articleService;

    // 根据条件查询分页数据及条数
    @RequestMapping("/data")
    public RespResult data(@RequestParam("page") int page,
                           @RequestParam("limit") int limit,
                           @RequestParam(value = "title", required = false) String title,
                           @RequestParam(value = "userId", required = false) Integer userId,
                           @RequestParam(value = "articleTypeId", required = false) Integer articleTypeId,
                           @RequestParam(value = "groupsId", required = false) Integer groupsId,
                           @RequestParam(value = "status", required = false) Integer status,
                           HttpSession session) {
        User user = (User) session.getAttribute(SessionConstant.KEY_USER);
        List<Article> articleList = articleService.selectListByPaging(
                page,
                limit,
                title,
                userId,
                articleTypeId,
                groupsId,
                status
        );
        int count = articleService.selectCountByPaging(
                title,
                userId,
                articleTypeId,
                groupsId,
                status
        );
        RespResult respResult = new RespResult();
        respResult.success(articleList, count);
        return respResult;
    }

    // 查询全部数据
    @RequestMapping("/all")
    public RespResult all() {
        List<Article> articleList = articleService.selectAll();
        RespResult respResult = new RespResult();
        respResult.success(articleList);
        return respResult;
    }

    // 根据条件查询列表数据
    @RequestMapping("/list")
    public RespResult list(@RequestBody Article article) {
        List<Article> articleList = articleService.selectList(article);
        RespResult respResult = new RespResult();
        respResult.success(articleList);
        return respResult;
    }

    // 根据字段、排序方式、limit条 查询列表数据
    @RequestMapping("/list/limit")
    public RespResult selectListByLimit(@RequestParam(value = "field", required = false) String field,
                                        @RequestParam(value = "sort", required = false) String sort,
                                        @RequestParam(value = "limit", required = false) Integer limit) {
        List<Article> articleList = articleService.selectListByLimit(
                 field, sort, limit
        );
        RespResult respResult = new RespResult();
        respResult.success(articleList);
        return respResult;
    }

    // 根据字段查询列表数据
    @RequestMapping("/list/field")
    public RespResult selectListByField(@RequestParam(value = "field", required = false) String field,
                                        @RequestParam(value = "value", required = false) Object value) {
        List<Article> articleList = articleService.selectListByField(
                field, value
        );
        RespResult respResult = new RespResult();
        respResult.success(articleList);
        return respResult;
    }

    // 根据条件查询单个数据
    @RequestMapping("/info/dynamic")
    public RespResult infoDynamic(@RequestBody Article data) {
        Article article = articleService.selectOne(data);
        RespResult respResult = new RespResult();
        respResult.success(article);
        return respResult;
    }

    // 根据ID查询单个数据
    @RequestMapping("/info")
    public RespResult info(@RequestParam("id") Integer id) {
        Article article = articleService.selectByPrimaryKey(id);
        RespResult respResult = new RespResult();
        respResult.success(article);
        return respResult;
    }

    // 根据ID查询数据详情
    @RequestMapping("/details")
    public RespResult details(@RequestParam("id") Integer id) {
        Article article = articleService.selectOneByDetails(id);
        article.setReadCount(article.getReadCount() + 1);
        articleService.updateByPrimaryKeySelective(article);
        RespResult respResult = new RespResult();
        respResult.success(article);
        return respResult;
    }

    // 全部条数
    @RequestMapping("/count")
    public RespResult count() {
        int count = articleService.selectAllCount();
        RespResult respResult = new RespResult();
        respResult.success(count);
        return respResult;
    }

    // 根据条件查询数据条数
    @RequestMapping("/count/dynamic")
    public RespResult countDynamic(@RequestBody Article article) {
        int count = articleService.selectCount(article);
        RespResult respResult = new RespResult();
        respResult.success(count);
        return respResult;
    }

    // 根据条件修改全部数据
    @RequestMapping("/update/all")
    public RespResult updateAll(@RequestBody Article article) {
        articleService.updateAll(article);
        RespResult respResult = new RespResult();
        return respResult;
    }

    // 添加数据
    @RequestMapping("/add")
    public RespResult add(@RequestBody Article article) {
        article.setCreatTime(new Date());
        articleService.insertSelective(article);
        RespResult respResult = new RespResult();
        respResult.success(article);
        return respResult;
    }

    // 修改数据
    @RequestMapping("/edit")
    public RespResult edit(@RequestBody Article article) {
        articleService.updateByPrimaryKeySelective(article);
        RespResult respResult = new RespResult();
        respResult.success(article);
        return respResult;
    }

    // 单个删除
    @RequestMapping("/delete")
    public RespResult delete(@RequestParam("id") Integer id) {
        articleService.deleteByPrimaryKey(id);
        return new RespResult();
    }

    // 批量删除
    @RequestMapping("/delete/list")
    public RespResult deleteList(@RequestBody Integer[] idList) {
        for (Integer id : idList) {
            articleService.deleteByPrimaryKey(id);
        }
        return new RespResult();
    }

    // 分类统计
    @ResponseBody
    @RequestMapping("/statistics/type")
    public RespResult statisticsType () {
        // 饼图数据
        List<Statistics> statisticsList = articleService.selectStatisticsByType();

        // 柱图数据
        List<String> nameList = new ArrayList<>();
        List<Object> valueList = new ArrayList<>();
        for (Statistics data : statisticsList) {
            nameList.add(data.getName());
            valueList.add(data.getValue());
        }

        Map<String, Object> data = new HashMap<>();
        data.put("statisticsList", statisticsList);
        data.put("nameList", nameList);
        data.put("valueList", valueList);

        RespResult respResult = new RespResult();
        respResult.success(data);
        return respResult;
    }

    // 小组统计
    @ResponseBody
    @RequestMapping("/statistics/groups")
    public RespResult statisticsGroups () {
        // 饼图数据
        List<Statistics> statisticsList = articleService.selectStatisticsByGroups();

        // 柱图数据
        List<String> nameList = new ArrayList<>();
        List<Object> valueList = new ArrayList<>();
        for (Statistics data : statisticsList) {
            nameList.add(data.getName());
            valueList.add(data.getValue());
        }

        Map<String, Object> data = new HashMap<>();
        data.put("statisticsList", statisticsList);
        data.put("nameList", nameList);
        data.put("valueList", valueList);

        RespResult respResult = new RespResult();
        respResult.success(data);
        return respResult;
    }

}
