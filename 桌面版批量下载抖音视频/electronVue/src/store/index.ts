/*
 * @Author: your name
 * @Date: 2020-10-28 10:53:17
 * @LastEditTime: 2020-11-30 10:58:38
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \electronVue\src\store\index.ts
 */
import Vue from 'vue';
import Vuex from 'vuex';

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    videoList: [], // 视频列表
    saveDirectoryVideo: '', // 文件下载地址
    mergedVideopath: '', // 合并视频地址
  },
  mutations: {
    'setVideoList'(state, val:[]){
      console.log(val)
      state.videoList.push(...val);
    },
    'setSaveDirectoryVideo'(state, val){
      state.saveDirectoryVideo = val;
    },
    'setMergedVideopath'(state, val){
      state.mergedVideopath = val;
    },
    
  },
  actions: {
  },
  modules: {
  },
});
