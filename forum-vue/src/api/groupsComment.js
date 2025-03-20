import request from '@/utils/request'

// 添加
export function addGroupsComment(data) {
  return request({
    url: '/groupsComment/add',
    method: 'post',
    data: data
  })
}

// 编辑
export function editGroupsComment(data) {
  return request({
    url: '/groupsComment/edit',
    method: 'post',
    data: data
  })
}

// ID查询单个数据
export function getGroupsComment(id) {
  return request({
    url: '/groupsComment/info',
    method: 'post',
    params: { id }
  })
}

// 删除
export function delGroupsComment(id) {
  return request({
    url: '/groupsComment/delete',
    method: 'post',
    params: { id }
  })
}

// 批量删除
export function delListGroupsComment(idList) {
  return request({
    url: '/groupsComment/delete/list',
    method: 'post',
    data: idList
  })
}

// 查询分页数据
export function dataGroupsComment(query) {
  return request({
    url: '/groupsComment/data',
    method: 'post',
    params: query
  })
}

// 查询全部数据
export function allGroupsComment() {
  return request({
    url: '/groupsComment/all',
    method: 'post',
  })
}

// 条件查询列表数据
export function listGroupsComment(data) {
  return request({
    url: '/groupsComment/list',
    method: 'post',
    data: data
  })
}

// 根据字段、排序方式、limit条 查询列表数据
export function listLimitGroupsComment(field, sort, limit) {
  return request({
    url: '/groupsComment/list/limit',
    method: 'post',
    params: { field, sort, limit }
  })
}

// 根据字段查询列表数据
export function listFieldGroupsComment(field, value) {
  return request({
    url: '/groupsComment/list/field',
    method: 'post',
    params: { field, value }
  })
}

// 动态查询单个数据
export function dynamicGetGroupsComment(data) {
  return request({
    url: '/groupsComment/info/dynamic',
    method: 'post',
    data: data
  })
}

// 查看详情数据
export function detailsGetGroupsComment(id) {
  return request({
    url: '/groupsComment/details',
    method: 'post',
    params: { id }
  })
}

// 全部条数
export function countGroupsComment() {
  return request({
    url: '/groupsComment/count',
    method: 'post',
  })
}

// 条件查询条数
export function dynamicCountGroupsComment(data) {
  return request({
    url: '/groupsComment/count/dynamic',
    method: 'post',
    data: data
  })
}
