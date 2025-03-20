<template>
  <header>
    <div style="background-color: #eeeeee47; height: 40px;">
      <div style="width: 1150px; margin: auto; text-align: right; padding-top: 5px;" v-if="userId.length == 0">
        <router-link to="/login" style="margin-right: 10px; margin-top: 5px;">
          登录
        </router-link>
        <router-link to="/register">
          注册
        </router-link>
      </div>

      <div style="width: 1150px; margin: auto; text-align: right;" v-if="userId.length != 0">
        <ul>
          <li style="position: relative;">
            <router-link to="/personal">
              <el-avatar size="small" :src="avatar" style="margin-top: 5px; margin-right: 5px;"></el-avatar>
              <span style="display: initial; margin-right: 30px;">{{name}}</span>
            </router-link>
            <a @click="logout" style="display: initial;">退出登录</a>
          </li>
        </ul>
      </div>
    </div>
    <div class="logo-section box">
      <div class="search">
        <div>
          <input class="input_text" v-model="queryParams.title" placeholder="请输入关键字..."
                 style="color: rgb(153, 153, 153);" type="text">
          <input name="Submit" class="input_submit" value="搜索" style="padding-left: 20px;" @click="search">
        </div>
      </div>
      <div class="logo">
        <router-link to="/">
          <img src="~@/ui/images/logo.png">
          <h2 class="logo-title">{{about.name}}</h2>
          <p class="logo-text">欢迎您</p>
        </router-link></div>
    </div>
    <div class="clear"></div>
    <div class="topnav">
      <h2>{{about.name}}</h2>
      <nav>
        <ul id="starlist">
          <li v-for="item in headerMune">
            <router-link :to="{ name: item.name }">{{item.text}}</router-link>
          </li>
        </ul>
      </nav>
      <h2 id="mnavh"><span class="navicon"></span></h2>
    </div>
  </header>
</template>

<script>
  import { mapGetters } from 'vuex'
  import { dynamicGetAbout } from '@/api/about'

  export default {
    name: 'Header',
    computed: {
      ...mapGetters([
        'userId',
        'name',
        'avatar',
        'role',
      ])
    },
    data() {
      return {
        headerMune: [
          {
            name: 'index',
            text: '网站首页'
          },
          {
            name: 'groups-list',
            text: '小组介绍'
          },
          {
            name: 'article-list',
            text: '论坛交流'
          },
          {
            name: 'information-list',
            text: '动态资讯'
          },
          {
            name: 'notice-list',
            text: '通知公告'
          },
          {
            name: 'about-list',
            text: '关于我们'
          }
        ],
        about: {},
        queryParams: {},
        levels: null,
      }
    },
    created() {
      this.dynamicGetAbout()
    },
    methods: {
      async logout() {
        await this.$store.dispatch('user/logout')
        this.$router.push(`/login?redirect=${this.$route.fullPath}`)
      },
      search() {
        this.$router.push({ path: '/article-search/' + this.queryParams.title })
      },
      dynamicGetAbout() {
        const data = {}
        data.status = 1
        dynamicGetAbout(data).then(response => {
          this.about = response.data
        })
      },
    }
  }
</script>
