package com.xbb.mapper;

import java.util.Date;
import java.util.List;
import com.xbb.entity.GroupsComment;
import org.apache.ibatis.annotations.Param;

public interface GroupsCommentMapper {

    // 删除数据
    int deleteByPrimaryKey(Integer id);

    // 插入数据
    int insert(GroupsComment groupsComment);

    // 插入数据
    int insertSelective(GroupsComment groupsComment);

    // 根据ID查询单个数据
    GroupsComment selectByPrimaryKey(Integer id);

    // 修改数据
    int updateByPrimaryKeySelective(GroupsComment groupsComment);

    // 修改数据
    int updateByPrimaryKey(GroupsComment groupsComment);

    // 查询分页数据
    List<GroupsComment> selectListByPaging(
            @Param("page") Integer page,
            @Param("limit") Integer limit,
            @Param("groupsId") Integer groupsId,
            @Param("userId") Integer userId,
            @Param("content") String content,
            @Param("types") Integer types
    );

    // 查询分页数据条数
    int selectCountByPaging(
            @Param("groupsId") Integer groupsId,
            @Param("userId") Integer userId,
            @Param("content") String content,
            @Param("types") Integer types
    );

    // 查询全部数据
    List<GroupsComment> selectAll();

    // 根据条件查询列表数据
    List<GroupsComment> selectList(GroupsComment groupsComment);

    // 根据字段、排序方式、limit条 查询列表数据
    List<GroupsComment> selectListByLimit(
            @Param("field") String field,
            @Param("sort") String sort,
            @Param("limit") Integer limit
    );

    // 根据字段查询列表数据
    List<GroupsComment> selectListByField(
            @Param("field") String field,
            @Param("value") Object value
    );

    // 根据条件查询单个数据
    GroupsComment selectOne(GroupsComment groupsComment);

    // 根据ID查询详情数据
    GroupsComment selectOneByDetails(Integer id);

    // 查询全部条数
    int selectAllCount();

    // 根据条件查询数据条数
    int selectCount(GroupsComment groupsComment);

    // 根据条件修改全部数据
    int updateAll(GroupsComment groupsComment);


}
