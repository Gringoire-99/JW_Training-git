import {createRouter} from 'vue-router'
import {createWebHashHistory} from 'vue-router'
import BookManagement from "@/components/BookManagement";
import Login from "@/components/Login";

const routes = [
    {path: '/login', component: Login},
    {path: '/bookManagement', component: BookManagement},
]
export default createRouter({
    history: createWebHashHistory(),
    routes
})