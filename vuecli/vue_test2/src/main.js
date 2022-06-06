import {createApp} from 'vue'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap/dist/js/bootstrap.min'
import ElementPlus from 'element-plus'
import zhCn from 'element-plus/es/locale/lang/zh-cn'
import 'element-plus/dist/index.css'
import {store} from "@/store";
import App from './App.vue'
import Router from "@/router";
const app = createApp(App)
app.use(ElementPlus, {
    locale: zhCn,
})
app.use(store)
app.use(Router)
app.mount('#app')



