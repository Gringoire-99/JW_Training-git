<template>
  <div>
    <book-list :key-word="keyWord"></book-list>
    <search-pane @search="search"></search-pane>
  </div>
</template>

<script>
import bookList from "@/components/BookList";
import SearchPane from "@/components/SearchPane";

export default {
  name: 'App',
  components: {
    SearchPane,
    bookList
  },
  data() {
    return {
      keyWord: '',
    }
  },
  //keyWord 来源：搜索子组件的emit， 绑定：列表子组件的keyWord
  methods: {
    search(keyWord) {
      this.keyWord = keyWord
    }
  }
}
</script>

<style>
#app {
}
</style>
