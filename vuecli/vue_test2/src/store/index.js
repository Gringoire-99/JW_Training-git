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
        {bookId: '01', bookName: '西游', bookAuthor: 'wcn', bookPrice: 52, bookNumber: 2050, borrowNumber: 650,press:'新华出版社'},
        {bookId: '02', bookName: '三国', bookAuthor: 'xxx', bookPrice: 32, bookNumber: 2000, borrowNumber: 1500,press:'新华出版社'},
        {bookId: '03', bookName: '红楼', bookAuthor: 'cxq', bookPrice: 65, bookNumber: 200, borrowNumber: 150000,press:'新华出版社'},
        {bookId: '04', bookName: '水浒', bookAuthor: 'lgz', bookPrice: 33, bookNumber: 20, borrowNumber: 15,press:'新华出版社'},
    ],
}
export const store = Vuex.createStore({
    state,
    mutations,
    actions,
})