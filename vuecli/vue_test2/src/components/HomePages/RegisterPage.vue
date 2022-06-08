<template>

  <el-row :gutter="20">
    <transition
        appear
        name="animate__animated"
        enter-active-class="animate__bounceIn"
    >
      <el-col :span="12">
        <el-container>
          <el-header class="hvr-fade">
            <h4>注册账号</h4>
          </el-header>
          <el-main class="hvr-border-fade">
            <el-form label-width="120px">
              <el-form-item label="学号">
                <el-tooltip
                    class="box-item"
                    effect="dark"
                    content="请输入您的学号"
                    placement="right-start"
                >
                  <el-input v-model="form.id" type="number"/>
                </el-tooltip>
              </el-form-item>
              <el-form-item label="用户姓名">
                <el-tooltip
                    class="box-item"
                    effect="dark"
                    content="请输入您的姓名"
                    placement="right-start"
                >
                  <el-input v-model="form.name"/>
                </el-tooltip>
              </el-form-item>
              <el-form-item label="用户密码">
                <el-tooltip
                    class="box-item"
                    effect="dark"
                    content="请输入您的密码"
                    placement="right-start"
                >
                  <el-input v-model="form.password" type="password" show-password/>
                </el-tooltip>
              </el-form-item>
              <el-form-item label="用户类型">
                <el-select v-model="form.role" placeholder="选择你的角色">
                  <el-option label="普通用户" value="user"/>
                  <el-option label="管理员" value="admin"/>
                </el-select>
              </el-form-item>
              <el-form-item>
                <el-popconfirm
                    confirm-button-text="确定"
                    cancel-button-text="取消"
                    icon-color="#626AEF"
                    title="确认你的输入无误？"
                    @confirm="submit"
                >
                  <template #reference>
                    <el-button type="primary">提交</el-button>
                  </template>
                </el-popconfirm>

                <el-button>取消</el-button>
              </el-form-item>
            </el-form>
            <p></p>
            <el-progress :percentage="progress" :indeterminate="true" v-show="showProgress" :status="status"
                         :duration="1.5"/>
            <el-alert v-show="registerSuccessStatus" @close="registerSuccessStatus=false"
                      title="注册成功"
                      type="success"
                      :description="registerMessage"
                      show-icon
            />
            <el-alert v-show="registerFailStatus" @close="registerFailStatus=false"
                      title="注册失败"
                      type="error"
                      :description="registerMessage"
                      show-icon
            />
          </el-main>
        </el-container>
      </el-col>
    </transition>


    <el-col :span="12">
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
              <h1 class="hvr-grow-shadow">
                <span style="color: #2259dc">加入</span>我们！<br>
                JOIN US!
                <p></p>
              </h1>
              <img src="../../assets/registerImg.svg" style="width: 500px" class="hvr-grow-shadow">
            </main>
          </el-container>
        </el-col>
      </transition>
    </el-col>
  </el-row>


</template>

<script>
import axios from "axios";

export default {
  name: "RegisterPage",
  data() {
    return {
      form: {
        id: '',
        name: '',
        password: '',
        role: ''
      },
      registerSuccessStatus: false,
      registerFailStatus: false,
      registerMessage: '',

      showProgress: false,
      progress: 0,
      status: '',
      progressStatus: {'success': "success", "exception": "exception"}
    }
  },
  methods: {
    submit() {
      let timer;
      let id = this.form.id;
      let name = this.form.name;
      let pwd = this.form.password;
      let role = this.form.role;
      if (id.length === 0 || name.length === 0 || pwd.length === 0 || role.length === 0) {
        this.registerSuccessStatus = false;
        this.registerFailStatus = true;
        this.registerMessage = "有空选项"
        return
      }
      this.showProgress = true
      timer = setInterval(() => {
        this.progress += 20
      }, 1500)
      axios.get('http://localhost:8080/register', {
        params: {
          id,
          name,
          pwd,
          role
        }
      }).then(response => {
        this.status = this.progressStatus['success']
        this.registerMessage = "成功状态" + response.status
        setTimeout(() => {
          clearInterval(timer)
          this.progress = 0
          this.registerSuccessStatus = true
          this.registerFailStatus = false
          window.setTimeout(() => {
            this.showProgress = false
            this.status = ''
          }, 3000)
        }, 2000)
      }).catch(() => {
        this.registerMessage = '网络请求失败'
        this.status = this.progressStatus['exception']
        setTimeout(() => {
          clearInterval(timer)
          this.progress = 0
          this.registerFailStatus = true
          this.registerSuccessStatus = false
          window.setTimeout(() => {
            this.showProgress = false
            this.status = ''
          }, 3000)
        }, 2000)
      })

    }
  }
}
</script>

<style scoped>
.separate {
  border-width: 1px;
  border-style: dashed;
  border-color: #2098D1;
  height: 100%;
  margin: 10px;
}
</style>