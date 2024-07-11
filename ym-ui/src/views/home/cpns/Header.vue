<script setup>
import {storeToRefs} from "pinia";
import {useRouter} from "vue-router";
import useUserStore from "@/stores/user.js";
import useItemStore from "@/stores/item.js";
import {localCache} from "@/utils/cache.js"
import useCartStore from "@/stores/cart.js";

const router = useRouter()
const userStore = useUserStore()
const itemStore = useItemStore()
const cartStore = useCartStore()

const {userInfo} = storeToRefs(userStore)
const {pageQuery} = storeToRefs(itemStore)
const {cartList} = storeToRefs(cartStore)

const searchClick = () => {
  router.push("/search")
}

const cartClick = () => {
  if (!localCache.getCache("token")) {
    router.push("/login")
  } else {
    router.push("/cart")
  }
}


</script>

<template>
  <div class="main">
    <div class="container">
      <div class="header">
        <div class="left">
          <img class="logo" src="../../../assets/image/logo.png">
          <el-text size="large" tag="b" type="danger">洋芋商城</el-text>
        </div>
        <div class="center">
          <div class="search">
            <el-input
                v-model="pageQuery.key"
            >
              <template #append>
                <el-button @click="searchClick">搜索</el-button>
              </template>
            </el-input>
          </div>
          <div class="tag-list">
            <el-text size="small" type="danger">洋芋首发</el-text>
            <el-text size="small">亿元优惠</el-text>
            <el-text size="small">9.9元团购</el-text>
            <el-text size="small">满99减30</el-text>
            <el-text size="small">办公用品</el-text>
            <el-text size="small">限时优惠</el-text>
          </div>
        </div>
        <div class="right">
          <el-button color="#F7F7F7" dark @click="cartClick">
            <el-icon size="18" style="margin-right:6px" color="#C81523">
              <ShoppingCart/>
            </el-icon>
            <el-badge :value="cartList?.length ?cartList.length : ''" class="item" :offset="[10,-6]">
              <el-text size="small">
                我的购物车
              </el-text>
            </el-badge>
          </el-button>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped lang="less">
.header {
  display: flex;
  height: 105px;

  .left {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    width: 210px;

    .logo {
      width: 80px;
      height: 80px;
      object-fit: contain;
    }
  }

  .center {
    display: flex;
    flex-direction: column;
    width: 740px;
    height: 105px;
    padding: 0 100px;
    box-sizing: border-box;

    .search {
      width: 100%;
      margin: 26px 0 10px;

      :deep(.el-input__wrapper) {
        border: 3px solid #C81523;
        border-radius: 0;
        box-shadow: 0 0;
      }

      :deep(.el-input-group__append) {
        background-color: #C81523;
        border-radius: 0;
        box-shadow: 0 0;
        color: white;
        font-weight: 500;
        font-size: 14px;
      }
    }

    .tag-list {
      .el-text {
        margin-right: 20px;
      }
    }
  }

  .right {
    width: 250px;
    height: 105px;
    display: flex;
    justify-content: center;
    align-items: center;

    .el-button {
      font-size: 12px;
    }
  }
}
</style>