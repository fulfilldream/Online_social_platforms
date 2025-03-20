package com.xbb.mapper;

import java.util.Date;
import java.util.List;
import com.xbb.entity.InformationComment;
import org.apache.ibatis.annotations.Param;

public interface InformationCommentMapper {

    // 删除数据
    int deleteByPrimaryKey(Integer id);

    // 插入数据
    int insert(InformationComment informationComment);

    // 插入数据
    int insertSelective(InformationComment informationComment);

    // 根据ID查询单个数据
    InformationComment selectByPrimaryKey(Integer id);

    // 修改数据
    int updateByPrimaryKeySelective(InformationComment informationComment);

    // 修改数据
    int updateByPrimaryKey(InformationComment informationComment);

    // 查询分页数据
    List<InformationComment> selectListByPaging(
            @Param("page") Integer page,
            @Param("limit") Integer limit,
            @Param("userId") Integer userId,
            @Param("informationId") Integer informationId,
            @Param("content") String content,
            @Param("title") String title
    );

    // 查询分页数据条数
    int selectCountByPaging(
            @Param("userId") Integer userId,
            @Param("informationId") Integer informationId,
            @Param("content") String content,
            @Param("title") String title
    );

    // 查询全部数据
    List<InformationComment> selectAll();

    // 根据条件查询列表数据
    List<InformationComment> selectList(InformationComment informationComment);

    // 根据字段、排序方式、limit条 查询列表数据
    List<InformationComment> selectListByLimit(
            @Param("field") String field,
            @Param("sort") String sort,
            @Param("limit") Integer limit
    );

    // 根据字段查询列表数据
    List<InformationComment> selectListByField(
            @Param("field") String field,
            @Param("value") Object value
    );

    // 根据条件查询单个数据
    InformationComment selectOne(InformationComment informationComment);

    // 根据ID查询详情数据
    InformationComment selectOneByDetails(Integer id);

    // 查询全部条数
    int selectAllCount();

    // 根据条件查询数据条数
    int selectCount(InformationComment informationComment);

    // 根据条件修改全部数据
    int updateAll(InformationComment informationComment);


}
