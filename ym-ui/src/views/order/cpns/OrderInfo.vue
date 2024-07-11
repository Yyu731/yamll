<script setup>
import AdderssItem from './AdderssItem.vue'
import PayItem from './PayItem.vue'
import {computed, ref} from 'vue'
import {storeToRefs} from "pinia";
import useUserStore from "@/stores/user.js";
import useCartStore from "@/stores/cart.js";
import useOrderStore from "@/stores/order.js";
import {useRouter} from "vue-router";

const router = useRouter()
const userStore = useUserStore()
const cartStore = useCartStore()
const orderStore = useOrderStore()
const {addressList, activeId} = storeToRefs(userStore)
const {selectCartList} = storeToRefs(cartStore)
const {payTypeList, activePaymentId} = storeToRefs(orderStore)

const deliverType = ref(0)
const handleDeliverTypeItemClick = (type) => {
  deliverType.value = type
}

const getActiveAddress = computed(() => addressList?.value.filter(item => item.id === activeId.value)[0] || [])
const getTotalAccount = (selectCartList.value.reduce((sum,item) => sum + item.num * item.newPrice,0) / 100).toFixed(2)

const handleCreateOrder = () => {
  orderStore.createOrderAction({
    addressId: activeId.value,
    paymentType: activePaymentId.value,
    details: selectCartList.value
  }).then(res => {
    router.push("/pay")
  })
}
</script>

<template>
  <div class="container">
    <div class="order-info">
      <div class="title" style="margin-top: 20px;margin-bottom: 10px">
        <el-space size="small">
          <el-text tag="b" size="large">填写并核对订单信息</el-text>
        </el-space>
      </div>
      <div class="order-detail">
        <div class="area">
          <div class="head">
            <el-text tag="b">收货人信息</el-text>
            <el-link class="new">新增收货地址</el-link>
          </div>
          <div class="addr-list">
            <template v-for="item in addressList" :key="item">
              <AdderssItem :addressItem="item"/>
            </template>
          </div>
        </div>
        <div class="area">
          <div class="head">
            <el-text tag="b">支付方式</el-text>
          </div>
          <div class="pay-list">
            <template v-for="item in payTypeList" :key="item">
              <PayItem :payType="item"/>
            </template>
          </div>
        </div>
        <div class="area">
          <div class="head">
            <el-text tag="b">送货清单</el-text>
            <el-link class="new">返回修改购物车</el-link>
          </div>
          <div class="item-list">
            <div class="cart-item-list" style="display: flex; background-color: #F7F7F7">
              <div class="left" style="flex: 1; padding: 10px 10px 10px 20px">
                <el-text tag="b">配送方式</el-text>
                <div class="deliver-type">
                  <div :class="['deliver-type-item', deliverType === 0 ? 'active' : '']"
                       @click="handleDeliverTypeItemClick(0)">
                    <div class="choose">
                      洋芋快递
                      <div class="icon"/>
                    </div>
                  </div>
                  <div :class="['deliver-type-item', deliverType === 1 ? 'active' : '']"
                       @click="handleDeliverTypeItemClick(1)">
                    <div class="choose">
                      上门自提
                      <div class="icon"/>
                    </div>
                  </div>
                </div>
                <div class="deliver-time" style="margin-top: 20px; height: 30px;border-bottom: 1px solid #EAEAEA">
                  <el-text tag="b" style="color: #999999">标&nbsp;&nbsp;准&nbsp;&nbsp;达：</el-text>
                  <el-text style="color: #666666" size="default">预计 7月12日(周五) 09:00-15:00</el-text>
                  <el-text style="color: #005EA7;margin-left: 20px" size="default">修改</el-text>
                </div>
              </div>
              <div class="right">
                <el-table ref="tableRef" :data="selectCartList" border style="width: 740px">

                  <el-table-column align="left" prop="name" label="商品" width="400">
                    <template #default="{row}">
                      <div style="display: flex">
                        <img :src="row.image" style="height: 80px;width: 80px; border: 1px solid #EAEAEA"/>
                        <el-text :line-clamp="2" style="align-self:flex-start;margin-top: 4px; margin-left: 12px">
                          {{ row.name }}
                        </el-text>
                      </div>
                    </template>
                  </el-table-column>
                  <el-table-column align="center" prop="price" label="小计" width="140">
                    <template #default="{row}">
                      <el-text tag="b" style="color: #E4393C">
                        ￥{{ ((row.newPrice * 1.0 / 100) * (row.num)).toFixed(2) }}
                      </el-text>
                    </template>
                  </el-table-column>
                  <el-table-column align="center" prop="num" label="数量" width="120">
                    <template #default="{row}">
                      <el-text size="default">x{{ row.num }}</el-text>
                    </template>
                  </el-table-column>
                  <el-table-column align="center" label="备注" width="80">
                    <template #default="{row}">
                      <el-text size="default">有货</el-text>
                    </template>
                  </el-table-column>
                </el-table>
              </div>
            </div>
          </div>
        </div>
        <div style="margin-bottom: 20px"/>
      </div>
    </div>
    <div class="total-info">
      <div class="sub-total">
        <div class="line">
          <div style="width: 180px;margin-right: 20px;color: #666666">总商品金额：</div>
          <div style="width: 100px;color: #333333">￥{{ getTotalAccount }}</div>
        </div>
        <div class="line">
          <div style="width: 180px;margin-right: 20px;color: #666666">运费：</div>
          <div style="width: 100px;color: #333333">￥0.00</div>
        </div>
      </div>
      <div class="all-total">
        <div class="line">
          <div style="width: 180px;margin-right: 20px;color: #666666">应付总额：</div>
          <div style="width: 100px;color: #E4393C; font:700 18px Verdana;">￥{{ getTotalAccount }}</div>
        </div>
        <div class="line">
          <div style="margin-right:24px;color: #666666">
            寄送至：{{ getActiveAddress.province }}
            {{ getActiveAddress.city }}
            {{ getActiveAddress.town }}
            {{ getActiveAddress.street }}
          </div>
          <div style="color: #666666">
            收货人：{{ getActiveAddress.contact }}&nbsp;&nbsp;{{ getActiveAddress.mobile }}
          </div>
        </div>
      </div>
      <div class="submit-btn" @click="handleCreateOrder">
        <div class="btn">
          <el-text tag="b" size="large" style="color: #FFFFFF">提交订单</el-text>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped lang="less">
