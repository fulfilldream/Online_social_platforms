<template>
  <div class="app-container">
    <div class="el-card">
      <div class="el-card__header">
        <div class="clearfix"><strong>编辑动态</strong></div>
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
  import { getInformation, editInformation } from '@/api/information'
  import Wangeditor from '@/components/WangEditor'
  import { allUser } from '@/api/user'

  export default {
    name: 'EditInformation',
    components: {
      Wangeditor,
    },
    computed: {
      ...mapGetters([
        'userId',
      ])
    },
    data() {
      const validateData = (rule, value, callback) => {
        if (value == null || value.length == 0) {
          callback(new Error('必填项不能为空'))
        } else {
          callback()
        }
      }
      return {
        userList: [],
        content: '',
        isClear: false,
        uploadImgUrl: process.env.VUE_APP_BASE_API + "/uploadImgFile",
        // 表单参数
        form: {
          img: '',
        },
        // 表单校验
        rules: {
        id: [{ required: true, trigger: 'blur', validator: validateData }],
        title: [{ required: true, trigger: 'blur', validator: validateData }],
        content: [{ required: true, trigger: 'blur', validator: validateData }],
        summary: [{ required: true, trigger: 'blur', validator: validateData }],
        userId: [{ required: true, trigger: 'blur', validator: validateData }],
        creatTime: [{ required: true, trigger: 'blur', validator: validateData }],
        img: [{ required: true, trigger: 'blur', validator: validateData }],
        readCount: [{ required: true, trigger: 'blur', validator: validateData }],
        }
      }
    },
    created() {
      this.getInformation()
      this.allUser()
    },
    methods: {
      allUser(){
          this.loading = true
          allUser().then(response => {
             this.userList = response.data
             this.loading = false
        })
      },
      // 查询详细
      getInformation() {
          this.loading = true
          getInformation(this.$route.params.id).then(response => {
              this.form = response.data
              this.content = response.data.content
              this.loading = false
          })
      },
      /** 提交按钮 */
      submitForm() {
        this.$refs['form'].validate(valid => {
          if (valid) {
            this.form.content = this.content
            editInformation(this.form).then(response => {
              this.$message.success('编辑成功')
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

<style>
  .line {
    text-align: center;
  }

  .avatar-uploader .el-upload {
    border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
  }

  .avatar-uploader .el-upload:hover {
    border-color: #409EFF;
  }

  .avatar-uploader-icon {
    font-size: 28px;
    color: #8c939d;
    width: 100px;
    height: 100px;
    line-height: 100px;
    text-align: center;
  }

  .avatar {
    width: 100px;
    height: 100px;
    display: block;
  }
</style>
