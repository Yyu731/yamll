<script setup>
import Top from '@/components/Top.vue'
import { RouterLink, RouterView } from 'vue-router'
import {useRoute} from "vue-router";
const route = useRoute()
console.log(route)
</script>

<template>
  <Top v-if="!route?.meta?.hideTop"/>
  <RouterView />
</template>

<style lang="less" scoped>

</style>