.container {
  --el-color-primary: #C81523;
}

.order-info {
  .order-detail {
    padding: 0 20px;
    box-sizing: border-box;
    border: 1px solid #EAEAEA;

    .area {
      border-bottom: 1px solid #EAEAEA;

      .head {
        display: flex;
        justify-content: space-between;
        align-items: center;
        height: 50px;

        .new {
          color: #005EA7;
        }
      }
    }

    .addr-list {
      margin: 10px 40px;
    }

    .pay-list {
      display: flex;
      margin: 10px 40px;
    }

    .item-list {
      margin: 10px;
    }

    .item-list {
      .deliver-type {
        display: flex;
        justify-content: space-between;
        margin-top: 20px;
        margin-bottom: 12px;
        margin-right: 16px;
        height: 30px;
        display: flex;
        font-size: 13px;

        .deliver-type-item {
          width: 46%;

          &.active .choose {
            position: relative;
            border: 2px solid #e4393c;

            .icon {
              position: absolute;
              right: 0;
              bottom: 0;
              height: 12px;
              width: 12px;
              background-image: url("../../../assets/image/selected-icon.png");
            }
          }
        }

        .choose {
          display: flex;
          justify-content: center;
          align-items: center;
          border: 1px solid #EAEAEA;
          padding: 4px 10px;
          height: 30px;
          width: 100%;
          box-sizing: border-box;
          color: #666666;
        }


      }
    }
  }
}

.total-info {
  .sub-total {
    display: flex;
    flex-direction: column;
    justify-content: space-around;
    margin: 20px 20px 10px 0;
    height: 58px;

    .line {
      display: flex;
      justify-content: flex-end;
      align-items: center;
      height: 24px;
      font-size: 12px;

      div {
        text-align: right;
      }
    }
  }

  .all-total {
    display: flex;
    flex-direction: column;
    justify-content: space-around;
    height: 80px;
    padding: 15px 20px;
    box-sizing: border-box;
    background-color: #F4F4F4;

    .line {
      display: flex;
      justify-content: flex-end;
      align-items: center;
      height: 25px;
      font-size: 12px;

      div {
        text-align: right;
      }
    }
  }
}

.submit-btn {
  display: flex;
  justify-content: flex-end;
  align-items: center;
  height: 50px;
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
</style>