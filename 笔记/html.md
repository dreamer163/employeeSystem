# HTML/CSS/JS

## HTML5

### 1.主要标记

- h1-h6
- 块标记：独占一行 h1-h6，p，hr，ul，div

- 内联标记（行内标记）：不独占一行，从左向右排列。文本格式化标记。表单元素。span




### 2.颜色的表示方法

1.英文单词。whilte，black，silver，gold，brown，yellow，red，green，blue。。等等 

2.rgb函数表示法：rgb(0,0,0) 代表黑色，rgb(255,255,255)，rgb(255,0,0) 

3.使用#十六进制表示法（6位十六进制字符）：#ffffff。#ff0000，#0000ff。 

4.缩写格式：#fff，#000，#f00，#00f。



### 3.列表标记

- 有序ol，li
- 无序ul，li
- 定义列表dl，dt，dd

### 4.表格标记

- table thead tbody tfoot tr th td 
- colspan：表示列合并。 
- rowspan：表示行合并。



### 5.表单标记

- id：通用属性，可以用在任意标记，用于唯一的标识一个元素。不能重复。 
- name：通用属性，可以用在任意表单元素。可以重复。 
- readonly：布尔属性，只读。 
- disabled：布尔属性，禁用。表示此表单元素不再生效，也不向后台服务器提交数据。通用属性，可以 用在任意表单元素。 
- checked：默认选中，用于单选按钮和复选框。 
- selected：默认选中，用于select的option元素。
-  value：通用属性，用在任意表单元素，表示此元素向后台提交的数据。





## CSS

样式的三种引入方式： 

### 1.行内样式（内联样式）

直接在标记上使用style属性引入。缺点：只能修饰当前所在标记。 

### 2.页内样式

在当前页面引入样式，供本页使用。style标记。需要使用css选择器指定要修饰的元素集 合。

样式语法： 样式名：样式值； 

### 3.常用样式

1.color：前景色。

2.font-size：设置字号。单位可以px，em，rem，pt。 

3.background-color：背景色。

4.text-align：left|right|center。文本内容的水平对齐方式。

5.text-decoration：underline下划线，none，没有任何修饰。 

6.width：设置宽度，单位可以是像素或者百分比。

7.height：设置高度，单位可以是像素或者百分比。 

8.font-style：italic，字体斜体。

9.font-family：字体家族。 

10.display：none，不显示。block|inline|inline-block|flex|table｜table-cell 



### 4.基础选择器

1.标记选择器：标记名。

2.id选择器：#id名称。 

3.类选择器：.类名称。一个标记可以有多个类名称，使用空格分隔。 

4.全选选择器：*，表示选中全部元素。

css三种引用方式：

3.引入外部样式表文件。



### 5.复合选择器

a和b都是其他选择器（基础选择器，或者其他选择器）

1.子代选择器：a>b，tr>td选中 tr下的td

2.后代选择器：a空格b  #tbl控 空格 tr>td (tbl表格后下tr的td)

3.兄弟选择器：a~b所有弟，a+b紧邻弟

4.并集选择器：a,b

5.交集选择器：ab (div.my),注意顺序，不要歧义



### 6.超链接伪类选择器

爱恨准则。lovehate

:link,

:visited,

:hover,

:active

### 7.伪元素选择器

::before,::after



### 8.其他伪类选择器

:first-child：选中作为其父元素的第一个子元素的元素

:last-child：选中作为其父元素的最后一个子元素的元素

:nth-child(n),选中作为其父元素的第n个元素

:not(s),div:not(clear) 排除掉



### 9.盒模型：box model 

css将任意一个html元素都是为一个盒子。以div实例

从外到内

- margin-box
- border-box
- padding-box
- context-area

盒元素占用总宽度=内容区域宽度+左右内边距+左右内边框+左右外边距

margin：1px 2px 3px 4px

- 四个值：上右下左
- 三个值：上，左右，下
- 两个值：上下，左右
- 一个值；上下左右全都是



