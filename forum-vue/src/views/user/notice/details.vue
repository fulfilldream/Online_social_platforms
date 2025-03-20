<template>
  <div class="wrapper">
    <Header/>

    <div class="clear blank"></div>

    <article>

      <div class="left-box">

        <div class="whitebg">
          <div class="news-title">
            <span class="hnav">
              <router-link to="/">首页</router-link>
              <router-link to="/notice-list">通知公告</router-link>
            </span>
            <h2>公告详情</h2>
          </div>

          <div class="newstext-box">
            <h1 class="news-title-h1">{{info.title}}</h1>

            <div class="picview-other">
              <span class="po-from">{{info.user.name}}</span>
              <span class="po-date">{{info.creatTime}}</span>
              <span class="po-view">{{info.readCount}}(浏览)</span>
            </div>

            <div class="smalltext"><i></i>{{info.summary}}</div>

            <div class="newstext" v-html="info.content"></div>

            <div class="clear"></div>
          </div>
        </div>

        <div class="clear blank"></div>
      </div>

      <Right/>
    </article>

    <div class="clear blank"></div>

    <Footer/>
  </div>
</template>

<script>
  import { mapGetters } from 'vuex'
  import { detailsGetNotice, listLimitNotice } from '@/api/notice'
  import Header from '../common/Header.vue'
  import Footer from '../common/Footer.vue'
  import Right from '../common/Right.vue'

  export default {
    components: {
      Header,
      Footer,
      Right,
    },
    computed: {
      ...mapGetters([
        'userId'
      ])
    },
    data() {
      // 表单数据空值效验
      const validateData = (rule, value, callback) => {
        if (value == null || value.length == 0) {
          callback(new Error('必填项不能为空'))
        } else {
          callback()
        }
      }
      // 表单数据数字效验
      const validateNumberData = (rule, value, callback) => {
        if (value == null || value.length == 0) {
          callback(new Error('必填项不能为空'))
        } else {
          if (Number.isInteger(value)) {
            callback()
          } else {
            callback(new Error('请输入数字'))
          }
        }
      }
      return {
        info: {},
      }
    },
    watch: {
      '$route' (to, from) {
        if (to.name == 'notice-details') {
          this.detailsGetNotice(to.params.id)
        }
      }
    },
    created() {
      this.detailsGetNotice(this.$route.params.id)
    },
    methods: {
      detailsGetNotice(id) {
        this.loading = true
        detailsGetNotice(id).then(response => {
          this.info = response.data
          this.loading = false
        })
      },
    }
  }
</script>

<style scoped>
  .active{
    background: #1487f4;
    color: #fff;
  }
</style>


