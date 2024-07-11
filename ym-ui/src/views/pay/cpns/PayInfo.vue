<script setup>
import {onMounted, onUnmounted, ref} from 'vue'
import {storeToRefs} from "pinia";
import useOrderStore from "@/stores/order.js";
import {formatRestTime} from "@/utils/time.js";
import useUserStore from "@/stores/user.js";
import {useRouter} from "vue-router";

const router = useRouter()
const userStore = useUserStore()
const orderStore = useOrderStore()
const {userInfo} = storeToRefs(userStore)
const {orderId, orderInfo} = storeToRefs(orderStore)

let countDown = ref("");
let timer;
onMounted(() => {
  timer = setInterval(() => {
    console.log(formatRestTime(orderInfo.value.createTime, 20))
    countDown.value = formatRestTime(orderInfo.value.createTime, 20)
  }, 1000)
})
onUnmounted(() => {
  clearInterval(timer)
})

const handlePayOrder = () => {
  orderStore.payOrderAction().then(res => {
    router.push("/pay-success")
  })
}
</script>

<template>
  <div class="container">
    <div class="pay-info">
      <div class="pay-summary">
        <div class="top">
          <div class="left">
            订单提交成功，请尽快付款！订单号：{{ orderId }}
          </div>
          <div class="right">
            应付金额
            <el-text style="color: #e31613; font-size: 18px;font-weight: 700">
              {{ (orderInfo.totalFee / 100 || 0).toFixed(2) }}
            </el-text>
            元
          </div>
        </div>
        <div class="bottom">
          <div class="left">
            推荐使用 扫码支付
            <div class="base-line">|</div>
            请您在
            <el-text>
              {{ countDown }}
            </el-text>
            内完成支付，否则订单会被自动取消
          </div>
          <div class="right">
            <el-text size="small">订单详情
              <el-icon style="margin-left: 6px">
                <CaretBottom/>
              </el-icon>
            </el-text>
          </div>
        </div>
      </div>
      <div class="pay-type">
        <div class="type-item">余额支付</div>
        <div class="rest-amount">余额：
          <span class="text">{{ (userInfo.balance / 100).toFixed(2) }}</span>
          元
        </div>
      </div>
      <div class="submit-btn">
        <div class="btn" @click="handlePayOrder">
          <el-text tag="b" size="large" style="color: #FFFFFF">立即支付</el-text>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped lang="less">
.pay-info {
  .pay-summary {
    display: flex;
    flex-direction: column;
    margin-top: 10px;
    height: 120px;
    padding: 0 40px 0 80px;

    .top {
      display: flex;
      justify-content: space-between;
      margin-top: 40px;
      height: 20px;

      .left {
        color: #333333;
        font-size: 14px;
      }

      .right {
        color: #666666;
        font-size: 12px;
      }
    }

    .bottom {
      display: flex;
      justify-content: space-between;
      margin-top: 6px;

      .left {
        display: flex;
        align-items: center;
        color: #666666;
        font-size: 12px;

        .el-text {
          padding: 0 8px;
          color: #E31613;
          font-size: 12px;
        }
      ;

        .base-line {
          margin: 0 12px;
        }
      }

      .right {
        .el-text {
          color: #67A4FF;
        }
      }
    }
  }

  .pay-type {
    display: flex;
    justify-content: space-between;
    padding: 30px 30px;
    border: 1px solid #EAEAEA;
    box-shadow: 0 6px 32px rgba(0, 0, 0, .13);
    box-sizing: border-box;
    color: #333333;
    font-weight: 700;
    font-size: 18px;

    .rest-amount {
      .text {
        color: #E31613;
      }
    }
  }

  .submit-btn {
    display: flex;
    justify-content: flex-end;
    align-items: center;
    height: 50px;
    margin-top: 10px;
    padding: 10px 20px 10px 0;
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