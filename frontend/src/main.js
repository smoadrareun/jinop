import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";


import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
Vue.use(ElementUI);


import Axios from 'axios'
Vue.prototype.$axios = Axios;


import '@/assets/fontawesome-free-5.11.2-web/css/all.min.css'


import VueSession from 'vue-session'
Vue.use(VueSession)


Vue.config.productionTip = false;

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount("#app");
