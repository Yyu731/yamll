<script setup>
import Header from './cpns/Header.vue'
import Sort from './cpns/Sort.vue'
import Choose from './cpns/Choose.vue'
import Show from './cpns/Show.vue'
import Like from './cpns/Like.vue'
import{onMounted} from "vue";
import useCartStore from "@/stores/cart.js";

const cartStore = useCartStore()
onMounted(() => {
  cartStore.getCartListAction()
})

</script>

<template>
  <div class="home">
    <Header/>
    <Sort/>
    <Choose/>
    <Show/>
    <Like/>
    <div style="height: 200px"/>
  </div>
</template>

<style lang="less" scoped>

.home {

}


</style>