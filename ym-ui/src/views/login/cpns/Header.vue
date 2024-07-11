<script setup>
import {ref} from 'vue'

const searchKey = ref("")
</script>

<template>
  <div class="main">
    <div class="container">
      <div class="header">
        <div class="left">
          <img class="logo" src="../../../assets/image/logo.png">
          <el-text size="large" tag="b" type="danger">洋芋商城</el-text>
        </div>
        <div class="welcome">
          <el-text size="large" tag="b">欢迎登录</el-text>
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
    width: 180px;

    .logo {
      width: 80px;
      height: 80px;
      object-fit: contain;
    }
  }

  .welcome{
    display: flex;
    justify-content: center;
    align-items: center;
    height: 105px;
    .el-text {
      font-size: 24px;
    }
  }

}
</style>