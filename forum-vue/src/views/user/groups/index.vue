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
              <router-link to="/groups-list">讨交流小组小组</router-link>
            </span>
          <h2>交流小组</h2>
        </div>

        <el-row>
          <el-col :span="24">
            <el-row style="text-align: right; padding-right: 20px; margin-bottom: 20px;">
              <router-link to="/groups-add">
                <el-button
                  type="primary"
                  plain
                  icon="el-icon-plus"
                  size="mini">
                  创建
                </el-button>
              </router-link>
            </el-row>

            <ul id="data-list">
              <li v-for="item in list" :key="item.id">
                <router-link :to="{ name: 'groups-details', params: { id: item.id} }">
                  <i><img :src="item.img" style="height: 177px; width: 100%;"></i>
                  <h2 style="margin-top: 20px;">{{item.name}}</h2>
                  <p style="text-align: center;">{{item.label}}</p>
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
  import { dataGroups } from '@/api/groups'
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
          status: 1,
          name: null,
        }
      }
    },
    created() {
      this.dataGroups()
    },
    methods: {
      // 查询表格数据
      dataGroups() {
        this.loading = true
        dataGroups(this.queryParams).then(response => {
          this.list = response.data
          this.total = response.count
          this.loading = false
        })
      },
      // 分页数据跳转监听
      handleCurrentChange(val) {
        this.loading = true
        this.queryParams.page = val
        this.dataGroups()
      },
      // 搜索按钮操作
      handleQuery() {
        this.queryParams.page = 1
        this.dataGroups()
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


