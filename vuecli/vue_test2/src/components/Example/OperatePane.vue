<template>
  <tr id="op" class="block col-md-4">
    <td id='bookID' @click="select($event)">ID</td>
    <td id="bookName" @click="select($event)">书名</td>
    <td id="bookAuthor" @click="select($event)">作者</td>
    <td id="bookPrice" @click="select($event)">价格</td>
    <td id="bookNum" @click="select($event)">库存数量</td>
    <td id="borrowNum" @click="select($event)">借阅数量</td>
    <td id="asc" @click="selectOrder($event)">↑</td>
    <td id="desc" @click="selectOrder($event)">↓</td>
  </tr>
</template>

<script>
export default {
  name: "OperatePane",
  data() {
    return {}
  },
  //给父组件发消息
  methods: {
    select(event) {
      this.$emit('select', event.target.id);
    },
    selectOrder(event) {
      this.$emit('selectOrder', event.target.id);
    }
  }
}
</script>

<style scoped>
td {
  padding: 10px;
}

td:hover {
  background-color: #bbc0c0;
}

#op {
  margin: 0 auto;
}

.select {

}
</style>