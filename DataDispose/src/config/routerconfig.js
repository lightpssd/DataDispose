import HelloWorld from '../components/HelloWorld.vue'
import layout from '../components/layout.vue'
import layoutUpload from '../components/layoutUpload.vue'
import index from '../components/layoutIndex.vue'
import layoutnew from '../components/layoutNew.vue'
import layoutUploadNew from '../components/layoutUploadNew.vue'

export default [
        
    { // 配置默认路由
        path:"/", // 路由地址
        redirect:"/helloWorld" // 重定向
    },
    { path: '/helloWorld', component: HelloWorld },

    { path: '/layout/:id', component: layoutUploadNew },
    { path: '/layout/show/:id', component: layoutnew },

    { path: '/layoutIndex', component: index },


]
