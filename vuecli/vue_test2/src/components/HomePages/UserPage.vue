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
                <el-form-item label="姓名">
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
                  <el-popconfirm
                      confirm-button-text="是"
                      cancel-button-text="算了"
                      icon-color="#626AEF"
                      title="确定要修改信息吗？"
                      @confirm="submit"
                  >
                    <template #reference>
                      <el-button type="primary">保存</el-button>
                    </template>
                  </el-popconfirm>
                  <el-button>取消</el-button>
                </el-form-item>
              </el-form>
            </el-main>
            <el-footer>
              <el-icon class="hvr-grow-shadow ">
                <Reading/>
              </el-icon>
              <el-icon class="hvr-grow-shadow">
                <Bell/>
              </el-icon>
              <el-icon class="hvr-grow-shadow">
                <Star/>
              </el-icon>
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
                    <el-descriptions :column="3" border>
                      <el-descriptions-item
                          label="书名"
                          label-align="right"
                          align="center"
                          label-class-name="my-label"
                          class-name="my-content"
                          width="150px"
                      >{{ "西游记" }}
                      </el-descriptions-item
                      >
                      <el-descriptions-item label="图书编号" label-align="right" align="center"
                      >{{ "205486490000" }}
                      </el-descriptions-item
                      >
                      <el-descriptions-item label="作者" label-align="right" align="center"
                      >{{ "吴承恩" }}
                      </el-descriptions-item
                      >
                      <el-descriptions-item label="还书时间" label-align="right" align="center">
                        <el-tag size="small">{{ "2022-6-12" }}</el-tag>
                      </el-descriptions-item>
                      <el-descriptions-item label="描述" label-align="right" align="center"
                      >{{ "全书主要描写了孙悟空出世及大闹天宫后，遇见了唐僧、猪八戒、沙僧和白龙马，西行取经，一路上 ...".substring(0, 10) + "..." }}
                      </el-descriptions-item
                      >
                    </el-descriptions>
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
                          v-for="(activity, index) in bookRecord"
                          :key="index"
                          :timestamp="activity.returnDate"
                      >
                        {{ activity.bookName }}
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
<script>
import {ElNotification} from 'element-plus'

export default {
  data() {
    return {
      form: {
        name: '',
        region: '',
        date1: '',
        date2: '',
        desc: '',
      },
      bookRecord: [
        {bookName: '书1', returnDate: "2022-04-15"},
        {bookName: '书2', returnDate: "2022-05-15"},
        {bookName: '书2', returnDate: "2022-06-15"},
      ],
      userInfo: {
        userId: '',
        userName: '',
        userRole: '',
      },

    }
  },
  methods: {
    submit() {
      this.successPopUp('应用中...','修改成功')
    },
    warningPopUp(message,title) {
      ElNotification({
        title ,
        message,
        type: 'warning',
      })
    },
    successPopUp(message,title) {
      ElNotification({
        title ,
        message,
        type: 'success',
      })
    }
  },
  mounted() {
    //添加登录判断
    this.warningPopUp("您还未登录",'无法访问服务')
    //this.successPopUp('您已成功登录','欢迎，用户' + this.userInfo.userName)
  }
}
</script>
<!--<script lang="ts" setup>-->
<!--import {reactive} from 'vue'-->
<!--// do not use same name with ref-->
<!--const form = reactive({-->

<!--})-->
<!--const activities = [-->
<!--  {-->
<!--    content: '书xxx',-->
<!--    timestamp: '2022-04-15',-->
<!--  },-->
<!--  {-->
<!--    content: '书xxx',-->
<!--    timestamp: '2018-04-13',-->
<!--  },-->
<!--  {-->
<!--    content: '书xxx',-->
<!--    timestamp: '2010-04-11',-->
<!--  },-->
<!--]-->
<!--const onSubmit = () => {-->
<!--  console.log('submit!')-->
<!--}-->

<!--</script>-->
style>