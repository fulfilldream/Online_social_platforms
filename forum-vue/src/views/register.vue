<template>
  <div class="wrapper">

    <Header/>

    <div class="clear blank"></div>

    <article>
      <div class="page whitebg">
        <div class="page-box" style="min-height: 300px; padding-top: 80px;">
          <h2 class="page-box-title">用户注册</h2>
          <div class="page-box-content">
            <el-form class="login-form" ref="loginForm" :model="loginForm" :rules="loginRules">
              <el-form-item label="" prop="username">
                <el-input v-model="loginForm.username" prefix-icon="el-icon-user" placeholder="请输入用户名" clearable>
                </el-input>
              </el-form-item>

              <el-form-item label="" prop="password">
                <el-input v-model="loginForm.password" autocomplete="off" prefix-icon="el-icon-lock"
                          placeholder="请输入密码" show-password clearable>
                </el-input>
              </el-form-item>

              <el-form-item label="" prop="password2">
                <el-input v-model="loginForm.password2" autocomplete="off" prefix-icon="el-icon-lock"
                          placeholder="请输入确认密码" show-password clearable>
                </el-input>
              </el-form-item>

              <el-form-item label="" prop="name">
                <el-input v-model="loginForm.name" prefix-icon="el-icon-user" placeholder="请输入名称"></el-input>
              </el-form-item>

              <el-form-item label="" prop="cellphone">
                <el-input v-model="loginForm.cellphone" prefix-icon="el-icon-phone" placeholder="请输入电话"></el-input>
              </el-form-item>
              <label style="margin: 0px 0px 25px 0px">
                已有账号？
                <router-link to="login" style="color: #0275d8;">
                  点击登录
                </router-link>
              </label>
              <el-form-item>
                <el-button size="medium" type="primary" :loading="loading" @click.native.prevent="handleRegister">
                  <span>注  册</span>
                </el-button>
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
  import { register } from '@/api/user'
  import Header from './user/common/Header.vue'
  import Footer from './user/common/Footer.vue'

  export default {
    components: {
      Header,
      Footer
    },
    data() {
      const validateData = (rule, value, callback) => {
        if (value.length === 0) {
          callback(new Error('必填项不能为空'))
        } else {
          callback()
        }
      }
      const validatePassword = (rule, value, callback) => {
        if (value.length < 6) {
          callback(new Error('密码长度不得小于6位'))
        } else {
          callback()
        }
      }
      return {
        loginForm: {
          username: '',
          password: '',
          password2: '',
          name: '',
          cellphone: '',
        },
        loginRules: {
          username: [{ required: true, trigger: 'blur', validator: validateData }],
          password: [{ required: true, trigger: 'blur', validator: validateData }],
          password2: [{ required: true, trigger: 'blur', validator: validateData }],
          name: [{ required: true, trigger: 'blur', validator: validateData }],
          cellphone: [{ required: true, trigger: 'blur', validator: validateData }],
        },
        loading: false,
        passwordType: 'password',
        redirect: undefined
      }
    },
    watch: {
      $route: {
        handler: function (route) {
          this.redirect = route.query && route.query.redirect
        },
        immediate: true
      }
    },
    methods: {
      showPwd() {
        if (this.passwordType === 'password') {
          this.passwordType = ''
        } else {
          this.passwordType = 'password'
        }
        this.$nextTick(() => {
          this.$refs.password.focus()
        })
      },
      handleRegister() {
        this.$refs.loginForm.validate(valid => {
          if (valid) {
            if (this.loginForm.password === this.loginForm.password2) {
              // true：开启加载图标
              this.loading = true
              register(this.loginForm).then(response => {
                this.$message.success('注册成功');
                // 重定向
                this.$router.push({ path: this.redirect || '/' })
                this.loading = false
              }).catch(() => {
                this.loading = false
              })
            } else {
              this.$message.error('两次密码输入不一致');
              return false
            }
          } else {
            console.log('error submit!!')
            return false
          }
        })
      }
    }
  }
</script>

<style lang="scss" scoped>
  .login {
    background-image: url('../static/images/login.png');
    background-size: 100% 100%;
    // background-size: auto;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100%;
    position: relative;

    .login-form {
      background-image: url('../static/images/inputBg.png');
      border-radius: 6px;
      position: absolute;
      width: 490px;
      right: 250px;
      padding: 45px 50px 0 50px;

      .title {
        height: 40px;
        line-height: 40px;
        font-size: 28px;
        width: 100%;
        font-family: PingFang SC;
        color: #7aab37;
        text-align: center;
        margin-bottom: 35px;
      }

      .el-input {
        margin-bottom: 10px;
      }

      .el-button {
        width: 100%;
        margin: 35px 0;
        background-color: #7aab37;
      }

      .el-button:hover {
        background-color: #7aab37d5;
      }
    }

    .el-login-fotter {
      position: fixed;
      bottom: 0;
      height: 40px;
      line-height: 40px;
      color: #fff;
      font-size: 12px;
      font-family: Arial;
      letter-spacing: 1px;
    }
  }
</style>
