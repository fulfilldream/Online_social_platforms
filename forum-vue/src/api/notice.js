import request from '@/utils/request'

// 添加
export function addNotice(data) {
  return request({
    url: '/notice/add',
    method: 'post',
    data: data
  })
}

// 编辑
export function editNotice(data) {
  return request({
    url: '/notice/edit',
    method: 'post',
    data: data
  })
}

// ID查询单个数据
export function getNotice(id) {
  return request({
    url: '/notice/info',
    method: 'post',
    params: { id }
  })
}

// 删除
export function delNotice(id) {
  return request({
    url: '/notice/delete',
    method: 'post',
    params: { id }
  })
}

// 批量删除
export function delListNotice(idList) {
  return request({
    url: '/notice/delete/list',
    method: 'post',
    data: idList
  })
}

// 查询分页数据
export function dataNotice(query) {
  return request({
    url: '/notice/data',
    method: 'post',
    params: query
  })
}

// 查询全部数据
export function allNotice() {
  return request({
    url: '/notice/all',
    method: 'post',
  })
}

// 条件查询列表数据
export function listNotice(data) {
  return request({
    url: '/notice/list',
    method: 'post',
    data: data
  })
}

// 根据字段、排序方式、limit条 查询列表数据
export function listLimitNotice(field, sort, limit) {
  return request({
    url: '/notice/list/limit',
    method: 'post',
    params: { field, sort, limit }
  })
}

// 根据字段查询列表数据
export function listFieldNotice(field, value) {
  return request({
    url: '/notice/list/field',
    method: 'post',
    params: { field, value }
  })
}

// 动态查询单个数据
export function dynamicGetNotice(data) {
  return request({
    url: '/notice/info/dynamic',
    method: 'post',
    data: data
  })
}

// 查看详情数据
export function detailsGetNotice(id) {
  return request({
    url: '/notice/details',
    method: 'post',
    params: { id }
  })
}

// 全部条数
export function countNotice() {
  return request({
    url: '/notice/count',
    method: 'post',
  })
}

// 条件查询条数
export function dynamicCountNotice(data) {
  return request({
    url: '/notice/count/dynamic',
    method: 'post',
    data: data
  })
}
