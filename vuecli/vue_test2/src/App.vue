<template>
  <div class="container-fluid">
    <book-list></book-list>
    <search-pane>
      <template v-slot:request>
        <request-pane></request-pane>
      </template>
    </search-pane>
  </div>
</template>

<script>
import bookList from "@/components/BookList";
import SearchPane from "@/components/SearchPane";
import RequestPane from "@/components/RequestPane";
export default {
  name: 'App',
  components: {
    RequestPane,
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

</style>
