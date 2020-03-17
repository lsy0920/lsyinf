import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Link from '@/components/Link'
import Management from '@/components/Management'
import Echarts from '@/components/Echarts'

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/link',
      name: 'link',
      component: Link
    },
    {
      path: '/echarts',
      name: 'echarts',
      component: Echarts
    }
  ]
})
