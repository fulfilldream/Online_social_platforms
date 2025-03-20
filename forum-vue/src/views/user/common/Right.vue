<template>
  <aside class="side-section right-box">
    <div class="whitebg cloud">
      <h2 class="side-title">标签分类</h2>
      <ul>
        <li>
          <router-link style="height: 30px;" to="/article-list">全部</router-link>
        </li>
        <li v-for="item in typeList" :key="item.id">
          <router-link style="height: 30px;"
                       :to="{ name: 'article-category', params: { id: item.id} }">
            {{item.name}}
          </router-link>
        </li>
      </ul>
    </div>

    <div class="blank clear"></div>

    <div class="whitebg tuijian">
      <h2 class="side-title">最新发布</h2>
      <ul>
        <li v-for="item in newList" :key="item.id">
          <router-link :to="{ name: 'article-details', params: { id: item.id} }">
            <i><img :src="item.img"></i>
            <p>{{item.title}}</p>
          </router-link>
        </li>
      </ul>
    </div>

    <div class="blank clear"></div>

    <div class="whitebg tuijian">
      <h2 class="side-title">热门推荐</h2>
      <ul>
        <li v-for="item in hotList" :key="item.id">
          <router-link :to="{ name: 'article-details', params: { id: item.id} }">
            <i><img :src="item.img"></i>
            <p>{{item.title}}</p>
          </router-link>
        </li>
      </ul>
    </div>

    <div class="blank clear"></div>
  </aside>
</template>

<script>
  import { listLimitArticle } from '@/api/article'
  import { allArticleType } from '@/api/articleType'

  export default {
    data() {
      return {
        newList: [],
        hotList: [],
        typeList: [],
      }
    },
    created() {
      this.allArticleType()
      this.listLimitArticle()
    },
    methods: {
      listLimitArticle() {
        listLimitArticle('read_count', 'desc', 5).then(response => {
          this.hotList = response.data
        })
        listLimitArticle('id', 'desc', 5).then(response => {
          this.newList = response.data
        })
      },
      allArticleType() {
        this.loading = true
        allArticleType().then(response => {
          this.typeList = response.data
          this.loading = false
        })
      },
    }
  }
</script>

<style scoped>
  .active{
    background: #1487f4;
    color: #fff;
  }
</style>
