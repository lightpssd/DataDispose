import { createApp } from 'vue'
import * as VueRouter from 'vue-router'
import './style.css'
import App from './App.vue'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import VueDragResize from "vue-drag-resize/src/components/vue-drag-resize.vue";
import "vue-drag-resize/src/components/vue-drag-resize.css";
import routerconfig from './config/routerconfig.js'
import './assets/font/font.css'

const router = VueRouter.createRouter({
    // 4. 内部提供了 history 模式的实现。为了简单起见，我们在这里使用 hash 模式。
    history: VueRouter.createWebHashHistory(),
    routes:routerconfig// `routes: routes` 的缩写
  })
const app=createApp(App)
app.component('vue-drag-resize',VueDragResize)
app.use(ElementPlus)
app.use(router)
app.mount('#app')

