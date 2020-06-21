import '@mdi/font/css/materialdesignicons.css' // Ensure you are using css-loader
import Vue from 'vue';
import Vuetify from 'vuetify/lib';

Vue.use(Vuetify);

export default new Vuetify({
    theme: {
        themes: {
            light: {
                primary: '#CBAA5C',
                secondary: '#083759',
            },
        },
      icons: {
        iconfont: 'mdiSvg',
      },
    },
});
