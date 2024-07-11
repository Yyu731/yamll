<script setup>
</script>

<template>
  <div class="main">
    <div class="container">
      <div class="sort" >
        <div class="left"/>
        <div class="center">
          <el-text size="large">服装城</el-text>
          <el-text size="large">美妆城</el-text>
          <el-text size="large">洋芋超市</el-text>
          <el-text size="large">全球购</el-text>
          <el-text size="large">闪购</el-text>
          <el-text size="large">团购</el-text>
          <el-text size="large">有趣</el-text>
          <el-text size="large" type="primary">秒杀</el-text>
        </div>
        <div class="right"/>
      </div>
    </div>
  </div>
</template>

<style scoped lang="less">
.main {
  border-bottom: 2px solid #b1191a;
}
.sort {
  display: flex;
  .center {
    flex: 1;
    display: flex;
    justify-content: space-around;
    height: 45px;
  }
  .left {
    width: 210px;
  }
  .right {
    width: 250px;
  }
}
</style>