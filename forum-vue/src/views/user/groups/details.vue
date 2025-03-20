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
              <router-link to="/groups-list">交流小组</router-link>
            </span>
            <h2>详情</h2>
          </div>

          <div class="shopview">
            <div class="swiper-container swiper-container-initialized swiper-container-horizontal">
              <div class="swiper-wrapper" style="transform: translate3d(0px, 0px, 0px);">
                <div class="swiper-slide swiper-slide-active" style="width: 331px;">
                  <div class="swiper-zoom-container">
                    <img :src="info.img">
                  </div>
                </div>
              </div>
            </div>
          </div>

          <div class="product">

            <h1>{{info.name}}</h1>

            <p class="product-jianjie">
              <span>组长：</span>{{info.user.name}}
            </p>

            <p class="product-scj"><span>标签：</span>{{info.label}}</p>
            <p class="product-scj"><span>创建时间：</span>{{info.creatTime}}</p>

            <a class="btn-add" @click="addApply" v-if="apply == null"
               style="width: 100px; display: inline-block; margin-left: 20px;">加入</a>
            <a class="btn-add" @click="delApply" v-if="apply != null"
               style="width: 100px; display: inline-block; margin-left: 20px;">退出</a>
            <router-link :to="{ name: 'article-groups', params: { id: info.id} }" class="btn-add"
               style="width: 100px; display: inline-block; margin-left: 20px;">小组帖子</router-link>
          </div>

          <div class="clear"></div>

          <div class="product-infos">
            <div class="news-title">
              <h2>内容详情</h2>
            </div>

            <div class="product-content">
              <div v-html="info.content"></div>
            </div>
          </div>

          <div class="clear"></div>
        </div>

        <div class="pinglun-box whitebg">
          <div class="news-title">
            <h2>在线交流</h2>
          </div>
          <div class="pinglun">
            <el-form ref="formComment" :model="formComment" :rules="rulesComment" size="small" style="padding: 0px 20px;">
              <el-form-item label="交流内容" prop="content">
                <el-input type="textarea" :rows="3" v-model="formComment.content" placeholder="请输入内容"
                          clearable/>
              </el-form-item>
              <el-form-item size="large">
                <el-button type="primary" size="small" @click="addComment">确 定</el-button>
              </el-form-item>
            </el-form>
          </div>
        </div>

        <div class="clear blank"></div>

        <div class="otherlink whitebg">
          <div class="news-title">
            <h2>交流列表</h2>
          </div>

          <div id="data-list">
            <ul>
              <li style="width: 100%; position: relative;" v-for="item in commentList" :key="item.id">
                <img :src="item.user.avatar" style="width: 45px; height: 45px; position: absolute; left: 10px;">
                <p style="margin-left: 80px;">{{item.user.name}}（{{item.creatTime}}）</p>
                <span class="down-info" style="margin-left: 80px;">{{item.content}}</span>
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
  import { mapGetters } from 'vuex'
  import { detailsGetGroups } from '@/api/groups'
  import { addGroupsComment, dataGroupsComment } from '@/api/groupsComment'
  import { dynamicGetApply, addApply, delApply } from '@/api/apply'
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
        apply: null,
        commentList: [],
        total: null,
        queryParams: {
          page: 1,
          limit: 10,
          groupsId: null,
        },
        formComment: {},
        rulesComment: {
          content: [{ required: true, trigger: 'blur', validator: validateData }],
        }
      }
    },
    watch: {
      '$route'(to, from) {
        if (to.name == 'groups-details') {
          this.queryParams.GroupsId = to.params.id
          this.detailsGetGroups(to.params.id)
          this.dataGroupsComment()
        }
      }
    },
    created() {
      this.queryParams.groupsId = this.$route.params.id
      this.detailsGetGroups(this.$route.params.id)
      this.dataGroupsComment()
    },
    mounted() {
      this.timer = setInterval(() => {
        this.doSomething();
      }, 3000); // 5000毫秒 = 5秒
    },
    methods: {
      doSomething() {
        this.dataGroupsComment()
      },
      addComment() {
        this.$refs['formComment'].validate(valid => {
          if (valid) {
            this.formComment.userId = this.userId
            this.formComment.groupsId = this.info.id
            addGroupsComment(this.formComment).then(response => {
              this.$message.success('提交成功')
              this.formComment = {}
              this.dataGroupsComment()
            })
          }
        })
      },
      dataGroupsComment() {
        this.loading = true
        dataGroupsComment(this.queryParams).then(response => {
          this.commentList = response.data
          this.total = response.count
          this.loading = false
        })
      },
      handleCurrentChange(val) {
        this.loading = true
        this.queryParams.limit = val
        this.dataGroupsComment()
      },
      addApply() {
        if (this.userId == this.info.userId) {
          this.$message.error('加入失败：不可加入自己创建的小组')
        } else {
          this.apply = {}
          this.apply.userId = this.userId
          this.apply.groupsId = this.info.id
          addApply(this.apply).then(response => {
            this.apply = response.data
            this.$message.success('加入成功')
          })
        }
      },
      delApply() {
        delApply(this.apply.id).then(response => {
          this.apply = null
          this.$message.success('退出成功')
        })
      },
      detailsGetGroups(id) {
        detailsGetGroups(id).then(response => {
          this.info = response.data

          const data = {}
          data.userId = this.userId
          data.groupsId = this.info.id
          dynamicGetApply(data).then(response => {
            this.apply = response.data
          })

        })
      },
    }
  }
</script>

<style scoped>
  .active {
    background: #1487f4;
    color: #fff;
  }
</style>


