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
              <router-link to="/notice-list">通知公告</router-link>
            </span>
          <h2>通知公告</h2>
        </div>

        <el-row>
          <el-col :span="24">
            <ul id="data-list">
              <li v-for="item in list" :key="item.id">
                <router-link :to="{ name: 'notice-details', params: { id: item.id} }">
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
  import { dataNotice, listLimitNotice } from '@/api/notice'
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
      this.dataNotice()
    },
    methods: {
      // 查询表格数据
      dataNotice() {
        this.loading = true
        dataNotice(this.queryParams).then(response => {
          this.list = response.data
          this.total = response.count
          this.loading = false
        })
      },
      // 分页数据跳转监听
      handleCurrentChange(val) {
        this.loading = true
        this.queryParams.page = val
        this.dataNotice()
      },
      // 搜索按钮操作
      handleQuery() {
        this.queryParams.page = 1
        this.dataNotice()
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


