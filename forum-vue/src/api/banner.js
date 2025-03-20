import request from '@/utils/request'

// 添加
export function addBanner(data) {
  return request({
    url: '/banner/add',
    method: 'post',
    data: data
  })
}

// 编辑
export function editBanner(data) {
  return request({
    url: '/banner/edit',
    method: 'post',
    data: data
  })
}

// ID查询单个数据
export function getBanner(id) {
  return request({
    url: '/banner/info',
    method: 'post',
    params: { id }
  })
}

// 删除
export function delBanner(id) {
  return request({
    url: '/banner/delete',
    method: 'post',
    params: { id }
  })
}

// 批量删除
export function delListBanner(idList) {
  return request({
    url: '/banner/delete/list',
    method: 'post',
    data: idList
  })
}

// 查询分页数据
export function dataBanner(query) {
  return request({
    url: '/banner/data',
    method: 'post',
    params: query
  })
}

// 查询全部数据
export function allBanner() {
  return request({
    url: '/banner/all',
    method: 'post',
  })
}

// 条件查询列表数据
export function listBanner(data) {
  return request({
    url: '/banner/list',
    method: 'post',
    data: data
  })
}

// 根据字段、排序方式、limit条 查询列表数据
export function listLimitBanner(field, sort, limit) {
  return request({
    url: '/banner/list/limit',
    method: 'post',
    params: { field, sort, limit }
  })
}

// 根据字段查询列表数据
export function listFieldBanner(field, value) {
  return request({
    url: '/banner/list/field',
    method: 'post',
    params: { field, value }
  })
}

// 动态查询单个数据
export function dynamicGetBanner(data) {
  return request({
    url: '/banner/info/dynamic',
    method: 'post',
    data: data
  })
}

// 查看详情数据
export function detailsGetBanner(id) {
  return request({
    url: '/banner/details',
    method: 'post',
    params: { id }
  })
}

// 全部条数
export function countBanner() {
  return request({
    url: '/banner/count',
    method: 'post',
  })
}

// 条件查询条数
export function dynamicCountBanner(data) {
  return request({
    url: '/banner/count/dynamic',
    method: 'post',
    data: data
  })
}
