import {createApp} from 'vue'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap/dist/js/bootstrap.min'
import {store} from "@/store";
import App from './App.vue'
import Router from "@/router";
const app = createApp(App)
app.use(store)
app.use(Router)
app.mount('#app')



