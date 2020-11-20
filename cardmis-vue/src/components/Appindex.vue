<!--每个.vue文件包含三种类型的顶级语言块 <template>, <script> 和 <style>。这三个部分分别代表了 html,js,css。-->
<template>
  <div class="active">
    <br>
    <h2>微名片前端首页</h2>
    <!--exact精确匹配-->
    已注册，<router-link to="/login" :exact="true">去登录</router-link> <br><br>
    没注册，<router-link to="/register" :exact="true">去注册</router-link><br><br>
  </div>
</template>
<script>
  export default {
    name: 'AppIndex'
  }
</script>
<style scoped>
  a {text-decoration: none}
  .active {
    background-image: url("../assets/bb.jpg");
  }
</style>
