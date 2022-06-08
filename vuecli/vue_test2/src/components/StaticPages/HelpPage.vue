<template>
  <div>
    <h1>
      帮助页面
    </h1>
    <el-steps :active="active" finish-status="success">
      <el-step title="Step 1" />
      <el-step title="Step 2" />
      <el-step title="Step 3" />
    </el-steps>
    <h4>
      帮助内容0
      这是帮助内容这是帮助内容这是帮助内容这是帮助内容这是帮助内容
      这是帮助内容这是帮助内容这是帮助内容这是帮助内容这是帮助内容
      这是帮助内容这是帮助内容这是帮助内容这是帮助内容这是帮助内容
    </h4>
    <h4 v-show="active.value==1">
      帮助内容1
      这是帮助内容这是帮助内容这是帮助内容这是帮助内容这是帮助内容
      这是帮助内容这是帮助内容这是帮助内容这是帮助内容这是帮助内容
      这是帮助内容这是帮助内容这是帮助内容这是帮助内容这是帮助内容
    </h4>
    <h4 v-show="active.value==2">
      帮助内容2
      这是帮助内容这是帮助内容这是帮助内容这是帮助内容这是帮助内容
      这是帮助内容这是帮助内容这是帮助内容这是帮助内容这是帮助内容
      这是帮助内容这是帮助内容这是帮助内容这是帮助内容这是帮助内容
    </h4>
    <h4 v-show="active.value==3">
      帮助内容3
      这是帮助内容这是帮助内容这是帮助内容这是帮助内容这是帮助内容
      这是帮助内容这是帮助内容这是帮助内容这是帮助内容这是帮助内容
      这是帮助内容这是帮助内容这是帮助内容这是帮助内容这是帮助内容
    </h4>
    <el-button style="margin-top: 12px" @click="next">Next step</el-button>


  </div>
</template>

<script lang="ts" setup>
import { ref } from 'vue'

const active = ref(0)

const next = () => {
  if (active.value++ > 2) active.value = 0
  console.log(active.value);
}
</script>

<style scoped>

</style>