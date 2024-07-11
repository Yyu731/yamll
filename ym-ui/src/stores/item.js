import {defineStore} from "pinia";
import {fetchItemList} from "@/request/item.js"

const useItemStore = defineStore('item', {

    state: () => ({
        pageQuery: {
            pageNo: 1,
            pageSize: 20,
            key: "",
            category: "",
            isAsc:false ,
            sortBy:"",
        },
        pageResult: {},
        itemList: []
    }),

    actions: {
        async pageQueryAction() {
            console.log(this.pageQuery)
            const itemListRes = await fetchItemList(this.pageQuery)
            if (itemListRes.code >= 200 && itemListRes.code <= 299) {
                this.pageResult = itemListRes.data
                this.itemList = itemListRes.data.list
            }
        }
    },

})

export default useItemStore