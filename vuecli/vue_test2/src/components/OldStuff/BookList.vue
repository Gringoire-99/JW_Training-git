<template>
  <div id="bl">
    <operate-pane @select="select" @selectOrder="selectedOrder"></operate-pane>
    <transition-group
        appear
        name="animate__animated animate__bounce"
        enter-active-class="animate__bounceInDown"
        leave-active-class="animate__zoomOutLeft">
      <book-item v-for="book in filterList" :key="book.bookID" :book="book" class="block col-md-4"></book-item>
    </transition-group>
    <span class="msg">正在使用：{{ selectedProp }} 进行{{ order === 'asc' ? '升序' : '降序' }}搜索</span>
  </div>
</template>

<script>
import OperatePane from "@/components/OldStuff/OperatePane";
import BookItem from "@/components/OldStuff/BookItem";
import pubsub from 'pubsub-js'
import '../../../node_modules/animate.css/animate.css'
import '../../../node_modules/hover.css/css/hover.css'
export default {
  name: "BookList",
  components: {OperatePane, BookItem,},
  data() {
    return {
      //选择搜索的属性
      selectedProp: 'bookName',
      //搜索的排序
      order: 'asc',
      keyWord: '',
    }
  },
  //接收子组件的数据（emit）
  methods: {
    select(id) {
      this.selectedProp = id;
    },
    selectedOrder(id) {
      this.order = id;
    }
  },
  mounted() {
    this.pID = pubsub.subscribe("keyWord", (_, keyWord) => {
      this.keyWord = keyWord
    })
  },
  beforeUnmount() {
    pubsub.unsubscribe(this.pID)
  },
  computed: {
    bookList:{
      get(){
        return this.$store.state.bookList;
      }
    },
    //当参数发生变化时，生成新列表重新渲染
    filterList: {
      get() {
        let keyWord = this.keyWord;
        let selectedProp = this.selectedProp;
        let order = this.order;
        let src = this.bookList
        let arr
        arr = src.filter((b) => ("" + b[selectedProp]).indexOf(keyWord) !== -1)
        if (order === 'asc') {
          arr.sort((b1, b2) => b1[selectedProp] > b2[selectedProp] ? 1 : -1)
        } else {
          arr.sort((b1, b2) => b1[selectedProp] > b2[selectedProp] ? -1 : 1)
        }
        return arr
      }
    },

  }
}
</script>

<style scoped>

.msg {
  background-color: coral;
  color: azure;
}
</style>