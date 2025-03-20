<template>
  <div class="dashboard-editor-container">

    <el-alert
      style="margin: 30px 0px;"
      title="热烈庆祝本站成立"
      type="success"
      description="欢迎您"
      show-icon>
    </el-alert>

    <el-row :gutter="32">
      <el-col :xs="24" :sm="24" :lg="6">
        <div class="chart-wrapper" style="padding: 0px;">
          <box-card/>
        </div>
      </el-col>
      <el-col :xs="24" :sm="24" :lg="14">
        <div class="chart-wrapper" style="padding: 0px;">
          <pie-chart/>
        </div>
      </el-col>
      <el-col :xs="24" :sm="24" :lg="14">
        <div class="chart-wrapper" style="padding: 0px;">
          <line-chart/>
        </div>
      </el-col>
    </el-row>

  </div>
</template>

<script>
  import LineChart from './components/LineChart'
  import PieChart from './components/PieChart'
  import BoxCard from './components/BoxCard'

  export default {
    name: 'DashboardAdmin',
    components: {
      LineChart,
      PieChart,
      BoxCard,
    },
    data() {
      return {
        value: new Date()
      }
    }
  }
</script>

<style lang="scss" scoped>
  .dashboard-editor-container {
    padding: 32px;
    background-color: rgb(240, 242, 245);
    position: relative;

    .github-corner {
      position: absolute;
      top: 0px;
      border: 0;
      right: 0;
    }

    .chart-wrapper {
      background: #fff;
      padding: 16px 16px 0;
      margin-bottom: 32px;
    }
  }

  @media (max-width: 1024px) {
    .chart-wrapper {
      padding: 8px;
    }
  }
</style>
