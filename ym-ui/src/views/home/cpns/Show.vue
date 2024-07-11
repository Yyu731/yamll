<script setup>

</script>

<template>
  <div class="container">
    <div class="show">
      <div class="time">
        <img class="icon" src="../../../assets/image/recommend/clock.png"/>
        <el-text size="large" tag="b">今日推荐</el-text>
      </div>
      <div class="recommend">
        <div class="item">
          <img src="../../../assets/image/recommend/today01.png">
        </div>
        <div class="item">
          <img src="../../../assets/image/recommend/today02.png">
        </div>
        <div class="item">
          <img src="../../../assets/image/recommend/today03.png">
        </div>
        <div class="item">
          <img src="../../../assets/image/recommend/today04.png">
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped lang="less">
.show {
  display: flex;
  margin-top: 10px;
  height: 165px;
  background-color: #EAEAEA;

  .time {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    padding: 30px 0;
    height: 165px;
    width: 200px;
    box-sizing: border-box;
    background-color: #5c5251;

    .icon {
      height: 57px;
      width: 57px;
    }

    .el-text {
      margin-top: 12px;
      font-size: 18px;
      color: white;
    }
  }

  .recommend {
    display: flex;
    .item {
      height: 165px;
      width: 250px;
    }
  }
}

</style>