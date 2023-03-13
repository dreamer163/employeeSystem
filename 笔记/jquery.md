# 1

## Jquery



### 1.Jquery选择器

$("xxx选择器").xxx();由jquery选择器返回的对象，通常称之为jquery对象，以式和dom对象区分



### 2.文档操作



### 3.级联操作，隐式迭代

1.jquery的操作方法，大多数但会jquery对象本身

2.jquery的操作方法，绝大多数都支持隐式迭代

### 4.jquery对象和dom对象的区别以及转换方式



1.如何获取jquery对象？使用jquery选择器获取的对象。一个jquery对象中，可以有0或多个dom对象。

2.如何获取dom对象？：jquery[x],使用下标访问jquery对象中的元素。或使用jquery对象get(x)

3.如何将dom对象转换成jquery对象？使用$(dom)即可

4.

5.







### 5.事件动画

**1.页面就绪事件**

$(function(){

//some code

});

**2.其他常用事件**

当出现xxx事件的时候，执行某种操作，xxx事件名称

$jq.xxx(function(){

//some code here

});



在事件处理函数中，this指代触发事件的dom对象。

在jquery事件处理函数中，参数是原始event对象的一个封装。



如何获取原始event？

e.originalEvent



**关闭事件**：$jq.off("xxx");

**注册事件**：$jq.on("xxx",function(){

//....

});

$jq.on("xxx",function(){

//...

});

$jq.off("xxx");



**使用js触发事件**，$jq.trigger("xxx"),使用js代码手动触发xxx事件





**3.事件委托**:事件冒泡

$jq.on("xxx","真正要监听的对象的选择器，$jq的后代元素"，function(){});















### 6.ajax





### 7.动画

$jq.xxx(speed,easing,fn);

参1：速度

参2：缓动函数

参3：回调函数

speed：slow，normal，fast，也可以使用



缓动函数：指随时间而变化的曲线

回调函数：动画结束后触发



show/hide

slideDown/slideUp/slideToggle

fadeIn/fadeOut/fadeToggle/fadeTo

## 选择器

1.支持绝大多数选择器

- :first,
- :last,
- :eq(n),
- :gt(n),
- :lt(n)

2.:even,:odd

3.contains(xxx);匹配包含指定文本的元素

4.empty:匹配**空**元素

5.parent：匹配**非空**元素

6.hidden：匹配**不可见**元素。display：none，<input type="hidden">

7.visible：匹配**可见**元素

8.[xxx],匹配拥有xxx**属性**的元素。

9.[xxx=yyy]:拥有xxx属性，且值为yyy的元素

10.[xxx!=yyy]:匹配没有xxx属性,且值等于yyy的元素

11.[xxx^=yyy]:匹配拥有xxx属性，且值以yyy开头的元素

12.[xxx$=yyy]:匹配拥有xxx属性，且值以yyy结尾的元素

13.[xxx*=yyy]匹配拥有xxx属性，且值包含yyy的元素



14.表单选择器

- :input，选中所有类型的元素，包括文本框，密码框，下拉列表框，单选按钮，复选框，文本域，文件域

- :text，选中单行文本框

- :password，选中密码框

- radio，选中单选按钮

- :submit，选中复选框

- :reset

- :button

  button类型的按钮，input类型

- :file选中文件域

- :disabled 不可用元素，enabled可用元素

- :checked选中单选按钮，或复选框被选中的元素

- :selected:选中下拉列表中被选中的元素



## 常用操作

1.css(参数1，参数2)：第一个参数代表获取css，第二个参数代表设置css

2.text(参1)：0参数代表获取文本内容，1参数代表设置文本内容

3.val（参1），有参数代表设置，无参数代表获取。

4.html(参数)，有参代表设置，无参代表获取。

5.attr(参1，参2)，两个参数代表设置，一个参数代表获取

6.removeAttr(参数)，移除属性

7.prop(参数，boolean参数)：用于设置或获取布尔类型参数

8.addClass("参数")：添加类名称，removeClass("添加类名称")，hasClass(),判断是否拥有某个class，toggleClass(参数)，切换类名称

- is("selector"):判断是否拥有某个class



9.二次筛选

- eq(n),first(),last()
- filter(选择器)，筛选出符合指定选择器的元素
- has(选择器)，筛选出拥有匹配制定选择器的子元素的元素
- not(选择器)，排除掉满足指定选择器的元素
- slice(start,end):切片，选择其中第一元素
- 四向遍历：参数可选
  - children(选择器)，向下，选取匹配制定选择器的**所有**子元素
  - parent(选择器)，获取**所有**父元素
  - find(选择器)向下，选取匹配制定选择器所有后代元素(包含子代)
  - parents(选择器)，获取所有祖先元素包括父元素
  - parentUntil(选择器)，
  - closest(选择器)，获取最近的
  - prev(选择器)，获取匹配制定选择器的**紧邻**兄元素
  - prevAll(选择器)，获取匹配制定选择器的所有兄元素，指导指定选择器
  - next()
  - nextall()
  - nextUntil()
  - sibilings(选择器)：选取所有兄弟元素，不包括自身

- add(选择器)，添加匹配制定选择器的元素到当前集合，取并集

10.is("selector"):判断jquery是不是匹配指定的选择器的元素



11.增删改查

1.增

- $a.append($b):在$a追加子元素$b
- $b.appendTo($a):
- $a.prepend($b)在$a所有子元素面前追加一个子元素。
- $a.before($b):uan
- $a.after($b)在$a的后面插入元素$b.
- $b.insertAfter($a);
- $a.remove(),移除$a

13.empty()：清空子元素

14.clone()：克隆

15.offset():获取或设置元素的偏移位置，数字类型

16.position()，相对父元素的偏移

17.scrollTop()，获取或设置滚动的距离，scrollLeft

18.width()和height()：获取或设置元素的宽度和高度

