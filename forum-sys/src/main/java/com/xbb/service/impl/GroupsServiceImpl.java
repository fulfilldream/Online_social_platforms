package com.xbb.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import com.xbb.mapper.GroupsMapper;
import com.xbb.entity.Groups;
import com.xbb.service.GroupsService;
import org.springframework.stereotype.Service;

@Service
public class GroupsServiceImpl implements GroupsService {

    @Resource
    private GroupsMapper groupsMapper;

    // 删除数据
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return groupsMapper.deleteByPrimaryKey(id);
    }

    // 插入数据
    @Override
    public int insert(Groups groups) {
        return groupsMapper.insert(groups);
    }

    // 插入数据
    @Override
    public int insertSelective(Groups groups) {
        return groupsMapper.insertSelective(groups);
    }

    // 根据ID查询单个数据
    @Override
    public Groups selectByPrimaryKey(Integer id) {
        return groupsMapper.selectByPrimaryKey(id);
    }

    // 修改数据
    @Override
    public int updateByPrimaryKeySelective(Groups groups) {
        return groupsMapper.updateByPrimaryKeySelective(groups);
    }

    // 修改数据
    @Override
    public int updateByPrimaryKey(Groups groups) {
        return groupsMapper.updateByPrimaryKey(groups);
    }

    // 根据条件查询分页数据
    @Override
    public List<Groups> selectListByPaging(Integer page, Integer limit,Integer userId, String name, String label, Integer status) {
        return groupsMapper.selectListByPaging(
            (page - 1) * limit,
            limit,
            userId,
            name,
            label,
            status
        );
    }

    // 根据条件查询数据条数
    @Override
    public int selectCountByPaging(Integer userId, String name, String label, Integer status) {
        return groupsMapper.selectCountByPaging(
            userId,
            name,
            label,
            status
        );
    }

    // 查询全部数据
    @Override
    public List<Groups> selectAll() {
        return groupsMapper.selectAll();
    }

    // 根据条件查询列表数据
    @Override
    public List<Groups> selectList(Groups groups) {
        return groupsMapper.selectList(groups);
    }

    // 根据字段、排序方式、limit条 查询列表数据
    @Override
    public List<Groups> selectListByLimit(String field, String sort, Integer limit) {
        return groupsMapper.selectListByLimit(field, sort, limit);
    }

    // 根据字段查询列表数据
    @Override
    public List<Groups> selectListByField(String field, Object value) {
        return groupsMapper.selectListByField(field, value);
    }

    // 根据条件查询单个数据
    @Override
    public Groups selectOne(Groups groups) {
        return groupsMapper.selectOne(groups);
    }

    // 根据ID查询详情数据
    @Override
    public Groups selectOneByDetails(Integer id) {
        return groupsMapper.selectOneByDetails(id);
    }

    // 查询全部条数
    @Override
    public int selectAllCount() {
        return groupsMapper.selectAllCount();
    }

    // 根据条件查询数据条数
    @Override
    public int selectCount(Groups groups) {
        return groupsMapper.selectCount(groups);
    }

    // 根据条件修改全部数据
    @Override
    public int updateAll(Groups groups) {
        return groupsMapper.updateAll(groups);
    }


}
