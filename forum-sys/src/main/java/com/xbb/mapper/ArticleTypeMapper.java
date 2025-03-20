package com.xbb.mapper;

import java.util.Date;
import java.util.List;
import com.xbb.entity.ArticleType;
import org.apache.ibatis.annotations.Param;

public interface ArticleTypeMapper {

    // 删除数据
    int deleteByPrimaryKey(Integer id);

    // 插入数据
    int insert(ArticleType articleType);

    // 插入数据
    int insertSelective(ArticleType articleType);

    // 根据ID查询单个数据
    ArticleType selectByPrimaryKey(Integer id);

    // 修改数据
    int updateByPrimaryKeySelective(ArticleType articleType);

    // 修改数据
    int updateByPrimaryKey(ArticleType articleType);

    // 查询分页数据
    List<ArticleType> selectListByPaging(
            @Param("page") Integer page,
            @Param("limit") Integer limit,
            @Param("name") String name
    );

    // 查询分页数据条数
    int selectCountByPaging(
            @Param("name") String name
    );

    // 查询全部数据
    List<ArticleType> selectAll();

    // 根据条件查询列表数据
    List<ArticleType> selectList(ArticleType articleType);

    // 根据字段、排序方式、limit条 查询列表数据
    List<ArticleType> selectListByLimit(
            @Param("field") String field,
            @Param("sort") String sort,
            @Param("limit") Integer limit
    );

    // 根据字段查询列表数据
    List<ArticleType> selectListByField(
            @Param("field") String field,
            @Param("value") Object value
    );

    // 根据条件查询单个数据
    ArticleType selectOne(ArticleType articleType);

    // 根据ID查询详情数据
    ArticleType selectOneByDetails(Integer id);

    // 查询全部条数
    int selectAllCount();

    // 根据条件查询数据条数
    int selectCount(ArticleType articleType);

    // 根据条件修改全部数据
    int updateAll(ArticleType articleType);


}
