<template>
  <el-row :gutter="20">
    <el-col :span="12">
      <transition
          appear
          enter-active-class="animate__bounceIn"
          name="animate__animated"
      >
        <el-container>
          <el-header class="hvr-fade">
            <h4>我的信息</h4>
          </el-header>
          <div class="hvr-border-fade">
            <el-main>
              <el-form label-width="120px">
                <el-form-item label="姓名">
                  <el-input v-model="userName"/>
                </el-form-item>
                <el-form-item label="性别">
                  <el-select v-model="gender" placeholder="请选择你的性别">
                    <el-option label="男" value="male"/>
                    <el-option label="女" value="female"/>
                  </el-select>
                </el-form-item>
                <el-form-item label="出生日期">
                  <el-col :span="11">
                    <el-date-picker
                        v-model="birthdate"
                        placeholder="选择日期"
                        style="width: 100%"
                        type="date"
                    />
                  </el-col>
                  <el-col :span="2" class="text-center">
                    <span class="text-gray-500">-</span>
                  </el-col>
                  <el-col :span="11">
                    <!-- 待添加模型-->
                    <el-time-picker
                        placeholder="选择时间"
                        style="width: 100%"
                    />
                  </el-col>
                </el-form-item>
                <el-form-item label="备注">
                  <el-input v-model="remark" type="textarea"/>
                </el-form-item>
                <el-form-item>
                  <el-popconfirm
                      cancel-button-text="算了"
                      confirm-button-text="是"
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
                <el-collapse-item name="1" title="正在读">
                  <div>
                    <el-descriptions :column="3" border>
                      <el-descriptions-item
                          align="center"
                          class-name="my-content"
                          label="书名"
                          label-align="right"
                          label-class-name="my-label"
                          width="150px"
                      >{{ "西游记" }}
                      </el-descriptions-item
                      >
                      <el-descriptions-item align="center" label="图书编号" label-align="right"
                      >{{ "205486490000" }}
                      </el-descriptions-item
                      >
                      <el-descriptions-item align="center" label="作者" label-align="right"
                      >{{ "吴承恩" }}
                      </el-descriptions-item
                      >
                      <el-descriptions-item align="center" label="还书时间" label-align="right">
                        <el-tag size="small">{{ "2022-6-12" }}</el-tag>
                      </el-descriptions-item>
                      <el-descriptions-item align="center" label="描述" label-align="right"
                      >{{ "全书主要描写了孙悟空出世及大闹天宫后，遇见了唐僧、猪八戒、沙僧和白龙马，西行取经，一路上 ...".substring(0, 10) + "..." }}
                      </el-descriptions-item
                      >
                    </el-descriptions>
                  </div>
                </el-collapse-item>
                <el-collapse-item name="2" title="收藏图书">
                  <div>
                    ！BOOKLIST！
                  </div>
                  <div>
                    ！BOOKLIST！
                  </div>
                </el-collapse-item>
                <el-collapse-item name="3" title="待还">
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
        enter-active-class="animate__jackInTheBox"
        leave-active-class="animate__bounceOut"
        name="animate__animated animate__jackInTheBox">

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
              <span>
                尊敬的用户：{{ userName }}
              </span>
            </div>
            <p></p>
            <img class="hvr-grow-shadow" src="../../assets/userPageImg.svg" style="width: 500px">
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
    }
  },
  computed: {
    userName() {
      return this.$store.state.user.userName
    },
    userId() {
      return this.$store.state.user.userId
    },
    role() {
      return this.$store.state.user.role
    },
    gender() {
      return this.$store.state.user.gender
    },
    birthdate() {
      return this.$store.state.user.birthdate
    },
    remark() {
      return this.$store.state.user.remark
    },
  },
  methods: {
    submit() {
      this.successPopUp('应用中...', '修改成功')
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
    }
  },

}
</script>

<style>

</style>