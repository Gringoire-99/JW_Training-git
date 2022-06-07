<template>
  <div>
    <el-container class="items-center " height="100%">
      <el-aside width="200px">
        <el-scrollbar>
          <el-menu :default-openeds="['1','2']">

            <el-sub-menu index="1" class="hvr-radial-out" >
              <template #title>
                <el-icon>
                  <HomeFilled/>
                </el-icon>
                主页<span class="fill" style="width: 103px"></span>
              </template>
              <el-menu-item index="1-1" class="hvr-underline-from-center hvr-grow-shadow" @click="pushHomePage">回到主页</el-menu-item>

              <el-menu-item-group>
                <template #title>账号
                </template>
                <el-menu-item index="1-2" class="hvr-underline-from-center hvr-grow-shadow" @click="pushUserPage">我的</el-menu-item>
                <el-menu-item index="1-3" class="hvr-underline-from-center hvr-grow-shadow" @click="pushLoginPage">登录</el-menu-item>
                <el-menu-item index="1-4" class="hvr-underline-from-center hvr-grow-shadow" @click="pushRegisterPage">注册</el-menu-item>
              </el-menu-item-group>

              <el-menu-item-group title="其他">

                <el-sub-menu index="1-4" class="hvr-grow-shadow">
                  <template #title>
                    <el-icon>
                      <Avatar/>
                    </el-icon>
                    关于我们<span class="fill"></span>
                  </template>
                  <el-menu-item index="1-4-1" class="hvr-underline-from-center hvr-grow-shadow" @click="pushTeamPage">团队</el-menu-item>
                  <el-menu-item index="1-4-2" class="hvr-underline-from-center hvr-grow-shadow" @click="pushJoinUsPage">加入我们！</el-menu-item>
                  <el-menu-item index="1-4-3" class="hvr-underline-from-center hvr-grow-shadow" @click="pushContactPage">联系方式</el-menu-item>
                </el-sub-menu>

                <el-sub-menu index="1-5" class="hvr-grow-shadow">
                  <template #title>
                    <el-icon>
                      <InfoFilled/>
                    </el-icon>
                    获取帮助<span class="fill"></span>
                  </template>
                  <el-menu-item index="1-5-1" class="hvr-underline-from-center hvr-grow-shadow" @click="pushHelpPage">如何使用？</el-menu-item>
                </el-sub-menu>
              </el-menu-item-group>

            </el-sub-menu>


            <el-sub-menu index="2" class="hvr-radial-out">
              <template #title>
                <el-icon>
                  <Document/>
                </el-icon>
                图书管理<span class="fill"></span>
              </template>
              <el-menu-item-group>
                <template #title>管理</template>
                <el-menu-item index="2-1" class="hvr-underline-from-center">查看图书</el-menu-item>
                <el-menu-item index="2-2" class="hvr-underline-from-center">查看借阅记录</el-menu-item>
              </el-menu-item-group>
              <el-sub-menu index="2-4" class="hvr-grow-shadow">
                <template #title>用户信息<span class="fill"></span></template>
                <el-menu-item index="2-4-1" class="hvr-underline-from-center">查看用户</el-menu-item>
                <el-menu-item index="2-4-2" class="hvr-underline-from-center">用户管理</el-menu-item>
              </el-sub-menu>
            </el-sub-menu>
          </el-menu>
        </el-scrollbar>
      </el-aside>
      <el-main>
        <router-view></router-view>
      </el-main>
    </el-container>
  </div>
</template>

<script>
import 'animate.css'
import 'hover.css'
export default {
  name: "testPage",
  data() {
    return {}
  },
  methods:{
    pushHomePage(){
      this.$router.push({
        name:'HomePage',
        query:{}
      })
    },
    pushUserPage(){
      this.$router.push({
        name:'UserPage',
        query:{}
      })
    },
    pushLoginPage(){
      this.$router.push({
        name:'LoginPage',
        query:{}
      })
    },
    pushRegisterPage(){
      this.$router.push({
        name:'RegisterPage',
        query:{}
      })
    },
    pushContactPage(){
      this.$router.push({
        name:'ContactPage',
        query:{}
      })
    },
    pushHelpPage(){
      this.$router.push({
        name:'HelpPage',
        query:{}
      })
    },
    pushJoinUsPage(){
      this.$router.push({
        name:'JoinUsPage',
        query:{}
      })
    },
    pushTeamPage(){
      this.$router.push({
        name:'TeamPage',
        query:{}
      })
    },
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