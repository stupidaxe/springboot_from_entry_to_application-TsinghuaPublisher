import Vue from 'vue'
import Router from 'vue-router'
// 导入组件
import AppIndex from '@/components/AppIndex'
import Login from '@/components/Login'
import Register from '@/components/Register'
import Main from '@/components/Main'
import Add from '@/components/Add'
import DeleteSelect from '@/components/DeleteSelect'
import UpdateSelect from '@/components/UpdateSelect'
import EditCard from '@/components/EditCard'
//安装插件
Vue.use(Router)//挂载属性
//创建路由对象并配置路由规则
export default new Router({
  //将路由从默认的 hash 模式切换为 histroy 模式
  mode: 'history',
  routes: [
    // 下面都是固定的写法，一个个link对象
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/register',
      name: 'Register',
      component: Register
    },
    {
      path: '/main',
      name: 'Main',
      component: Main,
      meta:{auth:true}//需要登录权限验证
    },
    {
      path: '/toAdd',
      name: 'Add',
      component: Add,
      meta:{auth:true}//需要登录权限验证
    },
    {
      path: '/toDeleteSelect',
      name: 'DeleteSelect',
      component: DeleteSelect,
      meta:{auth:true}//需要登录权限验证
    },
    {
      path: '/toUpdateSelect',
      name: 'UpdateSelect',
      component: UpdateSelect,
      meta:{auth:true}//需要登录权限验证
    },
    {
      path: '/editCard',//接收参数
      name: 'EditCard',
      component: EditCard,
      meta:{auth:true}//需要登录权限验证
    },
    {
      path: '/',
      name: 'AppIndex',
      component: AppIndex
    }
  ]
})
