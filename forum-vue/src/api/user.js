import request from '@/utils/request'

// 注册
export function register(data) {
  return request({
    url: '/register',
    method: 'post',
    data
  })
}

// 登录
export function login(data) {
  return request({
    url: '/login',
    method: 'post',
    data
  })
}

// 退出登录
export function logout() {
  return request({
    url: '/logout',
    method: 'post'
  })
}

// 通过 token 获取信息
export function getInfo(token) {
  return request({
    url: '/user/token',
    method: 'post',
    params: { token }
  })
}

// 添加
export function addUser(data) {
  return request({
    url: '/user/add',
    method: 'post',
    data: data
  })
}

// 编辑
export function editUser(data) {
  return request({
    url: '/user/edit',
    method: 'post',
    data: data
  })
}

// ID查询单个数据
export function getUser(id) {
  return request({
    url: '/user/info',
    method: 'post',
    params: { id }
  })
}

// 删除
export function delUser(id) {
  return request({
    url: '/user/delete',
    method: 'post',
    params: { id }
  })
}

// 批量删除
export function delListUser(idList) {
  return request({
    url: '/user/delete/list',
    method: 'post',
    data: idList
  })
}

// 查询分页数据
export function dataUser(query) {
  return request({
    url: '/user/data',
    method: 'post',
    params: query
  })
}

// 查询全部数据
export function allUser() {
  return request({
    url: '/user/all',
    method: 'post',
  })
}

// 条件查询列表数据
export function listUser(data) {
  return request({
    url: '/user/list',
    method: 'post',
    data: data
  })
}

// 根据字段、排序方式、limit条 查询列表数据
export function listLimitUser(field, sort, limit) {
  return request({
    url: '/user/list/limit',
    method: 'post',
    params: { field, sort, limit }
  })
}

// 根据字段查询列表数据
export function listFieldUser(field, value) {
  return request({
    url: '/user/list/field',
    method: 'post',
    params: { field, value }
  })
}

// 动态查询单个数据
export function dynamicGetUser(data) {
  return request({
    url: '/user/info/dynamic',
    method: 'post',
    data: data
  })
}

// 查看详情数据
export function detailsGetUser(id) {
  return request({
    url: '/user/details',
    method: 'post',
    params: { id }
  })
}

// 全部条数
export function countUser() {
  return request({
    url: '/user/count',
    method: 'post',
  })
}

// 条件查询条数
export function dynamicCountUser(data) {
  return request({
    url: '/user/count/dynamic',
    method: 'post',
    data: data
  })
}
