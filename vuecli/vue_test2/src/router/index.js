import {createRouter} from 'vue-router'
import {createWebHashHistory} from 'vue-router'
import HomePage from "@/components/HomePage";
import UserPage from "@/components/UserPage";
import LoginPage from "@/components/LoginPage";
import RegisterPage from "@/components/RegisterPage";
import ContactPage from "@/components/StaticPage/ContactPage";
import HelpPage from "@/components/StaticPage/HelpPage";
import JoinUsPage from "@/components/StaticPage/JoinUsPage";
import TeamPage from "@/components/StaticPage/TeamPage";

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