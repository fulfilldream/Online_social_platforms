package com.xbb.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import com.xbb.mapper.InformationMapper;
import com.xbb.entity.Information;
import com.xbb.service.InformationService;
import org.springframework.stereotype.Service;

@Service
public class InformationServiceImpl implements InformationService {

    @Resource
    private InformationMapper informationMapper;

    // 删除数据
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return informationMapper.deleteByPrimaryKey(id);
    }

    // 插入数据
    @Override
    public int insert(Information information) {
        return informationMapper.insert(information);
    }

    // 插入数据
    @Override
    public int insertSelective(Information information) {
        return informationMapper.insertSelective(information);
    }

    // 根据ID查询单个数据
    @Override
    public Information selectByPrimaryKey(Integer id) {
        return informationMapper.selectByPrimaryKey(id);
    }

    // 修改数据
    @Override
    public int updateByPrimaryKeySelective(Information information) {
        return informationMapper.updateByPrimaryKeySelective(information);
    }

    // 修改数据
    @Override
    public int updateByPrimaryKey(Information information) {
        return informationMapper.updateByPrimaryKey(information);
    }

    // 根据条件查询分页数据
    @Override
    public List<Information> selectListByPaging(Integer page, Integer limit,String title, Integer userId) {
        return informationMapper.selectListByPaging(
            (page - 1) * limit,
            limit,
            title,
            userId
        );
    }

    // 根据条件查询数据条数
    @Override
    public int selectCountByPaging(String title, Integer userId) {
        return informationMapper.selectCountByPaging(
            title,
            userId
        );
    }

    // 查询全部数据
    @Override
    public List<Information> selectAll() {
        return informationMapper.selectAll();
    }

    // 根据条件查询列表数据
    @Override
    public List<Information> selectList(Information information) {
        return informationMapper.selectList(information);
    }

    // 根据字段、排序方式、limit条 查询列表数据
    @Override
    public List<Information> selectListByLimit(String field, String sort, Integer limit) {
        return informationMapper.selectListByLimit(field, sort, limit);
    }

    // 根据字段查询列表数据
    @Override
    public List<Information> selectListByField(String field, Object value) {
        return informationMapper.selectListByField(field, value);
    }

    // 根据条件查询单个数据
    @Override
    public Information selectOne(Information information) {
        return informationMapper.selectOne(information);
    }

    // 根据ID查询详情数据
    @Override
    public Information selectOneByDetails(Integer id) {
        return informationMapper.selectOneByDetails(id);
    }

    // 查询全部条数
    @Override
    public int selectAllCount() {
        return informationMapper.selectAllCount();
    }

    // 根据条件查询数据条数
    @Override
    public int selectCount(Information information) {
        return informationMapper.selectCount(information);
    }

    // 根据条件修改全部数据
    @Override
    public int updateAll(Information information) {
        return informationMapper.updateAll(information);
    }

}
