const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  lintOnSave: false,
  devServer:{
    port:8081,
    proxy:{
      '/host':{
        target:'http://localhost:8080/',
        pathRewrite:{'/host/':''}
      }
    }
  }
})
