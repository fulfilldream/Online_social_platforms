<template>
  <div class="wrapper">
    <Header/>

    <div class="clear blank"></div>

    <article>
      <div class="page whitebg">
        <div class="page-box">
          <h2 class="page-box-title">关于我们</h2>
          <div class="page-box-content">
            <h2>
              <strong style="color: #409eff;">{{about.name}}</strong>
            </h2>
            <p>
              <img :src="about.img">
            </p>
            <h2>
              <strong style="color: #409eff;">平台简介</strong>
            </h2>
            <p>{{about.introduce}}</p>
            <h2>
              <strong style="color: #409eff;">联系我们</strong>
            </h2>
            <p>电话：{{about.cellphone}}</p>
            <p>邮箱：{{about.email}}</p>
            <p>地址：{{about.address}}</p>
            <p>成立时间：{{about.creatDate}}</p>
          </div>
        </div>
      </div>
    </article>

    <div class="clear blank"></div>

    <Footer/>
  </div>
</template>

<script>
  import { dynamicGetAbout } from '@/api/about'
  import Header from '../common/Header.vue'
  import Footer from '../common/Footer.vue'

  export default {
    components: {
      Header,
      Footer
    },
    data() {
      return {
        about: {},
      }
    },
    created() {
      this.dynamicGetAbout()
    },
    methods: {
      dynamicGetAbout() {
        const data = {}
        data.status = 1
        dynamicGetAbout(data).then(response => {
          this.about = response.data
        })
      },
    }
  }
</script>


