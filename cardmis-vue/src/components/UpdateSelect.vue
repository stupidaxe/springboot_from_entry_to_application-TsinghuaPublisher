<template>
  <div class="active">
    <NavMain></NavMain>
    <br>
    <table border="1" align="center">
      <tr>
        <th>ID</th>
        <th>姓名</th>
        <th>公司</th>
        <th>地址</th>
        <th>邮箱</th>
        <th>电话</th>
        <th>邮编</th>
        <th>照片</th>
        <th>操作</th>
      </tr>
      <tr v-for="card in cards">
        <td>{{ card.id }} </td>
        <td>{{ card.name }} </td>
        <td>{{ card.company }} </td>
        <td>{{ card.address }} </td>
        <td>{{ card.email }} </td>
        <td>{{ card.telephone }} </td>
        <td>{{ card.post }} </td>
        <td><img :src="card.logo"></td>
        <td> <router-link :to="{path:'/editCard',query:{cid:card.id}}"  :exact="true">修改</router-link></td>
        <!-- <router-link :to="{name:'home',params:{id:001}}> -->
      </tr>
    </table>
    <br>
  </div>
</template>
<script>
  import NavMain from '@/components/NavMain'
  export default {
    name: 'Main',
    components: {NavMain},
    data () {
      return {
        cards: []//保存数据
      }
    },
    //created:在模板渲染成html前调用，即通常初始化某些属性值，然后再渲染成视图。
    //mounted:在模板渲染成html后调用，通常是初始化页面完成后，再对html的dom节点进行一些需要的操作。
    created: function () {
      this.loadCards()
    },
    methods: {
      loadCards() {
        let _this = this
        this.$axios
          .get('/cards')
          .then(successResponse => {
            if(successResponse.data === "noLogin"){
              alert("没有登录，请登录！")
              _this.$router.replace({path: '/login'})
            }else{
              _this.cards = successResponse.data
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
  table{
    font-size:12px;
    border-collapse:collapse
  }
  img{
    height: 20px;
    width: 20px;
  }
</style>

