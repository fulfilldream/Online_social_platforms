package com.xbb.mapper;

import java.util.Date;
import java.util.List;
import com.xbb.entity.ArticleCollect;
import org.apache.ibatis.annotations.Param;

public interface ArticleCollectMapper {

    // 删除数据
    int deleteByPrimaryKey(Integer id);

    // 插入数据
    int insert(ArticleCollect articleCollect);

    // 插入数据
    int insertSelective(ArticleCollect articleCollect);

    // 根据ID查询单个数据
    ArticleCollect selectByPrimaryKey(Integer id);

    // 修改数据
    int updateByPrimaryKeySelective(ArticleCollect articleCollect);

    // 修改数据
    int updateByPrimaryKey(ArticleCollect articleCollect);

    // 查询分页数据
    List<ArticleCollect> selectListByPaging(
            @Param("page") Integer page,
            @Param("limit") Integer limit,
            @Param("articleId") Integer articleId,
            @Param("userId") Integer userId,
            @Param("title") String title
    );

    // 查询分页数据条数
    int selectCountByPaging(
            @Param("articleId") Integer articleId,
            @Param("userId") Integer userId,
            @Param("title") String title
    );

    // 查询全部数据
    List<ArticleCollect> selectAll();

    // 根据条件查询列表数据
    List<ArticleCollect> selectList(ArticleCollect articleCollect);

    // 根据字段、排序方式、limit条 查询列表数据
    List<ArticleCollect> selectListByLimit(
            @Param("field") String field,
            @Param("sort") String sort,
            @Param("limit") Integer limit
    );

    // 根据字段查询列表数据
    List<ArticleCollect> selectListByField(
            @Param("field") String field,
            @Param("value") Object value
    );

    // 根据条件查询单个数据
    ArticleCollect selectOne(ArticleCollect articleCollect);

    // 根据ID查询详情数据
    ArticleCollect selectOneByDetails(Integer id);

    // 查询全部条数
    int selectAllCount();

    // 根据条件查询数据条数
    int selectCount(ArticleCollect articleCollect);

    // 根据条件修改全部数据
    int updateAll(ArticleCollect articleCollect);


}
