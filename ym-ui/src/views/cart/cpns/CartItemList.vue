<script setup>
import {computed, onMounted, ref} from "vue"
import {storeToRefs} from "pinia"
import useCartStore from "@/stores/cart.js";
import * as _ from "underscore"
import {useRouter} from "vue-router";

const cartStore = useCartStore();
const {cartList,selectCartList} = storeToRefs(cartStore)

const router = useRouter()
onMounted(() => {
  cartStore.getCartListAction()
})

const lazyUpdateCart = _.debounce((row) => {
  cartStore.updateCartItemAction({
    id: row.id,
    num: row.num
  })
}, 500)

const handleNumChange = (row) => {
  lazyUpdateCart(row)
}

const deleteCartItem = (cart) => {
  cartStore.deleteCartItem(cart.id).then(res => {
    ElMessage({
      type: 'success',
      message: "删除成功"
    })
  })
}

const tableRef = ref()
const availableCart = computed(() => cartList.value.filter(item => item.stock && item.status === 1))
// const getCartCount = computed(()=>tableRef.value.getSelectionRows.reduce((item,sum) => item.num + sum),0);
const selectCart = computed(() => tableRef.value?.getSelectionRows())
const getCartCount = computed(() => selectCart.value?.reduce((sum, item) => sum + item.num, 0))
const getCartAmount = computed(() => selectCart.value?.reduce((sum, item) => sum + item.num * item.newPrice, 0))
const checkAllCart = ref(false)
const isCartIndeterminate = ref(false)
const handleSelectChange = (payload) => {
  checkAllCart.value = payload.length === availableCart.value.length
  isCartIndeterminate.value = payload.length > 0 && payload.length < availableCart.value.length;
}
const handleSelectAll = () => {
  tableRef.value.toggleAllSelection()
}

const handleCheckClick = () => {
  cartStore.selectCartList = selectCart?.value
  router.push("/order")
}

</script>

<template>
  <div class="container">
    <div class="title" style="margin-bottom: 10px">
      <el-space size="small">
        <el-text tag="b" size="large" style="color: var(--el-color-primary)">全部商品</el-text>
        <el-text tag="b" size="large" style="color: var(--el-color-primary)">{{ cartList.length }}</el-text>
      </el-space>
    </div>
    <div class="cart-item-list">
      <el-table ref="tableRef" :data="cartList" border style="width: 100%" @selection-change="handleSelectChange">
        <el-table-column align="center" type="selection" :selectable="(row) => row.stock && row.status === 1"
                         label="全选" width="60"/>
        <el-table-column align="left" prop="name" label="商品">
          <template #default="{row}">
            <div style="display: flex">
              <img :src="row.image" style="height: 80px;width: 80px; border: 1px solid #EAEAEA"/>
              <el-text :line-clamp="2" style="align-self:flex-start;margin-top: 4px; margin-left: 12px">
                {{ row.name }}
              </el-text>
            </div>
          </template>
        </el-table-column>
        <el-table-column align="center" prop="price" label="单价" width="170" class-name="price">
          <template #default="{row}">
            ￥{{ (row.newPrice * 1.0 / 100).toFixed(2) }}
            <template v-if="row.newPrice < row.price">
              <el-tag
                  type="danger"
                  effect="plain"
                  size="small"
              >比加入时降{{ (row.price - row.newPrice) / 100 }}元
              </el-tag>
            </template>
          </template>
        </el-table-column>
        <el-table-column align="center" prop="num" label="数量" width="120">
          <template #default="{row}">
            <template v-if="row.status === 2">
              <el-text type="danger" size="small">
                {{ "商品已下架" }}
              </el-text>
            </template>
            <template v-else-if="row.stock > 0">
              <div style="display: flex; align-items: center; flex-direction: column">
                <el-input-number style="width: 90px" v-model="row.num" :min="0" :max="row.stock" size="small"
                                 @change="handleNumChange(row)"/>
                <el-text type="info" size="small">
                  {{ row.stock <= 10 ? `仅剩${row.stock}件` : '有货' }}
                </el-text>
              </div>
            </template>
            <template v-else>
              <el-text type="danger" size="small">
                {{ "缺货" }}
              </el-text>
            </template>
          </template>
        </el-table-column>
        <el-table-column align="center" prop="price" label="小计" width="140" style="color: #b1191a">
          <template #default="{row}">
            <template v-if="row.stock && row.status === 1">
              <el-text tag="b">
                ￥{{ ((row.newPrice * 1.0 / 100) * (row.num)).toFixed(2) }}
              </el-text>
            </template>
            <template v-else>
              <el-text tag="b">
                /
              </el-text>
            </template>
          </template>
        </el-table-column>
        <el-table-column align="center" label="操作" width="160">
          <template #default="{row}">
            <el-button text @click="deleteCartItem(row)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
    <div class="pay">
      <div class="left">
        <el-checkbox
            v-model="checkAllCart"
            :indeterminate="isCartIndeterminate"
            @change="handleSelectAll"
            size="small"
        >
          全选
        </el-checkbox>
        <el-button text size="small">删除选中的商品</el-button>
        <el-button text size="small">移入关注</el-button>
        <el-button text size="small">
          <el-text tag="b" size="small">清理购物车</el-text>
        </el-button>
      </div>
      <div class="right">
        <el-space size="large">
          <div class="total">
            <el-text>已选择<el-text tag="b" type="danger">{{ getCartCount }}</el-text>件商品</el-text>
          </div>
          <div class="price">
            <el-text>总价：<el-text tag="b" type="danger" size="large">￥{{ (getCartAmount / 100).toFixed(2) }}</el-text></el-text>
          </div>
          <div class="go">
            <div class="btn" @click="handleCheckClick">
              <el-text tag="b" size="large">去结算</el-text>
            </div>
          </div>
        </el-space>
      </div>
    </div>
  </div>
</template>

<style scoped lang="less">
.cart-item-list {
  --el-color-primary: #C81523;
}

.pay {
  display: flex;
  justify-content: space-between;
  margin-top: 10px;
  height: 50px;
  border: 1px solid #EAEAEA;

  .left {
    margin-left: 8px;
    height: 100%;
    display: flex;
    align-items: center;

    .el-button {
      margin: 0;
      padding: 0px 6px;
    }

    .el-checkbox {
      margin: 0 6px
    }
  }

  .right {
    display: flex;

    .total {

    }

    .go {
      display: flex;
      justify-content: center;
      align-items: center;
      width: 110px;
      height: 50px;
      background-color: #e54346;

      .el-text {
        font-size: 19px;
        color: white;
      }

      &:hover {
        cursor: pointer;
      }
    }
  }
}
</style>