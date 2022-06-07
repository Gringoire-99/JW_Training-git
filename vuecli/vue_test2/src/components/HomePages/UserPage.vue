<template>
  <el-row :gutter="20">
    <el-col :span="12">
      <transition
          appear
          name="animate__animated"
          enter-active-class="animate__bounceIn"
      >
        <el-container>
          <el-header class="hvr-fade">
            <h4>我的信息</h4>
          </el-header>
          <div class="hvr-border-fade">
            <el-main>
              <el-form :model="form" label-width="120px">
                <el-form-item label="用户姓名">
                  <el-input v-model="form.name"/>
                </el-form-item>
                <el-form-item label="性别">
                  <el-select v-model="form.region" placeholder="请选择你的性别">
                    <el-option label="男" value="male"/>
                    <el-option label="女" value="female"/>
                  </el-select>
                </el-form-item>
                <el-form-item label="出生日期">
                  <el-col :span="11">
                    <el-date-picker
                        v-model="form.date1"
                        type="date"
                        placeholder="选择日期"
                        style="width: 100%"
                    />
                  </el-col>
                  <el-col :span="2" class="text-center">
                    <span class="text-gray-500">-</span>
                  </el-col>
                  <el-col :span="11">
                    <el-time-picker
                        v-model="form.date2"
                        placeholder="选择时间"
                        style="width: 100%"
                    />
                  </el-col>
                </el-form-item>
                <el-form-item label="备注">
                  <el-input v-model="form.desc" type="textarea"/>
                </el-form-item>
                <el-form-item>
                  <el-button type="primary" @click="onSubmit">保存</el-button>
                  <el-button>取消</el-button>
                </el-form-item>
              </el-form>
            </el-main>
            <el-footer >
              <el-icon class="hvr-grow-shadow "><Reading /></el-icon>
              <el-icon class="hvr-grow-shadow"><Bell /></el-icon>
              <el-icon class="hvr-grow-shadow" ><Star /></el-icon>
            </el-footer>
          </div>
          <hr>
          <el-container>
            <el-header class="hvr-fade">
              <h4>
                图书借阅
              </h4>
            </el-header>
            <el-main class="hvr-border-fade">
              <el-collapse>
                <el-collapse-item title="正在读" name="1">
                  <div>
                    ！BOOKLIST！
                  </div>
                  <div>
                    ！BOOKLIST！
                  </div>
                </el-collapse-item>
                <el-collapse-item title="收藏图书" name="2">
                  <div>
                    ！BOOKLIST！
                  </div>
                  <div>
                    ！BOOKLIST！
                  </div>
                </el-collapse-item>
                <el-collapse-item title="待还" name="3">
                  <div>
                    <el-timeline>
                      <el-timeline-item
                          v-for="(activity, index) in activities"
                          :key="index"
                          :timestamp="activity.timestamp"
                      >
                        {{ activity.content }}
                      </el-timeline-item>
                    </el-timeline>
                  </div>
                </el-collapse-item>
              </el-collapse>
            </el-main>
          </el-container>

        </el-container>
      </transition>

    </el-col>
    <transition
        appear
        name="animate__animated animate__jackInTheBox"
        enter-active-class="animate__jackInTheBox"
        leave-active-class="animate__bounceOut">
      <el-col :span="12">
        <el-container>
          <aside>
            <div class="separate"></div>
          </aside>
          <main>
            <div class="hvr-grow-shadow">
              <h1>
                欢迎使用<span style="color: #0794ff">LMS！</span><br>
              </h1>
              尊敬的用户：！username！
            </div>
            <p></p>
            <img src="../../assets/userPageImg.svg" style="width: 500px" class="hvr-grow-shadow">
          </main>
        </el-container>
      </el-col>
    </transition>
  </el-row>


</template>

<script lang="ts" setup>
import {reactive} from 'vue'
// do not use same name with ref
const form = reactive({
  name: '',
  region: '',
  date1: '',
  date2: '',
  delivery: false,
  type: [],
  resource: '',
  desc: '',
})
const activities = [
  {
    content: '书xxx',
    timestamp: '2022-04-15',
  },
  {
    content: '书xxx',
    timestamp: '2018-04-13',
  },
  {
    content: '书xxx',
    timestamp: '2010-04-11',
  },
]
const onSubmit = () => {
  console.log('submit!')
}

</script>
style>