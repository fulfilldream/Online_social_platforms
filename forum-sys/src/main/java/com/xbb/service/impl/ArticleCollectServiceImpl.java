package com.xbb.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.xbb.mapper.ArticleCollectMapper;
import com.xbb.entity.ArticleCollect;
import com.xbb.service.ArticleCollectService;
import org.springframework.stereotype.Service;

@Service
public class ArticleCollectServiceImpl implements ArticleCollectService {

    @Resource
    private ArticleCollectMapper articleCollectMapper;

    // 删除数据
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return articleCollectMapper.deleteByPrimaryKey(id);
    }

    // 插入数据
    @Override
    public int insert(ArticleCollect articleCollect) {
        return articleCollectMapper.insert(articleCollect);
    }

    // 插入数据
    @Override
    public int insertSelective(ArticleCollect articleCollect) {
        return articleCollectMapper.insertSelective(articleCollect);
    }

    // 根据ID查询单个数据
    @Override
    public ArticleCollect selectByPrimaryKey(Integer id) {
        return articleCollectMapper.selectByPrimaryKey(id);
    }

    // 修改数据
    @Override
    public int updateByPrimaryKeySelective(ArticleCollect articleCollect) {
        return articleCollectMapper.updateByPrimaryKeySelective(articleCollect);
    }

    // 修改数据
    @Override
    public int updateByPrimaryKey(ArticleCollect articleCollect) {
        return articleCollectMapper.updateByPrimaryKey(articleCollect);
    }

    // 根据条件查询分页数据
    @Override
    public List<ArticleCollect> selectListByPaging(Integer page, Integer limit, Integer articleId, Integer userId, String title) {
        return articleCollectMapper.selectListByPaging(
                (page - 1) * limit,
                limit,
                articleId,
                userId,
                title
        );
    }

    // 根据条件查询数据条数
    @Override
    public int selectCountByPaging(Integer articleId, Integer userId, String title) {
        return articleCollectMapper.selectCountByPaging(
                articleId,
                userId,
                title
        );
    }

    // 查询全部数据
    @Override
    public List<ArticleCollect> selectAll() {
        return articleCollectMapper.selectAll();
    }

    // 根据条件查询列表数据
    @Override
    public List<ArticleCollect> selectList(ArticleCollect articleCollect) {
        return articleCollectMapper.selectList(articleCollect);
    }

    // 根据字段、排序方式、limit条 查询列表数据
    @Override
    public List<ArticleCollect> selectListByLimit(String field, String sort, Integer limit) {
        return articleCollectMapper.selectListByLimit(field, sort, limit);
    }

    // 根据字段查询列表数据
    @Override
    public List<ArticleCollect> selectListByField(String field, Object value) {
        return articleCollectMapper.selectListByField(field, value);
    }

    // 根据条件查询单个数据
    @Override
    public ArticleCollect selectOne(ArticleCollect articleCollect) {
        return articleCollectMapper.selectOne(articleCollect);
    }

    // 根据ID查询详情数据
    @Override
    public ArticleCollect selectOneByDetails(Integer id) {
        return articleCollectMapper.selectOneByDetails(id);
    }

    // 查询全部条数
    @Override
    public int selectAllCount() {
        return articleCollectMapper.selectAllCount();
    }

    // 根据条件查询数据条数
    @Override
    public int selectCount(ArticleCollect articleCollect) {
        return articleCollectMapper.selectCount(articleCollect);
    }

    // 根据条件修改全部数据
    @Override
    public int updateAll(ArticleCollect articleCollect) {
        return articleCollectMapper.updateAll(articleCollect);
    }


}
