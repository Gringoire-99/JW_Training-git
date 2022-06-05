import {createRouter} from 'vue-router'
import {createWebHashHistory} from 'vue-router'
import BookManagement from "@/components/BookManagement";
import homePage from "@/components/HomePage";
import login from "@/components/Login";
import register from "@/components/register";
import helpPage from "@/components/helpPage";
import helpDetail from "@/components/helpDetail";

const routes = [
    {path: '/homePage', component: homePage, children: [{path: 'login', component: login}, {path: 'register', component: register}]
    },
    {path: '/bookManagement', component: BookManagement},
    {path: '/', component: homePage},
    {path: '/help', component: helpPage, children: [{path: 'detail', component: helpDetail}]}

]
export default createRouter({
    history: createWebHashHistory(),
    routes
})