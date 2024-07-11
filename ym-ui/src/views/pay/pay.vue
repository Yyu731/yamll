<script setup>
import Header from './cpns/Header.vue'
import PayInfo from './cpns/PayInfo.vue'

import {storeToRefs} from "pinia";
import useOrderStore from "@/stores/order.js";

const orderStore = useOrderStore()
const {orderId} = storeToRefs(orderStore)

</script>

<template>
  <div class="pay">
    <Header />
    <PayInfo/>
  </div>
</template>

<style scoped lang="less">

</style>