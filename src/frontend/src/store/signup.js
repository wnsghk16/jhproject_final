import axios from "axios";

const state = {
  context:`http://localhost:5000/`,
  member:[],
  message:'',
  response:'',
  joinck:false,
  count:0
}
const actions = {
  async submit({commit},payload){
    axios.post(state.context+`user/signup`,payload,{
      authorization: "JWT fefege..",
      Accept: "application/json",
      "Content-Type": "application/json"
    })
      .then(({data})=>{
        commit('SIGN_UP',data)

      })
      .catch(()=>{
        alert('통신 실패')
      })
  },
  async idcheck({commit},id){
    axios.get(state.context+`user/${id}`)
      .then(({data})=>{
        commit('ID_CHECK',data)
      })
      .catch(()=>{
        alert('통신 실패')
      })
  }

}
const mutations ={
  SIGN_UP(state,data){
    if(data){
      state.joinck = false
      alert("아이디 중복")
    }else {
      state.joinck = true
      alert("회원가입성공")
    }
  },
  ID_CHECK(state,data){
    if(data){
      state.joinck = false
      alert("아이디 중복")
    }else {
      state.joinck = true
      alert("사용가능한 아이디")
    }
  }
}


const getters ={
  member : state => state.member,
  joinck: state=>state.joinck
}

export default{
  name:'singup',
  namespaced:true,
  state,
  actions,
  getters,
  mutations

}
