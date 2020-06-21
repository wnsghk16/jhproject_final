<template>
    <div>
        <v-card>
          <player-detail/>
            <v-card-title>
                <v-spacer></v-spacer>
                <v-text-field
                        v-model="search"
                        append-icon="mdi-magnify"
                        label="Search"
                        single-line
                        hide-details
                ></v-text-field>
            </v-card-title>
            <v-data-table
                    :headers="headers"
                    :items="tableItems"
                    :search="search"
                    @click:row="click"
            >
                <template v-slot:item.playerimg="{item}">
                    <v-img class="image" :src=item.playerimg />
                </template>

                <template v-slot:item.teamimg="{item}">
                    <img class="image" :src=item.teamimg />
                </template>

            </v-data-table>

            <v-alert slot="no-results" :value="true" color="error" icon="warning">
                Your search for "{{ search }}" found no results.
            </v-alert>
        </v-card>
    </div>
</template>

<script>
    import {mapState} from "vuex";
    import PlayerDetail from "./PlayerDetail";

    export default {
      components: {PlayerDetail},
      props:['playerdata'],
      data () {
            return {
                canBeShown: false,
                search: '',
                headers: [
                    {
                        text: 'PlayerImg',
                        align: 'left',
                        sortable: false,
                        value: 'playerimg'
                    },
                    { text: 'Player', value: 'player' },
                    { text: 'Name', value: 'name' },
                    { text: 'Hometown', value: 'hometown' },
                    { text: 'TeamImg', sortable: false, value: 'teamimg' },
                    { text: 'Team', value: 'team' },
                    { text: 'Role', value: 'role' }
                ],

            }
        },
        created() {
            this.$store.dispatch('crawling/search','선수')
            this.search = this.$store.state.crawling.team
            setInterval(() => {
              this.canBeShown = !this.canBeShown
            }, 5000)
        },
        computed : {
            ...mapState({
                tableItems : (state) => state.crawling.owplayers,
            })
        },
      methods:{
        click(member){
          this.$store.state.crawling.player = member
          this.$modal.show('detail')
        }
      }
    }
</script>

<style scoped>
    .google{
        width: 140px;
        height: 45px;
        margin-right: 20px;
    }
    .search{
        width: 550px;
        height: 40px;
        font-size: 15pt;
        box-shadow: 3px 3px 5px #C3C3C3;
        border: 1px solid #EAEAEA;
    }
    .top{
        text-align: center;
        margin: 10px;
    }
    .image{
        width: 100px;
        height : 100px;
    }

</style>

