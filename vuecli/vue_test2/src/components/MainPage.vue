<template>
  <div>
    <el-container class="items-center " height="100%">
      <el-aside width="200px">
        <el-scrollbar>
          <el-menu :default-openeds="['1','2']">

            <el-sub-menu class="hvr-radial-out" index="1">
              <template #title>
                <el-icon>
                  <HomeFilled/>
                </el-icon>
                主页<span class="fill" style="width: 103px"></span>
              </template>
              <el-menu-item class="hvr-underline-from-center hvr-grow-shadow" index="1-1" @click="pushHomePage">回到主页
              </el-menu-item>

              <el-menu-item-group>
                <template #title>账号
                </template>
                <el-menu-item class="hvr-underline-from-center hvr-grow-shadow" index="1-2" @click="pushUserPage">我的
                </el-menu-item>
                <el-menu-item class="hvr-underline-from-center hvr-grow-shadow" index="1-3" @click="pushLoginPage">登录
                </el-menu-item>
                <el-menu-item class="hvr-underline-from-center hvr-grow-shadow" index="1-4" @click="pushRegisterPage">
                  注册
                </el-menu-item>
              </el-menu-item-group>

              <el-menu-item-group title="其他">

                <el-sub-menu class="hvr-grow-shadow" index="1-4">
                  <template #title>
                    <el-icon>
                      <Avatar/>
                    </el-icon>
                    关于我们<span class="fill"></span>
                  </template>
                  <el-menu-item class="hvr-underline-from-center hvr-grow-shadow" index="1-4-1" @click="pushTeamPage">
                    团队
                  </el-menu-item>
                  <el-menu-item class="hvr-underline-from-center hvr-grow-shadow" index="1-4-2" @click="pushJoinUsPage">
                    加入我们！
                  </el-menu-item>
                  <el-menu-item class="hvr-underline-from-center hvr-grow-shadow" index="1-4-3"
                                @click="pushContactPage">联系方式
                  </el-menu-item>
                </el-sub-menu>

                <el-sub-menu class="hvr-grow-shadow" index="1-5">
                  <template #title>
                    <el-icon>
                      <InfoFilled/>
                    </el-icon>
                    获取帮助<span class="fill"></span>
                  </template>
                  <el-menu-item class="hvr-underline-from-center hvr-grow-shadow" index="1-5-1" @click="pushHelpPage">
                    如何使用？
                  </el-menu-item>
                </el-sub-menu>
              </el-menu-item-group>

            </el-sub-menu>


            <el-sub-menu class="hvr-radial-out" index="2">
              <template #title>
                <el-icon>
                  <Document/>
                </el-icon>
                图书管理<span class="fill"></span>
              </template>
              <el-menu-item-group>
                <template #title>管理</template>
                <el-menu-item class="hvr-underline-from-center" index="2-1" @click="pushBookListPage">查看图书
                </el-menu-item>
                <el-menu-item class="hvr-underline-from-center" index="2-2" @click="pushBookRecordPage">查看借阅记录
                </el-menu-item>
              </el-menu-item-group>
              <el-sub-menu class="hvr-grow-shadow" index="2-4">
                <template #title>用户信息<span class="fill"></span></template>
                <el-menu-item class="hvr-underline-from-center" index="2-4-2" @click="pushUserManagerPage">用户管理
                </el-menu-item>
              </el-sub-menu>
            </el-sub-menu>
          </el-menu>
        </el-scrollbar>
      </el-aside>
      <el-main>
        <router-view v-if="isRouterAlive"></router-view>
      </el-main>
    </el-container>
  </div>
</template>

<script>
import 'animate.css'
import 'hover.css'
import {ElNotification} from 'element-plus'
import axios from "axios";

export default {
  name: "MainPage",
  data() {
    return {isRouterAlive: true}
  },
  methods: {
    reload() {
      this.isRouterAlive = false
      this.$nextTick(() => (this.isRouterAlive = true))
    },
    pushHomePage() {
      this.$router.push({
        name: 'HomePage',
        query: {}
      })
    },
    pushUserPage() {
      this.$router.push({
        name: 'UserPage',
        query: {}
      })
    },
    pushLoginPage() {
      this.$router.push({
        name: 'LoginPage',
        query: {}
      })
    },
    pushRegisterPage() {
      this.$router.push({
        name: 'RegisterPage',
        query: {}
      })
    },
    pushContactPage() {
      this.$router.push({
        name: 'ContactPage',
        query: {}
      })
    },
    pushHelpPage() {
      this.$router.push({
        name: 'HelpPage',
        query: {}
      })
    },
    pushJoinUsPage() {
      this.$router.push({
        name: 'JoinUsPage',
        query: {}
      })
    },
    pushTeamPage() {
      this.$router.push({
        name: 'TeamPage',
        query: {}
      })
    },
    pushBookListPage() {
      this.$router.push({
        name: 'BookListPage',
        query: {}
      })
    },
    pushBookRecordPage() {
      this.$router.push({
        name: 'BookRecordPage',
        query: {}
      })
    },
    pushUserManagerPage() {
      this.$router.push({
        name: 'UserManagerPage',
        query: {}
      })
    },
    warningPopUp(message, title) {
      ElNotification({
        title,
        message,
        type: 'warning',
      })
    },
    successPopUp(message, title) {
      ElNotification({
        title,
        message,
        type: 'success',
      })
    },
    errorPopUp(message, title) {
      ElNotification({
        title,
        message,
        type: 'error',
      })
    },
    requestBookList() {
      new Promise(() => {
        axios.get('/ToHost/getAllBooks').then(value => {
          this.$store.commit('UPDATE_BOOK_LIST', value.data.data)
        }, () => {
          this.errorPopUp('图书数据请求失败', '网络异常')
        })
      })
    },
    requestBookRecord() {
      new Promise(() => {
        axios.get('/ToHost/getAllRecord').then(value => {
          this.$store.commit('UPDATE_BOOK_RECORD', value.data.data)
        }, () => {
          this.errorPopUp('借阅数据请求失败', '网络异常')
        })
      })
    },

  },
  mounted() {
    this.requestBookList()
    this.requestBookRecord();
    //在页面加载时，判断用户权限（游客，用户，管理员），在后端读取用户信息，初始化用户信息
    let name = localStorage.getItem('userName')
    if (name != null) {
      this.$store.state.isLogin = true
      this.$store.state.user.userName = name
      this.$store.state.user.userId = localStorage.getItem('userId')
      this.$store.state.user.role = localStorage.getItem('role')
      this.$store.state.user.remark = localStorage.getItem('remark')
      this.$store.state.user.gender = localStorage.getItem('gender')
      this.$store.state.user.birthdate = localStorage.getItem('birthdate')
    } else {
      this.warningPopUp('您还未登录，仅能访问部分资源', '未登录')
    }
  }

}
</script>

<style scoped>
.fill {
  width: 75px;
}

el-container {
  margin: 20px;
}
</style>