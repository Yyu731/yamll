import {defineStore} from "pinia";
import {postCreateOrder, getOrderInfo, postPayOrder, postPayOrderByBalance} from '@/request/order.js'

const useOrderStore = defineStore('order', {

    state: () => ({
        payTypeList : [
            {id: 1, type: "网页支付"},
            {id: 2, type: "小程序支付"},
            {id: 3, type: "APP支付"},
            {id: 4, type: "扫码支付"},
            {id: 5, type: "余额支付"}
        ],
        activePaymentId: 5,
        orderId : "",
        orderInfo : {},
        payOrderId: ""
    }),

    actions: {
        async createOrderAction(orderForm) {
            const res = await postCreateOrder(orderForm)
            this.orderId = res
            const orderRes = await getOrderInfo(this.orderId)
            this.orderInfo = orderRes
            const payOrderIdRes = await postPayOrder({
                bizOrderNo: this.orderId,
                amount: orderRes.totalFee,
                payChannelCode: "balence",
                payType: this.activePaymentId,
                orderInfo: JSON.stringify(orderRes)
            })
            this.payOrderId = payOrderIdRes
        },
        async payOrderAction() {
            await postPayOrderByBalance(this.payOrderId,
                {
                    id: this.payOrderId,
                    pw: "123"
                })
        }
    },

    persist: [
        {
            paths: ['orderId','orderInfo'],
            storage: sessionStorage
        }
    ]

})

export default useOrderStore