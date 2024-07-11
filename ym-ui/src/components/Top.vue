<script setup>
import {useRouter} from "vue-router";
import {storeToRefs} from "pinia";
import useUserStore from "@/stores/user.js";

const userStore = useUserStore()
const { userInfo } = storeToRefs(userStore)
const router = useRouter()
const handleLoginClick = () => {
  console.log("login")
  router.push({
    path: "/login"
  })
}

const handleLoginOutClick = () => {
  userStore.$reset()
  localStorage.clear()
  ElMessage({
    type: 'success',
    message: "退出成功"
  })
}
</script>

<template>
  <div class="top">
    <div class="container">
      <div class="left">
        <el-text size="small">洋芋欢迎您!</el-text>
        <template v-if="userInfo.username">
          <el-text size="small" type="primary">您好，{{ userInfo.username }}！</el-text>
          <el-text size="small" type="danger" @click="handleLoginOutClick">退出</el-text>
        </template>
        <template v-else>
          <el-text size="small" type="primary" @click="handleLoginClick">请登录</el-text>
          <el-text size="small" type="primary">免费注册</el-text>
        </template>
      </div>
      <div class="right">
        <el-text size="small" type="primary">首页</el-text>
        <el-text size="small">|</el-text>
        <el-text size="small" type="primary">我的购物车</el-text>
        <el-text size="small">|</el-text>
        <el-text size="small">我的洋芋</el-text>
        <el-text size="small">|</el-text>
        <el-text size="small">洋芋会员</el-text>
        <el-text size="small">|</el-text>
        <el-text size="small">企业采购</el-text>
        <el-text size="small">|</el-text>
        <el-text size="small">关注洋芋</el-text>
        <el-text size="small">|</el-text>
        <el-text size="small">客户服务</el-text>
        <el-text size="small">|</el-text>
        <el-text size="small">网站导航</el-text>
      </div>
    </div>
  </div>
</template>

<style scoped lang="less">
.top {
  background-color: #EAEAEA;

  .container {
    display: flex;
    justify-content: space-between;
    align-items: center;
    height: 30px;

    .left {
      .el-text {
        margin-right: 5px;
      }
    }

    .right {
      .el-text {
        padding: 0 5px;
      }
    }
  }
}
</style>