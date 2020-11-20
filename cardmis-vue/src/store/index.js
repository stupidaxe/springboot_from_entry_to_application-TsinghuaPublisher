import Vue from 'vue'
import Vuex from 'vuex'
Vue.use(Vuex)//vuex是专为vue.js应用程序开发的状态管理模式。
// 提供仓库
export default new Vuex.Store({
    state:{
      //初始时候给一个 isLogin='0' 表示用户未登录
      isLogin:window.sessionStorage.getItem('user') == null ? '0' : window.sessionStorage.getItem('user')
    },
  mutations:{
    changeLogin(state, data) {
      state.isLogin = data;
      window.sessionStorage.setItem('user', data)
    }
  }
})
