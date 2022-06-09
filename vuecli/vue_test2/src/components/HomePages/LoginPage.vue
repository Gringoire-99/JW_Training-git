<template>
  <el-row :gutter="20">
    <transition
        appear
        enter-active-class="animate__bounceIn"
        leave-active-class="animate__bounceOut"
        name="animate__animated animate__jackInTheBox">
      <el-col :span="12" class="grid-content">

        <el-container @mouseleave="close">
          <el-header class="hvr-fade">
            <h4>登录账号</h4>
          </el-header>
          <template class="hvr-border-fade">

            <el-main>
              <el-form :model="form">
                <el-form-item label="学号" type="number">
                  <el-tooltip
                      class="box-item"
                      content="请输入您的学号"
                      effect="dark"
                      placement="right-start"
                  >
                    <el-input v-model="form.id" type="number"/>
                  </el-tooltip>
                </el-form-item>
                <el-form-item label="密码">
                  <el-tooltip
                      class="box-item"
                      content="请输入您的密码"
                      effect="dark"
                      placement="right-start"
                  >
                    <el-input v-model="form.password" show-password type="password"/>
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
                  enter-active-class="animate__slideInRight"
                  leave-active-class="animate__zoomOut"
                  name="animate__animated animate__swing">
                <el-button v-show="showDetail" class="hvr-sweep-to-right" @click="pushRegisterPage">GO! 马上注册一个！
                  <el-icon>
                    <Promotion/>
                  </el-icon>
                </el-button>
              </transition>
              <p></p>
              <el-progress v-show="showProgress" :duration="1.5" :indeterminate="true" :percentage="progress"
                           :status="status"/>
              <el-alert v-show="loginStatusSuccess" :description="loginMessage"
                        show-icon
                        title="登录成功"
                        type="success"
                        @close="loginStatusSuccess=false"
              />
              <el-alert v-show="loginStatusFail" :description="loginMessage"
                        show-icon
                        title="登录失败"
                        type="error"
                        @close="loginStatusFail=false"
              />

            </el-main>

          </template>

        </el-container>

      </el-col>
    </transition>

    <transition
        appear
        enter-active-class="animate__jackInTheBox"
        leave-active-class="animate__bounceOut"
        name="animate__animated animate__jackInTheBox">
      <el-col :span="12" class="grid-content">
        <el-container>
          <aside>
            <div class="separate"></div>
          </aside>
          <main>
            <div class="hvr-grow-shadow">
              <h1>
                登录你的<span style="color: #2a35ff">账号！</span><br>
                Getting Started With LMS
              </h1>
            </div>
            <p></p>
            <img class="hvr-grow-shadow" src="../../assets/loginImg.svg" style="width: 500px">
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

      showProgress: false,
      progress: 0,
      status: '',
      progressStatus: {'success': "success", "exception": "exception"}
    }
  },
  methods: {
    submit() {
      let timer;
      let userId = this.form.id;
      let password = this.form.password
      if (userId.length === 0 || password.length === 0) {
        this.loginStatusFail = true
        this.loginStatusSuccess = false
        this.loginMessage = "学号或密码不能为空"
        return
      }
      axios.get('/ToHost/login', {
        params: {
          userId,
          password
        }
      }).then(response => {
        this.status = this.progressStatus['success']
        this.loginMessage = "成功状态" + response.status
        console.log(response.data);
        console.log(response.status);
        console.log(response.statusText);
        console.log(response.headers);
        console.log(response.config);
        setTimeout(() => {
          clearInterval(timer)
          this.progress = 0
          this.loginStatusSuccess = true
          this.loginStatusFail = false
          window.setTimeout(() => {
            this.showProgress = false
            this.status = ''
          }, 3000)
        }, 2000)
      }).catch((error) => {
        console.log(error)
        this.loginMessage = '网络请求失败'
        this.status = this.progressStatus['exception']
        setTimeout(() => {
          clearInterval(timer)
          this.progress = 0
          this.loginStatusFail = true
          this.loginStatusSuccess = false
          window.setTimeout(() => {
            this.showProgress = false
            this.status = ''
          }, 3000)
        }, 2000)
      })
      this.showProgress = true
      timer = setInterval(() => {
        this.progress += 20
      }, 1500)
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