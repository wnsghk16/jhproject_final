import axios from 'axios'
import router from '@/router' //절대경로

const state={
    context:'http://localhost:5000/',
    owplayers:[],
    owteams:[],
    team:'',
    player:[],
    article:[],
    count : 0,
    searchWord : ''
}

const actions={
    async search({commit},searchWord){
        state.searchWord = searchWord
        switch (searchWord) {
            case '선수':
                axios.get(state.context+`owplayer`)
                    .then(({data})=>{
                        commit('OWPLAYER_SEARCH',data)
                        router.push('/owplayer')
                    })
                    .catch(()=>{
                        alert('통신 실패')
                    })
                break;
            case '팀':
                axios.get(state.context+`owteam`)
                    .then(({data})=>{
                        commit('OWTEAM_SEARCH',data)
                        router.push('/owteams')
                    })
                    .catch(()=>{
                        alert('통신 실패')
                    })
                break;
          case '뉴스':
            axios.get(state.context+`article`)
              .then(({data})=>{
                commit('ARTICLE_SEARCH',data)
                router.push('/article')
              })
              .catch(()=>{
                alert('통신 실패')
              })
            break;
          case '홈':
            router.push('/')
            break;
        }
    },
}

const mutations={
    OWPLAYER_SEARCH(state,data){
        state.owplayers = [] //초기화
        state.count = data.count
        data.list.forEach(
            item => {state.owplayers.push({
                playerimg : item.playerimg,
                player : item.player,
                name : item.name,
                hometown : item.hometown,
                teamimg : item.teamimg,
                team : item.team,
                role : item.role})}
        )
    },
    OWTEAM_SEARCH(state,data){
        state.owteams = [] //초기화
        state.count = data.count
        data.list.forEach(
            item => {state.owteams.push({
                teamimg : item.teamimg,
                team : item.team})}
        )
    },
    ARTICLE_SEARCH(state,data){
          state.article = [] //초기화
          state.count = data.count
          data.list.forEach(
              item => {state.article.push({
                banner : item.banner,
                title : item.title,
                category : item.category,
                author : item.author,
                date : item.date})}
          )
    },
}

const getters={
    count : state => state.count,
    owplayers : state => state.owplayers,
    owteams : state => state.owteams,
    article : state => state.article
}

export default {
    name:'crawling',
    namespaced:true,
    state,
    actions,
    mutations,
    getters
}
