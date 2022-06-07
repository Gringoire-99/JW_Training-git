<template>
  <div id="BookItem">
    <div class="hvr-grow-shadow hvr-back-pulse">
      <span>{{ book.bookID }}</span>
      <span>{{ book.bookName }}</span>
      <span>{{ book.bookAuthor }}</span>
      <span>{{ book.bookPrice }}</span>
      <span>{{ book.bookNum }}</span>
      <span>{{ book.borrowNum }}</span>
      <img src="../../assets/modify.png" @click="modify">
    </div>

  </div>
</template>

<script>
export default {
  name: "BookItem",
  //读取参数book的属性删除标签
  props: ["book"],
  methods: {
    modify() {
      console.log("修改")
    }
  }
}
</script>

<style scoped>
img {
  width: 25px;
  height: 25px;
  float: right;
}

img:hover {
  border-color: #1575d7;
  border-style: solid;
  border-width: 1px;
  margin: 0 auto;
}


/*#BookItem {*/
/*  overflow: hidden;*/
/*  height: 25px;*/
/*  line-height: 25px;*/
/*}*/

span {
  margin: 10px;
  /*width: 40px;*/
  /*height: 20px;*/
}
</style>