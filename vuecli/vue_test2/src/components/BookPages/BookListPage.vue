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
            <el-menu-item index="4">添加</el-menu-item>
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
                  :prefix-icon="Search"
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
          <el-table :data="filterList" style="width: 100%"
                    :stripe="true"
                    :border="true"
                    height="700"
                    max-height="700"
                    :default-sort="{ prop: 'bookId', order: 'descending' }"
          >
            <!--     折叠子面板      -->
            <el-table-column type="expand">
              <template #default="props">
                <transition
                    appear
                    name="animate__animated "
                    enter-active-class="animate__fadeIn"
                    leave-active-class="animate__bounceOut">
                  <el-container>
                    <el-aside width="350px">
                      <el-card class="box-card" shadow="always" style="overflow: clip">
                        <div class="hvr-box-shadow-outset">
                          <img
                              src="https://img.alicdn.com/imgextra/i1/2718889079/O1CN0197JYoj2GwEPkQLEcW_!!0-item_pic.jpg_430x430q90.jpg"
                              class="image" style=" width: 300px;height: 300px;"
                              alt="error"
                          />
                          <div style="padding: 14px">
                            <h4>{{ props.row.bookName }}</h4>
                            <el-icon>
                              <CollectionTag/>
                            </el-icon>
                            press by: {{ props.row.press }}
                            <el-button text class="button hvr-bounce-to-right" type="primary">详情页</el-button>
                          </div>
                        </div>
                      </el-card>
                    </el-aside>
                    <el-main>
                      <div class="hvr-backward">
                        <h4><span style="color: cornflowerblue">
                        图书简介
                      </span></h4>
                        <span>
                         Lorem ipsum dolor sit amet, consectetur adipisicing elit. A aliquid culpa dolore earum esse et eum
                      expedita, fugit iste laudantium libero molestias optio reiciendis veniam voluptate! Eos ex
                      provident saepe?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A ad cum id modi, molestiae nostrum rerum soluta. Corporis, dicta eveniet fugiat magnam maxime minima nam nesciunt porro, quas reprehenderit ullam!
                      Lorem ipsum dolor sit amet, consectetur adipisicing elit. Distinctio dolores eius enim est, excepturi exercitationem explicabo illo inventore ipsa labore laboriosam magnam neque quas qui, quisquam reiciendis repellat similique voluptas.
                      lorem  Lorem ipsum dolor sit amet, consectetur adipisicing elit. A aliquid culpa dolore earum esse et eum
                      lorem
                      </span>
                      </div>
                      <div style="height: 300px">
                        <el-row :gutter="20">
                          <el-col :span="9">
                            <el-row :gutter="20">
                              <div class="hvr-grow-shadow">
                                <el-col :span="24">
                                  <h4><span style="color: #1575d7"> Tags</span></h4>
                                  <el-card shadow="always">
                                    <el-tag
                                        class="mx-1"
                                        closable
                                        :disable-transitions="false"
                                    >
                                      {{ "传统" }}
                                    </el-tag>
                                    <el-tag
                                        class="mx-1"
                                        closable
                                        :disable-transitions="false"
                                    >
                                      {{ "大多数选择" }}
                                    </el-tag>
                                    <el-tag
                                        class="mx-1"
                                        closable
                                        :disable-transitions="false"
                                    >
                                      {{ "小说" }}
                                    </el-tag>
                                  </el-card>
                                </el-col>
                              </div>
                            </el-row>
                            <hr>
                            <el-row :gutter="20">
                              <el-col :span="24">
                                <div class="hvr-grow-shadow" style="width: 263px">
                                  <span style="color: #fd7f00"><h4> 打个分吧!</h4></span>
                                  <el-card shadow="always">
                                    <el-popover
                                        placement="top-start"
                                        title="感谢你的反馈！"
                                        :width="200"
                                        trigger="click"
                                        content="或许你还可以留下你的评论！"
                                    >
                                      <template #reference>
                                        <el-rate v-model="score" :colors="scoreColors"/>
                                      </template>
                                    </el-popover>

                                  </el-card>
                                </div>
                              </el-col>
                            </el-row>
                          </el-col>
                          <el-col :span="15">
                            <div class="hvr-grow-shadow" style="height: 250px">
                              <h4><span style="color: #cc0058">Commands</span></h4>
                              <el-card shadow="always">
                                <el-table :data="comments" style="width: 100%">
                                  <el-table-column label="用户" width="180">
                                    <template #default="scope">
                                      <div style="display: flex; align-items: center">
                                        <el-icon>
                                          <ChatLineRound/>
                                        </el-icon>
                                        <span style="margin-left: 10px">{{ scope.row.name }}</span>
                                      </div>
                                    </template>
                                  </el-table-column>
                                  <el-table-column label="Comments" width="180">
                                    <template #default="scope">
                                      <div>{{ scope.row.comment }}</div>
                                    </template>
                                  </el-table-column>
                                </el-table>
                              </el-card>
                            </div>
                          </el-col>
                        </el-row>
                      </div>
                    </el-main>
                  </el-container>
                </transition>
              </template>
            </el-table-column>

            <el-table-column label="书号" prop="bookId" sortable/>
            <el-table-column label="书名" prop="bookName" sortable/>
            <el-table-column label="价格" prop="bookPrice" sortable/>
            <el-table-column label="库存" prop="bookNumber" sortable/>
            <el-table-column label="出版社" prop="press" sortable/>
            <el-table-column label="借阅数" prop="borrowNumber" sortable/>
            <el-table-column fixed="right" label="操作" width="120">
              <template #default="scope">
                <el-button link type="primary"  @click="handleEdit(scope.$index, scope.row)"
                >修改
                </el-button
                >
              </template>
            </el-table-column>
          </el-table>
          <el-drawer
              v-model="isOpenFilter"
              title="筛选书籍"
              direction="rtl"
              size="35%"
          >
            <el-descriptions
                class="margin-top"
                title="筛选"
                :column="3"
                border
            >
              <el-descriptions-item>
                <template #label>
                  <div class="cell-item">
                    属性名
                  </div>
                </template>
                {{ filters.price.name }}
              </el-descriptions-item>
              <el-descriptions-item>
                <template #label>
                  <div class="cell-item">
                    最小
                  </div>
                </template>
                <el-input v-model="filters.price.lowest" type="number"></el-input>
              </el-descriptions-item>
              <el-descriptions-item>
                <template #label>
                  <div class="cell-item">
                    最大
                  </div>
                </template>
                <el-input v-model="filters.price.highest" type="number"></el-input>
              </el-descriptions-item>
              <el-descriptions-item>
                <template #label>
                  <div class="cell-item">
                    属性名
                  </div>
                </template>
                {{ filters.borrowNumber.name }}
              </el-descriptions-item>
              <el-descriptions-item>
                <template #label>
                  <div class="cell-item">
                    最小
                  </div>
                </template>
                <el-input v-model="filters.borrowNumber.lowest" type="number"></el-input>
              </el-descriptions-item>
              <el-descriptions-item>
                <template #label>
                  <div class="cell-item">
                    最大
                  </div>
                </template>
                <el-input v-model="filters.borrowNumber.highest" type="number"></el-input>
              </el-descriptions-item>
              <el-descriptions-item>
                <template #label>
                  <div class="cell-item">
                    属性名
                  </div>
                </template>
                {{ filters.bookNumber.name }}
              </el-descriptions-item>
              <el-descriptions-item>
                <template #label>
                  <div class="cell-item">
                    最小
                  </div>
                </template>
                <el-input v-model="filters.bookNumber.lowest" type="number"></el-input>
              </el-descriptions-item>
              <el-descriptions-item>
                <template #label>
                  <div class="cell-item">
                    最大
                  </div>
                </template>
                <el-input v-model="filters.bookNumber.highest" type="number"></el-input>
              </el-descriptions-item>

            </el-descriptions>
          </el-drawer>
        </el-main>
      </el-container>

    </div>
  </transition>
