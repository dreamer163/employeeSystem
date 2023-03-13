# JAVA基础

## 第一章

### 1.基本数据类型

**（这八个基本数据类型不是对象）**

byte：1Byte

short：2个字节

int：4个字节

long：8个字节

float：4个字节

double：8个字节

boolean：true，false

char：2个字节

BigInteger:大整数，存储无限精度

BigDecimal：大实数，存储无限精度

### 2.运算符，表达式

算数运算符：+-*/

比较：><,>=<=

逻辑：与或非

赋值：=,+=,-=,*=,%=

位运算：&|^,左移<<右移>>

条件运算符：a?b:c

### 3.控制流

顺序：从上往下，逐行执行

选择：分支结构，if...ifelse,并列的ifelse，嵌套的ifelse，switch中包含了（case，default）

循环：while，do...while，for

### 4.数组

（用一个变量来存一组数据）

```java
int a[] = new int[10];
int b[] = new int[]{1,2,3};
int c[] = {1,2,3};
a.length
```

1.数组定义：int[] a = new int[5]; //定义

2.数组定义之后，即拥有默认值。

整数类型：0 

小数类型：0.0 

布尔类型：false

字符类型：'\0'，其实就是0 

引用类型：null 

3.数组在定义的同时，初始化：int[] a = new int[]{1,2,3,4,5}; int[] a = {1,2,3,4,5}; 

4.数组的长度：.length属性，只读。

5.访问数组元素：使用下标、索引。下标：非负整数。

6.数组特点 ：数组类型，即数组中每个元素的类型，每个数组元素的类型是一致的。

7.选择法排序和冒泡法排序

```java
    for(int i=0;i<a.length-1;i++) { //选择排序
            for(int j=i+1;j<a.length;j++) {
                if(a[i]>a[j]) {
                    int temp = a[j];
                    a[j]=a[i];
                    a[i]=temp; 
                }
            }
        }
```

```java
//选择法排序
```



### 5.函数

函数名，满足标识符规则：字母，数字，下划线，不能以数字开头，不能是关键字，可以是$。

### 6.面向对象（封装继承多态）

类：类型，程序员自己创建

对象：以类为模板，创建出的实例。运行时，new出来，存在于内存中

**面向对象**的三大特性

1.封装：对象是有一定状态（字段）和行为（方法）的个体。通过访问修饰符控制对象内部成员的可见性 

|            | public | protected | 空   | private |
| :--------- | ------ | --------- | ---- | ------- |
| 外部       | 对     |           |      |         |
| 子类       | 对     | 对        |      |         |
| 同一个包内 | 对     | 对        | 对   |         |
| 类内       | 对     | 对        | 对   | 对      |



2.继承：单根继承结构，最高类是Object，extends关键字，只能继承一个类。

（1）重写：override，覆盖父类（祖先类）的方法

（2）重载：方法名相同，单参数列表不同。（个数不同，参数不同，类型不同）

3.多态：对同一个引用，可能会出现不同的实现（不同的行为）

```java
public void run(Animal a){
    a.run();//a具体什么类型我不知道，我知道类型是Animal,或者是后代类实例
}
Animal a = new A(); // A的父类是Animal
//使用父类的引用，指向子类的对象。党调用父类的方法，实际上执行的是子类的方法

```

### 7.抽象类，抽象接口，内部类

**抽象类**：使用*abstract*关键字修饰的类，不能实例化，除此之外和普通类没有任何区别，抽象类可以没有抽象方法

**抽象方法**：使用abstract关键字修饰的方法，抽象方法没有方法体。

1.这个方法我不知道怎么实现，或者我不想写也不应该我写，而是让我的子类去写。

2.如果有抽象方法，这个类只能是抽象类

**接口**：抽象类的再次延伸，没有已实现的方法，全部为抽象方法。（约束一个类必须有何种行为），实现了这个接口就必须有这个行为

```java
public interface B{
	public abstract void run();
    void runnable(); //public abstract 默认省略，全部为抽象方法
}
```

```java
public class  C implements B{
	void runnable(){
        //实现B的方法
    }
}
C b = new C();
System.out.println(b instanceof C);//判断b是否为C的实例

```

**接口的特点**：

1.类使用implements关键字来实现接口，一个类可以实现多个接口。（单继承多实现）

2.接口可以继承其他接口，多个。使用extends关键字

**内部类**：定义在类内部的类

1.成员内部类（非静态内部类）:内部类违外部类的一个普通成员，

持有一个指向外部类对象的引用，自由的访问外部类的成员,变相的实现了多重继承

```java
public class A{
	private int age;
	public void setAge(){
		this.age=age;
	}
	class B{//内部类
        public void init() extends C{
            age=20;
            setAge(10);
            super.c();//继承父类C的方法
            class D{
                //局部内部类，定义在代码块中，有作用域的。外部根本用不了，生命周期比较短暂有局限
            }
        }
	}
}
```

