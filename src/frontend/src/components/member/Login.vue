<template>
  <modal name="login" transition="pop-out" :focus-trap="true" :width="490" :height="700">
    <div v-if="!check">
      <div class="card">
        <div class="login-box">
          <div class="login-snip">
            <input id="tab-1" type="radio" name="tab" class="sign-in" checked>
            <label for="tab-1" class="tab">Login</label>
            <input id="tab-2" type="radio" name="tab" class="sign-up" >
            <label for="tab-2" class="tab">Sign Up</label>
            <div class="login-space">
              <div class="login">
                <div class="group">
                  <br/><br/><br/>
                  <label for="login_id" class="label">UserID</label>
                  <input id="login_id" type="text" class="input" placeholder="Enter your UserID">
                </div>
                <div class="group" >
                  <label for="login_passwd" class="label">Password</label>
                  <input id="login_passwd" type="password" class="input" data-type="password" placeholder="Enter your password">
                </div>
                <div class="group">
                  <input id="check" type="checkbox" class="check" checked>
                  <label for="check">
                    <span class="icon"></span>
                    Keep me Signed in
                  </label>
                </div>
                <div class="group">
                  <input @click="login" type="submit" class="button" value="Sign In">
                </div>
                <div class="hr"></div>
                <div class="foot">
                  <label for="tab-2">
                    I'm New
                  </label>
                </div>
              </div>
              <div class="sign-up-form" >
                <div class="group">
                  <br/>
                  <label for="join_id" class="label">UserID</label>
                  <input id="join_id" v-model="join_id" type="text" class="input" placeholder="Create your UserID">
                  <br/>
                  <v-btn small color="error"  @click="idcheck">check</v-btn>
                </div>
                <div class="group">
                  <label for="join_passwd" class="label">Password</label>
                  <input id="join_passwd" v-model="join_passwd" type="password" class="input" data-type="password" placeholder="Create your password">
                </div>
                <div class="group">
                  <label for="name" class="label">Name</label>
                  <input id="name" v-model="name" type="text" class="input" placeholder="Enter your Name">
                </div>
                <div class="group">
                  <label for="email" class="label">Email Address</label>
                  <input id="email" v-model="email" type="text" class="input" placeholder="Enter your email address">
                </div>
                <div class="group">
                  <label v-if="this.$store.state.signup.joinck" for="tab-1" @click="submit" type="submit" class="button">
                    Sign Up
                  </label>
                  <label v-if="!this.$store.state.signup.joinck" @click="submit" type="submit" class="button">
                    Sign Up
                  </label>
                </div>
                <div class="hr"></div>
                <div class="foot">
                  <label for="tab-1">Already Member?</label>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div v-if="check">
      <div class="card">
        <div class="login-box">
          <div class="login-snip">
            <input id="tab-3" type="radio" name="tab" class="sign-in" checked>
            <label for="tab-3" class="tab">MyPage</label>
            <div class="login-space">
              <br/><br/>
              <div class="group">
                <h3 class="input">ID: {{member.id}}</h3>
              </div>
              <div class="group">
                <h3 class="input">PassWord: {{member.passwd}}</h3>
              </div>
              <div class="group">
                <h3 class="input">Name: {{member.name}}</h3>
              </div>
              <div class="group">
                <h3 class="input">Email: {{member.email}}</h3>
              </div>
              <div class="hr"></div>
              <div class="group2">
                <v-btn @click="logout" type="submit" class="button2">
                  Log-Out
                </v-btn>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </modal>
</template>

<script>
  import {mapState} from "vuex";
  export default {
    name: 'Login',
    data() {
      return {
        join_id:'',
      }
    },
    computed: {
      ...mapState({
        result: state => state.signin.result,
        check: state=>state.signin.check,
        joinck: state=>state.signup.joinck,
        member : state=>state.signin.member
      })
    },
    methods: {
      submit(){
        this.$store.dispatch('signup/submit',
          { id:document.getElementById('join_id').value,
            passwd:document.getElementById('join_passwd').value,
            name:document.getElementById('name').value,
            email:document.getElementById('email').value})
      },
      idcheck(){
        console.log(this.join_id)
        this.$store.dispatch('signup/idcheck',this.join_id)
      },
      login(){
        this.$store.dispatch('signin/login', {
          id : document.getElementById('login_id').value,
          passwd : document.getElementById('login_passwd').value,
        })
      },
      logout(){
        alert("로그아웃")
        this.$store.state.signin.check = false
      },
    }
  }
