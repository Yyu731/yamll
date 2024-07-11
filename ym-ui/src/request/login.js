import yyRequest from './index.js'
export function login(account) {
    return yyRequest.post({
        url: 'users/login',
        data: account
    })
}