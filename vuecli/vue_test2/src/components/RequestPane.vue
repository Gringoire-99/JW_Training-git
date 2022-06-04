<template>
    <button @click="test">发送请求</button>
</template>

<script>
import axios from 'axios'

export default {
  name: "RequestPane",
  methods:{
    test(){
      axios.get('/host/http://localhost:8080/t1').then((response=>{
        console.log("请求成功，数据为："+response.data)
      }),error=>{
        console.log("请求失败，数据为："+error.message)
      })
    }
  }
}
</script>

<style scoped>
button{
  margin-left: 5px;
}
</style>