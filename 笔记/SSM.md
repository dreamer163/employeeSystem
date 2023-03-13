# SSM

SSM = springmvc + spring +mybatis

## Springmvc

### 1.搭建mvc框架的过程

1.引入 springmvc库



2.配置web.xml，配置DispatcherServlet



3.配置springmvc.xml配置文件



4.编写Controler





### 2.常用注解及相关操作

1.@Controller代表控制器组件，@RestController 代表响应json数据的控制器组件



2.@RequestMapping:表示接收请求类型的模式，可以修饰类，可以修饰方法。

修饰类的时候，表示类中所有的方法都以此为请求为基准，@RequestMappig表示各种类型的请求。处理的请求可以定义多个。



3.@GetMapping，@PostMapping注解



4.在controller的方法，定义Map，Model，ModelMap此三种类型的对象，都可以等效于对请求域的操作



### 3.存储转发和重定向

- 存储转发

- 重定向

- 加前缀forward，表示转发给另一个请求。forward:/student/list

- 加前缀redirect，表示重定向到另一个请求。redirect:/hello/list

  

### **4.参数绑定**

获取参数。自动将请求中的参数绑定到方法中的参数。

- 如果名称相同，直接绑定。
- 如果类型不同，自动转换类型(有可能异常)。基本数据类型的封装类型，String，dDate/LocalDate/LocalTime/,BigInteger,BigDecimal
- 日期类型：@DateTimeFormat
- 使用@RequestParam注解，可以指定请求参数，使用不同名称并可以指定此参数是否必须
- 如果使用@RequestParam修饰map，此时map将不作为域对象，而作为存储请求参数map
- 可以直接怼javabean直接进行绑定



### **5.响应ajax请求**

指定响应内容类型：produces="application/json;charset=utf-8"

添加@ResponseBody注解



### 6.controller中方法参数

1. 基本数据类型封装类型

   String，LocalDate/LocalTime/LocalDateTime,Date,BigInteger,BigDecimal

2. javaBean

3. Map,Model,ModelMap,等效于请求域对象使用

4. HttpServletRequest，HttpServletResponse，HttpSession

5. MutilpartFile:用于文件上传

### 7.controller中方法的返回值

1. 字符串，三种定义

2. 可以返回javabean，或者集合，或者字符串；

   当方法响应ajax请求时，返回值会被序列化为json对象

3. ModelAndView：同时作为域对象存储模型数据和视图名称。

   

   

### 8.springmvc拦截器

**1.拦截器和过滤器区别**

1.拦截的时机（位置）不同，一个是在到达servlet之前拦截，一个是到达controller之前拦截

2.过滤器是javaee内置的组件，而拦截器是springmvc提供的

3.拦截器可以使用springmvc的一些特性，但过滤器不行





**2.配置拦截器**

```xml
<!--拦截器的配置-->
<mvc:interceptors>
<!--配置一个拦截器-->
	<mvc:interceptor>
		<!--配置拦截模式，定义多个。/*,*.do,/**/*-->
		<!--/**代表任意多层目录-->
		<mvc:mapping path="/**"/>
		<!--排除拦截的请求-->
        <mvc:exclude-mapping path="/user/login"/>
        <mvc:exclude-mapping path="/user/logout"/>
        <mvc:exclude-mapping path="/**/*.js"/>
        <mvc:exclude-mapping path="/**/*.png"/>
        <mvc:exclude-mapping path="/**/*.jpg"/>
        <mvc:exclude-mapping path="/**/*.css"/>
        <mvc:exclude-mapping path="/static/**"/>
       <beanclass="com.situ.springmvc1.interceptors.SecurityInterceptor"/>
            </mvc:interceptor>
<!--继续配置拦截器-->
</mvc:interceptors>

```



**2.定义拦截器**

```java
public class SecurityInterceptor implements HandlerInterceptor {
//到达controller之前处理，返回true代表放行，返回false代表拦截
@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponseresponse, Object handler) throws Exception {
		System.out.println("到达controller之前");
		return true;
}
//到达controller之后处理
@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse
response, Object handler, ModelAndView modelAndView) throws Exception {
		System.out.println("到达controller之后");
}
}

```



**3.上传文件**

1.在springmvc配置上传文件解析器

