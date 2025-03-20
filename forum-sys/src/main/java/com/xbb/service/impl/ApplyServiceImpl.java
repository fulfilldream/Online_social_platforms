package com.xbb.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import com.xbb.mapper.ApplyMapper;
import com.xbb.entity.Apply;
import com.xbb.service.ApplyService;
import org.springframework.stereotype.Service;

@Service
public class ApplyServiceImpl implements ApplyService {

    @Resource
    private ApplyMapper applyMapper;

    // 删除数据
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return applyMapper.deleteByPrimaryKey(id);
    }

    // 插入数据
    @Override
    public int insert(Apply apply) {
        return applyMapper.insert(apply);
    }

    // 插入数据
    @Override
    public int insertSelective(Apply apply) {
        return applyMapper.insertSelective(apply);
    }

    // 根据ID查询单个数据
    @Override
    public Apply selectByPrimaryKey(Integer id) {
        return applyMapper.selectByPrimaryKey(id);
    }

    // 修改数据
    @Override
    public int updateByPrimaryKeySelective(Apply apply) {
        return applyMapper.updateByPrimaryKeySelective(apply);
    }

    // 修改数据
    @Override
    public int updateByPrimaryKey(Apply apply) {
        return applyMapper.updateByPrimaryKey(apply);
    }

    // 根据条件查询分页数据
    @Override
    public List<Apply> selectListByPaging(Integer page, Integer limit,Integer userId, Integer groupsId, String name) {
        return applyMapper.selectListByPaging(
            (page - 1) * limit,
            limit,
            userId,
            groupsId,
                name
        );
    }

    // 根据条件查询数据条数
    @Override
    public int selectCountByPaging(Integer userId, Integer groupsId, String name) {
        return applyMapper.selectCountByPaging(
            userId,
            groupsId,
                name
        );
    }

    // 查询全部数据
    @Override
    public List<Apply> selectAll() {
        return applyMapper.selectAll();
    }

    // 根据条件查询列表数据
    @Override
    public List<Apply> selectList(Apply apply) {
        return applyMapper.selectList(apply);
    }

    // 根据字段、排序方式、limit条 查询列表数据
    @Override
    public List<Apply> selectListByLimit(String field, String sort, Integer limit) {
        return applyMapper.selectListByLimit(field, sort, limit);
    }

    // 根据字段查询列表数据
    @Override
    public List<Apply> selectListByField(String field, Object value) {
        return applyMapper.selectListByField(field, value);
    }

    // 根据条件查询单个数据
    @Override
    public Apply selectOne(Apply apply) {
        return applyMapper.selectOne(apply);
    }

    // 根据ID查询详情数据
    @Override
    public Apply selectOneByDetails(Integer id) {
        return applyMapper.selectOneByDetails(id);
    }

    // 查询全部条数
    @Override
    public int selectAllCount() {
        return applyMapper.selectAllCount();
    }

    // 根据条件查询数据条数
    @Override
    public int selectCount(Apply apply) {
        return applyMapper.selectCount(apply);
    }

    // 根据条件修改全部数据
    @Override
    public int updateAll(Apply apply) {
        return applyMapper.updateAll(apply);
    }


}
