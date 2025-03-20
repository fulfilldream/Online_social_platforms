import request from '@/utils/request'

// 添加
export function addInformation(data) {
  return request({
    url: '/information/add',
    method: 'post',
    data: data
  })
}

// 编辑
export function editInformation(data) {
  return request({
    url: '/information/edit',
    method: 'post',
    data: data
  })
}

// ID查询单个数据
export function getInformation(id) {
  return request({
    url: '/information/info',
    method: 'post',
    params: { id }
  })
}

// 删除
export function delInformation(id) {
  return request({
    url: '/information/delete',
    method: 'post',
    params: { id }
  })
}

// 批量删除
export function delListInformation(idList) {
  return request({
    url: '/information/delete/list',
    method: 'post',
    data: idList
  })
}

// 查询分页数据
export function dataInformation(query) {
  return request({
    url: '/information/data',
    method: 'post',
    params: query
  })
}

// 查询全部数据
export function allInformation() {
  return request({
    url: '/information/all',
    method: 'post',
  })
}

// 条件查询列表数据
export function listInformation(data) {
  return request({
    url: '/information/list',
    method: 'post',
    data: data
  })
}

// 根据字段、排序方式、limit条 查询列表数据
export function listLimitInformation(field, sort, limit) {
  return request({
    url: '/information/list/limit',
    method: 'post',
    params: { field, sort, limit }
  })
}

// 根据字段查询列表数据
export function listFieldInformation(field, value) {
  return request({
    url: '/information/list/field',
    method: 'post',
    params: { field, value }
  })
}

// 动态查询单个数据
export function dynamicGetInformation(data) {
  return request({
    url: '/information/info/dynamic',
    method: 'post',
    data: data
  })
}

// 查看详情数据
export function detailsGetInformation(id) {
  return request({
    url: '/information/details',
    method: 'post',
    params: { id }
  })
}

// 全部条数
export function countInformation() {
  return request({
    url: '/information/count',
    method: 'post',
  })
}

// 条件查询条数
export function dynamicCountInformation(data) {
  return request({
    url: '/information/count/dynamic',
    method: 'post',
    data: data
  })
}
