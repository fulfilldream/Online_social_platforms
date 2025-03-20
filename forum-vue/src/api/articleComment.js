import request from '@/utils/request'

// 添加
export function addArticleComment(data) {
  return request({
    url: '/articleComment/add',
    method: 'post',
    data: data
  })
}

// 编辑
export function editArticleComment(data) {
  return request({
    url: '/articleComment/edit',
    method: 'post',
    data: data
  })
}

// ID查询单个数据
export function getArticleComment(id) {
  return request({
    url: '/articleComment/info',
    method: 'post',
    params: { id }
  })
}

// 删除
export function delArticleComment(id) {
  return request({
    url: '/articleComment/delete',
    method: 'post',
    params: { id }
  })
}

// 批量删除
export function delListArticleComment(idList) {
  return request({
    url: '/articleComment/delete/list',
    method: 'post',
    data: idList
  })
}

// 查询分页数据
export function dataArticleComment(query) {
  return request({
    url: '/articleComment/data',
    method: 'post',
    params: query
  })
}

// 查询全部数据
export function allArticleComment() {
  return request({
    url: '/articleComment/all',
    method: 'post',
  })
}

// 条件查询列表数据
export function listArticleComment(data) {
  return request({
    url: '/articleComment/list',
    method: 'post',
    data: data
  })
}

// 根据字段、排序方式、limit条 查询列表数据
export function listLimitArticleComment(field, sort, limit) {
  return request({
    url: '/articleComment/list/limit',
    method: 'post',
    params: { field, sort, limit }
  })
}

// 根据字段查询列表数据
export function listFieldArticleComment(field, value) {
  return request({
    url: '/articleComment/list/field',
    method: 'post',
    params: { field, value }
  })
}

// 动态查询单个数据
export function dynamicGetArticleComment(data) {
  return request({
    url: '/articleComment/info/dynamic',
    method: 'post',
    data: data
  })
}

// 查看详情数据
export function detailsGetArticleComment(id) {
  return request({
    url: '/articleComment/details',
    method: 'post',
    params: { id }
  })
}

// 全部条数
export function countArticleComment() {
  return request({
    url: '/articleComment/count',
    method: 'post',
  })
}

// 条件查询条数
export function dynamicCountArticleComment(data) {
  return request({
    url: '/articleComment/count/dynamic',
    method: 'post',
    data: data
  })
}
