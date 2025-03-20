import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

import Layout from '@/layout'

// 用户路由
export const userAsyncRoutes = [
  {
    path: '/',
    name: 'index',
    title: '首页',
    component: () => import('@/views/user/index'),
    hidden: true
  },
  {
    path: '/groups-list',
    name: 'groups-list',
    title: '小组列表',
    component: () => import('@/views/user/groups/index'),
    hidden: true
  },
  {
    path: '/groups-add',
    name: 'groups-add',
    title: '添加小组',
    component: () => import('@/views/user/groups/add'),
    hidden: true
  },
  {
    path: '/groups-edit/:id(\\d+)',
    name: 'groups-edit',
    title: '编辑小组',
    component: () => import('@/views/user/groups/edit'),
    hidden: true
  },
  {
    path: '/groups-details/:id(\\d+)',
    name: 'groups-details',
    title: '小组详情',
    component: () => import('@/views/user/groups/details'),
    hidden: true
  },
  {
    path: '/article-list',
    name: 'article-list',
    title: '文章列表',
    component: () => import('@/views/user/article/index'),
    hidden: true
  },
  {
    path: '/article-category/:id(\\d+)',
    name: 'article-category',
    component: () => import('@/views/user/article/category'),
    title: '文章分类',
    hidden: true
  },
  {
    path: '/article-groups/:id(\\d+)',
    name: 'article-groups',
    component: () => import('@/views/user/article/groups'),
    title: '文章小组',
    hidden: true
  },
  {
    path: '/article-search/:title',
    name: 'article-search',
    component: () => import('@/views/user/article/search'),
    title: '文章搜索',
    hidden: true
  },
  {
    path: '/article-user/:id(\\d+)',
    name: 'article-user',
    component: () => import('@/views/user/article/user'),
    title: '文章用户',
    hidden: true
  },
  {
    path: '/article-add',
    name: 'article-add',
    title: '添加文章',
    component: () => import('@/views/user/article/add'),
    hidden: true
  },
  {
    path: '/article-edit/:id(\\d+)',
    name: 'article-edit',
    title: '编辑文章',
    component: () => import('@/views/user/article/edit'),
    hidden: true
  },
  {
    path: '/article-details/:id(\\d+)',
    name: 'article-details',
    title: '文章详情',
    component: () => import('@/views/user/article/details'),
    hidden: true
  },
  {
    path: '/information-list',
    name: 'information-list',
    title: '动态列表',
    component: () => import('@/views/user/information/index'),
    hidden: true
  },
  {
    path: '/information-user/:id(\\d+)',
    name: 'information-user',
    title: '动态用户',
    component: () => import('@/views/user/information/user'),
    hidden: true
  },
  {
    path: '/information-add',
    name: 'information-add',
    title: '添加动态',
    component: () => import('@/views/user/information/add'),
    hidden: true
  },
  {
    path: '/information-edit/:id(\\d+)',
    name: 'information-edit',
    title: '编辑动态',
    component: () => import('@/views/user/information/edit'),
    hidden: true
  },
  {
    path: '/information-details/:id(\\d+)',
    name: 'information-details',
    title: '动态详情',
    component: () => import('@/views/user/information/details'),
    hidden: true
  },
  {
    path: '/notice-list',
    name: 'notice-list',
    title: '公告列表',
    component: () => import('@/views/user/notice/index'),
    hidden: true
  },
  {
    path: '/notice-details/:id(\\d+)',
    name: 'notice-details',
    title: '公告详情',
    component: () => import('@/views/user/notice/details'),
    hidden: true
  },
  {
    path: '/about-list',
    name: 'about-list',
    title: '关于我们',
    component: () => import('@/views/user/about/index'),
    hidden: true
  },
  {
    path: '/personal',
    name: 'personal',
    title: '个人资料',
    component: () => import('@/views/user/personal/index'),
    hidden: true
  },
  {
    path: '/password',
    name: 'password',
    title: '重置密码',
    component: () => import('@/views/user/password/index'),
    hidden: true
  },
  {
    path: '/groups',
    name: 'groups',
    title: '我的小组',
    component: () => import('@/views/user/groups/manage'),
    hidden: true
  },
  {
    path: '/apply',
    name: 'apply',
    title: '我的加入',
    component: () => import('@/views/user/apply/manage'),
    hidden: true
  },
  {
    path: '/article',
    name: 'article',
    title: '我的文章',
    component: () => import('@/views/user/article/manage'),
    hidden: true
  },
  {
    path: '/information',
    name: 'information',
    title: '我的动态',
    component: () => import('@/views/user/information/manage'),
    hidden: true
  },
  {
    path: '/articleCollect',
    name: 'articleCollect',
    title: '我的收藏',
    component: () => import('@/views/user/articleCollect/manage'),
    hidden: true
  },
  {
    path: '/follow',
    name: 'follow',
    title: '我的关注',
    component: () => import('@/views/user/follow/manage'),
    hidden: true
  },
  {
    path: '/leaves',
    name: 'leaves',
    title: '我的私信',
    component: () => import('@/views/user/leaves/manage'),
    hidden: true
  },
  {
    path: '/reply',
    name: 'reply',
    title: '私信回复',
    component: () => import('@/views/user/leaves/reply'),
    hidden: true
  },
  // 404 page must be placed at the end !!!
  { path: '*', redirect: '/home', hidden: true }
]

