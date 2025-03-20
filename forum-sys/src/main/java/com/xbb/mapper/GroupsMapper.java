package com.xbb.mapper;

import java.util.Date;
import java.util.List;
import com.xbb.entity.Groups;
import org.apache.ibatis.annotations.Param;

public interface GroupsMapper {

    // 删除数据
    int deleteByPrimaryKey(Integer id);

    // 插入数据
    int insert(Groups groups);

    // 插入数据
    int insertSelective(Groups groups);

    // 根据ID查询单个数据
    Groups selectByPrimaryKey(Integer id);

    // 修改数据
    int updateByPrimaryKeySelective(Groups groups);

    // 修改数据
    int updateByPrimaryKey(Groups groups);

    // 查询分页数据
    List<Groups> selectListByPaging(
            @Param("page") Integer page,
            @Param("limit") Integer limit,
            @Param("userId") Integer userId,
            @Param("name") String name,
            @Param("label") String label,
            @Param("status") Integer status
    );

    // 查询分页数据条数
    int selectCountByPaging(
            @Param("userId") Integer userId,
            @Param("name") String name,
            @Param("label") String label,
            @Param("status") Integer status
    );

    // 查询全部数据
    List<Groups> selectAll();

    // 根据条件查询列表数据
    List<Groups> selectList(Groups groups);

    // 根据字段、排序方式、limit条 查询列表数据
    List<Groups> selectListByLimit(
            @Param("field") String field,
            @Param("sort") String sort,
            @Param("limit") Integer limit
    );

    // 根据字段查询列表数据
    List<Groups> selectListByField(
            @Param("field") String field,
            @Param("value") Object value
    );

    // 根据条件查询单个数据
    Groups selectOne(Groups groups);

    // 根据ID查询详情数据
    Groups selectOneByDetails(Integer id);

    // 查询全部条数
    int selectAllCount();

    // 根据条件查询数据条数
    int selectCount(Groups groups);

    // 根据条件修改全部数据
    int updateAll(Groups groups);


}
