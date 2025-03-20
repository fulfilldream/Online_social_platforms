<template>
  <div class="app-container">
    <div class="el-card">
      <div class="el-card__header">
        <div class="clearfix"><strong>编辑轮播图</strong></div>
      </div>
      <div class="el-card__body">
        <el-form ref="form" :model="form" :rules="rules" size="small" label-width="80px">
          <el-form-item label="名称" prop="name">
            <el-input v-model="form.name" placeholder="请输入名称" clearable/>
          </el-form-item>
          <el-form-item label="图片" prop="img">
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
          <el-form-item label="展示状态" prop="status">
            <el-radio v-model="form.status" label="true">展示</el-radio>
            <el-radio v-model="form.status" label="false">不展示</el-radio>
          </el-form-item>
          <el-form-item label="简介" prop="introduce">
            <el-input v-model="form.introduce" placeholder="请输入简介" clearable/>
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
  import { getBanner, editBanner } from '@/api/banner'
  import Wangeditor from '@/components/WangEditor'

  export default {
    name: 'EditBanner',
    components: {
      Wangeditor: Wangeditor
    },
    computed: {
      ...mapGetters([
        'userId'
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
        content: '',
        isClear: false,
        uploadImgUrl: process.env.VUE_APP_BASE_API + '/uploadImgFile',
        // 表单参数
        form: {
          img: ''
        },
        // 表单校验
        rules: {
          id: [{ required: true, trigger: 'blur', validator: validateData }],
          img: [{ required: true, trigger: 'blur', validator: validateData }],
          status: [{ required: true, trigger: 'blur', validator: validateData }],
          name: [{ required: true, trigger: 'blur', validator: validateData }],
          introduce: [{ required: true, trigger: 'blur', validator: validateData }]
        }
      }
    },
    created() {
      this.getBanner()
    },
    methods: {
      // 查询详细
      getBanner() {
        this.loading = true
        getBanner(this.$route.params.id).then(response => {
          this.form = response.data
          if (this.form.status) {
            this.form.status = 'true'
          } else {
            this.form.status = 'false'
          }
          this.content = response.data.content
          this.loading = false
        })
      },
      /** 提交按钮 */
      submitForm() {
        this.$refs['form'].validate(valid => {
          if (valid) {
            this.form.content = this.content
            editBanner(this.form).then(response => {
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
      }
    }
  }
</script>

<style scoped>
  .avatar-uploader .el-upload {
    border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
  }

  .avatar-uploader .el-upload:hover {
    border-color: #7aab37;
  }

  .avatar-uploader-icon {
    font-size: 28px;
    color: #8c939d;
    width: 250px;
    height: 150px;
    line-height: 150px;
    text-align: center;
  }

  .avatar {
    width: 250px;
    height: 150px;
    display: block;
  }
</style>
