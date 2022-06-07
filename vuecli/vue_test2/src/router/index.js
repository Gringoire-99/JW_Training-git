import {createRouter} from 'vue-router'
import {createWebHashHistory} from 'vue-router'
import HomePage from "@/components/HomePages/HomePage";
import UserPage from "@/components/HomePages/UserPage";
import LoginPage from "@/components/HomePages/LoginPage";
import RegisterPage from "@/components/HomePages/RegisterPage";
import ContactPage from "@/components/StaticPages/ContactPage";
import HelpPage from "@/components/StaticPages/HelpPage";
import JoinUsPage from "@/components/StaticPages/JoinUsPage";
import TeamPage from "@/components/StaticPages/TeamPage";

const routes = [

    {path: '/', component: HomePage},
    {
        name: 'HomePage',
        path: '/HomePage',
        component: HomePage,
    },
    {
        name: 'UserPage',
        path: '/UserPage',
        component: UserPage
    },
    {
        name: 'LoginPage',
        path: '/LoginPage',
        component: LoginPage
    },
    {
        name: 'RegisterPage',
        path: '/RegisterPage',
        component: RegisterPage
    },
    {
        name: 'ContactPage',
        path: '/ContactPage',
        component: ContactPage
    },
    {
        name: 'HelpPage',
        path: '/HelpPage',
        component: HelpPage
    },
    {
        name: 'JoinUsPage',
        path: '/JoinUsPage',
        component: JoinUsPage
    },
    {
        name: 'TeamPage',
        path: '/TeamPage',
        component: TeamPage
    },
]
export default createRouter({
    history: createWebHashHistory(),
    routes
})