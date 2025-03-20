package com.xbb.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import com.xbb.mapper.ArticleTypeMapper;
import com.xbb.entity.ArticleType;
import com.xbb.service.ArticleTypeService;
import org.springframework.stereotype.Service;

@Service
public class ArticleTypeServiceImpl implements ArticleTypeService {

    @Resource
    private ArticleTypeMapper articleTypeMapper;

    // 删除数据
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return articleTypeMapper.deleteByPrimaryKey(id);
    }

    // 插入数据
    @Override
    public int insert(ArticleType articleType) {
        return articleTypeMapper.insert(articleType);
    }

    // 插入数据
    @Override
    public int insertSelective(ArticleType articleType) {
        return articleTypeMapper.insertSelective(articleType);
    }

    // 根据ID查询单个数据
    @Override
    public ArticleType selectByPrimaryKey(Integer id) {
        return articleTypeMapper.selectByPrimaryKey(id);
    }

    // 修改数据
    @Override
    public int updateByPrimaryKeySelective(ArticleType articleType) {
        return articleTypeMapper.updateByPrimaryKeySelective(articleType);
    }

    // 修改数据
    @Override
    public int updateByPrimaryKey(ArticleType articleType) {
        return articleTypeMapper.updateByPrimaryKey(articleType);
    }

    // 根据条件查询分页数据
    @Override
    public List<ArticleType> selectListByPaging(Integer page, Integer limit,String name) {
        return articleTypeMapper.selectListByPaging(
            (page - 1) * limit,
            limit,
            name
        );
    }

    // 根据条件查询数据条数
    @Override
    public int selectCountByPaging(String name) {
        return articleTypeMapper.selectCountByPaging(
            name
        );
    }

    // 查询全部数据
    @Override
    public List<ArticleType> selectAll() {
        return articleTypeMapper.selectAll();
    }

    // 根据条件查询列表数据
    @Override
    public List<ArticleType> selectList(ArticleType articleType) {
        return articleTypeMapper.selectList(articleType);
    }

    // 根据字段、排序方式、limit条 查询列表数据
    @Override
    public List<ArticleType> selectListByLimit(String field, String sort, Integer limit) {
        return articleTypeMapper.selectListByLimit(field, sort, limit);
    }

    // 根据字段查询列表数据
    @Override
    public List<ArticleType> selectListByField(String field, Object value) {
        return articleTypeMapper.selectListByField(field, value);
    }

    // 根据条件查询单个数据
    @Override
    public ArticleType selectOne(ArticleType articleType) {
        return articleTypeMapper.selectOne(articleType);
    }

    // 根据ID查询详情数据
    @Override
    public ArticleType selectOneByDetails(Integer id) {
        return articleTypeMapper.selectOneByDetails(id);
    }

    // 查询全部条数
    @Override
    public int selectAllCount() {
        return articleTypeMapper.selectAllCount();
    }

    // 根据条件查询数据条数
    @Override
    public int selectCount(ArticleType articleType) {
        return articleTypeMapper.selectCount(articleType);
    }

    // 根据条件修改全部数据
    @Override
    public int updateAll(ArticleType articleType) {
        return articleTypeMapper.updateAll(articleType);
    }


}
