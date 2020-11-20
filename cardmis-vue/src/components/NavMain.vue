<template>
  <div>
    <br>
    <h2>微名片主页面</h2>
    <router-link to="/toAdd" :exact="true">添加名片</router-link>&nbsp;&nbsp;
    <router-link to="/toDeleteSelect" :exact="true">删除名片</router-link>&nbsp;&nbsp;
    <router-link to="/toUpdateSelect" :exact="true">修改名片</router-link>&nbsp;&nbsp;
    <router-link to="/main" :exact="true">查询名片</router-link><br>
  </div>
</template>
<script>
  export default {
    name: 'NavMain'
  }
</script>
<style>
  a {text-decoration: none}
</style>
