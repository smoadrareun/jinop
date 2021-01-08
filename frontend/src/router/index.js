import Vue from "vue";
import VueRouter from "vue-router";
import Login from "../views/login.vue";
import GoodOpe from "../views/goodOpe.vue"
import MerchantOpe from "../views/merchantOpe.vue"
import TradingRecordOpe from "../views/tradingRecordOpe.vue"
import ClientSearch from "../views/clientSearch.vue"
import MerchantProfile from "../views/merchantProfile.vue"

import Signup from "../views/signup.vue"
import Buy from "../views/buy.vue"
import ShoppingCart from '../views/shoppingCart.vue'
import ClientProfile from '../views/clientProfile.vue'


Vue.use(VueRouter);

const routes = [{
    path: "/",
    name: "Login",
    component: Login
  },
  {
    path: "/goodOpe",
    name: "GoodOpe",
    component: GoodOpe
  },
  {
    path: "/merchantOpe",
    name: "MerchantOpe",
    component: MerchantOpe
  },
  {
    path: "/tradingRecordOpe",
    name: "TradingRecordOpe",
    component: TradingRecordOpe
  },
  {
    path: "/clientSearch",
    name: "ClientSearch",
    component: ClientSearch
  },
  {
    path: "/merchantProfile",
    name: "MerchantProfile",
    component: MerchantProfile
  },
  {
    path: "/buy",
    name: "Buy",
    component: Buy
  },
  {
    path: "/shoppingCart",
    name: "ShoppingCart",
    component: ShoppingCart
  },
  {
    path: "/clientProfile",
    name: "ClientProfile",
    component: ClientProfile
  },
  {
    path: "/signup",
    name: "Signup",
    component: Signup
  }
];

const router = new VueRouter({
  routes
});

export default router;