package com.xbb.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import com.xbb.mapper.InformationCommentMapper;
import com.xbb.entity.InformationComment;
import com.xbb.service.InformationCommentService;
import org.springframework.stereotype.Service;

@Service
public class InformationCommentServiceImpl implements InformationCommentService {

    @Resource
    private InformationCommentMapper informationCommentMapper;

    // 删除数据
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return informationCommentMapper.deleteByPrimaryKey(id);
    }

    // 插入数据
    @Override
    public int insert(InformationComment informationComment) {
        return informationCommentMapper.insert(informationComment);
    }

    // 插入数据
    @Override
    public int insertSelective(InformationComment informationComment) {
        return informationCommentMapper.insertSelective(informationComment);
    }

    // 根据ID查询单个数据
    @Override
    public InformationComment selectByPrimaryKey(Integer id) {
        return informationCommentMapper.selectByPrimaryKey(id);
    }

    // 修改数据
    @Override
    public int updateByPrimaryKeySelective(InformationComment informationComment) {
        return informationCommentMapper.updateByPrimaryKeySelective(informationComment);
    }

    // 修改数据
    @Override
    public int updateByPrimaryKey(InformationComment informationComment) {
        return informationCommentMapper.updateByPrimaryKey(informationComment);
    }

    // 根据条件查询分页数据
    @Override
    public List<InformationComment> selectListByPaging(Integer page, Integer limit,Integer userId, Integer informationId, String content, String title) {
        return informationCommentMapper.selectListByPaging(
            (page - 1) * limit,
            limit,
            userId,
            informationId,
            content,
                title
        );
    }

    // 根据条件查询数据条数
    @Override
    public int selectCountByPaging(Integer userId, Integer informationId, String content, String title) {
        return informationCommentMapper.selectCountByPaging(
            userId,
            informationId,
            content,
                title
        );
    }

    // 查询全部数据
    @Override
    public List<InformationComment> selectAll() {
        return informationCommentMapper.selectAll();
    }

    // 根据条件查询列表数据
    @Override
    public List<InformationComment> selectList(InformationComment informationComment) {
        return informationCommentMapper.selectList(informationComment);
    }

    // 根据字段、排序方式、limit条 查询列表数据
    @Override
    public List<InformationComment> selectListByLimit(String field, String sort, Integer limit) {
        return informationCommentMapper.selectListByLimit(field, sort, limit);
    }

    // 根据字段查询列表数据
    @Override
    public List<InformationComment> selectListByField(String field, Object value) {
        return informationCommentMapper.selectListByField(field, value);
    }

    // 根据条件查询单个数据
    @Override
    public InformationComment selectOne(InformationComment informationComment) {
        return informationCommentMapper.selectOne(informationComment);
    }

    // 根据ID查询详情数据
    @Override
    public InformationComment selectOneByDetails(Integer id) {
        return informationCommentMapper.selectOneByDetails(id);
    }

    // 查询全部条数
    @Override
    public int selectAllCount() {
        return informationCommentMapper.selectAllCount();
    }

    // 根据条件查询数据条数
    @Override
    public int selectCount(InformationComment informationComment) {
        return informationCommentMapper.selectCount(informationComment);
    }

    // 根据条件修改全部数据
    @Override
    public int updateAll(InformationComment informationComment) {
        return informationCommentMapper.updateAll(informationComment);
    }


}