```xml
<!--配置文件上传-->
<!-- 文件上传配置。注意：文件上传时，要配置form的enctype属性值为multipart/form-data -
->
<!-- 文件上传解析器，其id固定为multipartResolver，配置为其它值无效，此实现类依赖于
commons-fileupload、commons-io -->
<bean id="multipartResolver"
class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
		<!-- 上传文件大小上限，单位为字节（10MB） -->
		<property name="maxUploadSize" value="10485760" />
		<!-- 请求的编码格式，必须模板页的编码一致，以便正确读取表单的内容，默认为ISO-8859-1
-->
		<property name="defaultEncoding" value="UTF-8" />
</bean>

```



2.配置依赖

```xml
<!--配置文件上传-->
<!-- https://mvnrepository.com/artifact/commons-fileupload/commons-fileupload -->
<dependency>
        <groupId>commons-fileupload</groupId>
        <artifactId>commons-fileupload</artifactId>
        <version>1.5</version>
</dependency
```



3.在表单实现文件上传

```xml
<div>
    <label for="avatar">头像：</label>
    <input type="file" id="avatar" name="avatar">
</div>
    
<form action="human/edit" method="post" enctype="multipart/form-data">
```



4.在controller实现文件上传

```java
file.transferTo(target);//复制到指定位置
```





### 9.SpringMAC中的路径参数



@PathVariable注解，用于定义路径参数

请求路径：a/b/c

@RequestMapping(/{a}/{b}/{c})



### 10.

- compile：编译时需要
- runtime：
- provided：



### 11.配置

**1.tomcat**

- serletapi

- jspapi

  

**2.springmvc**/web.xml

- 引入springwebmvc

- 配置servlet，Dispatcher

- servletmapping

- springmvc.xml

  包扫描component scan：只去扫描控制器



**3.spring**

1.监听器：

```

```

2.spring.xml



**4.mybatis**

1.mybatis

2.mybatis-spring







## Spring



控制反转：IOC，把创建对象的控制权力交给框架，由框架帮你创建

依赖注入：DI，框架可以自动将某对象依赖的其他对象进行注入



StudentServiceImpl ssi = new AnotherStudentServiceImpl();

StudentDAO dao = new StudentDAOImpl();

ssi.setStudentDAO(dao);



问题1：大量创建对象。但实际上并不需要

问题2：很难再运行期间切换业务的实现，不灵活



spring 可以用来整合其他框架



### 1.使用spring框架步骤

1.引入依赖，如果web程序中已经引入了springmvc，则spring相关库会被依赖引入。

2.在web.xml中，配置spring监听器



```xml
<!--配置spring监听器-->
<!-- spring配置文件参数 -->
<context-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>classpath:spring.xml</param-value>
</context-param>
<!-- spring引入，在web应用启动时执行-->
<listener> <listenerclass>org.springframework.web.context.ContextLoaderListener</listener-class>
</listener>
```



3.注入有三种：

1.字段注入：@Autowired+属性

2.方法注入：setter方法注入

3.构造函数注入：@Autowired+构造方法



@Autowired表示依赖其他bean。按照类型匹配注入，需要容器中有唯一的制定类型的实例。



## Mybatis

### 1.配置数据库连接池：

1.引入依赖。 

2.配置。 

配置MyBatis： 

1.引入依赖。

2.配置。mybatis.xml mapper/*.xml





### 2.mybatis接口参数

1.支持基本数据类型的封装类型。Integer，Long，String，LocalDate，LocatTime，BigInteger，BigDecimal

2.支持POJO(javaBean),Student,Employee

3.支持Map

4.以上为默认支持，单参数只能是一个

5.当只有一个参数且是基本数据类型的时候，mapper.xml中任意名称可以省略

6.当只有一个参数是，可以配置parameterType。可以省略

7.除了上述情况之外，必须使用@param注解

- 数组作为参数
- List作为参数
- set作为参数
- 以上各种数据类型的组合，超过*两个*参数





### 3.mybatis映射类型

1.resultType



### 4.#和$的区别

- $原理是字符串拼接，容易引发sql注入。
-  #的原理是?

### 5.jdbctype，javatype

- complie：编译，运行时需要。 
- runtime：仅运行时需要。 
- provided：编译时需要，运行时不需要，由外部提供。



### 6.关联查询

1.一对一：association

2.一对多：collection



N+1问题

1.延迟加载：当用到关联数据的时候，才发出查询。开启延迟加载之后，所有的关联查询都会视需要而 加载。

2.二级缓存：打开 总开关。还可以解决循环关联查询问题。





### 7.一级缓存二级缓存

1.一级缓存：在同一个会话之内进行缓存，SqlSession级别

2.二级缓存：

打开总开关。映射器里面配置cache，

配置cache标记

uese =  true