</script>
<style>
  body {
    margin: 0;
    color: #6a6f8c;
    font: 600 13px/15px 'Open Sans', sans-serif
  }

  .login-box {
    width: 500px;
    margin: auto;
    max-width: 525px;
    min-height: 700px;
    position: relative;
    background: url(https://w.namu.la/s/3e688f9e93b88b02a8fcf9fcdc14b466bdc0aca7b427b9017c380cdcfc1d016fa3af2e85a537c9023566c7d7e3b243cf539e8575f9cc4c38a4df2e7110748b39aa6a3d5d2345937c60de456f09cbce9f198d8292840e2dc83659f28c73b6a0e4) no-repeat center;
    box-shadow: 0 12px 15px 0 rgba(0, 0, 0, .24), 0 17px 50px 0 rgba(0, 0, 0, .19)
  }

  .login-snip {
    width: 100%;
    height: 100%;
    position: absolute;
    padding: 50px 70px 50px 70px;
    background: rgba(101, 99, 99, 0.7)
  }

  .login-snip .login,
  .login-snip .sign-up-form {
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
    position: absolute;
    transform: rotateY(180deg);
    backface-visibility: hidden;
    transition: all .4s linear
  }

  .login-snip .sign-in,
  .login-snip .sign-up,
  .login-space .group .check {
    display: none
  }

  .login-snip .tab,
  .login-space .group .label,
  .login-space .group .button {
    text-transform: uppercase
  }

  .login-snip .tab {
    font-size: 22px;
    margin-right: 15px;
    padding-bottom: 5px;
    margin: 0 15px 10px 0;
    display: inline-block;
    border-bottom: 2px solid transparent
  }

  .login-snip .sign-in:checked+.tab,
  .login-snip .sign-up:checked+.tab {
    color: #fff;
    border-color: #1161ee
  }

  .login-space {
    min-height: 345px;
    position: relative;
    perspective: 1000px;
    transform-style: preserve-3d
  }

  .login-space .group {
    margin-bottom: 15px
  }

  .login-space .group .label,
  .login-space .group .input,
  .login-space .group .button {
    width: 100%;
    color: #fff;
    display: block
  }

  .login-space .group .input,
  .login-space .group .button {
    border: none;
    padding: 15px 20px;
    border-radius: 25px;
    background: rgba(255, 255, 255, .1)
  }

  .login-space .group input[data-type="password"] {
    text-security: circle;
    -webkit-text-security: circle
  }

  .login-space .group .label {
    color: #ffffff;
    font-size: 12px
  }

  .login-space .group .button {
    background: #1161ee
  }

  .login-space .group label .icon {
    width: 15px;
    height: 15px;
    border-radius: 2px;
    position: relative;
    display: inline-block;
    background: rgba(255, 255, 255, .1)
  }

  .login-space .group label .icon:before,
  .login-space .group label .icon:after {
    content: '';
    width: 10px;
    height: 2px;
    background: #fff;
    position: absolute;
    transition: all .2s ease-in-out 0s
  }

  .login-space .group label .icon:before {
    left: 3px;
    width: 5px;
    bottom: 6px;
    transform: scale(0) rotate(0)
  }

  .login-space .group label .icon:after {
    top: 6px;
    right: 0;
    transform: scale(0) rotate(0)
  }

  .login-space .group .check:checked+label {
    color: #fff
  }

  .login-space .group .check:checked+label .icon {
    background: #1161ee
  }

  .login-space .group .check:checked+label .icon:before {
    transform: scale(1) rotate(45deg)
  }

  .login-space .group .check:checked+label .icon:after {
    transform: scale(1) rotate(-45deg)
  }

  .login-snip .sign-in:checked+.tab+.sign-up+.tab+.login-space .login {
    transform: rotate(0)
  }

  .login-snip .sign-up:checked+.tab+.login-space .sign-up-form {
    transform: rotate(0)
  }

  *,
  :after,
  :before {
    box-sizing: border-box
  }

  .clearfix:after,
  .clearfix:before {
    content: '';
    display: table
  }

  .clearfix:after {
    clear: both;
    display: block
  }

  a {
    color: inherit;
    text-decoration: none
  }

  .hr {
    height: 2px;
    margin: 30px 0 30px 0;
    background: rgba(255, 255, 255, .2)
  }

  .foot {
    text-align: center;
    color: #f3dd17;
    font-size: 20px
  }

  .card {
    width: 500px;
    left: 100px
  }

  ::placeholder {
    color: #b3b3b3
  }
  .button{
    text-align: center;
  }
  .login-space .group2 .button2 {
    text-transform: uppercase;
    color: #ef1212;
    width: 100%;
    display: block
  }
</style>
