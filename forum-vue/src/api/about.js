import request from '@/utils/request'

// 添加
export function addAbout(data) {
  return request({
    url: '/about/add',
    method: 'post',
    data: data
  })
}

// 编辑
export function editAbout(data) {
  return request({
    url: '/about/edit',
    method: 'post',
    data: data
  })
}

// 设置
export function setAbout(data) {
  return request({
    url: '/about/set',
    method: 'post',
    data: data
  })
}

// ID查询单个数据
export function getAbout(id) {
  return request({
    url: '/about/info',
    method: 'post',
    params: { id }
  })
}

// 删除
export function delAbout(id) {
  return request({
    url: '/about/delete',
    method: 'post',
    params: { id }
  })
}

// 批量删除
export function delListAbout(idList) {
  return request({
    url: '/about/delete/list',
    method: 'post',
    data: idList
  })
}

// 查询分页数据
export function dataAbout(query) {
  return request({
    url: '/about/data',
    method: 'post',
    params: query
  })
}

// 查询全部数据
export function allAbout() {
  return request({
    url: '/about/all',
    method: 'post',
  })
}

// 条件查询列表数据
export function listAbout(data) {
  return request({
    url: '/about/list',
    method: 'post',
    data: data
  })
}

// 根据字段、排序方式、limit条 查询列表数据
export function listLimitAbout(field, sort, limit) {
  return request({
    url: '/about/list/limit',
    method: 'post',
    params: { field, sort, limit }
  })
}

// 根据字段查询列表数据
export function listFieldAbout(field, value) {
  return request({
    url: '/about/list/field',
    method: 'post',
    params: { field, value }
  })
}

// 动态查询单个数据
export function dynamicGetAbout(data) {
  return request({
    url: '/about/info/dynamic',
    method: 'post',
    data: data
  })
}

// 查看详情数据
export function detailsGetAbout(id) {
  return request({
    url: '/about/details',
    method: 'post',
    params: { id }
  })
}

// 全部条数
export function countAbout() {
  return request({
    url: '/about/count',
    method: 'post',
  })
}

// 条件查询条数
export function dynamicCountAbout(data) {
  return request({
    url: '/about/count/dynamic',
    method: 'post',
    data: data
  })
}
