<template>
  <base-card dark >
    <td></td>
    <v-row align="center" justify="center">
      <v-img
        src="https://images.blz-contentstack.com/v3/assets/blt321317473c90505c/blt62ad9210eea8978d/5cd5d7672bbbdbbb548aa04f/image_-_arena.png?auto=webp"
        class="grey lighten-2 px-20 "
        height="500"
        max-width="1200"
      >
        <v-row
          class="fill-height pa-3"
          align="center"
        >
          <v-col
            cols="12"
            md="7"
            offset-md="5"
          >
            <h1 class="font display-3 font-weight-light">
              Overwatch League
            </h1>

            <div class="font subheading text-uppercase pl-2 mb-4">
              The Overwatch League is an international esports league.
            </div>

            <v-btn
              color="primary"
              depressed
              href="https://www.youtube.com/channel/UCiAInBL9kUzz1XRxk66v-gw"
            >
              Subscribe
            </v-btn>
          </v-col>
        </v-row>
      </v-img>
    </v-row>
    <td></td>
  </base-card>
</template>

<script>
  export default {
    name: 'HomeBanner',
  }
</script>
<style>
  .font{
    color: #ffffff;
  }
</style>
