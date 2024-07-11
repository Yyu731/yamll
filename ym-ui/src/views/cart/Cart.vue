<script setup>
import Header from './cpns/Header.vue'
import CartItemList from "@/views/cart/cpns/CartItemList.vue";
</script>

<template>
  <div class="cart">
    <Header/>
    <CartItemList class="cart-item-list" />
  </div>
</template>

<style scoped lang="less">
.cart-item-list {
  margin-top: 20px;
}
</style>