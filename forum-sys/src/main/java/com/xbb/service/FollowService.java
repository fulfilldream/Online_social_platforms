package com.xbb.service;

import java.util.Date;
import java.util.List;
import com.xbb.entity.Follow;

public interface FollowService {

    // 删除数据
    int deleteByPrimaryKey(Integer id);

    // 插入数据
    int insert(Follow follow);

    // 插入数据
    int insertSelective(Follow follow);

    // 根据ID查询单个数据
    Follow selectByPrimaryKey(Integer id);

    // 修改数据
    int updateByPrimaryKeySelective(Follow follow);

    // 修改数据
    int updateByPrimaryKey(Follow follow);

    // 根据条件查询分页数据
    List<Follow> selectListByPaging(
            Integer page,
            Integer limit,
            Integer userId,
            Integer followUserId,
            String name
    );

    // 根据条件查询分页数据条数
    int selectCountByPaging(
            Integer userId,
            Integer followUserId,
            String name
    );

    // 查询全部数据
    List<Follow> selectAll();

    // 根据条件查询列表数据
    List<Follow> selectList(Follow follow);

    // 根据字段、排序方式、limit条 查询列表数据
    List<Follow> selectListByLimit(
            String field,
            String sort,
            Integer limit
    );

    // 根据字段查询列表数据
    List<Follow> selectListByField(
            String field,
            Object value
    );

    // 根据条件查询单个数据
    Follow selectOne(Follow follow);

    // 根据ID查询详情数据
    Follow selectOneByDetails(Integer id);

    // 查询全部条数
    int selectAllCount();

    // 根据条件查询数据条数
    int selectCount(Follow follow);

    // 根据条件修改全部数据
    int updateAll(Follow follow);

}
