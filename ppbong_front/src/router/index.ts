import Vue from 'vue'
import VueRouter, { RouteConfig } from 'vue-router'
import Home from '../views/home/Home.vue'
import Layout from '../views/layout/Layout.vue'


Vue.use(VueRouter)

const routes: Array<RouteConfig> = [
  {
    path: '/',
    // name: 'Layout',//如果有默认子路由，则父路由不需要起名字了，否则会给警告
    component:Layout,
    children:[
      {
        path: '',//path为空，会作为默认子路由渲染
        name: 'Home',
        component:Home,
      }
    ]

  },
  {
    path: '/iteminfo',
    name: 'ItemInfo',
    components: {
      default:()=>import("@/views/ItemInfo.vue"),
    },
  },
  {
    path: '/login',
    name: 'Login',
    components: {
      default:()=>import("@/views/login/Login.vue"),
    },
  },
  {
    path: '/manager',
    name: 'Manager',
    component:()=>import("@/views/manager/Manager.vue"),

  }

]

const router = new VueRouter({
  routes
})

export default router
