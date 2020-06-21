import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Login from "../components/member/Login";
import OWPlayer from "../components/OWPlayer";
import OWTeam from "../components/OWTeam";
import Articles from "../components/home/Articles";

Vue.use(VueRouter)

export default new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
    },
    {path:'/login', component:Login},
    {path:'/owplayer', component: OWPlayer},
    {path:'/owteams', component: OWTeam},
    {path:'/article', component: Articles}
  ],
})
