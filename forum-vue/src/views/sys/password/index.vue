<template>
  <div class="app-container">
    <div class="el-card">
      <div class="el-card__header">
        <div class="clearfix"><strong>重置密码</strong></div>
      </div>
      <div class="el-card__body">
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
</template>

<script>
  import { mapGetters } from 'vuex'
  import { getUser, editUser } from '@/api/user'

  export default {
    computed: {
      ...mapGetters([
        'userId'
      ])
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
