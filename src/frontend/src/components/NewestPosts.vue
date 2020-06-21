<template>
  <v-container class="pa-0">
    <base-subheading>Newest News Posts</base-subheading>

    <v-row
      v-for="(article, i) in articles.slice(11, 14)"
      :key="i"
      align="center"
      class="mb-2"
    >
      <v-col
        class="d-flex"
        cols="12"
      >
        <a @click="click">
          <v-img
            :src="article.banner"
            class="mr-3"
            height="60"
            max-width="60"
          />
        </a>

        <div>
          <div class="subheading" >
            <a :href="article.link">{{article.title}}</a>
          </div>

          <div class="caption">
            {{article.date}}
          </div>
        </div>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
  // Utilities
  import { mapState } from 'vuex'
  import router from '@/router'

  export default {
    name: 'NewestPosts',
    computed: {
      ...mapState(['articles']),
    },
    methods:{
      click(){
        router.push("/article")
      }
    }
  }
</script>
