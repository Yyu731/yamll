<script setup>
import Item from "@/views/search/cpns/Item.vue";
import {ref} from "vue";
import {storeToRefs} from "pinia";
import useItemStore from "@/stores/item.js";

const itemStore = useItemStore()
const {pageQuery, pageResult, itemList} = storeToRefs(itemStore)

const handleCurrentChange = (currentPage) => {
  itemStore.pageQueryAction()
}

const sortField = ['','sold','price']
const sortType = ref(0)
const handleSortTypeChange = (type) => {
  if (sortType.value !== type) {
    itemStore.pageQuery.isAsc = false
    itemStore.pageQuery.sortBy = sortField[type]
    sortType.value = type
  } else {
    itemStore.pageQuery.isAsc = !itemStore.pageQuery.isAsc
  }
  itemStore.pageQuery.pageNo = 1
  itemStore.pageQuery.pageSize = 20
  itemStore.pageQueryAction()
}


</script>

<template>
  <div class="container">
    <div class="top">
      <div class="sort">
        <el-link :underline="false" :class="['sort-item',sortType === 0 ? 'active':'']"
                 @click="handleSortTypeChange(0)">默认
        </el-link>
        <el-link :underline="false" :class="['sort-item',sortType === 1 ? 'active':'']"
                 @click="handleSortTypeChange(1)">销量
          <el-icon>
            <component :is="sortType === 1 && pageQuery.isAsc ?'CaretTop':'CaretBottom'"/>
          </el-icon>
        </el-link>
        <el-link :underline="false" :class="['sort-item',sortType === 2 ? 'active':'']"
                 @click="handleSortTypeChange(2)">价格
          <el-icon>
            <el-icon>
              <component :is="sortType === 2 && pageQuery.isAsc ?'CaretTop':'CaretBottom'"/>
            </el-icon>
          </el-icon>
        </el-link>
      </div>
      <div class="pagination">
        <el-pagination
            v-model:current-page="pageQuery.pageNo"
            :page-count="Math.min(Math.ceil(pageResult.total / 20),50)"
            :total="+pageResult.total"
            size="small"
            background
            layout="total, prev, pager, next, jumper"

            @current-change="handleCurrentChange"
        />

      </div>
    </div>
    <div class="item-list">
      <template v-for="item in itemList" :key="item">
        <Item class="item" :item="item"/>
      </template>
    </div>
  </div>
</template>

<style scoped lang="less">

.top {
  --el-color-primary: #C81523;
  height: 40px;
  display: flex;
  justify-content: space-between;
  align-items: center;

  .sort {
    display: flex;
    font-size: 14px;

    .sort-item {
      display: flex;
      align-items: center;
      margin-right: 8px;

      &.active {
        font-weight: 700;
        color: #C81523;
      }
    }
  }
}

.item-list {
  display: flex;
  justify-content: space-between;
  flex-wrap: wrap;

  .item {
    margin-top: 10px;
  }
}
</style>