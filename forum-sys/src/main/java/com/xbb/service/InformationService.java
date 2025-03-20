package com.xbb.service;

import java.util.Date;
import java.util.List;
import com.xbb.entity.Information;

public interface InformationService {

    // 删除数据
    int deleteByPrimaryKey(Integer id);

    // 插入数据
    int insert(Information information);

    // 插入数据
    int insertSelective(Information information);

    // 根据ID查询单个数据
    Information selectByPrimaryKey(Integer id);

    // 修改数据
    int updateByPrimaryKeySelective(Information information);

    // 修改数据
    int updateByPrimaryKey(Information information);

    // 根据条件查询分页数据
    List<Information> selectListByPaging(
            Integer page,
            Integer limit,
            String title,
            Integer userId
    );

    // 根据条件查询分页数据条数
    int selectCountByPaging(
            String title,
            Integer userId
    );

    // 查询全部数据
    List<Information> selectAll();

    // 根据条件查询列表数据
    List<Information> selectList(Information information);

    // 根据字段、排序方式、limit条 查询列表数据
    List<Information> selectListByLimit(
            String field,
            String sort,
            Integer limit
    );

    // 根据字段查询列表数据
    List<Information> selectListByField(
            String field,
            Object value
    );

    // 根据条件查询单个数据
    Information selectOne(Information information);

    // 根据ID查询详情数据
    Information selectOneByDetails(Integer id);

    // 查询全部条数
    int selectAllCount();

    // 根据条件查询数据条数
    int selectCount(Information information);

    // 根据条件修改全部数据
    int updateAll(Information information);

}
