<!--
 * @Author: your name
 * @Date: 2020-11-03 17:37:29
 * @LastEditTime: 2020-11-20 13:21:44
 * @LastEditors: Please set LastEditors
 * @Description: 视频合并列表
 * @FilePath: \electronVue\src\components\dealWith.vue
-->
<template>
    <div class="deal-with">
        <div class="main" id="main">
            <div class="import-video">视频拖在这里
                <input type="file" class="file" multiple @change="checkVideo">
            </div>
            <div class="synthetic-video">
                <video class="video" v-if="mergedVideopath" preload controls>
                    <source :src="mergedVideopath" type='video/mp4'>
                </video>
            </div>
        </div>
        <pl-sort-mode :list="videoUrl"/>
        <el-button type="success" :disabled="videoUrl.length < 2" class="btn" @click="videoMerge" >合并视频</el-button>
        <p @click="initImage">生成图片</p>
    </div>
</template>

<script lang="ts">
import { Component, Prop, Vue } from 'vue-property-decorator';
import sortMode from '@/components/sortMode.vue';
import { State, namespace, Mutation } from 'vuex-class';
import { showLoading, hideLoading, message } from '@/util/common.ts';
const { ipcRenderer } = window.require('electron');
import $store from '@/store/index.ts'
const fs = window.require('fs')
interface VideoUrl {
    path: string; // 临时文件路径
    absolutePath: string; // 绝对地址
}
@Component({
    components: {
        'pl-sort-mode': sortMode,
    }
})
export default class DealWith extends Vue {
    @State((s) => s.saveDirectoryVideo) private saveDirectoryVideo!: string;
    // 合并好的视频
    @State((s) => s.mergedVideopath) private mergedVideopath!: string;
    // 视频格式
    videoFormat = ['MP4','3GP','AVI','MKV','WMV','MPG','VOB','FLV','SWF','MOV'];
    // 选择的视频路径
    videoUrl: VideoUrl[] = [];
    mounted() {
        const dragWrapper: any = document.getElementById("main");
        dragWrapper.addEventListener("drop",(e: any)=>{
            e.preventDefault(); //阻止e的默认行为
            this.checkVideo(e)
        })    
        dragWrapper.addEventListener("dragover",(e: any)=>{
            e.preventDefault();
        })  
        this._BackCmdMergeVideo()  
        this._BackGenerateImage()
        this._BackSelectVideo()
    }
    // 验证选择视频
    checkVideo(e: any) {
        const files: any = e.target.files ? e.target.files : e.dataTransfer.files;
        if (files && files.length>=1){
            for (const item of files) {
                const arr = item.path.split('.');
                const suffix = arr[arr.length - 1].toUpperCase();
                if (this.videoFormat.includes(suffix)) {
                    this.videoUrl.push({
                        path: window.URL.createObjectURL(item),
                        absolutePath: item.path.replace(/\\/g, '\\\\'),
                    })
                } else {
                    message({
                        type: 'error',
                        message: '请上传视频文件'
                    });
                }
            }
        }        
    }
    // 合成视频
    videoMerge() {
        if (!this.saveDirectoryVideo) {
            return ipcRenderer.send('ShowSaveDirectory');
        }
        showLoading('合成视频中')
        $store.commit('setMergedVideopath', '');
        // 合成文件名
        const fileName: string = `${this.saveDirectoryVideo}/1.txt`;
        let txt = '';
        for (const item of this.videoUrl) {
            txt += `file '${item.absolutePath}' \r\n`;
        }
        const status = fs.writeFileSync(fileName, txt);
        ipcRenderer.send('CmdMergeVideo', this.saveDirectoryVideo);

    }
    // 合成视频地址
    _BackCmdMergeVideo() {
        ipcRenderer.on('BackCmdMergeVideo', (event: any, res: any) => {
            console.log(res, '返回数据')
            if (+res.code === 0) {
                const binary = fs.readFileSync(res.content);
                let file = new File([binary],'1.mp4',{type:'video/mp4'})
                let path = window.URL.createObjectURL(file);
                $store.commit('setMergedVideopath', path)
            } else {
                message({
                    message: res.err || '合成失败',
                    type: 'error'
                });
            }
            hideLoading()
            // let times = setTimeout(() => {
            //     window.URL.revokeObjectURL(path);
            //     clearTimeout(times)
            // }, 1000)
        })
    }

    // 生成图片
    initImage() {
        showLoading()
        ipcRenderer.send('GenerateImage', this.saveDirectoryVideo);
    }
    // 图片回调
    _BackGenerateImage() {
        ipcRenderer.on('BackGenerateImage', (event: any, res: any) => {
            if (+res.code === 0) {
                message({
                    message: '图片生成完成',
                });
            } else {
                message({
                    message: res.err || '图片生成失败',
                    type: 'error'
                });
            }
            hideLoading()
        })
    }
    // 选择视频回调
    _BackSelectVideo() {
        ipcRenderer.on('BackSelectVideo', (event: any, files: any) => {
            this.checkVideo(files)
        })
    }
}
</script>

<style lang="scss">
.deal-with{
    width: 96%;
    @include ma;
    .main {
        @include flexsb();
        div {
            @include wh(200px, 200px, #eee);
        }
        .import-video{
            width: 200px;
            height: 200px;
            line-height: 200px;
            text-align: center;
            position: relative;
            .file{
                width: 100%;
                height: 100%;
                position: absolute;
                top: 0;
                left:0;
                opacity: 0;
            }
        }
        .synthetic-video{
            width: 200px;
            min-height: 200px;
            height: auto;
            overflow: hidden;
            .video{
                width: 100%;
                height: auto;
            }
        }
    }
    .btn{
        @include ma;
        margin-top: 20px;
    }
    
}
</style>



