<script setup>
import Header from './cpns/Header.vue'
import OrderInfo from './cpns/OrderInfo.vue'
import {ref, onMounted} from 'vue'
import useUserStore from "@/stores/user.js";


const userStore = useUserStore()
onMounted(() => {
  userStore.getUserAddressListAction()
})


</script>

<template>
  <div class="order">
    <Header/>
    <OrderInfo />
    <div style="height: 200px"/>
  </div>
</template>

<style scoped lang="less">

</style>