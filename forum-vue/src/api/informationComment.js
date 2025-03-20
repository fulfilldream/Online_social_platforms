import request from '@/utils/request'

// 添加
export function addInformationComment(data) {
  return request({
    url: '/informationComment/add',
    method: 'post',
    data: data
  })
}

// 编辑
export function editInformationComment(data) {
  return request({
    url: '/informationComment/edit',
    method: 'post',
    data: data
  })
}

// ID查询单个数据
export function getInformationComment(id) {
  return request({
    url: '/informationComment/info',
    method: 'post',
    params: { id }
  })
}

// 删除
export function delInformationComment(id) {
  return request({
    url: '/informationComment/delete',
    method: 'post',
    params: { id }
  })
}

// 批量删除
export function delListInformationComment(idList) {
  return request({
    url: '/informationComment/delete/list',
    method: 'post',
    data: idList
  })
}

// 查询分页数据
export function dataInformationComment(query) {
  return request({
    url: '/informationComment/data',
    method: 'post',
    params: query
  })
}

// 查询全部数据
export function allInformationComment() {
  return request({
    url: '/informationComment/all',
    method: 'post',
  })
}

// 条件查询列表数据
export function listInformationComment(data) {
  return request({
    url: '/informationComment/list',
    method: 'post',
    data: data
  })
}

// 根据字段、排序方式、limit条 查询列表数据
export function listLimitInformationComment(field, sort, limit) {
  return request({
    url: '/informationComment/list/limit',
    method: 'post',
    params: { field, sort, limit }
  })
}

// 根据字段查询列表数据
export function listFieldInformationComment(field, value) {
  return request({
    url: '/informationComment/list/field',
    method: 'post',
    params: { field, value }
  })
}

// 动态查询单个数据
export function dynamicGetInformationComment(data) {
  return request({
    url: '/informationComment/info/dynamic',
    method: 'post',
    data: data
  })
}

// 查看详情数据
export function detailsGetInformationComment(id) {
  return request({
    url: '/informationComment/details',
    method: 'post',
    params: { id }
  })
}

// 全部条数
export function countInformationComment() {
  return request({
    url: '/informationComment/count',
    method: 'post',
  })
}

// 条件查询条数
export function dynamicCountInformationComment(data) {
  return request({
    url: '/informationComment/count/dynamic',
    method: 'post',
    data: data
  })
}
