<script setup>

import useCartStore from "@/stores/cart.js";
import {useRouter} from "vue-router";

const props = defineProps({
  item: {
    brand: "华为",
    category: "手机",
    commentCount: 0,
    id: "1",
    image: "https://m.360buyimg.com/mobilecms/s720x720_jfs/t7804/212/1308671016/161589/6dd9c5fc/599c0da5N88410391.jpg!q70.jpg.webp",
    isAD: false,
    name: "华为畅享7 Plus 3GB+32GB 移动4G版 香槟金 移动联通电信4G手机 双卡双待",
    price:211600,
    sold: 0,
    spec: "",
    status: 0,
    stock: 0,
  }
})
const router = useRouter()
const cartStore = useCartStore()
const addItem2Cart = (item) => {
  cartStore.addItem2CartAction(item).then(res => {
    ElMessage({
      type: 'success',
      message: res
    })
    router.push("/cart")
  }).catch(err => {
    ElMessage({
      type: 'error',
      message: err
    })
  })
}

</script>

<template>
  <div class="item">
    <el-card body-style="padding: 20px 10px" style="height: 400px; width: 230px" shadow="hover">
      <img class="image" :src="item.image"/>
      <el-space direction="horizontal" :size="0">
        <el-text class="price" tag="b">￥</el-text>
        <el-text class="num" tag="b">{{ 1.0 * item.price / 100 }}</el-text>
      </el-space>
      <el-link :underline="false">
        <el-text class="name" size="small" line-clamp="2" v-html="item.name"/>
      </el-link>
      <div class="comment">
        <el-text class="comment-num">{{ item.commentCount }}</el-text>
        <el-text class="desc"> 条评论</el-text>
      </div>
      <div class="sale">
        <el-text class="desc">最近一个月销量:</el-text>
        <el-text class="sale-num">{{ item.sold }}</el-text>
      </div>
      <div class="btns">
        <div class="btn">
          <el-text size="small">立即购买</el-text>
        </div>
        <div class="btn" @click="addItem2Cart(item)">
          <el-text size="small">加入购物车</el-text>
        </div>
      </div>
    </el-card>
  </div>
</template>

<style scoped lang="less">

.item {
  :deep(.el-card__body) {
    display: flex;
    flex-direction: column;
    align-items: flex-start;

    .image {
      align-self: center;
      height: 200px;
      width: 200px;
    }

    .price,
    .num {
      margin-top: 8px;
      font-size: 20px;
      align-self: flex-start;
      color: #E4393C;
    }

    .name {
      margin-top: 8px;
      align-self: flex-start;

      &:hover {
        color: red;
      }
    }

    .comment .comment-num,
    .sale .sale-num {
      font-weight: 700;
      color: #646FB0;
    }

    .comment,
    .sale {
      margin-top: 8px;
    }
  }

  .btns {
    display: flex;
    justify-content: space-around;
    margin-top: 12px;
    width: 100%;

    .btn {
      display: flex;
      justify-content: center;
      align-items: center;
      width: 92px;
      height: 24px;
      border: 1px solid #FF0000;

      .el-text {
        color: #FF0000;
      }

      &:hover {
        background-color: #FF0000;
        cursor: pointer;
      }

      &:hover .el-text {
        color: #FFFFFF;
      }
    }
  }

}
</style>