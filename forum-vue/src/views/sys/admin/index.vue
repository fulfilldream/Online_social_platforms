<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryParams" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="名称" prop="name">
        <el-input
          v-model="queryParams.name"
          placeholder="请输入名称"
          clearable
          @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="手机号" prop="cellphone">
        <el-input
          v-model="queryParams.cellphone"
          placeholder="请输入手机号"
          clearable
          @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
          <el-button icon="el-icon-refresh" size="mini" @click="resetForm('queryParams')">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd">
            新增
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDeleteList">
            删除
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport">
            导出
        </el-button>
      </el-col>
    </el-row>

    <el-table v-loading="loading" :data="tableData" ref="tableRef" @selection-change="handleSelectionChange">
      <el-table-column type="selection" fixed width="55" align="center" />
      <el-table-column label="ID" align="center" fixed prop="id" width="70" :show-overflow-tooltip='true'/>
      <el-table-column label="用户名" align="center" prop="username" min-width="120" :show-overflow-tooltip='true'/>
      <el-table-column label="名称" align="center" prop="name" min-width="120" :show-overflow-tooltip='true'/>
      <el-table-column label="头像" align="center" prop="avatar" width="70">
        <template slot-scope="scope">
          <el-image :src="scope.row.avatar" style="width: 50px; height: 50px; margin-top: 5px;"></el-image>
        </template>
      </el-table-column>
      <el-table-column label="性别" align="center" prop="sex" min-width="120" :show-overflow-tooltip='true'/>
      <el-table-column label="邮箱" align="center" prop="email" min-width="120" :show-overflow-tooltip='true'/>
      <el-table-column label="手机号" align="center" prop="cellphone" min-width="120" :show-overflow-tooltip='true'/>
      <el-table-column label="身份证" align="center" prop="identity" min-width="120" :show-overflow-tooltip='true'/>
      <el-table-column label="地址" align="center" prop="address" min-width="120" :show-overflow-tooltip='true'/>
      <el-table-column label="注册时间" align="center" prop="registerTime" min-width="120" :show-overflow-tooltip='true'/>
      <el-table-column label="操作" align="center" fixed="right" width="140" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)">
              编辑
          </el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)">
              删除
          </el-button>
        </template>
      </el-table-column>
    </el-table>

    <el-pagination
      layout="total, sizes, prev, pager, next, jumper"
      background
      v-show="total>0"
      :total="total"
      :current-page="queryParams.page"
      :page-size="queryParams.limit"
      :page-sizes="[10, 20, 30, 50]"
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange">
    </el-pagination>

    <!-- 添加\编辑 用户 对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="700px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" size="small" label-width="80px">
        <el-form-item label="用户名" prop="username">
          <el-input v-model="form.username" :disabled="single" placeholder="请输入用户名" clearable/>
        </el-form-item>
        <el-form-item label="密码" prop="password">
          <el-input v-model="form.password" type="password" placeholder="请输入密码" clearable/>
        </el-form-item>
        <el-form-item label="名称" prop="name">
          <el-input v-model="form.name" placeholder="请输入名称" clearable/>
        </el-form-item>
        <el-form-item label="头像" prop="avatar">
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
          <el-input v-model="form.email" placeholder="请输入邮箱" clearable/>
        </el-form-item>
        <el-form-item label="手机号" prop="cellphone">
          <el-input v-model="form.cellphone" placeholder="请输入手机号" clearable/>
        </el-form-item>
        <el-form-item label="身份证" prop="identity">
          <el-input v-model="form.identity" placeholder="请输入身份证" clearable/>
        </el-form-item>
        <el-form-item label="地址" prop="address">
          <el-input v-model="form.address" placeholder="请输入地址" clearable/>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" size="small" @click="submitForm">确 定</el-button>
        <el-button size="small" @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
import { dataUser, dynamicListUser, listLimitUser, countUser, dynamicCountUser, allUser, getUser, detailsGetUser, dynamicGetUser, addUser, editUser, delUser, delListUser } from "@/api/user";

