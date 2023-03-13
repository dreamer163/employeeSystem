# javaee

## Maven

### 1.Servlet

执行web服务器中的java代码组件

接收http请求，并响应请求



请求类型get/post

只有在表单通过method属性指明为post的，才是post类型。除此之外，一切请求都是get类型



使用注解配置servlet@WebServlet



### 2.Servlet生命周期

1.从第一次访问对应的请求开始，加载创建对象。调用init（）函数。两个init函数

-可以通过参数指定servlet，从应用启动即加载，load-on-startup =1

2.持续对外提供服务，等待处理请求

3.服务器终止服务，调用destory函数



## jsp

java服务器端页面

jsp本质也是servlet，服务器Tomcat，也可以称为servlet容器，可以将jsp转译成servlet代码，并进行编译



### 1.jsp四大作用域

1.页面域：pagContext，当前页面，4

2.请求域：request，限于一次请求。1

3.会话域：session，限于一次会话。2

4.应用域：application，随应用启动而启动，随应用销毁二销毁，整个应用唯一。

### 2.九大内置对象

1.request：代表请求对象，请求域 

2.response：代表响应对象 

3.out：字符输出流，用于向前端输出内容 

4.session：代表会话对象，会话域。 

5.applicaiton：应用域，类型为ServletContext 

6.config：类型ServletConfig，servlet的配置对象 

7.exception：异常对象。只有ErrorPage才有。 

8.page：指代当前页面，即this 

9.pageContext：页面上下文，称之为页面域。