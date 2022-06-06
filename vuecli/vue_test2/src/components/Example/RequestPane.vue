<template>
    <button @click="test">发送请求</button>
</template>

<script>

export default {
  name: "RequestPane",
  methods:{
    test(){
      // 标记/host/表示要被代理服务器发送到目的服务器
      this.$store.dispatch('getBookList')
    }
  }
}
</script>

<style scoped>
button{
  margin-left: 5px;
}
</style>