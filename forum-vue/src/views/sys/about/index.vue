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
      <el-form-item label="状态" prop="status">
        <el-select v-model="queryParams.status" placeholder="请选择状态" filterable clearable>
            <el-option label="待展示" value="0"></el-option>
            <el-option label="已展示" value="1"></el-option>
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
      <el-table-column label="名称" align="center" prop="name" min-width="120" :show-overflow-tooltip='true'/>
      <el-table-column label="展示图" align="center" prop="img" width="220">
        <template slot-scope="scope">
          <el-image :src="scope.row.img" style="width: 200px; height: 100px; margin-top: 5px;"></el-image>
        </template>
      </el-table-column>
      <el-table-column label="状态" align="center" prop="status" min-width="100" :show-overflow-tooltip='true'>
        <template slot-scope="scope">
          <el-tag v-if="scope.row.status === false" :type="'success'" disable-transitions>未展示</el-tag>
          <el-tag v-if="scope.row.status === true" :type="'primary'" disable-transitions>已展示</el-tag>
        </template>
      </el-table-column>
      <el-table-column label="电话" align="center" prop="cellphone" min-width="120" :show-overflow-tooltip='true'/>
      <el-table-column label="邮箱" align="center" prop="email" min-width="120" :show-overflow-tooltip='true'/>
      <el-table-column label="地址" align="center" prop="address" min-width="120" :show-overflow-tooltip='true'/>
      <el-table-column label="成立时间" align="center" prop="creatDate" min-width="120" :show-overflow-tooltip='true'/>
      <el-table-column label="简介" align="center" prop="introduce" min-width="120" :show-overflow-tooltip='true'/>
      <el-table-column label="操作" align="center" width="210" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleSet(scope.row)">
            设为展示
          </el-button>
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

  </div>
</template>

<script>
import { mapGetters } from 'vuex'
import { setAbout, dataAbout, dynamicListAbout, listLimitAbout, countAbout, dynamicCountAbout, allAbout, getAbout, detailsGetAbout, dynamicGetAbout, addAbout, editAbout, delAbout, delListAbout } from "@/api/about";

export default {
  name: "About",
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
        cellphone: null,
        creatDate: null,
        status: null,
        name: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        id: [{ required: true, trigger: 'blur', validator: validateNumberData }],
        cellphone: [{ required: true, trigger: 'blur', validator: validateData }],
        email: [{ required: true, trigger: 'blur', validator: validateData }],
        address: [{ required: true, trigger: 'blur', validator: validateData }],
        creatDate: [{ required: true, trigger: 'blur', validator: validateData }],
        status: [{ required: true, trigger: 'blur', validator: validateNumberData }],
        introduce: [{ required: true, trigger: 'blur', validator: validateData }],
        img: [{ required: true, trigger: 'blur', validator: validateData }],
        name: [{ required: true, trigger: 'blur', validator: validateData }],
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
    /** 查询关于我们分页数据 */
    getData() {
      this.loading = true;
      dataAbout(this.queryParams).then(response => {
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
        cellphone: null,
        email: null,
        address: null,
        creatDate: null,
        status: null,
        introduce: null,
        img: null,
        name: null
      };
      this.$nextTick(() => {
        this.$refs['form'].clearValidate()
      })
    },
    /** 新增按钮操作 */
    handleAdd() {
        this.$router.push({ path: '/sys-basics/about/add'})
    },
    /** 编辑按钮操作 */
    handleUpdate(row) {
        this.$router.push({ path: '/sys-basics/about/edit/' + row.id })
    },
    // 展示按钮操作
    handleSet(row) {
      row.status = 1
      setAbout(row).then(response => {
        this.getData()
        this.$message.success('设置成功')
      })
    },
    // 单个删除按钮操作
    handleDelete(row) {
       this.$confirm('确定删除吗?', '提示', {
           confirmButtonText: '确定',
           cancelButtonText: '取消',
           type: 'warning'
       }).then(() => {
           return delAbout(row.id)
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
           return delListAbout(this.ids)
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
           const columnNames = ['关于我们ID','电话','邮箱','地址','成立时间','状态','简介','图片','名称'];
           // 表格属性
           const headerProps = ['id','cellphone','email','address','creatDate','status','introduce','img','name'];
           // 表格数据
           allAbout().then(response => {
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
