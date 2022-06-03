<template>
  <div>
    <span>关键词<input v-model="keyWord" type="text">
    </span>
  </div>
</template>

<script>
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
        this.$emit('search', newKeyWord)
      }
    }
  },
}
</script>

<style scoped>

</style>