### 10.常用样式

1.border：边框样式。dashed|dotted|solid

2.border-radius：边框圆角

3.border-collapse：collapse，表格边框折叠

4.font-weight：字重。normal正常，bold加粗的。也可以整数表示重复

5.cursor：default、move、pointer

6.border-width

7.border-style

8.border-color

9.display:inline-block（内敛，块）

10.box-sizing:boder-box,content-box

11.overflow:hidden|scroll。overflow-x，overflow-y

12.background-position：cover恰好能覆盖，contain恰好被包含

- 块元素：可以设置尺寸 **display：block**
- 内联元素：默认尺寸，尤其内容所决定，不能设置尺寸***display：inline***

隐藏

- display:none
- visibility:hidden

### 11.等分布局

1.calc((100%-30pc)/4)函数



### 12.浮动

一种破坏默认文档流规则的机制

float：left|right

清除浮动

1.必须使用一兄弟元素来清除浮动

2.必须在浮动元素的后面

3.



### 13.定位

可以将一个元素定位到网页中的任意位置

1.position：static/absolute/relative/fixed （static和不写一样）

- 绝对定位：参照物，以当前元素最接近的非static定位祖先元素为参照，找不到就往上找，最后body参照
- 相对定位：参照物，以当前元素未偏移之前的位置为参照
- 固定定位：参照物，以可视区域为参照



注意事项：相对定位，如果不指定偏移，则位置不变。



2.z-index：值是整数

控制浏览器平面的显示



3.top：



4.left：



5.right：



6.bottom:

### 14.样式的层叠

（css可以写在任何位置）

层叠：一个元素的样式，可能是多种样式层叠加的效果

继承：某些样式具备继承特性，一般是文本格式化样式。

优先级：参考规则

- 样式修饰，离修饰元素**最近**优先级最高。
- 选择器选择**越精准**优先级越高，或者起个id#xxx更精准
- **!important**优先级非常高,比行内优先级还高。写在任意样式的后面
- max-width/min-width/max-height/min-height,优先级高

### 15.额外的布局flex

css3中万能布局

- 弹性布局，display：flex
- 值为row横向为主轴，flex-direction：row
- 值为column纵向为主轴，flex-direction：column
- 主轴对齐方式，justify-content：space-between
- 交叉轴对其方式，align-items：center

### 16.额外的css3效果

过渡：transition

动画：animation

### 17.响应式

### 18.盒阴影

box-shadow：5px 5px 5px gray

### 19.颜色透明

1.opacity：.5

2.background-color：rgba(0,0,0,.5);

3.background-color:transparent



## JS

js：负责动态效果，行为交互

js脚本语言，以网页作为宿主运行，Node.js服务器编程语言

语法：以es5作为基准



### 1.标识符，关键字，变量，常量

- var a = 10;
- const c = 20;

### 2.数据类型

原始类型

- number：数字包括整数小数其实就是双精度数字
- string：字符串。可以使用**单**引号，也可以使用**双**引号
- boolean：true和false
- undefined：未定义
- null：一个不指向对象的引用

引用类型：

除了原始类型之外，都是引用类型。包括：数组，对象，函数。



### 3.流程控制

- 顺序
- 选择：判定条件和java区别，**非零非空**即为真
- 循环

let sum =0;

for(let i=0;i<=100;i++){

​	sum += i;

}

console.log(sum)



### 4.数组

是一个对象object

let a = [];

let b =[1,2,3,4,5]

console.log(b.length);

万能数据结构，

- let a = [1,2,3];
- a.push(4);//尾部压入
- let b = a.pop();//尾部取出
  a.unshift(100);//头部压入
  let c = a.shift();//头部取出

### 5.函数





### 6.运算符

- 算术：

- 比较：

  ===，!== 恒等于，完全等于，即判断类型也判断值

  ==仅判断其值是否相等，忽略类型

