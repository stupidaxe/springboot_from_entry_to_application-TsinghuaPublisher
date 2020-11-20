<template>
  <div class="active">
    <br>
    <h2>登录页面</h2>
    <form>
    用户名:<input type="text" v-model="loginForm.uname" placeholder="请输入用户名"/><br><br>
    密码： <input type="password" v-model="loginForm.upwd" placeholder="请输入密码"/><br><br>
    <button type="button" @click="login"  :disabled="isDisable">登录</button>
    <button type="reset">重置</button>
    </form>
    <br>
  </div>
</template>
<script>
  export default {
    name: 'Login',
    data () {
      return {
        isDisable:false,
        loginForm: {
          uname: '',
          upwd: ''
        }
      }
    },
    methods: {
      login () {
        this.isDisable = true;
        var formData = JSON.stringify(this.loginForm);
        let config = {
          headers:{'Content-Type':'application/json; charset=UTF-8'}
        };
        this.$axios
          .post('/login', formData, config)//直接提交表单
          .then(successResponse => {
              if (successResponse.data === "ok") {
                alert("登录成功")
                this.$store.commit('changeLogin',this.loginForm.uname)
                let path = this.$route.query.redirect
                this.$router.replace({path: path === '/' || path === undefined ? '/main': path})
            }else {
                alert("用户名或密码错误！")
                this.isDisable = false
              }
          })
          .catch(failResponse => {
            alert("响应异常")
          })
        }
    }
  }
</script>
<style>
  .active {
    background-image: url("../assets/bb.jpg");
  }
</style>

