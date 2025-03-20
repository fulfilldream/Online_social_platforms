<template>
  <div class="app-container">
    <div class="el-card">
      <div class="el-card__header">
        <div class="clearfix"><strong>添加文章</strong></div>
      </div>
      <div class="el-card__body">
        <el-form ref="form" :model="form" :rules="rules" size="small" label-width="80px">
          <el-form-item label="标题" prop="title">
            <el-input v-model="form.title" placeholder="请输入标题" clearable/>
          </el-form-item>
          <el-form-item label="摘要" prop="summary">
            <el-input v-model="form.summary" placeholder="请输入摘要" clearable/>
          </el-form-item>
          <el-form-item label="展示图" prop="img">
            <el-upload class="avatar-uploader"
                       :action="uploadImgUrl"
                       :on-success="handleAvatarSuccess"
                       :before-upload="beforeAvatarUpload"
                       :show-file-list="false"
                       :auto-upload="true">
              <img v-if="form.img" :src="form.img" class="avatar">
              <i v-else class="el-icon-plus avatar-uploader-icon"></i>
              <div slot="tip" class="el-upload__tip" style="margin-top: 0px; line-height: 0px;">
                只能上传jpg/png文件，且不超过2MB
              </div>
            </el-upload>
          </el-form-item>
          <el-form-item label="类型" prop="articleTypeId">
            <el-select v-model="form.articleTypeId" placeholder="请选择类型" filterable clearable>
              <el-option v-for="item in articleTypeList" :key="item.id" :label="item.name" :value="item.id">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="小组" prop="groupsId">
            <el-select v-model="form.groupsId" placeholder="请选择小组" filterable clearable>
              <el-option v-for="item in groupsList" :key="item.id" :label="item.name" :value="item.id">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="内容">
            <Wangeditor v-model="content" :isClear="isClear"></Wangeditor>
          </el-form-item>
          <el-form-item size="large">
            <el-button type="primary" size="small" @click="submitForm">确 定</el-button>
            <el-button size="small" @click="cancel">取 消</el-button>
          </el-form-item>
        </el-form>
      </div>
    </div>
  </div>
</template>

<script>
  import { mapGetters } from 'vuex'
  import { addArticle } from '@/api/article'
  import Wangeditor from '@/components/WangEditor'
  import { allUser } from '@/api/user'
  import { allArticleType } from '@/api/articleType'
  import { userGroups } from '@/api/groups'

  export default {
    components: {
      Wangeditor,
    },
    computed: {
      ...mapGetters([
        'userId',
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
              callback(new Error('必填项不能为空'));
          } else {
              if (Number.isInteger(value)) {
                   callback();
              } else {
                  callback(new Error('请输入数字'));
              }
          }
      }
      return {
        userList: [],
        articleTypeList: [],
        groupsList: [],
        content: '',
        isClear: false,
        uploadImgUrl: process.env.VUE_APP_BASE_API + "/uploadImgFile",
        // 表单参数
        form: {
          img: '',
        },
        // 表单校验
        rules: {
          id: [{ required: true, trigger: 'blur', validator: validateNumberData }],
          title: [{ required: true, trigger: 'blur', validator: validateData }],
          content: [{ required: true, trigger: 'blur', validator: validateData }],
          summary: [{ required: true, trigger: 'blur', validator: validateData }],
          userId: [{ required: true, trigger: 'blur', validator: validateNumberData }],
          creatTime: [{ required: true, trigger: 'blur', validator: validateData }],
          img: [{ required: true, trigger: 'blur', validator: validateData }],
          articleTypeId: [{ required: true, trigger: 'blur', validator: validateNumberData }],
          readCount: [{ required: true, trigger: 'blur', validator: validateNumberData }],
          collectCount: [{ required: true, trigger: 'blur', validator: validateNumberData }],
          status: [{ required: true, trigger: 'blur', validator: validateNumberData }],
          opinion: [{ required: true, trigger: 'blur', validator: validateData }],
        }
      }
    },
    created() {
      this.allUser()
      this.allArticleType()
      this.userGroups()
    },
    methods: {
      allUser(){
          this.loading = true
          allUser().then(response => {
              this.userList = response.data
              this.loading = false
          })
      },
      allArticleType(){
          this.loading = true
          allArticleType().then(response => {
              this.articleTypeList = response.data
              this.loading = false
          })
      },
      userGroups(){
          this.loading = true
          userGroups(this.userId).then(response => {
              this.groupsList = response.data
              this.loading = false
          })
      },
      /** 提交按钮 */
      submitForm() {
        this.$refs['form'].validate(valid => {
          if (valid) {
            this.form.userId = this.userId
            this.form.content = this.content
            addArticle(this.form).then(response => {
              this.$message.success('新增成功')
            })
          }
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
      },
      // 上传前的钩子
      beforeAvatarUpload(file) {
        let isJPG = ''
        if (file.type === 'image/jpeg' || file.type === 'image/png') {
          isJPG = true
        }
        const isLt2M = file.size / 1024 / 1024 < 2

        if (!isJPG) {
          this.$message.error('图片只能是 JPG、PNG 格式!')
        }
        if (!isLt2M) {
          this.$message.error('图片大小不能超过 2MB!')
        }
        return isJPG && isLt2M
      },
      // 上传成功后的钩子
      handleAvatarSuccess(res, file) {
        this.form.img = process.env.VUE_APP_BASE_API + res.data
      },
    }
  }
</script>
