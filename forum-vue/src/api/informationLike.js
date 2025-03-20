import request from '@/utils/request'

// 添加
export function addInformationLike(data) {
  return request({
    url: '/informationLike/add',
    method: 'post',
    data: data
  })
}

// 编辑
export function editInformationLike(data) {
  return request({
    url: '/informationLike/edit',
    method: 'post',
    data: data
  })
}

// ID查询单个数据
export function getInformationLike(id) {
  return request({
    url: '/informationLike/info',
    method: 'post',
    params: { id }
  })
}

// 删除
export function delInformationLike(id) {
  return request({
    url: '/informationLike/delete',
    method: 'post',
    params: { id }
  })
}

// 批量删除
export function delListInformationLike(idList) {
  return request({
    url: '/informationLike/delete/list',
    method: 'post',
    data: idList
  })
}

// 查询分页数据
export function dataInformationLike(query) {
  return request({
    url: '/informationLike/data',
    method: 'post',
    params: query
  })
}

// 查询全部数据
export function allInformationLike() {
  return request({
    url: '/informationLike/all',
    method: 'post',
  })
}

// 条件查询列表数据
export function listInformationLike(data) {
  return request({
    url: '/informationLike/list',
    method: 'post',
    data: data
  })
}

// 根据字段、排序方式、limit条 查询列表数据
export function listLimitInformationLike(field, sort, limit) {
  return request({
    url: '/informationLike/list/limit',
    method: 'post',
    params: { field, sort, limit }
  })
}

// 根据字段查询列表数据
export function listFieldInformationLike(field, value) {
  return request({
    url: '/informationLike/list/field',
    method: 'post',
    params: { field, value }
  })
}

// 动态查询单个数据
export function dynamicGetInformationLike(data) {
  return request({
    url: '/informationLike/info/dynamic',
    method: 'post',
    data: data
  })
}

// 查看详情数据
export function detailsGetInformationLike(id) {
  return request({
    url: '/informationLike/details',
    method: 'post',
    params: { id }
  })
}

// 全部条数
export function countInformationLike() {
  return request({
    url: '/informationLike/count',
    method: 'post',
  })
}

// 条件查询条数
export function dynamicCountInformationLike(data) {
  return request({
    url: '/informationLike/count/dynamic',
    method: 'post',
    data: data
  })
}
