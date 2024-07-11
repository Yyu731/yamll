import { createRouter, createWebHashHistory } from 'vue-router'

const router = createRouter({
  history: createWebHashHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      redirect: '/home',
    },
    {
      path: '/home',
      name: 'home',
      component: () => import('../views/home/Home.vue')
    },
    {
      path: '/search',
      name: 'search',
      component: () => import('../views/search/Search.vue')
    },
    {
      path: '/cart',
      name: 'cart',
      component: () => import('../views/cart/Cart.vue'),
    },
    {
      path: '/order',
      name: 'order',
      component: () => import('../views/order/Order.vue'),
    },
    {
      path: '/pay',
      name: 'pay',
      component: () => import('../views/pay/pay.vue'),
    },
    {
      path: '/pay-success',
      name: 'pay-success',
      component: () => import('../views/pay-success/pay-success.vue'),
    },
    {
      path: '/login',
      name: 'login',
      component: () => import('../views/login/Login.vue'),
      meta: {
        hideTop :true
      }
    }
  ]
})

export default router
