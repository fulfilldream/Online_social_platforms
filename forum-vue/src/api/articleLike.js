import request from '@/utils/request'

// 添加
export function addArticleLike(data) {
  return request({
    url: '/articleLike/add',
    method: 'post',
    data: data
  })
}

// 编辑
export function editArticleLike(data) {
  return request({
    url: '/articleLike/edit',
    method: 'post',
    data: data
  })
}

// ID查询单个数据
export function getArticleLike(id) {
  return request({
    url: '/articleLike/info',
    method: 'post',
    params: { id }
  })
}

// 删除
export function delArticleLike(id) {
  return request({
    url: '/articleLike/delete',
    method: 'post',
    params: { id }
  })
}

// 批量删除
export function delListArticleLike(idList) {
  return request({
    url: '/articleLike/delete/list',
    method: 'post',
    data: idList
  })
}

// 查询分页数据
export function dataArticleLike(query) {
  return request({
    url: '/articleLike/data',
    method: 'post',
    params: query
  })
}

// 查询全部数据
export function allArticleLike() {
  return request({
    url: '/articleLike/all',
    method: 'post',
  })
}

// 条件查询列表数据
export function listArticleLike(data) {
  return request({
    url: '/articleLike/list',
    method: 'post',
    data: data
  })
}

// 根据字段、排序方式、limit条 查询列表数据
export function listLimitArticleLike(field, sort, limit) {
  return request({
    url: '/articleLike/list/limit',
    method: 'post',
    params: { field, sort, limit }
  })
}

// 根据字段查询列表数据
export function listFieldArticleLike(field, value) {
  return request({
    url: '/articleLike/list/field',
    method: 'post',
    params: { field, value }
  })
}

// 动态查询单个数据
export function dynamicGetArticleLike(data) {
  return request({
    url: '/articleLike/info/dynamic',
    method: 'post',
    data: data
  })
}

// 查看详情数据
export function detailsGetArticleLike(id) {
  return request({
    url: '/articleLike/details',
    method: 'post',
    params: { id }
  })
}

// 全部条数
export function countArticleLike() {
  return request({
    url: '/articleLike/count',
    method: 'post',
  })
}

// 条件查询条数
export function dynamicCountArticleLike(data) {
  return request({
    url: '/articleLike/count/dynamic',
    method: 'post',
    data: data
  })
}
