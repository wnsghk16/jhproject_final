<template>
    <modal name="detail" transition="pop-out" :focus-trap="true" :width="600" :height="600">
      <div class="box">
        <div class="container">
          <div class="left" >
            <a class="image">
              <img :src=player.playerimg>
            </a>
            <div class="profile">
              <p>{{player.player}}</p>
              <span>{{player.name}}</span>
            </div>
            <div class="actions">
              <a href="#" class="btn">Follow</a>
              <a href="#" class="btn">Message</a>
            </div>
          </div>
          <div class="right">
            <a class="right-box">
              <p>TEAM</p>
              <span><img :src=player.teamimg :width="100" height="100"></span>
              <span>{{player.team}}</span>
            </a>
            <a class="right-box">
              <p>Role</p>
              <br/>
              <span>{{player.role}}</span>
            </a>
            <a class="right-box">
              <p>HomeTown</p>
              <br/>
              <span>{{player.hometown}}</span>
            </a>
          </div>
        </div>
      </div>
    </modal>
</template>

<script>
    import {mapState} from 'vuex'

    export default {
        name: "PlayerDetail",
        computed : {
          ...mapState({
            player : (state) => state.crawling.player,
          })
        },
    }
</script>

<style scoped>
  /*
light orange: #EEBE6C
dark orange: #CA7C4E
beige: #F5E8DF
brown: #786450

font: Open Sans 600, 300
*/

  .box {
    width: 600px;
    height: 600px;
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    background: linear-gradient(to top right, #EEBE6C 0%, #CA7C4E 100%);
    box-shadow: 1px 2px 10px 0 rgba(0, 0, 0, .3);
    color: #786450;
    font-weight: 600;
    font-family: 'Open Sans', sans-serif;
    border-radius: 2px;
  }

  .container {
    border-radius: 4px;
    background: #fff;
    box-shadow: 7px 7px 16px 0 rgba(0, 0, 0, .4);
    width: 95%;
    height: 95%;
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    display: flex;
  }

  .left {
    max-width: 63%;
    flex: 0 0 63%;
    display: flex;
    flex-direction: column;
    align-items: center;
    padding: 40px 20px;
    box-sizing: border-box;
  }

  .right {
    flex: 1;
  }

  .image {
    width: 274px;
    height: 274px;
    position: relative;
    border-radius: 50%;
    margin-bottom: 22px;
  }

  .image:hover:before {
    content: '';
    transform: translate(-50%, -50%) rotate(360deg);
  }

  .image:hover:after {
    content: '';
    transform: translate(-50%, -50%) rotate(-360deg);
  }

  .image:before,
  .image:after {
    content: '';
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%) rotate(0);
    border-radius: 50%;
    transition: all 1.5s ease-in-out;
  }

  .image:before {
    width: 278px;
    height: 278px;
    border: 1px solid #786450;
    border-left-color: transparent;
  }

  .image:after {
    width: 284px;
    height: 284px;
    border: 1px solid #786450;
    border-right-color: transparent;
  }

  .image img {
    width: 274px;
    height: 274px;
    border-radius: 50%;
    overflow: hidden;
  }

  .profile {
    text-align: center;
    display: flex;
    flex-direction: column;
    align-items: center;
    margin-bottom: 20px;
  }

  .profile p {
    font-size: 34px;
    font-weight: 600;
    margin: 0;
    line-height: 1.2;
  }

  .profile span {
    font-weight: 300;
    font-size: 21px;
    display: inline-block;
  }

  .actions {
    text-align: center;
  }

  .btn {
    text-align: center;
    border: 1px solid;
    width: 125px;
    border-radius: 20px;
    line-height: 28px;
    font-size: 14px;
    font-weight: 700;
    text-decoration: none;
    color: #786450;
    display: inline-block;
    transition: all .5s;
  }

  .btn:hover {
    background: #786450;
    color: #fff;
  }

  .btn + .btn {
    margin-top: 10px;
  }

  .right {
    display: flex;
    flex-flow: column nowrap;
    align-items: stretch;
  }

  .right-box {
    background: #f5e8df;
    flex: 1;
    text-decoration: none;
    color: #786450;
    display: flex;
    justify-content: center;
    align-items: center;
    flex-direction: column;
    cursor: pointer;
    transition: background .5s;
  }

  .right-box:hover {
    background: #E1CFC2;
  }

  .right-box p {
    font-size: 25px;
    font-weight: 600;
    margin: 0;
    line-height: 1.2;
  }

  .right-box span {
    font-size: 20px;
    font-weight: 300;
  }

  .right-box + .right-box {
    border-top: 1px solid #fff;
  }
</style>