export default {
  name: "User",
  computed: {
      ...mapGetters([
          'userId',
      ])
  },
  data() {
    // 表单数据空值效验
    const validateData = (rule, value, callback) => {
        if (value == null || value.length == 0) {
            callback(new Error('必填项不能为空'));
        } else {
            callback();
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
      uploadImgUrl: process.env.VUE_APP_BASE_API + "/uploadImgFile",
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 表格数据
      tableData: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        page: 1,
        limit: 10,
        username: null,
        sex: null,
        cellphone: null,
        name: null,
        role: 5,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        id: [{ required: true, trigger: 'blur', validator: validateNumberData }],
        username: [{ required: true, trigger: 'blur', validator: validateData }],
        password: [{ required: true, trigger: 'blur', validator: validateData }],
        sex: [{ required: true, trigger: 'blur', validator: validateData }],
        email: [{ required: true, trigger: 'blur', validator: validateData }],
        cellphone: [{ required: true, trigger: 'blur', validator: validateData }],
        address: [{ required: true, trigger: 'blur', validator: validateData }],
        name: [{ required: true, trigger: 'blur', validator: validateData }],
        registerTime: [{ required: true, trigger: 'blur', validator: validateData }],
        role: [{ required: true, trigger: 'blur', validator: validateNumberData }],
        avatar: [{ required: true, trigger: 'blur', validator: validateData }],
        token: [{ required: true, trigger: 'blur', validator: validateData }],
        identity: [{ required: true, trigger: 'blur', validator: validateData }],
      }
    };
  },
  created() {
     this.getData()
  },
  watch: {
    '$route': 'getData'
  },
  methods: {
    /** 查询用户分页数据 */
    getData() {
      this.loading = true;
      dataUser(this.queryParams).then(response => {
         this.tableData = response.data
         this.total = response.count
         this.loading = false
      });
    },
    // 分页数据条数监听
    handleSizeChange(val) {
        this.loading = true
        this.queryParams.limit = val
        this.getData()
    },
    // 分页数据跳转监听
    handleCurrentChange(val) {
       this.loading = true
       this.queryParams.page = val
       this.getData()
    },
    // 搜索按钮操作
    handleQuery() {
       this.queryParams.page = 1
       this.getData()
    },
    // 重置按钮操作
    resetForm(formName) {
       this.$nextTick(() => {
           this.$refs[formName].resetFields()
       })
       this.handleQuery()
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
       this.ids = selection.map(item => item.id)
       this.single = selection.length!==1
       this.multiple = !selection.length
    },
    // 取消按钮
    cancel() {
       this.open = false;
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        username: null,
        password: null,
        sex: null,
        email: null,
        cellphone: null,
        address: null,
        name: null,
        registerTime: null,
        role: null,
        avatar: null,
        token: null,
        identity: null
      };
      this.$nextTick(() => {
        this.$refs['form'].clearValidate()
      })
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset()
      this.form.sex = '男'
      this.single = false
      this.open = true
      this.title = "添加用户"
    },
    /** 编辑按钮操作 */
    handleUpdate(row) {
      this.reset()
      const id = row.id || this.ids
      getUser(id).then(response => {
        this.form = response.data;
        this.single = true
        this.open = true
        this.title = "编辑用户"
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            editUser(this.form).then(response => {
              this.$message.success('编辑成功')
              this.open = false
              this.getData()
            });
          } else {
            this.form.role = 5
            addUser(this.form).then(response => {
              this.$message.success('新增成功')
              this.open = false;
              this.getData()
            });
          }
        }
      });
    },
    // 单个删除按钮操作
    handleDelete(row) {
       this.$confirm('确定删除吗?', '提示', {
           confirmButtonText: '确定',
           cancelButtonText: '取消',
           type: 'warning'
       }).then(() => {
           return delUser(row.id)
       }).then(() => {
           this.getData()
           this.$message.success('删除成功')
       }).catch(() => {
       });
    },
    // 批量删除按钮操作
    handleDeleteList(row) {
       this.$confirm('确定删除吗?', '提示', {
           confirmButtonText: '确定',
           cancelButtonText: '取消',
           type: 'warning'
       }).then(() => {
           return delListUser(this.ids)
       }).then(() => {
           this.getData()
           this.$message.success('删除成功');
       }).catch(() => {
       });
    },
    // 导出表格
    handleExport() {
       import('@/vendor/Export2Excel').then(excel => {
           // 表格名称
           const columnNames = ['用户ID','用户名','密码','性别','邮箱','手机号','地址','名称','注册时间','角色','头像','令牌','身份证'];
           // 表格属性
           const headerProps = ['id','username','password','sex','email','cellphone','address','name','registerTime','role','avatar','token','identity'];
           // 表格数据
           allUser().then(response => {
               const formatData = response.data
               const data = this.formatJson(headerProps, formatData)
               excel.export_json_to_excel({
                   header: columnNames,
                   data,
                   filename: this.filename,
                   autoWidth: this.autoWidth,
                   bookType: this.bookType
               });
           });
       })
    },
    formatJson(filterVal, jsonData) {
        return jsonData.map(v => filterVal.map(j => {
            if (j === 'timestamp') {
                return parseTime(v[j]);
            } else {
                return v[j];
            }
        }))
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
      this.form.avatar = process.env.VUE_APP_BASE_API + res.data
    },
  }
};
</script>
