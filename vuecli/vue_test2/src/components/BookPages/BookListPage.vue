<template>
  <transition
      appear
      name="animate__animated "
      enter-active-class="animate__fadeInLeft"
      leave-active-class="animate__bounceOut">
    <div>
      <el-container>
        <el-header>
          <el-menu
              class="el-menu-demo"
              mode="horizontal"
              background-color="#545c64"
              text-color="#fff"
              active-text-color="#ffd04b"
          >

            <el-menu-item index="1">Processing Center</el-menu-item>
            <el-sub-menu index="2">
              <template #title>Workspace</template>
              <el-menu-item index="2-1">item one</el-menu-item>
              <el-menu-item index="2-2">item two</el-menu-item>
              <el-menu-item index="2-3">item three</el-menu-item>
              <el-sub-menu index="2-4">
                <template #title>item four</template>
                <el-menu-item index="2-4-1">item one</el-menu-item>
                <el-menu-item index="2-4-2">item two</el-menu-item>
                <el-menu-item index="2-4-3">item three</el-menu-item>
              </el-sub-menu>
            </el-sub-menu>
            <el-menu-item index="3" disabled>Info</el-menu-item>
            <el-menu-item index="4">Orders</el-menu-item>

          </el-menu>

        </el-header>
        <el-main>

          <el-table :data="bookList" style="width: 100%">

            <el-table-column type="expand">
              <template #default="props">
                <transition
                    appear
                    name="animate__animated "
                    enter-active-class="animate__fadeIn"
                    leave-active-class="animate__bounceOut">
                  <el-container>
                    <el-aside>
                      <el-card :body-style="{ padding: '0px' }">
                        <img
                            src="https://img.alicdn.com/imgextra/i1/2718889079/O1CN0197JYoj2GwEPkQLEcW_!!0-item_pic.jpg_430x430q90.jpg"
                            class="image" style="width: 300px;height: 300px"
                        />
                        <div style="padding: 14px">
                          <span>Yummy hamburger</span>
                          <div class="bottom">
                            <el-button text class="button">Operating</el-button>
                          </div>
                        </div>
                      </el-card>
                      <div>
                        <p>书号: {{ props.row.bookId }}</p>
                        <p>书名: {{ props.row.bookName }}</p>
                        <p>价格: {{ props.row.bookPrice }}</p>
                        <p>库存: {{ props.row.bookNum }}</p>
                        <p>出版社: {{ props.row.press }}</p>
                        <p>借阅数: {{ props.row.borrowNumber }}</p>
                      </div>
                    </el-aside>
                    <el-main>
                      <h4>图书简介</h4>
                      <span>
                         Lorem ipsum dolor sit amet, consectetur adipisicing elit. A aliquid culpa dolore earum esse et eum
                      expedita, fugit iste laudantium libero molestias optio reiciendis veniam voluptate! Eos ex
                      provident saepe?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A ad cum id modi, molestiae nostrum rerum soluta. Corporis, dicta eveniet fugiat magnam maxime minima nam nesciunt porro, quas reprehenderit ullam!
                      Lorem ipsum dolor sit amet, consectetur adipisicing elit. Distinctio dolores eius enim est, excepturi exercitationem explicabo illo inventore ipsa labore laboriosam magnam neque quas qui, quisquam reiciendis repellat similique voluptas.
                      lorem  Lorem ipsum dolor sit amet, consectetur adipisicing elit. A aliquid culpa dolore earum esse et eum
                      expedita, fugit iste laudantium libero molestias optio reiciendis veniam voluptate! Eos ex
                      provident saepe?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A ad cum id modi, molestiae nostrum rerum soluta. Corporis, dicta eveniet fugiat magnam maxime minima nam nesciunt porro, quas reprehenderit ullam!
                      Lorem ipsum dolor sit amet, consectetur adipisicing elit. Distinctio dolores eius enim est, excepturi exercitationem explicabo illo inventore ipsa labore laboriosam magnam neque quas qui, quisquam reiciendis repellat similique voluptas.
                      lorem
                      </span>

                    </el-main>
                  </el-container>
                </transition>
              </template>
            </el-table-column>

            <el-table-column label="书号" prop="bookId"/>
            <el-table-column label="书名" prop="bookName"/>
            <el-table-column label="价格" prop="bookPrice"/>
            <el-table-column label="库存" prop="bookNumber"/>
            <el-table-column label="出版社" prop="press"/>
            <el-table-column label="借阅数" prop="borrowNumber"/>
            <el-table-column fixed="right" label="Operations" width="120">
              <template #default>
                <el-button link type="primary" size="small"
                >Detail
                </el-button
                >
                <el-button link type="primary" size="small">Edit</el-button>
              </template>
            </el-table-column>
          </el-table>

        </el-main>
      </el-container>

    </div>
  </transition>
</template>

<script>
export default {
  name: "BookListPage",
  computed: {
    bookList() {
      return this.$store.state.bookList
    }
  }

}
</script>

<style scoped>

</style>