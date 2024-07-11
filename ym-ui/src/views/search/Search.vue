<script setup>

import Header from './cpns/Header.vue'
import ItemList from './cpns/ItemList.vue'
import {onMounted} from "vue";
import useItemStore from "@/stores/item.js";
import {useRouter} from "vue-router";


const itemStore = useItemStore()
onMounted(() => {
  itemStore.pageQuery.pageNo = 1
  itemStore.pageQuery.pageSize = 20
  itemStore.pageQueryAction()
})
</script>

<template>
  <div class="search">
    <Header/>
    <ItemList/>
    <div style="height: 200px"/>
  </div>
</template>

<style scoped lang="less">

</style>