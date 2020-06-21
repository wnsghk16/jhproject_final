<template>
  <v-footer
    class="py-4"
    dark
    height="auto"
  >
    <v-container class="mx-auto">
      <v-row>
        <v-col cols="9">
          <base-btn
            v-for="(item, i) in items"
            :key="i"
            :href="item.href"
            class="ml-0 mr-3"
            color="primary"
            square
            target="_blank"
          >
            <a :href="item.href"><v-icon v-text="item.icon"/></a>
          </base-btn>
        </v-col>

        <v-spacer />

        <base-btn
          class="mr-0"
          square
          title="Go to top"
          @click="$vuetify.goTo(0)"
        >
          <v-icon>mdi-chevron-up</v-icon>
        </base-btn>
      </v-row>
    </v-container>
  </v-footer>
</template>

<script>
  export default {
    name: 'CoreFooter',

    data: () => ({
      items: [
        {
          href: 'https://twitter.com/overwatchleague',
          icon: 'mdi-twitter',
        },
        {
          href: 'https://www.instagram.com/overwatchleague/?hl=ko',
          icon: 'mdi-instagram',
        },
        {
          href: 'https://www.facebook.com/OWLkakaobot/',
          icon: 'mdi-facebook',
        },
        {
          href: 'https://www.youtube.com/channel/UCiAInBL9kUzz1XRxk66v-gw',
          icon: 'mdi-youtube',
        },
        {
          href: 'https://www.reddit.com/r/OverwatchLeague/',
          icon: 'mdi-reddit',
        },
        {
          href: 'https://www.reddit.com/r/Overwatch/comments/7qbkcz/overwatch_league_teams_official_discord_servers/',
          icon: 'mdi-discord',
        },
      ],
    }),
  }
</script>
