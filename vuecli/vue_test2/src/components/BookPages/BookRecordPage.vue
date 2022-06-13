<template>
  <transition
      appear
      name="animate__animated "
      enter-active-class="animate__fadeInLeft"
      leave-active-class="animate__bounceOut">
    <div>
      <el-container>
        <el-header>
          <div class="h-6"/>
          <el-menu
              class="el-menu-demo"
              mode="horizontal"
              background-color="#545c64"
              text-color="#fff"
              active-text-color="#ffd04b"
          >
            <el-menu-item index="1" @click="openFilter">筛选</el-menu-item>
            <el-menu-item index="2" @mouseenter="openSearch">搜索</el-menu-item>
            <el-menu-item index="3" @click="reset();successPopUp('已重置筛选项！','重置')">重置</el-menu-item>
            <el-menu-item index="4" @click="openAdd">添加</el-menu-item>
          </el-menu>

        </el-header>
        <el-main>
          <transition
              appear
              name="animate__animated"
              enter-active-class="animate__bounceIn"
              leave-active-class="animate__bounceOut"
          >
            <div v-show="isOpenSearch" style="width: 500px;display: flex">
              <el-input
                  placeholder="请输入查找关键词"
                  v-model="keyWord"
              ></el-input>
              <el-select class="m-2" placeholder="Select" size="large" v-model="keyProp">
                <el-option
                    v-for="(prop,index) in filters"
                    :key="index"
                    :label="prop.name"
                    :value="prop.name"
                />
              </el-select>

            </div>
          </transition>
          <el-table :data="pageList" style="width: 100%"
                    :stripe="true"
                    :border="true"
                    height="600"
                    max-height="600"
                    :default-sort="{ prop: 'bookId', order: 'descending' }"
          >
            <!--表格属性-->
            <el-table-column label="借阅书籍Id" prop="borrowBookId" sortable/>
            <el-table-column label="借阅者Id" prop="borrowUserId" sortable/>
            <el-table-column label="借阅时间" prop="borrowDate" sortable/>
            <el-table-column label="归还时间" prop="returnDate" sortable/>
            <el-table-column fixed="right" label="操作" width="120">
              <template #default="scope">
                <el-button link type="primary" @click="handleModify(scope.$index, scope.row);openModify()"
                >修改
                </el-button
                >
                <el-button link type="primary" @click="handelDelete(scope.$index, scope.row);"
                >删除
                </el-button
                >

              </template>
            </el-table-column>
          </el-table>
          <el-drawer
              v-model="isOpenModify"
              direction="rtl"
              size="35%"
          >
            <el-card class="box-card">
              <template #header>
                <div class="card-header">
                  <h4>修改数据</h4>
                </div>
                <p></p>
                <el-descriptions
                    class="margin-top"
                    title="旧数据"
                    :column="3"
                    border
                >
                  <el-descriptions-item v-for="(prop,index) in modify" :key='index'>
                    <template #label>
                      <div class="cell-item">
                        {{ prop.name }}
                      </div>
                    </template>
                    {{ prop.oldVal }}
                  </el-descriptions-item>
                </el-descriptions>
                <p></p>
                <el-descriptions
                    class="margin-top"
                    title="新数据"
                    :column="3"
                    border
                >
                  <el-descriptions-item v-for="(prop,index) in modify" :key='index'>
                    <template #label>
                      <div class="cell-item">
                        {{ prop.name }}
                      </div>
                    </template>
                    <el-input v-model.trim="prop.newVal"></el-input>
                  </el-descriptions-item>
                </el-descriptions>
              </template>
              <div class="bottom">
                <el-popconfirm
                    confirm-button-text="是"
                    cancel-button-text="算了"
                    icon-color="#626AEF"
                    title="确定要修改信息吗？"
                    @confirm="submitModify"
                >
                  <template #reference>
                    <el-button type="primary">保存</el-button>
                  </template>
                </el-popconfirm>
                <el-button @click="closeModify">取消</el-button>
              </div>
            </el-card>
          </el-drawer>
          <el-drawer
              v-model="isOpenAdd"
              direction="rtl"
              size="35%"
          >
            <el-card class="box-card">
              <template #header>
                <div class="card-header">
                  <h4>添加数据</h4>
                </div>
                <p></p>
                <el-descriptions
                    class="margin-top"
                    title="新数据"
                    :column="3"
                    border
                >
                  <el-descriptions-item v-for="(prop,index) in add" :key='index'>
                    <template #label>
                      <div class="cell-item">
                        {{ prop.name }}
                      </div>
                    </template>
                    <el-input v-model.trim="prop.newVal"></el-input>
                  </el-descriptions-item>
                </el-descriptions>
              </template>
              <div class="bottom">
                <el-popconfirm
                    confirm-button-text="是"
                    cancel-button-text="算了"
                    icon-color="#626AEF"
                    title="确定要添加书籍信息吗？"
                    @confirm="submitAdd"
                >
                  <template #reference>
                    <el-button type="primary">添加</el-button>
                  </template>
                </el-popconfirm>
                <el-button @click="closeAdd">取消</el-button>
              </div>
            </el-card>
          </el-drawer>
        </el-main>
        <el-footer>
          <el-pagination
              v-model:currentPage="currentPage"
              v-model:page-size="pageSize"
              :page-sizes="[20,40, 80, 120, 200]"
              :background="true"
              layout="total, sizes, prev, pager, next, jumper"
              :total="total"
          />
        </el-footer>
      </el-container>

    </div>
  </transition>
