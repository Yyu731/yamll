<script setup>
import Header from './cpns/Header.vue'
import {useRouter} from "vue-router";

const router = useRouter()
const handlebackClick= () => {
  router.push("/home")
}
</script>

<template>
  <div class="pay-success">
    <Header/>
    <div class="container">
      <img src="../../assets/image/right.png">
      <div class="submit-btn">
        <div class="btn" @click="handlebackClick">
          <el-text tag="b" size="large" style="color: #FFFFFF">返回首页</el-text>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped lang="less">

.container {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  margin-top: 120px;

  img {
    width: 100px;
    height: 100px;
  }

  .submit-btn {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 50px;
    margin-top: 10px;
    box-sizing: border-box;

    .btn {
      display: flex;
      justify-content: center;
      align-items: center;
      height: 36px;
      width: 135px;
      border-radius: 4px;
      background-color: #e33d3f;

      &:hover {
        background-color: #ef4c4f;
        cursor: pointer;
      }
    }
  }
}
</style>