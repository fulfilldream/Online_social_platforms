package com.xbb.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import com.xbb.mapper.GroupsCommentMapper;
import com.xbb.entity.GroupsComment;
import com.xbb.service.GroupsCommentService;
import org.springframework.stereotype.Service;

@Service
public class GroupsCommentServiceImpl implements GroupsCommentService {

    @Resource
    private GroupsCommentMapper groupsCommentMapper;

    // 删除数据
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return groupsCommentMapper.deleteByPrimaryKey(id);
    }

    // 插入数据
    @Override
    public int insert(GroupsComment groupsComment) {
        return groupsCommentMapper.insert(groupsComment);
    }

    // 插入数据
    @Override
    public int insertSelective(GroupsComment groupsComment) {
        return groupsCommentMapper.insertSelective(groupsComment);
    }

    // 根据ID查询单个数据
    @Override
    public GroupsComment selectByPrimaryKey(Integer id) {
        return groupsCommentMapper.selectByPrimaryKey(id);
    }

    // 修改数据
    @Override
    public int updateByPrimaryKeySelective(GroupsComment groupsComment) {
        return groupsCommentMapper.updateByPrimaryKeySelective(groupsComment);
    }

    // 修改数据
    @Override
    public int updateByPrimaryKey(GroupsComment groupsComment) {
        return groupsCommentMapper.updateByPrimaryKey(groupsComment);
    }

    // 根据条件查询分页数据
    @Override
    public List<GroupsComment> selectListByPaging(Integer page, Integer limit,Integer groupsId, Integer userId, String content, Integer types) {
        return groupsCommentMapper.selectListByPaging(
            (page - 1) * limit,
            limit,
            groupsId,
            userId,
            content,
            types
        );
    }

    // 根据条件查询数据条数
    @Override
    public int selectCountByPaging(Integer groupsId, Integer userId, String content, Integer types) {
        return groupsCommentMapper.selectCountByPaging(
            groupsId,
            userId,
            content,
            types
        );
    }

    // 查询全部数据
    @Override
    public List<GroupsComment> selectAll() {
        return groupsCommentMapper.selectAll();
    }

    // 根据条件查询列表数据
    @Override
    public List<GroupsComment> selectList(GroupsComment groupsComment) {
        return groupsCommentMapper.selectList(groupsComment);
    }

    // 根据字段、排序方式、limit条 查询列表数据
    @Override
    public List<GroupsComment> selectListByLimit(String field, String sort, Integer limit) {
        return groupsCommentMapper.selectListByLimit(field, sort, limit);
    }

    // 根据字段查询列表数据
    @Override
    public List<GroupsComment> selectListByField(String field, Object value) {
        return groupsCommentMapper.selectListByField(field, value);
    }

    // 根据条件查询单个数据
    @Override
    public GroupsComment selectOne(GroupsComment groupsComment) {
        return groupsCommentMapper.selectOne(groupsComment);
    }

    // 根据ID查询详情数据
    @Override
    public GroupsComment selectOneByDetails(Integer id) {
        return groupsCommentMapper.selectOneByDetails(id);
    }

    // 查询全部条数
    @Override
    public int selectAllCount() {
        return groupsCommentMapper.selectAllCount();
    }

    // 根据条件查询数据条数
    @Override
    public int selectCount(GroupsComment groupsComment) {
        return groupsCommentMapper.selectCount(groupsComment);
    }

    // 根据条件修改全部数据
    @Override
    public int updateAll(GroupsComment groupsComment) {
        return groupsCommentMapper.updateAll(groupsComment);
    }


}