2.静态内部类：class前面+static，没有指向外部类对象的引用。只能引用外部类的静态成员

3.局部内部类：定义在代码块之中的类，有作用域和生命周期

4.匿名内部类：适用于只需要一个对象的场景。借助于继承，或者实现接口。定义类同时，创建此类的唯一对象

```java
A a =new A(){
    //大括号包围的是匿名内部类，等同于创建了一个对象xxx继承自A
};
```

### 8.构造函数

1.和类同名，没有返回值，用于创建和初始化对象。

2.可以重载。

3.可以调用其他构造函数，this(...),必须是方法体的第一句。

4.可以不定义构造方法，默认创建一个共有的无参的构造方法。

5.构造函数的第一句，一定是this(...)，或者super(...)的调用；如果super无参数，可以省略super();super表示调用父类的构造函数。

```java
public class C{
	public C(){
		super(...);this(...);
	}
}
```

6.构造函数可以使用访问修饰符，private，void

7.类先执行静态成员（块）。执行构造函数时，先要调用父类构造函数（递归），之后执行普通代码块，最后执行用户代码。

```java
public class B {
    public B() {
        super();
        System.out.println("111");
    }
    static {
        System.out.println("222");
    }
    {
        System.out.println("333");
    }
}
```

```java
public class A extends B {
    static {
        System.out.println("aaa");
    }
    public A() {
        System.out.println("bbb");
    }
    {
        System.out.println("ccc");
    }
}
```

```java
public class Test {
    public static void main(String[] args) {
        new A();
    }
}
//输出的句子  22 aa  33 11 cc bb
```

**super关键字** 

1.super. 可以访问父类的成员。

2.super() 可以访问父类的构造函数。 

方法的重写： 在子类中，对父类继承下来的方法进行覆盖。

### 9.static和final关键字

static：表示静态的类的，使用static修饰的成员，无须先创建对象，通过类名可直接进行访问

final：表示最终的。不可改变的。

1.修饰变量：表示变量不可变，常量。 

2.修饰方法：表示此方法是最终的，不可变的，不可被重写。

3.修饰类：表示此类是最终的，不可被继承。





## 第二章

### 1.常用类

1.String类

```java
String s = new String("a"); //s的内容是a，无法改变
//对象存在于堆中 s引用存在于栈中
String s2="a";
"b".   //可以点出东西== new String("a")
```

(1).值不可改变String天生线程安全

(2).final修饰，不可被继承

(3).引出缓存机制，可以缓存字符串常量

```java
String s1 = "a";//创建对象
String s2 = "a";//没有创建对象，在堆的字符串池中
Strign s3 = new String("a");//共开辟了两个对象 
System.out.println(s1==s2);//是True
```

```java
String a1 = "ja"+"va";
String a2 = "java";//java一开始就有
//共创建两个对象
String a1 ="计算机"+"语言";//创建三个对象
String a2 ="计算机语言";
```

但StringBuilder和StringBuffer的值可以改变

StringBuilder：线程不安全

StringBuffer：线程安全

(4).常用方法：charAt，indexOf，subString,replace,length(),split()

(5).+可以将两个字符串拼接



2.Object类：所有类的最终父类(根)

eaquls：判断两个对象是否相等

hashCode：生成一个唯一的hash码。

toString：将对象以字符串形式展示

前三个都可以被重写





3.Date类：

表示日期和时间的类

LocalDate：表示日期

LocalTime：表示时间

LocalDateTime：表示时间和日期



4.Calenda类：日历类



5.Math类

6.BigInteger类：大整数，存储无限精度

7.BidDecimal类：大实数，存储无限精度



8.基本数据类型（原始类型）封装类：引用类型

int：Integer

byte：Byte

short：Short

long：Long

float：Float

double：Double

boolean：Boolean

char：Character



9.拆箱装箱

```java
int a = 10;//基本数据类型
Integer a1 = 10;//引用类型
Integer a1 = Integer.ValueOf(10);//装箱机制和上一句一样
int a2 = Integer.parseInt("100");//字符串转化数字int类型

System.out.print(a2+a1);//自动拆箱了
```

Integer.paraseInt()

------

### 2.集合与泛型

集合：数据的容器。数组

![20180803193423722](C:\Users\shaofuhao\Desktop\20180803193423722.png)

List：列表，接口，有序重复

(1).ArrayList:底层基于数组实现的List，可以自动增长

(2).LinkedList：基于双向链表实现的List



Set：集合，存储不重复无序数据，接口

(1).HashSet：底层是通过HashMap来实现的



Map：映射，关联，存储键值对

(1).HashMap：存储键值对，通过hash码的原理来判断键是否重复。底层实现：数组+链表+红黑树

