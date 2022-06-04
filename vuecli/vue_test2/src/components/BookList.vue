<template>
  <div id="bl">
    <operate-pane @select="select" @selectOrder="selectedOrder"></operate-pane>
    <transition-group
    appear
    name="animate__animated animate__bounce"
    enter-active-class="animate__bounceInDown">
      <book-item v-for="book in filterList" :key="book.bookID" :book="book" class="button hvr-grow"></book-item>
    </transition-group>
    <span class="msg">正在使用：{{ selectedProp }} 进行{{ order === 'asc' ? '升序' : '降序' }}搜索</span>
  </div>
</template>

<script>
import OperatePane from "@/components/OperatePane";
import BookItem from "@/components/BookItem";
import pubsub from 'pubsub-js'
import 'animate.css'
import 'hover.css'
export default {
  name: "BookList",
  components: {OperatePane, BookItem,},
  data() {
    return {
      //数据源
      bookList: [
        {bookID: '01', bookName: '西游记', bookAuthor: 'wcn', bookPrice: 19, bookNum: 200000, borrowNum: 15000},
        {bookID: '02', bookName: '三国', bookAuthor: 'xxx', bookPrice: 1999, bookNum: 2000, borrowNum: 1500},
        {bookID: '03', bookName: '红楼', bookAuthor: 'cxq', bookPrice: 19999, bookNum: 200, borrowNum: 150000},
        {bookID: '04', bookName: '水浒', bookAuthor: 'lgz', bookPrice: 199999, bookNum: 20, borrowNum: 15},
      ],
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
  mounted(){
    this.pID=pubsub.subscribe("keyWord",(_,keyWord)=>{
      this.keyWord = keyWord
    })
  },beforeDestroy(){
    pubsub.unsubscribe(this.pID)
  },
  computed: {
    //当参数发生变化时，生成新列表重新渲染
    filterList: {
      get() {
        let keyWord = this.keyWord;
        let selectedProp = this.selectedProp;
        let order = this.order;
        let arr
        arr = this.bookList.filter((b) => ("" + b[selectedProp]).indexOf(keyWord) !== -1)
        if (order === 'asc') {
          arr.sort((b1, b2) => b1[selectedProp] > b2[selectedProp] ? 1 : -1)
        } else {
          arr.sort((b1, b2) => b1[selectedProp] > b2[selectedProp] ? -1 : 1)
        }
        return arr
      }
    }
  }
}
</script>

<style scoped>

.msg {
  background-color: coral;
  color: azure;
}
</style>