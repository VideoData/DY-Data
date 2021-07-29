<!--
 * @Author: your name
 * @Date: 2020-10-27 13:34:48
 * @LastEditTime: 2020-11-27 17:37:14
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \vue-electron\src\components\optionInput.vue
-->
<template>
    <div>
        <el-input placeholder="请输入内容" v-model="input" class="input-with-select">
            <el-select v-model="selectValue" slot="prepend" placeholder="请选择" @change="changeSelect">
                <el-option v-for="(item, index) in optionList" 
                    :key="index" 
                    :label="item.name" 
                    :value="item.type">
                </el-option>
            </el-select>
            <el-button @click="search" slot="append" icon="el-icon-search" :disabled="!input" :class="{'el-icon-search-gray': input}"></el-button>
        </el-input>
    </div>
</template>  
<script lang="ts">
import { Component, Prop, Vue } from 'vue-property-decorator';
@Component
export default class OptionInput extends Vue {

    selectValue = 1;
    optionList = [
        {
            name: '抖音解析',
            type: 1,
        },
        {
            name: '抖音火山',
            type: 3,
        }    
    ];

    private inputText: string = 'https://v.douyin.com/JPU6cfJ/';
    get input() {
        return this.inputText.trim()
    }
    set input(v: string) {
        this.inputText = v
    }
    // 搜索用户
    private search() {
        this.$emit('search', this.input, this.selectValue)
    }

    // 下拉改变
    changeSelect(type: number) {
        this.selectValue = type;
        this.inputText = ''
    }
}
</script>
<style lang="css">
    .el-icon-search-gray{
        color: greenyellow;
    }
    .el-select{
        width: 200px;
    }
</style>