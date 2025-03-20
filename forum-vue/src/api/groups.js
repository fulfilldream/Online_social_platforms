import request from '@/utils/request'

// 添加
export function addGroups(data) {
  return request({
    url: '/groups/add',
    method: 'post',
    data: data
  })
}

// 编辑
export function editGroups(data) {
  return request({
    url: '/groups/edit',
    method: 'post',
    data: data
  })
}

// ID查询单个数据
export function getGroups(id) {
  return request({
    url: '/groups/info',
    method: 'post',
    params: { id }
  })
}

// 删除
export function delGroups(id) {
  return request({
    url: '/groups/delete',
    method: 'post',
    params: { id }
  })
}

// 批量删除
export function delListGroups(idList) {
  return request({
    url: '/groups/delete/list',
    method: 'post',
    data: idList
  })
}

// 查询分页数据
export function dataGroups(query) {
  return request({
    url: '/groups/data',
    method: 'post',
    params: query
  })
}

// 查询全部数据
export function allGroups() {
  return request({
    url: '/groups/all',
    method: 'post',
  })
}

// 条件查询列表数据
export function listGroups(data) {
  return request({
    url: '/groups/list',
    method: 'post',
    data: data
  })
}

// 根据字段、排序方式、limit条 查询列表数据
export function listLimitGroups(field, sort, limit) {
  return request({
    url: '/groups/list/limit',
    method: 'post',
    params: { field, sort, limit }
  })
}

// 根据字段查询列表数据
export function listFieldGroups(field, value) {
  return request({
    url: '/groups/list/field',
    method: 'post',
    params: { field, value }
  })
}

// 动态查询单个数据
export function dynamicGetGroups(data) {
  return request({
    url: '/groups/info/dynamic',
    method: 'post',
    data: data
  })
}

// 查看详情数据
export function detailsGetGroups(id) {
  return request({
    url: '/groups/details',
    method: 'post',
    params: { id }
  })
}

// 全部条数
export function countGroups() {
  return request({
    url: '/groups/count',
    method: 'post',
  })
}

// 条件查询条数
export function dynamicCountGroups(data) {
  return request({
    url: '/groups/count/dynamic',
    method: 'post',
    data: data
  })
}

export function userGroups(userId) {
  return request({
    url: '/groups/user',
    method: 'post',
    params: { userId }
  })
}

