# README

> [Java网课]()的笔记

## UML建模语言

- 用例图
- 时序图 绘制工厂设计模式
- 类图


## 继承

### 定义与使用

`extends` 子类扩充属性

总结：虽然都在同一片堆内存中，但是也分父类与子类的区别。

**子类对象实例化流程**

1. 子类的构造方法里，隐含了`super()`。如果父类没有提供无参构造，就得用`super()`调用有参构造

> 当实例化子类对象时，先调用父类的构造的语句


继承定义的限制：
1. Java不允许多重继承，但允许多层继承
2. 子类可以继承父类的所有操作结构。但对于私有操作属于显式继承

## 覆写

### 方法覆写

当子类定义了一个方法，它与父类方法名称相同，参数类型及个数完全相同的时候，这种现象称为方法的覆写。

### 属性覆写

```
super.getInfo()
```

**super与this区别**

1. this先查找本类，再查找父类；super只查找父类
2. this与super都可以进行构造方法调用
3. this可以表示当前对象

### final 关键字

定义不能被继承的类、不能被覆写的方法、常量

```java
public static final int ON = 1;
// 全局常量
```

## Annotation

**`@Override`**
> 程序编译的时候，检查覆写的正确性

1. 忘记写extends
2. 覆写的方法名称错误

**`@Deprecated`**
> 过期声明


**`@SuppressWarnings`**
> 压制警告

## Object

> toString equals

## 抽象类

- 抽象类必须提供有子类，子类使用extends继承一个抽象类
- 抽象类的子类一定要覆写抽象类中的全部方法
- 抽象类的对象实例化可以利用对象多态性通过子类向上转型的方式完成

**注意**
1. 不能用final定义

### 模板设计模式

> 应用

## 接口

### 基本定义

> 接口和抽象类之间的区别

抽象类与普通类相比最大的优势在于，可以实现对子类覆写方法的控制。但是抽象类里可能保留一些普通方法，普通方法里可能涉及到安全或隐私的操作问题。

要对外部隐藏全部的实现细节，可以通过接口进行描述：
1. 接口需要被子类实现（implements），一个子类可以实现多个接口
2. 子类（如果不是抽象类）那么一定要覆写接口中的所有抽象方法
3. 接口对象可以利用子类对象的*向上转型*进行实例化
4. 接口中所有抽象方法的访问权限都为`public`
5. 一个普通类只能继承一个抽象类并且可以实现多个父接口，要求先继承后实现
6. `extends`在类继承上只能继承一个父类，但是接口可以继承多个

接口使用的三种形式
1. 进行标准设置
2. 表示一种操作的能力
3. 暴露远程方法视图，在RPC分布式开发中使用 

### 接口定义加强

```java
// 该操作属于挽救功能
interface IMessage {
  public String message();
  public default boolean connect(){
    return true;
  }
}
```

**使用接口定义标准**


### 工厂模式

> new 造成耦合，实例化接口时需要知道具体的子类

客户端程序类与接口子类没有直接关系，而是通过工厂类获得。工厂类根据参数，返回要使用的子类

### 代理模式

为核心接口代理，构造类里应该体现为哪个对象代理。

主要特点是：一个接口提供有两个子类，其中一个子类是真实业务操作类，另一个是代理业务操作类。

### 抽象类与接口的区别



## 包装类

- 对象型包装类（Object直接子类）：Boolean Character
- 数值型包装类 （Number直接子类）：Byte Short Integer Long Float

**Number**
```java
public byte byteValue()
public short shortValue()
public abstract int intValue()
public abstract long longValue()
public abstract float floatValue()
public abstract double doubleValue()
```

## 多态

> Thinking in Java 第八章

- 方法的多态性
  - 方法的重载：根据传入参数有不同的实现
  - 方法的覆写：根据使用子类的不同有不同的实现

- 对象的多态性
  - 对象向上转型：自动完成转换
  - 对象向下转型：强制完成转换

用`instanceof` 检查向下转型

## 访问控制权限


## 函数式编程

> JDK1.8


### lambda 表达式

实现要求：**SAM** *Single Abstract Method* 只有一个抽象方法 

```
@FunctionalInterface
```

格式：

- 方法没有参数 () -> {}
- 方法有参数 (参数, 参数) -> {}
- 只有一行语句返回 (参数, 参数) -> 语句

### 方法引用

JDK1.8之后提供方法的引用：即不同的方法名称可以描述同一个方法 

- 引用静态方法：类名称::static方法名称（要求是函数式接口，为一个方法定义多个名字）
- 引用某个实例对象的方法：实例化对象::普通方法
- 引用特定类型的方法：特定类::普通方法
- **引用构造方法**：类名称::new

### 内建函数式接口

提供有一个`java.util.function`的开发包，里面可以直接使用函数式接口

1. 功能性函数式接口 `apply`
2. 消费型函数式接口 `accept`：只能够进行数据的处理操作，而没有任何的返回
   - `System.out.println` 
3. 供给型函数式接口 `get`
4. 断言型函数式接口 `test`：进行判断处理
   - `String equalsIgnoreCase()` 

## 异常的捕获及处理

### Java异常处理流程

1. 在程序运行过程之中才会产生异常，一旦程序执行中产生了异常将自动进行指定类型的异常类对象实例化处理
2. 如果程序中没有异常处理支持，则采用JVM默认异常处理方式，首先进行异常信息的打印，而后直接退出当前程序
3. 如果程序中有异常处理支持，那么产生的异常类的实例化对象会被try语句捕获
4. try捕获到异常后，与其匹配的catch异常依次比对：如果有匹配，则使用对应catch代码进行处理；如果没有任何匹配，则该异常无法进行处理
5. 不管异常是否处理，最终都要执行finally语句，执行完finally语句后：如果异常处理过了，继续向后执行代码；如果没有处理，则交由JVM进行默认处理

- java.lang.Throwable
  - Error: 程序还未执行出现的错误
  - Exception: 程序中出现的异常，可以处理

默认的Exception应该放在最后(把捕获范围大的异常放在捕获范围小的之后)

### throws关键字

> 用于方法声明要抛出哪种疫情

### throw关键字

> 手工抛出异常

### 异常处理的标准格式

```java
public static throws Exception {
  try {

  } finally {

  }
}
```
### RuntimeException

**请解释RuntimeException与Exception的区别**
- `RuntimeException`是`Exception`的子类
- `RuntimeException`标注的异常可以不需要进行强制性处理，而`Exception`需要强制性处理

**常见RuntimeException**
- `NumberFormatException`

### 自定义异常

> 自定义一个RuntimeException

### assert断言

```bash
java -ea AssertionDemo
```

## 内部类

> 让Inner内部类可以访问Outer这个类的私有属性，不通过内部类实现的话，需要额外写很多引用的代码。

内部类可以在任意的结构中定义：类中、方法中、代码块中

### 内部类相关说明


```java
外部类.内部类 内部类对象 = new 外部类().new 内部类()
```

- 内部类编译完成之后，自动形成"Outer$Inner.class"类文件

- 接口内的内部抽象类

- 接口内部进行接口实现

### static定义内部类

> static定义内部接口

### 方法中定义内部类

> 1.8之前，方法中定义的内部类，要访问方法中的参数得加final


### 匿名内部类

> 内部类只想使用一次的时候

用途： 
- 在接口中直接定义匿名内部类