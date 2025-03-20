<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryParams" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="标题" prop="title">
        <el-input
          v-model="queryParams.title"
          placeholder="请输入标题"
          clearable
          @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="类型" prop="articleTypeId">
        <el-select v-model="queryParams.articleTypeId" placeholder="请选择类型" filterable clearable>
            <el-option v-for="item in articleTypeList" :key="item.id" :label="item.name" :value="item.id">
            </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="小组" prop="groupsId">
        <el-select v-model="queryParams.groupsId" placeholder="请选择小组" filterable clearable>
            <el-option v-for="item in groupsList" :key="item.id" :label="item.name" :value="item.id">
            </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="审核状态" prop="status">
        <el-select v-model="queryParams.status" placeholder="请选择审核状态" filterable clearable>
            <el-option label="待审核" value="0"></el-option>
            <el-option label="通过" value="1"></el-option>
            <el-option label="驳回" value="2"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
          <el-button icon="el-icon-refresh" size="mini" @click="resetForm('queryParams')">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
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
      <el-table-column label="标题" align="center" prop="title" min-width="120" :show-overflow-tooltip='true'/>
      <el-table-column label="摘要" align="center" prop="summary" min-width="120" :show-overflow-tooltip='true'/>
      <el-table-column label="展示图" align="center" prop="img" width="70">
        <template slot-scope="scope">
          <el-image :src="scope.row.img" style="width: 50px; height: 50px; margin-top: 5px;"></el-image>
        </template>
      </el-table-column>
      <el-table-column label="小组" align="center" prop="groups.name" min-width="120" :show-overflow-tooltip='true'/>
      <el-table-column label="类型" align="center" prop="articleType.name" min-width="120" :show-overflow-tooltip='true'/>
      <el-table-column label="浏览量" align="center" prop="readCount" min-width="120" :show-overflow-tooltip='true'/>
      <el-table-column label="点赞量" align="center" prop="likeCount" min-width="120" :show-overflow-tooltip='true'/>
      <el-table-column label="收藏量" align="center" prop="collectCount" min-width="120" :show-overflow-tooltip='true'/>
      <el-table-column label="发布者" align="center" prop="user.name" min-width="120" :show-overflow-tooltip='true'/>
      <el-table-column label="发布时间" align="center" prop="creatTime" min-width="120" :show-overflow-tooltip='true'/>
      <el-table-column label="审核状态" align="center" prop="status" min-width="100" :show-overflow-tooltip='true'>
          <template slot-scope="scope">
              <el-tag v-if="scope.row.status === 0" :type="'success'" disable-transitions>待审核</el-tag>
              <el-tag v-if="scope.row.status === 1" :type="'primary'" disable-transitions>通过</el-tag>
              <el-tag v-if="scope.row.status === 2" :type="'warning'" disable-transitions>驳回</el-tag>
          </template>
      </el-table-column>
      <el-table-column label="审核意见" align="center" prop="opinion" min-width="120" :show-overflow-tooltip='true'/>
      <el-table-column label="操作" align="center" fixed="right" width="240" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-position"
            @click="handleDetails(scope.row)">
              详情
          </el-button>
          <el-button
            v-if="scope.row.status === 0"
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)">
              审核
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

    <el-dialog :title="title" :visible.sync="open" width="700px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" size="small" label-width="80px">
        <el-form-item label="审核状态" prop="status">
          <el-radio v-model="form.status" label="1">通过</el-radio>
          <el-radio v-model="form.status" label="2">驳回</el-radio>
        </el-form-item>
        <el-form-item label="审核意见" prop="opinion">
          <el-input v-model="form.opinion" placeholder="请输入审核意见" clearable/>
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
import { dataArticle, dynamicListArticle, listLimitArticle, countArticle, dynamicCountArticle, allArticle, getArticle, detailsGetArticle, dynamicGetArticle, addArticle, editArticle, delArticle, delListArticle } from "@/api/article";
import { allUser } from '@/api/user'
import { allArticleType } from '@/api/articleType'
import { allGroups } from '@/api/groups'

export default {
  name: "Article",
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
      userList: [],
      articleTypeList: [],
      groupsList: [],
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
        title: null,
        userId: null,
        articleTypeId: null,
        groupsId: null,
        status: null,
      },
      // 表单参数
      form: {},
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
        groupsId: [{ required: true, trigger: 'blur', validator: validateNumberData }],
        status: [{ required: true, trigger: 'blur', validator: validateData }],
        opinion: [{ required: true, trigger: 'blur', validator: validateData }],
      }
    };
  },
  created() {
     this.getData()
     this.allUser()
     this.allArticleType()
     this.allGroups()
  },
  watch: {
    '$route': 'getData'
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
    allGroups(){
       this.loading = true
       allGroups().then(response => {
           this.groupsList = response.data
           this.loading = false
       })
    },
    /** 查询分页数据 */
    getData() {
      this.loading = true;
      dataArticle(this.queryParams).then(response => {
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
        title: null,
        content: null,
        summary: null,
        userId: null,
        creatTime: null,
        img: null,
        articleTypeId: null,
        readCount: null,
        collectCount: null,
        groupsId: null,
        status: null,
        opinion: null
      };
      this.$nextTick(() => {
         this.$refs['form'].clearValidate()
      })
    },
    /** 新增按钮操作 */
    handleAdd() {
        this.$router.push({ path: '/sys-article/article/add'})
    },
    /** 编辑按钮操作 */
    handleUpdate(row) {
      this.reset()
      this.form.id = row.id
      this.open = true
      this.title = "数据审核"
    },
    /** 详情按钮操作 */
    handleDetails(row) {
        this.$router.push({ path: '/sys-article/article/details/' + row.id })
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          editArticle(this.form).then(response => {
            this.$message.success('审核成功')
            this.open = false
            this.getData()
          });
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
           return delArticle(row.id)
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
           return delListArticle(this.ids)
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
           const columnNames = ['文章ID','标题','内容','摘要','发布者ID','发布时间','展示图','类型ID','浏览量','收藏量','小组ID','审核状态','审核意见'];
           // 表格属性
           const headerProps = ['id','title','content','summary','userId','creatTime','img','articleTypeId','readCount','collectCount','groupsId','status','opinion'];
           // 表格数据
           allArticle().then(response => {
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
  }
};
</script>
