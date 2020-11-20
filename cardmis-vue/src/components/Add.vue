<template>
  <div class="active">
    <NavMain></NavMain>
    <h3>添加名片</h3>
    <form>
    姓名：<input type="text" v-model="name" placeholder="请输入用户名"/><br><br>
    电话：<input type="text" v-model="telephone" placeholder="请输入电话"/><br><br>
    邮箱：<input type="text" v-model="email" placeholder="请输入邮箱"/><br><br>
    单位：<input type="text" v-model="company" placeholder="请输入单位"/><br><br>
    邮编：<input type="text" v-model="post1" placeholder="请输入邮编"/><br><br>
    地址：<input type="text" v-model="address" placeholder="请输入地址"/><br><br>
    头像：
    <input  type="file"  @change="getFile($event)"/><br><br>
    <button type="button" @click="add($event)" :disabled="isDisable">添加</button>
    <button type="reset">重置</button>
    </form>
    <br>
  </div>
</template>
<script>
  import NavMain from '@/components/NavMain'
  export default {
    name: 'Add',
    components: {NavMain},
    data () {
      return {
        isDisable:false
      }
    },
    methods: {
      //获得文件对象
      getFile(event) {
        this.file = event.target.files[0];
      },
      add (event) {
        this.isDisable = true;
        event.preventDefault();
        let formData = new FormData();
        formData.append('name', this.name === undefined ? '': this.name);
        formData.append('telephone', this.telephone === undefined ? '': this.telephone);
        formData.append('email', this.email === undefined ? '': this.email);
        formData.append('company', this.company === undefined ? '': this.company);
        formData.append('post', this.post1 === undefined ? '': this.post1);
        formData.append('address', this.address === undefined ? '': this.address);
        formData.append('file', this.file === undefined ? null: this.file);
        let config = {
          headers:{'Content-Type':'multipart/form-data'}
        };
        this.$axios
          .post('/add', formData, config)//直接提交表单
          .then(successResponse => {
            if (successResponse.data === "ok") {
              alert("添加成功")
              this.$router.replace({path: '/main'})
            }else if(successResponse.data === "noLogin"){
              alert("没有登录，请登录！")
              this.$router.replace({path: '/login'})
            }else {
              alert("添加失败")
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
