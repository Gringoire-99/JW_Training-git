import {createRouter} from 'vue-router'
import {createWebHashHistory} from 'vue-router'
import BookManagement from "@/components/Example/BookManagement";
import homePage from "@/components/Example/HomePage";
import login from "@/components/Example/Login";
import register from "@/components/Example/register";
import helpPage from "@/components/Example/helpPage";
import helpDetail from "@/components/Example/helpDetail";

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