export const staffAsyncRoutes = []

// 管理员路由
export const sysAsyncRoutes = [
  {
    path: '/',
    component: Layout,
    redirect: '/home',
    children: [{
      path: 'home',
      name: 'Home',
      component: () => import('@/views/sys/home/index'),
      meta: { title: '首页', icon: 'el-icon-s-home', affix: true }
    }]
  },
  {
    path: '/sys-personal',
    component: Layout,
    meta: { title: '个人信息', icon: 'el-icon-setting' },
    hidden: true,
    children: [
      {
        path: 'personal',
        name: 'personal',
        component: () => import('@/views/sys/personal/index'),
        meta: { title: '个人资料',  }
      },
      {
        path: 'password',
        name: 'password',
        component: () => import('@/views/sys/password/index'),
        meta: { title: '重置密码',  }
      }
    ]
  },
  {
    path: '/sys-user',
    component: Layout,
    meta: { title: '用户管理', icon: 'el-icon-user', roles: ['5'] },
    children: [
      {
        path: 'user',
        name: 'user',
        component: () => import('@/views/sys/user/index'),
        meta: { title: '用户管理',  }
      },
      {
        path: 'admin',
        name: 'admin',
        component: () => import('@/views/sys/admin/index'),
        meta: { title: '管理员管理',  }
      }
    ]
  },
  {
    path: '/sys-basics',
    component: Layout,
    meta: { title: '基础管理', icon: 'el-icon-notebook-2', roles: ['5'] },
    children: [
      {
        path: 'banner',
        name: 'banner',
        component: () => import('@/views/sys/banner/index'),
        meta: { title: '轮播图管理',  }
      },
      {
        path: 'banner/add',
        name: 'add',
        component: () => import('@/views/sys/banner/add'),
        meta: { title: '添加轮播图',  },
        hidden: true
      },
      {
        path: 'banner/edit/:id(\\d+)',
        name: 'edit',
        component: () => import('@/views/sys/banner/edit'),
        meta: { title: '编辑轮播图',  },
        hidden: true
      },
      {
        path: 'about',
        name: 'about',
        component: () => import('@/views/sys/about/index'),
        meta: { title: '关于我们管理',  }
      },
      {
        path: 'about/add',
        name: 'add',
        component: () => import('@/views/sys/about/add'),
        meta: { title: '添加关于我们',  },
        hidden: true
      },
      {
        path: 'about/edit/:id(\\d+)',
        name: 'edit',
        component: () => import('@/views/sys/about/edit'),
        meta: { title: '编辑关于我们',  },
        hidden: true
      },
      {
        path: 'links',
        name: 'links',
        component: () => import('@/views/sys/links/index'),
        meta: { title: '友情链接管理',  }
      },
      {
        path: 'notice',
        name: 'notice',
        component: () => import('@/views/sys/notice/index'),
        meta: { title: '公告管理',  }
      },
      {
        path: 'notice/add',
        name: 'add',
        component: () => import('@/views/sys/notice/add'),
        meta: { title: '添加公告',  },
        hidden: true
      },
      {
        path: 'notice/edit/:id(\\d+)',
        name: 'edit',
        component: () => import('@/views/sys/notice/edit'),
        meta: { title: '编辑公告',  },
        hidden: true
      },
      {
        path: 'notice/details/:id(\\d+)',
        name: 'details',
        component: () => import('@/views/sys/notice/details'),
        meta: { title: '公告详情',  },
        hidden: true
      },
      {
        path: 'leaves',
        name: 'leaves',
        component: () => import('@/views/sys/leaves/index'),
        meta: { title: '私信管理',  }
      },
    ]
  },

  {
    path: '/sys-groups',
    component: Layout,
    meta: { title: '小组管理', icon: 'el-icon-eleme', roles: ['5'] },
    children: [
      {
        path: 'groups',
        name: 'groups',
        component: () => import('@/views/sys/groups/index'),
        meta: { title: '小组管理',  }
      },
      {
        path: 'groups/add',
        name: 'add',
        component: () => import('@/views/sys/groups/add'),
        meta: { title: '添加小组',  },
        hidden: true
      },
      {
        path: 'groups/edit/:id(\\d+)',
        name: 'edit',
        component: () => import('@/views/sys/groups/edit'),
        meta: { title: '编辑小组',  },
        hidden: true
      },
      {
        path: 'groups/details/:id(\\d+)',
        name: 'details',
        component: () => import('@/views/sys/groups/details'),
        meta: { title: '小组详情',  },
        hidden: true
      },
      {
        path: 'groupsComment',
        name: 'groupsComment',
        component: () => import('@/views/sys/groupsComment/index'),
        meta: { title: '小组讨论管理',  }
      },
    ]
  },

  {
    path: '/sys-article',
    component: Layout,
    meta: { title: '论坛管理', icon: 'el-icon-bank-card', roles: ['5'] },
    children: [
      {
        path: 'articleType',
        name: 'articleType',
        component: () => import('@/views/sys/articleType/index'),
        meta: { title: '文章类型管理',  }
      },
      {
        path: 'article',
        name: 'article',
        component: () => import('@/views/sys/article/index'),
        meta: { title: '文章管理',  }
      },
      {
        path: 'article/add',
        name: 'add',
        component: () => import('@/views/sys/article/add'),
        meta: { title: '添加文章',  },
        hidden: true
      },
      {
        path: 'article/edit/:id(\\d+)',
        name: 'edit',
        component: () => import('@/views/sys/article/edit'),
        meta: { title: '编辑文章',  },
        hidden: true
      },
      {
        path: 'article/details/:id(\\d+)',
        name: 'details',
        component: () => import('@/views/sys/article/details'),
        meta: { title: '文章详情',  },
        hidden: true
      },
      {
        path: 'articleComment',
        name: 'articleComment',
        component: () => import('@/views/sys/articleComment/index'),
        meta: { title: '文章讨论管理',  }
      },
    ]
  },

  {
    path: '/sys-information',
    component: Layout,
    meta: { title: '动态管理', icon: 'el-icon-shopping-bag-1', roles: ['5'] },
    children: [
      {
        path: 'information',
        name: 'information',
        component: () => import('@/views/sys/information/index'),
        meta: { title: '动态管理',  }
      },
      {
        path: 'information/add',
        name: 'add',
        component: () => import('@/views/sys/information/add'),
        meta: { title: '添加动态',  },
        hidden: true
      },
      {
        path: 'information/edit/:id(\\d+)',
        name: 'edit',
        component: () => import('@/views/sys/information/edit'),
        meta: { title: '编辑动态',  },
        hidden: true
      },
      {
        path: 'information/details/:id(\\d+)',
        name: 'details',
        component: () => import('@/views/sys/information/details'),
        meta: { title: '动态详情',  },
        hidden: true
      },
      {
        path: 'informationComment',
        name: 'informationComment',
        component: () => import('@/views/sys/informationComment/index'),
        meta: { title: '动态讨论管理',  }
      },
    ]
  },

  // 404 page must be placed at the end !!!
  { path: '*', redirect: '/home', hidden: true }
]

// 静态路由
export const constantRoutes = [
  {
    path: '/login',
    component: () => import('@/views/login'),
    hidden: true
  },

  {
    path: '/register',
    component: () => import('@/views/register'),
    hidden: true
  },

  {
    path: '/404',
    component: () => import('@/views/404'),
    hidden: true
  }

  // 404 page must be placed at the end !!!
  // { path: '*', redirect: '/404', hidden: true }
]

const createRouter = () => new Router({
  // mode: 'history', // require service support
  scrollBehavior: () => ({ y: 0 }),
  routes: constantRoutes
})

const router = createRouter()

// Detail see: https://github.com/vuejs/vue-router/issues/1234#issuecomment-357941465
export function resetRouter() {
  const newRouter = createRouter()
  router.matcher = newRouter.matcher // reset router
}

export default router
