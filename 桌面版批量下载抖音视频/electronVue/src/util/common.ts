/*
 * @Author: your name
 * @Date: 2020-11-11 09:57:21
 * @LastEditTime: 2020-11-11 11:06:09
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \electronVue\src\util\common.ts
 */
import { Loading, Message } from 'element-ui'
/**
 * 公共loading层 - 使用这个显示loading
 * @param text - 文字
 * @param loadingClass - 图标类名
 */
let loadingCount: number = 0;
let loading: any;

function showLoading(text?: string, loadingClass?: string, background?: string) {
    if (loadingCount === 0) {
        loading = Loading.service({
            lock: true,
            text: text || '加载中……',
            spinner: loadingClass || 'el-icon-loading',
            background: background || 'rgba(0, 0, 0, 0.3)',
        });
    }
    loadingCount += 1;
}

/**
 * 公共loading层 - 使用这个关闭loading
 */
function hideLoading() {
    if (loadingCount <= 0) {
        return;
    }
    loadingCount -= 1;
    if (loadingCount === 0) {
        loading.close();
    }
}
// 提示
function message(param: any) {
    const paramData = {
        // 提示的内容
        message: param.message || '请求数据发生错误！',
        // 提示框类型（默认成功）
        type: param.type || 'success',
    };
    Message(paramData);
}
export {
    showLoading,
    hideLoading,
    message
}