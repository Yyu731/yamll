import yyRequest from './index.js'
export function fetchCartList() {
    return yyRequest.get({
        url: 'carts'
    })
}

export function addItem2Cart(item) {
    return yyRequest.post({
        url: 'carts',
        data: {
            itemId: item.id,
            ...item
        }
    })
}
export function deleteCartItem(cartId) {
    return yyRequest.delete({
        url: 'carts/' + cartId
    })
}
export function updateCartItem(cart) {
    return yyRequest.put({
        url: 'carts',
        data: cart
    })
}
