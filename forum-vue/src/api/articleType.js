import request from '@/utils/request'

// 添加
export function addArticleType(data) {
  return request({
    url: '/articleType/add',
    method: 'post',
    data: data
  })
}

// 编辑
export function editArticleType(data) {
  return request({
    url: '/articleType/edit',
    method: 'post',
    data: data
  })
}

// ID查询单个数据
export function getArticleType(id) {
  return request({
    url: '/articleType/info',
    method: 'post',
    params: { id }
  })
}

// 删除
export function delArticleType(id) {
  return request({
    url: '/articleType/delete',
    method: 'post',
    params: { id }
  })
}

// 批量删除
export function delListArticleType(idList) {
  return request({
    url: '/articleType/delete/list',
    method: 'post',
    data: idList
  })
}

// 查询分页数据
export function dataArticleType(query) {
  return request({
    url: '/articleType/data',
    method: 'post',
    params: query
  })
}

// 查询全部数据
export function allArticleType() {
  return request({
    url: '/articleType/all',
    method: 'post',
  })
}

// 条件查询列表数据
export function listArticleType(data) {
  return request({
    url: '/articleType/list',
    method: 'post',
    data: data
  })
}

// 根据字段、排序方式、limit条 查询列表数据
export function listLimitArticleType(field, sort, limit) {
  return request({
    url: '/articleType/list/limit',
    method: 'post',
    params: { field, sort, limit }
  })
}

// 根据字段查询列表数据
export function listFieldArticleType(field, value) {
  return request({
    url: '/articleType/list/field',
    method: 'post',
    params: { field, value }
  })
}

// 动态查询单个数据
export function dynamicGetArticleType(data) {
  return request({
    url: '/articleType/info/dynamic',
    method: 'post',
    data: data
  })
}

// 查看详情数据
export function detailsGetArticleType(id) {
  return request({
    url: '/articleType/details',
    method: 'post',
    params: { id }
  })
}

// 全部条数
export function countArticleType() {
  return request({
    url: '/articleType/count',
    method: 'post',
  })
}

// 条件查询条数
export function dynamicCountArticleType(data) {
  return request({
    url: '/articleType/count/dynamic',
    method: 'post',
    data: data
  })
}
