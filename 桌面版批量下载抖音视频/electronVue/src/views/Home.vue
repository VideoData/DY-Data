<!--
 * @Author: your name
 * @Date: 2020-10-27 09:57:15
 * @LastEditTime: 2020-11-30 10:29:36
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \vue-electron\src\views\Home.vue
-->
<template>
  <div class="home">
    <el-tabs v-model="activeIndex" @tab-click="handleClick">
        <el-tab-pane label="抖音批量解析" name="0">
          <pl-option-input @search="search"/>
          <pl-video-list @getVideoList="getVideoList"/>
        </el-tab-pane>
        <el-tab-pane label="视频编辑" name="1">
          <pl-deal-with/>
        </el-tab-pane>
    </el-tabs>
  </div>
</template>

<script lang="ts">
import optionInput from '@/components/optionInput.vue'
import { Component, Prop, Vue } from 'vue-property-decorator';
import videoList from '@/components/videoList.vue';
import dealWith from '@/components/dealWith.vue';
import { showLoading, hideLoading, message } from '@/util/common.ts';
import db from '@/nodeModule/db.ts';
import store from '@/store/index.ts';
const { ipcRenderer } = window.require('electron')

@Component({
  name: 'Home',
  components: {
    'pl-option-input': optionInput,
    'pl-video-list': videoList,
    'pl-deal-with': dealWith,
  }
})
export default class OptionInput extends Vue {
  // 导航下标
  activeIndex: string = '0';
  // 搜索内容
  searchVal: string = '';
  // 搜索类型
  searchType: number = -1;
  // 搜索
  search(val: string, type: number) {
    this.searchVal = val;
    this.searchType = type;
    showLoading()
    ipcRenderer.send('GetDouYiPlayUrl', val, type);
  }
  getVideoList(){
    showLoading()
    ipcRenderer.send('GetDouYiPlayUrl', this.searchVal, this.searchType);
  }
  handleClick(val: any) {
      // console.log(val)
  }

  mounted() {
    // 视频下载目录
    ipcRenderer.on('BackShowSaveDirectory', (event: any, arg: any) => {
      db.remove({}).then(() => {
        db.insert({videoSaveDirectory: arg}).then((res: any) => {
          store.commit('setSaveDirectoryVideo', arg);
          console.log(res, '返回');
          message({
              message: res.code ? '设置失败' : '成功',
              type: res.code ? 'error' : '',
          });
        });
      })
    })
  }

}
</script>

<style lang="scss">


</style>
