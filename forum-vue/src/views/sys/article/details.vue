<template>
  <div class="app-container">
    <div class="el-card">
      <div class="el-card__header">
        <div class="clearfix"><strong>文章详情</strong></div>
      </div>
      <div class="el-card__body">
        <div>
          <h3>{{info.title}}</h3>
          <el-divider></el-divider>
          <div>
            <span style="margin-right: 15px;">类型：{{info.articleType.name}}</span>
            <span style="margin-right: 15px;">小组：{{info.groups.name}}</span>
            <span style="margin-right: 15px;">浏览量：{{info.readCount}}</span>
            <span style="margin-right: 15px;">点赞量：{{info.likeCount}}</span>
            <span style="margin-right: 15px;">收藏量：{{info.collectCount}}</span>
            <span style="margin-right: 15px;">发布者：{{info.user.name}}</span>
            <span style="margin-right: 15px;">发布时间：{{info.creatTime}}</span>
          </div>
          <el-divider></el-divider>
          <div v-html="info.content"></div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  import { detailsGetArticle } from '@/api/article'

  export default {
    data() {
      return {
        info: {}
      }
    },
    created() {
      this.detailsGetArticle()
    },
    methods: {
      // 查询详细
      detailsGetArticle() {
        this.loading = true
        detailsGetArticle(this.$route.params.id).then(response => {
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
