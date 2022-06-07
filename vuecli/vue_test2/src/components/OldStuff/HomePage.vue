<template>
  <div>
    <h1>主页.....</h1>
    <router-link to="/homePage/login">请登录</router-link>
    <router-link to="/homePage/register">注册</router-link>
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  name: "HomePage"
}
</script>

<style scoped>
  div{
  }
</style>