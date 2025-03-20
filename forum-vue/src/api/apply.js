import request from '@/utils/request'

// 添加
export function addApply(data) {
  return request({
    url: '/apply/add',
    method: 'post',
    data: data
  })
}

// 编辑
export function editApply(data) {
  return request({
    url: '/apply/edit',
    method: 'post',
    data: data
  })
}

// ID查询单个数据
export function getApply(id) {
  return request({
    url: '/apply/info',
    method: 'post',
    params: { id }
  })
}

// 删除
export function delApply(id) {
  return request({
    url: '/apply/delete',
    method: 'post',
    params: { id }
  })
}

// 批量删除
export function delListApply(idList) {
  return request({
    url: '/apply/delete/list',
    method: 'post',
    data: idList
  })
}

// 查询分页数据
export function dataApply(query) {
  return request({
    url: '/apply/data',
    method: 'post',
    params: query
  })
}

// 查询全部数据
export function allApply() {
  return request({
    url: '/apply/all',
    method: 'post',
  })
}

// 条件查询列表数据
export function listApply(data) {
  return request({
    url: '/apply/list',
    method: 'post',
    data: data
  })
}

// 根据字段、排序方式、limit条 查询列表数据
export function listLimitApply(field, sort, limit) {
  return request({
    url: '/apply/list/limit',
    method: 'post',
    params: { field, sort, limit }
  })
}

// 根据字段查询列表数据
export function listFieldApply(field, value) {
  return request({
    url: '/apply/list/field',
    method: 'post',
    params: { field, value }
  })
}

// 动态查询单个数据
export function dynamicGetApply(data) {
  return request({
    url: '/apply/info/dynamic',
    method: 'post',
    data: data
  })
}

// 查看详情数据
export function detailsGetApply(id) {
  return request({
    url: '/apply/details',
    method: 'post',
    params: { id }
  })
}

// 全部条数
export function countApply() {
  return request({
    url: '/apply/count',
    method: 'post',
  })
}

// 条件查询条数
export function dynamicCountApply(data) {
  return request({
    url: '/apply/count/dynamic',
    method: 'post',
    data: data
  })
}
