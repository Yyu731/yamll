<script setup>
import {storeToRefs} from "pinia";
import useUserStore from "@/stores/user.js";

const props = defineProps({
  addressItem: {
    id: "",
    province: "",
    city: "",
    town: "",
    mobile: "",
    street: "",
    contact: "",
    isDefault: 0,
    notes: ""
  }
})

const userStore = useUserStore()
const {addressList, activeId} = storeToRefs(userStore)
const handleAddressItemClick = () => {
  activeId.value = props.addressItem.id
}


</script>

<template>
  <div :class="['address-item', addressItem.id === activeId? 'active':'']" @click="handleAddressItemClick">
    <div class="choose">
      {{ addressItem.contact }} &nbsp; {{addressItem.province}}
      <div class="icon"/>
    </div>
    <div class="detail">
      <el-text class="text contact">{{ addressItem.contact }}</el-text>
      <el-text class="text province">{{addressItem.province}}</el-text>
      <el-text class="text city">{{addressItem.city}}</el-text>
      <el-text class="text town">{{addressItem.town}}</el-text>
      <el-text class="text street">{{addressItem.street}}</el-text>
      <el-text class="text mobile">{{addressItem.mobile}}</el-text>
      <el-text class="text default" v-if="addressItem.isDefault === 1">默认地址</el-text>
    </div>
  </div>
</template>

<style scoped lang="less">

.address-item {
  margin-bottom: 12px;
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
    width: 150px;
    box-sizing: border-box;
    color: #666666;
  }

  &.active .choose {
    position: relative;
    border: 2px solid #e4393c;

    .icon {
      position: absolute;
      right: 0;
      bottom: 0px;
      height: 12px;
      width: 12px;
      background-image: url("../../../assets/image/selected-icon.png");
    }
  }

  .detail {
    flex: 1;
    display: flex;
    padding-left: 6px;
    align-items: center;

    .text {
      font-size: 13px;
      margin-left: 8px;
    }
    .default {
      padding: 2px 3px;
      margin-left: 16px;
      font-size: 11px;
      background-color: #999999;
      color: #FFFFFF;
      border-radius: 2px;
    }
  }

  &:hover .choose {
    border: 2px solid #e4393c;
  }

  &:hover .detail {
    background-color: #fff3f3;
  }

}
</style>