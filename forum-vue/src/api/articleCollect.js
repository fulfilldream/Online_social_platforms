import request from '@/utils/request'

// 添加
export function addArticleCollect(data) {
  return request({
    url: '/articleCollect/add',
    method: 'post',
    data: data
  })
}

// 编辑
export function editArticleCollect(data) {
  return request({
    url: '/articleCollect/edit',
    method: 'post',
    data: data
  })
}

// ID查询单个数据
export function getArticleCollect(id) {
  return request({
    url: '/articleCollect/info',
    method: 'post',
    params: { id }
  })
}

// 删除
export function delArticleCollect(id) {
  return request({
    url: '/articleCollect/delete',
    method: 'post',
    params: { id }
  })
}

// 批量删除
export function delListArticleCollect(idList) {
  return request({
    url: '/articleCollect/delete/list',
    method: 'post',
    data: idList
  })
}

// 查询分页数据
export function dataArticleCollect(query) {
  return request({
    url: '/articleCollect/data',
    method: 'post',
    params: query
  })
}

// 查询全部数据
export function allArticleCollect() {
  return request({
    url: '/articleCollect/all',
    method: 'post',
  })
}

// 条件查询列表数据
export function listArticleCollect(data) {
  return request({
    url: '/articleCollect/list',
    method: 'post',
    data: data
  })
}

// 根据字段、排序方式、limit条 查询列表数据
export function listLimitArticleCollect(field, sort, limit) {
  return request({
    url: '/articleCollect/list/limit',
    method: 'post',
    params: { field, sort, limit }
  })
}

// 根据字段查询列表数据
export function listFieldArticleCollect(field, value) {
  return request({
    url: '/articleCollect/list/field',
    method: 'post',
    params: { field, value }
  })
}

// 动态查询单个数据
export function dynamicGetArticleCollect(data) {
  return request({
    url: '/articleCollect/info/dynamic',
    method: 'post',
    data: data
  })
}

// 查看详情数据
export function detailsGetArticleCollect(id) {
  return request({
    url: '/articleCollect/details',
    method: 'post',
    params: { id }
  })
}

// 全部条数
export function countArticleCollect() {
  return request({
    url: '/articleCollect/count',
    method: 'post',
  })
}

// 条件查询条数
export function dynamicCountArticleCollect(data) {
  return request({
    url: '/articleCollect/count/dynamic',
    method: 'post',
    data: data
  })
}
