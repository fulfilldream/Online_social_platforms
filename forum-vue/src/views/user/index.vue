<template>
  <div class="wrapper">
    <Header/>

    <div class="clear blank"></div>

    <article>
      <el-row>
        <el-col :span="16" style="padding-right: 10px;">
          <el-carousel indicator-position="outside" height="400px" style="width: 100%;">
            <el-carousel-item v-for="item in bannerList" :key="item.id">
              <img :src="item.img" style="width: 100%; height: 100%;">
            </el-carousel-item>
          </el-carousel>
        </el-col>
        <el-col :span="8">
          <div class="headline-box whitebg" style="width: 100%;">
          <div class="headline-news">
            <h2 class="headline-news-title" v-if="newList.length != 0">
              <span>最新发布</span>
              <router-link :to="{ name: 'article-details', params: { id: newList[0].id} }">
                {{newList[0].title}}
              </router-link>
            </h2>
            <p class="headline-news-smalltext" v-if="newList.length != 0">
              {{newList[0].summary}}
            </p>
            <ul class="headline-news-list">
              <li v-for="(item, index) in newList" :key="item.id" v-if="index != 0">
                <router-link :to="{ name: 'article-details', params: { id: item.id} }">
                  {{item.title}}
                </router-link>
              </li>
            </ul>
          </div>
        </div>
        </el-col>
      </el-row>

      <div class="clear blank"></div>

      <div class="tuijian-news box whitebg tab-num01">
        <div class="gd-box">
          <ul id="tab">
            <li class="tab-current">热门文章</li>
          </ul>
        </div>
        <div id="tab-content">
          <section>
            <div class="tuijian-news-pic" v-if="hotList.length != 0">
              <i>
                <router-link :to="{ name: 'article-details', params: { id: hotList[0].id} }">
                  <img :src="hotList[0].img" style="width: 339px; height: 190px;"><span>推荐</span>
                </router-link>
              </i>
              <h2>
                <router-link :to="{ name: 'article-details', params: { id: hotList[0].id} }">
                  {{hotList[0].title}}
                </router-link>
              </h2>
              <p>{{hotList[0].summary}}</p>
              <router-link to="/article-list" class="btn-blue-border">阅读更多</router-link>
            </div>

            <div class="tuijian-news-list">
              <ul>
                <li v-for="(item, index) in hotList" :key="item.id" v-if="index != 0">
                  <router-link :to="{ name: 'article-details', params: { id: item.id} }">
                      <span>
                        <img :src="item.img" style="width: 70px; height: 70px;">
                      </span>
                    <h3>{{item.title}}</h3>
                    <p>{{item.summary}}</p>
                  </router-link>
                </li>
              </ul>
            </div>
            <span class="tab-a-more">
              <router-link to="/article-list"><i></i><i></i><i></i></router-link>
            </span>
          </section>
        </div>
      </div>

      <div class="clear blank"></div>

      <div class="pics box whitebg tab-num02">
        <div class="gd-box">
          <ul id="tab">
            <li class="tab-current">动态资讯</li>
          </ul>
        </div>
        <div id="tab-content">
          <section>
            <div class="pic-list-img">
              <ul>
                <li v-if="informationList.length != 0">
                  <router-link :to="{ name: 'information-details', params: { id: informationList[0].id} }">
                    <i><img :src="informationList[0].img" style="width: 100%; height: 100%;"><em>受欢迎的</em></i>
                    <span>{{informationList[0].title}}</span>
                  </router-link>
                </li>
                <li v-for="(item, index) in informationList" :key="item.id" v-if="index != 0">
                  <router-link :to="{ name: 'information-details', params: { id: item.id} }">
                    <i><img :src="item.img" style="width: 205px; height: 115px;"></i>
                    <span>{{item.title}}</span>
                  </router-link>
                </li>
              </ul>
            </div>
            <span class="tab-a-more">
                <router-link to="/information-list"><i></i><i></i><i></i></router-link>
              </span>
          </section>
        </div>
      </div>

      <div class="clear blank"></div>

      <div class="news box whitebg tab-num03">
        <div class="gd-box">
          <ul id="tab">
            <li class="tab-current">通知公告</li>
          </ul>
        </div>
        <div id="tab-content">
          <section>
            <div class="news-zuixin">
              <ul>
                <li v-for="item in noticeList" :key="item.id">
                  <section>
                    <router-link :to="{ name: 'notice-details', params: { id: item.id} }" class="news-zuixin-pic">
                      <img :src="item.img" style="height: 62px; width: 100%">
                    </router-link>
                    <h2>
                      <router-link :to="{ name: 'notice-details', params: { id: item.id} }" style="width: 100%;" class="news-zuixin-pic">
                        {{item.title}}
                      </router-link>
                    </h2>
                    <p>{{item.summary}}</p>
                    <span>
                       <router-link :to="{ name: 'notice-details', params: { id: item.id} }">
                        {{item.creatTime}}
                      </router-link>
                    </span>
                  </section>
                </li>
              </ul>
            </div>
            <span class="tab-a-more">
                <router-link to="/notice-list"><i></i><i></i><i></i></router-link>
            </span>
          </section>
        </div>
      </div>

      <div class="blank clear"></div>

      <div class="whitebg box tags">
        <div class="news-title">
          <h2>标签分类</h2>
          <span class="tab-a-more">
            <router-link to="/Article-list"><i></i><i></i><i></i></router-link>
          </span>
        </div>
        <div style="padding: 0px 20px; padding-bottom: 20px;">
          <ul>
            <li v-for="item in articleTypeList" :key="item.id">
              <router-link style="height: 35px;"
                           :to="{ name: 'article-category', params: { id: item.id} }">{{item.name}}</router-link>
            </li>
          </ul>
        </div>
      </div>

      <div class="blank clear"></div>
    </article>

    <Footer/>
  </div>
</template>

<script>
  import { mapGetters } from 'vuex'
  import { listBanner } from '@/api/banner'
  import { listLimitNotice } from '@/api/notice'
  import { listLimitInformation } from '@/api/information'
  import { listLimitArticle } from '@/api/article'
  import { allArticleType } from '@/api/articleType'
  import Header from './common/Header.vue'
  import Footer from './common/Footer.vue'

  export default {
    computed: {
      ...mapGetters([
        'userId'
      ])
    },
    components: {
      Header,
      Footer
    },
    data() {
      return {
        bannerList: [],
        noticeList: [],
        informationList: [],
        newList: [],
        hotList: [],
        articleTypeList: [],
      }
    },
    created() {
      this.listBanner()
      this.listLimitNotice()
      this.listLimitInformation()
      this.listLimitArticle()
      this.allArticleType()
    },
    methods: {
      listBanner() {
        const data = {}
        data.status = 1
        listBanner(data).then(response => {
          this.bannerList = response.data
        })
      },
      allArticleType() {
        allArticleType().then(response => {
          this.articleTypeList = response.data
        })
      },
      listLimitArticle() {
        listLimitArticle('id', 'desc', 9).then(response => {
          this.newList = response.data
        })
        listLimitArticle('read_count', 'desc', 7).then(response => {
          this.hotList = response.data
        })
      },
      listLimitNotice() {
        listLimitNotice('read_count', 'desc', 6).then(response => {
          this.noticeList = response.data
        })
      },
      listLimitInformation() {
        listLimitInformation('read_count', 'desc', 7).then(response => {
          this.informationList = response.data
        })
      },
    }
  }
</script>


