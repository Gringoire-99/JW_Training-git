<template>
  <el-container >
    <el-header class="hvr-fade">
      <h4>登录账号</h4>
    </el-header>
    <el-main class="hvr-border-fade">
      <el-form :model="form" label-width="120px">
        <el-form-item label="用户姓名">
          <el-input v-model="form.name"/>
        </el-form-item>
        <el-form-item label="用户密码">
          <el-input v-model="form.password" type="password"/>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="submit">登录</el-button>
          <el-button>取消</el-button>
        </el-form-item>
      </el-form>
    </el-main>
  </el-container>

</template>

<script>
export default {
  name: "LoginPage",
  data() {
    return {
      form: {
        name: '',
        password: '',
        gender: ''
      }
    }
  },
  methods: {
    submit() {
      alert("注册成功")
    }
  }
}
</script>

<style scoped>

</style>