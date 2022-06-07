<template>
  <el-row :gutter="20">
    <el-col :span="12" class="grid-content">
      <transition
          appear
          name="animate__animated animate__jackInTheBox"
          enter-active-class="animate__bounceIn"
          leave-active-class="animate__bounceOut">
        <el-container @mouseleave="close">

          <el-header class="hvr-fade">
            <h4>登录账号</h4>
          </el-header>

          <el-main class="hvr-border-fade">
            <el-form :model="form">
              <el-form-item label="学号" type="number">
                <el-tooltip
                    class="box-item"
                    effect="dark"
                    content="请输入您的学号"
                    placement="right-start"
                >
                  <el-input v-model="form.id" type="number"/>
                </el-tooltip>
              </el-form-item>
              <el-form-item label="密码">
                <el-tooltip
                    class="box-item"
                    effect="dark"
                    content="请输入您的密码"
                    placement="right-start"
                >
                <el-input v-model="form.password" type="password" show-password/>
                </el-tooltip>
              </el-form-item>
              <el-form-item>
                <el-button type="primary" @click="submit">登录</el-button>
                <el-button>取消</el-button>
              </el-form-item>
            </el-form>
            <el-button @mouseenter="open">
              还没有账号？
            </el-button>
            <transition
                appear
                name="animate__animated animate__swing"
                enter-active-class="animate__slideInRight"
                leave-active-class="animate__zoomOut">
              <el-button @click="pushRegisterPage" v-show="showDetail" class="hvr-sweep-to-right">GO! 马上注册一个！
                <el-icon>
                  <Promotion/>
                </el-icon>
              </el-button>
            </transition>
            <p></p>

                <el-alert v-show="loginStatusSuccess" @close="loginStatusSuccess=false"
                          title="登录成功"
                          type="success"
                          description="点击跳转到图书模块"
                          show-icon
                />
                <el-alert v-show="loginStatusFail" @close="loginStatusFail=false"
                          title="登录失败"
                          type="error"
                          description="学号或密码错误！"
                          show-icon
                />

          </el-main>

        </el-container>
      </transition>

    </el-col>

    <transition
        appear
        name="animate__animated animate__jackInTheBox"
        enter-active-class="animate__jackInTheBox"
        leave-active-class="animate__bounceOut">
      <el-col :span="12" class="grid-content">
        <el-container>
          <aside>
            <div class="separate"></div>
          </aside>
          <main>
            <h1>
              <div class="hvr-grow-shadow">
                登录你的<span style="color: #2a35ff">账号！</span><br>
              Getting Started With LMS
              </div>

              <p></p>
            </h1>
            <img src="../assets/loginImg.svg" style="width: 500px" class="hvr-grow-shadow">
          </main>
        </el-container>
      </el-col>
    </transition>

  </el-row>

</template>

<script>
import axios from 'axios'

export default {
  name: "LoginPage",
  data() {
    return {
      form: {
        id: '',
        name: '',
        password: '',
        gender: ''
      },
      showDetail: false,
      loginStatusFail: false,
      loginStatusSuccess: false,
      loginMessage: '',
    }
  },
  methods: {
    submit() {
      this.checkInput()
      let id = this.id;
      let password = this.password
      axios.get('http://localhost:8080/login', {
        params: {
          id,
          password
        }
      }).then(response => {
        this.loginStatusSuccess = true
        this.loginStatusFail = false
        this.loginMessage = response.status
      }).catch(() => {
        this.loginStatusFail = true
        this.loginStatusSuccess = false
      })
    },
    pushRegisterPage() {
      this.$router.replace('/RegisterPage');
    },
    open() {
      this.showDetail = true
    },
    close() {
      this.showDetail = false

    },
    checkInput(){
        alert(this.id)
    }
  },

}
</script>

<style scoped>
el-row {
  margin-bottom: 20px;
}

el-row:last-child {
  margin-bottom: 0;
}

el-col {
  border-radius: 4px;
}

.grid-content {
  border-radius: 4px;
  min-height: 36px;
}

.separate {
  border-width: 1px;
  border-style: dashed;
  border-color: #2098D1;
  height: 100%;
  margin: 10px;
}

el-container {
  margin-bottom: 20px;
}
</style>