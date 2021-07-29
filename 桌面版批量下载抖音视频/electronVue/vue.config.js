/*
 * @Author: your name
 * @Date: 2020-10-28 15:18:37
 * @LastEditTime: 2020-11-17 10:50:54
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \electronVue\vue.config.js
 */
const path = require("path");
const webpack = require("webpack");
const ffmpegStatic = require("ffmpeg-static");
const ffprobeStatic = require("ffprobe-static");
const CopyWebpackPlugin = require("copy-webpack-plugin");
const PermissionsOutputPlugin = require("webpack-permissions-plugin");
const { platform, arch } = process;

process.env.ffmpegStatic = ffmpegStatic
process.env.ffprobeStatic = ffprobeStatic.path

let plugins = [];
if (process.env.NODE_ENV === "production") {
  // 打包不同平台的 ffmpeg 到 app
  const ffmpegBasePath = "./node_modules/ffmpeg-static/ffmpeg.exe";
  const ffprobeBasePath = "./node_modules/_ffprobe-static@3.0.0@ffprobe-static/bin"; // ffprobe-static
  const ffmpegPath = path.join(
    ffmpegBasePath
  );
  const ffprobePath = path.join(
    ffprobeBasePath,
    platform,
    arch,
    platform === "win32" ? "ffprobe.exe" : "ffprobe"
  );
  plugins.push(
    // 复制二进制文件到core文件夹中
    new CopyWebpackPlugin({
      patterns: [
        {
          from: path.join(__dirname, ffmpegPath),
          to: path.join(__dirname, "core")
        },
        {
          from: path.join(__dirname, ffprobePath),
          to: path.join(__dirname, "core")
        }
      ]
    }),
    // 调整二进制文件的权限
    new PermissionsOutputPlugin({
      buildFiles: [
        {
          path: path.resolve(__dirname, "core"),
          fileMode: "777"
        },
        {
          path: path.resolve(__dirname, "core"),
          fileMode: "777"
        }
      ]
    })
  );
}

module.exports = {
  configureWebpack: {
    plugins
  },
  css: {
    sourceMap: false,
    extract: false,
    loaderOptions: {
      sass: {
        data: `@import '@/assets/scss/index.scss';`
      }
    }
  },
  pluginOptions: {
    electronBuilder: {
      builderOptions: {
        productName: "ffmpegGUI",
        appId: "com.xmit.ffmpegGUI",
        win: {
          target: [
            {
              target: "nsis"
            }
          ],
          extraResources: {
            from: "./core/",
            to: "./core/",
            filter: ["**/*"]
          }
        },
        nsis: {
          oneClick: false,
          perMachine: true,
          allowToChangeInstallationDirectory: true,
          allowElevation: true,
        }
      }
    }
  }
}