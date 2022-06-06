
const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  lintOnSave: false,
  devServer:{
    port:8081,
    // proxy:{
    //   //带有/host标签的请求向目的主机发生请求
    //   '/host':{
    //     target:'http://localhost:8080/',
    //     //将/host/替换为空字符串
    //     pathRewrite:{'/host/':''}
    //   }
    // }
  },

  configureWebpack: {
    resolve: { extensions: [".ts", ".tsx", ".js", ".json"] },
    module: {
      rules: [
        {
          test: /\.tsx?$/,
          loader: 'ts-loader',
          exclude: /node_modules/,
          options: {
            appendTsSuffixTo: [/\.vue$/],
          }
        }
      ]
    }
  }
})
