import yyRequest from './index.js'
export function getUserAddressList() {
    return yyRequest.get({
        url: 'addresses'
    })
}