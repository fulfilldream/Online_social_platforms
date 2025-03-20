package com.xbb.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import com.xbb.mapper.FollowMapper;
import com.xbb.entity.Follow;
import com.xbb.service.FollowService;
import org.springframework.stereotype.Service;

@Service
public class FollowServiceImpl implements FollowService {

    @Resource
    private FollowMapper followMapper;

    // 删除数据
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return followMapper.deleteByPrimaryKey(id);
    }

    // 插入数据
    @Override
    public int insert(Follow follow) {
        return followMapper.insert(follow);
    }

    // 插入数据
    @Override
    public int insertSelective(Follow follow) {
        return followMapper.insertSelective(follow);
    }

    // 根据ID查询单个数据
    @Override
    public Follow selectByPrimaryKey(Integer id) {
        return followMapper.selectByPrimaryKey(id);
    }

    // 修改数据
    @Override
    public int updateByPrimaryKeySelective(Follow follow) {
        return followMapper.updateByPrimaryKeySelective(follow);
    }

    // 修改数据
    @Override
    public int updateByPrimaryKey(Follow follow) {
        return followMapper.updateByPrimaryKey(follow);
    }

    // 根据条件查询分页数据
    @Override
    public List<Follow> selectListByPaging(Integer page, Integer limit,Integer userId, Integer followUserId, String name) {
        return followMapper.selectListByPaging(
            (page - 1) * limit,
            limit,
            userId,
            followUserId,
                name
        );
    }

    // 根据条件查询数据条数
    @Override
    public int selectCountByPaging(Integer userId, Integer followUserId, String name) {
        return followMapper.selectCountByPaging(
            userId,
            followUserId,
                name
        );
    }

    // 查询全部数据
    @Override
    public List<Follow> selectAll() {
        return followMapper.selectAll();
    }

    // 根据条件查询列表数据
    @Override
    public List<Follow> selectList(Follow follow) {
        return followMapper.selectList(follow);
    }

    // 根据字段、排序方式、limit条 查询列表数据
    @Override
    public List<Follow> selectListByLimit(String field, String sort, Integer limit) {
        return followMapper.selectListByLimit(field, sort, limit);
    }

    // 根据字段查询列表数据
    @Override
    public List<Follow> selectListByField(String field, Object value) {
        return followMapper.selectListByField(field, value);
    }

    // 根据条件查询单个数据
    @Override
    public Follow selectOne(Follow follow) {
        return followMapper.selectOne(follow);
    }

    // 根据ID查询详情数据
    @Override
    public Follow selectOneByDetails(Integer id) {
        return followMapper.selectOneByDetails(id);
    }

    // 查询全部条数
    @Override
    public int selectAllCount() {
        return followMapper.selectAllCount();
    }

    // 根据条件查询数据条数
    @Override
    public int selectCount(Follow follow) {
        return followMapper.selectCount(follow);
    }

    // 根据条件修改全部数据
    @Override
    public int updateAll(Follow follow) {
        return followMapper.updateAll(follow);
    }


}
