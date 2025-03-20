package com.xbb.mapper;

import java.util.Date;
import java.util.List;
import com.xbb.entity.Information;
import org.apache.ibatis.annotations.Param;

public interface InformationMapper {

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

    // 查询分页数据
    List<Information> selectListByPaging(
            @Param("page") Integer page,
            @Param("limit") Integer limit,
            @Param("title") String title,
            @Param("userId") Integer userId
    );

    // 查询分页数据条数
    int selectCountByPaging(
            @Param("title") String title,
            @Param("userId") Integer userId
    );

    // 查询全部数据
    List<Information> selectAll();

    // 根据条件查询列表数据
    List<Information> selectList(Information information);

    // 根据字段、排序方式、limit条 查询列表数据
    List<Information> selectListByLimit(
            @Param("field") String field,
            @Param("sort") String sort,
            @Param("limit") Integer limit
    );

    // 根据字段查询列表数据
    List<Information> selectListByField(
            @Param("field") String field,
            @Param("value") Object value
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
