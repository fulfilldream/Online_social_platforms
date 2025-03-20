<template>
  <div class="dashboard-container">
    <component :is="currentRole" />
  </div>
</template>

<script>

import adminDashboard from './admin'

export default {
  name: 'Home',
  components: { adminDashboard },
  data() {
    return {
      currentRole: 'adminDashboard'
    }
  }
}
</script>
