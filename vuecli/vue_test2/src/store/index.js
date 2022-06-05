//声明一个store
import Vuex from 'vuex';
import axios from 'axios'

//actions: 可被分配的动作（预处理，申请ajax）
const actions = {
    //参数1context上下文，可以读取调用位置的上下文，2 可携带参数
    getBookList(context){
        axios.get('/host/http://localhost:8080/t1').then((response=>{
            console.log("请求成功，数据为："+response.data)
            let newBook = {bookID: '09', bookName: '书1', bookAuthor: 'kk', bookPrice: 202, bookNum: 1531651, borrowNum: 15}
            context.commit("GET_BOOK_LIST",newBook)
        }),error=>{
            console.log("请求失败，数据为："+error.message)
        })
    }

}
//动作调用的实现方法(改变state)
const mutations = {
    //参数1 state 所有组件都可访问到的空间，2 action传递的参数
    GET_BOOK_LIST(state,list){
        console.log("合并")
        state.bookList.push(list)
    },

}
const state = {
    count:0,
    bookList: [
        {bookID: '01', bookName: '西游', bookAuthor: 'wcn', bookPrice: 19, bookNum: 200000, borrowNum: 15000},
        {bookID: '02', bookName: '三国', bookAuthor: 'xxx', bookPrice: 1999, bookNum: 2000, borrowNum: 1500},
        {bookID: '03', bookName: '红楼', bookAuthor: 'cxq', bookPrice: 19999, bookNum: 200, borrowNum: 150000},
        {bookID: '04', bookName: '水浒', bookAuthor: 'lgz', bookPrice: 199999, bookNum: 20, borrowNum: 15},
    ],
}
export const store = Vuex.createStore({
    state,
    mutations,
    actions,
})