<template>
  <el-container style="background-color: black;color: white;">
    <el-aside width="50px">
    </el-aside>
    <el-main>
      <el-row :gutter="20" >
        <el-col :span="12">
          <el-container >

            <el-header>
              LMS你的图书管理系统
            </el-header>

            <el-main>

                <h1> <span class="hvr-grow-shadow">高效管理<span style="color: #f8a857">你的书籍！</span> </span></h1>


              <div style="height: 30px;"></div>
              <div class="hvr-grow-shadow" style="padding: 5px">
                Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ab adipisci amet, aperiam aut deleniti dolores eum exercitationem impedit laboriosam maxime pariatur, reiciendis repudiandae, tempore? Alias facilis maxime numquam obcaecati qui?
              Lorem ipsum dolor sit amet, consectetur adipisicing elit. Autem culpa cum deserunt nesciunt quibusdam similique tempora tenetur, veniam? Aspernatur blanditiis dolores facilis minima nemo nulla quo sapiente sequi? Quia, reprehenderit.
              </div>
            </el-main>
            <el-footer>
              <el-button type="primary" style="background-color: #1575d7;font-style: oblique;" class="hvr-grow-rotate">
                立即开启图书之旅！
              </el-button>
            </el-footer>
          </el-container>
        </el-col>

        <el-col :span="12">
          <el-container >

            <el-header>
              <el-row>
                <el-col :span="12">

                </el-col>
                <el-col :span="12">
                  <span style="color: #a9a4a4">
                  图书管理&nbsp;&nbsp;图书借阅&nbsp;&nbsp;图书搜索
                  </span>
                </el-col>
              </el-row>
            </el-header>

            <el-main>
              <img class="hvr-grow-shadow" src="../../assets/homePage_1.svg" style="width: 500px">
            </el-main>
          </el-container>
        </el-col>
      </el-row>
    </el-main>
    <el-footer style="background-color: #0794ff" height="90px">
      <el-container>
        <el-aside width="20px"></el-aside>
        <el-main>
          <el-row>
            <el-col :span="12">
              <span style="font-size: 30px">
              现在就注册账号 加入我们吧！
              </span>
            </el-col>
              <el-col :span="12">

                <el-input style="height: 40px;width: 500px;margin-top: 5px" placeholder="输入你的学号">
                </el-input>
                <el-button type="info" style="background-color: #282020;color: white;height: 43px">
                  注册
                </el-button>

              </el-col>
          </el-row>
        </el-main>
      </el-container>
    </el-footer>

  </el-container>
</template>

<script>
export default {
  name: "HomePage"
}
</script>

<style scoped>
el-container {
}

el-aside {
}

*{
  overflow: visible;
}
</style>