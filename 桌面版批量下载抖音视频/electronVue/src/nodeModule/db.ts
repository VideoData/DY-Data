/*
 * @Author: your name
 * @Date: 2020-11-05 09:49:45
 * @LastEditTime: 2020-11-20 09:35:03
 * @LastEditors: Please set LastEditors
 * @Description: 本地数据库
 * @FilePath: \electronVue\src\nodeModule\db.ts
 */
import Datastore from 'nedb'
const path = require('path')

const { remote } = window.require('electron')
// console.log('数据', remote.app.getPath('userData'))
const nedb = new Datastore({filename: path.join(remote.app.getPath('userData'), 'device.db'), autoload: true});
// 插入数据
const insert = function insert(field: object) {
    return new Promise((resolve, reject) => {
        nedb.insert(field, function (err: any, newDoc: any) {
            if (err) {
                reject(err);
            } else {
                resolve(newDoc);
            }
        });
    })
}
// 删除数据
const remove = function remove(field: object) {
    return new Promise((resolve, reject) => {
        nedb.remove(field, function (err: any, newDoc: any) {
            if (err) {
                reject(err);
            } else {
                resolve(newDoc);
            }
        });
    })
}

// 查找数据
const find = function find(field: object) {
    return new Promise((resolve, reject) => {
        nedb.find(field, function (err: any, newDoc: any) {
            if (err) {
                reject(err);
            } else {
                resolve(newDoc);
            }
        });
    })
}

// 修改数据
/**
 * 
 * @param field {_id: number}
 * @param newField {key: value}
 */
const update = function update(field: object, newField: object) {
    return new Promise((resolve, reject) => {
        nedb.update(field,{ $set: newField }, { multi: true }, function (err: any, newDoc: any) {
            if (err) {
                reject(err);
            } else {
                resolve(newDoc);
            }
        });
    })
}
export default {
    nedb,
    insert,
    remove,
    find,
    update,
}