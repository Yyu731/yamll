import {defineStore} from "pinia";
import {login} from "@/request/login.js"
import router from "@/router/index.js";
import {localCache} from "@/utils/cache.js"
import {getUserAddressList} from "@/request/user.js";

const useUserStore = defineStore('user', {

    state: () => ({
        userInfo : {},
        addressList: [],
        activeId: "",
    }),

    actions: {
        async loginAction(account){
            const loginRes = await login(account)
            if (loginRes.code >= 200 && loginRes.code <= 299) {
                router.back()
            }
            localCache.setCache("token",loginRes.data.token)
            this.userInfo = loginRes.data
        },
        async getUserAddressListAction() {
            this.addressList = await getUserAddressList()
            this.activeId = this.addressList[0].id
            this.activeId = this.addressList.filter(item => item.isDefault === 1)[0].id
        }
    },

    persist:true
})

export default useUserStore