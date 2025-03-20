import router from './router'
import store from './store'
import { Message } from 'element-ui'
import NProgress from 'nprogress' // progress bar
import 'nprogress/nprogress.css' // progress bar style
import { getToken } from '@/utils/auth' // get token from cookie
import getPageTitle from '@/utils/get-page-title'

NProgress.configure({ showSpinner: false }) // NProgress Configuration

const whiteList = ['/login', '/register'] // 拦截器：白名单

// 导航守卫
router.beforeEach(async (to, from, next) => {
  // 启动加载图标
  NProgress.start()

  // 浏览器选项卡标签名
  document.title = getPageTitle(to.meta.title)

  // 获取token
  const hasToken = getToken()

  if (hasToken) {
    if (to.path === '/login') {
      next({ path: '/' })
      NProgress.done() // 加载图标
    } else {
      const hasGetUserInfo = store.getters.name
      if (hasGetUserInfo) {
        next()
      } else {
        try {
          // 获取用户信息
          await store.dispatch('user/getInfo')

          // 获取角色权限信息
          const roles = []
          roles.push(String(store.getters.role))

          // 通过角色获取路由
          const accessRoutes = await store.dispatch('permission/generateRoutes', roles)

          // 添加到路由
          router.addRoutes(accessRoutes)

          next({ ...to, replace: true })
          // next()
        } catch (error) {
          // remove token and go to login page to re-login
          await store.dispatch('user/resetToken')
          Message.error(error || 'Has Error')
          next(`/login?redirect=${to.path}`)
          NProgress.done()
        }
      }
    }
  } else {
    // 判断路径是否在白名单中
    if (whiteList.indexOf(to.path) !== -1) {
      // 白名单放行
      next()
    } else {
      // 不是白名单拦截到登录页，登录后重定向到上一次路径页面
      next(`/login?redirect=${to.path}`)
      NProgress.done()
    }
  }
})

router.afterEach(() => {
  // finish progress bar
  NProgress.done()
})
