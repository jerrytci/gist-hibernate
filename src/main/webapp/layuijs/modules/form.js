/*
  Demo1.js
  使用Layui的form和upload模块
*/
layui.use(['form', 'upload'], function(){  //如果只加载一个模块，可以不填数组。如：layui.use('form')
    var form = layui.form //获取form模块
        ,upload = layui.upload; //获取upload模块

    //监听提交按钮
    form.on('submit(test)', function(data){
        console.log(data);
    });

    //实例化一个上传控件
    upload({
        url: '上传接口url'
        ,success: function(data){
            console.log(data);
        }
    })
});