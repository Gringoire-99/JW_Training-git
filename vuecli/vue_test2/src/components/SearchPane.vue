<template>
  <div>
    <span>关键词<input v-model="keyWord" type="text"></span>
    <slot name="request"></slot>
  </div>
</template>

<script>
import pubsub from "pubsub-js"

export default {
  name: "SearchPane",
  data() {
    return {
      keyWord: ''
    }
  },
  watch: {
    //监听搜索内容，并实时发送给父组件
    keyWord: {
      immediate: true,
      handler(newKeyWord) {
        pubsub.publish('keyWord', newKeyWord);
      }
    }
  },
}
</script>

<style scoped>

</style>