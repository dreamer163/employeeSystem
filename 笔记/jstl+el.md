# jstl+el

## EL

:express language表达式语言，jsp默认支持

${},会自动进行反射调用



## jstl

jsp standard library，jsp标准标签库。需要引入相关的库

# 过滤器和监听器

## 1.过滤器

## 2.监听器









ServletContextListener：监听应用上下文的创建与销毁

ServletContextAttributeListener：监听应用上下文对属性的操作



ServletRequestListener：监听请求的创建与销毁

ServletRequestAttributeListener





SessionListener

SessionAttributeListener







# session和cookie

session是一个服务器端对象，可以存储数据

对于同一用户的多个请求公用一个会话



cookie是客户端访问服务器请求时，携带的小量的数据(字符串)，没有安全性可言，也不能携带大量数据。

通常情况下，session可以借助cookie携带一个jsessionid



