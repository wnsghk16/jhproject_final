import axios from "axios";

const state = {
  context:`http://localhost:5000/`,
  member:[],
  result:"",
  check:false
}

const actions = {
  async login({commit},payload){
    axios.post(state.context+`user/signin`,payload,{
      authorization: "JWT fefege..",
      Accept: "application/json",
      "Content-Type": "application/json"
    })
      .then(({data})=>{
        state.member = data.member
        commit('LOGIN',data)
        alert(data.result)
      })
      .catch((e)=>{
        alert('통신 실패'+e)
      })
  }

}
const  mutations ={
  async LOGIN(state,data){
    state.member=[]
    state.member=data.member
    state.result = data.result
    state.check = data.check
  }
}


const getters ={
  result: state => state.result,
  check : state => state.check,
  member : state => state.member,
}

export default{
  name:'singup',
  namespaced:true,
  state,
  actions,
  getters,
  mutations

}
