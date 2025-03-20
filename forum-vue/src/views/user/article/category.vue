<template>
  <div class="wrapper">
    <Header/>

    <div class="clear blank"></div>

    <article>

      <div class="blogs left-box">

        <div class="blogs-box whitebg" style="padding-bottom: 20px;">

          <div class="news-title">
            <span class="hnav">
              <router-link to="/">首页</router-link>
              <router-link to="/article-list">论坛交流</router-link>
            </span>
            <h2>{{articleType.name}}</h2>
          </div>

          <div class="blogs-list">
            <el-row style="text-align: right; padding-right: 20px;">
              <router-link to="/article-add">
                <el-button
                  type="primary"
                  plain
                  icon="el-icon-plus"
                  size="mini">
                  发布
                </el-button>
              </router-link>
            </el-row>

            <ul>
              <li v-for="item in list" :key="item.id">
                <h2>
                  <router-link :to="{ name: 'article-details', params: { id: item.id} }">
                    {{item.title}}
                  </router-link>
                </h2>
                <i>
                  <router-link :to="{ name: 'article-details', params: { id: item.id} }">
                    <img :src="item.img" style="width: 100%; height: 100%;">
                  </router-link>
                </i>
                <p>{{item.summary}}</p>
                <span>
                   <router-link :to="{ name: 'article-details', params: { id: item.id} }">
                    {{item.user.name}}
                  </router-link>
                  <router-link :to="{ name: 'article-details', params: { id: item.id} }">
                    {{item.articleType.name}}
                  </router-link>
                  <router-link :to="{ name: 'article-details', params: { id: item.id} }">
                  {{item.creatTime}}
                  </router-link>
                </span>
              </li>
            </ul>
          </div>

          <el-pagination
            v-show="total > 0"
            background
            class="pagination-container"
            @current-change="handleCurrentChange"
            :current-page="queryParams.page"
            :page-size="queryParams.limit"
            :page-sizes="[10, 20, 30, 50]"
            layout="prev, pager, next"
            :total="total">
          </el-pagination>
        </div>

      </div>

      <Right/>
    </article>

    <div class="clear blank"></div>

    <Footer/>
  </div>
</template>

<script>
  import { dataArticle, listLimitArticle } from '@/api/article'
  import { getArticleType ,allArticleType } from '@/api/articleType'
  import Header from '../common/Header.vue'
  import Footer from '../common/Footer.vue'
  import Right from '../common/Right.vue'

  export default {
    components: {
      Header,
      Footer,
      Right,
    },
    data() {
      return {
        articleType: {},
        total: 0,
        list: [],
        // 查询参数
        queryParams: {
          page: 1,
          limit: 5,
          name: null,
          articleTypeId: null,
          groupsId: null,
          status: 1
        }
      }
    },
    watch: {
      '$route' (to, from) {
        if (to.name == 'article-category') {
          this.queryParams.articleTypeId = to.params.id
          this.dataArticle()
          this.getArticleType(to.params.id)
        }
      }
    },
    created() {
      this.queryParams.articleTypeId = this.$route.params.id
      this.dataArticle()
      this.getArticleType(this.$route.params.id)
    },
    methods: {
      getArticleType(id) {
        getArticleType(id).then(response => {
          this.articleType = response.data
        })
      },
      // 查询表格数据
      dataArticle() {
        this.loading = true
        dataArticle(this.queryParams).then(response => {
          this.list = response.data
          this.total = response.count
          this.loading = false
        })
      },
      // 分页数据跳转监听
      handleCurrentChange(val) {
        this.loading = true
        this.queryParams.page = val
        this.dataArticle()
      },
      // 搜索按钮操作
      handleQuery() {
        this.queryParams.page = 1
        this.dataArticle()
      },
      // 重置按钮操作
      resetForm(formName) {
        this.$nextTick(() => {
          this.$refs[formName].resetFields()
        })
        this.handleQuery()
      }
    }
  }
</script>

<style scoped>
  .active{
    background: #1487f4;
    color: #fff;
  }
</style>


