<template>
  <div class="main">
    <book-list></book-list>
    <search-pane>
      <!--插入插槽-->
      <template v-slot:request>
        <request-pane></request-pane>
      </template>
    </search-pane>
  </div>
</template>

<script>
import bookList from "@/components/Example/BookList";
import SearchPane from "@/components/Example/SearchPane";
import RequestPane from "@/components/Example/RequestPane";

export default {
  name: "BookManagement",
  components: {
    RequestPane,
    SearchPane,
    bookList,
  },

}
</script>

<style scoped>
.main {
  float: right;
}
</style>