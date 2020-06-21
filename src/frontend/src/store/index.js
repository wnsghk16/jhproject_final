import Vue from 'vue'
import Vuex from 'vuex'
import crawling from "./crawling"
import signup from "./signup";
import signin from "./signin";

Vue.use(Vuex)

export default new Vuex.Store({
  modules:{
    crawling,
    signup,
    signin
  },
  state: {
    articles: require('@/data/articles.json'),
    drawer: false,
    items: [
      {
        text: 'Home',
        href: '/',
      },
      {
        text: 'About',
        href: '#about',
      },
      {
        text: 'Team',
        href: '/owteams',
      },
      {
        text: 'Player',
        href: '/owplayer',
      },
      {
        text: 'Article',
        href: '/article',
      }
    ],
  },
  getters: {
    categories: state => {
      const categories = []

      for (const article of state.articles) {
        if (
            !article.category ||
            categories.find(category => category.text === article.category)
        ) continue

        const text = article.category

        categories.push({
          text,
          href: '#!',
        })
      }

      return categories.sort().slice(0, 4)
    },
    links_categoris:(state,getters)=>{
      return state.items.concat(getters.categories)
    },
    links: state => state.items,
  },
  mutations: {
    setDrawer: (state, payload) => (state.drawer = payload),
    toggleDrawer: state => (state.drawer = !state.drawer),

  },
  actions: {

  },
})
