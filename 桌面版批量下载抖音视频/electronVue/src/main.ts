/*
 * @Author: your name
 * @Date: 2020-10-27 09:57:15
 * @LastEditTime: 2020-11-17 11:52:53
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \vue-electron\src\main.ts
 */
import Vue from 'vue';
import App from './App.vue';
import router from './router';
import store from './store';
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import db from '@/nodeModule/db.ts'

Vue.prototype.$db = db.nedb
Vue.use(ElementUI);
Vue.config.productionTip = false;

(db as any).find({})
.then((list: any) => {
  const data = list.find((item: any) => item.videoSaveDirectory);
  console.log(data)
  if (data) {
    store.commit('setSaveDirectoryVideo', data.videoSaveDirectory);
  }
})

Vue.directive('InfiniteScroll', {
  update(el: any, binding) {
      el.onscroll = function() {
          const bottom = this.scrollHeight - (this.scrollTop + this.clientHeight);
          const { methods, allTotal, dataListLen } = binding.value;
          console.log(binding.value.status, allTotal, dataListLen);
          if (bottom < 20 && binding.value.status && allTotal > dataListLen) {
              binding.value.status = false;
              methods();
          }
      };
  },
});
new Vue({
  router,
  store,
  render: (h) => h(App),
}).$mount('#app');
