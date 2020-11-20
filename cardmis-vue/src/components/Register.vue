<template>
  <div class="active">
    <br>
    <h2>注册页面</h2>
    <form>
    用户名:<input type="text" v-model="registerForm.uname" placeholder="请输入用户名"/><br><br>
    密码： <input type="password" v-model="registerForm.upwd" placeholder="请输入密码"/><br><br>
    确认密码： <input type="password" v-model="registerForm.reupwd" placeholder="请再次输入密码"/><br><br>
    <button type="button" @click="register" :disabled="isDisable">注册</button>
    <button type="reset">重置</button>
    </form>
    <br>
  </div>
</template>
<script>
  export default {
    name: 'Register',
    data () {
      return {
        isDisable:false,
        registerForm: {
          uname: '',
          upwd: '',
          reupwd: ''
        }
      }
    },
    methods: {
      register () {
        this.isDisable = true;
        if(this.registerForm.upwd != this.registerForm.reupwd) {
          alert("两次密码不一致，重新输入！");
          return false;
        }
        this.$axios
          .post('/register', {
            uname: this.registerForm.uname,
            upwd: this.registerForm.upwd
          })
          .then(successResponse => {
            if (successResponse.data === "no") {
              alert("用户名已存在！")
              this.isDisable = false
            }else{
              alert("注册成功！")
              this.$router.replace({path: '/login'})
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
