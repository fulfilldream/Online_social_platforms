<template>
  <div class="wrapper">
    <Header/>

    <div class="clear blank"></div>

    <article>
      <div class="page whitebg">

        <Left/>

        <div class="page-box">
          <h2 class="page-box-title">我的私信</h2>
          <div class="page-box-content">
            <div>
              <el-form :model="queryParams" ref="queryParams" size="small" :inline="true" v-show="showSearch" label-width="68px">
                <el-form-item label="私信内容" prop="content">
                  <el-input
                    v-model="queryParams.content"
                    placeholder="请输入内容"
                    clearable
                    @keyup.enter.native="handleQuery"/>
                </el-form-item>
                <el-form-item>
                  <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
                  <el-button icon="el-icon-refresh" size="mini" @click="resetForm('queryParams')">重置</el-button>
                </el-form-item>
              </el-form>

              <el-table v-loading="loading" :data="tableData" ref="tableRef" @selection-change="handleSelectionChange">
                <el-table-column label="私信对象" align="center" prop="staff.name" min-width="120" :show-overflow-tooltip='true'/>
                <el-table-column label="私信内容" align="center" prop="content" min-width="120" :show-overflow-tooltip='true'/>
                <el-table-column label="私信时间" align="center" prop="creatTime" min-width="120" :show-overflow-tooltip='true'/>
                <el-table-column label="回复内容" align="center" prop="replyCon" min-width="120" :show-overflow-tooltip='true'/>
                <el-table-column label="回复时间" align="center" prop="replyTime" min-width="120" :show-overflow-tooltip='true'/>
                <el-table-column label="操作" align="center" fixed="right" width="100" class-name="small-padding fixed-width">
                  <template slot-scope="scope">
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
  import { dataLeaves, dynamicListLeaves, listLimitLeaves, countLeaves, dynamicCountLeaves, allLeaves, getLeaves, detailsGetLeaves, dynamicGetLeaves, addLeaves, editLeaves, delLeaves, delListLeaves } from "@/api/leaves";
  import { allUser } from '@/api/user'
  import Header from '../common/Header.vue'
  import Footer from '../common/Footer.vue'
  import Left from '../common/Left.vue'

  export default {
    name: "Leaves",
    computed: {
      ...mapGetters([
        'userId',
      ])
    },
    components: {
      Header,
      Footer,
      Left,
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
          userId: null,
          content: null,
          replyCon: null,
          staffId: null
        },
        // 表单参数
        form: {},
        // 表单校验
        rules: {
          id: [{ required: true, trigger: 'blur', validator: validateNumberData }],
          userId: [{ required: true, trigger: 'blur', validator: validateNumberData }],
          content: [{ required: true, trigger: 'blur', validator: validateData }],
          creatTime: [{ required: true, trigger: 'blur', validator: validateData }],
          replyCon: [{ required: true, trigger: 'blur', validator: validateData }],
          replyTime: [{ required: true, trigger: 'blur', validator: validateData }],
          staffId: [{ required: true, trigger: 'blur', validator: validateNumberData }],
        }
      };
    },
    created() {
      this.getData()
      this.allUser()
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
      /** 查询分页数据 */
      getData() {
        this.loading = true;
        this.queryParams.userId = this.userId
        dataLeaves(this.queryParams).then(response => {
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
          userId: null,
          content: null,
          creatTime: null,
          replyCon: null,
          replyTime: null,
          staffId: null
        };
        this.$nextTick(() => {
          this.$refs['form'].clearValidate()
        })
      },
      // 单个删除按钮操作
      handleDelete(row) {
        this.$confirm('确定删除吗?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          return delLeaves(row.id)
        }).then(() => {
          this.getData()
          this.$message.success('删除成功')
        }).catch(() => {
        });
      },
    }
  };
</script>


