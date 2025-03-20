import request from '@/utils/request'

// 关注功能API -js

// 添加
export function addFollow(data) {
  return request({
    url: '/follow/add',
    method: 'post',
    data: data
  })
}

// 编辑
export function editFollow(data) {
  return request({
    url: '/follow/edit',
    method: 'post',
    data: data
  })
}

// ID查询单个数据
export function getFollow(id) {
  return request({
    url: '/follow/info',
    method: 'post',
    params: { id }
  })
}

// 删除
export function delFollow(id) {
  return request({
    url: '/follow/delete',
    method: 'post',
    params: { id }
  })
}

// 批量删除
export function delListFollow(idList) {
  return request({
    url: '/follow/delete/list',
    method: 'post',
    data: idList
  })
}

// 查询分页数据
export function dataFollow(query) {
  return request({
    url: '/follow/data',
    method: 'post',
    params: query
  })
}

// 查询全部数据
export function allFollow() {
  return request({
    url: '/follow/all',
    method: 'post',
  })
}

// 条件查询列表数据
export function listFollow(data) {
  return request({
    url: '/follow/list',
    method: 'post',
    data: data
  })
}

// 根据字段、排序方式、limit条 查询列表数据
export function listLimitFollow(field, sort, limit) {
  return request({
    url: '/follow/list/limit',
    method: 'post',
    params: { field, sort, limit }
  })
}

// 根据字段查询列表数据
export function listFieldFollow(field, value) {
  return request({
    url: '/follow/list/field',
    method: 'post',
    params: { field, value }
  })
}

// 动态查询单个数据
export function dynamicGetFollow(data) {
  return request({
    url: '/follow/info/dynamic',
    method: 'post',
    data: data
  })
}

// 查看详情数据
export function detailsGetFollow(id) {
  return request({
    url: '/follow/details',
    method: 'post',
    params: { id }
  })
}

// 全部条数
export function countFollow() {
  return request({
    url: '/follow/count',
    method: 'post',
  })
}

// 条件查询条数
export function dynamicCountFollow(data) {
  return request({
    url: '/follow/count/dynamic',
    method: 'post',
    data: data
  })
}
