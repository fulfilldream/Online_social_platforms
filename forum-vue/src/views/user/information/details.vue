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
              <router-link to="/information-list">动态资讯</router-link>
            </span>
            <h2>动态资讯</h2>
          </div>

          <div class="newstext-box">
            <h1 class="news-title-h1">{{info.title}}</h1>

            <div style="margin: 10px 0px;">
              <el-button type="primary" size="small" @click="addLike" v-if="like == null">点赞</el-button>
              <el-button type="primary" size="small" @click="delLike" v-if="like != null">取消点赞</el-button>
              <el-button type="primary" size="small" @click="addFollow" v-if="follow == null">关注</el-button>
              <el-button type="primary" size="small" @click="delFollow" v-if="follow != null">取消关注</el-button>
              <el-button type="primary" size="small" @click="handleSend">发送私信</el-button>
            </div>

            <div class="picview-other">
              <span class="po-from">{{info.user.name}}</span>
              <span class="po-date">{{info.creatTime}}</span>
              <span class="po-view">{{info.readCount}}(浏览)</span>
              <span class="po-view">{{info.likeCount}}(点赞)</span>
            </div>

            <div class="smalltext"><i></i>{{info.summary}}</div>

            <div class="newstext" v-html="info.content"></div>

            <div class="clear"></div>

            <div class="share">
              <img :src="info.user.avatar">
              <div class="share-text">
                <p>{{info.user.name}}</p>
                <p>
                  <router-link :to="{ name: 'information-user', params: { id: info.userId} }">
                    他的发布
                  </router-link>
                </p>
              </div>
            </div>

            <div class="clear"></div>
          </div>
        </div>

        <div class="clear blank"></div>

        <div class="pinglun-box whitebg">
          <div class="news-title">
            <h2>在线评论</h2>
          </div>
          <div class="pinglun">
            <el-form ref="formComment" :model="formComment" :rules="rulesComment" size="small" style="padding: 0px 20px;">
              <el-form-item label="评论内容" prop="content">
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
            <h2>评论列表</h2>
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

    <el-dialog :title="title" :visible.sync="open" width="700px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" size="small" label-width="80px">
        <el-form-item label="私信内容" prop="content">
          <el-input v-model="form.content" type="textarea" :rows="3" placeholder="请输入内容" clearable/>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" size="small" @click="submitForm">确 定</el-button>
        <el-button size="small" @click="cancel">取 消</el-button>
      </div>
    </el-dialog>

    <Footer/>
  </div>
</template>

<script>
  import { mapGetters } from 'vuex'
  import { detailsGetInformation, listLimitInformation, editInformation } from '@/api/information'
  import { addInformationComment, dataInformationComment } from '@/api/informationComment'
  import { dynamicGetInformationLike, addInformationLike, delInformationLike } from '@/api/informationLike'
  import { dynamicGetFollow, addFollow, delFollow } from '@/api/follow'
  import { addLeaves } from '@/api/leaves'
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
        open: false,
        title: '',
        like: null,
        follow: null,
        info: {},
        commentList: [],
        total: null,
        queryParams: {
          page: 1,
          limit: 10,
          InformationId: null,
        },
        form: {},
        formComment: {},
        rules: {
          content: [{ required: true, trigger: 'blur', validator: validateData }],
        },
        rulesComment: {
          content: [{ required: true, trigger: 'blur', validator: validateData }],
        }
      }
    },
    watch: {
      '$route' (to, from) {
        if (to.name == 'information-details') {
          this.queryParams.informationId = to.params.id
          this.detailsGetInformation(to.params.id)
          this.dataInformationComment()
        }
      }
    },
    created() {
      this.queryParams.informationId = this.$route.params.id
      this.detailsGetInformation(this.$route.params.id)
      this.dataInformationComment()
    },
    methods: {
      handleSend() {
        this.open = true
        this.title = "发送私信"
      },
      cancel() {
        this.open = false;
      },
      submitForm() {
        this.$refs["form"].validate(valid => {
          if (valid) {
            this.form.staffId = row.info.userId;
            this.form.userId = this.userId
            addLeaves(this.form).then(response => {
              this.$message.success('发送成功')
              this.open = false;
            });
          }
        });
      },
      addFollow() {
        this.follow = {}
        this.follow.userId = this.userId
        this.follow.followUserId = this.info.userId
        addFollow(this.follow).then(response => {
          this.follow = response.data
        })
      },
      delFollow() {
        delFollow(this.follow.id).then(response => {
          this.follow = null
        })
      },
      addLike() {
        this.like = {}
        this.like.userId = this.userId
        this.like.informationId = this.info.id
        addInformationLike(this.like).then(response => {
          this.like = response.data
          this.info.likeCount = this.info.likeCount + 1
          editInformation(this.info)
        })
      },
      delLike() {
        delInformationLike(this.like.id).then(response => {
          this.like = null
          this.info.likeCount = this.info.likeCount - 1
          editInformation(this.info)
        })
      },
      addComment() {
        this.$refs['formComment'].validate(valid => {
          if (valid) {
            this.formComment.userId = this.userId
            this.formComment.informationId = this.info.id
            addInformationComment(this.formComment).then(response => {
              this.$message.success('评论成功')
              this.formComment = {}
              this.dataInformationComment()
            })
          }
        })
      },
      dataInformationComment() {
        this.loading = true
        dataInformationComment(this.queryParams).then(response => {
          this.commentList = response.data
          this.total = response.count
          this.loading = false
        })
      },
      // 分页数据条数监听
      handleCurrentChange(val) {
        this.queryParams.limit = val
        this.getData()
      },
      detailsGetInformation(id) {
        this.loading = true
        detailsGetInformation(id).then(response => {
          this.info = response.data

          const data = {}
          data.userId = this.userId
          data.informationId = this.info.id
          dynamicGetInformationLike(data).then(response => {
            this.like = response.data
          })

          const search = {}
          search.userId = this.userId
          search.followUserId = this.info.userId
          dynamicGetFollow(search).then(response => {
            this.follow = response.data
          })

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


