<template>
  <div id="app">
    <router-view />
  </div>
</template>

<script>
export default {
  name: 'App'
}
</script>

<style lang="scss" >
  // 顶部导航颜色更换
  .navbar,.sidebar-logo-container {
    border-bottom: 2px solid #ecf5ff; // logo下划线
    background-color: #0275d8!important;
  }

  .app-breadcrumb.el-breadcrumb .no-redirect{
    color: #fff!important;
  }

  .hamburger{
    fill: #f0f8ff!important;
  }

  .navbar .right-menu .right-menu-item{
    color: #fff!important;
  }

  .el-breadcrumb__inner a{
    color: #fff!important;
  }

  // 头像文字颜色
  .avatar-wrapper{
    color: #fff!important;
  }
  // 左侧导航条
  #app .sidebar-container{
    box-shadow: 1px 1px 5px 3px #eeeeee;
  }

  // 左侧子菜单选中背景色
  .sidebar-container .el-menu-item.is-active {
    background-color: #0275d8 !important; /* 你想要的高亮颜色 */
  }

  #app .sidebar-container a:hover {
    color: #ffffff!important;
  }
</style>
