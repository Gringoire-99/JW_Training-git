<template>
  <div>
    <h1>帮助目录</h1>
    <router-link :to="{
    path:'/help/detail',
    query:{
      msg:'hihao'
    }
    }">帮助1</router-link>
    <router-link :to="{
    path:'/help/detail',
    query:{
      msg:'hello'
    }
    }">帮助2</router-link>
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  name: "helpPage"
  ,
  data() {
    return {
      m1: {helpMsg: '点击导航跳转', helpImg: '我是帮助图片1'},
      m2: {helpMsg: '点击图片跳转', helpImg: '我是帮助图片2'}
    }
  }
}
</script>

<style scoped>

</style>