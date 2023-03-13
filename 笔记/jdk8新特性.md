# jdk8新特性

## 一.特性

### 1.函数式接口

只有一个抽象方法，（不含object的方法）的接口，可以添加@FunctionnalInterface接口 但不是必须的

### 2.接口的静态方法和默认方法

- 静态方法：static修饰，接口.方法名调用
- 默认方法：default修饰，可以被继承到其实现类中



### 3.lambda表达式

1.（一个对象）适合于方法体较少

```java
public interface Task{
    void doTask();
}
Task t = new Task(){
    public void doTask(){
        System.out.print("1111");
    }
}
---------------------
   public interface Task{
    int doTask(int a,int b);
}
Task t = () -> System.out.print("1111"); 
    
```



- 一个参数括号可以省略
- 两个参数 必须加小括号
- 类型可以省略，可以自动推断



2.双冒号**方法引用**

```
//方法引用也是一个对象

```

### 4.stream流的操作

- 中间操作：返回的依然是流
- 终结操作：无返回值，无法再继续对流操作

```java
public class Test3 {
    public static void main(String[] args) {
        /*Thread t = new Thread(()-> System.out.println("aaaa"));
        t.start();*/
        Logger logger = (t) -> System.out.println(t);
        Logger logger2 = System.out::println;

        List<Integer> list = List.of(1, 2, 3, 4, 5);
        list.stream().filter(t -> t % 2 == 0)
                .forEach(System.out::println);

        String s = list.parallelStream()
                .filter(t -> t % 2 == 0)
                .map(t->String.valueOf(t))
                .collect(Collectors.joining(","));
        System.out.println(s);
    }
}
```

```java
public class Test4 {
    public static void main(String[] args) {
        OptionalInt oi =  IntStream.rangeClosed(1, 100).reduce((a, b) -> a + b);

        System.out.println(oi.getAsInt());
    }
}
```



### 5.新增时间

- LocalDate
- LocalTime
- LocalDateTime

### 6.注解

注释的一种

源码级别：某一类型的注解只有标识作用，在编译后即擦除。如override

还有一类注解，结合反射，可以起到一定的程序逻辑，编译后依然存在

### 7.自定义注解

1. 使用**@interface**，不具备继承能力
2. 类似于定义**抽象方法**，但是**无参**。可以通过**default**定义默认值。方法返回值的类型就是值的类型
3. {}代表数组
4. 返回值只能是基本数据类型（封装类），以及数组或者引用类型，不能使用集合

## 二.java注解

### 1.java自带注解

**1.@Override**

如果试图使用 @Override 标记一个实际上并没有覆写父类的方法时，java 编译器会告警。

**2.@Deprecated**

用于标明被修饰的类或类成员、类方法已经废弃、过时，不建议使用。

**3.@SuppressWarnings**

用于关闭对类、方法、成员编译时产生的特定警告。

**4.@FunctionalInterface**

用于指示被修饰的接口是函数式接口

函数式接口(Functional Interface)就是一个有且仅有一个抽象方法，但是可以有多个非抽象方法的接口。

### 2.元注解

**1.@Retention**

用来定义该注解在哪一个级别可用，在源代码中(SOURCE)、类文件中(CLASS)或者运行时(RUNTIME)。

- @Retention(RetentionPolicy.SOURCE)

  编译时被丢弃，不包含在类文件中

- @Retention(RetentionPolicy.CLASS)

  jvm加载时被丢弃，包含在类文件中，默认值

- @Retention(RetentionPolicy.RUNTIME)

  由jvm加载，包含在类文件中，在运行时可以被获取到

​	

**2.@Documented**

生成文档信息的时候保留注解，对类作辅助说明



**3.@Target**

ElementType 是一个枚举类型，它定义了被 @Target 修饰的注解可以应用的范围：

-  @Target(ElementType.TYPE):应用于类接口（包括注解类型）枚举
-  @Target(ElementType.CONSTRUCTOR)：应用于构造函数
-  @Target(ElementType.PARAMETER)：应用于方法的参数
-  @Target(ElementType.FIELD)：应用于字段属性值
-  @Target(ElementType.METHOD)：应用于方法
-  @Target(ElementType.PACKAGE)：应用于包
-  @Target(ElementType.LOCAL_VARIABLE)：应用于局部变量
-  @Target(ElementType.TYPE)：1.8新增，应用于各种类型变量
-  @Target(ElementType.TYPE)：1.8新增，应用于任何使用类型语句中

**4.@Inherited**

@Inherited：说明子类可以继承父类中的该注解

表示自动继承注解类型。 如果注解类型声明中存在 @Inherited 元注解，则注解所修饰类的所有子类都将会继承此注解。

**5.@Repeatable**

@Repeatable 表示注解可以重复使用。

当我们需要重复使用某个注解时，希望利用相同的注解来表现所有的形式时，我们可以借助@Repeatable注解。

### 3.自定义注解
