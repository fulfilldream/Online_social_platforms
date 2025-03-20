import request from '@/utils/request'

// 添加
export function addArticle(data) {
  return request({
    url: '/article/add',
    method: 'post',
    data: data
  })
}

// 编辑
export function editArticle(data) {
  return request({
    url: '/article/edit',
    method: 'post',
    data: data
  })
}

// ID查询单个数据
export function getArticle(id) {
  return request({
    url: '/article/info',
    method: 'post',
    params: { id }
  })
}

// 删除
export function delArticle(id) {
  return request({
    url: '/article/delete',
    method: 'post',
    params: { id }
  })
}

// 批量删除
export function delListArticle(idList) {
  return request({
    url: '/article/delete/list',
    method: 'post',
    data: idList
  })
}

// 查询分页数据
export function dataArticle(query) {
  return request({
    url: '/article/data',
    method: 'post',
    params: query
  })
}

// 查询全部数据
export function allArticle() {
  return request({
    url: '/article/all',
    method: 'post',
  })
}

// 条件查询列表数据
export function listArticle(data) {
  return request({
    url: '/article/list',
    method: 'post',
    data: data
  })
}

// 根据字段、排序方式、limit条 查询列表数据
export function listLimitArticle(field, sort, limit) {
  return request({
    url: '/article/list/limit',
    method: 'post',
    params: { field, sort, limit }
  })
}

// 根据字段查询列表数据
export function listFieldArticle(field, value) {
  return request({
    url: '/article/list/field',
    method: 'post',
    params: { field, value }
  })
}

// 动态查询单个数据
export function dynamicGetArticle(data) {
  return request({
    url: '/article/info/dynamic',
    method: 'post',
    data: data
  })
}

// 查看详情数据
export function detailsGetArticle(id) {
  return request({
    url: '/article/details',
    method: 'post',
    params: { id }
  })
}

// 全部条数
export function countArticle() {
  return request({
    url: '/article/count',
    method: 'post',
  })
}

// 条件查询条数
export function dynamicCountArticle(data) {
  return request({
    url: '/article/count/dynamic',
    method: 'post',
    data: data
  })
}

export function statisticsArticleGroups() {
  return request({
    url: '/article/statistics/groups',
    method: 'post',
  })
}

export function statisticsArticleType() {
  return request({
    url: '/article/statistics/type',
    method: 'post',
  })
}
