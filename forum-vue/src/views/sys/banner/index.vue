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
      <el-form-item label="展示状态" prop="status">
        <el-select v-model="queryParams.status" placeholder="请选择展示状态" filterable clearable>
            <el-option label="未展示" value="0"></el-option>
            <el-option label="展示" value="1"></el-option>
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
      <el-table-column label="展示状态" align="center" prop="status" min-width="100">
        <template slot-scope="scope">
          <el-switch
            @change="handleSwitch(scope.row)"
            v-model="scope.row.status"
            active-color="#13ce66">
          </el-switch>
        </template>
      </el-table-column>
      <el-table-column label="简介" align="center" prop="introduce" min-width="120" :show-overflow-tooltip='true'/>
      <el-table-column label="操作" align="center" width="140" class-name="small-padding fixed-width">
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

  </div>
</template>

<script>
import { mapGetters } from 'vuex'
import { dataBanner, dynamicListBanner, listLimitBanner, countBanner, dynamicCountBanner, allBanner, getBanner, detailsGetBanner, dynamicGetBanner, addBanner, editBanner, delBanner, delListBanner } from "@/api/banner";

export default {
  name: "Banner",
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
        status: null,
        name: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        id: [{ required: true, trigger: 'blur', validator: validateNumberData }],
        img: [{ required: true, trigger: 'blur', validator: validateData }],
        status: [{ required: true, trigger: 'blur', validator: validateData }],
        name: [{ required: true, trigger: 'blur', validator: validateData }],
        introduce: [{ required: true, trigger: 'blur', validator: validateData }],
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
    /** 查询轮播图分页数据 */
    getData() {
      this.loading = true;
      dataBanner(this.queryParams).then(response => {
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
    // switch监听事项
    handleSwitch(row) {
      editBanner(row).then(response => {
        if (row.status) {
          this.$message.success('设为展示')
        } else {
          this.$message.success('取消展示')
        }
      })
    },
    // 取消按钮
    cancel() {
       this.open = false;
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        img: null,
        status: null,
        name: null,
        introduce: null
      };
      this.$nextTick(() => {
        this.$refs['form'].clearValidate()
      })
    },
    /** 新增按钮操作 */
    handleAdd() {
        this.$router.push({ path: '/sys-basics/banner/add'})
    },
    /** 编辑按钮操作 */
    handleUpdate(row) {
        this.$router.push({ path: '/sys-basics/banner/edit/' + row.id })
    },
    // 单个删除按钮操作
    handleDelete(row) {
       this.$confirm('确定删除吗?', '提示', {
           confirmButtonText: '确定',
           cancelButtonText: '取消',
           type: 'warning'
       }).then(() => {
           return delBanner(row.id)
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
           return delListBanner(this.ids)
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
           const columnNames = ['轮播图ID','图片','是否展示','名称','简介'];
           // 表格属性
           const headerProps = ['id','img','status','name','introduce'];
           // 表格数据
           allBanner().then(response => {
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
