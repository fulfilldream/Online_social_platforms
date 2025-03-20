import request from '@/utils/request'

// 添加
export function addLeaves(data) {
  return request({
    url: '/leaves/add',
    method: 'post',
    data: data
  })
}

// 编辑
export function editLeaves(data) {
  return request({
    url: '/leaves/edit',
    method: 'post',
    data: data
  })
}

// ID查询单个数据
export function getLeaves(id) {
  return request({
    url: '/leaves/info',
    method: 'post',
    params: { id }
  })
}

// 删除
export function delLeaves(id) {
  return request({
    url: '/leaves/delete',
    method: 'post',
    params: { id }
  })
}

// 批量删除
export function delListLeaves(idList) {
  return request({
    url: '/leaves/delete/list',
    method: 'post',
    data: idList
  })
}

// 查询分页数据
export function dataLeaves(query) {
  return request({
    url: '/leaves/data',
    method: 'post',
    params: query
  })
}

// 查询全部数据
export function allLeaves() {
  return request({
    url: '/leaves/all',
    method: 'post',
  })
}

// 条件查询列表数据
export function listLeaves(data) {
  return request({
    url: '/leaves/list',
    method: 'post',
    data: data
  })
}

// 根据字段、排序方式、limit条 查询列表数据
export function listLimitLeaves(field, sort, limit) {
  return request({
    url: '/leaves/list/limit',
    method: 'post',
    params: { field, sort, limit }
  })
}

// 根据字段查询列表数据
export function listFieldLeaves(field, value) {
  return request({
    url: '/leaves/list/field',
    method: 'post',
    params: { field, value }
  })
}

// 动态查询单个数据
export function dynamicGetLeaves(data) {
  return request({
    url: '/leaves/info/dynamic',
    method: 'post',
    data: data
  })
}

// 查看详情数据
export function detailsGetLeaves(id) {
  return request({
    url: '/leaves/details',
    method: 'post',
    params: { id }
  })
}

// 全部条数
export function countLeaves() {
  return request({
    url: '/leaves/count',
    method: 'post',
  })
}

// 条件查询条数
export function dynamicCountLeaves(data) {
  return request({
    url: '/leaves/count/dynamic',
    method: 'post',
    data: data
  })
}
