<template>
  <footer>
    <div class="footer box">
      <div class="wxbox">
        <ul>
          <li><span>@ 2025 {{about.name}}</span></li>
        </ul>
      </div>
      <div class="wxbox">
        <ul>
          <li>友情链接：<a v-for="item in linksList" :key="item.id" :href="item.links"
                       style="color: #777; margin-right: 10px;" target="_blank">{{item.name}}</a></li>
        </ul>
      </div>
    </div>
  </footer>
</template>

<script>
  import { dynamicGetAbout } from '@/api/about'
  import { allLinks } from '@/api/links'

  export default {
    name: 'Footer',
    data() {
      return {
        about: {},
        linksList: []
      }
    },
    created() {
      this.dynamicGetAbout()
      this.allLinks()
    },
    methods: {
      // 关于我们
      dynamicGetAbout() {
        const data = {}
        data.status = 1
        dynamicGetAbout(data).then(response => {
          this.about = response.data
        })
      },
      // 友情链接
      allLinks() {
        allLinks().then(response => {
          this.linksList = response.data
        })
      }
    }
  }
</script>

<style scoped>
  @import '~@/ui/css/base.css';
  @import '~@/ui/css/m.css';
  @import '~@/ui/css/swiper.min.css';
</style>
