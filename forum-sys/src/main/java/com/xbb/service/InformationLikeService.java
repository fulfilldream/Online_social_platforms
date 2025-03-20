package com.xbb.service;

import java.util.Date;
import java.util.List;
import com.xbb.entity.InformationLike;

public interface InformationLikeService {

    // 删除数据
    int deleteByPrimaryKey(Integer id);

    // 插入数据
    int insert(InformationLike informationLike);

    // 插入数据
    int insertSelective(InformationLike informationLike);

    // 根据ID查询单个数据
    InformationLike selectByPrimaryKey(Integer id);

    // 修改数据
    int updateByPrimaryKeySelective(InformationLike informationLike);

    // 修改数据
    int updateByPrimaryKey(InformationLike informationLike);

    // 根据条件查询分页数据
    List<InformationLike> selectListByPaging(
            Integer page,
            Integer limit,
            Integer informationId,
            Integer userId
    );

    // 根据条件查询分页数据条数
    int selectCountByPaging(
            Integer informationId,
            Integer userId
    );

    // 查询全部数据
    List<InformationLike> selectAll();

    // 根据条件查询列表数据
    List<InformationLike> selectList(InformationLike informationLike);

    // 根据字段、排序方式、limit条 查询列表数据
    List<InformationLike> selectListByLimit(
            String field,
            String sort,
            Integer limit
    );

    // 根据字段查询列表数据
    List<InformationLike> selectListByField(
            String field,
            Object value
    );

    // 根据条件查询单个数据
    InformationLike selectOne(InformationLike informationLike);

    // 根据ID查询详情数据
    InformationLike selectOneByDetails(Integer id);

    // 查询全部条数
    int selectAllCount();

    // 根据条件查询数据条数
    int selectCount(InformationLike informationLike);

    // 根据条件修改全部数据
    int updateAll(InformationLike informationLike);

}
