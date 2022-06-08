<template>
  <div>
    <el-container>
      <el-header>

        <el-menu
            :default-active="activeIndex2"
            class="el-menu-demo"
            mode="horizontal"
            background-color="#545c64"
            text-color="#fff"
            active-text-color="#ffd04b"
            @select="handleSelect"
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
              <div m="4">
                <p m="t-0 b-2">State: {{ props.row.bookAuthor }}</p>
                <p m="t-0 b-2">City: {{ props.row.bookPrice }}</p>
                <p m="t-0 b-2">Address: {{ props.row.press }}</p>
                <p m="t-0 b-2">Zip: {{ props.row.zip }}</p>
              </div>
            </template>
          </el-table-column>

          <el-table-column label="书号" prop="bookId"/>
          <el-table-column label="书名" prop="bookName"/>
          <el-table-column label="库存" prop="bookNumber"/>
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