- 逻辑：

- 位：

- 赋值：

- 条件：



### 7.DOM

Document Object Model 文档对象模型

在js中，将每一个html元素都视为一个对象，通过js就可以操作这些对象

```html
let my = document.getElementById("my");

```

在js中，有一些类型，拥有和数组类似的行为（可以使用下标索引，有length属性），称之为类数组。



**获取dom元素的方法**

1.document.getElementByiId;

2.document.getElementsByClassName;

3.doument.querySelectAll();//在dom上下文，去获取所有匹配元素

4.document.querySelector()//在dom上下文，只获取第一个匹配元素



**dom对象常用属性和行为**

1.innerText:指代元素的文本内容，读写

2.innerHTML:指代元素的html内容

3.style：指代元素的行内样式

4.className：读写dom元素的class值

5.classList：用于指代dom元素的class值的一个对象，add remove contains

6.removeAttribute：移除一个属性，参数为属性名称

7.hasAttribute：用于判断是否拥有某个指定名称的属性

8.getAttribute：获取某个属性的值

9.setAttribute：用于设置（添加）属性

10.tagName：返回一个元素的标签名，只读



**11.增删改查**

- createElement：凭空创建一个dom对象

- parent.appendChild(child):父dom追加一个子元素

- parent.insertBefore(child,target):父dom添加一个子元素到target的面前

- dom.remove();dom元素移除自身

- 父dom.removeChild(child):

  

**12.四向遍历**

1. parentElement：获取父元素.唯一
2. childElementCount：获取子元素的个数，只读
3. children：获取所有子元素，返回值是类数组
4. previousElementSibing：获取兄元素。唯一，如果没有，返回null
5. nextElementSibling：获取弟元素，唯一，如果没有，返回null





### 8.js的事件处理

**定义事件的三种方式**

1.直接写在行内，写在行内，onxxx，onclick

- 无法写太长代码

- 不方便阅读维护调试，调用函数。

- 同一类型事件只能定义一个

  

2.dom.onXXX

本质即修改标记的onxxx属性，同第一种方式相同

- 取消事件：btn.onclick=null

  

3.dom.addEventListener("xxx",fun)推荐

- 1参：事件类型，2参：事件处理函数

- 可以对同一类型的事件添加多次（按定义的顺序调用），不与onxxx冲突
- btn.addEventListener("click",func)：移除事件处理函数，第一个参数事件类型，第二个参数事件处理看书。绑定匿名函数，无法移除







**事件对象：**

封装了事件触发现场的一些相关数据

1.内置的事件对象event

2.在事件处理函数中，第一个参数即为event对象



**dom属性：**

1.offsetTop：上偏移

2.offsetLeft：左偏移

3.offsetParent：绝对定位的参照dom





**常用事件类型**

1.click，单击事件

2.dblclick，双击事件

3.键盘相关事件，keydown，keyup，keypressed

- keydown可以持续触发
- keyup松开触发只触发一次

4.鼠标相关事件

- mousedown
- mouseup
- mouseleave
- mouseover
- moudeenter
- mousemove

5.载入事件：unload事件，页面加载完毕事件，图像加载完毕事件

- window.onload



**引入js三种方式**

1.行内js：只能用于事件处理属性。onxxx

2.页内js：

3.引入外部js：







**事件委托**

1.事件冒泡

使用场景：



1.很多相同（或相似）的元素添加事件监听器。

2.预期有不存在的元素，提前添加事件

### 9.动画

随时间有节奏的变化，

1.setTimeout()

2.setInterval()

3.clearTimeOut：清除一个循环定时器

4.clearInterval：清除一个循环定时器





### 10.bom

Browser Object Model 浏览器对象模型

通过js可以控制浏览器中的一些对象

- window：window.document。
- location：指代地址栏对象，可以更换地址
- history：指代访问历史记录。



localStorage：本地存储

sessionStroage：会话存储
