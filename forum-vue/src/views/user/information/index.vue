<template>
  <div class="wrapper">
    <Header/>

    <div class="clear blank"></div>

    <article>
      <div class="clear blank"></div>

      <div class="pics-list-box whitebg">

        <div class="news-title">
            <span class="hnav">
              <router-link to="/">首页</router-link>
              <router-link to="/information-list">动态资讯</router-link>
            </span>
          <h2>动态资讯</h2>
        </div>

        <el-row>
          <el-row style="text-align: right; padding-right: 20px; margin-bottom: 10px;">
            <router-link to="/information-add">
              <el-button
                type="primary"
                plain
                icon="el-icon-plus"
                size="mini">
                发布
              </el-button>
            </router-link>
          </el-row>

          <el-col :span="24">
            <ul id="data-list">
              <li v-for="item in list" :key="item.id">
                <router-link :to="{ name: 'information-details', params: { id: item.id} }">
                  <i><img :src="item.img" style="height: 177px; width: 100%;"></i>
                  <h2>{{item.title}}</h2>
                  <p>{{item.summary}}</p>
                  <p><b class="datetime">{{item.creatTime}}</b></p>
                </router-link>
              </li>
            </ul>
          </el-col>
        </el-row>

        <el-row style="padding-bottom: 20px;">
          <el-col :span="24">
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
          </el-col>
        </el-row>
      </div>
    </article>

    <div class="clear blank"></div>

    <Footer/>
  </div>
</template>

<script>
  import { dataInformation, listLimitInformation } from '@/api/information'
  import Header from '../common/Header.vue'
  import Footer from '../common/Footer.vue'

  export default {
    components: {
      Header,
      Footer
    },
    data() {
      return {
        total: 0,
        list: [],
        // 查询参数
        queryParams: {
          page: 1,
          limit: 8,
          title: null,
        }
      }
    },
    created() {
      this.dataInformation()
    },
    methods: {
      // 查询表格数据
      dataInformation() {
        this.loading = true
        dataInformation(this.queryParams).then(response => {
          this.list = response.data
          this.total = response.count
          this.loading = false
        })
      },
      // 分页数据跳转监听
      handleCurrentChange(val) {
        this.loading = true
        this.queryParams.page = val
        this.dataInformation()
      },
      // 搜索按钮操作
      handleQuery() {
        this.queryParams.page = 1
        this.dataInformation()
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


