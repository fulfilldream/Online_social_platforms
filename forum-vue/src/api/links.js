import request from '@/utils/request'

// 添加
export function addLinks(data) {
  return request({
    url: '/links/add',
    method: 'post',
    data: data
  })
}

// 编辑
export function editLinks(data) {
  return request({
    url: '/links/edit',
    method: 'post',
    data: data
  })
}

// ID查询单个数据
export function getLinks(id) {
  return request({
    url: '/links/info',
    method: 'post',
    params: { id }
  })
}

// 删除
export function delLinks(id) {
  return request({
    url: '/links/delete',
    method: 'post',
    params: { id }
  })
}

// 批量删除
export function delListLinks(idList) {
  return request({
    url: '/links/delete/list',
    method: 'post',
    data: idList
  })
}

// 查询分页数据
export function dataLinks(query) {
  return request({
    url: '/links/data',
    method: 'post',
    params: query
  })
}

// 查询全部数据
export function allLinks() {
  return request({
    url: '/links/all',
    method: 'post',
  })
}

// 条件查询列表数据
export function listLinks(data) {
  return request({
    url: '/links/list',
    method: 'post',
    data: data
  })
}

// 根据字段、排序方式、limit条 查询列表数据
export function listLimitLinks(field, sort, limit) {
  return request({
    url: '/links/list/limit',
    method: 'post',
    params: { field, sort, limit }
  })
}

// 根据字段查询列表数据
export function listFieldLinks(field, value) {
  return request({
    url: '/links/list/field',
    method: 'post',
    params: { field, value }
  })
}

// 动态查询单个数据
export function dynamicGetLinks(data) {
  return request({
    url: '/links/info/dynamic',
    method: 'post',
    data: data
  })
}

// 查看详情数据
export function detailsGetLinks(id) {
  return request({
    url: '/links/details',
    method: 'post',
    params: { id }
  })
}

// 全部条数
export function countLinks() {
  return request({
    url: '/links/count',
    method: 'post',
  })
}

// 条件查询条数
export function dynamicCountLinks(data) {
  return request({
    url: '/links/count/dynamic',
    method: 'post',
    data: data
  })
}
