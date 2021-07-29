/*
 * @Author: your name
 * @Date: 2020-11-03 15:03:34
 * @LastEditTime: 2020-11-05 17:36:44
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \electronVue\src\nodeModule\file.ts
 */
console.log('当前绝对文件路径：', __filename, '所在目录', __dirname);
const http = require('http');
const fs = require('fs');
const _PATH = require('path');

const obj: any = {
    fileDir: [],
    Dir: [],
    noPermissions: [],
};
function a(pathUrl: string) {
    fs.readdir(pathUrl, (err: any, files: any) => {
        files.map((v: string, index: number) => {
            const path = pathUrl + '/' + v;
            try {
                // 是不是目录
                const data = fs.statSync(path).isDirectory();
                if (data) {
                    a(path);
                    obj.Dir.push(path)
                } else {
                    const isHas = ['.PNG', '.JPG', '.GIF'].includes(_PATH.extname(path).toLocaleUpperCase());
                    if (isHas) {
                        const fileName = 'D:/name.txt';
                        fs.readFile(fileName, 'utf8', (error: string, data: any) => { 
                            if (error) { 
                                fs.writeFile(fileName, '您好 ~ \n', (error: any) => { 
                                    if(error) { 
                                        console.log(error)
                                    }
                                })
                            } else { 
                                fs.appendFile(fileName, path + '\n', (error: any) => { 
                                    if(error) { 
                                        console.log(error)
                                    }
                                })
                            } 
                        })
                        obj.fileDir.push(path)
                        console.log(obj.fileDir, '----', index)
                    }
                }
            } catch (err) {
                obj.noPermissions.push(err);
            }
        });
    })
}

const readFile = (filePath: string) => {
    fs.readFile(filePath, (err: string, data: any)=>{
        if(err) throw err;
        console.log(data, filePath, '**//')
        return data;
    })
}

export default {
    readFile,
}