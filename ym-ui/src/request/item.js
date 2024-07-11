import yyRequest from './index.js'
export function fetchItemList(pageQuery) {
    return yyRequest.get({
        url: 'search/list',
        params: pageQuery
    })
}