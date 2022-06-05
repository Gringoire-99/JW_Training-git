<template>
  <div class="container-fluid">
    <navigate class="nav"></navigate>
    <router-link to="/login">登录</router-link>
    <router-link to="/bookManagement">图书管理</router-link>
    <router-view></router-view>
  </div>
</template>

<script>
import Navigate from "@/components/Navigate";
export default {
  name: 'App',
  components: {
    Navigate
  },
  data() {
    return {}
  },
  methods: {},
  mounted() {
  }

}
</script>

<style>

.nav {
  float: left;
}
</style>
