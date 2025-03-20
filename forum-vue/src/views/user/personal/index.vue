<template>
  <div class="wrapper">
    <Header/>

    <div class="clear blank"></div>

    <article>
      <div class="page whitebg">

        <Left/>

        <div class="page-box">
          <h2 class="page-box-title">个人资料</h2>
          <div class="page-box-content">
            <el-form :model="form" :rules="rules" ref="form" label-width="110px">
              <el-form-item label="id" prop="id" style="display: none;">
                <el-input v-model="form.id" ref="id" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="用户名" prop="username">
                <el-input v-model="form.username" ref="username" :disabled="true" placeholder="请输入用户名" autocomplete="off"
                          clearable></el-input>
              </el-form-item>
              <el-form-item label="名称" prop="name">
                <el-input v-model="form.name" placeholder="请输入名称" autocomplete="off" clearable></el-input>
              </el-form-item>
              <el-form-item label="头像" prop="img">
                <el-upload class="avatar-uploader"
                           :action="uploadImgUrl"
                           :on-success="handleAvatarSuccess"
                           :before-upload="beforeAvatarUpload"
                           :show-file-list="false"
                           :auto-upload="true">
                  <img v-if="form.avatar" :src="form.avatar" class="avatar">
                  <i v-else class="el-icon-plus avatar-uploader-icon"></i>
                  <div slot="tip" class="el-upload__tip" style="margin-top: 0px; line-height: 0px;">
                    只能上传jpg/png文件，且不超过2MB
                  </div>
                </el-upload>
              </el-form-item>
              <el-form-item label="性别" prop="sex">
                <el-radio v-model="form.sex" label="男">男</el-radio>
                <el-radio v-model="form.sex" label="女">女</el-radio>
              </el-form-item>
              <el-form-item label="邮箱" prop="email">
                <el-input v-model="form.email" placeholder="请输入邮箱" autocomplete="off" clearable></el-input>
              </el-form-item>
              <el-form-item label="电话" prop="cellphone">
                <el-input v-model="form.cellphone" placeholder="请输入电话" autocomplete="off" clearable></el-input>
              </el-form-item>
              <el-form-item label="身份证" prop="identity">
                <el-input v-model="form.identity" placeholder="请输入身份证" autocomplete="off" clearable></el-input>
              </el-form-item>
              <el-form-item label="地址" prop="address">
                <el-input v-model="form.address" placeholder="请输入地址" autocomplete="off" clearable></el-input>
              </el-form-item>
              <el-form-item size="large">
                <el-button type="primary" size="small" @click="editData">保存编辑</el-button>
              </el-form-item>
            </el-form>
          </div>
        </div>
      </div>
    </article>

    <div class="clear blank"></div>

    <Footer/>
  </div>
</template>

<script>
  import { mapGetters } from 'vuex'
  import { getUser, editUser } from '@/api/user'
  import Header from '../common/Header.vue'
  import Footer from '../common/Footer.vue'
  import Left from '../common/Left.vue'

  export default {
    computed: {
      ...mapGetters([
        'userId'
      ])
    },
    components: {
      Header,
      Footer,
      Left
    },
    data() {
      const validateData = (rule, value, callback) => {
        if (value == null || value.length === 0) {
          callback(new Error('必填项不能为空'))
        } else {
          callback()
        }
      }
      return {
        uploadImgUrl: process.env.VUE_APP_BASE_API + "/uploadImgFile",
        // 表单参数
        form: {
          avatar: '',
        },
        rules: {
          // 要以数组形式展示
          username: [{ required: true, trigger: 'blur', validator: validateData }],
          password: [{ required: true, trigger: 'blur', validator: validateData }],
          email: [
            { required: true, trigger: 'blur', validator: validateData },
            {type: "email", required: true, message: "邮箱格式不正确", trigger: "blur"}
          ],
          cellphone: [{ required: true, trigger: 'blur', validator: validateData }],
          name: [{ required: true, trigger: 'blur', validator: validateData }]
        }
      }
    },
    created() {
      getUser(this.userId).then(response => {
        this.form = response.data
      })
    },
    methods: {
      editData() {
        this.$refs.form.validate(valid => {
          if (valid) {
            editUser(this.form).then(response => {
              this.$message.success('编辑成功')
              // 刷新当前路由
              setTimeout(() => {
                this.$router.go(0)
              }, 300)
            })
          } else {
            console.log('error submit!!')
            return false
          }
        })
      },
      // 上传前的钩子
      beforeAvatarUpload(file) {
        let isJPG = ''
        if (file.type === 'image/jpeg' || file.type === 'image/png') {
          isJPG = true
        }
        const isLt2M = file.size / 1024 / 1024 < 2

        if (!isJPG) {
          this.$message.error('上传头像图片只能是 JPG、PNG 格式!')
        }
        if (!isLt2M) {
          this.$message.error('上传头像图片大小不能超过 2MB!')
        }
        return isJPG && isLt2M
      },
      // 上传成功后的钩子
      handleAvatarSuccess(res, file) {
        this.form.avatar = process.env.VUE_APP_BASE_API + res.data
      }
    }
  }
</script>


