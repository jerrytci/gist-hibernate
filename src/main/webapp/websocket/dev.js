var uname = "jerry";
var sid = 1;
// var host="ws://10.144.238.15:8080/starcLL/LL_ws/"+uname+"_"+sid;
var host="ws://localhost:8080/LL_ws/"+uname+"_"+sid;
var ws = "";
if ('WebSocket' in window) {
    ws=new WebSocket(host);
} else if ('MozWebSocket' in window) {
    ws= new MozWebSocket(host);
} else {
    layui.use(['layer'], function(){
        var layer = layui.layer;
        layer.alert("您的浏览器不支持webscoket协议,建议使用新版谷歌、火狐等浏览器，请勿使用IE10以下浏览器，360浏览器请使用极速模式，不要使用兼容模式！");
    });
}

ws.onopen = function(e) {
    console.log("ws连接成功！");
    var obj={
        type:3,
        userName:uname+"_"+sid,
        contentType:"online",
        to:"all"
    }
    var message =JSON.stringify(obj);
    ws.send(message);
}

/*
var realName="测试教师";
var sendTo="qwe104,ewrrwer,fdgdfg,tea,rerere";
var content="飞机开始的恢复快第三个规范的健康过恢复健康的jhkhhjhj899";
var k=2;//1单聊2群聊
var contentType="text";
*/
function sendMessage(realName,userName,sendTo,siteId,content,contentType){
    ws.send(message);   //发到websocket
}


var obj={
    type:3,
    userName:uname+"_"+sid,
    contentType:"online",
    to:"all"
}
var message =JSON.stringify(obj);
// ws.send(message);

ws.onmessage = function(e) {
    alert("onmessage");
    alert("e: "+e);
}
