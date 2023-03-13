# ajax

页面异步无刷新的请求机制。

创造web2.0时代

1.ajax需要通过js来实现，借助于jquery。





1.$.post(url,{

​		pageNo:1;

​		pageSize:10;

},function(resp ){



//回调。请求响应完成，调用此回调函数。

},"json");    //发送一个ajax请求



2.ajax响应类型

- resp.setContentType("application/json;charset=utf-8");
- resp.setCharacterEncoding("utf-8");





3.json字符串

一种js的对象表示方式

{

​	k1:v1,

​	k2:v2,

​	k3,v3。

}