```java
HashMap<String,Integer> map = new HashMap<>();
map.put("001",1);
```









泛型应用在方法和类上

1.定义在类上 public class Test<A>{}，在类内部进行约束

2.定义在方法上，在方法内进行约束



### 3.异常处理

try：尝试执行，监控一段代码

catch：可以有多个 finally只能有一个

finally：无论是否出现异常，必须要执行的一段。finalize：对象不用了一个清理操作

throw：触发一个异常

throws：定义在方法之后，可以抛出多种异常，

```java
test();//谁调用谁处理异常
public static void test() throws Exception{
//把异常抛出给上层调用者处理
}
throw //写在方法体中
public static void test() {
	throw new Exception();// 自己处理 或者抛出去
}
```

运行时异常（RuntimeException）不强制要求捕获

检查异常：要求必须显示捕获

**常用异常**

NullPointerException：

ArrayIndexOutOfBoundsException：

StringIndexOutOfBoundsException：

ArithmeticException：

RuntimeException：

IOException：

FileNotFoundException：

### 4.IO

**Input、Output以流机制实**
字节流
java.io.InputStream 字节输入流
java.io.OutputStream 字节输出流
字符流
java.io.Reader 字符输入流
java.io.Writer 字符输出流
注意：

四大家族的首领都是抽象类。(abstract class)
所有的流都实现了：
java.io.Closeable接口，都是可关闭的，都有 close() 方法。
流是一个管道，这个是内存和硬盘之间的通道，用完之后一定要关闭，不然会耗费(占用)很多资源。养成好习惯，用完流一定要关闭。
所有的 输出流 都实现了：
java.io.Flushable接口，都是可刷新的，都有 flush() 方法。
养成一个好习惯，输出流在最终输出之后，一定要记得flush()刷新一下。这个刷新表示将通道/管道当中剩余未输出的数据强行输出完（清空管道！）刷新的作用就是清空管道。
ps：如果没有flush()可能会导致丢失数据。



在java中只要“类名”以 Stream 结尾的都是字节流。以“ Reader/Writer ”结尾的都是字符流。
**Java要掌握的流（16个）**
文件专属：
java.io.FileInputStream（掌握）
java.io.FileOutputStream（掌握）
java.io.FileReader
java.io.FileWriter
转换流：（将字节流转换成字符流）
java.io.InputStreamReader
java.io.OutputStreamWriter
缓冲流专属：
java.io.BufferedReader
java.io.BufferedWriter
java.io.BufferedInputStream
java.io.BufferedOutputStream
数据流专属：
java.io.DataInputStream
java.io.DataOutputStream
标准输出流：
java.io.PrintWriter
java.io.PrintStream（掌握）
对象专属流：
java.io.ObjectInputStream（掌握）
java.io.ObjectOutputStream（掌握）
File文件类
java.io.File
补充：Windows/Linux小知识点
Windows：D:\Soft\QQ\Plugin
Linux：      D:/Soft/QQ/Plugin

注意： Windows各个文件之间分隔符为：” \ “；Linux各个文件之间分割符为：” / “

补充：IDEA默认的当前路径是？
工程Project的根就是IDEA的默认当前路径



#### **java.io.FileInputStream**

文件字节输入流，万能的，任何类型的文件都可以采用这个流来读

构造方法
构造方法名	备注
FileInputStream(String name)	name为文件路径
FileInputStream(File file)	
方法

1. 方法名	作用

2. int read()	读取一个字节，返回值为该字节ASCII码；读到文件末尾返回-1

3. int read(byte[] b)	读b数组长度的字节到b数组中，返回值为读到的字节个数；读到文件末尾返回-1

4. int read(byte[] b, int off, int len)	从b数组off位置读len长度的字节到b数组中，返回值为读到的字节个数；读到文件末尾返回-1

5. int available()	返回文件有效的字节数

6. long skip(long n)	跳过n个字节

7. void close()	关闭文件输入流

   

#### **java.io.FileOutputStream**

构造方法
构造方法名	备注
FileOutputStream(String name)	name为文件路径
FileOutputStream(String name, boolean append)	name为文件路径，append为true表示在文件末尾追加；为false表示清空文件内容，重新写入
FileOutputStream(File file)	
FileOutputStream(File file, boolean append)	append为true表示在文件末尾追加；为false表示清空文件内容，重新写入方法
**方法名	                      作用**
void write(int b)	将指定字节写入文件中
void write(byte[] b)	将b.length个字节写入文件中
void write(byte[] b, int off, int len)	将b数组off位置开始，len长度的字节写入文件中
void flush()	刷新此输出流并强制写出所有缓冲的输出字节
void close()	关闭文件输出流java.io.FileReader
FileReader 文件字符输入流，只能读取普通文本。读取文本内容时，比较方便，快捷。

