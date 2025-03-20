package com.xbb.mapper;

import java.util.Date;
import java.util.List;
import com.xbb.entity.Follow;
import org.apache.ibatis.annotations.Param;

public interface FollowMapper {

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

    // 查询分页数据
    List<Follow> selectListByPaging(
            @Param("page") Integer page,
            @Param("limit") Integer limit,
            @Param("userId") Integer userId,
            @Param("followUserId") Integer followUserId,
            @Param("name") String name
    );

    // 查询分页数据条数
    int selectCountByPaging(
            @Param("userId") Integer userId,
            @Param("followUserId") Integer followUserId,
            @Param("name") String name
    );

    // 查询全部数据
    List<Follow> selectAll();

    // 根据条件查询列表数据
    List<Follow> selectList(Follow follow);

    // 根据字段、排序方式、limit条 查询列表数据
    List<Follow> selectListByLimit(
            @Param("field") String field,
            @Param("sort") String sort,
            @Param("limit") Integer limit
    );

    // 根据字段查询列表数据
    List<Follow> selectListByField(
            @Param("field") String field,
            @Param("value") Object value
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
