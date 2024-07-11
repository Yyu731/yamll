import {defineStore} from "pinia";
import {fetchCartList, addItem2Cart, deleteCartItem, updateCartItem} from "@/request/cart.js"
import useUserStore from "@/stores/user.js";

const userStore = useUserStore()
const useCartStore = defineStore('cart', {

    state: () => ({
        cartList: [],
        selectCartList: []
    }),

    actions: {
        async getCartListAction() {
            const cartListRes = await fetchCartList()
            if (cartListRes.code >= 200 && cartListRes.code <= 299) {
                this.cartList = cartListRes.data
            }
            userStore.userInfo.cartItemCount = this.cartList.length
        },
        async addItem2CartAction(item) {
            const addRes = await addItem2Cart(item);
            if (addRes.code >= 200 && addRes.code <= 299) {
                return addRes.msg
            } else  {
                throw addRes.msg
            }
        },
        async deleteCartItem(cartId) {
            await deleteCartItem(cartId)
            await this.getCartListAction()
        },
        async updateCartItemAction(cart)  {
            await updateCartItem(cart)
            await this.getCartListAction()
        }
    },
    persist: [
        {
            paths: ['selectCartList'],
            storage: sessionStorage,
        },
    ]
})

export default useCartStore