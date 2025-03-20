<template>
  <div class="wrapper">
    <Header/>

    <div class="clear blank"></div>

    <article>
      <div class="page whitebg">

        <Left/>

        <div class="page-box">
          <h2 class="page-box-title">重置密码</h2>
          <div class="page-box-content">
            <el-form :model="form" :rules="rules" ref="form" label-width="110px">
              <el-form-item label="id" prop="id" style="display: none;">
                <el-input v-model="form.id" ref="id" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="用户名" prop="username">
                <el-input v-model="form.username" ref="username" :disabled="true" placeholder="请输入用户名"
                          autocomplete="off" clearable></el-input>
              </el-form-item>
              <el-form-item label="新密码" prop="password">
                <el-input v-model="form.password" type="password" placeholder="请输入密码"
                          autocomplete="off" clearable></el-input>
              </el-form-item>
              <el-form-item label="确认密码" prop="password2">
                <el-input v-model="form.password2" type="password" placeholder="请输入密码"
                          autocomplete="off" clearable></el-input>
              </el-form-item>
              <el-form-item size="large">
                <el-button type="primary" size="small" @click="editData">重置密码</el-button>
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
        if (value == null || value.length == 0) {
          callback(new Error('必填项不能为空'));
        } else {
          callback();
        }
      }
      return {
        form: {
        },
        rules: {
          // 要以数组形式展示
          username: [{ required: true, trigger: 'blur', validator: validateData }],
          password: [{ required: true, trigger: 'blur', validator: validateData }],
          password2: [{ required: true, trigger: 'blur', validator: validateData }]
        }
      }
    },
    created() {
      getUser(this.userId).then(response => {
        this.form = response.data
        this.form.password = '';
      })
    },
    methods: {
      editData() {
        this.$refs.form.validate(valid => {
          if (valid) {
            if (this.form.password === this.form.password2) {
              editUser(this.form).then(response => {
                this.$message.success('重置成功')
              })
            } else {
              this.$message.error('两次密码输入不一致')
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


