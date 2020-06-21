<template>
  <v-container class="pa-0">
    <base-subheading>On Instagram</base-subheading>

    <v-row>
      <v-col
        v-for="(post, i) in posts"
        :key="i"
        cols="4"
      >
        <base-card
          :href="post.href"
          color="grey lighten-2"
          height="88"
          tag="a"
        >
          <a :href="post.href">
            <v-img
              v-if="post.src"
              :src="require(`@/assets/instagram/${post.src}`)"
              height="100%"
            />
          </a>
        </base-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
  export default {
    name: 'Instagram',

    data: () => ({
      posts: [
        { src: 'fleta1.jpg',href:'https://www.instagram.com/p/CBn8wy8gl45/' },
        { src: 'fleta2.jpg',href:'https://www.instagram.com/p/CBn8vQCAFmO/' },
        { src: 'fleta3.jpg' ,href:'https://www.instagram.com/p/CBn8tO9AjV8/'},
        { src: 'jjonak1.jpg' ,href:'https://www.instagram.com/p/CBWOWR1AY22/'},
        { src: 'jjonak2.jpg' ,href:'https://www.instagram.com/p/CBWOVABgZcY/'},
        { src: 'jjonak3.jpg' ,href:'https://www.instagram.com/p/CBWOTC8g3aU/'},
      ],
    }),
  }
</script>
