<template>
  <div class="app-container">
    <div class="el-card">
      <div class="el-card__header">
        <div class="clearfix"><strong>公告详情</strong></div>
      </div>
      <div class="el-card__body">
        <div>
          <h3>{{info.title}}</h3>
          <el-divider></el-divider>
          <div>
            <span style="margin-right: 15px;">发布者：{{info.user.name}}</span>
            <span style="margin-right: 15px;">发布时间：{{info.creatTime}}</span>
            <span style="margin-right: 15px;">浏览量：{{info.readCount}}</span>
          </div>
          <el-divider></el-divider>
          <div v-html="info.content"></div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  import { detailsGetNotice } from '@/api/notice'

  export default {
    name: 'ItemNotice',
    data() {
      return {
        info: {}
      }
    },
    created() {
      this.detailsGetNotice()
    },
    methods: {
      // 查询详细
      detailsGetNotice() {
        this.loading = true
        detailsGetNotice(this.$route.params.id).then(response => {
          this.info = response.data
          this.loading = false
        })
      },
      // 取消按钮
      cancel() {
        const currentTag = this.$route // 获取当前路由对象
        this.$store.dispatch('tagsView/delView', currentTag) // 调用vuex中的删除操作
        const tags = this.$store.state.tagsView.visitedViews // 获取所有已访问的标签页
        const prevTag = tags.slice(-1)[0] // 获取倒数第二个标签页
        if (prevTag) {
          this.$router.push(prevTag.path) // 跳转到倒数第二个标签页
        } else {
          this.$router.push('/') // 如果没有倒数第二个标签页，跳转到首页
        }
      }
    }
  }
</script>

<style scoped>
  .el-divider--horizontal {
    margin: 10px 0px;
  }

  span {
    margin-right: 15px;
    color: #847d7d;
    font-size: 14px;
  }
</style>