</template>

<script>
import {ElNotification} from "element-plus";

let propMap = new Map()
propMap.set("书号", "bookId")
propMap.set("学号", "userId")
propMap.set("归还时间", "returnDate")
propMap.set("借书时间", "borrowDate")
let checkData = function (data) {
  //数值性数据验证
  if ((!/^\d+$/.test("" + data.bookId.newVal)) || (!/^\d+$/.test("" + data.bookNumber.newVal)) || (!/^\d+$/.test("" + data.borrowNumber.newVal)) || (!/^\d+$/.test("" + data.bookPrice.newVal))) {
    return "含有错误数据"
  }
  //字符串性数据验证
  if ((!/^[\u4E00-\u9FA5A-Za-z\d_ ]+$/.test(data.press.newVal)) || (!/^[\u4E00-\u9FA5A-Za-z\d_ ]+$/.test(data.press.newVal)) || (!/^[\u4E00-\u9FA5A-Za-z\d_ ]+$/.test(data.bookName.newVal))) {
    return "含有错误数据"
  }
  return "correct"
}

export default {
  name: "BookRecordPage",
  data() {
    return {
      currentPage: 1,
      pageSize: 200,

      isOpenFilter: false,
      isOpenSearch: false,
      isOpenModify: false,
      isOpenAdd: false,

      filters: {
        userId: {
          name: '用户Id',
          lowest: 0,
          highest: Number.MAX_VALUE,
        },
        bookId: {
          name: '图书Id',
          lowest: 0,
          highest: Number.MAX_VALUE,
        },
        borrowDate: {
          name: '借书时间'
        },
        returnDate: {
          name: '还书时间'
        },

      },
      keyWord: '',
      keyProp: '用户Id',

      modify: {
        userId: {
          name: '用户Id',
          oldVal: '',
          newVal: '',
        },
        bookId: {
          name: '图书Id',
          oldVal: '',
          newVal: '',
        },
        borrowDate: {
          name: '借书时间',
          oldVal: '',
          newVal: '',
        },
        returnDate: {
          name: '还书时间',
          oldVal: '',
          newVal: '',
        },
      },
      add: {
        userId: {
          name: '用户Id',
          newVal: '',
        },
        bookId: {
          name: '图书Id',
          newVal: '',
        },
        borrowDate: {
          name: '借书时间',
          newVal: '',
        },
        returnDate: {
          name: '还书时间',
          newVal: '',
        },
      },
    }
  }, computed: {
    filterList() {
      let bookRecord = this.$store.state.bookRecord
      let keyProp = propMap.get(this.keyProp)
      let keyWord = this.keyWord

      let fl = bookRecord.filter((record) => ("" + record[keyProp]).indexOf(keyWord) !== -1)
      console.log(fl)


      return fl;
    },
    pageList() {
      let currentPage = this.currentPage
      let pageSize = this.pageSize
      let start = (currentPage - 1) * pageSize
      let end = currentPage * pageSize - 1
      let fl = this.filterList
      fl = fl.slice(start, end)
      return fl
    },
    total() {
      return this.filterList.length
    },
  },

  methods: {
    openFilter() {
      this.isOpenFilter = true
    },
    openSearch() {
      this.isOpenSearch = true
    },
    openModify() {
      this.isOpenModify = true
    },
    openAdd() {
      this.isOpenAdd = true
    },
    closeSearch() {
      this.isOpenSearch = false
    },
    closeModify() {
      this.isOpenModify = false
    },
    closeAdd() {
      this.isOpenAdd = false
    },
    reset() {
      this.filters = {
        userId: {
          name: '用户Id',
          lowest: 0,
          highest: Number.MAX_VALUE,
        },
        bookId: {
          name: '图书Id',
          lowest: 0,
          highest: Number.MAX_VALUE,
        },
      }
    },
    warningPopUp(message, title) {
      ElNotification({
        title,
        message,
        type: 'error',
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
  }
}
</script>

<style scoped>

</style>