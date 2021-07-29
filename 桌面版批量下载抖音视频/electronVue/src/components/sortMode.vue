<!--
 * @Description: 拖拽视频
 * @Author: your name
 * @Date: 2019-08-15 09:28:45
 * @LastEditTime: 2020-11-04 15:42:40
 * @LastEditors: Please set LastEditors
 -->
<template>
    <div class="activity-commodity-images">
        <div class="drag-sort">
            <div class="img-list-item"
                v-for="(item, index) in list"
                :key="index">
                    <video class="video" preload controls>
                        <source :src="item.path" type='video/mp4'>
                    </video>
                <div class="delete-image" @click="deleteShopImg(index)">
                    <i class="el-icon-close"></i>
                </div>
            </div>
        </div>
    </div>
</template>

<script lang="ts">
import { Vue, Component, Watch, Prop } from 'vue-property-decorator';
import { State, namespace, Mutation } from 'vuex-class';
import Sortable from 'sortablejs';
interface VideoUrl {
    path: string; // 临时文件路径
    absolutePath: string; // 绝对地址
}

@Component({
    name: 'SortMode'
})
export default class SortMode extends Vue {
    @Prop()
    list!: VideoUrl[];

    // 删除图片
    private deleteShopImg(index: number) {
        this.list.splice(index, 1);
    }
    private changeShortcutBarCallBack(evt: any) {
        if (1 === Math.abs(evt.oldIndex - evt.newIndex)) {
            const oldShortcut = this.list[evt.oldIndex];
            this.list[
                evt.oldIndex
            ] = this.list[evt.newIndex];
            this.list[evt.newIndex] = oldShortcut;
        } else {
            const oldShortcut = this.list.splice(evt.oldIndex, 1)[0];
            this.list.splice(evt.newIndex, 0, oldShortcut);
        }
    }
    private mounted() {
        this.$nextTick(() => {
            const dragSort: any = document.getElementsByClassName('drag-sort')[0];
            Sortable.create(dragSort, {
                animation: 200,
                onEnd: this.changeShortcutBarCallBack,
            });
        });
    }
}
</script>

<style lang="scss">
.activity-commodity-images {
    .drag-sort {
        @include flexstart;
        & > div {
            cursor: move;
        }
    }
    .img-list-item {
        position: relative;
        width: 100px;
        margin-right: 10px;
        vertical-align: middle;
        border-radius: 4px;
        overflow: hidden;
        .video {
            width: 100%;
        }
        .delete-image {
            display: none;
            position: absolute;
            width: 20px;
            height: 20px;
            top: 5px;
            right: 5px;
            border-radius: 50%;
            background-color: #ffffff;
            line-height: 20px;
            text-align: center;
            cursor: pointer;
            z-index: 5;
        }
        i {
            font-size: 20px;
            text-align: center;
        }
    }
    .img-list-item:hover {
        .delete-image {
            display: block;
        }
    }
}
</style>
