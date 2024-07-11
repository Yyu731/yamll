<script setup>
import {storeToRefs} from "pinia";
import useUserStore from "@/stores/user.js";
import useOrderStore from "@/stores/order.js";

const props = defineProps({
  payType: {
    type: Object,
    default: () => ({
      id: 0,
      type: ""
    })
  }
})

const userStore = useUserStore()
const orderStore = useOrderStore()
const {activePaymentId} = storeToRefs(orderStore)

const handlePayTypeItemClick = () => {
  activePaymentId.value = props.payType.id
}

</script>

<template>
  <div :class="['pay-item',payType.id === activePaymentId? 'active':'']" @click="handlePayTypeItemClick">
    <div class="choose">
      {{ payType.type }}
      <div class="icon"/>
    </div>
  </div>
</template>

<style scoped lang="less">
.pay-item {
  margin-bottom: 12px;
  margin-right: 16px;
  height: 30px;
  display: flex;
  font-size: 13px;

  .choose {
    display: flex;
    justify-content: center;
    align-items: center;
    border: 1px solid #EAEAEA;
    padding: 4px 10px;
    height: 30px;
    width: 90px;
    box-sizing: border-box;
    color: #666666;
  }

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
</style>