</template>

<script>
import {Search} from '@element-plus/icons-vue'
import {ElNotification} from 'element-plus'
let propMap = new Map()
propMap.set("书名", "bookName")
propMap.set("书号", "bookId")
propMap.set("作者", "bookAuthor")
propMap.set("出版社", "press")
propMap.set("库存", "bookNumber")
propMap.set("借阅数", "borrowNumber")
propMap.set("价格", "bookPrice")
export default {
  name: "BookListPage",
  data() {
    return {
      score: 0,
      scoreColors: ['#99A9BF', '#f68402', '#ff0026'],
      count: 0,
      isOpenFilter: false,
      isOpenSearch: false,

      filters: {
        price: {
          name: '价格',
          lowest: 0,
          highest: Number.MAX_VALUE,
        },
        bookNumber: {
          name: '库存',
          lowest: 0,
          highest: Number.MAX_VALUE,
        },
        bookId: {
          name: '书号',
        },
        bookName: {
          name: '书名',
        },
        bookAuthor: {
          name: '作者',
        },
        press: {
          name: '出版社',
        },
        borrowNumber: {
          name: '借阅数',
          lowest: 0,
          highest: Number.MAX_VALUE,
        },
      },
      keyWord: '',
      keyProp: '书名',

      modify:{
        price: {
          name: '价格',
          oldVal:'',
          newVal:'',
        },
        bookNumber: {
          name: '库存',
          oldVal:'',
          newVal:'',
        },
        bookId: {
          name: '书号',
          oldVal:'',
          newVal:'',
        },
        bookName: {
          name: '书名',
          oldVal:'',
          newVal:'',
        },
        bookAuthor: {
          name: '作者',
          oldVal:'',
          newVal:'',
        },
        press: {
          name: '出版社',
          oldVal:'',
          newVal:'',
        },
        borrowNumber: {
          name: '借阅数',
          oldVal:'',
          newVal:'',
        },
      }
    }
  },
  computed: {
    comments() {
      return this.$store.state.comments
    },
    filterList() {
      let bookList = this.$store.state.bookList
      let keyProp = propMap.get(this.keyProp)
      let keyWord = this.keyWord
      let fl = bookList.filter((book) => {
        return book.bookPrice >= this.filters.price.lowest && book.bookPrice <= this.filters.price.highest
            && book.bookNumber >= this.filters.bookNumber.lowest && book.bookNumber <= this.filters.bookNumber.highest
            && book.borrowNumber >= this.filters.borrowNumber.lowest && book.borrowNumber <= this.filters.borrowNumber.highest
      });
      fl = fl.filter((book) => ("" + book[keyProp]).indexOf(keyWord) !== -1)
      return fl;
    }
  },
  methods: {
    openFilter() {
      this.isOpenFilter = true
    },
    openSearch() {
      this.isOpenSearch = true
    },
    closeSearch() {
      this.isOpenSearch = false
    },
    reset() {
      this.filters = {
        price: {
          name: '价格',
          lowest: 0,
          highest: Number.MAX_VALUE,
        },
        bookNumber: {
          name: '库存',
          lowest: 0,
          highest: Number.MAX_VALUE,
        },
        borrowNumber: {
          name: '借阅数',
          lowest: 0,
          highest: Number.MAX_VALUE,
        },
      }
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
    },
    handleEdit(index, row){
      console.log(index, row)
    }
  }, mounted() {
    this.Search = Search
  }

}
</script>

<style scoped>
.mButton {
  width: 100px;
  height: 60px;
  border-radius: 0;
  background-color: #545c64;
  color: #ffd04b;
}

</style>