<template>
  <div class="container-fluid">
    <navigate class="nav"></navigate>
    <router-link active-class="activated" to="/homePage">登录</router-link>
    <router-link active-class="activated" to="/bookManagement">图书管理</router-link>
    <router-link active-class="activated" to="/help">帮助</router-link>
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
.activated{
  border-style: solid;
  border-color: #2098D1;
}
.nav {
  float: left;
}
</style>
