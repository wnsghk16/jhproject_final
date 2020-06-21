import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import vuetify from './plugins/vuetify';
import axios from 'axios'
import vuex from 'vuex'
import VModal from 'vue-js-modal'
import VueYouTubeEmbed from 'vue-youtube-embed'

Vue.config.productionTip = false
Vue.use(vuex)
Vue.use(VModal, { dynamic: true })
Vue.use(VueYouTubeEmbed)

new Vue({
  router,
  store,
  vuetify,
  vuex,
  axios,
  render: h => h(App)
}).$mount('#app')
