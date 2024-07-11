import yyRequest from './index.js'
export function postCreateOrder(orderForm) {
    return yyRequest.post({
        url: 'orders',
        data: orderForm
    })
}
export function getOrderInfo(orderId) {
    return yyRequest.get({
        url: 'orders/' + orderId
    })
}
export function postPayOrder(payApply) {
    return yyRequest.post({
        url: 'pay-orders',
        data: payApply
    })
}
export function postPayOrderByBalance(payOrderId, payOrderForm) {
    return yyRequest.post({
        url: 'pay-orders/' + payOrderId,
        data: payOrderForm
    })
}