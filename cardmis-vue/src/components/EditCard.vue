<template>
  <div class="active">
    <NavMain></NavMain>
    <h3>修改名片</h3>
    <form>
      姓名：<input type="text" v-model="aCard.name" placeholder="请输入用户名"/><br><br>
      电话：<input type="text" v-model="aCard.telephone" placeholder="请输入电话"/><br><br>
      邮箱：<input type="email" v-model="aCard.email" placeholder="请输入邮箱"/><br><br>
      单位：<input type="text" v-model="aCard.company" placeholder="请输入单位"/><br><br>
      <!--post对应于实体属性名-->
      邮编：<input type="text" v-model="aCard.post" placeholder="请输入邮编"/><br><br>
      地址：<input type="text" v-model="aCard.address" placeholder="请输入地址"/><br><br>
      头像：
      <input  type="file"  @change="getFile($event)"/><img :src="aCard.logo" alt="没有头像">
      <input  type="hidden"  v-model="aCard.logo"/><!--不选择图片时，使用隐藏域的图片路径，即没有修改图片-->
      <input  type="hidden"  v-model="aCard.id"/>
      <br><br>
      <button type="button" @click="update($event)" :disabled="isDisable">修改</button>
      <button type="reset">重置</button>
    </form>
    <br>
  </div>
</template>
<script>
  import NavMain from '@/components/NavMain'
  export default {
    name: 'Edit',
    components: {NavMain},
    data () {
      return {
        isDisable:false,
        aCard: []//存储返回结果
      }
    },
    created: function () {
      this.loadCard()
    },
    methods: {
      loadCard() {
        let _this = this
        let cid = _this.$route.query.cid
        this.$axios
          .get('/aCard?cid='+ cid)
          .then(successResponse => {
            if(successResponse.data === "noLogin"){
              alert("没有登录，请登录！")
              _this.$router.replace({path: '/login'})
            }else{
              _this.aCard = successResponse.data
            }
          })
          .catch(failResponse => {
            alert("响应异常")
          })
      },
      //获得文件对象
      getFile(event) {
        this.file = event.target.files[0];
      },
      update (event) {
        this.isDisable = true;
        event.preventDefault();
        let formData = new FormData();
        formData.append('name', this.aCard.name);
        formData.append('telephone', this.aCard.telephone);
        formData.append('email', this.aCard.email);
        formData.append('company', this.aCard.company);
        formData.append('post', this.aCard.post);
        formData.append('address', this.aCard.address);
        formData.append('file', this.file);
        formData.append('logo', this.aCard.logo);
        formData.append('id', this.aCard.id);
        let config = {
          headers:{'Content-Type':'multipart/form-data'}
        };
        this.$axios
          .post('/add', formData, config)//直接提交表单
          .then(successResponse => {
            if (successResponse.data === "ok") {
              alert("修改成功")
              let path = this.$route.query.redirect
              this.$router.replace({path: path === '/' || path === undefined ? '/toUpdateSelect': path})
            }else if(successResponse.data === "noLogin"){
              alert("没有登录，请登录！")
              this.$router.replace({path: '/login'})
            }else {
              alert("修改失败")
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
  img{
    height: 30px;
    width: 30px;
  }
</style>
