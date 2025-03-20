<template>
  <div class="page-title" id="pageContents">
    <ul>
      <li v-for="item in leftMune" :key="item.id">
        <router-link :to="{ name: item.name }" :class="item.name == hash?'active':''">{{item.text}}</router-link>
      </li>
    </ul>
  </div>
</template>

<script>
  export default {
    name: 'Left',
    data() {
      return {
        leftMune: [
          {
            name: 'personal',
            text: '个人资料',
          },
          {
            name: 'password',
            text: '重置密码',
          },
          {
            name: 'groups',
            text: '我的小组',
          },
          {
            name: 'apply',
            text: '我的加入',
          },
          {
            name: 'article',
            text: '我的发帖',
          },
          {
            name: 'information',
            text: '我的动态',
          },
          {
            name: 'articleCollect',
            text: '我的收藏',
          },
          {
            name: 'follow',
            text: '我的关注',
          },
          {
            name: 'leaves',
            text: '我的私信',
          },
          {
            name: 'reply',
            text: '私信回复',
          },
        ],
        hash: null,
      }
    },
    created(){
      this.getHash()
    },
    methods: {
      // 获取路径
      getHash() {
        this.hash = window.location.hash.substring(2); // 去掉前面的'#'和'/'
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