#### **java.io.FileWriter**

**构造方法名	            备注**
FileReader(String fileName)	name为文件路径
FileReader(File file)	
方法
**方法名	                              作用**
int read()	读取一个字符，返回值为该字符ASCII码；读到文件末尾返回-1
int read(char[] c)	读c数组长度的字节到c数组中，返回值为读到的字符个数；读到文件末尾返回-1
int read(char[] c, int off, int len)	从c素组off位置读len长度的字符到c数组中，返回值为读到的字符个数；读到文件末尾返回-1
long skip(long n)	跳过n个字符
void close()	关闭文件输入流



#### **java.io.FileWriter**

FileWriter文件字符输出流。写。只能输出普通文本。

构造方法
构造方法名	备注
FileWriter(String fileName)	name为文件路径
FileWriter(String fileName, boolean append)	name为文件路径，append为true表示在文件末尾追加；为false表示清空文件内容，重新写入
FileWriter(File file)	
FileWriter(File file, boolean append)	append为true表示在文件末尾追加；为false表示清空文件内容，重新写入
方法
方法名	作用
void write(int c)	将指定字符写入文件中
void write(char[] c)	将c.length个字符写入文件中
void write(char[] c, int off, int len)	将c素组off位置开始，len长度的字符写入文件中
void write(String str)	将字符串写入文件中
void write(String str, int off, int len)	从字符串off位置开始截取len长度的字符串写入文件
void flush()	刷新此输出流并强制写出所有缓冲的输出字符
void close()	关闭文件输出流





7.读写properties文件



## 第三章

### 1.多线程

进程与线程的区别：process，thread。一个程序最少是一个进程，操作系统直接进行调度。

线程共享内存.

1.用Thread创建

```java
Thread t = new Thread(){ //匿名内部类，继承Thread类
	public void run(){//重写 run方法
		for(int i;i<10;i++){
			System.out.print("i");
		}
	}
};
t.start();//启动线程
t.run();//单纯调用run方法
```

2.创建Runnable接口的实现类，

```java
Runnable  r = new Runnable(){
	public void run(){
				for(int i;i<10;i++){
                    Thread.yield();//让步
			System.out.print("i");
		}
	}
}
Thread r =new Thead(r);
```

3.jdk1.5新增了Excutor,Excutors(工具类),ExcutorService,线程池

Excutor：接口，用于提交任务

Excutors：提空一些快速创建Excutor的工具类

ExcutorService：接口，继承自Excutor，扩展了一些接口而已

Future类：代表一个未来有值的

Thread.sleep()休眠指定的秒数



```java
ExcutorService es = Excutors.newSingleThreadExecutor();//单线程池
ExcutorService es = Excutors.newFixedThreadPool(5);//创建固定数量五个线程池
es.execute(r);
```

```java
ExcutorService es = Excutors.newSingleThreadExecutor()
Callable<Integer> c = new Callable<>(){
	public Integer call() throws Exception{
		Thread.sleep(3000);
	}
};
Future<Integer> f= es.submit(c);
```

wait():表示等待，可指定具体的等待时间，或者无限等待

notify():唤醒一个等待中的线程    

notifyAll()：唤醒所有等待中的线程

等待和唤醒操作必须放到同步块中，用同一把锁，lock.wait()放入等待池

synchronized：	

```java
public static void main(String[] args){
    


}




```



### 2.反射



1.专门用于描述其他类的类，叫Class





**如何获取Class类型对象**

1.类名.class

2.通过对象，getClass来获取

3.Class.forName("类全名");

```java
Class<?> clazz = Student.class;  //1.类名.class
Student s = new Student();//2.通过对象，getClass来获取
Class<?> clazz1=s.getClass();
Class<?> clazz2=  Class.forName("包名加类名");//3.Class.forName()
```

**反射可以做什么**

1.创建对象,建议使用构造函数创建对象

```java
 Constructor<Student> fun =(Constructor<Student>)
 												clazz.getDeclaredConstructor(String.class, String.class, int.class);
Student stu = fun.newInstance("孙小美", "女", Integer.valueOf(30));//用构造函数
```

2.可以访问对象的属性

```

```

3.可以访问(调用)对象的方法.无法获取方法体，但可以调用方法。



**和反射相关的类**

1.Class：描述类的类

```

```

2.Constructor：描述构造函数的类

```

```

```java
public void printNumber(Integer... numbers){//这个函数不定参数
	System.out.println(numbers.length);//
}
```

3.Field：描述字段的类

```


```

4.Method：描述方法的类

```


```

5.Parameter：描述方法参数的类





有几种创建对象的方式

1.new 加构造函数创建对象。

2.反射创建。

3.反序列化创建的对象。

4.克隆



