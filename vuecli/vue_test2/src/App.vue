<template>
  <div>
    <book-list></book-list>
    <search-pane></search-pane>
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
    }
  },
  methods: {
  },

}
</script>

<style>
#app {
}
</style>
