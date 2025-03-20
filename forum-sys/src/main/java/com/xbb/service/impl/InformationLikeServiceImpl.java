package com.xbb.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import com.xbb.mapper.InformationLikeMapper;
import com.xbb.entity.InformationLike;
import com.xbb.service.InformationLikeService;
import org.springframework.stereotype.Service;

@Service
public class InformationLikeServiceImpl implements InformationLikeService {

    @Resource
    private InformationLikeMapper informationLikeMapper;

    // 删除数据
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return informationLikeMapper.deleteByPrimaryKey(id);
    }

    // 插入数据
    @Override
    public int insert(InformationLike informationLike) {
        return informationLikeMapper.insert(informationLike);
    }

    // 插入数据
    @Override
    public int insertSelective(InformationLike informationLike) {
        return informationLikeMapper.insertSelective(informationLike);
    }

    // 根据ID查询单个数据
    @Override
    public InformationLike selectByPrimaryKey(Integer id) {
        return informationLikeMapper.selectByPrimaryKey(id);
    }

    // 修改数据
    @Override
    public int updateByPrimaryKeySelective(InformationLike informationLike) {
        return informationLikeMapper.updateByPrimaryKeySelective(informationLike);
    }

    // 修改数据
    @Override
    public int updateByPrimaryKey(InformationLike informationLike) {
        return informationLikeMapper.updateByPrimaryKey(informationLike);
    }

    // 根据条件查询分页数据
    @Override
    public List<InformationLike> selectListByPaging(Integer page, Integer limit,Integer informationId, Integer userId) {
        return informationLikeMapper.selectListByPaging(
            (page - 1) * limit,
            limit,
            informationId,
            userId
        );
    }

    // 根据条件查询数据条数
    @Override
    public int selectCountByPaging(Integer informationId, Integer userId) {
        return informationLikeMapper.selectCountByPaging(
            informationId,
            userId
        );
    }

    // 查询全部数据
    @Override
    public List<InformationLike> selectAll() {
        return informationLikeMapper.selectAll();
    }

    // 根据条件查询列表数据
    @Override
    public List<InformationLike> selectList(InformationLike informationLike) {
        return informationLikeMapper.selectList(informationLike);
    }

    // 根据字段、排序方式、limit条 查询列表数据
    @Override
    public List<InformationLike> selectListByLimit(String field, String sort, Integer limit) {
        return informationLikeMapper.selectListByLimit(field, sort, limit);
    }

    // 根据字段查询列表数据
    @Override
    public List<InformationLike> selectListByField(String field, Object value) {
        return informationLikeMapper.selectListByField(field, value);
    }

    // 根据条件查询单个数据
    @Override
    public InformationLike selectOne(InformationLike informationLike) {
        return informationLikeMapper.selectOne(informationLike);
    }

    // 根据ID查询详情数据
    @Override
    public InformationLike selectOneByDetails(Integer id) {
        return informationLikeMapper.selectOneByDetails(id);
    }

    // 查询全部条数
    @Override
    public int selectAllCount() {
        return informationLikeMapper.selectAllCount();
    }

    // 根据条件查询数据条数
    @Override
    public int selectCount(InformationLike informationLike) {
        return informationLikeMapper.selectCount(informationLike);
    }

    // 根据条件修改全部数据
    @Override
    public int updateAll(InformationLike informationLike) {
        return informationLikeMapper.updateAll(informationLike);
    }


}
