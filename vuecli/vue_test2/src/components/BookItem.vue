<template>
  <div id="BookItem">
    <span>{{ book.bookID }}</span>
    <span>{{ book.bookName }}</span>
    <span>{{ book.bookAuthor }}</span>
    <span>{{ book.bookPrice }}</span>
    <span>{{ book.bookNum }}</span>
    <span>{{ book.borrowNum }}</span>
    <img src="../assets/modify.png">
  </div>
</template>

<script>
export default {
  name: "BookItem",
  //读取参数book的属性删除标签
  props: ["book"],
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

#BookItem:hover {
  background-color: rgba(191, 191, 199, 0.31);
}

#BookItem {
  overflow: hidden;
  height: 25px;
  line-height: 25px;
}

span {
  margin: 10px;
  width: 40px;
  height: 20px;
  padding-right: 5px;
}
</style>