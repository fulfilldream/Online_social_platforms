package com.xbb.mapper;

import java.util.Date;
import java.util.List;
import com.xbb.entity.Apply;
import org.apache.ibatis.annotations.Param;

public interface ApplyMapper {

    // 删除数据
    int deleteByPrimaryKey(Integer id);

    // 插入数据
    int insert(Apply apply);

    // 插入数据
    int insertSelective(Apply apply);

    // 根据ID查询单个数据
    Apply selectByPrimaryKey(Integer id);

    // 修改数据
    int updateByPrimaryKeySelective(Apply apply);

    // 修改数据
    int updateByPrimaryKey(Apply apply);

    // 查询分页数据
    List<Apply> selectListByPaging(
            @Param("page") Integer page,
            @Param("limit") Integer limit,
            @Param("userId") Integer userId,
            @Param("groupsId") Integer groupsId,
            @Param("name") String name
    );

    // 查询分页数据条数
    int selectCountByPaging(
            @Param("userId") Integer userId,
            @Param("groupsId") Integer groupsId,
            @Param("name") String name
    );

    // 查询全部数据
    List<Apply> selectAll();

    // 根据条件查询列表数据
    List<Apply> selectList(Apply apply);

    // 根据字段、排序方式、limit条 查询列表数据
    List<Apply> selectListByLimit(
            @Param("field") String field,
            @Param("sort") String sort,
            @Param("limit") Integer limit
    );

    // 根据字段查询列表数据
    List<Apply> selectListByField(
            @Param("field") String field,
            @Param("value") Object value
    );

    // 根据条件查询单个数据
    Apply selectOne(Apply apply);

    // 根据ID查询详情数据
    Apply selectOneByDetails(Integer id);

    // 查询全部条数
    int selectAllCount();

    // 根据条件查询数据条数
    int selectCount(Apply apply);

    // 根据条件修改全部数据
    int updateAll(Apply apply);


}
