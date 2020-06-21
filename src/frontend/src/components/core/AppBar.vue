<template>
  <div>
    <login/>
    <v-app-bar
      app
      flat
    >
      <v-app-bar-nav-icon
        class="hidden-md-and-up"
      />

      <v-container class="mx-auto py-0">
        <v-row align="center">
          <v-img
            :src="require('@/assets/logo.png')"
            class="mr-5"
            contain
            height="48"
            width="48"
            max-width="48"
            href="/"
          />

          <v-btn
            v-for="(link, i) in links"
            :key="i"
            v-bind="link"
            class="hidden-sm-and-down"
            text
            @click="onClick($event, link)"
          >
            {{ link.text }}
          </v-btn>

          <v-spacer /><v-spacer /><v-spacer /><v-spacer /><v-spacer /><v-spacer /><v-spacer />
          <v-text-field
            append-icon="mdi-magnify"
            flat
            hide-details
            solo-inverted
            style="max-width: 300px;"
            v-model="searchWord"
            v-on:keyup.enter="search"
          />
          <v-spacer />
          <v-img class="icon" src="https://www.clipartmax.com/png/full/34-340027_user-login-man-human-body-mobile-person-comments-person-icon-png.png" @click="$modal.show('login')">
          </v-img>
        </v-row>
      </v-container>
    </v-app-bar>
  </div>
</template>

<script>
  // Utilities
  import {
    mapGetters,
  } from 'vuex'
  import Login from "../member/Login";

  export default {
    name: 'CoreAppBar',
    components: {Login},
    data:()=>{
      return{
        canBeShown: false,
        searchWord:''
      }
    },
    created() {
      setInterval(() => {
        this.canBeShown = !this.canBeShown
      }, 5000)
    },
    computed: {
      ...mapGetters(['links']),
    },
    methods: {
      search(){
        this.$store.dispatch('crawling/search',this.searchWord)
      },
      onClick (e, item) {
        e.stopPropagation()
        if (item.to || !item.href) return

        this.$vuetify.goTo(item.href.endsWith('!') ? 0 : item.href)
      },
    },
  }
</script>
<style>
  .icon{
    width: 0.2px;
    height: 45.6px;
  }
</style>
