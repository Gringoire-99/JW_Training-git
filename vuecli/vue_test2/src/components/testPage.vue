<template>
  <div>
    <el-container class="items-center hvr-grow-shadow hvr-radial-out">
      <el-aside width="200px">
        <el-scrollbar>
          <el-menu :default-openeds="['1','2', '3']">
            <el-sub-menu index="1" class="hvr-radial-out">
              <template #title>
                <el-icon><HomeFilled /></el-icon>
                主页（HomePage）
              </template>
              <el-menu-item-group>
                <template #title>账号</template>
                <el-menu-item index="1-1" class="hvr-underline-from-center">我的</el-menu-item>
                <el-menu-item index="1-2" class="hvr-underline-from-center">登录</el-menu-item>
                <el-menu-item index="1-3" class="hvr-underline-from-center">注册</el-menu-item>
              </el-menu-item-group>
              <el-menu-item-group title="其他">
                <el-sub-menu index="1-4">
                  <template #title>关于我们</template>
                  <el-menu-item index="1-4-1" class="hvr-underline-from-center">团队</el-menu-item>
                  <el-menu-item index="1-4-2" class="hvr-underline-from-center">加入我们！</el-menu-item>
                  <el-menu-item index="1-4-3" class="hvr-underline-from-center">联系方式</el-menu-item>
                </el-sub-menu>
                <el-sub-menu index="1-5">
                  <template #title>获取帮助</template>
                  <el-menu-item index="1-5-1" class="hvr-underline-from-center">如何使用？</el-menu-item>
                </el-sub-menu>
              </el-menu-item-group>
            </el-sub-menu>
            <el-sub-menu index="2" class="hvr-radial-out">
              <template #title>
                <el-icon><Document /></el-icon>
                图书管理
              </template>
              <el-menu-item-group>
                <template #title>Group 1</template>
                <el-menu-item index="2-1">Option 1</el-menu-item>
                <el-menu-item index="2-2">Option 2</el-menu-item>
              </el-menu-item-group>
              <el-menu-item-group title="Group 2">
                <el-menu-item index="2-3">Option 3</el-menu-item>
              </el-menu-item-group>
              <el-sub-menu index="2-4">
                <template #title>Option 4</template>
                <el-menu-item index="2-4-1">Option 4-1</el-menu-item>
              </el-sub-menu>
            </el-sub-menu>
            <!--          <el-sub-menu index="3">-->
            <!--            <template #title>-->
            <!--              <el-icon><setting /></el-icon>-->
            <!--            </template>-->
            <!--            <el-menu-item-group>-->
            <!--              <template #title>Group 1</template>-->
            <!--              <el-menu-item index="3-1">Option 1</el-menu-item>-->
            <!--              <el-menu-item index="3-2">Option 2</el-menu-item>-->
            <!--            </el-menu-item-group>-->
            <!--            <el-menu-item-group title="Group 2">-->
            <!--              <el-menu-item index="3-3">Option 3</el-menu-item>-->
            <!--            </el-menu-item-group>-->
            <!--            <el-sub-menu index="3-4">-->
            <!--              <template #title>Option 4</template>-->
            <!--              <el-menu-item index="3-4-1">Option 4-1</el-menu-item>-->
            <!--            </el-sub-menu>-->
            <!--          </el-sub-menu>-->
          </el-menu>
        </el-scrollbar>
      </el-aside>

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
  }
}
</script>

<style scoped>


</style>