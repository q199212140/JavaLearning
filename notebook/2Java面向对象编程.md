



# 第1章：类与对象

## 面向对象简介

​	Java语言最大的特点在于面向对象的编程设计,而且面向对象的编程设计也在由于Java的发展不断的发展.很多当初不支持面向对象的编程也开始转向面向对象编程,但是依然有很多的开发者认为面向过程,或者函数式编程比较好.

​	最早并且一直到现在流行的编程语言c、c++、java、python。其中c已经编程了面向过程开发的语言。c++以及尤其产生的Java式面向对象的编程语言

c++受的IBM的启发

​	所谓面向过程是指的面对一个问题的解决方案，更多的情况下不会做出重用的思考；面向对象更多的方式为模块化设计，并且可以进行重用配置，在整个面向对象的设计里很多情况下考虑的是标准，在使用时根据标准进行拼装

###　面向对象有三个主要特征

* 封装性：内部的操作对外部而言不可见，当内部操作不可直接使用时才是安全的；
* 继承性：在已有结构的基础上，继续进行功能的扩充；
* 多态性：是在继承性基础上扩充而来的概念，指的是类型的转换处理。（一个范围内可以变化的处理形式）

### 面向对象的开发之中三个步骤：

* OOA：面向对象分析
* OOD：面向对象设计；
* OOP：面向对象编程；



## 类与对象的介绍

面向对象是一个非常庞大的话题，任何庞大话题都有核心组成：类与对象

​		类试对某一类事务共性的抽象概念，而对象描述的是一个具体的产物。例如：我与某一个先生比较的时候，可以立刻区分出我还有别人。

​		我和其他人都一样，都是一个个具体可以使用个个体产物，但是这些个体都有一些共性的标志，比如中国人，这是相同的，所谓的人和人之间的不同依靠的是我们各自的属性，每一个属性的集合构成了一个对象，但是所有的属性都应该是群体的定义，而群体的定义就形成了一个类。

![image-20200705123948660](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200705123948660.png)

类是一个模板，而对象才是类可以使用的实例。

招人，秘书：标准。标准有不同的实现。

标准就是类，不能直接用。标准的实现就是类，可以直接用

类之中一般有两个组成：

  * 成员属性（Field）：有些时候为了简化称为属性
    		* 一个人的年龄、姓名都是不同的，所以这些对于整体来讲称为属性；

* 操作方法（Method）：定义对象具有的处理型位：
  * 这个人可以唱歌、跳舞、游泳、运动；

类中有的方法才是对象可以使用的方法，类中有的属性才是对象可以操作和保存的属性。



## 类与对的定义和使用

在Java 之中类是一个独立的结构体，所以需要使用class来进行定义，而在类之中主要由属性和方法所组成，那么属性就是一个个具体的变量，方法就是可以重复执行的代码。

**定义一个类**

```java
class Person { 		//定义类
	String name;	//人员姓名
	int age;		//人员年龄
	public void tell() {
		System.out.println("姓名：" + name + "、年龄：" + age);
}
```

在这个类中定义两个属性和一个方法，有了类之后，如果想使用类，必须要用对象来使用。如果要产生对象，那么必须使用如下的语法格式来完成。

* 声明并实例化对象：

  > 类名称 对象名称 = new 类名称();

* 分步骤完成：

  * 声明对象：

    > 类名称 对象名称 = null;

  * 实例化对象：

    > 对象名称 = new 类名称();

当获取了**实例化对象**之后，那么就需要通过对象进行类中的操作调用，此时由两种调用方式。

* 调用类中的属性:实例化对象.成员对象:
* 调用类中的方法：实例化对象.方法名称();

范例：使用对象操作类

```java
class Person { 		//定义类
	String name;	//人员姓名
	int age;		//人员年龄
	public void tell() {
		System.out.println("姓名：" + name + "、年龄：" + age);
	}
}

public class JavaDemo {
	public static void main(String args[]) {
		Person per = new Person();	//声明并实例化对象
		per.name = "张三";
		per.age = 18;
		per.tell();			//方法的调用
	}

} 
```

> 姓名：张三、年龄：18

如果此时的程序并没有进行对象属性内容的设置,则该数据内容为其对应数据类型的默认值.

**所以定义接收类型要用包装类,否则会在未返回值时使用默认值造成错误**

```java
class Person { 		//定义类
	String name;	//人员姓名
	int age;		//人员年龄
	public void tell() {
		System.out.println("姓名：" + name + "、年龄：" + age);
	}
}

public class JavaDemo {
	public static void main(String args[]) {
		Person per = new Person();	//声明并实例化对象
		per.tell();			//方法的调用
	}

} 
```

> 姓名：null、年龄：0

String为引用类型,int为基本类型



## 对象实例化操作的初步分析

Java之中类属于引用数据类型,引用数据类型最大的困难在于要进行内存的管理,同时在进行操作的时候也会有内存关系的变化,本次针对之前的程序的内存关系进行简单的分析

范例: 以下面的程序进行分析

```java
class Person { 		//定义类
	String name;	//人员姓名
	int age;		//人员年龄
	public void tell() {
		System.out.println("姓名：" + name + "、年龄：" + age);
	}
}

public class JavaDemo {
	public static void main(String args[]) {
		Person per = new Person();	//声明并实例化对象
		per.name = "张三";
		per.age = 18;
		per.tell();
	}

} 
```

如果要进行内存分析,那么首先要给出两块最为常用的内存空间:

* 堆内存: 保存对象的具体信息,在程序中堆内存空间的开辟是通过new来完成的

* 栈内存: 保存的是一块堆内存的地址, 即通过地址找到堆内存,而后找到对象内容,但是为了分析简化方便,可以理解将对象的名称存到栈内存

  (对象的名称表示对象在堆内存的地址)

![image-20200705131134371](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200705131134371.png)

所有堆内存都有对应地址的编号. 堆之前的程序进行分析

* new是开辟内存的最高级别,无论何时必须开辟

![image-20200705131812294](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200705131812294.png)

对象的实例化有两种语法,上面表示的是声明并实例化 , 下面分布操作走.

```
Person per = null;  //声明对象
per = new Person();	//实例化对象
```

![image-20200705132137493](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200705132137493.png)

需要特别注意的是,所有的对象在调用类中的属性或方法时,必须要实例化之后才能使用或执行.

> 错误案例:
>
> ``` java
> 	public static void main(String args[]) {
> 		Person per = null;	//声明并实例化对象
> 		per.name = "张三";
> 		per.age = 18;
> 		per.tell();
> 	}
> } 
> ```

> Exception in thread "main" java.lang.NullPointerException
>         at JavaDemo.main(JavaDemo.java:12)

* 代码只声明,没有实例化,所以无法调用
* NullPointerException : 空指向异常,表示没有在对内存开辟后使用所产生的问题,并且只有引用数据类型有此问题.
* JavaDemo.java:12  表明错误产生的类以及行数



## 对象引用传递分析

类本身属于引用数据类型,既然时引用数据类型,那么就牵扯到内存的引用传递,所谓的引用传递的本质: 同一块堆内存空间可以被不同的栈内存所指向,也可以更改引用

```java
class Person { 		//定义类
	String name;	//人员姓名
	int age;		//人员年龄
	public void tell() {
		System.out.println("姓名：" + name + "、年龄：" + age);
	}
}

public class JavaDemo {
	public static void main(String args[]) {
		Person per1 = new Person();	//声明并实例化对象
		per1.name = "张三";
		per1.age = 18;
		Person per2 = per1;
		per2.age = 80;
		per1.tell();
	}

} 
```

> 姓名：张三、年龄：80

![image-20200705133500985](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200705133500985.png)



这个时候的引用传递时直接在主方法之中定义的,也可以通过方法实现引用传递处理

```java
class Person { 		//定义类
	String name;	//人员姓名
	int age;		//人员年龄
	public void tell() {
		System.out.println("姓名：" + name + "、年龄：" + age);
	}
}

public class JavaDemo {
	public static void main(String args[]) {
		Person per = new Person();	//声明并实例化对象
		per.name = "张三";
		per.age = 18;
		change(per);  //等价于: Person temp = per;
		per.tell();
	}

	public static void change(Person temp) {
		temp.age = 80;
	}
} 
```

> 姓名：张三、年龄：80

与之前的差别最大的地方在于,此时的程序是将Person类的实例化对象( 内存地址 , 数值!!!)传递到了change方法之中,由于传递 是一个Person类型,那么change()方法接收的也是一个Person类型.

![image-20200705134349629](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200705134349629.png)

引用传递可以发生在方法上,这个时候一定要观察方法的参数类型,同时也要观察方法的执行过程



## 引用传递与垃圾产生分析

经过一系列的分析之后已经确认,所有的引用传递的本质就是一场堆内存的调戏游戏. 但是对于引用传递,如果处理不当,也会造成垃圾的产生, 那么本次针对垃圾产生原因进行分析



```java
class Person { 		//定义类
	String name;	//人员姓名
	int age;		//人员年龄
	public void tell() {
		System.out.println("姓名：" + name + "、年龄：" + age);
	}
}

public class JavaDemo {
	public static void main(String args[]) {
		Person per1 = new Person();	//声明并实例化对象
		Person per2 = new Person();
		per1.name = "张三";
		per1.age = 18;
		per2.name = "李四";
		per2.age = 19;
		per2 = per1; 	//引用传递
		per2.age = 80;		
		per1.tell();		//进行方法的调用
	}

	public static void change(Person temp) {
		temp.age = 80;
	}
} 
```

> 姓名：张三、年龄：80

此处发生了引用传递,也完成了引用传递的处理操作,但是下面来观察一下其内存的分配与处理流程.一个栈内存之只能够保存有一个堆内存的地址数据,如果发生更改,则之前的地址数据就从此栈内存中彻底消失.

 ![image-20200705135323748](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200705135323748.png)

所谓的垃圾空间指的时没有任何栈内存所指向的堆内存空间,所有的垃圾将被GC(Garbage Conllector 垃圾收集器)不定期进行回收空间,但是如果垃圾过多,一定会影响到GC的处理性能,从而降低整体的程序性能,那么在实际的开发之中,对于垃圾的产生越少越好.



# 第2章：深入分析类与对象

## 成员属性封装处理

​		在类之中的组成就是属性和方法, 一般而言方法都是对外提供服务的,所以是不会进行封装处理的,而属性由于需要较高 的安全性,所以往往需要对其进行保护,这个时候就需要采用封装性对属性进行保护.

​		因为默认情况下,对于类中属性是可以用其他类使用对象进行调用的.



```java
class Person { 		//定义类
	String name;	//人员姓名
	int age;		//人员年龄
	public void tell() {
		System.out.println("姓名：" + name + "、年龄：" + age);
	}
}

public class JavaDemo { //主类
	public static void main(String args[]) {
		Person per1 = new Person();	//声明并实例化对象 
		per1.name = "张三";	//在类外部修改属性
		per1.age = -18;
		per1.tell();		//进行方法的调用
	}
} 
```

属性没有得到保护,进行封装处理,这样类外部可以直接进行修改,可能设置错误的数据. 如果想要解决就可以利用private关键字对属性进行封装处理

```java
class Person { 		//定义类
	private String name;	//人员姓名
	private int age;		//人员年龄
	public void tell() {
		System.out.println("姓名：" + name + "、年龄：" + age);
	}
}
```

> JavaDemo.java:12: 错误: name 在 Person 中是 private 访问控制
>                 per1.name = "张三";    //在类外部修改属性
>                     ^
> JavaDemo.java:13: 错误: age 在 Person 中是 private 访问控制
>                 per1.age = 18;     //在类外部修改属性
>                     ^
> 2 个错误

属性封装之后,外部不可直接访问.即对外部不可见,但是对类的内部可以访问封装的属性.则Java开发标准中提供有如下要求:

* 【setter、getter】设置或取得属性，可以使用setXxx()、getXxx()，以private String name为例
  * 设置属性方法：public void setName(String n);
  * 获取属性方法：public String getName()



```java
class Person { 		//定义类
	private String name;	//人员姓名
	private int age;		//人员年龄
	public void tell() {
		System.out.println("姓名：" + name + "、年龄：" + age);
	}

	public void setName(String n) {
		name = n;
	}
	public void setAge(int a) {
        if(a>=0) {
			age= a;
        }
	}

	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
}

public class JavaDemo { //主类
	public static void main(String args[]) {
		Person per1 = new Person();	//声明并实例化对象
		per1.setName( "张三" );
		per1.setAge(18);
        per1.tell();
	}
}
```

> 姓名：张三、年龄：18

以后任何类定义的时候一定要记住，类中的所有属性都

必须使用private封装（适用98%）。需要访问必须提供setter、getter方法



## 构造方法与匿名对象

现在的程序在使用类的时候一般按照如下步骤：

* 声明并实例化对象，这个时候实例化对象的属性没有任何数据，都是数据类型的默认值
* 需要通过一系列的setter方法为类中的属性设置内容

等于现在要想真正的获得一个可以正常使用的实例化对象，必须经过两个步骤才可以完成。

范例：传统调用

```java
class Person { 		//定义类
	private String name;	//人员姓名
	private int age;		//人员年龄
	public void tell() {
		System.out.println("姓名：" + name + "、年龄：" + age);
	}

	public void setName(String n) {
		name = n;
	}
	public void setAge(int a) {
		age= a;
	}

	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
}

public class JavaDemo { //主类
	public static void main(String args[]) {
		//1.对象的初始化准备
		Person per1 = new Person();	//声明并实例化对象
		per1.setName( "张三" );    //在类外部修改属性
		per1.setAge(18);     //在类外部修改属性
		//2.对象的使用
		per1.tell();
	}
}
```

如果按这样的方式来进行思考的话：假设现在的类中的属性很多个（8个），按照之前的做法，就需要调用8次setter方法进行设置，调用太罗嗦。

所以Java考虑到对象初始化的问题i，专门提供有构造方法，即：可以通过构造方法实现实例化对象中的属性初始化处理。只有在关键字new 的时候使用构造方法。

在java程序里构造方法的定义要求如下：

* 构造方法名称必须与类名称一致；
* 构造方法不允许设置任何的返回值类型，即没有返回值定义；
* 构造方法是使用关键字new 实例化对象的时候自动调用的。

范例：定义构造方法

```java
class Person { 		//定义类
	private String name;	//人员姓名
	private int age;	
	//方法名称与类名称相同，并且无返回值定义
	public Person (String n, int a) {	//定义有参构造
		name = n;	     //为类中属性赋值
		age = a;        //为类中属性赋值
	}
	//人员年龄
	public void tell() {
		System.out.println("姓名：" + name + "、年龄：" + age);
	}

}

public class JavaDemo { //主类
	public static void main(String args[]) {
		//1.对象的初始化准备
		Person per1 = new Person("张三",18);	//声明并实例化对象
		//2.对象的使用
		per1.tell();
	}
}
```

下面对于当前的对象实例化格式，与之前的对象实例化格式进行比较：

* 之前的实例化格式：①Person ②per = ③new ④Person();
* 当前的实例化格式：①Person ②per = ③new ④Person("张三",18);
  * ①Person：定义对象的所属类型，类型决定了你可以调用的方法；
  * ②per ：实例化对象的名称，所有的操作通过对象来进行访问
  * ③new：开辟一块新的堆内存空间；
  * ④Person("张三",18)：调用有参构造；④Person();调用无参构造。

* 为了Java程序的完整性，所有的类都会提供有构造方法，也就是如果现在类中如果美欧定义任何的构造方法，就自动生成一个什么都不做的构造方法，这个构造方法试在程序编译的时候自动创建的。如果已经在类中明确的定义了构造方法，那么编译时不会自动生成默认的构造方法

  * 如果拿class反编译，会看到代码里有无参构造方法

  * 如果定义了有参构造方法，但调用了无参构造方法

    ```java
    public class JavaDemo { //主类
    	public static void main(String args[]) {
    		//1.对象的初始化准备
    		Person per1 = new Person();	//声明并实例化对象
    		//2.对象的使用
    		per1.tell();
    	}
    }
    ```

    > JavaDemo.java:19: 错误: 无法将类 Person中的构 造器 Person应用到给定类型;
    >                 Person per1 = new Person();
    > //声明并实例化对象
    >                               ^
    >   需要: String,int
    >   找到:    没有参数
    >   原因: 实际参数列表和形式参数列表长度不同
    > 1 个错误

结论：一个类至少存在有一个构造方法，永恒存在。

> 疑问：为什么构造方法上不允许设置返回值类型？
>
> * 既然构造方法是一个方法，为什么不让它自定义返回值类型呢？
>
> * 既然构造方法不会返回数据，为什么不使用void
>
>   * public Person (String n, int a) {}
>   * public void Person (String n, int a) {} ×
>
>   分析： 程序编译器是根据代码结构来进行编译处理的，执行的时候也是根据代码结构来处理的。
>
>   **如果在构造方法上使用了void，那么此结构就与普通方法完全相同了，这样编译器会认为次方法是一个普通方法，而普通方法和构造方法最大的区别，是构造方法在类对象实例化的时候调用，普通方法是类对象实例化产生之后调用。**

既然构造方法本身就是一个方法，那么方法就具有重载的特点，而构造方法重载时只需要考虑参数的类型和个数即可

```java
class Person { 		//定义类
	private String name;	//人员姓名
	private int age;
	public Person () { 
		name = "无名";
		age = 100;
	}
	
	public Person (String n) {	//定义有参构造
		name = n;	     //为类中属性赋值
	}
	//方法名称与类名称相同，并且无返回值定义
	public Person (String n, int a) {	//定义有参构造
		name = n;	     //为类中属性赋值
		age = a;        //为类中属性赋值
	}
	//人员年龄
	public void tell() {
		System.out.println("姓名：" + name + "、年龄：" + age);
	}

}

public class JavaDemo { //主类
	public static void main(String args[]) {
		//1.对象的初始化准备
		Person per1 = new Person();	//声明并实例化对象
		//2.对象的使用
		per1.tell();
	}
}
```

> 姓名：无名、年龄：100

在进行多个构造方法定义的时候强烈建议有一定的定义顺序，例如：按参数个数降序/升序 排列

构造方法的确可以设置数据，而setter也可以设置数据。构造方法在对象实例化时为属性设置初始化内容，而setter除了设置数据功能外，还具有修改数据的功能。

范例：使用setter修改数据

```java
class Person { 		//定义类
	private String name;	//人员姓名
	private int age;
	public Person () { 
		name = "无名";
		age = 100;
	}
	
	public Person (String n) {	//定义有参构造
		name = n;	     //为类中属性赋值
	}
	//方法名称与类名称相同，并且无返回值定义
	public Person (String n, int a) {	//定义有参构造
		name = n;	     //为类中属性赋值
		age = a;        //为类中属性赋值
	}
	//人员年龄
	public void tell() {
		System.out.println("姓名：" + name + "、年龄：" + age);
	}

	public void setName(String n) {
		name = n;
	}
	public void setAge(int a) {
		age= a;
	}

	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}


}

public class JavaDemo { //主类
	public static void main(String args[]) {
		//1.对象的初始化准备
		Person per1 = new Person("张三",18);	//声明并实例化对象
		per1.setAge(20);
		//2.对象的使用
		per1.tell();
	}
}
```

> 姓名：张三、年龄：20



经过分析后发现，利用构造方法可以传递属性数据，于是进一步分析对象的产生格式。

* 定义对象的名称： 类名称  对象名称 = null;
* 实例化对象：       对象名称 = new  类名称();

### 匿名对象

**如果这个时候只是通过实例化操作来进行类操作也是可以的，而这种形式的对象由于没有名字，所以称为匿名对象**

```java
public class JavaDemo { //主类
	public static void main(String args[]) {
		new Person("张三",18).tell();//方法调用
	}
}
```

此时依然通过了对象进行了类中tell()方法的调用，但是由于此对象没有任何的引用，所以执行一次过后就将称为垃圾，而所有的垃圾将被gc进行回收与释放。

现在发现程序里已经有构造方法，下面通过一个程序对匿名类进行分析。

```java
class Message {
	private String title;
	public Message(String t) {
		title = t;		
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String t) {  //具有修改功能
		title = t;	
	}
}

class Person { 		//定义类
	private String name;	//人员姓名
	private int age;
	public Person () { 
		name = "无名";
		age = 100;
	}
	public Person (String n) {	//定义有参构造
		name = n;	     //为类中属性赋值
	}
	public Person (Message msg, int a) {	//定义有参构造
		name = msg.getTitle();	     //为类中属性赋值
		age = a;        //为类中属性赋值
	}

	public Message getInfo() {
		return new Message(name + ":" + age);
	}
	public void tell() {
		System.out.println("姓名：" + name + "、年龄：" + age);
	}

	public void setName(String n) {
		name = n;
	}
	public void setAge(int a) {
		age= a;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
}

public class JavaDemo { //主类
	public static void main(String args[]) {
		Message msg = new Message("mldn");
		Person per = new Person(msg,20);
		msg = per.getInfo();
		System.out.println(msg.getTitle());
	}
}
```

> mldn:20

进行内存分析

![image-20200705163800480](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200705163800480.png)

只要是方法都可以传递任意数据类型（基本类型、引用类型）



# 第3章：this关键字

## this调用本类属性

this可以算是java里面比较复杂的关键字，因为this的使用形式上决定了它的灵活性。

可以实现三类结构的描述：

* 当前类中的属性：this.属性
* 当前类的方法（普通方法，构造方法）：this()、this.方法名称();
* 描述当前对象；

### 使用this调用当前类中属性

通过现在的分析可以发现，利用构造方法或者时setter方法都可以进行类中属性赋值。之前采用如下的定义形式

```java
class Person { 		//定义类
	private String name;	//人员姓名
	private int age;

	//方法名称与类名称相同，并且无返回值定义
	public Person (String n, int a) {	//定义有参构造
		name = n;	     //为类中属性赋值
		age = a;        //为类中属性赋值
	}

	public Message getInfo() {
		return new Message(name + ":" + age);
	}
	public void tell() {
		System.out.println("姓名：" + name + "、年龄：" + age);
	}

}

public class JavaDemo { //主类
	public static void main(String args[]) {
		Person per = new Person("张三",20);
		per.tell();
	}
}
```

但是在构造方法定义的过程之中会有一点点问题。

```java
	public Person (String n, int a) {	//定义有参构造
		name = n;	     //为类中属性赋值
		age = a;        //为类中属性赋值
	}
```

这个问题i出现在参数名称上，可以发现，此时构造方法中的两个参数目的是为了类中的name age属性初始化，但是此时代码n和a名称不好。 

最好取成一致的名字，则无法进行正常设置

```java
	private String name;	//人员姓名
	private int age;

	public Person (String name, int age) {	//定义有参构造
		name = name;	     //为类中属性赋值
		age = age;        //为类中属性赋值
	}

```

在Java之中{} 是结构体的边界符号，在程序中进行变量使用（参数、属性都成为变量）时，以{}作为一个查找边界；按照就近取用的原则，此时的构造方法并没有能够访问类中的属性，所以此时为了明确的标记出类中的属性与参数的区别，在类中的属性前加上this.

因为构造方法中有name和age参数，所以不会去{}外面找到Person类的属性name age。

```java
class Person { 		//定义类
	private String name;	//人员姓名
	private int age;

	//方法名称与类名称相同，并且无返回值定义
	public Person (String name, int age) {	//定义有参构造
		this.name = name ;	     //为类中属性赋值
		this.age = age ;        //为类中属性赋值
	}

	public void tell() {
		System.out.println("姓名：" + this.name + "、年龄：" + this.age);
	}
}

public class JavaDemo { //主类
	public static void main(String args[]) {
		Person per = new Person("张三",20);
		per.tell();
	}
}
```

在以后程序开发的代码里，只要访问本类中属性的时候，一定要加上**this.属性名**



## this调用本类方法

除了调用属性，也可以实现方法的调用，但是对于方法的调用就必须考虑构造方法和普通方法。

* 构造方法调用（this()）：new实例化时候调用
* 普通方法调用（this.方法名称()）：实例化之后调用普通方法

范例：调用普通方法

```java
class Person { 		//定义类
	private String name;	//人员姓名
	private int age;

	//方法名称与类名称相同，并且无返回值定义
	public Person (String name, int age) {
		this.setName = name ;
		setAge(age) ;      //加与不加都表示本类方法
    }

	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int a) {
		this.age= age;
	}
	public String getName() {
		return this.name;
	}
	public int getAge() {
		return this.age;
	}

	public void tell() {
		System.out.println("姓名：" + this.name + "、年龄：" + this.age);
	}

}

public class JavaDemo { //主类
	public static void main(String args[]) {
		Person per = new Person("张三",20);
		per.tell();
	}
}
```

> 		this.setName = name ;
> 		setAge(age) ;

除了普通方法的调用，还需要进行构造方法的调用，肯定是要放在构造方法中执行。如果类中一共有三个构造方法，如果不管调用哪个构造方法都输出一句“一个新的Person类对象实例化了”

```java
class Person { 		//定义类
	private String name;	//人员姓名
	private int age;

	public Person () {
		System.out.println("一个新的Person类对象实例化了");
	}
	public Person (String name) {
		System.out.println("一个新的Person类对象实例化了");
		this.name= name ;
	}
	public Person (String name, int age) {
		System.out.println("一个新的Person类对象实例化了");
		this.name= name ;
		this.age = age ;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int a) {
		this.age= age;
	}
	public String getName() {
		return this.name;
	}
	public int getAge() {
		return this.age;
	}

	public void tell() {
		System.out.println("姓名：" + this.name + "、年龄：" + this.age);
	}

}

public class JavaDemo { //主类
	public static void main(String args[]) {
		Person per = new Person("张三",20);
		per.tell();
	}
}
```

> 一个新的Person类对象实例化了
> 姓名：张三、年龄：20

效果实现了，但是代码不优美

想要评价一个代码的好坏：

* 代码结构可以重用，提供的是一个中间独立的支持
* 我们的目标是：没有重复代码

**利用this构造调用优化**

```java
class Person { 		//定义类
	private String name;	//人员姓名
	private int age;

	public Person () {
		System.out.println("一个新的Person类对象实例化了");
	}
	public Person (String name) {
		this();  //调用本类无参
		this.name= name ;
	}
	public Person (String name, int age) {
		this(name);   //调用本类单参
		this.age = age ;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int a) {
		this.age= age;
	}
	public String getName() {
		return this.name;
	}
	public int getAge() {
		return this.age;
	}

	public void tell() {
		System.out.println("姓名：" + this.name + "、年龄：" + this.age);
	}
}

public class JavaDemo { //主类
	public static void main(String args[]) {
		Person per = new Person("张三",20);
		per.tell();
	}
}
```

对于本类构造方法的互相调用注意以下几点问题：

* 构造方法必须在实例化新对象的时候调用，所以“this()”的语句只允许在构造方法的首行！！

  ```java
  	public Person (String name) {
  		this.name= name ;
  		this();  //调用本类无参
  	}
  ```

  > JavaDemo.java:10: 错误: 对this的调用必须是构造器中的第一个语句
  >                 this();  //调用本类无参
  >                     ^
  > 1 个错误

* 普通方法中不允许调用构造方法

* 构造方法互相调用时请保留有程序的出口，别形成死循环

  ```java
  	public Person () {
  		this(name);
  		System.out.println("一个新的Person类对象实例化了");
  	}
  	public Person (String name) {
  		this(); 
  		this.name= name ;
  	}
  ```

  > JavaDemo.java:6: 错误: 无法在调用超类型构造器 之前引用name
  >                 this(name);
  >                      ^
  > JavaDemo.java:9: 错误: 递归构造器调用
  >         public Person (String name) {
  >                ^
  > 2 个错误

  

构造方法互相调用的案例：

定义一个描述员工信息的程序类，提供：编号、姓名、部门、工资

* 【无参构造】编号定义1000，姓名定义为无名氏；
* 【单参构造】传递编号，姓名定义为“新员工”，部门定义为“未定”，工资为0；
* 【三参构造】传递编号、姓名、部门，工资为2500.00；
* 【四参构造】所有的属性全部进行传递。

范例：代码初期实现

```java
class Emp{ 		//定义类
	private long empno;    //员工编号
	private String ename;    //员工姓名
	private String dept;   //部门名称
	private double salary;    //基本工资

	public Emp() {
		this.empno = 1000;
		this.ename = "无名氏";
	}

	public Emp(long empno) {
		this.empno = empno;
		this.ename = "新员工";
		this.dept = "未定";
	}

	public Emp(long empno, String ename, String dept) {
		this.empno = empno;
		this.ename = ename;
		this.dept = dept;
	}

	public Emp(long empno, String ename, String dept,double salary) {
		this.empno = empno;
		this.ename = ename;
		this.dept = dept;
		this.salary = salary;
	}

	public String getInfo() {
		return  "雇员编号：" + this.empno + "、雇员姓名：" + this.ename + "、所在部门：" + this.dept + "、基本工资：" + this.salary;
	}
}

public class JavaDemo { //主类
	public static void main(String args[]) {
		Emp emp = new Emp(7369L,"史密斯","财务部",6500.00);
		System.out.println(emp.getInfo());
	}
}
```

> 雇员编号：7369、雇员姓名：史密斯、所在部门：财务部、基本工资：6500.0

缺点，有太多重复代码

可以对Emp类进行简化

```java
class Emp{ 		//定义类
	private long empno;    //员工编号
	private String ename;    //员工姓名
	private String dept;   //部门名称
	private double salary;    //基本工资

	public Emp() {
		this(1000,"无名氏",null,0.0);
	}
	public Emp(long empno) {
		this(empno,"新员工","未定",0.0);
	}
	public Emp(long empno, String ename, String dept) {
		this(empno, ename,dept,2500.00);		}
	public Emp(long empno, String ename, String dept,double salary) {
		this.empno = empno;
		this.ename = ename;
		this.dept = dept;
		this.salary = salary;
	}

	public String getInfo() {
		return  "雇员编号：" + this.empno + "、雇员姓名：" + this.ename + "、所在部门：" + this.dept + "、基本工资：" + this.salary;
	}
}

public class JavaDemo { //主类
	public static void main(String args[]) {
		Emp emp = new Emp(7369L,"史密斯","财务部",6500.00);
		System.out.println(emp.getInfo());
	}
}
```

依靠构造方法实现了优化，先期学习要考虑消除代码重复



## 综合实践：简单java类

在以后进行项目的开发和设计之中，简单java类都将作为一个重要的组合部分存在。简单java类无处不在，并且可能会产生一系列的变化。

所谓的简单java类指的是可以描述某一类信息的程序类，例如：描述一个人、描述一本书，并且在这个类之中并没有特别复杂的逻辑操作，只作为一种信息存储的媒介存在。

​		对于简单Java类而言，其核心的开发结构如下：

* 类名称一定要有名义，可以明确的描述某一类食物；
* 类之中的所有属性都必须使用private封装，同时封装后的属性必须提供有setter getter方法
* 类之中可以提供有无数多个构造方法，但是必须要保留无参构造方法；
* 类之中不允许出现任何的输出语句，所有内容的获取必须返回；
* 【非必需】可以提供一个获取对象详细信息的方法，暂时将此方法名称定义为getInfo();

```java
class Dept{ 		//类名称可以明确描述出某类食物
	private long deptno;   
	private String dname; 
	private String loc;   

	public Dept() { }	//必须提供无参
	public Dept ( long deptno, String dname,String loc) { 
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}

	public String getInfo() {
		return  "【部门信息】部门编号：" + this.deptno + "、部门名称：" + this.dname + "、部门位置：" + this.loc;
	}

	public void setDeptno(Long deptno) {
		this.deptno = deptno;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public long getDeptno() {
		return this.deptno;
	}
	public String getDname() {
		return this.dname;
	}
	public String getLoc() {
		return this.loc;
	}
}

public class JavaDemo { //主类
	public static void main(String args[]) {
		Dept dept = new Dept(10,"技术部","北京");
		System.out.println(dept.getInfo());
	}
}
```

> 【部门信息】部门编号：10、部门名称：技术部、部门位置：北京

 这种简单Java类融合了现在接触的概念。



# 第4章：static关键字

static是一个关键字，这个关键字主要可以哦那个来定义属性和方法，下面该将针对于此关键字的使用进行分析。

## static定义属性

在一个类之中，所有的属性一旦定义了，实际上内容都交由堆内存空间所保存

范例：定义一个程序类

```java
class Person{ 
	private String name;   
	private int age; 
	String country = "中华民国";   //暂时不封装   	
	
	public Person (String name,int age) {
		this.name = name;
		this.age = age;
	}

	//getter setter略
	public String getInfo() {
	return "姓名：" + this.name + "、年龄：" + this.age + "、国家：" + this.country;
	}
}

public class JavaDemo { 
	public static void main(String args[]) {
		Person perA = new Person("张三",10);
		Person perB = new Person("李四",10);
		Person perC = new Person("王五",11);
		System.out.println(perA.getInfo());
		System.out.println(perB.getInfo());
		System.out.println(perC.getInfo());
	}
}
```

> 姓名：张三、年龄：10、国家：中华民国
> 姓名：李四、年龄：10、国家：中华民国
> 姓名：王五、年龄：11、国家：中华民国

观察传统操作的问题。

对**String country = "中华民国"; **进行内存分析

![image-20200705211115105](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200705211115105.png)

在正常开发过程之中，每个对象保存各自的属性，所以此时没有问题。如果有一个时刻，国家变成了“中华人民共和国”，此时已有了5000w个对象，那么此时会面临一个噩梦。

```
public class JavaDemo { 
	public static void main(String args[]) {
		Person perA = new Person("张三",10);
		Person perB = new Person("李四",10);
		Person perC = new Person("王五",11);
		perA.country = "中华人民共和国";
		System.out.println(perA.getInfo());
		System.out.println(perB.getInfo());
		System.out.println(perC.getInfo());
	}
}
```

只有一个变了，每个对象拥有各自的country属性

> 姓名：张三、年龄：10、国家：中华人民共和国
> 姓名：李四、年龄：10、国家：中华民国
> 姓名：王五、年龄：11、国家：中华民国

Q:发现问题

* 重复保存数据
* 修改不方便

传统开发，没有公共概念，最好的解决方案，使用country为公共属性。修改Person类定义，使用static定义公共属性。

> 姓名：张三、年龄：10、国家：中华人民共和国
> 姓名：李四、年龄：10、国家：中华人民共和国
> 姓名：王五、年龄：11、国家：中华人民共和国

**一个对象修改属性后，所有的都跟着更改**

此时的内存关系图如下

![image-20200705211846069](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200705211846069.png)

但是对static属性的访问需要注意一点：由于其本身是一个公共属性，虽然可以通过对象进行访问，但是最好的方法时通过所有对象的最高代表（类）来进行访问，所以**static属性可以由类名称直接调用**。

```
Person.country = "中华人民共和国";
```

static属性虽然定义在类之中，但是其并不受到类实例化对象的控制。static属性可以在没有实例化对象的时候使用。

范例：在没有实例化时调用static属性

```java
class Person{ 
	private String name;   
	private int age; 
	static String country = "中国";   //暂时不封装   	
	
	public Person (String name,int age) {
		this.name = name;
		this.age = age;
	}

	//getter setter略
	public String getInfo() {
	return "姓名：" + this.name + "、年龄：" + this.age + "、国家：" + this.country;
	}
}

public class JavaDemo { 
	public static void main(String args[]) {
		System.out.println(Person.country);
		Person.country = "中华人民共和国";
		Person per = new Person("张三",10);
		System.out.println(per.getInfo());
	}
}
```

> 中国
> 姓名：张三、年龄：10、国家：中华人民共和国

在以后进行类设计时候，首选的一定是非static属性（95%），而考虑到公共信息存储的时候才会使用到static属性。非static属性必须在实例化对象产生之后使用，static属性可以在没有实例化对象产生时用类调用。



## 声明static方法

static关键字也可以进行方法的定义，static方法的主要特点在于，其可以直接由类名称，在没有实例化对象的情况下进行调用。

```java
class Person{ 
	private String name;   
	private int age; 
	private static String country = "中国";
	
	public Person (String name,int age) {
		this.name = name;
		this.age = age;
	}

	public static void setCountry(String c) {
		country = c;
	}

	public static String getCountry() {
		return country;
	}
	//getter setter略
	public String getInfo() {
	return "姓名：" + this.name + "、年龄：" + this.age + "、国家：" + this.country;
	}
}

public class JavaDemo { 
	public static void main(String args[]) {
		System.out.println(Person.getCountry());
		Person.setCountry( "中华人民共和国");
		Person per = new Person("张三",10);
		System.out.println(per.getInfo());
	}
}
```

> 中国
> 姓名：张三、年龄：10、国家：中华人民共和国

这个时候程序而言，有两个方法：static方法，非static方法；

* static方法只允许调用static属性或者static方法

  >JavaDemo.java:12: 错误: 无法从静态上下文中引用非静态 变量 this
  >                this.name = c;
  >                ^
  >1 个错误

* 非static方法允许调用static属性或者static方法

所有的static定义的属性和方法都可以在没有实例化对象的前提下使用，而所有非static定义的属性和static属性和方法必须在实例化对象之后才可以使用。

得到新的结论：最早讲解方法定义强调过，当前定义的方法都是在主类中定义的，并且由主方法调用。

调用static

```java
public class JavaDemo { 
	public static void main(String args[]) {
		print();
	}
	
	public static void print() {
		System.out.println("中国");
	}
```

调用非static

```java
public class JavaDemo { 
	public static void main(String args[]) {
		new JavaDemo().print();
	}
	
	public void print() {
		System.out.println("中国");
	}
```

static定义的方法或者属性都不是代码编写之初需要考虑的内容，只有在回避实例化对象调用并且描述公共属性的情况下才会使用static定义的方法或者属性。



## static应用案例

为了加强理解，下面坐两个简单的程序来进行static应用的提示。

范例：编写一个程序类，可以实现实例化对象个数的统计，每次创建新的实例化对象都可以实现一个统计操作。

* 单独创建一个static属性，在构造方法中实现数据的统计

```java
class Book{
	private String title;
	private static int count = 0;
	public Book(String title) {
		this.title = title;
		count ++ ;
		System.out.println("第" + count + "本新的图书创建出来。");
	} 
}

public class JavaDemo { 
	public static void main(String args[]) {
	new Book("java");
	new Book("JSP");
	new Book("Spring");
	}
}
```

> 第1本新的图书创建出来。
> 第2本新的图书创建出来。
> 第3本新的图书创建出来。

范例：实现属性的自动命名处理

* 如果现在传递了title属性，就是用传递的属性内容，如果没有传递title属性，则自动采用“NOTITLE-编号”的形式进行该属性内容的定义。

```java
class Book{
	private String title;
	private static int count = 0;
	public Book() { }
	public Book(String title) {
		this.title = title;
		count ++ ;
		System.out.println("第" + count + "本新的图书创建出来。");
	} 
	public String getTitle() {
		return this.title;
	}
	
}

public class JavaDemo { 
	public static void main(String args[]) {
		System.out.println(new Book("java").getTitle());
		System.out.println(new Book("JSP").getTitle());
		System.out.println(new Book("Spring").getTitle());
	}
}
```

> 第1本新的图书创建出来。
> java
> 第2本新的图书创建出来。
> JSP
> 第3本新的图书创建出来。
> Spring



修改无参构造

```java
class Book{
	private String title;
	private static int count = 0;
	public Book() { 
		this("NOTITLE - " + (count++));
	}
	public Book(String title) {
		this.title = title;
		count ++ ;
	} 
	public String getTitle() {
		return this.title;
	}
	
}

public class JavaDemo { 
	public static void main(String args[]) {
		System.out.println(new Book("java").getTitle());
		System.out.println(new Book("JSP").getTitle());
		System.out.println(new Book("Spring").getTitle());
		System.out.println(new Book().getTitle());
	}
}
```

> java
> JSP
> Spring
> NOTITLE - 3

避免没设置title属性时title为空导致重复的问题



# 第5章：代码块

在程序之中，使用{}定义的结构就叫代码块，根据代码块出现的位置及定义，分为了普通代码块、构造块、静态块、同步代码块，其中同步代码块是在多线程的时候才会用的

## 普通代码块

定义在一个方法中的代码块。

范例：

```java
public class JavaDemo { 
	public static void main(String args[]) {
		if(true) {
			int x = 10;   //局部变量
			System.out.println("x = " + x );
		}
		int x = 100;   //全局变量
		System.out.println("x = " + x );
	}
}
```

按照Java程序规定，相同名称的变量不能够在同一个方法之中存在的，但是由于此时有不同的分界描述。

> x = 10
> x = 100

局部和全局变量只是相对的，范围比较大的叫全局。

如果定义普通代码块，就把上面的if判断去掉就可

```java
public class JavaDemo { 
	public static void main(String args[]) {
		{
			int x = 10;   //局部变量
			System.out.println("x = " + x );
		}
		int x = 100;   //全局变量
		System.out.println("x = " + x );
	}
}
```

可以在一个方法之中进行一些结构的拆分，以避免相同名称的变量带来的相互影响



## 构造代码块

构造代码块是定义在一个类之中的

```java
class Person {
	public Person() {
		System.out.println("【构造方法】Person类的构造方法执行");
	}

	{
		System.out.println("【构造块】Person构造块执行");
	}
}

public class JavaDemo { 
	public static void main(String args[]) {
		new Person();
		new Person();
		new Person();
	}
}
```

> 【构造块】Person构造块执行
> 【构造方法】Person类的构造方法执行
> 【构造块】Person构造块执行
> 【构造方法】Person类的构造方法执行
> 【构造块】Person构造块执行
> 【构造方法】Person类的构造方法执行

构造块会优先于构造方法执行，并且每一次实例化新对象时都会调用构造块的代码

## 静态代码块

静态代码块主要指的是用static定义的代码块，需要考虑两种，主类中定义的，或非主类的。

### 非主类进行静态块定义

范例

```java
class Person {
	public Person() {
		System.out.println("【构造方法】Person类的构造方法执行");
	}

	static {
		System.out.println("【静态块】静态块执行");
	}
	{
		System.out.println("【构造块】Person构造块执行");
	}
}

public class JavaDemo { 
	public static void main(String args[]) {
		new Person();
		new Person();
		new Person();
	}
}
```

> 【静态块】静态块执行
> 【构造块】Person构造块执行
> 【构造方法】Person类的构造方法执行
> 【构造块】Person构造块执行
> 【构造方法】Person类的构造方法执行
> 【构造块】Person构造块执行
> 【构造方法】Person类的构造方法执行

此时发现静态代码块优先于构造块执行。且不论多少个实例化对象，都执行一次。主要目的时为了类中的静态属性初始化



范例：观察静态属性初始化

```java
class Message {
	public static String getCountry() {
		//该消息内容可能来自于网络或其他服务器
		return "中华人民共和国";
	}
}


class Person {
	private static String country;

	static {
		country = Message.getCountry();
		System.out.println(country);
	}
}

public class JavaDemo { 
	public static void main(String args[]) {
		new Person();
		new Person();
		new Person();
	}
}
```

> 中华人民共和国

改成以下也可，在static需执行语句多时不方便

```java
class Person {
	private static String country = Message.getCountry();

	static {
		//可能有很多其他语句要执行
		System.out.println(country);
	}
}
```

对于静态代码块还需要考虑，在主类中定义的形式

### 主类定义静态代码块

```java
public class JavaDemo { 

	static {
		System.out.println("*******");
	}

	public static void main(String args[]) {
		System.out.println("程序初始化");
	}
}

//*******
//程序初始化
```

可以发现静态代码块在主程序前执行。

在jdk1.7以前，会程序从静态代码开始执行。后续修复了bug，只是为主程序提供初始化数据



# 第6章：面向对象案例分析

初期最可靠最简单

## 案例一：Address

![image-20200708003341826](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200708003341826.png)

```java
class Address {
	private String country;
	private String province;
	private String city;
	private String street;
	private String zipcode;

	public Address() {}
	public Address(String country, String province, String city, String street, String zipcode) {
        this.country = country;
        this.province = province;
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }

	public String getInfo() {
		return "国家：" + this.country + " 省份：" + this.province + " 城市：" + this.city + " 街道：" + this.street + " 邮编：" + this.zipcode; 
	}
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}

public class JavaDemo { 
	public static void main(String args[]) {
		System.out.println(new Address("中华人民共和国","四川","成都","春熙路","610000").getInfo());
	}
}
```

> 国家：中华人民共和国 省份：四川 城市：成都 街道：春熙路 邮编：610000



## 案例二：employee

定义并测试一个代表员工的Employee类，员工属性包括”括号“，”姓名“，”基本薪水“，”薪水增长率“，还包括计算薪水增长额及计算增长后的工资总额的操作方法。

这个程序超过简单Java类的定义范畴，简单Java类不应该设计计算过程，但是可以从简单类出发

```java
class Employee {

    private long empno;
    private String ename;
    private double salary;
    private double rate;

    public Employee() {
    }

    public Employee(long empno, String ename, double salary, double rate) {
        this.empno = empno;
        this.ename = ename;
        this.salary = salary;
        this.rate = rate;
    }

	public double salaryIncValue() {//得到增长额度
		return this.salary*this.rate;
	}

	public double salaryIncResult() {
		this.salary = this.salary * (1 + this.rate);
		return this.salary;
	}

    public long getEmpno() {
        return empno;
    }

    public void setEmpno(long empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getInfo() {
        return "雇员编号：" + this.empno + " 雇员姓名：" + this.ename + " 基本薪水：" + this.salary + " 薪水增长率:" + this.rate;
    }
}

public class JavaDemo { 
	public static void main(String args[]) {
		Employee emp = new Employee(7369L,"大头",3000.0,0.3);		
		System.out.println(emp.getInfo());
		System.out.println("工资调整额度：" + emp.salaryIncValue());
		System.out.println("上调后的工资：" + emp.salaryIncResult());
		System.out.println(emp.getInfo());
	}
}
```

> 雇员编号：7369 雇员姓名：大头 基本薪水：3000.0 薪水增长率:0.3
> 工资调整额度：900.0
> 上调后的工资：3900.0
> 雇员编号：7369 雇员姓名：大头 基本薪水：3900.0 薪水增长率:0.3



## 案例三：Dog

设计一个Dog类，有名字、颜色、年龄等属性，定义构造方法来初始化类的这些属性，定义方法，输出Dog信息



## 案例四：Account

![image-20200708010753167](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200708010753167.png)

![image-20200708010831341](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200708010831341.png)

![image-20200708010903954](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200708010903954.png)



## 案例五：User

设计一个表示用户的User类，类中的变量有用户名、口令和记录用户个数的变量，定义类的三个构造方法（无参，为用户名赋值，为用户名和口令赋值）、获取和设置口令的方法和返回类信息的方法。

在简单java类追加static统计操作

![image-20200708011228353](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200708011228353.png)

![image-20200708011315573](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200708011315573.png)

![image-20200708011346618](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200708011346618.png)



## 案例六：Book

声明一个图书类，其数据成员为谁能够、编号（利用静态变量实现自动编号）、书价，并拥有静态数据成员册数，记录图书的总册数，在构造方法中利用此静态变量为对象的编号赋值，在主方法中定义多个对象，并求出总册数。

![image-20200708011828601](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200708011828601.png)

![image-20200708011802615](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200708011802615.png)

在面向对象最基础的开发里面，简单java类是解决先期设计的最好方案。



# 第7章：数组的定义与使用

所有的项目开发里一定存在数组的使用，本次讲解的只是数组的基本概念，而基本形式的数组在开发中用到的不多，并且也不会设计到过多复杂的操作。



## 数组的基本概念

如果定义100个整型变量，传统做法的实现

> int i1,i2,i3,i4, ... ,i100;

如果该组变量互相关联，则不适合维护，没参考规律。所有考虑一组变量的整体维护，所有引入了数组。

需要注意，Java中将数组定义为引用数据类型，所以涉及到内存分配，所以想到要用new关键字处理。

### 数组的定义格式

* 数组的动态初始化，初始化后，数组内的每个元素为其数据类型的默认值
  * 声明并初始化数组：
    * 数据类型 数组名称[] = new 数据类型[长度];
    * 数据类型[] 数组名称 = new 数据类型[长度];

* 数组的静态初始化：在数组定义的时候就为其设置好了里面的内容：
  * 简化格式：数据类型[] 数组名称 = {数据1,数据2,....};
  * 完整格式：数据类型[] 数组名称 = new 数据类型[] {数据1,数据2,....};    (使所需数组指向创建的匿名数组)

当创建了数组后，可以用以下使用。

* 使用脚标进行每一个元素的访问，从0开始，范围0~size-1

  * 如果超过脚标范围，执行时会报异常

    > E:\software\javadev\Java\jdk-14.0.1\bin>javac JavaDemo.java
    >
    > E:\software\javadev\Java\jdk-14.0.1\bin>java JavaDemo
    > 0
    > 0
    > Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3
    >         at JavaDemo.main(JavaDemo.java:7)

* 进行数组操作往往会用for循环来完成

  ![image-20200708013715072](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200708013715072.png)

* 也可以使用数组名.length属性进行获得

  ![image-20200708013830927](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200708013830927.png)

范例：定义数组

```java
public class JavaDemo { 
	public static void main(String args[]) {
		//使用数组的动态初始化
		int data[] = new int[3];
		System.out.println(data[0]);
		System.out.println(data[1]);
		System.out.println(data[2]);
	}
}
```

> 0
> 0
> 0



以后的开发过程，见到最多的使用形式，就是对数组进行循环处理。

静态初始化，希望数组生成时就已经有值。

![image-20200708014021092](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200708014021092.png)



## 数组的引用传递分析

通过数组的基本定义发现，数组使用过程中依然需要new进行内存的开辟。



```java
public class JavaDemo { 
	public static void main(String args[]) {
		//使用数组的动态初始化
		int data[] = new int[3];
		data[0] = 10;
		data[1] = 20;
		data[2] = 30;

		for(int x = 0 ;x < data.length() ; x ++) {
			System.out.println(data[x]);
		}
	}
}
```



数组内存分析

![image-20200708014534454](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200708014534454.png)



引用类型，涉及到引用传递：一个堆内存可以被多个栈内存指向。

范例：观察数组引用

```java
public class JavaDemo { 
	public static void main(String args[]) {
		//使用数组的动态初始化
		int data[] = new int[] {10,20,30};
		int temp[] = data;
		temp[0] = 99;

		for(int x = 0 ;x < data.length ; x ++) {
			System.out.println(data[x]);
		}
	}
}
```

> 99
> 20
> 30

![image-20200708014917135](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200708014917135.png)

由于数组属于引用类型，所以一定要为其开辟堆内存空间以后才可以使用，如果在没用开辟时使用会出现：”NullPointerException“

```java
public class JavaDemo { 
	public static void main(String args[]) {
		//使用数组的动态初始化
		int data[] = null;
		System.out.println(data[0]);
	}
}
```

> E:\software\javadev\Java\jdk-14.0.1\bin>javac JavaDemo.java
>
> E:\software\javadev\Java\jdk-14.0.1\bin>java JavaDemo
> Exception in thread "main" java.lang.NullPointerException
>         at JavaDemo.main(JavaDemo.java:5)

必须有实例化对象才可以使用数组操作形式进行数组的操作



## foreach 迭代输出

数组一般用for循环，一般会用下标的形式。

![image-20200708235910670](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200708235910670.png)

jdk1.5以后为了避免下标对程序的影响（如果下标处理不当会导致下标越界），参考.net引入了增强的for循环（foreach）,利用foreach可以直接自动获取数组的每个元素

> 语法:
>
> for(数据类型 变量:数组|集合) {}

最大特点是可以自动将每一个元素的内容取出来保存到变量里，就避免用下标方式获取

![image-20200709000216130](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200709000216130.png)

语法的好处避免下标的控制



## 二维数组

之前的数组只有一个[]，就像一行数据，可以用一个下标进行控制。

* 传统数组好像一行数据

  | 下标 | 0    | 1    | 2    | 3    | 4    |
  | ---- | ---- | ---- | ---- | ---- | ---- |
  | 数据 | 123  | 224  | 543  | 124  | 154  |

* 如果需要一个多行多列的结构，就需要两个下标共同定义，有两个[] []，

* 二维数组定义语法：

  * 动态初始化：

    * 数据类型 数组名称[] []  =  new 数据类型 [行个数] [列个数]; 

  * 静态初始化：

    * 数据类型 数组名称[] [] = new 数据类型[] [] {{数据,数据,...},{数据,数据,...},...}。

      

| 行标 | 0    | 1    | 2    | 3    | 4    |
| ---- | ---- | ---- | ---- | ---- | ---- |
| 0    | 1    | 2    | 3    | 4    | 5    |
| 1    | 1    | 2    | 3    |      |      |
| 2    | 5    | 6    | 7    | 8    |      |

既然二位数组每一行都是数组，可以取出一行，作为一维数组的处理形式。

![image-20200709000926517](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200709000926517.png)

![image-20200709001100027](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200709001100027.png)

一般不建议上图不规则的二位数组。

如果用foreach的

![image-20200709001027867](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200709001027867.png)

![image-20200709001115544](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200709001115544.png)

通过foreach的输出格式，可以发现二维数组就是数组的嵌套。

随着现在的开发，很少会用到



## 数组与方法

对于引用数据类型而言，可以用方法实现引用传递，数组也可以实现。

实现最简单的引用传递

![image-20200709001301851](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200709001301851.png)

![image-20200709001413151](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200709001413151.png)

既然可以通过方法接收数组，也可以通过方法返回数组。

![image-20200709001457459](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200709001457459.png)

匿名数组

![image-20200709001527156](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200709001527156.png)

如果简化成下面就报错

![image-20200709001553827](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200709001553827.png)

![image-20200709001612778](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200709001612778.png)

下面针对此程序，实现内存的分析

![image-20200709001718914](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200709001718914.png)



范例:通过方法修改数组内容

![image-20200709001756134](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200709001756134.png)

本程序的内存关系如下：

![image-20200709001916457](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200709001916457.png)

案例：随意定义一个int数组，要求可以计算这个数组元素的总和，最大值，最小值，平均值。

![image-20200709002048016](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200709002048016.png)

![image-20200709002140099](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200709002140099.png)

对于此程序最基本的实现，如上。但不理想

* 主方法所在的类是主类，主类编写过于复杂。再进行开发的时候，主方法本身就是一个客户端，这些操作应该交给一个程序类（工具类）

优化后的实现。

![ ](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200709002348219.png)



![image-20200709002436923](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200709002436923.png)

主类

![image-20200709002517703](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200709002517703.png)

此时的主类只关心如何操作，具体类操作的过程，被进行了封装。



## 数组排序案例分析

可以将一个杂乱的数组按照顺序进行排序。但是对于数组的排序总是通过基础模型进行实现。这里先进行升序排序。

数组分析：

原始 8 9 0 2 3 5 10 7 6 1

### 冒泡排序

![image-20200709003053152](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200709003053152.png)

![image-20200709003145003](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200709003145003.png)

![image-20200709003203890](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200709003203890.png)

![image-20200709003247164](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200709003247164.png)



![image-20200709003315091](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200709003315091.png)

![image-20200709003326272](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200709003326272.png)

![image-20200709003343800](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200709003343800.png)

![image-20200709003405731](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200709003405731.png)

![image-20200709003427884](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200709003427884.png)

数据的依次排序      

![image-20200709003539455](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200709003539455.png)

第一次

![image-20200709003557913](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200709003557913.png)

![image-20200709003621671](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200709003621671.png)

优化，二层循环的次数应减少。而且不应放在主方法。应交给一个类来处理。

![image-20200709003758453](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200709003758453.png)

![image-20200709004014353](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200709004014353.png)

![image-20200709004022903](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200709004022903.png)

Q:为什么不用实例化对象，而用static直接方法名调用？

* 因为类中没属性，产生实例化没有用。

* 以后再定义类时，如果类中没有属性存在的意义，那么定义的方法就没有必要使用普通方法了，因为普通方法需要再有实例化对象产生的情况下调用



## 数组反转案例分析

数组反转就前后专职处理，即首尾交换。例如现在有一个数组，

* 数组内容：1、2、3、4、5、6、7、8、9
* 交换后的内容：9、8、7、6、5、4、3、2、1

 对于数组的前后交换有两种做法：

做法一： 定义一个新的数组而后按照逆序的方式保存

![image-20200709004510324](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200709004510324.png)

![image-20200709004629197](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200709004629197.png)

内存分析：a代价产生垃圾

![image-20200709004823368](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200709004823368.png)



做法二：一个数组转置

![image-20200709004953213](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200709004953213.png)

这种转置最需要确定的就是数组的转换的次数，次数的计算：数组长度/2，不需要考虑奇数还是偶数

![image-20200709005143129](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200709005143129.png)

两种实现比较，第一种循环次数较多而且产生垃圾。第二种存在if判断，时间复杂度增加，可是可以减少无用对象的产生，以提升性能。

范例：吧方法转为类

![image-20200709005332998](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200709005332998.png)

![image-20200709005357728](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200709005357728.png)

可以发现数组由于可以通过角标访问，所以用循环操作的比较多



## 数组相关操作方法

由于数组是重要概念，所以Java语音本身也提供了数组相关支持处理

开发中使用

### 1.排序

java.util.Arrays.sort(data);    //排序



### 2.数组拷贝

System.arraycopy(源数组 ， 源数组开始点，目标数组，目标数组开始点，拷贝长度)

![image-20200709005755124](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200709005755124.png)

![image-20200709005846303](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200709005846303.png)

这些操作支持都是系统本身提供的，可以再开发中提供的。需要知道原理，可以自己实现。

![image-20200709010030337](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200709010030337.png)

如果自己定义copy 排序方法，则需要写工具类，适用多种格式。



## 方法可变参数

如果要求定义一个方法，要求实现任意多个整型数据的相加处理，应该怎么处理？？

最早时只能用数组来传递：
![image-20200709010234721](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200709010234721.png)

虽然以上程序可以实现任意多个数字的参数内容传递，但是与要求并不符合。要求任意多个参数，而不是一个数组。

![image-20200709010344323](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200709010344323.png)

从JDK1.5开始，为了开发者可变参数的处理，增加了新功能

![image-20200709010419515](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200709010419515.png)

实质，其实是变种数组，也可以直接传数组。

最大作用，在于程序设计或者开发者调用时避免数组的传递。比直接调用数组多了灵活性。



## 对象数组

之前接触到的都是基本类型的数组，Java中各种数据类型都可以是数组类型，这种数组称为对象数组。定义格式

* 动态初始化： 类 对象数组名 [] = new 类 [长度], 每一个元素的内容都是null
* 静态初始化：类 对象数组名 [] = new 类 [] {实例化对象,实例化对象,...};



范例：使用动态初始化。

![image-20200709010816536](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200709010816536.png)

![image-20200709010830023](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200709010830023.png)

执行都是空，需要为数组内每个元素实例化

![image-20200709010933401](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200709010933401.png)



静态初始化

![image-20200709010956246](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200709010956246.png)

对于对象数组而言，只是更换了一种数组类型，但是此时内存图就比较麻烦了。

![image-20200709011204079](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200709011204079.png)

引用中嵌套引用，所有的开发都不可能离开对象数组

经过一系列分析应该知道一个数组中最大的缺陷：长度是固定的。优势：数据是线性的，根据索引访问速度较快，时间复杂度为1



# 第8章：引用传递实际应用

引用传递是整个Java开发与设计过程中最重要的计数组成，也与生活息息相关。



## 引用应用分析一：

假设说现在生活比较好，于是有的人可以有一辆汽车，当然有的人是没有汽车的。现在通过面向对象的设计来解决实现以上的这种关系转换。

人和车本质上是分离的，需要加上关联关系

![image-20200709012358302](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200709012358302.png)

Person下应该加private Car car

Car类下应该加private Person person

这两个从属对象的实例化不应该交给构造方法，否则变成 人想出生必须先消费车。不应该有直接关系，通过后期方法设置。

```java
class Car {
	private String name;
	private double price;
	private Person person; //一辆车属于一个人
	public Car(String name ,double price) {
		this.name = name;
		this.price = price;
	}
	
	public void setPerson(Person person) {
		this.person = person;
	}

	public Person getPerson() {
		return this.person;
	}

	public String getInfo() {
		return	"品牌车型：" + this.name +"、价格：" + this.price;
	}
}

class Person {
	private String name;
	private int age;
	private Car car; //一个人有一辆车

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public Car getCar() {
		return this.car;
	}

	public String getInfo() {
		return	"姓名：" + this.name +"、年龄：" + this.age;
	}
}

public class JavaDemo { 
	public static void main(String args[]) {
		//第一步：生命对象并设置彼此关系
		Person person = new Person("林强",29);
		Car car = new Car("宾利",8000000.00);
		person.setCar(car);   //一个人有一辆车
		car.setPerson(person);  //一辆车属于一个人
		//第二步：根据关系获取数据
		System.out.println(person.getCar().getInfo()); //代码链(或者Car c = person.getCar(); c.getInfo();)
		System.out.println(car.getPerson().getInfo()); //代码链

	}
}
```

> 品牌车型：宾利、价格：8000000.0
> 姓名：林强、年龄：29

本次所操作 两个类型：Person Car是两种独立类型，实现了对两种引用关系的设置。

![image-20200709013924717](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200709013924717.png)



## 引用应用分析 二

现在已经确定了人与车的关系，现在可以进一步进行该操作的完善。例如如某一个人有孩子，孩子会成年，孩子成年后也会成年。

![image-20200709013946703](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200709013946703.png)

```java
class Car {
	private String name;
	private double price;
	private Person person; //一辆车属于一个人
	public Car(String name ,double price) {
		this.name = name;
		this.price = price;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Person getPerson() {
		return this.person;
	}

	public String getInfo() {
		return	"品牌车型：" + this.name +"、价格：" + this.price;
	}
}

class Person {
	private String name;
	private int age;
	private Car car; //一个人有一辆车
	private Person children[]; //一个人有多个孩子

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	
	public void setChildren(Person children[]) {
		this.children = children;
	}

	public Person[] getChildren() {
		return this.children;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public Car getCar() {
		return this.car;
	}

	public String getInfo() {
		return	"姓名：" + this.name +"、年龄：" + this.age;
	}
}

public class JavaDemo { 
	public static void main(String args[]) {
		//第一步：生命对象并设置彼此关系
		Person person = new Person("老张",39);
		Person childA = new Person("张三",18);
		Person childB = new Person("张四",19);
		childA.setCar(new Car("BMW X1" , 300000.00));
		childB.setCar(new Car("AUDI A8", 1000000.00));
		person.setChildren(new Person[] {childA,childB}); //一个人的孩子
		Car car = new Car("宾利",8000000.00);
		person.setCar(car);   //一个人有一辆车
		car.setPerson(person);  //一辆车属于一个人
		//第二步：根据关系获取数据
		System.out.println(person.getCar().getInfo()); //代码链(或者Car c = person.getCar(); c.getInfo();)
		System.out.println(car.getPerson().getInfo()); //代码链
		//根据人找到所有孩子及其孩子对应的汽车
		for ( int x = 0 ; x < person.getChildren().length ;x++) {
			System.out.println("\t|- " + person.getChildren()[x].getInfo());
			System.out.println("\t\t|- " + person.getChildren()[x].getCar().getInfo());

		
		
		}

	}
}
```

> 品牌车型：宾利、价格：8000000.0
> 姓名：老张、年龄：39
>         |- 姓名：张三、年龄：18
>                 |- 品牌车型：BMW X1、价格：300000.0
>         |- 姓名：张四、年龄：19
>                 |- 品牌车型：AUDI A8、价格：1000000.0

这些关系的匹配都是通过引用数据类型匹配来实现的。



## 引用应用分析三：

假设要求你定义一种可以描述电脑的类，那么在这样的状态下就必须进行拆分，电脑分为两部分，显示器和主机，而主机上需要设置一系列硬件板

```java
class 电脑{
	private 显示器 对象数组[];
	private 主机 对象;
}

class 显示器{}
class 主机{
	private 主板 对象;
	private 鼠标 对象;
	private 键盘 对象;
}
class 主板{
	private 内存 对象数组[];
	private CPU 对象数组[];
	private 显卡 对象;
	private 硬盘 对象数组[];
}
class 键盘{}
class 鼠标{}
class CPU{}
class 显卡{}
class 影盘{}
```

理论上这些组成电脑 

任何人类的产品都是可以进行拆分，而后进行重新组合，所以这样的设计在java之中被称为合成设计模式。

先拆开，用的时候根据标准合在一起。而这些关联通过引用传递来实现的。



# 第9章：数据表和简单java类映射转换

## 综合实战：数据表和简单Java类映射转换

简单Java类是现在面向对象设计的主要分析基础，但是对于实际的开发之中，简单Java类的定义来源是由依据的，往往都是根据数据表的结构实现简单Java定义。

在Java数据库中提供有若干个数据表的，那么每一张实体数据表实际上都可以描述出一些具体的概念，例如：雇员信息表、或部门信息表，一看就知道是描述的雇员或部门的信息。

那么按照这个思路回到程序之中，你会发现，程序类的定义形式实际上和实体表的差别并不大，在实际的开发之中，数据表和简单Java类的基本映射关系如下：

* 数据实体表设计 = 类的定义；
* 表中的字段 = 类的成员属性；
* 表的一行记录 = 类的一个实例化对象；
* 表的多行对象 = 对象数组；
* 表的外键关联 = 引用关联

![image-20200710235000647](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200710235000647.png)

在以上所对应数据表的关系之中可以发现如下关联存在：

* 一个部门有多个雇员
* 一个雇员属于一个部门
* 一个雇员有一个领导

下面将以上的数据表转换为简单java类的定义形式，在整体的代码之中要求可以获得如下信息：

* 根据部门信息获得以下内容
  * 一个部门的完整信息
  * 一个部门之中所有雇员的信息
  * 一个雇员对应的领导的信息
* 根据雇员信息获得以下内容
  * 一个雇员所在的部门信息
  * 一个雇员对应的领导信息



对于数据表与简单java类的映射最好的解决步骤：先抛开所有的关联字段不看，写出类的基本组成，然后通过引用配置关联字段的关系。：

第一步：定义Emp、Dept两个实体类

**描述数据表主键的时候用long**

```java
class Dept{
	private long deptno;
	private String dname;
	private String loc;
	public Dept(long dempno,String dnam,String loc) {
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}
	//setter、getter、无参构造略

	public String getInfo() {
		return "【部门信息】部门编号 = " + this.deptno + "、部门名称 = " + this.dname + "、部门位置 = " + this.loc;
	}
}

class Emp{
	private long empno;
	private String ename;
	private String job;
	private double sal;
	private double comm;
	public Emp(long empno, String ename, String job, double sal, double comm) {
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.sal = sal;
		this.comm = comm;
	}
	
	//setter、getter、无参构造方法略

	public String getInfo(){
		return "【雇员信息】雇员编号 = " + this.empno + "、雇员姓名 = " + this.ename + "、雇员职位 = " + this.job + "、佣金 = " + this.comm;
	}
}

public class JavaDemo { 
	public static void main(String args[]) {
			System.out.println("ok");
			
		}

	}
```

第二步：配置所有关联字段

```java
class Dept{
	private long deptno;
	private String dname;
	private String loc;
	private Emp emps [];  //一个部门有多个雇员信息
	public Dept(long dempno,String dnam,String loc) {
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}

	public void setEmps(Emps [] emps) {
		this.emps = emps;
	}

	public Emp [] getEmps() {
		return this.emps;
	}
	//setter、getter、无参构造略

	public String getInfo() {
		return "【部门信息】部门编号 = " + this.deptno + "、部门名称 = " + this.dname + "、部门位置 = " + this.loc;
	}
}

class Emp{
	private long empno;
	private String ename;
	private String job;
	private double sal;
	private double comm;
	private Dept dept; //所属部门
	private Emp mgr;  //所属领导
	public Emp(long empno, String ename, String job, double sal, double comm) {
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.sal = sal;
		this.comm = comm;
	}
	
	//setter、getter、无参构造方法略

	public String getInfo(){
		return "【雇员信息】雇员编号 = " + this.empno + "、雇员姓名 = " + this.ename + "、雇员职位 = " + this.job + "、佣金 = " + this.comm;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public void setMgr(Emp mgr){
		this.mgr = mgr;
	}

	public Dept getDept() {
		return this.dept;
	}

	public Emp getMgr(){
		return this.mgr;
	}
}

public class JavaDemo { 
	public static void main(String args[]) {
			System.out.println("ok");
			
		}

	}
```

以后进行实际项目开发的过程之中一定是分两个步骤实现的：

* 第一步:根据表的结构关系进行对象的配置;
* 第二步:根据要求通过结构获取数据.

范例:实现项目所有开发需求

```java
class Dept{
	private long deptno;
	private String dname;
	private String loc;
	private Emp emps [];  //一个部门有多个雇员信息
	public Dept(long dempno,String dnam,String loc) {
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}

	public void setEmps(Emp [] emps) {
		this.emps = emps;
	}

	public Emp [] getEmps() {
		return this.emps;
	}
	//setter、getter、无参构造略

	public String getInfo() {
		return "【部门信息】部门编号 = " + this.deptno + "、部门名称 = " + this.dname + "、部门位置 = " + this.loc;
	}
}

class Emp{
	private long empno;
	private String ename;
	private String job;
	private double sal;
	private double comm;
	private Dept dept; //所属部门
	private Emp mgr;  //所属领导
	public Emp(long empno, String ename, String job, double sal, double comm) {
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.sal = sal;
		this.comm = comm;
	}
	
	//setter、getter、无参构造方法略

	public String getInfo(){
		return "【雇员信息】雇员编号 = " + this.empno + "、雇员姓名 = " + this.ename + "、雇员职位 = " + this.job + "、佣金 = " + this.comm;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public void setMgr(Emp mgr){
		this.mgr = mgr;
	}

	public Dept getDept() {
		return this.dept;
	}

	public Emp getMgr(){
		return this.mgr;
	}
}

public class JavaDemo { 
	public static void main(String args[]) {
		//第一步： 根据关系进行类的定义
		Dept dept = new Dept(10,"财务部","上海");
		Emp empA = new Emp(7369L,"SMITH","CLERK",800.00,0.0);
		Emp empB = new Emp(7566L,"FORD","MANAGER",2450.00,0.0);
		Emp empC = new Emp(7839L,"KING","PRESIDENT",5000.00,0.0);
		//需要为对象进行关联的设置
		empA.setDept(dept);	//设置雇员与部门的关联
		empB.setDept(dept);	//设置雇员与部门的关联
		empC.setDept(dept);	//设置雇员与部门的关联
		empA.setMgr(empB);	//设置雇员与领导的关联
		empB.setMgr(empC);	//设置雇员与领导的关联
		dept.setEmps(new Emp[] {empA,empB,empC});  //部门与雇员的关系

		//第二步：根据关系获取数据
		System.out.println(dept.getInfo());  //部门信息
		for (int x = 0; x < dept.getEmps().length ; x ++ ){
			System.out.println("\t|- " + dept.getEmps()[x].getInfo());  //雇员信息
			System.out.println("\t\t|- " + dept.getEmps()[x].getMgr().getInfo()); //领导信息
		}
	}
}
```

> 【部门信息】部门编号 = 0、部门名称 = null、部门位置 = 上海
>         |- 【雇员信息】雇员编号 = 7369、雇员姓名 = SMITH、雇员职位 = CLERK、佣金 = 0.0
>                 |- 【雇员信息】雇员编号 = 7566、雇员姓名 = FORD、雇员职位 = MANAGER、佣金 = 0.0
>         |- 【雇员信息】雇员编号 = 7566、雇员姓名 = FORD、雇员职位 = MANAGER、佣金 = 0.0
>                 |- 【雇员信息】雇员编号 = 7839、雇员姓名 = KING、雇员职位 = PRESIDENT、佣金 = 0.0
>         |- 【雇员信息】雇员编号 = 7839、雇员姓名 = KING、雇员职位 = PRESIDENT、佣金 = 0.0
> Exception in thread "main" java.lang.NullPointerException
>         at JavaDemo.main(JavaDemo.java:84)

原因,7839没有领导

```java
			if(dept.getEmps()[x].getMgr() != null) {
				System.out.println("\t\t|- " + dept.getEmps()[x].getMgr().getInfo()); //领导信息
			}
```

完成功能

```java
class Dept{
	private long deptno;
	private String dname;
	private String loc;
	private Emp emps [];  //一个部门有多个雇员信息
	public Dept(long dempno,String dnam,String loc) {
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}

	public void setEmps(Emp [] emps) {
		this.emps = emps;
	}

	public Emp [] getEmps() {
		return this.emps;
	}
	//setter、getter、无参构造略

	public String getInfo() {
		return "【部门信息】部门编号 = " + this.deptno + "、部门名称 = " + this.dname + "、部门位置 = " + this.loc;
	}
}

class Emp{
	private long empno;
	private String ename;
	private String job;
	private double sal;
	private double comm;
	private Dept dept; //所属部门
	private Emp mgr;  //所属领导
	public Emp(long empno, String ename, String job, double sal, double comm) {
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.sal = sal;
		this.comm = comm;
	}
	
	//setter、getter、无参构造方法略

	public String getInfo(){
		return "【雇员信息】雇员编号 = " + this.empno + "、雇员姓名 = " + this.ename + "、雇员职位 = " + this.job + "、佣金 = " + this.comm;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public void setMgr(Emp mgr){
		this.mgr = mgr;
	}

	public Dept getDept() {
		return this.dept;
	}

	public Emp getMgr(){
		return this.mgr;
	}
}

public class JavaDemo { 
	public static void main(String args[]) {
		//第一步： 根据关系进行类的定义
		Dept dept = new Dept(10,"财务部","上海");
		Emp empA = new Emp(7369L,"SMITH","CLERK",800.00,0.0);
		Emp empB = new Emp(7566L,"FORD","MANAGER",2450.00,0.0);
		Emp empC = new Emp(7839L,"KING","PRESIDENT",5000.00,0.0);
		//需要为对象进行关联的设置
		empA.setDept(dept);	//设置雇员与部门的关联
		empB.setDept(dept);	//设置雇员与部门的关联
		empC.setDept(dept);	//设置雇员与部门的关联
		empA.setMgr(empB);	//设置雇员与领导的关联
		empB.setMgr(empC);	//设置雇员与领导的关联
		dept.setEmps(new Emp[] {empA,empB,empC});  //部门与雇员的关系

		//第二步：根据关系获取数据
		System.out.println(dept.getInfo());  //部门信息
		for (int x = 0; x < dept.getEmps().length ; x ++ ){
			System.out.println("\t|- " + dept.getEmps()[x].getInfo());  //雇员信息
			if(dept.getEmps()[x].getMgr() != null) {
				System.out.println("\t\t|- " + dept.getEmps()[x].getMgr().getInfo()); //领导信息
			}
		}
		System.out.println("-------------------------"); 
		
		System.out.println(empB.getDept().getInfo()); //根据雇员获取部门信息
		System.out.println(empB.getMgr().getInfo()); //根据雇员获取领导信息
	}
}
```

在以后的开发之中这种转换的定义形式一定要求熟练完成的. 引用,代码链等



## 综合实战:一对多映射

![image-20200711111411089](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200711111411089.png)

按照表的要求将表的结构转化为类结构,同时可以获取如下信息:

* 获取一个分类的完整信息;
* 可以根据分类获取其对应的所有子分类的信息。

```java
class Item{
	private long iid;
	private String title;
	private Subitem subitems [] ;
	public Item(long iid, String title) {
		this.iid = iid;
		this.title = title;
	}
	public void setSubitems(Subitem subitems []) {
		this.subitems = subitems;
	}
	public Subitem [] getSubitems() {
		return this.subitems;
	}
	public String getInfo() {
		return "【分类信息】iid = " + this.iid + "、title = " + this.title;
	}

}

class Subitem{
	private long sid;
	private String title;
	private Item item;
	public Subitem(long sid, String title) {
		this.sid = sid;
		this.title = title;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public Item getItem() {
		return this.item;
	}


	public String getInfo() {
		return "【子分类信息】sid = " + this.sid + "、title = " + this.title;
	}
}

public class JavaDemo { 
	public static void main(String args[]) {
		//第一步： 根据结构设置对象数据
		Item item = new Item(1L, "图书");
		Subitem subitems[] = new Subitem [] {
			new Subitem(10L,"编程图书"),
			new Subitem(10L,"图形图像类图书")
		};
		item.setSubitems(subitems);     //一个分类下有多个子分类
		for (int x = 0; x < subitems.length ; x ++) {
			subitems[x].setItem(item);
		}
		//第二步：根据要求获取数据
		System.out.println(item.getInfo());
		for (int x = 0; x< item.getSubitems().length ; x ++) {
			System.out.println("\t|- " + item.getSubitems() [x].getInfo());
		}
	}
}
```

> 【分类信息】iid = 1、title = 图书
>         |- 【子分类信息】sid = 10、title = 编程图书
>         |- 【子分类信息】sid = 10、title = 图形图像类图书

## 综合实战：多对多映射

![image-20200711114815240](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200711114815240.png)

将以上固定结构转换为类结构，并且可以获取如下的信息。

* 获取一个用户浏览过的所有商品的详细信息。
* 获取一个商品被浏览过的全部用户信息。

Q:如果要做转换，访问记录需不需要转换？？

此时的程序只需要去考虑实体表的设计即可，也就是说对于中间的访问记录信息表（关联表）不要求你进行转换处理，知道你故意两个类即可。

范例

```java
class Member{
	private String mid;
	private String name;
	private Product products [] ;
	public Member(String mid, String name) {
		this.mid = mid;
		this.name = name;
	}

	public void setProducts(Product products []) {
		this.products = products;
	}

	public Product [] getProducts() {
		return this.products;
	}

	public String getInfo() {
		return "【用户信息】mid = " + this.mid + "、name = " + this.name;
	}
}

class Product {
	private long pid;
	private String title;
	private double price;
	private Member members [];

	public Product(long pid, String title, double price) {
		this.pid = pid;
		this.title = title;
		this.price = price;
	}

	public void setMembers(Member members []) {
		this.members = members;
	}

	public Member [] getMembers() {
		return this.members;
	}

	public String getInfo() {
		return "【商品信息】pid = " + this.pid + "、title = " + this.title + "、price = " + this.price;
	}
}

class Pulic
{
}

public class JavaDemo { 
	public static void main(String args[]) {
		//第一步： 根据结构设置对象数据
		Member memA = new Member("mldn","张三");
		Member memB = new Member("mldnjava","李四");
		Product proA = new Product(1L,"java开发图书",79.8);
		Product proB = new Product(2L,"非常大的B的耳机",2309.8);
		Product proC = new Product(3L,"小米手机",3000.8);

		memA.setProducts(new Product[] {proA,proB,proC});
		memB.setProducts(new Product[] {proA});
		proA.setMembers(new Member[] {memA,memB});
		proB.setMembers(new Member[] {memA});
		proC.setMembers(new Member[] {memA});
		//第二步：根据要求获取数据
		System.out.println("-----------------根据商品找到被浏览的记录---------------");
		System.out.println(proA.getInfo());
		for (int x = 0 ; x < proA.getMembers().length ; x ++ ) {
			System.out.println("\t|- " + proA.getMembers() [x].getInfo());			
		}
		System.out.println("-----------------根据用户查看浏览商品信息---------------");
		System.out.println(memA.getInfo());
		for (int x = 0 ; x < memA.getProducts().length ; x ++ ) {
			System.out.println("\t|- " + memA.getProducts() [x].getInfo());			
		}

	}
}
```

> -----------------根据商品找到被浏览的记录---------------
> 【商品信息】pid = 1、title = java开发图书、price = 79.8
>         |- 【用户信息】mid = mldn、name = 张三
>         |- 【用户信息】mid = mldnjava、name = 李四
> -----------------根据用户查看浏览商品信息---------------
> 【用户信息】mid = mldn、name = 张三
>         |- 【商品信息】pid = 1、title = java开发图书、price = 79.8
>         |- 【商品信息】pid = 2、title = 非常大的B的耳机、price = 2309.8
>         |- 【商品信息】pid = 3、title = 小米手机、price = 3000.8



## 综合实战：复杂多对多映射

![image-20200711204846331](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200711204846331.png)

在进行实际项目开发过程之中，对于用户的授权管理是一项重要的任务，下面给出了一个最为常见的用户权限管理的表结构设计，基本关系如下：

* 一个用户可以拥有多个角色，一个角色可能有多个用户；
* 一个角色可能拥有多个权限；



要求实现如下查询功能：

* 根据一个用户找到该用户对应的角色，以及每一个角色对应的所有权限信息；
* 根据一个角色找到该角色下的所有权限，以及拥有此角色的全部用户信息；
* 根据一个权限找到具备此权限的所有用户信息。 

四张表，三个类。

```java
class Member{
	private String mid;
	private String name;
	private Role[] roles;
	public Member(String mid, String name) {
		this.mid = mid;
		this.name = name;
	}

	public void setRoles(Role[] roles ) {
		this.roles = roles;
	}

	public Role[] getRoles() {
		return this.roles;
	}

	public String getInfo() {
		return "【用户信息】mid = " + this.mid + "、name = " + this.name;
	}
}

class Role {
	private long rid;
	private String title;
	private Member[] members ;
	private Privilege[] privileges ;
	public Role(long rid,String title) {
		this.rid = rid;
		this.title = title;
	}
	
	public void setMembers(Member[] members) {
		this.members = members;
	}

	public Member[] getMembers() {
		return this.members;
	}

	public void setPrivileges(Privilege[] privileges) {
		this.privileges = privileges;
	}

	public Privilege[] getPrivileges() {
		return this.privileges;
	}

	public String getInfo() {
		return "【角色信息】rid = " + this.rid + "、title = " + this.title;
	}
}

class Privilege {
	private long pid;
	private String title;
	private Role role ;
	public Privilege(long pid, String title) {
		this.pid = pid;
		this.title = title;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Role getRole() {
		return this.role;
	}

	public String getInfo() {
		return "【权限信息】pid = " + this.pid + "、title = " +this.title; 
	}

}

public class JavaDemo { 
	public static void main(String[] args) {
		//第一步： 根据结构设置对象数据
		Member memA = new Member("mldn-a","张三");
		Member memB = new Member("mldn-b","李四");
		Role roleA = new Role(1L,"系统配置");
		Role roleB = new Role(2L,"备份管理");
		Role roleC = new Role(3L,"人事管理");
		Privilege priA = new Privilege(1000L,"系统初始化");
		Privilege priB = new Privilege(1001L,"系统还原");
		Privilege priC = new Privilege(1002L,"系统环境修改");
		Privilege priD = new Privilege(2000L,"备份员工数据");
		Privilege priE = new Privilege(2001L,"备份部门数据");
		Privilege priF = new Privilege(2002L,"备份公文数据");
		Privilege priG = new Privilege(3000L,"增加员工");
		Privilege priH = new Privilege(3001L,"编辑员工");
		Privilege priI = new Privilege(3002L,"浏览员工");
		Privilege priJ = new Privilege(3003L,"员工离职");
		//增加角色与权限的对应关系
		roleA.setPrivileges(new Privilege[] {priA,priB,priC});
		roleB.setPrivileges(new Privilege[] {priD,priE,priF});
		roleC.setPrivileges(new Privilege[] {priG,priH,priI,priJ});
		//增加权限与角色对应
		priA.setRole(roleA);
		priB.setRole(roleA);
		priC.setRole(roleA);
		priD.setRole(roleB);
		priE.setRole(roleB);
		priF.setRole(roleB);
		priG.setRole(roleC);
		priH.setRole(roleC);
		priI.setRole(roleC);
		priJ.setRole(roleC);
		//增加用户与角色的对应关系
		memA.setRoles(new Role[] {roleA,roleB});
		memB.setRoles(new Role[] {roleA,roleB,roleC});
		roleA.setMembers(new Member[] {memA,memB});
		roleB.setMembers(new Member[] {memA,memB});
		roleC.setMembers(new Member[] {memB});
		//第二步：根据要求获取数据
		System.out.println("--------通过用户查找信息------------");
		System.out.println(memB.getInfo());
		for (int x = 0 ; x < memB.getRoles().length ; x ++) {
			System.out.println("\t|- " + memB.getRoles() [x].getInfo());
			for ( int y = 0 ; y < memB.getRoles()[x].getPrivileges().length ; y ++ ) {
				System.out.println("\t\t|- " + memB.getRoles()[x].getPrivileges()[y].getInfo());
			}
		}
		System.out.println("--------通过角色查找信息------------");
		System.out.println(roleB.getInfo());
		System.out.println("\t|- 浏览此角色下的所有权限信息：");
		for (int x = 0 ; x < roleB.getPrivileges().length ; x ++ ) {
			System.out.println("\t|- " + roleB.getPrivileges()[x].getInfo());
		}
		System.out.println("\t|- 浏览此角色下的所有用户信息：");
		for (int x = 0 ; x < roleB.getMembers().length ; x ++) {
			System.out.println("\t\t|- " + roleB.getMembers()[x].getInfo());
		}
		System.out.println("--------通过权限查找信息------------");
		System.out.println(priA.getInfo());
		for (int x = 0 ; x < priA.getRole().getMembers().length ; x ++ ) {
			System.out.println("\t|- " + priA.getRole().getMembers()[x].getInfo());
		}

	}
}
```

> --------通过用户查找信息------------
> 【用户信息】mid = mldn-b、name = 李四
>         |- 【角色信息】rid = 1、title = 系统配置
>                 |- 【权限信息】pid = 1000、title = 系统初始化
>                 |- 【权限信息】pid = 1001、title = 系统还原
>                 |- 【权限信息】pid = 1002、title = 系统环境修改
>         |- 【角色信息】rid = 2、title = 备份管理
>                 |- 【权限信息】pid = 2000、title = 备份员工数据
>                 |- 【权限信息】pid = 2001、title = 备份部门数据
>                 |- 【权限信息】pid = 2002、title = 备份公文数据
>         |- 【角色信息】rid = 3、title = 人事管理
>                 |- 【权限信息】pid = 3000、title = 增加员工
>                 |- 【权限信息】pid = 3001、title = 编辑员工
>                 |- 【权限信息】pid = 3002、title = 浏览员工
>                 |- 【权限信息】pid = 3003、title = 员工离职
> --------通过角色查找信息------------
> 【角色信息】rid = 2、title = 备份管理
>         |- 浏览此角色下的所有权限信息：
>         |- 【权限信息】pid = 2000、title = 备份员工数据
>         |- 【权限信息】pid = 2001、title = 备份部门数据
>         |- 【权限信息】pid = 2002、title = 备份公文数据
>         |- 浏览此角色下的所有用户信息：
>                 |- 【用户信息】mid = mldn-a、name = 张三
>                 |- 【用户信息】mid = mldn-b、name = 李四
> --------通过权限查找信息------------
> 【权限信息】pid = 1000、title = 系统初始化
>         |- 【用户信息】mid = mldn-a、name = 张三
>         |- 【用户信息】mid = mldn-b、name = 李四



# 第10章：String类特点分析

实际开发中没有哪个项目不去使用String类，也就是说String是整个系统开发之中一个至关重要的组成类。Java中字符串要求“”定义，还可以用+连接。此外还有些自身的特点。

## String类简介

String 严格说并不能算是一个基本数据类型，也就是说没有任何一门语言会提供有字符串这种数据类型，而java里面为了方便开发者进行项目的编写，所以利用JVM的支持制造了一种可以简单使用的String类。

范例：String类的实例化

```java
public class JavaDemo { 
	public static void main(String[] args) {
		String str = "www.faw.com" ; //直接赋值
		System.out.println(str);
	}
}
```

需要注意的是，String这个类里面之所以可以保存字符串主要的原因是其中定义了一个数组，也就是说，String字符串中的每一个字符之中都是存在了数组之中。

**提示：观察String的源代码实现**

* 源代码目录： java\jdk**\lib\src.zip

* JDK1.8以后字符串的定义形式增多了

* | jdk1.8及以前的String支持类                                   | jdk1.9及以后的String支持类                                   |
  | ------------------------------------------------------------ | ------------------------------------------------------------ |
  | ![image-20200711223230388](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200711223230388.png) | ![image-20200711223258652](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200711223258652.png) |

  

* | JDK1.8以前String保存的字符数组 | JDK1.9以后String保存的字节数组 |
  | ------------------------------ | ------------------------------ |
  | private final byte[] value;    | private final char value[];    |

* 原来所谓的字符串就是对数组的一种包装应用，同时需要清除的一点，因为包装的是数组，所以String中的内容是无法改变的。



另外需要注意的是，在String类里面除了可以使用直接赋值的形式为对象实例化之外，也可用传统方式，利用构造放啊进行对象的实例化处理：

>  public String(String str);

范例：利用构造方法进行实例化

```java
public class JavaDemo { 
	public static void main(String[] args) {
		String str = new String("www.faw.com") ; //直接赋值
		System.out.println(str);
	}
}
```

String 本身包装的是一个数组，有直接赋值和构造方法两种实例化形式。



## 字符串比较

下面回顾以下，如果判断两个int型变量是否相等，肯定用“==”比较

范例：用==比较

```java
public class JavaDemo { 
	public static void main(String[] args) {
		int x = 10;
		int y = 10;
		System.out.println(x == y);
	}
}
```

> true

但是String类也牵扯到了相等的判断问题，但是对于String类相等的判断也可以使用==，但是判断的**不准确**。

范例：字符串相等的判断

```java
public class JavaDemo { 
	public static void main(String[] args) {
		String strA = "mldn";
		String strB = new String("mldn");
		System.out.println(strA == strB);
	}
}
```

> false

此时的比较并没有成功，所以发现虽然两个字符串对象的内容是相同的，但是“==”也无法得到准确的相等判断，但是这种情况下，如果想要使用准确的字符串相等判断，应该使用String类中提供的一个字符串比较方法：

* 字符串比较（有变形）：public boolean equals(String str);

范例：利用equals()实现字符串比较

```java
public class JavaDemo { 
	public static void main(String[] args) {
		String strA = "mldn";
		String strB = new String("mldn");
		System.out.println(strA.equals(strB));
	}
}
```

> true

**Q：解释String中"==" 与equals()区别**

如果以对象为例，strB代表内存地址，使用了new 开辟了新的内存空间，所以strA和strB的内存地址不相等

* “==”：进行的是数值比较，用于对象比较上比较的是两个内存地址
* equals()：是类所提供的一个比较方法 ，可以直接比较字符串内容



## 字符串常量是String类的匿名对象！

现在已经清除了String类的基本操作形式，但是需要做出一个明确的定义，在程序的开发之中，任何的一个整数都是int型，任何的小数都是double，但是对于字符串而言，程序之中不会提供字符串这样的基本数据类型，提供的只是String类。所以任何使用""定义的字符串常量实际上描述的都是一个String类的匿名对象。

例如下面的内存关系图分析

> String str = "mldn";

![image-20200711232942620](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200711232942620.png)

如果"mldn"在堆，但是没有栈指向，就是一个“匿名对象”

所谓的String类对象的直接赋值直接描述的是，将一个匿名对象设置一个具体的引用名字。

范例：观察匿名对象的存在

```java
public class JavaDemo { 
	public static void main(String[] args) {
		String str = "mldn";
		System.out.println("mlldn".equals(str));
	}
}
```

如果匿名对象，是一个类的实例化对象，所以可以调用String类的equals方法，实现对象相等的判断。

》》》程序中没有所谓的字符串常量，有的只是String类的匿名对象。（由系统自动的）

**关于对象相等判断的小技巧**

在以后项目开发的时候，如果现在某些数据是由用户输入，并且要求这些数据为一个指定内容的情况下，建议将字符串常量写在前面。

反例：

```java
public class JavaDemo { 
	public static void main(String[] args) {
		String input = "mldn";
		System.out.println(input.equals("mlldn"));
	}
}
```

本身没错，假设用户未输入， input = null，会出现空指针。所以换个方式，将字符串写在前面。

equals()方法里有可以回避null的判断，如果调用equals方法时将常量写在前面，匿名对象不会为空，不会出现空指针异常。



## String类两种实例化方式区别

区分两种处理模式使用哪种会更好

### 分析直接赋值的对象实例化模式

在程序之中只需要将一个字符串赋值给String类的对象就可以实现对象的实例化处理，现在假设只有如下一行代码

```java
public class JavaDemo { 
	public static void main(String[] args) {
		String input = "mldn";
	}
}
```

这种情况下只会开辟出一块堆内存空间。内存关系图如下。

![image-20200711232942620](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200711232942620.png)

除了这种内存模式之外，利用直接赋值实例化String的形式还可以实现同一个字符串数据的共享操作。

范例：观察String直接赋值时的数据共享

```java
public class JavaDemo { 
	public static void main(String[] args) {
		String strA = "mldn";
		String strB = "mldn";
		String strC = "mldn";
		System.out.println(strA == strB);  //地址判断
		
	}
}
```

> true

此时程序的判断结果返回了true，可以得出结论，这两个对象所指向的堆内存是同一个地址。

内存关系图如下

![image-20200711234402042](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200711234402042.png)



**Q：为什么可以共享**

之所以会有这样的特点，主要的原因是因为java程序的底层里面提供有一个专门的字符串池（字符串数组）。

在堆内存中有一块空间叫字符串池。初始默认全为null。

![image-20200711234750225](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200711234750225.png)

新定义时，优先查找字符串池，如果池中有数据，直接指向，如果没有数据再放个新的。

范例：字符串池的认识

```java
public class JavaDemo { 
	public static void main(String[] args) {
		String strA = "mldn";
		String strB = "mldnJava";
		String strC = "mldn";
		System.out.println(strA == strB);  //地址判断
		
	}
}
```

![image-20200711235052655](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200711235052655.png)

在采用直接赋值的处理过程之中，对于字符串而言可以实现池数据的自动保存，这样如果再有相同数据定义时，可以减少对象的产生，以提高操作性能



### 构造方法实例化String

构造方法实例化可以说时进行对象定义时候的一种常见做法。String类为了满足于设计的结构要求，也提供有构造方法实例化的做法。

```java
public class JavaDemo { 
	public static void main(String[] args) {
		String str = new String( "mldn");	
	}
}
```

![image-20200712174546545](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200712174546545.png)

此时会开辟两块堆内存空间，而后只会使用一块，而另一块由于字符串常量所定义的匿名对象将成为垃圾空间。new 会带来垃圾空间

范例：更换一种形式

```java
public class JavaDemo { 
	public static void main(String[] args) {
		String strA = "mldn";
		String strB = new String( "mldn");
		System.out.println(str);  
		
	}
}
```

![image-20200712191241450](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200712191241450.png)

除了以上特点之外，在使用构造方法实例化String类对象时不会出现自动保存到字符串池的处理

范例：观察构造方法实例化的池操作。

```java
public class JavaDemo { 
	public static void main(String[] args) {
		String strA = "mldn";
		String strB = new String( "mldn");
		System.out.println(strA == strB);  
		
	}
}
```

> false

可以发现构造方法实例化的对象实际上是属于一种自己专用的内存空间，但是在String类之中也提供有帮助开发者手工入池的处理情况，这个方法：public String intern();

范例：观察手工入池

```java
public class JavaDemo { 
	public static void main(String[] args) {
		String strA = "mldn";
		String strB = new String( "mldn").intern();
		System.out.println(strA == strB);  
	}
}
```

在构造方法定义对象之后，使用了intern()方法，所以即便是构造出来的String类对象的内容，也可以实现入对象池的统一管理，但是做法太罗嗦

**面试题：解释String类两种实例化方式的区别**

* 直接赋值：生成一个实例化对象，并且可以自动保存到对象池之中，以实现该字符串实例的重用；
* 构造方法实例化：生成两个实例化对象，并且不会自动入池，无法实现对象重用但是可以使用inern()方法，手工入池处理。



## String对象（常量）池

对象池的主要目的是实现数据的共享处理。以String对象池为例，里面的内容主要目的是为了重用，即实现共享设计，但是在Java之中对象（常量）池实际上可以分为两种：

* 静态常量池：指的是程序（*.class）在加载时会自动将程序之中保存的字符串、普通常量、类和方法的信息等等，全部进行分配；
* 运行时常量池：当一个程序（*.class）加载之后，里面可能与一些变量，这个时候提供的常量池

范例：观察一个程序，静态常量池

```java
public class JavaDemo { 
	public static void main(String[] args) {
		String strA = "www.mldn.cn";
		String strB = "www." + "mldn" + ".cn";
		System.out.println(strA == strB);  
	}
}
```

> true

本程序中所给出的内容全部都是常量内容（字符串的常量都是匿名对象），所以在程序加载时会自动帮开发者实现连接。

![image-20200712193052892](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200712193052892.png)

范例：观察另外一种情况

```java
public class JavaDemo { 
	public static void main(String[] args) {
		String info = "mldn";
		String strA = "www.mldn.cn";
		String strB = "www." + info + ".cn";
		System.out.println(strA == strB);  
	}
}
```

> false

这时是因为，程序在加载时候并不确定info是什么内容，因为进行字符串连接的时候info是一个变量，变量的内容可以修改，所以加载时无法识别strb的结果是最后的结果。

strA在静态常量池，strB存入了运行时常量池。所以输入数据如果用==与静态数据比较，绝对不等。



## 字符串内容不可修改

在String类之中包含的是一个数组，数组的最大缺点在于长度不可改变，当设置了一个字符串之后，会自动的进行数组空间的开辟，且长度是固定的

范例：String程序的保存

![image-20200712193505108](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200712193505108.png)

范例：观察一个程序

```java
public class JavaDemo { 
	public static void main(String[] args) {
		String str = "www.";
		str += "mldn.";
		str = str + "cn";
		System.out.println(str);  
	}
}
```

分析下内存处理操作

![image-20200712194839151](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200712194839151.png)

整个程序发现，处理过程之中字符串常量的内容并没有发生改变，只是对象引用的变更，并产生了大量垃圾空间

```java
public class JavaDemo { 
	public static void main(String[] args) {
		String str = "www.";
		for (int x = 0 ; x < 1000 ; x ++ ) {
			str += x;
		}
		System.out.println(str);  
	}
}
```

> www.0123456789101112131415161718192021222324252627282930313233343536373839404142434445464748495051525354555657585960616263646566676869707172737475767778798081828384858687888990919293949596979899100101102103104105106107108109110111112113114115116117118119120121122123124125126127128129130131132133134135136137138139140141142143144145146147148149150151152153154155156157158159160161162163164165166167168169170171172173174175176177178179180181182183184185186187188189190191192193194195196197198199200201202203204205206207208209210211212213214215216217218219220221222223224225226227228229230231232233234235236237238239240241242243244245246247248249250251252253254255256257258259260261262263264265266267268269270271272273274275276277278279280281282283284285286287288289290291292293294295296297298299300301302303304305306307308309310311312313314315316317318319320321322323324325326327328329330331332333334335336337338339340341342343344345346347348349350351352353354355356357358359360361362363364365366367368369370371372373374375376377378379380381382383384385386387388389390391392393394395396397398399400401402403404405406407408409410411412413414415416417418419420421422423424425426427428429430431432433434435436437438439440441442443444445446447448449450451452453454455456457458459460461462463464465466467468469470471472473474475476477478479480481482483484485486487488489490491492493494495496497498499500501502503504505506507508509510511512513514515516517518519520521522523524525526527528529530531532533534535536537538539540541542543544545546547548549550551552553554555556557558559560561562563564565566567568569570571572573574575576577578579580581582583584585586587588589590591592593594595596597598599600601602603604605606607608609610611612613614615616617618619620621622623624625626627628629630631632633634635636637638639640641642643644645646647648649650651652653654655656657658659660661662663664665666667668669670671672673674675676677678679680681682683684685686687688689690691692693694695696697698699700701702703704705706707708709710711712713714715716717718719720721722723724725726727728729730731732733734735736737738739740741742743744745746747748749750751752753754755756757758759760761762763764765766767768769770771772773774775776777778779780781782783784785786787788789790791792793794795796797798799800801802803804805806807808809810811812813814815816817818819820821822823824825826827828829830831832833834835836837838839840841842843844845846847848849850851852853854855856857858859860861862863864865866867868869870871872873874875876877878879880881882883884885886887888889890891892893894895896897898899900901902903904905906907908909910911912913914915916917918919920921922923924925926927928929930931932933934935936937938939940941942943944945946947948949950951952953954955956957958959960961962963964965966967968969970971972973974975976977978979980981982983984985986987988989990991992993994995996997998999

如果真的出现在了代码中，将会产生2000个垃圾空间，并且String对象的执行修改1000次，这样程序的修能非常差。在开发中尽量减少对String的修改

>  String str = "a"  + "b"  + "c";
>
> 这种不算修改



## Java中的主方法

java中的主方法组成非常复杂，而且单词也很多：public static void main(String args[])

* public：描述的是一种访问权限，主方法是一切的开始点，开始点一定是公共的；
* static：程序 执行是通过类名称完成的，所以表示次方法是由类直接调用的，执行时不用加main，系统自己找到的；
* void：主方法时一切的起点，一旦开始就没有返回的可能的。
* main：是一个系统定义好的方法名称
* String args[]：字符串的数组，可以实现程序启动参数的接收。

```java
public class JavaDemo { 
	public static void main(String[] args) {
		for (String arg : args) {
			System.out.println(arg);  
		}
	}
}
```

程序执行的时候可以设置参数，每一个参数之间使用空格分隔：

> java JavaDemo first second
>
> first
> second

但是千万注意几点，如果参数本身拥有空格，则必须使用"  "定义包装

> java JavaDemo hello world hello mldn
> hello
> world
> hello
> mldn

和

> java JavaDemo "hello world" "hello mldn"
> hello world
> hello mldn

以后可以暂时通过启动参数，进行初始化数据



# 第11章：String类的常用方法

在实际的项目开发过程之中，只要是项目都一定会存在有String类的定义，所以掌握这个类之中的常用的处理方法，对于开发者而言时非常重要的。

## JavaDoc简介

在以后进行开发的过程之中肯定要大量的去使用Java的Api文档（JavaDoc），这个文档可以直接通过oracle的在线访问进行查看。

> https://docs.oracle.com/javase/9/docs/api/overview-summary.html

在JDK1.9之前，所有Java的常用类库会在JVM启动的时候进行全部的加载，这样实际上性能会有所下降，所以在JDK1.9开始，提供有模块化的设计，将一些程序类放在了不同的模块里面。

![image-20200712202012789](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200712202012789.png)

会使文档查询更加麻烦。

有个java.base的模块，里面是基础模块。每个模块里有很多程序开发包。

![image-20200712202135379](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200712202135379.png)

String在java.lang这个包，String是一个系统提供的较为标准的类，所以现在以这个类的文档结构进行说明，一般文档的组成有以下几个部分：

| 划分                         | 实例                                                         |
| ---------------------------- | ------------------------------------------------------------ |
| 类的完整定义                 | ![image-20200712202313159](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200712202313159.png) |
| 类的相关说明                 | ![image-20200712202547074](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200712202547074.png) |
| 成员属性摘要                 | ![image-20200712202625302](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200712202625302.png) |
| 构造方法摘要                 | ![image-20200712202706269](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200712202706269.png) |
| 方法摘要：（不同版本有区别） | ![image-20200712202805730](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200712202805730.png) |
| 详细的说明：                 | ![image-20200712202838923](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200712202838923.png) |

文档一般都有一些”假“的中文翻译版（自动翻译版），对于这些翻译版最好别用，整个java开发涉及的文档有几十上百份，没有中文，如果现在没有习惯英文文档，以后很难进行

https://docs.oracle.com/javase/9/docs/api/java/lang/String.html



## 字符串与字符数组

在JDK1.9以前，所有String都用了字符数组进行了包装处理，所以在String类里面提供有相应的转化处理方法，包括构造方法和普通方法。

| No   | 方法名称                                           | 类型 | 描述                               |
| ---- | -------------------------------------------------- | ---- | ---------------------------------- |
| 1    | Public String(char[] value)                        | 构造 | 将换入的全部字符数组转换为字符串   |
| 2    | Public String(char[] value, int offset, int count) | 构造 | 将部分字符数组变为字符串           |
| 3    | public char charAt(int index)                      | 普通 | 获得指定索引位置的字符             |
| 4    | public char[] toCharArray()                        | 普通 | 将字符串中的数据以字符数组形式返回 |



范例：观察charAt方法

```java
public class JavaDemo { 
	public static void main(String[] args) {
		String str = "www.mldn.cn";
		char c = str.charAt(5);
		System.out.println(c);  
	}
}
```

利用charAt()可以获取某一个指定索引位置的字符，需要注意程序中下标从0开始

程序语言之中，最早一直强调的就是字符串应该使用字符数组进行描述，所以String类方法中也有提现

范例：观察字符串和字符数组的转换

```java
public class JavaDemo { 
	public static void main(String[] args) {
		String str = "helloworld";
		char [] result = str.toCharArray();//字符串变为字符数组
		for (int x = 0 ; x < result.length ; x ++ ) {
			result[x] -= 32;
		}
		//处理完的字符数组变为字符串
		String newStr = new String(result);
		System.out.println(newStr);  
		System.out.println(new String(result,0,5));  
		System.out.println(new String(result));  
	}
}
```

> HELLOWORLD
> HELLO
> HELLOWORLD

现在假设要做一个验证功能，判断一个字符串中的数据是否全部由数字所组成。这个时候可以用如下思路。

* 如果判断每一位最好将字符串变为字符数组。
* 判断没有给字符是否在'0' - '9'
* 如果有一个不符则返回false

```java
public class JavaDemo { 
	public static void main(String[] args) {
		String str = "helloworld";
		System.out.println(isNumber(str) ? "是全部由数字组成":"不是全部由数字组成");
		System.out.println(isNumber("123") ? "是全部由数字组成":"不是全部由数字组成");
	}
	//该方法主要是判断字符串是否由数字所组成
	public static boolean isNumber(String str) {
		char[] result = str.toCharArray();//字符串转字符数组
		for (int x = 0 ; x < result.length ; x ++ ) {
			if (result[x] < '0' || result[x] > '9')	{
				return false; //后面不判断
			}
		}
		return true;
	}
}
```

> 不是全部由数字组成
> 是全部由数字组成

在实际开发之中处理中文的时候往往用char类型，因为其可以包含中文数据



## 字符串与字节数组

字符串与字节数组之间也可以进行转换处理，但是需要提醒，当进行时一般是为了进行二进制数据传输或进行编码转换

| No   | 方法名称                                                     | 类型 | 描述                       |
| ---- | ------------------------------------------------------------ | ---- | -------------------------- |
| 1    | public String(byte[] bytes)                                  | 构造 | 将全部的字节数组变为字符串 |
| 2    | public String(byte[] bytes,               int offset,               int length) | 构造 | 将部分字节数组变为字符串   |
| 3    | public byte[] getBytes()                                     | 普通 | 将字符串转换为字节数组     |
| 4    | public byte[] getBytes(String charsetName)                 throws UnsupportedEncodingException | 普通 | 编码转换                   |



范例：观察字节和字符串的转换

```java
public class JavaDemo { 
	public static void main(String[] args) {
		String str = "helloworld";
		byte data[] = str.getBytes(); //将字符串变为字节数组
		for (int x = 0 ; x < data.length ; x ++ ) {
			data[x] -= 32 ;
		}
		System.out.println(new String(data));
		System.out.println(new String(data,0,5));
	}
}
```

> HELLOWORLD
> HELLO

区别：字节有长度限制，-128到127之间



## 字符串比较

最为常用的方法就是equals()，需要注意的是该方法区分大小写

```java
public class JavaDemo { 
	public static void main(String[] args) {
		String strA = "helloworld";
		String strB = "HelloWorld";
		System.out.println(strA.equals(strB));
	}
}
```

> false

还有许多其他的比较方法

| No   | 方法名称                                              | 类型 | 描述                                                         |
| ---- | ----------------------------------------------------- | ---- | ------------------------------------------------------------ |
| 1    | public boolean equals(Object anObject)，先用String    | 普通 | 区分大小写的比较判断                                         |
| 2    | public boolean equalsIgnoreCase(String anotherString) | 普通 | 不区分大小写比较                                             |
| 3    | public int compareTo(String anotherString)            | 普通 | 进行字符串大小比较。返回一个int数据（三种结果，>0 , = 0 ,<0） |
| 4    | public int compareToIgnoreCase(String str)            | 普通 | 不区分大小写进行字符串大小比较                               |

范例：忽略大小写比较

```java
public class JavaDemo { 
	public static void main(String[] args) {
		String strA = "helloworld";
		String strB = "HelloWorld";
		System.out.println(strA.equalsIgnoreCase(strB));
	}
}
```

> true

```java
public class JavaDemo { 
	public static void main(String[] args) {
		String strA = "mldn";
		String strB = "Mldn";
		System.out.println(strA.compareTo(strB));//m - M
	}
}
```

> 32

```java
public class JavaDemo { 
	public static void main(String[] args) {
		String strA = "mldn";
		String strB = "Mldn";
		System.out.println(strA.compareTo(strB));//32
System.out.println(strB.compareTo(strA));//-32
System.out.println("Hello".compareTo("Hello"));//0
System.out.println(strA.compareToIgnoreCase(strB));//0
	}
}
```

compareTo()后面还有详细解释，此方发很重要。



## 字符串查找

从一个完整的字符串之中查找子字符串的存在，就属于字符串查找操作，在String类里面一共提供有如下的几个查找方法。

contains()，1.5之后采用。之前用的indexOf

| No   | 方法名称                                                     | 类型 | 描述                               |
| ---- | ------------------------------------------------------------ | ---- | ---------------------------------- |
| 1    | public boolean contains(CharSequence s)，先用String s        | 普通 | 判断子字符串是否存在               |
| 2    | public int indexOf(String str)                               | 普通 | 从头查找字符串的位置               |
| 3    | public int indexOf(String str,                    int fromIndex) | 普通 | 从指定位置查找字符串位置           |
| 4    | public int lastIndexOf(String str)                           | 普通 | 从后向前查找字符串                 |
| 5    | public int lastIndexOf(String str,                        int fromIndex) | 普通 | 从后向前从指定位置查找字符串       |
| 6    | public boolean startsWith(String prefix)                     | 普通 | 判断是否以指定的字符串开头         |
| 7    | public boolean startsWith(String prefix,                           int toffset) | 普通 | 由指定位置判断是否以指定字符串开头 |
| 8    | public boolean endsWith(String suffix)                       | 普通 | 是否以指定字符串结尾               |

```java
public class JavaDemo { 
	public static void main(String[] args) {
		String strA = "www.mldn.cn";
		String strB = "mldn";
		System.out.println(strA.contains(strB));
		System.out.println(strA.contains("hello"));
	}
}
```

> true
>
> false

此方法相对而言比较直观，从jdk1.5以后才有的，之前需要indexOf

范例：判断字符串是否存在

```java
public class JavaDemo { 
	public static void main(String[] args) {
		String strA = "www.mldn.cn";
		String strB = "mldn";
		System.out.println(strA.indexOf(strB));
		System.out.println(strA.indexOf("hello"));
		if (strA.indexOf("mldn") != -1) {
			System.out.println("数据存在");
		}
	}
}
```

> 4
> -1
> 数据存在

indexOf()是为了进行子字符串位置的查询，在一些开发中会用到通过此方发进行索引的确认。

```java
public class JavaDemo { 
	public static void main(String[] args) {
		String strA = "www.mldn.cn";
		System.out.println(strA.lastIndexOf("."));
		if (strA.indexOf("mldn") != -1) {
			System.out.println("数据存在");
		}
	}
}
```

字符串查找时判断开头和结尾，许多设计会用到它

```java
public class JavaDemo { 
	public static void main(String[] args) {
		String strA = "**@@www.mldn.cn##";
		System.out.println(strA.startsWith("**"));
		System.out.println(strA.startsWith("@@",2));
        System.out.println(strA.endsWith("##"));
	}
}
```

> true
>
> true
>
> true



## 字符串替换

可以通过一个指定的内容进行指定字符串的替换

| No   | 方法名称                                                     | 类型 | 描述     |
| ---- | ------------------------------------------------------------ | ---- | -------- |
| 1    | public String replaceAll(String regex,                          String replacement) | 普通 | 全部替换 |
| 2    | public String replaceFirst(String regex,                            String replacement) | 普通 | 替换首个 |

范例：实现替换处理

```java
public class JavaDemo { 
	public static void main(String[] args) {
		String str = "helloworld";
		System.out.println(str.replaceAll("l","X"));
		System.out.println(str.replaceFirst("l","X"));
	}
}
```

> heXXoworXd
> heXloworld

String regex 正则表达式



## 字符串拆分

可以通过根据一个指定的字符串，或者指定表达式实现字符串的拆分，拆分的结果将通过字符串数组进行返回。



| No   | 方法名称                                                     | 类型 | 描述                                   |
| ---- | ------------------------------------------------------------ | ---- | -------------------------------------- |
| 1    | public String[] split(String regex)                          | 普通 | 按照指定字符串全部拆分                 |
| 2    | public String[] split(String regex,                       int limit) | 普通 | 按照指定字符串拆分指定个数。后面不拆了 |



范例：观察字符串拆分，全部拆分，or拆分指定个数

```java
public class JavaDemo { 
	public static void main(String[] args) {
		String str = "hello world hello mldn";
		String result [] = str.split(" ");
		String result2 [] = str.split(" ",2);

		for (int x = 0 ; x < result.length ; x ++ ) {
			System.out.println("result[" + x + "]:" + result[x] );
		}
		for (int x = 0 ; x < result2.length ; x ++ ) {
			System.out.println("result2[" + x + "]:" + result2[x] );
		}
	}
}
```

> result[0]:hello
> result[1]:world
> result[2]:hello
> result[3]:mldn
> result2[0]:hello
> result2[1]:world hello mldn

但是在进行拆分的时候有可能会遇见拆不了的情况，实际上拆不开的原因，是因为正则表达式的原因。需要使用\\\进行转移

```java
public class JavaDemo { 
	public static void main(String[] args) {
		String str = "hello.world.hello.mldn";
		String result [] = str.split(".");
		String result2 [] = str.split("\\.");

		for (int x = 0 ; x < result.length ; x ++ ) {
			System.out.println("result[" + x + "]:" + result[x] );
		}
		for (int x = 0 ; x < result2.length ; x ++ ) {
			System.out.println("result2[" + x + "]:" + result2[x] );
		}
	}
}
```

> result2[0]:hello
> result2[1]:world
> result2[2]:hello
> result2[3]:mldn

直接输入. 没拆开



## 字符串截取

从一个完整的字符串之中截取子字符串

| No   | 方法名称                                                     | 类型 | 描述                 |
| ---- | ------------------------------------------------------------ | ---- | -------------------- |
| 1    | public String substring(int beginIndex)                      | 普通 | 从指定索引截取到结尾 |
| 2    | public String substring(int beginIndex,                         int endIndex) | 普通 | 截取指定范围的字符串 |



范例：观察字符串截取操作

```java
public class JavaDemo { 
	public static void main(String[] args) {
		String str = "www.mldn.cn";
		System.out.println(str.substring(4));
		System.out.println(str.substring(4,8));
	}
}
```

> mldn.cn
> mldn

在实际开发中很多时候截取的索引是由indexOf()计算来的。

```java
public class JavaDemo { 
	public static void main(String[] args) {
		//字符串结构：“用户id-photo-姓名.后缀”
		String str = "admin-photo-张三.jpg";
		int beginIndex = str.indexOf("-",str.indexOf("photo")) + 1;
		int beginIndex2 = str.lastIndexOf("-") + 1;
		int endIndex = str.lastIndexOf(".");
		System.out.println(str.substring(beginIndex2,endIndex));
	}
}
```

> 张三

以后实际开发中用计算确定索引的情况非常常见



## 字符串格式化

从JDK1.5开始，为了吸引更多的传统开发人员，Java提供了格式化数据的处理方式，参考c语言的格式化输出语句，可以利用占位符实现数据的输出，占位符常用的：字符串(%s)，字符(%c)，整数(%d)，小数(%f)



| No   | 方法名称                                                     | 类型 | 描述                               |
| ---- | ------------------------------------------------------------ | ---- | ---------------------------------- |
| 1    | public static String format(String format,                             Object... args)，先写成String...args | 静态 | 根据指定的结构，进行文本格式化显示 |

范例：观察格式化字符串

```java
public class JavaDemo { 
	public static void main(String[] args) {
		String name = "张三";
		int age = 18 ;
		double score = 98.76543;
		String str = String.format("姓名: %s、年龄：%d、成绩：%5.2f",name,age,score);
		System.out.println(str);
	}
}
```

> 姓名: 张三、年龄：18、成绩：98.77

这个输出操作是java的附加功能



## 其他操作方法

| No   | 方法名称                         | 类型 | 描述                       |
| ---- | -------------------------------- | ---- | -------------------------- |
| 1    | public String concat(String str) | 普通 | 描述的就是字符串的连接     |
| 2    | public String intern()           | 普通 | 字符串入池                 |
| 3    | public boolean isEmpty()         | 普通 | 是否为空字符串""，不是null |
| 4    | public int length()              | 普通 | 计算字符串长度             |
| 5    | public String trim()             | 普通 | 去除左右的空格             |
| 6    | public String toUpperCase()      | 普通 | 转大写                     |
| 7    | public String toLowerCase()      | 普通 | 转小写                     |

### 范例：观察字符串的连接

```java
public class JavaDemo { 
	public static void main(String[] args) {
		String strA = "www.mldn.cn";
		String strB = "www.".concat("mldn").concat(".cn");
		System.out.println(strA);
		System.out.println(strB);
		System.out.println(strA == strB);
	}
}
```

> www.mldn.cn
> www.mldn.cn
> false

虽然从整体运行结果来讲，内容相同，但是最后输出false，说明是运行时的操作，和+效果不一样。

### 范例：判断空字符串，一定要在有实例化对象的时候运行

```java
public class JavaDemo { 
	public static void main(String[] args) {
		String strA = "";
		String strB = null;
		System.out.println(strA.isEmpty());
		System.out.println("123".isEmpty());
		System.out.println(strB.isEmpty());
	}
}
```

> true
> false
> Exception in thread "main" java.lang.NullPointerException
>         at JavaDemo.main(JavaDemo.java:7)

### 范例：观察length()与trim()

```java
public class JavaDemo { 
	public static void main(String[] args) {
		String strA = "   Hello World     ";
		System.out.println(strA.length()); //19
		String trimStr = strA.trim();
	System.out.println(trimStr.length());  //11
	}
}
```

在进行一些数据输入的时候，很难保证输入数据没有空格， 有空格时可能会导致匹配失败，所以会遇到trim()

注意trim()不会消除中间空格

关于length()，数组也有length，但是没有括号。是数组的属性

### 范例：观察大小写转换

注意这种转换的特征是可以避免非字母的转换

```java
public class JavaDemo { 
	public static void main(String[] args) {
		String strA = "   Hello World!!! ";
		System.out.println(strA.toLowerCase());
		System.out.println(strA.toUpperCase());
	}
}
```

>    hello world!!!
>    HELLO WORLD!!!

注意，String类里面没有首字母大写的方法，这个方法可以有开发者自行谁实现，利用方法的组合。

### 范例：实现首字母大写的转换

```java
class StringUtil {
	public static String initcap(String str) {
		if (str == null || "".equals(str)) {
			return str; //原样返回
		}
		if (str.length() == 1) {
			return str.toUpperCase();
		}
		return str.substring(0,1).toUpperCase() + str.substring(1);
	}
}


public class JavaDemo { 
	public static void main(String[] args) {
		System.out.println(StringUtil.initcap("hello"));
		System.out.println(StringUtil.initcap("m"));
	}
}
```

> Hello
> M



# 第12章：继承的定义与使用

面向对象的第二大特征就是继承性，继承性的主要特点，就是扩展已有类的功能。

## 继承问题引出

所谓的良好代码指的是结构性合理、适合于维护、可重用性很高，但是如果现在如果只是按照之前所学习的概念进行定义，不可避免的面对重复问题，下面定义两个类：人类、学生类

| 人类类                                                       | 学生类                                                       |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| class Pesron {<br/>	private String name;<br/>	private int age;<br/>	public Person(String name,int age) {<br/>		this.name = name ;<br/>		this.age = age;<br/>	}<br/>	<br/>	//setter\getter\无参构造略<br/>} | class Student {<br/>	private String name;<br/>	private int age;<br/>	private String school;<br/>	public Student(String name,int age,String school) {<br/>		this.name = name ;<br/>		this.age = age;<br/>		this.school = school;<br/>	}<br/>	<br/>	//setter\getter\无参构造略<br/>} |

发现了虽然类的概念可以解决结构性问题，但是对于之前的开发的程序代码总能够发现有一些重复代码的出现。在程序之中，并且可以进一步思考关系：学生是一个人，人是一个更广泛的定义，从另外一个角度，学生之中应该包含有人的所有特点。

如果想要类的代码重用，就必须用继承的概念，在已有类上进行扩充。



## 继承的实现

如果在Java程序之中需要实现继承关系，就需要使用extends关键字

> class 子类 extends 父类 {}

特别需要注意的是，很多情况下会把子类称为派生类，父类称为超类（SuperClass）

```java
class Person {
	private String name;
	private int age;
	public Person(String name,int age) {
		this.name = name ;
		this.age = age;
	}

	public Person() {
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return this.name;
	}

	public int getAge() {
		return this.age;
	}
}

class Student extends Person{

	//在子类之中不定义任何功能
}

public class JavaDemo { 
	public static void main(String[] args) {

	Student stu = new Student();
	stu.setName("林大强"); //父类定义的方法
	stu.setAge(38);  //父类定义的方法
	System.out.println("姓名：" + stu.getName() + "、年龄：" + stu.getAge());
	}
}
```

> 姓名：林大强、年龄：38

由于此时存在继承关系，所以此时子类即便没有任何操作，也可以直接通过父类继承而来的方法实现操作。

继承操作的内存并无特殊，这里做一下分析。

![image-20200713213306025](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200713213306025.png)

继承的本质应该是已有功能上的扩充。

继承实现的主要目的是子类可以重用父类重点结构，并且也可以实现功能的扩充。

实例：子类扩充定义

```java
class Person {
	private String name;
	private int age;
	public Person(String name,int age) {
		this.name = name ;
		this.age = age;
	}

	public Person() {
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return this.name;
	}

	public int getAge() {
		return this.age;
	}
}

class Student extends Person{//Student是子类
	private String school;
	public void setSchool(String school) {
		this.school = school;
	}

	public String getSchool() {
		return this.school;
	}
}

public class JavaDemo { 
	public static void main(String[] args) {

	Student stu = new Student();
	stu.setName("林大强"); //父类定义的方法
	stu.setAge(38);  //父类定义的方法
	stu.setSchool("家里蹲大学");//子类定义的方向
	System.out.println("姓名：" + stu.getName() + "、年龄：" + stu.getAge() + "、学校：" + stu.getSchool());
	}
}
```

> 姓名：林大强、年龄：38、学校：家里蹲大学

如果继续讨论内存变换，则会出现父类核子类两个内存范围

![image-20200713213904932](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200713213904932.png)



## 子类对象实例化流程

一旦程序之中提供有继承逻辑，那么对于子类的对象的实例化定义是有要求的。从正常的社会逻辑：没有老子一定没有儿子，对于继承程序的逻辑也是一样的。在进行子类对象实例化的时候，一定要首先实例化好父类对象。

```java
class Person {

	public Person() {
		System.out.println("【Person父类】一个新的Person父类实例化对象产生了");
	}
}

class Student extends Person{//Student是子类
	public Student() {//构造方法
		System.out.println("【Student子类】一个新的Student实例化对象产生了");
	}
}

public class JavaDemo { 
	public static void main(String[] args) {
		new Student();
	}
}
```

> 【Person父类】一个新的Person父类实例化对象产生了
> 【Student子类】一个新的Student实例化对象产生了

现在即使没有进行父类对象实例化，也会由系统自动调用父类的构造方法（实例化了父类对象），默认情况下子类对象实例化流程，会自动实例化父类对象。实际上这个时候相当于子类的构造方法中隐藏了一个super();构造语句。写不写都一样

```java
class Person {

	public Person() {
		System.out.println("【Person父类】一个新的Person父类实例化对象产生了");
	}
}

class Student extends Person{//Student是子类
	public Student() {//构造方法
		super();
		System.out.println("【Student子类】一个新的Student实例化对象产生了");
	}
}

public class JavaDemo { 
	public static void main(String[] args) {
		new Student();
	}
}
```

super()表示的就是子类构造调用父类构造的语句，该语句只允许放在子类构造方法的第一行。

在默认情况下的实例化处理，子类只会调用父类的无参构造方法，写与不写super()区别不大。

但是如果父类没有无参构造方法（非简单Java类），则子类必须要通过super()明确调用有参构造。

范例：观察super使用

```java
class Person {
	private String name;
	private int age;
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
		System.out.println("【Person父类】一个新的Person父类实例化对象产生了");
	}
}

class Student extends Person{//Student是子类
}

public class JavaDemo { 
	public static void main(String[] args) {
		new Student();
	}
}
```

> JavaDemo.java:11: 错误: 无法将类 Person中的构造器 Person应用到给定类型;
> class Student extends Person{//Student是子类
> ^
>   需要: String,int
>   找到:    没有参数
>   原因: 实际参数列表和形式参数列表长度不同
> 1 个错误

找不到默认的父类无参构造，所以报错

```java
class Person {
	private String name;
	private int age;
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
		System.out.println("【Person父类】一个新的Person父类实例化对象产生了");
	}
}

class Student extends Person{//Student是子类
	private String school;
	public Student(String name, int age, String school) {//构造方法
		super(name,age);//明确调父类构造
		this.school = school;
		System.out.println("【Student子类】一个新的Student子类实例化对象产生了");
	}
}

public class JavaDemo { 
	public static void main(String[] args) {
		new Student("林小强",22,"北京大学");
	}
}
```

> 【Person父类】一个新的Person父类实例化对象产生了
> 【Student子类】一个新的Student子类实例化对象产生 了

所以一定要有习惯，定义类时写无参构造。

结论：无论如何折腾，实例化子类时一定会先实例化父类

```java
class Person {
	private String name;
	private int age;
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
		System.out.println("【Person父类】一个新的Person父类实例化对象产生了");
	}
}

class Student extends Person{//Student是子类
	private String school;
	public Student(String name, int age, String school) {//构造方法
		this(name,age);//明确调父类构造
		this.school = school;
		System.out.println("【Student子类】一个新的Student子类实例化对象产生了");
	}

	public Student(String name, int age) {
	}
}

public class JavaDemo { 
	public static void main(String[] args) {
		new Student("林小强",22,"北京大学");
	}
}
```

> JavaDemo.java:19: 错误: 无法将类 Person中的构造器 Person应用到给定类型;
>         public Student(String name, int age) {
>                                              ^
>   需要: String,int
>   找到:    没有参数
>   原因: 实际参数列表和形式参数列表长度不同
> 1 个错误

```java
class Person {
	private String name;
	private int age;
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
		System.out.println("【Person父类】一个新的Person父类实例化对象产生了");
	}
}

class Student extends Person{//Student是子类
	private String school;
	public Student(String name, int age, String school) {//构造方法
		this(name,age);//明确调父类构造
		this.school = school;
		System.out.println("【Student子类】一个新的Student子类实例化对象产生了");
	}

	public Student(String name, int age) {
		super(name,age);
	}
}

public class JavaDemo { 
	public static void main(String[] args) {
		new Student("林小强",22,"北京大学");
	}
}
```

> 通过

使用构造方法时，一定要留出口，用来调用父类的构造方法。

super和this都可以调用构造方法，而且都出现在首行，用调用父类和本类的构造方法。但是不允许同一个方法中出现



## 继承定义限制

对于继承的一些要求：

### 1.Java之中不允许多重继承，只允许多层继承。

* 在实际的生活之中一个人只会由一个亲爹，程序也有此逻辑

* | 多重继承                                                     | 多层继承                                                     |
  | ------------------------------------------------------------ | ------------------------------------------------------------ |
  | class A {}<br/>class B {}<br/>class C extends A,B{} //多重继承<br/><br/> | class A {}<br/>class B extends A{}<br/>class C extends B{} //多重继承<br/><br/> |
  | 语法错误                                                     | 语法正确                                                     |

  

* 继承的目的时扩展已有类的功能，但是多重继承目的是希望同时继承多个类中的方法，而面对于多继承的要求，应该将范围限定于同一类之中。

* 利用多层继承，C类同样可以继承多个父类的操作。

* 多重继承也要有个限度，不要继承太多层！！

* 对于继承关系，如果是自己写的代码，理论上层次不应该超过三层。

### 2.在进行继承关系定义时，实际上子类可以继承父类中所有的操作结构

* 对于私有操作属于隐式继承。所有非私有方法属于显示继承。

* ```java
  class Person {
  	private String name;
  	public void setName(String name) {
  		this.name = name;
  	}
  	public String getName() {
  		return this.name;
  	}
  
  }
  class Student extends Person {
  	public void fun() {
  		System.out.println(name);
  	}
  }
  
  public class JavaDemo { 
  	public static void main(String[] args) {
  	}
  }
  ```

  > JavaDemo.java:13: 错误: name 在 Person 中是 private 访问控制
  >                 System.out.println(name);
  >                                    ^
  > 1 个错误

  直接访问不可能

* ```java
  class Student extends Person {
  	public void fun() {
  		System.out.println(getName()); //间接访问
  	}
  }
  ```

  间接访问可以

* ```java
  class Person {
  	private String name;
  	public void setName(String name) {
  		this.name = name;
  	}
  	public String getName() {
  		return this.name;
  	}
  
  }
  class Student extends Person {
  	public Student(String name) {
  		setName(name);   //设置name属性内容
  	}
  	public void fun() {
  		System.out.println(getName()); //间接访问
  	}
  }
  
  public class JavaDemo { 
  	public static void main(String[] args) {
  		Student stu = new Student("林四");
  		stu.fun();
  	}
  }
  ```

  > 林四

  能执行setName，说明子类也有name属性，但是也是private

* 继承一旦发生了，所有的操作就可以被子类使用了。在程序设计中没有考虑到败家子的情况，子类至少会维持父类的现有功能。



# 第13章：覆写

## 方法覆写

子类与父类一旦产生了继承关系后，子类继承父类中的全部定义，但是这里面也可能出现不合适的情况。如果子类发现了父类中的设计不足，而且需要保留有父类中的方法或者属性名称的情况下就会产生覆写操作。

### 方法的覆写：

当子类定义了与父类方法名称相同，参数类型及个数完全相同（与父类方法一模一样），就称为方法的覆写

**调用父类方法**

```java
class Channel {
    public void connect() {
        System.out.println("【Channel父类】进行资源的连接。");
    }
}

class DatabaseChannel extends Channel {
    //要进行数据库连接
    public void connect() {
        System.out.println("【子类】进行数据库资源的连接。");
    }
}

public class JavaDemo {
    public static void main(String[] args) {
        Channel channel = new Channel();
        channel.connect();
    }
}
```



**实例化子类**

```java
class Channel {
    public void connect() {
        System.out.println("【Channel父类】进行资源的连接。");
    }
}

class DatabaseChannel extends Channel {
    //要进行数据库连接
    public void connect() {
        System.out.println("【子类】进行数据库资源的连接。");
    }
}

public class JavaDemo {
    public static void main(String[] args) {
        DatabaseChannel channel = new DatabaseChannel();
        channel.connect();
    }
}
```

> 【子类】进行数据库资源的连接。

现在实例化的是子类对象，所以此时调用的方法一定是被子类所覆写过的方法，如果该方法没有被覆写过，则调用父类的方法。

方法覆写的目的：优化父类方法的功能

![image-20200720212836318](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200720212836318.png)



在子类进行方法覆写之后，如果现在继续想要调用父类方法，则必须使用super.方法()

**错误示范**

```java
class Channel {
    public void connect() {
        System.out.println("【Channel父类】进行资源的连接。");
    }
}

class DatabaseChannel extends Channel {
    //要进行数据库连接
    public void connect() {
        connect();//想调用父类方法
        System.out.println("【子类】进行数据库资源的连接。");
    }
}

public class JavaDemo {
    public static void main(String[] args) {
        DatabaseChannel channel = new DatabaseChannel();
        channel.connect();
    }
}
```

> Exception in thread "main" java.lang.StackOverflowError
> 	at DatabaseChannel.connect(JavaDemo.java:10)
> 	at DatabaseChannel.connect(JavaDemo.java:10)

死循环了。因为默认不写的话connect()表示的是this.connect()，即从本类先找该方法。

加super.connect()，调用父类方法。

```java
class Channel {
    public void connect() {
        System.out.println("【Channel父类】进行资源的连接。");
    }
}

class DatabaseChannel extends Channel {
    //要进行数据库连接
    public void connect() {
        super.connect();//想调用父类方法
        System.out.println("【子类】进行数据库资源的连接。");
    }
}

public class JavaDemo {
    public static void main(String[] args) {
        DatabaseChannel channel = new DatabaseChannel();
        channel.connect();
    }
}
```

> 【Channel父类】进行资源的连接。
> 【子类】进行数据库资源的连接。



## 方法覆写的限制。

虽然利用方法的覆写可以更好的扩充父类的功能，但是对于覆写也是有其自身要求的：被覆写的方法不能拥有比父类方法更严格的访问控制权限。

* 对于现在的访问控制权限已经有三种：public>default(声明时不写)>private;private权限最小。

* 如果父类中的方法此时用了default定义，那么子类定义该方法时只能使用public或者default；
* 如果父类中的方法此时用了public定义，那么子类中的该方法只能够使用public定义。

范例：观察错误的覆写。

```java
class Channel {
    public void connect() {
        System.out.println("【Channel父类】进行资源的连接。");
    }
}

class DatabaseChannel extends Channel {
    //要进行数据库连接
    void connect() {
        super.connect();//想调用父类方法
        System.out.println("【子类】进行数据库资源的连接。");
    }
}

public class JavaDemo {
    public static void main(String[] args) {
        DatabaseChannel channel = new DatabaseChannel();
        channel.connect();
    }
}
```

> JavaDemo.java:9: 错误: DatabaseChannel中的connect()无法覆盖Channel中的connect()
>     void connect() {
>          ^
>   正在尝试分配更低的访问权限; 以前为public
> 1 个错误

父类public，子类default，更严格了，所以×

但是既然说到了权限问题，就必须要考虑private问题。

**范例：观察this和private**

```java
class Channel {
    public void connect() {
        System.out.println("【Channel父类】进行资源的连接。");
    }

    public void fun(){
        this.connect();    //调用本类方法
    }
}

class DatabaseChannel extends Channel {
    //要进行数据库连接

}

public class JavaDemo {
    public static void main(String[] args) {
        DatabaseChannel channel = new DatabaseChannel();
        channel.fun();
    }
}
```

> 【Channel父类】进行资源的连接。

此时子类没有connect方法，this调用的父类的connect方法

```java
class Channel {
    public void connect() {
        System.out.println("【Channel父类】进行资源的连接。");
    }

    public void fun(){
        this.connect();    //调用本类方法
    }
}

class DatabaseChannel extends Channel {
    //要进行数据库连接
    public void connect() {
        System.out.println("【子类】进行数据库资源的连接。");
    }
}

public class JavaDemo {
    public static void main(String[] args) {
        DatabaseChannel channel = new DatabaseChannel();
        channel.fun();
    }
}
```

> 【子类】进行数据库资源的连接。

此时子类覆写了（也有connect方法），因为实例化的子类，所以this指代的是子类。

如果父类的方法是private

```java
class Channel {
    private void connect() {
        System.out.println("【Channel父类】进行资源的连接。");
    }

    public void fun(){
        this.connect();    //调用本类方法
    }
}

class DatabaseChannel extends Channel {
    //此时并不是一个覆写，因为父类的connect()方法不可见，那么这个方法对于子类而言就是一个新定义的方法，与覆写没关系
    public void connect() {
        System.out.println("【子类】进行数据库资源的连接。");
    }
}

public class JavaDemo {
    public static void main(String[] args) {
        DatabaseChannel channel = new DatabaseChannel();
        channel.fun();
    }
}
```

> 【Channel父类】进行资源的连接。

因为父类是private方法，没有实现覆写，所以调用的是父类的方法。

**private方法不涉及覆写！！！！**

在以后实际开发中只要是定义方法，95%都是public，所以覆写的方法也是public

**Q:请解释Override和Overloading的区别？Overloading时，返回类型是否相同**

| No   | 区别     | OverLoading                          | Override                             |
| ---- | -------- | ------------------------------------ | ------------------------------------ |
| 1    | 中文含义 | 重载                                 | 覆写                                 |
| 2    | 概念     | 方法名称相同，参数的类型及个数不相同 | 方法名称、参数类型及个数、返回值相同 |
| 3    | 访问权限 | 没有权限控制                         | 被覆写方法不能拥有更严格的控制权限   |
| 4    | 范围     | 发生在一个类中                       | 发生在继承关系类中                   |

在Overloading时并没有对返回类型做限制，但是一般用作相同的返回类型。



## 属性覆盖

当子类定义了与子类相同名称的成员时候，就成为属性覆盖

观察属性覆盖

```java
class Channel {
    String info = "www.mldn.cn";
}

class DatabaseChannel extends Channel {
    String info = "HelloMLDN";
    public void fun() {
        System.out.println(this.info);
    }
}

public class JavaDemo {
    public static void main(String[] args) {
        DatabaseChannel channel = new DatabaseChannel();
        channel.fun();
    }
}
```

> HelloMLDN

如果想要获得父类的info，则使用println(super.info)

以上实现的前提条件时没有封装，如果封装了，则不能用super.info

```java
class Channel {
    private String info = "www.mldn.cn";
    public String getInfo() {
        return this.info;
    }
}

class DatabaseChannel extends Channel {
    String info = "HelloMLDN";
    public void fun() {
        System.out.println(this.info);
        System.out.println(super.getInfo());
    }
}

public class JavaDemo {
    public static void main(String[] args) {
        DatabaseChannel channel = new DatabaseChannel();
        channel.fun();
    }
}
```

> HelloMLDN
> www.mldn.cn

这是一个就近取用的过程，因为private不能被覆写，所以只能取到父类的info属性。

如果属性被封装了，则子类的同名属性只能看作一个同名新属性，属性覆盖就没有意义了

**Q：请解释super与this的区别**

* 在程序类中使用this，表示先从本类查找所需要的属性或方法，如果本类不存在，则查找父类定义；如果使用super则表示不查找子类，直接查找父类
* this与super都可以进行构造方法的调用，但是this()调用的时本类构造，而super()是由子类调用父类构造，两个语句都要放在构造方法的首行，所以不能同时出现
* this可以表示当前对象



## final关键字

final在程序之中描述的是种终接器的概念，在Java里面使用final关键字可以实现如下功能：定义不能被继承的类，定义不能被覆写的方法

```java
final class Channel {//这个类不能够有子类
}

class DatabaseChannel extends Channel {//无法继承
}

public class JavaDemo {
    public static void main(String[] args) {
        DatabaseChannel channel = new DatabaseChannel();
    }
}
```

> JavaDemo.java:4: 错误: 无法从最终Channel进行继承
> class DatabaseChannel extends Channel {//无法继承
>                          ^
> 1 个错误



当子类继承了父类后，是可以进行父类中的方法覆写的，如果不想方法被子类覆写，可以用final来定义

```java
class Channel {
    public final void connect() {}//这方法不能被覆写
}

class DatabaseChannel extends Channel {
    //无法覆写
    public void connect() {}
}

public class JavaDemo {
    public static void main(String[] args) {
        DatabaseChannel channel = new DatabaseChannel();
    }
}
```

> JavaDemo.java:7: 错误: DatabaseChannel中的connect()无法覆盖Channel中的connect()
>     public void connect() {}
>                 ^
>   被覆盖的方法为final
> 1 个错误

在有一些系统开发之中，可能使用1表示开关打开，使用0表示开关关闭，但是如果要是直接操作0或者是1，就会造成混乱，所以需要一些名称来操作0或者1。在final应用里很重要的一个就是来定义常量，常量的内容一旦定义则不可修改。

```java
class Channel {
    private final int ON = 1;//ON是常量 
    private final int OFF = 0;//OFF是常量 
}
```

常量往往都是公共的定义，所以一般都用公共的，共享的。public static

```java
class Channel {
    public static final int ON = 1;//ON是常量 
    public static final int OFF = 0;//OFF是常量 
}
```

在定义全局常量的时候每一个字母必须答大写表示

范例：观察程序

```java
public class JavaDemo {
    public static void main(String[] args) {
        String info = "mldn";
        String strA = "www.mldn.cn";
        String strB = "www." + info + ".cn";
        System.out.println(strA == strB);
    }
}
```

> false

如果加上final？

```java
public class JavaDemo {
    public static void main(String[] args) {
        final String info = "mldn";
        String strA = "www.mldn.cn";
        String strB = "www." + info + ".cn";
        System.out.println(strA == strB);
    }
}
```

> true

如果加上final，info就是常量了

在方法的时候，也可以使用final来定义参数，此时也表示一个常量的概念。



# 第14章：综合案例：继承分析

下面通过几个简短的程序要求对于继承的概念进行巩固，对于程序开发而言，简单Java类是最基础的组成，也是所有概念最简单的融合。

## 案例分析一：学生类

![image-20200721151138825](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200721151138825.png)

正常来讲进行一个程序类开发的时候是不需要去考虑子类的问题的，也就是说你现在需要做的只是对程序功能的完善定义。

先定义person类

```java
class Person {
    private String name;
    private String addr;
    private char sex;
    private int age;
    public Person() {}
    public Person(String name, String addr) {
        this(name,addr,'男',0);
    }

    public Person(String name,String addr,char sex,int age) {
        this.name = name;
        this.addr = addr;
        this.sex = sex;
        this.age = age;    
    }
    public String getInfo() {
        return "姓名：" + this.name + "、地址：" + this. addr + "、性别：" 
        + this.sex + "、年龄：" + this.age; 
    }
}

class Student extends Person {
    private double math;
    private double english;
    public Student() {}
    public Student(String name,String addr,char sex,int age,double math,double english) {
        super(name,addr,sex,age);
        this.math = math;
        this.english = english;
    }
    public String getInfo() {
        return super.getInfo() + "、数学成绩" + this.math + "、英语成绩：" + this.english;
    }
}


public class JavaDemo {
    public static void main (String[] args) {
        Student stu = new Student("张三","天安门",'男',12,78.99,89.98);
        System.out.println(stu.getInfo());  
    }
}
```

> 姓名：张三、地址：天安门、性别：男、年龄：12、数学成绩78.99、英语成绩：89.98

对象构造，方法实例化，方法覆写



## 案例分析二：管理人员与职员

![image-20200721155333004](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200721155333004.png)

```java
class Employee {
    private String name;
    private int age;
    private String sex;
    public Employee() {}
    public Employee(String name,int age,String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
    public String getInfo() {
        return "姓名：" + this.name + "、年龄：" + this.age + "、性别：" + this.sex;
    }
}

class Manager extends Employee {//管理层
    private String job;
    private double income;
    public Manager() {}
    public Manager(String name,int age,String sex,String job,double income) {
        super(name,age,sex);
        this.job = job;
        this.income = income;
    }
    public String getInfo() {
        return "【管理层】" + super.getInfo() + "、职位：" + this.job + "、收入：" + this.income;
    }
}

class Staff extends Employee {
    private String dept;
    private double salary;
    public Staff() {}
    public Staff(String name,int age,String sex,String dept,double salary) {
        super(name,age,sex);
        this.dept = dept;
        this.salary = salary;
    }
    public String getInfo() {
        return "【职员】" + super.getInfo() + "、部门：" + this.dept + "、薪水：" + this.salary;
    }
}

public class JavaDemo {
    public static void main (String[] args) {
        Manager man = new Manager("张三",38,"女","主管",150000.00);
        Staff stu = new Staff("李四",18,"男","出纳",3000.00);
        System.out.println(man.getInfo());
        System.out.println(stu.getInfo());
    }
}
```

> 【管理层】姓名：张三、年龄：38、性别：女、职位：主管、收入：150000.0
> 【职员】姓名：李四、年龄：18、性别：男、部门：出纳、薪水：3000.0



## 案例分析三：字符串统计

![image-20200721163328413](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200721163328413.png)

对于本程序而言，最简单的操作方式就是直接定义再主方法里面定义一个操作，或者直接定义一个新的类进行处理

范例：定义一个单独的处理类

```java
class StringUtil {
    //返回的第一个内容为字母n的个数，第二个内容为字母o的个数
    public static int [] count(String str) {
        int countData [] = new int[2];
        char [] data = str.toCharArray(); //将字符串变为字符数组
        for (int x = 0; x < data.length ; x ++) {
            if(data[x] == 'n' || data[x] == 'N') {
                countData[0] ++ ;
            }
            if(data[x] == 'o' || data[x] == 'O') {
                countData[1] ++ ;
            }
        }
        return countData;
    }

}

public class JavaDemo {
    public static void main (String[] args) {
        String str = "want you to know one thing";
        int result [] = StringUtil.count(str);
        System.out.println("字母n的个数：" + result[0]);
        System.out.println("字母o的个数：" + result[1]);
    }
}
```

> 字母n的个数：4
> 字母o的个数：4

以上的解决方案只是一种顺序式的思维模式解决的，但是以后可能有其他的统计需要。

![image-20200721165403427](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200721165403427.png)

```java
class StringUtil {
    private String content; //需要保存字符串
    public StringUtil(String content) {
        this.content = content;
    }
    public String getContent() {
        return this.content;
    }
    public String getInfo() {
        return this.getContent();
    }
}
class StringCount extends StringUtil {
    private int nCount;
    private int oCount;
    public StringCount(String content) {
        super(content);
        this.countChar(); //构造方法统计
    }
    public void countChar() {
        char [] data = super.getContent().toCharArray(); //将字符串变为字符数组
        for (int x = 0; x < data.length ; x ++) {
            if(data[x] == 'n' || data[x] == 'N') {
                this.nCount ++ ;
            }
            if(data[x] == 'o' || data[x] == 'O') {
                this.oCount ++ ;
            }
        }
    }
    public int getNCount() {
        return this.nCount;
    }
    public int getOCount() {
        return this.oCount;
    }
    public String getInfo() {
        return "字母n的个数：" + this.nCount + "、字母o的个数：" + this.oCount;
    }

}

public class JavaDemo {
    public static void main (String[] args) {
        StringCount sc = new StringCount("want you to know one thing");
        System.out.println(sc.getInfo());
    }
}
```

> 字母n的个数：4、字母o的个数：4

第二种利用面向对象的方案来解决。第一种方案更加直观





## 案例分析四：数组操作

![image-20200721170730090](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200721170730090.png)

对于本程序而言，首先要考虑的是父类如何定义

```java
class Array {//数组的操作类
    private int [] data; //整型数组
    private int foot; //进行数组索引控制
    public Array(int len) {
        if (len > 0) {
            this.data = new int [len]; //开辟数组
        } else {
            this.data = new int [1];//开辟一个空间
        }
    }
    //数组容量扩充，给出的扩充大小，实际大小：已有大小+ 扩充大小
    public void increment(int num) {
        int newData [] = new int [this.data.length + num];
        System.arraycopy(this.data,0,newData,0,this.data.length);
        this.data = newData;
    }
    public boolean add(int num) {//数据增加
        if(this.foot < this.data.length) {
            this.data[this.foot ++ ] = num;
            return true;
        }
        return false;
    }
    public int [] getData() {
        return this.data;
    }
}

public class JavaDemo {
    public static void main (String[] args) {
        Array arr = new Array(5);
        System.out.println(arr.add(10));
        System.out.println(arr.add(5));
        System.out.println(arr.add(20));
        System.out.println(arr.add(3));
        System.out.println(arr.add(6));
        arr.increment(3);
        System.out.println(arr.add(15));
        System.out.println(arr.add(1));
        System.out.println(arr.add(7));
    }
}
```

第一步：实现基本的数组操作类定义，插入和扩充的实现。

第二步：排序子类的定义

```java
class Array {//数组的操作类
    private int [] data; //整型数组
    private int foot; //进行数组索引控制
    public Array(int len) {
        if (len > 0) {
            this.data = new int [len]; //开辟数组
        } else {
            this.data = new int [1];//开辟一个空间
        }
    }
    //数组容量扩充，给出的扩充大小，实际大小：已有大小+ 扩充大小
    public void increment(int num) {
        int newData [] = new int [this.data.length + num];
        System.arraycopy(this.data,0,newData,0,this.data.length);
        this.data = newData;
    }
    public boolean add(int num) {//数据增加
        if(this.foot < this.data.length) {
            this.data[this.foot ++ ] = num;
            return true;
        }
        return false;
    }
    public int [] getData() {
        return this.data;
    }
}

class SortArray extends Array {//定义排序子类
    public SortArray(int len) {
        super(len);
    }
    public int [] getData() { //获得排序结果
        java.util.Arrays.sort(super.getData());  //排序
        return super.getData();
    }
}

public class JavaDemo {
    public static void main (String[] args) {
        SortArray arr = new SortArray(5);
        System.out.println(arr.add(10));
        System.out.println(arr.add(5));
        System.out.println(arr.add(20));
        System.out.println(arr.add(3));
        System.out.println(arr.add(6));
        arr.increment(3);
        System.out.println(arr.add(15));
        System.out.println(arr.add(1));
        System.out.println(arr.add(7));
        int result [] = arr.getData();
        for (int temp : result) {
            System.out.print(temp + "、");
        }
    }
}
```

> true
> true
> true
> true
> true
> true
> true
> true
> 1、3、5、6、7、10、15、20、

第三步：定义反转子类

```java
class Array {//数组的操作类
    private int [] data; //整型数组
    private int foot; //进行数组索引控制
    public Array(int len) {
        if (len > 0) {
            this.data = new int [len]; //开辟数组
        } else {
            this.data = new int [1];//开辟一个空间
        }
    }
    //数组容量扩充，给出的扩充大小，实际大小：已有大小+ 扩充大小
    public void increment(int num) {
        int newData [] = new int [this.data.length + num];
        System.arraycopy(this.data,0,newData,0,this.data.length);
        this.data = newData;
    }
    public boolean add(int num) {//数据增加
        if(this.foot < this.data.length) {
            this.data[this.foot ++ ] = num;
            return true;
        }
        return false;
    }
    public int [] getData() {
        return this.data;
    }
}

class SortArray extends Array {//定义排序子类
    public SortArray(int len) {
        super(len);
    }
    public int [] getData() { //获得排序结果
        java.util.Arrays.sort(super.getData());  //排序
        return super.getData();
    }
}

class ReverseArray extends Array {//定义反转子类
    public ReverseArray(int len) {
        super(len);
    }
    public int [] getData() { //获得反转结果
        int center = super.getData().length / 2;
        int head = 0;
        int tail = super.getData().length - 1;
        for (int x = 0 ; x < center ; x ++) {
            int temp = super.getData()[head];
            super.getData()[head] = super.getData()[tail];
            super.getData()[tail] = temp;
            head ++;
            tail --;
        }

        return super.getData();
    }
}

public class JavaDemo {
    public static void main (String[] args) {
        ReverseArray arr = new ReverseArray(5);
        System.out.println(arr.add(10));
        System.out.println(arr.add(5));
        System.out.println(arr.add(20));
        System.out.println(arr.add(3));
        System.out.println(arr.add(6));
        arr.increment(3);
        System.out.println(arr.add(15));
        System.out.println(arr.add(1));
        System.out.println(arr.add(7));
        int result [] = arr.getData();
        for (int temp : result) {
            System.out.print(temp + "、");
        }
    }
}
```

> true
> true
> true
> true
> true
> true
> true
> true
> 7、1、15、6、3、20、5、10、

父类中定义的方法名称往往很重要，所以子类在定义方法时，一般优先覆写父类方法。



**Q：Test.main()函数执行后的输出是（ ）？？**

```java
class Test {
    public static void main(String[] args) {
        System.out.println(new B().getValue());
    }
    static class A {
        protected int value;
        public A (int v) {
            setValue(v);
        }
        public void setValue(int value) {
            this.value= value;
        }
        public int getValue() {
            try {
                value ++;
                return value;
            } finally {
                this.setValue(value);
                System.out.println(value);
            }
        }
    }
    static class B extends A {
        public B () {
            super(5);
            setValue(getValue()- 3);
        }
        public void setValue(int value) {
            super.setValue(2 * value);
        }
    }
}

A、6 7 7

B、22 34 17

C、22 74 74

D、11 17 34
```

> B

> ```java
> 1.b = new B();
> 2.public B() {}super(5);
> 3.b.setValue(5) **当前子类的方法**
> 4.super.setValue(10)
> 5.value = 10
> 6.public B() {}getValue()
> 7.super.getValue()
> 8.value++ == 11
> 9.(1) return value = 11; --> getValue()-3 = 8
> (2) b.setValue(11);
>    super.setValue(22)
>    value = 22;
>    sout(22)；
> 10.b.setValue(8)
> 11.super.setValue(16);
> 12.value = 16
> 13.x = b.getValue();
> 14.value++ == 17
> 15.(1) return value = 17; --> x = 17
> (2) b.setValue(17);
>     super.setValue(34);
>     value = 34;
>     sout(34)
> 16.sout(x)   --> sout(17)
> 结果 22 34 17
> ```
>



# 第15章：Annotation注解

## Annotation简介

Annotation是从JDK1.5之后提出的一个新的开发技术结构，利用Annotation可以有效减少程序配置的代码，并且可以利用Annotationjin一些结构化的定义。 Annotation是一种注解的形式实现的程序开发。

如果想要清楚Annotation的产生意义，则必须了解一下程序开发结构的历史.

程序开发，是一个资源调度的过程。从历史上来讲，程序的开发分了三个过程：

* 过程一：在开发过程中，将所有可能使用的资源全部定义在程序代码之中

  * 如果服务器相关地址改变，对于程序而言就需要源代码修改，这样明显不方便

    ![image-20200721223731341](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200721223731341.png)

* 过程二：引入配置文件，在配置文件之中定义全部要使用的服务器资源

  * 在配置项不多的情况下，此类配置非常好用，并且十分的简单，但是如果这个时候所有的项目都是采用这种结构开发，就会出现一个可怕的场景：配置文件暴多

    ![image-20200721224129614](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200721224129614.png)

* 过程三：将配置信息重新写回到程序里面，利用一些特殊的标记与程序代码进行分离，这就是注解的作用，也就是Annotation的作用

  * 如果全部都是用注解开发，难度太高了，配置文件有好处也有缺点，所以现在基本都是配置文件+注解的形式完成的

本次所讲解的注解实际上知识java中提供的几个基本注解：@Override，@Deprecated、@SuppressWarnings



## 准确的覆写：@Override

子类在继承一个父类时，如果发现父类的方法功能不足时，会出现覆写的情况

```java
class Channel {
    public void connect() {
        System.out.println("**************Channel***********");
    }
}
class DatabaseChannel extends Channel {
    public void connect() {
        System.out.println("子类定义的通道连接操作。");
    }
}

public class JavaDemo {
    public static void main (String[] args) {
        new DatabaseChannel().connect();
    }
}
```

开发之中经常出现的两个问题：

* 虽然要明确的继承一个父类并且进行方法的覆写，但是有可能由于疏忽忘记编写extends，这个时候不是覆写
* 在进行方法覆写的时候单词写错了。

以上两种情况，程序都不会报错，但是没有覆写成功。在开发之中，为了避免此种现象出现，可以追加一个注解

```java
class Channel {
    public void connect() {
        System.out.println("**************Channel***********");
    }
}
class DatabaseChannel extends Channel {
    @Override
    public void connects() {
        System.out.println("子类定义的通道连接操作。");
    }
}

public class JavaDemo {
    public static void main (String[] args) {
        new DatabaseChannel().connect();
    }
}
```

> JavaDemo.java:7: 错误: 方法不会覆盖或实现超类型的方法
>     @Override
>     ^
> 1 个错误

主要帮助开发者在程序编译的时候可以检查出程序的错误。



## 过期操作：@Deprecated

所谓的过期操作，指的是在一个软件项目的迭代开发过程之中，可能有某一个方法或者某一个类设计、考虑不周（存在缺陷），导致新版本的应用会有不适用的地方（老版本不影响），这时候又不可能直接删除这些内容，那么就希望给一个过度的时间，于是就给一个过期的声明，告诉新的用户这些操作不要再用了。这种方法必须要用@Deprecated注解

```java
class Channel {
    @Deprecated  //老系统继续用，如果是新的不要用了
    public void connect() {
        System.out.println("**************Channel***********");
    }
    public String connection() {
        return "获得Xxx通道连接信息。";
    }
}

public class JavaDemo {
    public static void main (String[] args) {
        new Channel().connect();
    }
}
```

> 注: JavaDemo.java使用或覆盖了已过时的 API。
> 注: 有关详细信息, 请使用 -Xlint:deprecation 重新编译。
> **************Channel***********

有一些开源项目里很讨厌，新版本出现之后，将老版本的方法全部变了样子。建议使用@Deprecated ，柔和的实现代码过渡



## 压制警告：@SuppressWarnings

以之前的过期程序为例，可以发现在程序进行编译的时候会出现错误的提示信息。

> 注: JavaDemo.java使用或覆盖了已过时的 API。
> 注: 有关详细信息, 请使用 -Xlint:deprecation 重新编译。

如果此时不愿意见到这些提示信息，或者已经明确的知道错误在哪里，可以使用@SuppressWarning，来压制警告

```java
class Channel {
    @Deprecated
    public void connect() {
        System.out.println("**************Channel***********");
    }
    public String connection() {
        return "获得Xxx通道连接信息。";
    }
}

public class JavaDemo {
    @SuppressWarnings({"deprecation"})
    public static void main (String[] args) {
        new Channel().connect();
    }
}
```

它做的只是让警告信息不出现，不骚扰你而已



# 第16章：多态性

多态是面向对象中的第三大主要特征，多态性实在继承性的基础之上扩展出来的概念。也就是说可以实现父子类之间的互相转换处理

## 多态性的基本概念

在Java之中对于多态性又两种实现的模式：

* 方法的多态性：

  * 方法的重载：同一个方法名称可以根据传入的参数的类型或个数的不同，选择不同的方法实现

    ```java
    class Message {
    
        public void connect() {
            System.out.println("**************Channel***********");
        }
        public void connect(String str) {
            System.out.println("**************" + str + "***********");
        }
    }
    
    public class JavaDemo {
        public static void main (String[] args) {
            new Message().connect("123");
        }
    }
    ```

  * 方法的覆写：同一个方法可能根据使用子类的不同有不同的实现

    ```java
    class Message {
    
        public void connect() {
            System.out.println("**************Channel***********");
        }
    }
    class MessageBase extends Message {
        public void connect() {
            System.out.println("*****" + this.getClass() + "*****");
        }
    }
    class MessageExtra extends Message {
        public void connect() {
            System.out.println("*****" + this.getClass() + "*****");
        }
    }
    
    public class JavaDemo {
        public static void main (String[] args) {
            new MessageBase().connect();
        }
    }
    ```

* 对象的多态性：父子实例之间的转换处理，它有两种模式：

  * 对象向上转型：父类 父类实例 = 子类实例。--自动完成转型。人--》动物
  * 对象向下转型：子类 子类实例 = (子类) 父类实例。--强制完成转换。 （特殊的）动物 --》人

从实际的转型处理来讲，大部分情况下考虑最多的一定是对象的向上转型（90%），往往都在使用子类的特殊功能（子类可以对父类进行功能扩充）的时候，可能考虑对象的向下转型（3%），还有一些时候不会考虑转型（String类，7%）



## 对象向上转型

对象转型的处理属于多态性，而这一特性必须在继承性的基础上实现。

范例：观察一个简单代码

```java
class Message {

    public void print() {
        System.out.println("**************Message***********");
    }
}
class MessageBase extends Message {
    public void print() {
        System.out.println(this.getClass() + "：Oracle数据库连接信息...");
    }
}

public class JavaDemo {
    public static void main (String[] args) {
        MessageBase msg = new MessageBase();
        msg.print();
    }
}
```

> class MessageBase：Oracle数据库连接信息...

本程序是一个最简单的方法覆写实现，整体程序可以发现，实例化的子类对象，并且子类对象覆写了父类的print()方法，所以调用的是被覆写的方法。

范例：观察向上转型

```java
class Message {

    public void print() {
        System.out.println("**************Message***********");
    }
}
class MessageBase extends Message {
    public void print() {
        System.out.println(this.getClass() + "：Oracle数据库连接信息...");
    }
}

public class JavaDemo {
    public static void main (String[] args) {
        Message msg = new MessageBase();   //向上转型
        msg.print();
    }
}
```

> class MessageBase：Oracle数据库连接信息...

对结果无影响，根据new的对象决定执行print方法

那么这时候需要思考了，向上转型这种操作有什么用处呢。

```java
class Message {
    public void print() {
        System.out.println("**************Message***********");
    }
}
class MessageBase extends Message {
    public void print() {
        System.out.println(this.getClass() + "：Oracle数据库连接信息...");
    }
}

class MessageServer extends Message {
    public void print() {
        System.out.println(this.getClass() + "：web服务器连接信息...");
    }
}
public class JavaDemo {
    public static void main (String[] args) {
        fun(new MessageBase());  //Message msg = new MessageBase()
        fun(new MessageServer());  //Message msg = new MessageServer()
    }
    public static void fun(Message msg) {//不管传递哪一个子类
        msg.print();
    }
}
```

向上转型的主要特点是，可以对参数进行统一的设计。但是为什么此时不使用重载来解决当前问题呢？

```java
public class JavaDemo {
    public static void main (String[] args) {
        fun(new MessageBase());  //Message msg = new MessageBase()
        fun(new MessageServer());  //Message msg = new MessageServer()
    }
    public static void fun(MessageBase msg) {
        msg.print();
    }
    public static void fun(MessageServer msg) {
        msg.print();
    }
}
```

功能同上，但是设计程序时除了要满足要求之外，还需要做出可维护性的设计，如果随着项目的发展，message产生了3000子类，每一个子类之后都要重载fun()方法，对程序的维护性产生了很大影响。



## 对象向下转型

向下转型的主要特点在于，需要用到一些子类特殊的定义处理

![image-20200722000546785](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200722000546785.png)

eg：需要使用到子类会飞的功能

```java
class Person {
    public void print() {
        System.out.println("一个正常的人类行为：吃饭、睡觉、走路");
    }
}
class SuperMan extends Person {
    public void fly() {
        System.out.println("我可以飞~~~");
    }
    public void bite() {
        System.out.println("我抗揍~~~~");
    }
}
public class JavaDemo {
    public static void main (String[] args) {
        System.out.println("----正常状态下的超人应该是一个普通人----");
        Person per = new SuperMan();
        per.print();
        System.out.println("----外星怪兽骚扰地球，准备消灭人类----");
        SuperMan man = (SuperMan) per;
        man.fly();
        man.bite();
    }
}
```

> ----正常状态下的超人应该是一个普通人----
> 一个正常的人类行为：吃饭、睡觉、走路
> ----外星怪兽骚扰地球，准备消灭人类----
> 我可以飞~~~
> 我抗揍~~~~

向上描述的是一些公共的特征，而向下描述的是子类自己特殊的定义环境。但是需要明确的是，向下转型并不是一件安全的事情。因为在进行向下转型之前，一定要首先发生向上转型

![image-20200722001411720](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200722001411720.png)

```java
class Person {
    public void print() {
        System.out.println("一个正常的人类行为：吃饭、睡觉、走路");
    }
}
class SuperMan extends Person {
    public void fly() {
        System.out.println("我可以飞~~~");
    }
    public void bite() {
        System.out.println("我抗揍~~~~");
    }
}
public class JavaDemo {
    public static void main (String[] args) {
        System.out.println("----正常状态下的超人应该是一个普通人----");
        Person per = new Person();  //不转型
        per.print();
        System.out.println("----外星怪兽骚扰地球，准备消灭人类----");
        SuperMan man = (SuperMan) per;  //此时SuperMan类与Person类没关系
        man.fly();
        man.bite();
    }
}
```

> Exception in thread "main" java.lang.ClassCastException: class Person cannot be cast to class SuperMan (Person and SuperMan are in unnamed module of loader 'app')
> 	at JavaDemo.main(JavaDemo.java:20)

Person不能变成SuperMan，除非本来就是SuperMan，只是伪装成了Person。所以如果使用向下转型，一定要先使用向上转型

如果连个没有关系的类进行转换，一定会发生ClassCastException的异常，所以向下转型并不是一件安全的事情。



## instanceof关键字

通过分析可以发现，向下转型本身是一件存在有安全隐患的操作哦，所以为了保证向下转型的正确性，往往在进行转型之前进行判断，判断某个实例是否是某个类的对象，这个就需要通过instanceof语法实现

> 对象 instanceof 类

该判断将返回一个boolean类型，如果是true表示实例是指定类的对象

范例：观察instanceof的使用

```java
class Person {
    public void print() {
        System.out.println("一个正常的人类行为：吃饭、睡觉、走路");
    }
}
class SuperMan extends Person {
    public void fly() {
        System.out.println("我可以飞~~~");
    }
    public void bite() {
        System.out.println("我抗揍~~~~");
    }
}
public class JavaDemo {
    public static void main (String[] args) {
        Person per = new Person();  //不转型
        System.out.println(per instanceof Person); //true
        System.out.println(per instanceof SuperMan); //false
    }
}
```

范例：观察instanceof关键字

```java
class Person {
    public void print() {
        System.out.println("一个正常的人类行为：吃饭、睡觉、走路");
    }
}
class SuperMan extends Person {
    public void fly() {
        System.out.println("我可以飞~~~");
    }
    public void bite() {
        System.out.println("我抗揍~~~~");
    }
}
public class JavaDemo {
    public static void main (String[] args) {
        Person per = new SuperMan();  //转型
        System.out.println(per instanceof Person); //true
        System.out.println(per instanceof SuperMan); //true
    }
}
```

所以如果在开发之中需要用到向下转型，先使用instanceof判断一次

```java
class Person {
    public void print() {
        System.out.println("一个正常的人类行为：吃饭、睡觉、走路");
    }
}
class SuperMan extends Person {
    public void fly() {
        System.out.println("我可以飞~~~");
    }
    public void bite() {
        System.out.println("我抗揍~~~~");
    }
}
public class JavaDemo {
    public static void main (String[] args) {
        Person per = new SuperMan();  
        if(per instanceof SuperMan) {
            SuperMan man = (SuperMan) per;
            man.fly();
            man.bite();
        }
    }
}
```

在以后进行完善性的程序开发时，在类型转换前，先使用instanceof判断



# 第17章：Object类

Object类的主要特点是可以解决参数统一问题，也就是说使用Object类可以接收所有的数据类型

## Object类简介

在Java之中只有一个类是不存在有继承关系，这个类就是Object，所以类都是Object类的子类

以下两种类的定义效果完全相同：

> class Person{} //一个类

> class Person{} extneds Object//一个类

![image-20200722103059783](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200722103059783.png)

提供有无参构造，在Object定义时考虑了所有继承的问题。所以所有其他类定义时候未定义构造方法，默认继承了父类Object类的无参构造方法。

范例：观察使用Object类接受所有子类对象

```java
class Person {}//一个类

public class JavaDemo {
    public static void main (String[] args) {
        Object obj = new Person(); //向上转型
        if (obj instanceof Person) {
            Person per = (Person) obj;
            System.out.println("Person对象向下转型执行完毕");

        }
    }
}
```

如果以后一个程序的方法可以接受所有类对象的时候，就可以利用Object实现互利。但是还有一点需要注意，在Java设计之中，对于所有引用数据类型都可以用Object接收，包括数组也可以。

范例：观察数组接收

```java
public class JavaDemo {
    public static void main (String[] args) {
        Object obj = new int [] {1,2,3}; //向上转型
        if (obj instanceof int []) {
            int data [] = (int []) obj;//向下转型
            for (int temp : data) {
                System.out.print(temp + "、");
            }
        }
    }
}
```

Object是一个万能的数据类型，它更适合给我们程序标准的对象接收



## 获取对象信息：toString()

Object类提供了一些处理方法。部分方法出现了Deprecated

提供了一个toString()方法，可以获取对象的完整信息

```java
class Person {}//一个类

public class JavaDemo {
    public static void main (String[] args) {
        Person per = new Person();
        System.out.println(per);
        System.out.println(per.toString()); //Object类继承而来 
    }
}
```

> Person@28a418fc
> Person@28a418fc

**可以发现上面的程序无论执行多少次都是输出相同内容**

可以发现，在对象直接进行输出的时候调用的方法就是toString()方法，所以这个方法调用与不调用效果是一样的。在以后的开发之中，对象信息的获得可以直接覆写此方法，默认获得的只是对象的编码。

```java
class Person {
    private String name;
    private int age;
    public Person(String name,int age) {
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString() {
        return "姓名：" + this.name + "、年龄：" + this.age;
    }

}

public class JavaDemo {
    public static void main (String[] args) {
        Person per = new Person("张三",20);
        System.out.println(per);
    }
}
```

> 姓名：张三、年龄：20

以后编写简单java类时，不需要写getInfo()方法，只需要覆写toString()方法即可



## 对象比较：equals()

Object类中的另一个重要方法，用于对象比较的处理上，所谓对象比较主要的功能时比较两个对象的内容是否完全相同。假如说现在有两个Person对象，要想确认这两个对象是否一致，但是两个对象本身会有不同的内存地址，所以此时的比较应该时通过内容进行比较。

范例：对象属性比较的基本实现

```java
class Person {
    private String name;
    private int age;
    public Person(String name,int age) {
        this.name = name;
        this.age = age;
    }
    public String toString() {
        return "姓名：" + this.name + "、年龄：" + this.age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }
}

public class JavaDemo {
    public static void main (String[] args) {
        Person perA = new Person("张三",20);
        Person perB = new Person("张三",20);
        if(perA.getName().equals(perB.getName()) && 
            perA.getAge() == perB.getAge()) {
            System.out.println("是同一个对象。");
        } else{
            System.out.println("不是同一个对象。");
        }
    }
}
```

此时的确实现了对象比较，但是这个功能比较麻烦：

* 由于需要进行比较时候要将每一个属性都进行相等判断，所以外部要调用许多get方法
* 对象比较应该是一个类内部所具备的功能，而不应该在外部定义；

Object类作为所有类的父类提供了对象比较的操作支持，所以对象比较的实现可以使用equals()方法完成

* 对象比较：public boolean equals(Object obj) 可以接收所有的类。默认情况下该方法只是进行了两对象的地址判断

  > ```java
  > public boolean equals(Object obj) {
  >     return (this == obj);
  > }
  > ```

* 也就是说对于实际使用者而言，如果想正确的比较对象是否相同，必须覆写该方法。

范例：equals方法覆写

```java
class Person {
    private String name;
    private int age;
    public Person(String name,int age) {
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString() {
        return "姓名：" + this.name + "、年龄：" + this.age;
    }
    //quals方法中有当前对象this，传入的Object
    @Override
    public boolean equals(Object obj) {
        Person per = (Person) obj; //目的为了获取类中的属性
        return this.name.equals(per.name) && this.age == per.age; //当前在内部，所以可以直接访问
    }
}

public class JavaDemo {
    public static void main (String[] args) {
        Person perA = new Person("张三",20);
        Person perB = new Person("张三",20);
        System.out.println(perA.equals(perB));
    }
}
```

* **如果比较对象为空**

  加判空，避免空指针

* **如果和自身比**

  判断如果地址相同，则直接返回true

* **如果比较不同类**

  如果不同类，则直接返回false

```java
class Person {
    private String name;
    private int age;
    public Person(String name,int age) {
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString() {
        return "姓名：" + this.name + "、年龄：" + this.age;
    }
    //quals方法中有当前对象this，传入的Object
    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }
        if(!(obj instanceof Person)) {
            return false;
        }
        if(this == obj) {
            return true;
        }
        Person per = (Person) obj; //目的为了获取类中的属性
        return this.name.equals(per.name) && this.age == per.age; //当前在内部，所以可以直接访问
    }
}

public class JavaDemo {
    public static void main (String[] args) {
        Person perA = new Person("张三",20);
        Person perB = new Person("张三",20);
        System.out.println(perA.equals(perB));
    }
}
```

String类作为Object的子类，那么这个类里面实际上已经覆写了equals方法



# 第18章：抽象类的定义与使用

类继承的主要作用在于可以扩充已有类的功能，但是对于之前的继承操作可以发现，子类可以根据自己的选择决定是否需要覆写某一个方法，这是父类无法对子类做强制性约定（强制性你必须覆写某个方法），这种情况下往往不会进行类的继承。（在实际开发中很少会出现继承一个已经完善的类，可以直接使用的类）而是必须要继承抽象类。在以后父类（SuperClass）设计时优先考虑抽象类

## 抽象类的基本定义

抽象类的主要作用在于对子类中覆写方法进行约定，在抽象类里面可以去定义一些抽象方法以实现这样的约定，抽象方法是使用了abstract关键字定义的并且没有提供方法体的方法，而抽象方法所在的类必须使用abstract关键字来定义（在普通类的基础上增加抽象方法，就是抽象类）

范例：

```java
abstract class Message { //定义抽象类
    private String type; //消息类型
    private abstract String getConnectInfo(); //抽象方法
    public void setType(String type) {//普通方法
        this.type = type;
    }
    public String getType() {//普通方法
        return this.type;
    }
}
```

抽象类是不能直接用new来实例化的，在抽象类完成定义之后（切记：“抽象类不是完整的类”），如果想要去使用抽象类则必须按照如下原则进行：

* 抽象类必须提供有子类，子类extends继承一个抽象类
* 抽象类的子类（不能是抽象类）一定要覆写抽象类的全部抽象方法
* 抽象类的对象实例化可以利用对象多态性通过子类的实例化向上转型的方式完成

范例：使用抽象类

错误案例

```java
abstract class Message { //定义抽象类
    private String type; //消息类型
    public abstract String getConnectInfo(); //抽象方法
    public void setType(String type) {//普通方法
        this.type = type;
    }
    public String getType() {//普通方法
        return this.type;
    }
}
class DatabaseMessage extends Message {}
abstract class ServerMessage extends Message {}

public class JavaDemo {
    public static void main (String[] args) {
        Message msg = new Message();
    }
}
```

> JavaDemo.java:11: 错误: DatabaseMessage不是抽象的, 并且未覆盖Message中的抽象方法getConnectInfo()
> class DatabaseMessage extends Message {}
> ^
> JavaDemo.java:17: 错误: Message是抽象的; 无法实例化
>         Message msg = new Message();
>                       ^

```java
abstract class Message { //定义抽象类
    private String type; //消息类型
    public abstract String getConnectInfo(); //抽象方法
    public void setType(String type) {//普通方法
        this.type = type;
    }
    public String getType() {//普通方法
        return this.type;
    }
}
class DatabaseMessage extends Message {//类继承关系
    public String getConnectInfo() {
        return "Oracle数据库连接信息。";
    }
}

public class JavaDemo {
    public static void main (String[] args) {
        Message msg = new DatabaseMessage();
        msg.setType("客户信息");
        System.out.println(msg.getConnectInfo());
        System.out.println(msg.getType());
    }
}
```

从整体上来讲，抽象类只是比普通类增加了抽象方法以及对子类的强制性的覆写要求而已，其他的使用过程和子类和传统类的继承是完全相同的

对于抽象类使用的几点意见：

* 抽象类使用很大程度上有一个核心的问题：抽象类自己无法实例化
* 抽象类之中主要的目的是进行过渡操作使用，所以当你要使用抽象类进行开发的时候，往往是在你设计中需要解决类继承问题时所带来的代码重复处理。

设计时优先考虑接口



## 抽象类的相关说明

抽象类是一个重要的面向对象设计的结构，对于抽象类的使用需要注意以下几点问题：

* 在定义抽象类的时候绝对不能使用final关键字来定义，因为抽象类必须有子类，而final定义的类是不能有子类的。
* 抽象类是作为一个普通类的加强版出现的（实在普通类的基础上扩展出来的）， 那么普通类之中就可以定义属性和方法，那么这些属性一定是要求进习惯内存空间开辟的。那么抽象类一定可以提供有构造方法，而子类一定会按照子类对象的实例化原则进行父构造调用。
* 抽象类中允许没有抽象方法，但即便没有抽象方法，也不允许用new直接实例化类。必须依靠子类对象完成
* 抽象类之中可以提供有static方法，并且该方法不受到抽象类对象的局限

范例：如果抽象类没有无参构造供调用，子类没有显示调用构造方法

```java
abstract class Message { //定义抽象类
    private String type; //消息类型
    public Message(String type) {
        this.type = type;
    }
    public abstract String getConnectInfo(); //抽象方法
    public void setType(String type) {//普通方法
        this.type = type;
    }
    public String getType() {//普通方法
        return this.type;
    }
}
class DatabaseMessage extends Message {//类继承关系
    public String getConnectInfo() {
        return "Oracle数据库连接信息。";
    }
}

public class JavaDemo {
    public static void main (String[] args) {
        Message msg = new DatabaseMessage();
        msg.setType("客户信息");
        System.out.println(msg.getConnectInfo());
        System.out.println(msg.getType());
    }
}
```

> JavaDemo.java:14: 错误: 无法将类 Message中的构造器 Message应用到给定类型;
> class DatabaseMessage extends Message {//类继承关系
> ^
> 需要: String
> 找到:    没有参数
> 原因: 实际参数列表和形式参数列表长度不同
> 1 个错误

```java
abstract class Message { //定义抽象类
    private String type; //消息类型
    public Message(String type) {
        this.type = type;
    }
    public abstract String getConnectInfo(); //抽象方法
    public void setType(String type) {//普通方法
        this.type = type;
    }
    public String getType() {//普通方法
        return this.type;
    }
}
class DatabaseMessage extends Message {//类继承关系
    public DatabaseMessage(String str) {
       super(str);
    }
    public String getConnectInfo() {
        return "Oracle数据库连接信息。";
    }
}

public class JavaDemo {
    public static void main (String[] args) {
        Message msg = new DatabaseMessage("客户信息");
        System.out.println(msg.getConnectInfo());
        System.out.println(msg.getType());
    }
}
```

> Oracle数据库连接信息。
> 客户信息



范例：static方法

```java
abstract class Message { //定义抽象类
    public abstract String getInfo(); //抽象方法
    public static Message getInstance() {
        return new DatabaseMessage();
    }
}
class DatabaseMessage extends Message {//类继承关系
    public String getInfo() {
        return "Oracle数据库连接信息。";
    }
}

public class JavaDemo {
    public static void main (String[] args) {
        Message msg = Message.getInstance();
        System.out.println(msg.getInfo());
    }
}
```

static方法永远不受到实例化对象或结构的限制，直接用类名称.方法名调用



## 抽象类的应用--模板设计模式

抽象类本质上就属于一个加强的类，类已经清楚，类可以描述一切的现实事务，而抽象类是比一般类更高一层的存在。那么下面来研究抽象类实际应用。

假设现在要描述三类事务：

* 机器人：不休息，只知道补充能量和工作
* 人：需要休息，需要吃饭以及努力的工作
* 猪：需要休息，需要进食，不需要工作

需要一个操作方式（遥控器），统一处理这三类行为

通过传一个编码来选择执行的行为



![image-20200722224807237](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200722224807237.png)

行为是一个抽象的概念

```java
abstract class Action { //定义抽象类
    public static final int EAT = 1;
    public static final int SLEEP = 5;
    public static final int WORK = 10;
    public void command(int code) {
        switch (code) {
            case EAT : {
                this.eat();
                break;
            }
            case SLEEP : {
                this.sleep();
                break;
            }
            case WORK : {
                this.work();
                break;
            }
            case EAT + SLEEP + WORK : {
                this.eat();
                this.sleep();
                this.work();
                break;
            } 
        }
    }
    public abstract void eat(); //抽象方法
    public abstract void sleep(); //抽象方法
    public abstract void work(); //抽象方法
}
class Robot extends Action {//类继承关系
    public void eat() {
        System.out.println("机器人需要接通电源充电");
    }
    public void sleep() {}
    public void work() {
        System.out.println("机器人按照固定的套路进行工作");
    }
}
class Person extends Action {//类继承关系
    public void eat() {
        System.out.println("人饿的时候安静坐下吃饭");
    }
    public void sleep() {
        System.out.println("人累了，躺下慢慢睡着");
    }
    public void work() {
        System.out.println("人有想法的进行工作");
    }
}
class Pig extends Action {//类继承关系
    public void eat() {
        System.out.println("猪吃人类的剩饭");
    }
    public void sleep() {
        System.out.println("猪倒地就睡");
    }
    public void work() { }
}
public class JavaDemo {
    public static void main (String[] args) {
        Action robotAction = new Robot();
        Action personAction = new Person();
        Action pigAction = new Pig();
        System.out.println("-------机器人行为-------");
        robotAction.command(Action.SLEEP);
        robotAction.command(Action.WORK);
        System.out.println("-------人类的行为-------");
        personAction.command(Action.WORK + Action.SLEEP + Action.EAT);
        System.out.println("-------猪的行为-------");
        pigAction.work();
        pigAction.eat();
    }
}
```

> -------机器人行为-------
> 机器人按照固定的套路进行工作
> -------人类的行为-------
> 人饿的时候安静坐下吃饭
> 人累了，躺下慢慢睡着
> 人有想法的进行工作
> -------猪的行为-------
> 猪吃人类的剩饭

现在程序实现了一个行为的抽象处理，但是还是需要思考，现在定义的Action父类主要目的：对所有行为规范进行统一处理。

如果没有按照父类定义的方法写实现，无法被执行-->相当于父类作为抽象类 提供了一个模板。

抽象类最大的好处：

* 对子类方法统一管理
* 自身提供一些普通方法，可以调用抽象方法（在有子类提供实现时生效）

# 第19章：包装类

包装类的主要功能是针对与基本数据类型的对象转换而实现的，并且随着JDK版本的更新，包装类的功能也在改善，有了更多的支持

## 认识包装类

Object类最大的特点是所有类的父类，可以接收所有的数据类型，但是这个过程中，基本数据类型不是类，但是现在如果想要将基本数据类型以类的形式进行处理，这就引入了包装类。

```java
class Int { 
    private int data ;//包装一个基本数据类型
    public Int(int data) {
        this.data = data;
    }
    public int intVaule() {
        return this.data;
    }
}

public class JavaDemo {
    public static void main (String[] args) {
        Object obj = new Int(10); //装箱，将基本数据类型保存在包装类中
        int x = ((Int) obj).intVaule(); //拆箱，从包装类对象中获取基本数据类型
        System.out.println(x * 2);
    }
}
```

基本数据类型进行包装处理后可以像对象一样进行引用传递，同时也可以使用Object类来进行接收。但是可以发现基本数据类型与Object类型之间的缺陷，那么JDK也早就发现了同样的问题，提供了8种基本数据类型对应的包装类。

![image-20200722231659396](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200722231659396.png)

现在可以发现Java中包装类一共有两种类型：

* 对象型包装类（Object直接子类）：Boolean Character
* 数值型包装类（Object子类Number抽象类的子类）：其他六个

Number抽象类提供了一些常用的处理方法

| NO   | 方法名称                             | 类型 | 描述                     |
| ---- | ------------------------------------ | ---- | ------------------------ |
| 01   | public byte byteValue()              | 普通 | 从包装类中获取byte数据   |
| 02   | public short shortValue()            | 普通 | 从包装类中获取short数据  |
| 03   | public abstract int intValue()       | 抽象 | 从包装类中获取int数据    |
| 04   | public abstract long longValue()     | 抽象 | 从包装类中获取long数据   |
| 05   | public abstract float floatValue()   | 抽象 | 从包装类中获取float数据  |
| 06   | public abstract double doubleValue() | 抽象 | 从包装类中获取double数据 |



## 装箱与拆箱操作

基本数据类型的包装类 都是为了基本数据类型转换为对象提供的，这样两者之间就有如下的操作关系

* 数据装箱：将基本数据类型保存到包装类中，一般利用构造方法产生
  * Integer类：public Integer(int value);
  * Double类：public Double(double value);
  * Boolean类：public Boolean(boolean value);
  * 以上均在jdk1.9之后不推荐使用
* 数据拆箱：从包装类中获取基本数据类型
  * 数值型包装类已经由Number类定义了拆箱方法
  * Boolean型：public boolean booleanValue();

范例：以int和Integer为例

```java
public class JavaDemo {
    public static void main (String[] args) {
        Integer obj = new Integer(10); //装箱，将基本数据类型保存在包装类中
        int num = obj.intValue(); //拆箱，从包装类对象中获取基本数据类型
        System.out.println(num * 2);
    }
}
```

> 注: JavaDemo.java使用或覆盖了已过时的 API。
> 注: 有关详细信息, 请使用 -Xlint:deprecation 重新编译。
> 20

范例：以double和Double为例，boolean和Boolean为例

同上

可以发现从JDK1.9之后，对于所有包装类之中提供的构造方法变为了过期处理，不建议用户再继续使用了，这是因为JDK1.5之后为了方便处理，提供了自动装箱和拆箱操作。所以基本没有人用了。

范例：推荐用法

```java
public class JavaDemo {
    public static void main (String[] args) {
        Integer obj = 10; //装箱，将基本数据类型保存在包装类中
        int num = obj; //拆箱，从包装类对象中获取基本数据类型
        obj++; //直接参与数学计算
        System.out.println(num * obj);
    }
}
```

> 110

除了提供有这种自动的数学运算支持之外，自动装箱最大的好处是实现Object类接收基本数据类型

范例：Object接收double

```java
public class JavaDemo {
    public static void main (String[] args) {
        Object obj = 19.2; //double自动装箱Double，向上转型为Object
        //((Double)obj)++; //不支持 ++
        double num = (Double)obj;//不支持直接转型
        System.out.println(num * 2);
    }
}
```

> 38.4

JDK1.5提供自动支持，JDK1.9为了巩固此概念，将包装类的构造方法全设为了过期。

但是对于包装类需要注意一些问题了，关于相等判断上。

```java
public class JavaDemo {
    public static void main (String[] args) {
        Integer x = 127;
        Integer y = 127;
        System.out.println(x == y);  //true
    }
}
```

```java
public class JavaDemo {
    public static void main (String[] args) {
        Integer x = 128;
        Integer y = 128;
        System.out.println(x == y);  //false
        System.out.println(x.equals(y));  //true
    }
}
```

-128~127为byte范围，可以直接==比较，范围大于1字节，只能用equals方法比较

```java
public class JavaDemo {
    public static void main (String[] args) {
        Integer x = 127;
        Integer y = new Integer(127);
        System.out.println(x == y);
    }
}
```

> 注: JavaDemo.java使用或覆盖了已过时的 API。
> 注: 有关详细信息, 请使用 -Xlint:deprecation 重新编译。
> false

同String道理



# 第20章：接口的定义与使用 

当你可以灵活的的使用抽象类和接口进行设计的时候，那么基本上就表示面向对象的概念理解了

## 接口的基本定义

抽象类与普通类相比最大的优势在于：可以实现对子类覆写方法的控制，但是在抽象类里面可能依然会保留一些普通方法，而普通方法里面可能会涉及到一些安全或者隐私操作问题，那么这样在开发过程中想要对外部隐藏全部的实现细节，就用到了接口。

![image-20200723004907475](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200723004907475.png)

范例：定义一个接口

```java
//由于类名称和接口名称的定义要求相同，所以为了区分出接口，在接口名称前会加字母I
interface IMessage {//定义了一个接口
    public static final String INFO = "www.mldn.cn";//全局常量
    public abstract String getInfo(); //抽象方法
}
```

但是现在很明显的问题，此时的接口肯定无法直接产生实例化对象。所以对于接口的要求如下：

![image-20200723005325849](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200723005325849.png)

如果没有实现全部抽象方法，会报错

范例：实现接口

```java
//由于类名称和接口名称的定义要求相同，所以为了区分出接口，在接口名称前会加字母I
interface IMessage {//定义了一个接口
    public static final String INFO = "www.mldn.cn";//全局常量
    public abstract String getInfo(); //抽象方法
}
class MessageImpl implements IMessage {//实现了接口
    public String getInfo() {
        return "得到一个消息";
    }
}
public class JavaDemo {
    public static void main (String[] args) {
        IMessage msg = new MessageImpl();
        System.out.println(msg.getInfo());
        System.out.println(IMessage.INFO);
    }
}
```

以上是接口的基本使用，但是在Java里面之所以使用接口，主要目的是一个子类可以实现多个接口，通过接口可以实现多继承的概念

范例：观察实现多个接口

```java
//由于类名称和接口名称的定义要求相同，所以为了区分出接口，在接口名称前会加字母I
interface IMessage {//定义了一个接口
    public static final String INFO = "www.mldn.cn";//全局常量
    public abstract String getInfo(); //抽象方法
}
interface IChannel {//定义了一个接口
    public abstract boolean connect(); //抽象方法
}
class MessageImpl implements IMessage,IChannel {//实现了接口
    public String getInfo() {
        if(this.connect()) {
            return "得到一个消息";
        }
        return "通道建立失败";
    }
    public boolean connect() {
        System.out.println("消息发送通道已成功建立");
        return true;
    }
}
public class JavaDemo {
    public static void main (String[] args) {
        IMessage msg = new MessageImpl();
        System.out.println(msg.getInfo());
    }
}
```

> 消息发送通道已成功建立
> 得到一个消息

Java单继承的限制一定程度上得到了弥补。但是一个实际的情况出现了，涉及到对象的转型问题

![image-20200723010241370](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200723010241370.png)

此时，MessageImpl子类的对象可以任意的实现父接口的转换

范例：观察转换

```java
//由于类名称和接口名称的定义要求相同，所以为了区分出接口，在接口名称前会加字母I
interface IMessage {//定义了一个接口
    public static final String INFO = "www.mldn.cn";//全局常量
    public abstract String getInfo(); //抽象方法
}
interface IChannel {//定义了一个接口
    public abstract boolean connect(); //抽象方法
}
class MessageImpl implements IMessage,IChannel {//实现了接口
    public String getInfo() {
        if(this.connect()) {
            return "得到一个消息";
        }
        return "通道建立失败";
    }
    public boolean connect() {
        System.out.println("消息发送通道已成功建立");
        return true;
    }
}
public class JavaDemo {
    public static void main (String[] args) {
        IMessage msg = new MessageImpl();
        IChannel chl = (IChannel) msg;
        System.out.println(chl.connect());
    }
}
```

> 消息发送通道已成功建立
> true

实现了转换，关键看new的对象是MessageImpl()

由于MessageImpl子类实现了IMessage和IChannel两个接口，所以这个子类可以是这两个接口任意一个接口的实例，那么就表示此时这两个接口实例之间是可以转换的。

![image-20200723010716110](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200723010716110.png)

范例：观察Object与接口转换

```java
//由于类名称和接口名称的定义要求相同，所以为了区分出接口，在接口名称前会加字母I
interface IMessage {//定义了一个接口
    public static final String INFO = "www.mldn.cn";//全局常量
    public abstract String getInfo(); //抽象方法
}
interface IChannel {//定义了一个接口
    public abstract boolean connect(); //抽象方法
}
class MessageImpl implements IMessage,IChannel {//实现了接口
    public String getInfo() {
        if(this.connect()) {
            return "得到一个消息";
        }
        return "通道建立失败";
    }
    public boolean connect() {
        System.out.println("消息发送通道已成功建立");
        return true;
    }
}
public class JavaDemo {
    public static void main (String[] args) {
        IMessage msg = new MessageImpl();
        Object obj = msg; //向上转型
        IChannel chan = (IChannel) obj;
        System.out.println(chan.connect());
    }
}
```

结果同上

Object类对象可以接收所有数据类型，包括基本数据类型、类对象、接口对象、数组。

![image-20200723010948949](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200723010948949.png)

![image-20200723011025920](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200723011025920.png)

只有接口可以省略abstract，抽象类不可以！！

范例：子类先继承后实现

```java
//由于类名称和接口名称的定义要求相同，所以为了区分出接口，在接口名称前会加字母I
interface IMessage {//定义了一个接口
    public static final String INFO = "www.mldn.cn";//全局常量
    public abstract String getInfo(); //抽象方法
}
interface IChannel {//定义了一个接口
    public abstract boolean connect(); //抽象方法
}
abstract class DatabaseAbstract {//定义抽象类
    public abstract boolean getDatabaseConnect();
}
class MessageImpl extends DatabaseAbstract implements IMessage,IChannel {//实现了接口
    public String getInfo() {
        if(this.connect()) {
            if(this.getDatabaseConnect()) {
                return "数据库得到一个消息";
            } else {
                return "数据库消息无法访问";
            }
        }
        return "通道建立失败";
    }
    public boolean connect() {
        System.out.println("消息发送通道已成功建立");
        return true;
    }
    public boolean getDatabaseConnect() {
        return true;
    }
}
public class JavaDemo {
    public static void main (String[] args) {
        IMessage msg = new MessageImpl();
        System.out.println(msg.getInfo());
    }
}
```

> 消息发送通道已成功建立
> 数据库得到一个消息

虽然接口无法继承一个父类，但是一个接口确可以通过extends继承若干个父接口，称为接口的多继承

范例：观察接口的多继承

```java
interface IMessage {//定义了一个接口
    public String getInfo(); //抽象方法
}
interface IChannel {//定义了一个接口
    public boolean connect(); //抽象方法
}
//接口多继承，类只能继承一个
interface IService extends IChannel,IMessage {
    public String service();
}
class MessageService implements IService {
    public String getInfo() {
        return "实现getInfo";
    }
    public boolean connect() {
        return true;
    }
    public String service() {
        return "获取消息服务";
    }
}
public class JavaDemo {
    public static void main (String[] args) {
    }
}
```

接口里面有些设计的概念被打破了

![image-20200723012123312](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200723012123312.png)



## 接口定义加强

接口最早的主要特点是全部由抽象方法和全局常量所组成，但是如果项目设计不当，就可能出现一种非常严重的问题。

在很多个子类实现接口以后，如果接口追加方法？？

![image-20200723012346246](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200723012346246.png)

一直在强调该操作是属于结构设计不当的结果，那么在最初的时候任何人都不敢保证你的接口设计足够完善，可以在这样的情况下，为了方便子类的修改，往往不会让子类直接实现接口，而是中间追加一个过度的抽象类。

![image-20200723012530676](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200723012530676.png)

如果需要修改已经使用的接口，通过过渡抽象类追加方法，避免重复修改

**在JDK1.8之后，为了解决接口设计的缺陷，所以在接口之中允许开发者定义普通方法**

```java
interface IMessage {//定义了一个接口
    public String getInfo(); //抽象方法
    public default boolean connect() {//追加公共方法，所有子类都具备
        System.out.println("建立消息的发送通道");
        return true;
    }
}
class MessageImpl implements IMessage {
    public String getInfo() {
        return "实现getInfo";
    }
}
public class JavaDemo {
    public static void main (String[] args) {
        IMessage msg = new MessageImpl();
        if(msg.connect()) {
            System.out.println(msg.getInfo());
        }
    }
}
```

> 建立消息的发送通道
> 实现getInfo

接口中的普通方法必须追加default声明，但是该方法属于补充/挽救的功能，在不是必须的情况下不应该成为设计的首选。

除了可以追加普通方法之外，接口里面也可以定义static方法了，而static方法就可以通过接口直接调用

范例：在接口中定义static方法

```java
interface IMessage {//定义了一个接口
    public String getInfo(); //抽象方法
    public default boolean connect() {//追加公共方法，所有子类都具备
        System.out.println("建立消息的发送通道");
        return true;
    }
    public static IMessage getInstance() {
        return new MessageImpl(); //获得子类对象
    }
}
class MessageImpl implements IMessage {
    public String getInfo() {
        if (this.connect()) {
            return "实现getInfo";            
        }
        return "没有消息发送。";
    }
}
public class JavaDemo {
    public static void main (String[] args) {
        IMessage msg = IMessage.getInstance();
        System.out.println(msg.getInfo());
    }
}
```

![image-20200723013828619](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200723013828619.png)



## 使用接口定义标准

![image-20200723013920112](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200723013920112.png)

![image-20200723014127567](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200723014127567.png)

范例：usb实现

```java
interface IUSB {//定义USB标准
    public boolean check() ; //检查通过可以工作
    public void work() ;
}
class Computer {
    public void plugin(IUSB usb) {
        if (usb.check()) {
            usb.work();            
        } else {
            System.out.println(usb.getClass() + "硬件设备安装出现了问题，无法使用");
        }
    }
}
class Keyboard implements IUSB {
    public boolean check() {
        return true;
    }
    public void work() {
        System.out.println("开始进行码字任务");
    }
}
class Printer implements IUSB {
    public boolean check() {
        return false;
    }
    public void work() {
        System.out.println("开始进行照片打印");
    }
}

public class JavaDemo {
    public static void main (String[] args) {
        Computer computer = new Computer();
        computer.plugin(new Keyboard()); //插入键盘
        computer.plugin(new Printer()); //插入打印机
    }
}
```

> 开始进行码字任务
> class Printer硬件设备安装出现了问题，无法使用

现实生活中，标准的概念无处不在

![image-20200723015100060](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200723015100060.png)



## 工厂设计模式(Factory)

![image-20200723015230450](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200723015230450.png)

原则：某一个程序类的修改不应该影响其他程序

范例：观察如下一个程序

```java
interface IFood {//定义食物标准
    public void eat() ; //吃
}
class Bread implements IFood {//定义一种食物
    public void eat() {
        System.out.println("吃面包。");
    }
}

public class JavaDemo {
    public static void main (String[] args) {
        IFood food = new Bread();
        food.eat();//吃面包
    }
}
```

![image-20200723015613194](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200723015613194.png)

客户端关注食物本身，不在意怎么来的，不应该客户端指定子类

范例：扩展一类食物

```java
interface IFood {//定义食物标准
    public void eat() ; //吃
}
class Bread implements IFood {//定义一种食物
    public void eat() {
        System.out.println("吃面包。");
    }
}
class Milk implements IFood {//定义一种食物
    public void eat() {
        System.out.println("喝牛奶。");
    }
}
public class JavaDemo {
    public static void main (String[] args) {
        IFood food = new Milk();
        food.eat();//喝牛奶
    }
}
```

![image-20200723015959924](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200723015959924.png)

原理：避免与目标直接联系，去耦合

范例：工厂设计实现

```java
interface IFood {//定义食物标准
    public void eat() ; //吃
}
class Bread implements IFood {//定义一种食物
    public void eat() {
        System.out.println("吃面包。");
    }
}
class Milk implements IFood {//定义一种食物
    public void eat() {
        System.out.println("喝牛奶。");
    }
}
class Factory {
    public static IFood getInstance(String className) {
        if ("bread".equals(className)) {
            return new Bread();
        } else if ("milk".equals(className)) {
            return new Milk();
        } else {
            return null;
        }
    }
}
public class JavaDemo {
    public static void main (String[] args) {
        IFood food = Factory.getInstance(args[0]);
        food.eat();
    }
}
```

通过jvm参数实现选择

![image-20200723020635515](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200723020635515.png)

![image-20200723020656026](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200723020656026.png)

如果日后进行子类扩充的时候，只需要修改Factory程序类即可实现



## 代理设计模式(Proxy)

代理设计模式的主要功能是可以昂著用户将所有的开发注意力只集中在核心业务功能的处理上。例如：肚子饿了，思考如何可以迟到东西

![image-20200723021343176](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200723021343176.png)

真实情况应该与工厂模式整合

```java
interface IEat {//定义吃过程
    public void get() ; 
}
class EatReal implements IEat {//定义一个真实吃东西的人
    public void get() {
        System.out.println("【真实主题】得到食物，品尝美味");
    }
}
class EatProxy implements IEat {//服务代理
    private IEat eat; //为了吃而服务
    public EatProxy(IEat eat) { //一定要有一个代理项
        this.eat = eat;
    }
    public void get() {
        this.prepare();
        this.eat.get();  //真正吃东西的人去吃
        this.clear();
    }
    public void prepare() {//准备过程
        System.out.println("【代理主题】1.精心购买食材");
        System.out.println("【代理主题】2.小心处理食材");
    }
    public void clear() {
        System.out.println("【代理主题】3.收拾碗筷");
    }
}

public class JavaDemo {
    public static void main (String[] args) {
        IEat eat = new EatProxy(new EatReal());
        eat.get();
    }
}
```

> 【代理主题】1.精心购买食材
> 【代理主题】2.小心处理食材
> 【真实主题】得到食物，品尝美味
> 【代理主题】3.收拾碗筷

![image-20200723022318467](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200723022318467.png)



## 抽象类与接口的区别

![image-20200723022442815](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200723022442815.png)

![image-20200723022500648](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200723022500648.png)

![image-20200723022700873](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200723022700873.png)



![image-20200723022912394](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200723022912394.png)

接口和抽象类才是最初的设计



# 第21章：综合案例：抽象类与接口应用

抽象类与接口是Java里面最为核心的概念，也是所有设计模式的综合体现，包括在日后学习的过程之中也会接触到许多的系统提供的接口和抽象类。接口与抽象类在都可以使用的情况下一定要优先使用接口，因为接口可以避免单继承的局限。

##  案例分析一：获取类信息

![image-20200723191933754](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200723191933754.png)

```java
interface IClassName {//安装要求定义接口
    public String getClassName() ; //数据一定要返回 
}
class Company implements IClassName {//定义一个实现
    public String getClassName() {
        return "Company";
    }
}

public class JavaDemo {
    public static void main (String[] args) {
        IClassName ica = new Company();
        System.out.println(ica.getClassName());
    }
}
```

接口前追加一个字母I是一个良好的习惯，也是这几年一直强调的定义原则



## 案例分析二：绘图处理

考虑一个表示绘图的标准，并且可以根据不同的图形进行绘制

![image-20200723194737674](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200723194737674.png)

```java
interface IGraphical {//定义绘图标准
    public void paint() ; //绘图 
}
class Point {
    private double x; //坐标x
    private double y; //坐标y
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public double getX() {
        return this.x;
    }
    public double getY() {
        return this.y;
    }
}


class Triangle implements IGraphical {//画三角形
    private Point [] x; //保存第一条边的
    private Point [] y; //保存第二条边的
    private Point [] z; //保存第三条边的
    public Triangle(Point [] x, Point [] y, Point [] z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void paint() {
        System.out.println("绘制第一条边，开始坐标:[" + this.x[0].getX() + "," + this.x[0].getY() + "]，结束坐标为:[" + this.x[1].getX() + "," + this.x[1].getY() + "]" );
        System.out.println("绘制第二条边，开始坐标:[" + this.y[0].getX() + "," + this.y[0].getY() + "]，结束坐标为:[" + this.y[1].getX() + "," + this.y[1].getY() + "]" );
        System.out.println("绘制第三条边，开始坐标:[" + this.z[0].getX() + "," + this.z[0].getY() + "]，结束坐标为:[" + this.z[1].getX() + "," + this.z[1].getY() + "]" );
    }
}
class Circular implements IGraphical {//画三角形
    private double radius; //保存圆的半径
    public Circular(double radius) {
        this.radius = radius;
    }
    public void paint() {
        System.out.println("以半径为" + this.radius + "绘制圆形");
    }
}

class Factory {
    public static IGraphical getInstance(String className,double ... args) {
        if("triangle".equalsIgnoreCase(className)) {
            return new Triangle(
                new Point[] {
                    new Point(args[0],args[1]), new Point(args[2],args[3])
                },
                new Point[] {
                    new Point(args[0],args[1]), new Point(args[2],args[3])
                },
                new Point[] {
                    new Point(args[0],args[1]), new Point(args[2],args[3])
                }
            );
        } else if ("circular".equalsIgnoreCase(className)) {
            return new Circular(args[0]);
        } else {
            return null;
        }
    }
}



public class JavaDemo {
    public static void main (String[] args) {
        IGraphical iga = Factory.getInstance("triangle",1.1,2.2,3.3,4.4,11.11,22.22,33.33,44.44,111.111,222.222,333.333,444.444);
        iga.paint();
        IGraphical igb = Factory.getInstance("circular",88.11);
        igb.paint();
    }
}
```

> 绘制第一条边，开始坐标:[1.1,2.2]，结束坐标为:[3.3,4.4]
> 绘制第二条边，开始坐标:[1.1,2.2]，结束坐标为:[3.3,4.4]
> 绘制第三条边，开始坐标:[1.1,2.2]，结束坐标为:[3.3,4.4]
> 以半径为88.11绘制圆形



## 案例分析三：图形

![image-20200723204046877](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200723204046877.png)

![image-20200723204254111](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200723204254111.png)

抽象类要不要加工厂类？？可以加，工厂类不是只能用在接口，主要特征是为了隐藏所有实现子类

![image-20200724131307167](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200724131307167.png)

```java
abstract class AbstractShape {//定义图形
    public abstract double area() ;
    public abstract double perimeter(); 
}
class Circular extends AbstractShape {
    private double radius ; 
    public Circular(double radius) {
        this.radius = radius;
    }
    public double area() {
        return 3.1415927 * this.radius * this.radius;
    }
    public double perimeter() {
        return 2 * 3.1415927 * this.radius;
    }
}
class Rectangle extends AbstractShape {
    private double length;
    private double width;
    public Rectangle(double length,double width) {
        this.length = length;
        this.width = width;
    }
    public double area() {
        return this.length * this.width;
    }
    public double perimeter() {
        return 2 * (this.width + this.length);
    }
}

class Factory {
    public static AbstractShape getInstance(String className,double ... args) {
        if("Circular".equalsIgnoreCase(className)) {
            return new Circular(args[0]);
        } else if("Rectangle".equalsIgnoreCase(className)) {
            return new Rectangle(args[0], args[1]);
        } else {
            return null;
        }
    }
}



public class JavaDemo {
    public static void main (String[] args) {
        AbstractShape asa = Factory.getInstance("Circular",1.1);
        AbstractShape asb = Factory.getInstance("Rectangle",1.5,6.2);
        System.out.println("圆形面积：" + asa.area() + "、圆形周长：" + asa.perimeter());
        System.out.println("矩形面积：" + asb.area() + "、矩形周长：" + asb.perimeter());
    }
}
```

> 圆形面积：3.8013271670000006、圆形周长：6.91150394
> 矩形面积：9.3、矩形周长：15.4



# 第22章：泛型

泛型从JDK1.5之后追加到Java语言里面的，其主要的目的是为了解决ClassCastException 的问题， 在进行对象的向下转型永远都可能存在有安全隐患，而java希望通过泛型可以慢慢解决掉此类问题

## 泛型的问题引出

![image-20200724134319044](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200724134319044.png)

```java
class Point{
    private Object x;
    private Object y;
    public void setX(Object x) {
        this.x = x;
    }
    public void setY(Object y) {
        this.y = y;
    }
    public Object getX() {
        return this.x;
    }
    public Object getY() {
        return this.y;
    }
}

```

而后进行内容设置

范例：正确的内容操作

```java
public class JavaDemo {
    public static void main (String[] args) {
        Point point = new Point();
        //第一步：根据需求进行内容设置
        point.setX(10);  //自动装箱
        point.setY(20);  //自动装箱
        //第二步：从里面获取数据
        int x = (Integer) point.getX();
        int y = (Integer) point.getY();
        System.out.println("X坐标：" + x + "、Y坐标：" + y);
    }
}
```

本程序之所以可以解决当前的设计问题，主要原因在于，Object可以接收所有的数据类型，但是本程序也存在严重的安全隐患

```java
public class JavaDemo {
    public static void main (String[] args) {
        Point point = new Point();
        //第一步：根据需求进行内容设置
        point.setX(10);  //自动装箱
        point.setY("北纬20度");  //自动装箱
        //第二步：从里面获取数据
        int x = (Integer) point.getX();
        int y = (Integer) point.getY();
        System.out.println("X坐标：" + x + "、Y坐标：" + y);
    }
}
```

此时的程序明显出现了问题，在编译程序时不会出现错误，但是在执行时会出现ClassCastException异常，所以本程序的设计是存在安全隐患的。而这个安全隐患存在的依据在于使用了Object类型，因为Object可以涵盖的范围太广了，而对于这样的错误如果可以直接出现在编译过程之中，那么就可以避免运行时的错误。

》》引出泛型，不使用向上转换





## 泛型基本定义

![image-20200724135337767](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200724135337767.png)

```java
class Point<T>{  //type的简写，也可以用A B C
    private T x;
    private T y;
    public void setX(T x) {
        this.x = x;
    }
    public void setY(T y) {
        this.y = y;
    }
    public T getX() {
        return this.x;
    }
    public T getY() {
        return this.y;
    }
}
public class JavaDemo {
    public static void main (String[] args) {
        Point point = new Point();
        //第一步：根据需求进行内容设置
        point.setX(10);  //自动装箱
        point.setY(20);  //自动装箱
        //第二步：从里面获取数据
        int x = (Integer) point.getX();
        int y = (Integer) point.getY();
        System.out.println("X坐标：" + x + "、Y坐标：" + y);
    }
}
```

此时Point类的x,y数据类型并不确定，由外部来决定，如果未提供，执行上面，则得到结果：

> 注: JavaDemo.java使用了未经检查或不安全的操作。
> 注: 有关详细信息, 请使用 -Xlint:unchecked 重新编译。
> X坐标：10、Y坐标：20

>  提示：关于默认的泛型类型
>
> 由于泛型是属于JDK1.5之后的产物，在这之前已经有不少内置的程序类或者接口广泛的应用在项目开发之中，于是为了保证这些类或接口追加了反习惯之后，原始的程序类依然可用。所以如果不没设置泛型时，自动将使用Object作为类型以保证程序的正常执行，然是再编译的过程中会出现警告信息

泛型定义完成后可以再实例化对象的时候进行泛型类型的设置，一旦设置之后，里面的x与y的属性类型就与当前对象直接绑定了

```java
public class JavaDemo {
    public static void main (String[] args) {
        Point<Integer> point = new Point<Integer>();
        //第一步：根据需求进行内容设置
        point.setX(10); 
        point.setY(20); 
        //第二步：从里面获取数据
        int x = point.getX();
        int y = point.getY();
        System.out.println("X坐标：" + x + "、Y坐标：" + y);
    }
}
```

范例：如果值设置错误

> point.setY("北纬30度"); 

> JavaDemo.java:23: 错误: 不兼容的类型: String无法转换为Integer
>         point.setY("北纬30度"); 

![image-20200724140412192](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200724140412192.png)

![image-20200724140752585](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200724140752585.png)

## 泛型通配符

![image-20200724140839824](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200724140839824.png)

```java
class Message<T>{ 
    private T content;
    public void setContent(T content) {
        this.content = content;
    }
    public T getContent() {
        return this.content;
    }
}

public class JavaDemo {
    public static void main (String[] args) {
        Message<String> msg = new Message<>();
        msg.setContent("Message");
        fun(msg);  //引用传递
    }
    public static void fun(Message<String> temp) {
        System.out.println(temp.getContent());
    }
}
```

> Message

![image-20200724141847759](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200724141847759.png)

增加了新的问题，怎么进行引用传递

```java
public class JavaDemo {
    public static void main (String[] args) {
        Message<Integer> msg = new Message<>();
        msg.setContent(110);
        fun(msg);  //引用传递
    }
    public static void fun(Message<String> temp) {
        System.out.println(temp.getContent());
    }
}
```

> JavaDemo.java:15: 错误: 不兼容的类型: Message<Integer>无法转换为Message<String>
>         fun(msg);  //引用传递
>             ^
> 注: 某些消息已经过简化; 请使用 -Xdiags:verbose 重新编译以获得完整输出
> 1 个错误

进行方法重载？

```java
public class JavaDemo {
    public static void main (String[] args) {
        Message<Integer> msg = new Message<>();
        msg.setContent(110);
        fun(msg);  //引用传递
    }
    public static void fun(Message<String> temp) {
        System.out.println(temp.getContent());
    }
    public static void fun(Message<Integer> temp) {
        System.out.println(temp.getContent());
    }
}
```

> JavaDemo.java:20: 错误: 名称冲突: fun(Message<Integer>)和fun(Message<String>)具有相同疑符
>     public static void fun(Message<Integer> temp) {
>                        ^
> 1 个错误

**重载认的是泛型基础类Message<>**

范例：不设置泛型

```java
public class JavaDemo {
    public static void main (String[] args) {
        Message<Integer> msg = new Message<>();
        msg.setContent(110);
        fun(msg);  //引用传递
        Message<String> msgb = new Message<>();
        msgb.setContent("Message");
        fun(msgb);
    }
    public static void fun(Message temp) {
        System.out.println(temp.getContent());
    }
}
```

> 110
> Message

会出现更为严重的情况

```java
    public static void fun(Message temp) {
        temp.setContent(1.1);
        System.out.println(temp.getContent());
    }
```

> 1.1
> 1.1

发现如果不设置泛型，那么在方法之中有可能对数据进行修改，此时需要找一种方案：可以接收所有的泛型类型，并且不能够修改里面的数据（允许获取），那么就需要通过通配符”?“来解决

```java
    public static void fun(Message<?> temp) {
        temp.setContent(1.1);
        System.out.println(temp.getContent());
    }
```

> JavaDemo.java:26: 错误: 不兼容的类型: double无法转换为CAP#1
>         temp.setContent(1.1);
>                         ^
>   其中, CAP#1是新类型变量:
>     CAP#1从?的捕获扩展Object
> 注: 某些消息已经过简化; 请使用 -Xdiags:verbose 重新编译以获得完整输出
> 1 个错误

以上，发现不允许修改

```java
class Message<T>{ 
    private T content;
    public void setContent(T content) {
        this.content = content;
    }
    public T getContent() {
        return this.content;
    }
}




public class JavaDemo {
    public static void main (String[] args) {
        Message<Integer> msga = new Message<>();
        msga.setContent(110);
        fun(msga);  //引用传递
        Message<String> msgb = new Message<>();
        msgb.setContent("Message");
        fun(msgb);
    }
    public static void fun(Message<?> temp) {
        System.out.println(temp.getContent());
    }
}
```

> 110
> Message

此时在fun()方法里面由于采用了Message结合通配符的处理，所以可以接收所有的类型，并且不允许修改只允许获取数据。

在“?”这个通配符的基础之上实际还提供有两类小的通配符：

* ? extends 类：设置泛型的上限
  * 例如：定义“? extends Number”：表示该泛型类型只允许设置Number类或其子类
* ? super 类：设置泛型的下限：
  * 例如：定义“? super String”：表示只能使用String或其父类

范例：观察泛型的上限配置

```java
class Message<T extends Number>
...
public static void fun(Message<? extends Number> temp) 
...
```

> JavaDemo.java:19: 错误: 类型参数String不在类型变量T的范围内
>         Message<String> msgb = new Message<>();
>                 ^
>   其中, T是类型变量:
>     T扩展已在类 Message中声明的Number
> JavaDemo.java:19: 错误: 不兼容的类型: 无法推断Message<>的类型参数
>         Message<String> msgb = new Message<>();
>                                           ^
>     原因: 推论变量 T 具有不兼容的上限
>       等式约束条件：String
>       下限：Number
>   其中, T是类型变量:
>     T扩展已在类 Message中声明的Number
> JavaDemo.java:21: 错误: 不兼容的类型: Message<String>无法转换为Message<? extends Number>
>         fun(msgb);
>             ^
> 注: 某些消息已经过简化; 请使用 -Xdiags:verbose 重新编译以获得完整输出
> 3 个错误

把String部分去掉就不报错

> ```java
> class Message<T extends Number>{ 
>     private T content;
>     public void setContent(T content) {
>         this.content = content;
>     }
>     public T getContent() {
>         return this.content;
>     }
> }
> 
> 
> 
> 
> public class JavaDemo {
>     public static void main (String[] args) {
>         Message<Integer> msga = new Message<>();
>         msga.setContent(110);
>         fun(msga);  //引用传递
>     }
>     public static void fun(Message<? extends Number> temp) {
>         System.out.println(temp.getContent());
>     }
> }
> ```

范例：设置泛型下限

```java
...
public static void fun(Message<? super String> temp)
...
```

> JavaDemo.java:18: 错误: 不兼容的类型: Message<Integer>无法转换为Message<? super String>
>         fun(msga);  //引用传递
>             ^
> 注: 某些消息已经过简化; 请使用 -Xdiags:verbose 重新编译以获得完整输出
> 1 个错误

```java
class Message<T>{ 
    private T content;
    public void setContent(T content) {
        this.content = content;
    }
    public T getContent() {
        return this.content;
    }
}




public class JavaDemo {
    public static void main (String[] args) {
        Message<String> msgb = new Message<>();
        msgb.setContent("Message");
        fun(msgb);
    }
    public static void fun(Message<? super String> temp) {
        System.out.println(temp.getContent());
    }
}

```

对于通配符而言是一个重要的概念，并且要求一定可以理解此概念的定义，在java的系统类库里会大量出现



## 泛型接口

泛型除了可以在类上定义之外也可以直接在接口之中进行使用，例如：

![image-20200725231411370](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200725231411370.png)

实现方式一：在子类之中继续设置泛型定义

```java
interface IMessage<T>{ 
    public String echo(T t);
}
class MessageImpl<S> implements IMessage<S> {
    public String echo(S t) {
        return "【ECHO】" + t;
    }
}
public class JavaDemo {
    public static void main (String[] args) {
        IMessage<String> msg = new MessageImpl<String>();
        System.out.println(msg.echo("Message"));
    }
}
```

> 【ECHO】Message

实现方式二：在子类实现父接口时直接指定泛型的类型

```java
interface IMessage<T>{ 
    public String echo(T t);
}
class MessageImpl implements IMessage<String> {
    public String echo(String t) {
        return "【ECHO】" + t;
    }
}
public class JavaDemo {
    public static void main (String[] args) {
        IMessage<String> msg = new MessageImpl();
        System.out.println(msg.echo("Message"));
    }
}
```

从概念和实现上来讲并不复杂，但是在日后会遇见大量出现有泛型的接口，这个时候一定要清楚两种实现原则



## 泛型方法

在之前的程序类里面实际上已经可以发现在反省类之中如果将泛型 标记写在了方法撒谎给你，那么这样的方法就被称为泛型方法，但是需要注意的是，泛型方法不一定非要出现在泛型类之中，即：如果一个类上没有定义泛型，那么也可以使用泛型方法

```java
public class JavaDemo {
    public static void main (String[] args) {
    }

    public static T[] fun(T ... args) {
        return args;
    }
}
```

如果以上写法会认为T是一个数据类型

> JavaDemo.java:5: 错误: 找不到符号
>     public static T[] fun(T ... args) {
>                           ^
>   符号:   类 T
>   位置: 类 JavaDemo
> JavaDemo.java:5: 错误: 找不到符号
>     public static T[] fun(T ... args) {
>                   ^
>   符号:   类 T
>   位置: 类 JavaDemo
> 2 个错误

 ```java
public class JavaDemo {
    public static void main (String[] args) {
        Integer num [] = fun(1,2,3); //传入了Integer，则泛型类型就是Integer
        for(int temp:num) {
            System.out.print(temp + "、");
        }
    }

    public static <T> T[] fun(T ... args) {
        return args;
    }
}
 ```

在后期进行项目开发的时候，这种方法很常见，以工厂设计为例

![image-20200725232756538](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200725232756538.png)

如果一个接口的对象就编写一个工厂类，如果一个项目有上千个接口，到时候满眼望去都是绝望的身影。

如果写在一个工厂类里？

![image-20200725233023555](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200725233023555.png)

### TODO：范例：利用泛型改进工厂

```java
interface IMessage {
    public void send(String str);
}
class MessageImpl implements IMessage {
    public void send(String str) {
        System.out.println("消息发送：" +str);
    }
}
class Factory {
    public static <T> T getInsatnce(String className,T t) {
        if("messageImpl".equalsIgnoreCase(className)) {
            return new MessageImpl();
        }
        return null;
    }
}
public class JavaDemo {
    public static void main (String[] args) {
        IMessage msg = (IMessage) Factory.getInsatnce("messageImpl",IMessage.class);
        msg.send("Message");
    }
}
```

> JavaDemo.java:12: 错误: 不兼容的类型: MessageImpl无法转换为T
>             return new MessageImpl();
>                    ^
>   其中, T是类型变量:
>     T扩展已在方法 <T>getInsatnce(String,T)中声明的Object
> JavaDemo.java:19: 错误: 不兼容的类型: Class<IMessage>无法转换为IMessage
>         IMessage msg = (IMessage) Factory.getInsatnce("messageImpl",IMessage.class);
>                                                      ^
> 注: JavaDemo.java使用了未经检查或不安全的操作。
> 注: 有关详细信息, 请使用 -Xlint:unchecked 重新编译。
> 2 个错误

https://www.jb51.net/article/173548.html

抽象类

```java

import com.alibaba.fastjson.JSON;
import com.fawvw.ms.ap.cw06.recommend.vo.PushMessageVo;
import java.lang.reflect.ParameterizedType;
import java.util.Map;

/**
 * @ClassName ConvertService
 * @Description 对kafka发送过来的数据进行转换
 * @Author jian.sun.qd
 * @Date 2020/6/10 15:16
 * @Version 1.0
 **/
public abstract class ConvertService<T> {

    private Class<T> clazz;

    /**
     * 业务回调
     *
     * @param target
     */
    protected abstract PushMessageVo doServe(T target);

    /**
     * 类型转换为接收Vo
     *
     */
    public PushMessageVo convert(Map data) {
        if (clazz == null) {
            ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
            this.clazz = (Class<T>) type.getActualTypeArguments()[0];
        }

        //将判断kafka的map转换为Vo
        T target = JSON.parseObject(JSON.toJSONString(data), clazz);
        return doServe(target);
    }
}
```

调用处

```java
@Autowired
ApplicationContext ac;
Object action = ac.getBean(pushSetting.getAction().getActionCode());
ConvertService actionService = (ConvertService) action;
```

实现类

```java
@Service("ResetDriveTime")
public class ResetDriveTimeAction extends ConvertService<ScenarioResultVo> {
     @Override
    protected PushMessageVo doServe(ScenarioResultVo snapshot) {
        return null;
    }
}
```



# 第23章：包的定义及使用

在实际的项目开发过程之中，肯定一定有包的概念，利用包可以实现类的包装，在yih偶的实际开发之中，所有类都必须要放在包里

## 包的定义与使用

![image-20200726105939552](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200726105939552.png)

范例：定义包

```java
package com.faw_vw.ms; //定义包，其中.表示分割子目录（子）
public class JavaDemo {
    public static void main (String[] args) {
        System.out.print("Hello World");
    }
}
```

![image-20200726110658632](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200726110658632.png)



javac -d . JavaDemo.java

java com.faw_vw.ms.JavaDemo



## 包的导入

![image-20200726113111811](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200726113111811.png)

```java
package com.faw_vw.ms.util; //定义包，其中.表示分割子目录（子）
public class Message {
    public String getContent() {
        return "This is a Message";
    }
}
```

范例：定义测试类使用Message类

```java
package com.faw_vw.ms.test; 
import com.faw_vw.ms.util.Message;
public class JavaDemo {
    public static void main (String[] args) {
        Message msg = new Message();
        System.out.println(msg.getContent());
    }
}
```

此时按照使用顺序来讲，肯定要先编译Message.java，然后再编译JavaDemo.java。思考一个问题，如果写了一个程序代码，里面有100个类，彼此之间互相严格引用，该怎么区分？这个时候最好的做法是不区分顺序，直接交给Java自己完成，编译命令：javac -d . *.java

![image-20200726114611150](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200726114611150.png)

如果被引用的没有加public

class Message {}

> JavaDemo.java:2: 错误: Message在com.faw_vw.ms.util中不是公共的; 无法从外部程序包中对其进行访问
> import com.faw_vw.ms.util.Message;
>                          ^
> JavaDemo.java:5: 错误: Message在com.faw_vw.ms.util中不是公共的; 无法从外部程序包中对其进行访问
>         Message msg = new Message();
>         ^
> JavaDemo.java:5: 错误: Message在com.faw_vw.ms.util中不是公共的; 无法从外部程序包中对其进行访问
>         Message msg = new Message();
>                           ^
> 3 个错误

```java
package com.faw_vw.ms.test; 
import com.faw_vw.ms.util.*;   //导入其他包的类
public class JavaDemo {
    public static void main (String[] args) {
        Message msg = new Message();
        System.out.println(msg.getContent());
    }
}
```

即便此时使用了“包.*”的导入形式，那么也不表示会进行全部的加载，它会根据自己的需要加载所需要的程序类，而不需要的程序类是不会被加载的，所以是使用“*” 还是使用具体的类最终的性能是完全相同的。

但是如果在开发之中采用的是“包.*”的形式进行包 的导入时，那么有一点会比较麻烦：有可能两个不同的包中存在有相同的类名称，例如：现在假设JavaDemo类由于某种需要导入两个包：com.faw_vw.ms.util  org.demo，但是这两个包里面都有Message类

| package | com.faw_vw.ms.util                                           | org.demo                                                     |
| ------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| 代码    | package com.faw_vw.ms.util; //定义包，其中.表示分割子目录（子）<br/>public class Message {<br/>    public String getContent() {<br/>        return "This is a Message";<br/>    }<br/>} | package org.demo; //定义包，其中.表示分割子目录（子）<br/>public class Message {<br/>    public String getContent() {<br/>        return "中华人民共和国";<br/>    }<br/>} |

由于某种需要，在JavaDemo里导入了两个包

```java
package com.faw_vw.ms.test; 
import com.faw_vw.ms.util.*;   //导入其他包的类
import org.demo.*;   //导入其他包的类
public class JavaDemo {
    public static void main (String[] args) {
        Message msg = new Message();
        System.out.println(msg.getContent());
    }
}
```

> JavaDemo.java:6: 错误: 对Message的引用不明确
>         Message msg = new Message();
>         ^
>   org.demo 中的类 org.demo.Message 和 com.faw_vw.ms.util 中的类 com.faw_vw.ms.util.Message 都匹配
> JavaDemo.java:6: 错误: 对Message的引用不明确
>         Message msg = new Message();
>                           ^
>   org.demo 中的类 org.demo.Message 和 com.faw_vw.ms.util 中的类 com.faw_vw.ms.util.Message 都匹配
> 2 个错误

这个时候发现类名称相同的时候就会出现引用不明确的问题，所以此时最简单的处理方式就是直接写上类的完整名称

```java
package com.faw_vw.ms.test; 
import com.faw_vw.ms.util.*;   //导入其他包的类
import org.demo.*;   //导入其他包的类
public class JavaDemo {
    public static void main (String[] args) {
        com.faw_vw.ms.util.Message msg = new com.faw_vw.ms.util.Message();
        System.out.println(msg.getContent());
    }
}
```

在日后的开发过程之中，经常会见到大量的重名的类（包不重名），此时为了更好的解决问题，往往会使用类的完整名称。

或者单独导入完整类路径



## 包的静态导入

加入说现在有一个类，这个类中的全部方法都是static方法，那么按照原始的做啊肯定要导入程序所在的包.类，而后才可以通过类名称调用这些静态方法。



范例：定义一个数学类

```java
package com.faw_vw.ms.util; //定义包，其中.表示分割子目录（子）
public class Message {
    public static int add(int ... args) {
        int sum - 0;
        for (int temp : args) {
            sum += temp;
        }
        return sum;
    }
    public static int sub(int x, int y) {
        return x - y;
    }
}
```

此时如果按照原始的方式进行导入处理，那么此时需要导入类名称，然后类.方法调用

```java
package com.faw_vw.ms.test; 
import com.faw_vw.ms.util.Message;   //导入其他包的类
public class JavaDemo {
    public static void main (String[] args) {
        System.out.println(Message.add(10,20,30));
        System.out.println(Message.sub(30,20));
    }
}
```

从JDK1.5开始对于类中全部由静态方法提供的特殊类是可以采用静态导入处理形式的

范例：静态导入处理

```java
package com.faw_vw.ms.test; 
import static com.faw_vw.ms.util.Message.*;   //导入其他包的类
public class JavaDemo {
    public static void main (String[] args) {
        System.out.println(add(10,20,30));
        System.out.println(sub(30,20));
    }
}
```

就好像该方法是直接定义在主类中的，可以由主方法直接调用。

不建议用，很少有人这么写



## Jar命令（了解）

![image-20200726143412110](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200726143412110.png)

JDK14

```
E:\software\javadev\Java\jdk-14.0.1\bin>jar
用法: jar [OPTION...] [ [--release VERSION] [-C dir] files] ...
尝试使用 `jar --help' 获取详细信息。

E:\software\javadev\Java\jdk-14.0.1\bin>jar --help
用法: jar [OPTION...] [ [--release VERSION] [-C dir] files] ...
jar 创建类和资源的档案, 并且可以处理档案中的
单个类或资源或者从档案中还原单个类或资源。

 示例:
 # 创建包含两个类文件的名为 classes.jar 的档案:
 jar --create --file classes.jar Foo.class Bar.class
 # 使用现有的清单创建档案, 其中包含 foo/ 中的所有文件:
 jar --create --file classes.jar --manifest mymanifest -C foo/ .
 # 创建模块化 jar 档案, 其中模块描述符位于
 # classes/module-info.class:
 jar --create --file foo.jar --main-class com.foo.Main --module-version 1.0
     -C foo/ classes resources
 # 将现有的非模块化 jar 更新为模块化 jar:
 jar --update --file foo.jar --main-class com.foo.Main --module-version 1.0
     -C foo/ module-info.class
 # 创建包含多个发行版的 jar, 并将一些文件放在 META-INF/versions/9 目录中:
 jar --create --file mr.jar -C foo classes --release 9 -C foo9 classes

要缩短或简化 jar 命令, 可以在单独的文本文件中指定参数,
并使用 @ 符号作为前缀将此文件传递给 jar 命令。

 示例:
 # 从文件 classes.list 读取附加选项和类文件列表
 jar --create --file my.jar @classes.list


 主操作模式:

  -c, --create               创建档案
  -i, --generate-index=FILE  为指定的 jar 档案生成
                             索引信息
  -t, --list                 列出档案的目录
  -u, --update               更新现有 jar 档案
  -x, --extract              从档案中提取指定的 (或全部) 文件
  -d, --describe-module      输出模块描述符或自动模块名称

 在任意模式下有效的操作修饰符:

  -C DIR                     更改为指定的目录并包含
                             以下文件
  -f, --file=FILE            档案文件名。省略时, 基于操作
                             使用 stdin 或 stdout
      --release VERSION      将下面的所有文件都放在
                             jar 的版本化目录中 (即 META-INF/versions/VERSION/)
  -v, --verbose              在标准输出中生成详细输出

 在创建和更新模式下有效的操作修饰符:

  -e, --main-class=CLASSNAME 捆绑到模块化或可执行
                             jar 档案的独立应用程序
                             的应用程序入口点
  -m, --manifest=FILE        包含指定清单文件中的
                             清单信息
  -M, --no-manifest          不为条目创建清单文件
      --module-version=VERSION    创建模块化 jar 或更新
                             非模块化 jar 时的模块版本
      --hash-modules=PATTERN 计算和记录模块的散列,
                             这些模块按指定模式匹配并直接或
                             间接依赖于所创建的模块化 jar 或
                             所更新的非模块化 jar
  -p, --module-path          模块被依赖对象的位置, 用于生成
                             散列

 只在创建, 更新和生成索引模式下有效的操作修饰符:

  -0, --no-compress          仅存储; 不使用 ZIP 压缩

 其他选项:

  -?, -h, --help[:compat]    提供此帮助，也可以选择性地提供兼容性帮助
      --help-extra           提供额外选项的帮助
      --version              输出程序版本

 如果模块描述符 'module-info.class' 位于指定目录的
 根目录中, 或者位于 jar 档案本身的根目录中, 则
 该档案是一个模块化 jar。以下操作只在创建模块化 jar,
 或更新现有的非模块化 jar 时有效: '--module-version',
 '--hash-modules' 和 '--module-path'。

 如果为长选项提供了必需参数或可选参数, 则它们对于
 任何对应的短选项也是必需或可选的。
```

JDK8

```
C:\Users\jian.sun.qd>jar
用法: jar {ctxui}[vfmn0PMe] [jar-file] [manifest-file] [entry-point] [-C dir] files ...
选项:
    -c  创建新档案
    -t  列出档案目录
    -x  从档案中提取指定的 (或所有) 文件
    -u  更新现有档案
    -v  在标准输出中生成详细输出
    -f  指定档案文件名
    -m  包含指定清单文件中的清单信息
    -n  创建新档案后执行 Pack200 规范化
    -e  为捆绑到可执行 jar 文件的独立应用程序
        指定应用程序入口点
    -0  仅存储; 不使用任何 ZIP 压缩
    -P  保留文件名中的前导 '/' (绝对路径) 和 ".." (父目录) 组件
    -M  不创建条目的清单文件
    -i  为指定的 jar 文件生成索引信息
    -C  更改为指定的目录并包含以下文件
如果任何文件为目录, 则对其进行递归处理。
清单文件名, 档案文件名和入口点名称的指定顺序
与 'm', 'f' 和 'e' 标记的指定顺序相同。

示例 1: 将两个类文件归档到一个名为 classes.jar 的档案中:
       jar cvf classes.jar Foo.class Bar.class
示例 2: 使用现有的清单文件 'mymanifest' 并
           将 foo/ 目录中的所有文件归档到 'classes.jar' 中:
       jar cvfm classes.jar mymanifest -C foo/ .
```



下面通过程序的具体演示来实现jar的使用和配置的操作

1. 定义一个程序类，代码如下

   ```java
   package com.faw_vw.ms.util; //定义包，其中.表示分割子目录（子）
   public class Message {
       public String getContent() {
           return "This is a Message";
       }
   }
   ```

2. 对程序进行编译和打包处理：

   1. * 对程序进行打包编译： javac -d . Message.java;
      * 此时生成了com包，里面包括相应 的子包与*.class文件，将其打包为faw.jar： jar -cvf faw.jar com
        * -c：得到一个新的jar文件
        * -v：得到详细输出
        * -f：设置要生成jar文件名称，本处定义的faw.jar
      * ![image-20200726144534385](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200726144534385.png)

3. 每一个*.jar文件都是独立的程序路径，如果要想在Java程序之中使用此路径，需要在classpath进行配置

   1. 如果把jar和主文件放在同目录无法使用

      * > JavaDemo.java:2: 错误: 程序包com.faw_vw.ms.util不存在
        > import static com.faw_vw.ms.util.Message.*;   //导入其他包的类
        >                                 ^
        > JavaDemo.java:5: 错误: 找不到符号
        >         System.out.println(add(10,20,30));
        >                            ^
        >   符号:   方法 add(int,int,int)
        >   位置: 类 JavaDemo
        > JavaDemo.java:6: 错误: 找不到符号
        >         System.out.println(sub(30,20));
        >                            ^
        >   符号:   方法 sub(int,int)
        >   位置: 类 JavaDemo
        > 3 个错误

      * jar文件内部有说明文件![image-20200726144800872](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200726144800872.png)
      * ![image-20200726144918428](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200726144918428.png)

   2. 设置classpath

      * SET CLASSPATH=.;E:\software\javadev\Java\jdk-14.0.1\bin\faw.jar

4. 建立测试类，直接导入Message类并调用方法

   1. 代码

      * ```java
        package com.faw_vw.ms.test; 
        import com.faw_vw.ms.util.Message;   //导入其他包的类
        public class JavaDemo {
            public static void main (String[] args) {
                Message msg = new Message();
                System.out.println(msg.getContent());
           }
        }
        ```

      * 编译并使用JavaDemo类

        * 编译：javac -d . JavaDemo.java
        * 执行：java com.faw_vw.ms.test.JavaDemo

      ![image-20200726145805610](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200726145805610.png)

如果编译通过之后由于CLASSPATH发生了改变，类无法加载到了，则执行JavaDemo类时会报错

> Exception in thread "main" java.lang.NoClassDefFoundError: com/faw_vw/ms/util/Message
>         at com.faw_vw.ms.test.JavaDemo.main(JavaDemo.java:5)
> Caused by:...

![image-20200726150235302](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200726150235302.png)

JDK1.8

![image-20200726150640997](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200726150640997.png)

JDK1.9

![image-20200726150719067](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200726150719067.png)



## 系统常用包

![image-20200726150535067](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200726150535067.png)



世界最大的三个仓库，java>> ruby +  go

最初的jdk做applet时使用了大量windows组件，使用java.awt。后来使用了轻量化swing，这也是jdk1.2的标志



##　访问控制权限

在面向对象的开发过程有三大主要特点:封装、继承、多态。

封装：属性封装、结构封装，访问权限。

对于封装性而言，主要依靠的是访问控制权限。一共有四种：private、default（不写）、protect、public

| NO   | 访问范围         | private | default | protected | public |
| ---- | ---------------- | ------- | ------- | --------- | ------ |
| 1    | 同一包中的同一类 | √       | √       | √         | √      |
| 2    | 同一包中的不同类 |         | √       | √         | √      |
| 3    | 不同包的子类     |         |         | √         | √      |
| 4    | 不同包的所有类   |         |         |           | √      |



整个访问控制中，只有protected（受保护）的权限是比较新的概念，定义两个类：

* com.faw_vw.ms.a.Message类：提供protected访问权限
* com.faw_vw,ms.b.NetMessage类：将直接访问protected属性

范例：

```java
package com.faw_vw.ms.a; //定义包，其中.表示分割子目录（子）
public class Message {
    protected String info =  "This is a Message";
}
```

范例：定义子类，与父类不在同一个包

```java
package com.faw_vw.ms.b; 
import com.faw_vw.ms.a.Message;   //导入其他包的类
public class NetMessage extends Message {
    public void print() {
        System.out.println(super.info);
    }
}
```

范例：测试类

```java
package com.faw_vw.ms.test; 
import com.faw_vw.ms.a.*;   //导入其他包的类
public class JavaDemo {
    public static void main (String[] args) {
        new NetMessage().print();
    }
}
```

此程序通过子类访问了父类中的portected属性，但如果直接访问父类的protected属性，就会报错

范例:在测试类中直接访问Message属性

```java
package com.faw_vw.ms.test; 
import com.faw_vw.ms.a.*;   //导入其他包的类
public class JavaDemo {
    public static void main (String[] args) {
        System.out.println(new Message().info);
    }
}
```



> JavaDemo.java:5: 错误: info 在 Message 中是 protected 访问控制
>         System.out.println(new Message().info);
>                                         ^
> 1 个错误

如果每次都要考虑权限设置比较麻烦，给出参考的选择方案：

* 属性定义，用private
* 方法定义，用public
* 有些时候根据实际情况调整
* **最小开放权限**



# 第24章：UML图形

UML是统一的建模语言，本质就是利用图形化的形式来实现程序类关系的描述。在之前已经画出了大量的图形，这些图形都是按照UML标准进行的，并且最早并且使用最广泛的设计工具：Rational Rose，而后出现越来越多的设计工具，而像PoweDesigner也可以实现这些类图的定义。

现在大都是写出来代码再转化生成类图



## 类图描述

一般情况如果要想进行类结构的描述，往往可以使用三层的结构来表示：

![image-20200726164122134](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200726164122134.png)



![image-20200726164211754](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200726164211754.png)

开发者可以随意找到一些小的免费的开发工具，这里使用PowerDesigner



新建

![image-20200726164651773](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200726164651773.png)

![image-20200726164953219](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200726164953219.png)

![image-20200726165106245](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200726165106245.png)

![image-20200726165234159](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200726165234159.png)

在进行类图定义是，可以设置类中属性（Attribute），方法（Operation）

![image-20200726165538271](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200726165538271.png)

![image-20200726170153638](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200726170153638.png)

构造器

![image-20200726172149816](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200726172149816.png)

![image-20200726172359987](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200726172359987.png)

![image-20200726172611247](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200726172611247.png)

![image-20200726173113457](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200726173113457.png)

选择语言

![image-20200726173405285](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200726173405285.png)

ctrl+g生成代码

![image-20200726173459190](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200726173459190.png)

![image-20200726173651573](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200726173651573.png)

接口



抽象类

![image-20200726173737939](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200726173737939.png)

![image-20200726173942627](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200726173942627.png)



![image-20200726173851747](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200726173851747.png)



实际开发之中，花大量人力进行这样的设计一定是没有意义的无用功，所以一般会将程序的代码通过转换引擎变为图形显示

![image-20200726174132913](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200726174132913.png)

选择语言

![image-20200726174151523](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200726174151523.png)



选择路径

![image-20200726174234676](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200726174234676.png)

找到我们的程序类

生成视图

![image-20200726174341042](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200726174341042.png)



## 时序图

时序图只要描述的是代码的执行流程

```java
interface IMessage {//定义了一个接口
    public void send();
}
class MessageImpl implements IMessage {
    public MessageImpl() {
        this.connect(); //调用本类方法
    }
    public void send() {
		System.out.println("send Message");
    }
    public void connect() {
        System.out.println("进行消息发送通道连接");
    }
}
class Factory {
    public static IMessage getInstance() {
		return new MessageImpl();
    }
}
public class JavaDemo {
    public static void main (String[] args) {
        IMessage msg = Factory.getInstance();
        msg.send();
    }
}
```

![image-20200726174840199](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200726174840199.png)

![image-20200726175031569](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200726175031569.png)

绘制时序图

![image-20200726175734325](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200726175734325.png)



## 用例图

yonglitu 描述 是程序的执行分配，例如：现在如果是系统管理员可能用偶系统初始化、系统备份、公告发布的功能，而普通的公告管理员只是负责公告的管理，不应该负责系统的管理，所以就可以在设计书上写一些用例图加以说明

![image-20200726175931196](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200726175931196.png)

![image-20200726180116183](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200726180116183.png)

![image-20200726180159092](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200726180159092.png)



# 第25章：单例设计模式

单例设计模式（多例设计模式）主要是一种控制实例化对象产生个数的设计操作

## 单例设计

如果有一个程序，定义如下

```java
class Singleton {
    public void print() {
        System.out.println("Hello World");
    }
}
public class JavaDemo {
    public static void main (String[] args) {
        Singleton instanceA = new Singleton();
        Singleton instanceB = new Singleton();
        Singleton instanceC = new Singleton();
        instanceA.print();
        instanceB.print();
        instanceC.print();
    }
}
```

但是由于某些要求，现在要求Singleton这个类只允许有一个实例化对象。那么此时首先应该控制的是构造方法。因为所有新的实例化对象产生了，那么一定要调用构造方法，如果构造方法不可用了，就能保证只有一个实例。

范例：构造方法私有化

```java
class Singleton {
    private Singleton() {}//构造方法私有化
    public void print() {
        System.out.println("Hello World");
    }
}
public class JavaDemo {
    public static void main (String[] args) {
        Singleton instance = null; //声明对象
        instance = new Singleton(); //实例化对象
    }
}
```

> JavaDemo.java:10: 错误: Singleton() 在 Singleton 中是 private 访问控制
>         instance = new Singleton(); //实例化对象
>                    ^
> 1 个错误

但是现在有一个严格要求：必须产生有一个实例化对象。现在是不能产生了。所以必须想办法产生一个实例化对象交给客户端使用。这个时候的分析如下：

1. private权限不能在外部访问，可以在类本身调用，考虑在内部调用构造

```java
class Singleton {
    private Singleton instance = new Singleton();
    private Singleton() {}//构造方法私有化
    public void print() {
        System.out.println("Hello World");
    }
}
```

2. 此时Singleton类内部的instance是一个普通属性，而普通属性在有实例化对象时才会被调用，此时外部无法产生实例化对象，该属性就不可访问了。只有static属性可以

   ```java
   class Singleton {
       public static Singleton instance = new Singleton();
       private Singleton() {}//构造方法私有化
       public void print() {
           System.out.println("Hello World");
       }
   }
   public class JavaDemo {
       public static void main (String[] args) {
           Singleton instance = null; //声明对象
           instance = Singleton.instance; //实例化对
           instance.print();
       }
   }
   ```

3. 类中的属性应该封装后使用，理论上instance属性应该封装起来，用get方法获得

   ```java
   class Singleton {
       private static Singleton instance = new Singleton();
       public static Singleton getInstance() {
           return instance;
       }
       private Singleton() {}//构造方法私有化
       public void print() {
           System.out.println("Hello World");
       }
   }
   public class JavaDemo {
       public static void main (String[] args) {
           Singleton instance = null; //声明对象
           instance = Singleton.getInstance(); //实例化对
           instance.print();
       }
   }
   ```

4. 整个代码强调的是只有一个实例化对象，这个时候虽然提供了static的实例化对象，但是这个对象仍然可以被重新实例化。需要保证Singleton内部无法重新实例化

   ```java
   class Singleton {
       private static Singleton instance = new Singleton();
       public static Singleton getInstance() {
           instance = new Singleton();//每次都会新实例化
           return instance;
       }
       private Singleton() {}//构造方法私有化
       public void print() {
           System.out.println("Hello World");
       }
   }
   ```

5. 应该用final定义

```java
class Singleton {
    private static final Singleton INSTANCE = new Singleton();
    public static Singleton getInstance() {
        return INSTANCE;
    }
    private Singleton() {}//构造方法私有化
    public void print() {
        System.out.println("Hello World");
    }
}
```

在很多情况下有些类是不需要重复产生对象的，例如：如果一个程序启动，现在肯定需要有一个类负责保存有一些程序加载的数据信息。

![image-20200726185236609](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200726185236609.png)

windows中也有单例设计的存在。

比如回收站，每个盘都有RecycleBean，每个盘打开都是同一个。共用同一个回收站

对于单例设计模式也分为两种：懒汉式、饿汉式。在之前所定义的都属于饿汉式。在系统加载类的时候就会自动提供有Singleton类的实例化，而含有一种懒汉式，在第一次使用的时候进行实例化处理。

范例：观察懒汉式

```java
class Singleton {
    private static Singleton instance = new Singleton();
    private Singleton() {}//构造方法私有化
    public static Singleton getInstance() {
         if (instance == null) {//第一次使用
            instance = new Singleton();//实例化对象
         }
        return instance;
    }
    public void print() {
        System.out.println("Hello World");
    }
}
public class JavaDemo {
    public static void main (String[] args) {
        Singleton instance = null; //声明对象
        instance = Singleton.getInstance(); //实例化对
        instance.print();
    }
}
```

在多线程时，会详解懒汉和饿汉式

**面试题：请编写一个Singleton程序，并说明其主要特点**

* 代码如上，可以把懒汉式（后面需要考虑线程同步问题）和饿汉式都写上
* 特点：构造方法私有化，类内部提供static方法获取实例化对象，这样不管外部如何操作，都只有一个实例



## 多例设计

与单例设计对应的还有一个称为多例设计，单例设计是只保留有一个实例化对象，多例对象是可以保留有多个实例化对象，例如：如果现在要定义一个描述性别的类，那么该对象只有两个：男、女。或者描述颜色基色的类，可以使用：红色、绿色、蓝色。这种情况下就可以利用多例设计来解决。

范例：实现多例设计

```java
class Color {//定义描述颜色的类
    private static final Color RED = new Color("红色");
    private static final Color GREEN = new Color("绿色");
    private static final Color BLUE = new Color("蓝色");
    private String title;
    private Color(String title) {//
        this.title = title;
    }
    public static Color getInstance(String color) {
        switch(color) {
            case "red" : return RED;
            case "green" : return GREEN;
            case "blue" : return BLUE;
            default: return null;
        }
    }
    public String toString() {
        return this.title;
    }

}
public class JavaDemo {
    public static void main (String[] args) {
        Color g = Color.getInstance("green");
        System.out.println(g);
        Color r = Color.getInstance("red");
        System.out.println(r);
    }
}
```

> 绿色
> 红色

多例设计与单例设计的本质是相同的，一定都会在内部提供有static方法已返回实例化对象。



# 第26章：枚举

很多的编程语言都会提供有枚举的概念，但是Java一直到JDK1.5之后才提出了所谓枚举的概念。在实际的开发之中枚举的主要作用适用于定义有限个数对象的一种结构（多例设计），枚举就属于多例设计，并且其结构要比多利设计更加的简单。

> 前文所述的多例设计模式是在枚举使用之前所用的方式，有了之后就不用该方式了

## 枚举的基本定义

从JDK1.5之后程序提供有enum关键字，利用此关键字可以实现枚举的定义

范例：定义一个枚举，表示颜色基色

```java
enum Color {//枚举类
    红色,绿色,蓝色; //实例化对象
}
public class JavaDemo {
    public static void main (String[] args) {
        Color r = Color.红色; //获取实例化对象
        System.out.println(r);
        Color g = Color.绿色;
        System.out.println(g);
    }
}
```

```java
enum Color {//枚举类
    RED,GREEN,BLUE; //实例化对象
}
public class JavaDemo {
    public static void main (String[] args) {
        Color r = Color.RED; //获取实例化对象
        System.out.println(r);
        Color g = Color.GREEN;
        System.out.println(g);
    }
}
```

![image-20200727223404218](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200727223404218.png)

* 多例方式填错信息编译不会报错，执行出空指针

  * > ```java
    > public static void main (String[] args) {
    >     Color g = Color.getInstance("black");
    >     System.out.println(g);
    > }
    > ```

* 枚举方式填错信息编译直接报错

  * > ```java
    > public static void main (String[] args) {
    >     Color r = Color.BLACK; //获取实例化对象
    >     System.out.println(r);
    > }
    > ```

范例：获取所有的枚举对象

```java
enum Color {//枚举类
    RED,GREEN,BLUE; //实例化对象
}
public class JavaDemo {
    public static void main (String[] args) {
        for (Color c : Color.values()) {//获取所有值
            System.out.println(c);
        }
    }
}
```

> RED
> GREEN
> BLUE

如果此时同样的功能需要多例设计来解决的花，那么就需要使用对象数组了。

从JDK1.5追加了枚举结构之后，就可以在swtich之中进行枚举项的判断

范例：观察枚举与swtich处理

```java
enum Color {//枚举类
    RED,GREEN,BLUE; //实例化对象
}
public class JavaDemo {
    public static void main (String[] args) {
        Color c = Color.RED; 
        switch (c) {//直接支持枚举
            case RED:
                System.out.println("红色");
                break;
            case GREEN:
                System.out.println("绿色");
                break;
            case BLUE:
                System.out.println("蓝色");
                break;
        }
    }
}
```

多例上是无法实现这种与switch直接连接的，多黎耀祥实现它就需要编写大量的if判断。



## Enum类

严格意义上枚举并不属于一种新的结构，他的本质i相当于是一个类，但是这个类默认会继承Enum类，首先观察Enum类的基本定义。

属于java,lang包

![image-20200727224730869](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200727224730869.png)

类的基本定义

> public abstract class Enum<E extends Enum<E>> 
>
> extends Object
>
> implents Comparable<E>,Serializable

现在定义的枚举类的类型就是Enum中所使用的E类型。下面来观察一下Enum类中定义的方法。

![image-20200727225005336](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200727225005336.png)

后两个无法覆写

范例：观察Enum类

```java
enum Color {//枚举类
    RED,GREEN,BLUE; //实例化对象
}
public class JavaDemo {
    public static void main (String[] args) {
        for (Color c : Color.values()) {
            System.out.println(c.ordinal() + "-" + c.name());
        }
    }
}
```

> 0-RED
> 1-GREEN
> 2-BLUE

![image-20200727225357606](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200727225357606.png)



## 定义枚举结构

一直在强调枚举本身就属于一种多例设计模式，那么既然是多例设计模式，那么在一个类之中可以定义的结果是非常多的，例如：构造方法、普通方法、属性等。那么这些内容在枚举类中依然可以直接定义，但是需要注意的是：枚举类中定义的构造方法不能够使用非私有化定义（public无法使用）

范例：在枚举类中定义其他的结构

```java
enum Color {//枚举类
    RED("红色"),GREEN("绿色"),BLUE("蓝色"); //枚举对象写在首行对象
        //调用有参构造
    private String title; //定义属性
    private Color(String title) {
        this.title = title;
    }
    public String toString() {
        return this.title;
    }
}
public class JavaDemo {
    public static void main (String[] args) {
        for (Color c : Color.values()) {
            System.out.println(c.ordinal() + "-" + c.name());
        }
    }
}
```

本程序在简化程度上一定要远远高于多例设计模式。除了这种基本的结构之外，在枚举类也可以实现接口的继承。

范例：让枚举实现接口

```java
interface IMessage {
    public String getMessage();
}
enum Color implements IMessage {//枚举类
    RED("红色"),GREEN("绿色"),BLUE("蓝色"); //枚举对象写在首行对象

    private String title; //定义属性
    private Color(String title) {
        this.title = title;
    }
    public String toString() {
        return this.title;
    }
    public String getMessage() {
        return this.title;
    }
}
public class JavaDemo {
    public static void main (String[] args) {
        IMessage msg = Color.RED;
        System.out.println(msg.getMessage());
    }
}
```

在枚举类里面最有意思的是它可以直接定义抽象方法，并且要求每一个枚举对象都要独立覆写此抽象方法。

范例：观察枚举中定义抽象方法,没啥用

```java
enum Color implements IMessage {//枚举类
    RED("红色") {
        public String getMessage() {
            return this.title;
        }
    },GREEN("绿色") {        
        public String getMessage() {
            return this.title;
        }
    },BLUE("蓝色") {
        public String getMessage() {
            return this.title;
        }
    }; //枚举对象写在首行对象

    private String title; //定义属性
    private Color(String title) {
        this.title = title;
    }
    public String toString() {
        return this.title;
    }
    public abstract  String getMessage();
}
public class JavaDemo {
    public static void main (String[] args) {
        System.out.println(Color.RED.getMessage());
    }
}
```

> JavaDemo.java:4: 错误: title 在 Color 中是 private 访问控制
>             return this.title;
>                        ^
> JavaDemo.java:8: 错误: title 在 Color 中是 private 访问控制
>             return this.title;
>                        ^
> JavaDemo.java:12: 错误: title 在 Color 中是 private 访问控制
>             return this.title;
>                        ^
> 3 个错误

```java
enum Color {//枚举类
    RED("红色") {
        public String getMessage() {
            return this.toString();
        }
    },GREEN("绿色") {        
        public String getMessage() {
            return this.toString();
        }
    },BLUE("蓝色") {
        public String getMessage() {
            return this.toString();
        }
    }; //枚举对象写在首行对象

    private String title; //定义属性
    private Color(String title) {
        this.title = title;
    }
    public String toString() {
        return this.title;
    }
    public abstract  String getMessage();
}
public class JavaDemo {
    public static void main (String[] args) {
        System.out.println(Color.RED.getMessage());
    }
}
```

发现枚举的定义是非常灵活的，但是在实际的使用之中，枚举更多情况下还是建议使用它的正确用法，就是定义一个实例对象即可

## 枚举的实际应用

![image-20200727231739193](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200727231739193.png)

```java
enum Sex {//枚举类
    MALE("男"),FEMALE("女");
    private String title;
    private Sex(String title) {
        this.title = title;
    } 
    public String toString() {
        return this.title;
    }
}
class Person {
    private String name;
    private int age;
    private Sex sex;
    public Person(String name,int age,Sex sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
    public String toString() {
        return "姓名：" + this.name + "、年龄：" + this.age + "、性别：" + this.sex;
    }

}
public class JavaDemo {
    public static void main (String[] args) {
        System.out.println(new Person("张三",20,Sex.MALE));
    }
}
```

这个程序如果性别写错会报错，实际上不使用枚举也可以正常实现，追加几个判断就可。所以对于枚举是否使用都可以。



# 第27章：异常的捕获及处理

Java语言提供的最为强大的支持就在异常的处理操作上

## 认识异常对程序的影响

异常指的是导致程序中断执行的一种指令流，那么下首先观察没有异常产生的程序执行结果

范例：没有异常产生

```java
public class JavaDemo {
    public static void main (String[] args) {
        System.out.println("【1】*******程序开始执行***");
        System.out.println("【2】*******数学计算：" + (10/2));
        System.out.println("【3】*******程序执行完毕***");
    }
}
```

```
【1】*******程序开始执行***
【2】*******数学计算：5
【3】*******程序执行完毕***
```

在程序执行正常的过程里面会发现，所有的程序会按照既定的结构从头到尾开始执行

范例：产生异常

```java
public class JavaDemo {
    public static void main (String[] args) {
        System.out.println("【1】*******程序开始执行***");
        System.out.println("【2】*******数学计算：" + (10/0));
        System.out.println("【3】*******程序执行完毕***");
    }
}
```

```
【1】*******程序开始执行***
Exception in thread "main" java.lang.ArithmeticException: / by zero
	at JavaDemo.main(JavaDemo.java:4)
```

出现错误之后，整个的程序将不会按照既定的方式进行执行，二十中断了执行。那么为了保证程序出现了非致命错误之后程序依然可以正常完成，所以就需要有一个完善的异常处理机制，以保证程序的顺利执行。



## 处理异常

在java之中如果要进行异常的处理，可以使用：try、catch、finally这几个关键字来完成

![image-20200728132954342](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200728132954342.png)

在格式之中可以使用的组合：try...catch、try...catch...finally、try...finally

范例：处理异常

```java
public class JavaDemo {
    public static void main (String[] args) {
        System.out.println("【1】*******程序开始执行***");
        try {
        System.out.println("【2】*******数学计算：" + (10/0));
        } catch (ArithmeticException e) {
            System.out.println("【C】处理异常" + e); //处理异常
        }
        System.out.println("【3】*******程序执行完毕***");
    }
}
```

```
【1】*******程序开始执行***
【C】处理异常java.lang.ArithmeticException: / by zero
【3】*******程序执行完毕***
```

![image-20200728142455897](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200728142455897.png)

范例：获取完整异常信息

```java
public class JavaDemo {
    public static void main (String[] args) {
        System.out.println("【1】*******程序开始执行***");
        try {
        System.out.println("【2】*******数学计算：" + (10/0));
        } catch (ArithmeticException e) {
            System.out.println("【C】处理异常"); //处理异常
            e.printStackTrace();
        }
        System.out.println("【3】*******程序执行完毕***");
    }
}
```

![image-20200728143935324](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200728143935324.png)

注意在服务器上的日志不能用此方法，需要用log.error("xxx",e);

范例：使用finally语句

```java
public class JavaDemo {
    public static void main (String[] args) {
        System.out.println("【1】*******程序开始执行***");
        try {
            System.out.println("【2】*******数学计算：" + (10/0));
        } catch (ArithmeticException e) {
            System.out.println("【C】处理异常"); //处理异常
            e.printStackTrace();
        } finally {
            System.out.println("【F】不管是否出现异常，我都会执行");
        }
        System.out.println("【3】*******程序执行完毕***");
    }
}
```

![image-20200728144449295](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200728144449295.png)



## 处理多个异常

很多时候在程序执行的过程之中可能会产生若干个异常，那么这情况下也可以使用多个catch进行异常的捕获。现在假设通过初始化参数来进行两个科学计算数字的设置。

```java
public class JavaDemo {
    public static void main (String[] args) {
        System.out.println("【1】*******程序开始执行***");
        try {
            int x = Integer.parseInt(args[0]);
            int y = Integer.parseInt(args[1]);
            System.out.println("【2】*******数学计算：" + (x/y));
        } catch (ArithmeticException e) {
            System.out.println("【C】处理异常"); //处理异常
            e.printStackTrace();
        } finally {
            System.out.println("【F】不管有没有异常都执行");
        }
        System.out.println("【3】*******程序执行完毕***");
    }
}
```

![image-20200728145350133](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200728145350133.png)

![image-20200728145406133](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200728145406133.png)

```java
public class JavaDemo {
    public static void main (String[] args) {
        System.out.println("【1】*******程序开始执行***");
        try {
            int x = Integer.parseInt(args[0]);
            int y = Integer.parseInt(args[1]);
            System.out.println("【2】*******数学计算：" + (x/y));
        } catch (ArithmeticException e) {
            System.out.println("【C】处理异常"); //处理异常
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("【C】处理异常"); //处理异常
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("【C】处理异常"); //处理异常
            e.printStackTrace();
        } finally {
            System.out.println("【F】不管有没有异常都执行");
        }
        System.out.println("【3】*******程序执行完毕***");
    }
}
```

增加处理Exception

```java
catch (ArithmeticException|NumberFormatException|ArrayIndexOutOfBoundsException e) {
            System.out.println("【C】处理异常"); //处理异常
            e.printStackTrace();
        } 
```

此时我们开发者都已经明确的知道有那些异常了，又何必非用异常处理，直接写判断？



## 异常处理流程

在进行异常处理的时候如果将所有可能已经明确知道要产生的异常都进行了捕获，虽然你可以得到非常良好的代码结构，但是这种代码编写是非常麻烦的，所以现在要想进行合理异常就必须清楚再一场产生之后程序到底做了哪些处理。

![image-20200728213627367](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200728213627367.png)

![image-20200728213702941](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200728213702941.png)

![image-20200728213723900](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200728213723900.png)

> Error举例
>
> ![image-20200728214321090](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200728214321090.png)

范例：简化异常处理

如果catch异常大的写在前面：

```java
try{
    ...
}} catch (Exception e) {
            System.out.println("【C】处理异常"); //处理异常
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("【C】处理异常"); //处理异常
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("【C】处理异常"); //处理异常
            e.printStackTrace();
        } finally {
            System.out.println("【F】不管有没有异常都执行");
        }
```

> JavaDemo.java:11: 错误: 已捕获到异常错误NumberFormatException
>         } catch (NumberFormatException e) {
>           ^
> JavaDemo.java:14: 错误: 已捕获到异常错误ArrayIndexOutOfBoundsException
>         } catch (ArrayIndexOutOfBoundsException e) {
>           ^
> 2 个错误

多个异常时，范围大的靠后！！

```java
public class JavaDemo {
    public static void main (String[] args) {
        System.out.println("【1】*******程序开始执行***");
        try {
            int x = Integer.parseInt(args[0]);
            int y = Integer.parseInt(args[1]);
            System.out.println("【2】*******数学计算：" + (x/y));
        } catch (Exception e) {
            System.out.println("【C】处理异常"); //处理异常
            e.printStackTrace();
        } finally {
            System.out.println("【F】不管有没有异常都执行");
        }
        System.out.println("【3】*******程序执行完毕***");
    }
}
```

当你不确定可能产生哪些异常的时候，这种处理方式是最方便的。但是如果这样处理也会产生一个问题，这种异常的处理形式虽然方便，但是它表述的错误信息不明确，所以分开处理异常是一种可以更加明确的处理方式。

**在以后进行多个异常同时处理的时候要把捕获范围大的异常放在捕获范围小的异常之后**



## throws关键字

![image-20200728215222644](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200728215222644.png)

真有异常了，调用处来处理

```java
class MyMath {
    //这个代码执行的时候可能产生异常，如果产生异常调用处处理
    public static int div(int x, int y) throws Exception {
        return x/y;
    }
}

public class JavaDemo {
    public static void main (String[] args) {
        System.out.println(MyMath.div(10,2));
    }
}
```

> JavaDemo.java:10: 错误: 未报告的异常错误Exception; 必须对其进行捕获或声明以便抛出
>         System.out.println(MyMath.div(10,2));
>                                      ^
> 1 个错误

对于可能出现异常的方法的调用，必须要做异常处理

```java
class MyMath {
    //这个代码执行的时候可能产生异常，如果产生异常调用处处理
    public static int div(int x, int y) throws Exception {
        return x/y;
    }
}

public class JavaDemo {
    public static void main (String[] args) {
        try {
           System.out.println(MyMath.div(10,2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

主方法本身也是个方法，其实主方法也可以继续向上抛出。

范例：在主方法上继续抛出异常

```java
class MyMath {
    //这个代码执行的时候可能产生异常，如果产生异常调用处处理
    public static int div(int x, int y) throws Exception {
        return x/y;
    }
}

public class JavaDemo {
    public static void main (String[] args) throws Exception{
        System.out.println(MyMath.div(10,0));
    }
}
```

> Exception in thread "main" java.lang.ArithmeticException: / by zero
> 	at MyMath.div(JavaDemo.java:4)
> 	at JavaDemo.main(JavaDemo.java:10)

如果出错使用默认方式处理，主方法继续向上抛，就交给了JVM处理



## throw关键字

与throws对应的，此关键字的主要作用在于表示手工就行异常的抛出，即：此时将手工产生一个异常类的实例化对象，并且进行异常抛出处理。

范例：观察throw的使用

```java
public class JavaDemo {
    public static void main (String[] args) {
        throw new Exception("自己抛着玩的对象");//不用系统自动实例化的Exception，手动实例化
    }
}
```

> JavaDemo.java:3: 错误: 未报告的异常错误Exception; 必须对其进行捕获或声明以便抛出
>         throw new Exception("自己抛着玩的对象");//不用系统自动实例化的Exception，手动实例化
>         ^
> 1 个错误

需要try catch或者直接丢到上一层处理即

```java
public class JavaDemo {
    public static void main (String[] args) throws Exception{
        throw new Exception("自己抛着玩的对象");//不用系统自动实例化的Exception，手动实例化
    }
}
```

> Exception in thread "main" java.lang.Exception: 自己抛着玩的对象
> 	at JavaDemo.main(JavaDemo.java:3)

```java
public class JavaDemo {
    public static void main (String[] args) {
        try {
            throw new Exception("自己抛着玩的对象");//不用系统自动实例化的Exception，手动实例化
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

> java.lang.Exception: 自己抛着玩的对象
> 	at JavaDemo.main(JavaDemo.java:4)

**面试题：解释throw与throws的区别**

![image-20200728225714009](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200728225714009.png)



## 异常的标准处理格式

![image-20200728225810729](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200728225810729.png)

```java
class MyMath{
    //异常交给被调用处处理则一定要在方法上使用throws
    public static int div(int x,int y) throws Exception {
        int temp = 0;
        System.out.println("***【START】除法计算开始。");
        try{
            temp = x / y;
        } catch (Exception e) {
            throw e;//向上抛异常
        } finally {
            System.out.println("***【END】除法计算结束。");
        }
        return temp;
    }

}

public class JavaDemo {
    public static void main (String[] args) {
        try {
            System.out.println(MyMath.div(10,0));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

> ***【START】除法计算开始。
>
> ***【END】除法计算结束。java.lang.ArithmeticException: / by zero
>
> ​	at MyMath.div(JavaDemo.java:7)
>
> ​	at JavaDemo.main(JavaDemo.java:21)

对于此类操作实际上可以简化，省略catch和throw的操作

```java
class MyMath{
    //异常交给被调用处处理则一定要在方法上使用throws
    public static int div(int x,int y) throws Exception {
        int temp = 0;
        System.out.println("***【START】除法计算开始。");
        try{
            temp = x / y;
        } finally {
            System.out.println("***【END】除法计算结束。");
        }
        return temp;
    }
```

以后实际开发之中，这种异常的处理格式是最为重要的，尤其是当与一些资源进行访问操作的时候尤其重要



## RuntimeException

通过之前的分析发现，只要方法后面带有throws往往都是告诉用户本方法可能产生的异常是什么

```java
public class JavaDemo {
    public static void main (String[] args) {
        int num = Integer.parseInt("123");
        System.out.println(num);
    }
}
```

打开Integer类的parseInt()方法的定义来观察：

> public static int parseInt(String s) throws NumberFormatException

这个方法上明确抛了一个异常，但是在处理的时候并没有强制性要求处理，观察一下NumberFormatException类的继承结构，同时也观察数学异常类的继承结构

![image-20200728231518061](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200728231518061.png)

![image-20200728231605049](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200728231605049.png)

![image-20200728231842598](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200728231842598.png)



## 自定义异常类

![image-20200728232000808](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200728232000808.png)

范例:实现自定义异常

```java
class BombException extends Exception {
    public BombException(String msg) {
        super(msg);
    }
}
class Food {
    public static void eat(int num) throws BombException {
        if(num > 10) {
            throw new BombException("吃太多了，肚子爆了");
        } else {
            System.out.println("正常开始吃，不怕吃胖");
        }
    }
}
public class JavaDemo {
    public static void main (String[] args) {
        Food.eat(11);
    }
}
```

> JavaDemo.java:17: 错误: 未报告的异常错误BombException; 必须对其进行捕获或声明以便抛出
>         Food.eat(11);
>                 ^
> 1 个错误

以上代码会报错,需要throws抛到上层,或者自己处理.或者继承RuntimeException

```java
class BombException extends RuntimeException {
    public BombException(String msg) {
        super(msg);
    }
}
class Food {
    public static void eat(int num) throws BombException {
        if(num > 10) {
            throw new BombException("吃太多了，肚子爆了");
        } else {
            System.out.println("正常开始吃，不怕吃胖");
        }
    }
}
public class JavaDemo {
    public static void main (String[] args) {
        Food.eat(11);
    }
}
```

> Exception in thread "main" BombException: 吃太多了，肚子爆了
> 	at Food.eat(JavaDemo.java:9)
> 	at JavaDemo.main(JavaDemo.java:17)

使用了默认处理方式,抛给了JVM处理,与以下的执行结果一样

```java
class BombException extends Exception {
    public BombException(String msg) {
        super(msg);
    }
}
class Food {
    public static void eat(int num) throws BombException {
        if(num > 10) {
            throw new BombException("吃太多了，肚子爆了");
        } else {
            System.out.println("正常开始吃，不怕吃胖");
        }
    }
}
public class JavaDemo {
    public static void main (String[] args) throws BombException {
        Food.eat(11);
    }
}
```



## assert关键字

从JD看1.4开始追加有的断言的功能，确定代码执行到某行之后一定是所期待的结果，在实际开发之中，对于断言而言，并不一定是准确的，也有可能出现偏差，但是这种偏差不应该影响程序的正常执行。

范例：断言的使用

```java
public class JavaDemo {
    public static void main (String[] args) throws Exception {
        int x = 10;
        //中间会经过许多的x变量的操作步骤
        assert x == 100: "x的内容不是100";
        System.out.println(x);
    }
}
```

如果现在想要执行断言，则必须在程序执行的时候加入参数：

java -ea JaveDemo

![image-20200728233252984](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200728233252984.png)

所以在Java里面并没有将断言设置为一个程序必须执行的步骤，需要特定的环境下才可以开启。



# 第28章：内部类

虽然类之中的基本组成就是成员属性与方法，但是在任何语言里面结构也是允许进行嵌套的，所以在一个类的内部可以定义其他的类，这样的类就成为内部类

## 内部类的基本定义

如果说到内部类肯定其本身是一个独立且完善的类结构，在一个类的内部除了属性和方法之外可以继续使用class定义内部类

范例：内部类的基本定义

```java
class Outer {//外部类
    private String msg = "Message"; //私有成员属性
    public void fun() {//普通方法
        Inner in = new Inner(); //实例化内部类对象
        in.print(); // 调用内部类方法
    }

    class Inner { //在Outer类的内部定义了Inner类
        public void print() {
            System.out.println(Outer.this.msg); //Outer属性。不能直接用this，表示的是Inner
        }
    }
}

public class JavaDemo {
    public static void main(String[] args) {
        Outer out = new Outer(); //实例化外部类对象
        out.fun(); // 调用外部类方法
    }
}
```

![image-20200804151340937](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200804151340937.png)

范例：将以上程序分两个类

```java
class Outer {//外部类
    private String msg = "Message"; //私有成员属性
    public void fun() {//普通方法
        //思考五：需要将当前对象Outer传递到Inner类之中
        Inner in = new Inner(this); //实例化内部类对象
        in.print(); // 调用内部类方法
    }
    //思考一：msg属性要被外部访问需要getter方法
    public String getMsg() {
        return this.msg;
    }
}

class Inner { //在Outer类的内部定义了Inner类
    //思考三：Inner这个类的实例化时候需要Outer类的引用
    private Outer out;
    //思考四：应该通过Inner类构造方法获得OUter类的引用
    public Inner(Outer out) {
        this.out = out;
    }
    public void print() {
        //思考二：如果想要调用外部类中的getter方法，那么一定需要Otter对象。
        //如果用new Outer().getMsg();，与调用外部类处有了不同的实例化
        System.out.println(this.out.getMsg()); //Outer属性
    }
}

public class JavaDemo {
    public static void main(String[] args) {
        Outer out = new Outer(); //实例化外部类对象
        out.fun(); // 调用外部类方法
    }
}
```

可以发现整体的操做之中，主要目的就是为了让Inner的内部类可以访问Outer外部类的私有属性。但是如果不用内部类的时候整体代码非常的麻烦，所以可以得出内部类的有点：轻松的访问外部类中的私有属性。



## 内部类的相关说明

![image-20200804152751551](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200804152751551.png)

范例：外部类访问内部类的私有成员

```java
class Outer {//外部类
    private String msg = "Message"; //私有成员属性
    public void fun() {//普通方法
        Inner in = new Inner(); //实例化内部类对象
        in.print(); // 调用内部类方法
        System.out.println(in.info);//访问内部类的私有属性
    }

    class Inner { //在Outer类的内部定义了Inner类
        private String info = "今天天气不好，收衣服啦！";
        public void print() {
            System.out.println(Outer.this.msg); //Outer属性。不能直接用this，表示的是Inner
        }
    }
}

public class JavaDemo {
    public static void main(String[] args) {
        Outer out = new Outer(); //实例化外部类对象
        out.fun(); // 调用外部类方法
    }
}
```

> Message
> 今天天气不好，收衣服啦！

![image-20200804153226715](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200804153226715.png)

```java
class Outer {//外部类
    private String msg = "Message"; //私有成员属性
    class Inner { //在Outer类的内部定义了Inner类
        public void print() {
            System.out.println(Outer.this.msg); //Outer属性。不能直接用this，表示的是Inner
        }
    }
}

public class JavaDemo {
    public static void main(String[] args) {
        Outer.Inner in = new Outer().new Inner();
        in.print();
    }
}
```

如果Inner类只允许被Outer类使用，可以用private类私有定义

```java
class Outer {//外部类
    private String msg = "Message"; //私有成员属性
    private class Inner { //在Outer类的内部定义了Inner类
        public void print() {
            System.out.println(Outer.this.msg); //Outer属性。不能直接用this，表示的是Inner
        }
    }
}
```

此时Inner类无法外部使用

抽象类与接口中都可以定义内部结构

范例：定义内部接口

```java
interface IChannel {//定义接口
    public void send(IMessage msg); //发送消息
    interface IMessage {//内部接口，不是必须实现
        public String getContent(); //获取消息内容
    }
}

class ChannelImpl implements IChannel {
    public void send(IMessage msg) {
        System.out.println("发送消息： " + msg.getContent());
    }
    class MessageImpl implements IMessage {
        public String getContent() {
            return "this is a Message";
        }
    }
}

public class JavaDemo {
    public static void main(String[] args) {
        IChannel channel =  new ChannelImpl();
        channel.send(((ChannelImpl)channel).new MessageImpl());
    }
}
```

下面观察一个内部抽象类，可以定义在类、接口、抽象类之中都可以`

```java
interface IChannel {//定义接口
    public void send(); //发送消息
    abstract class MessageAbstract {
        public abstract String getContent();
    }
}

class ChannelImpl implements IChannel {
    public void send() {
        MessageAbstract msg = new MessageImpl();
        System.out.println("发送消息： " + msg.getContent());
    }
    class MessageImpl extends MessageAbstract {
        public String getContent() {
            return "this is a Message";
        }
    }
}

public class JavaDemo {
    public static void main(String[] args) {
        IChannel channel =  new ChannelImpl();
        channel.send();
    }
}
```

如果定义了一个接口，可以在内部利用类实现该接口，在JDK1.8之后接口追加了static方法可以不受到实例化对象控制，现在可以利用此特性来完成功能

范例：接口内部进行接口实现

```java
interface IChannel {//定义接口
    public void send(); //发送消息
    class ChannelImpl implements IChannel {
        public void send() {
            System.out.println("发送消息： this is a Message");
        }
    }
    public static IChannel getInstance() {
        return new ChannelImpl();
    }
}

public class JavaDemo {
    public static void main(String[] args) {
        IChannel channel =  IChannel.getInstance();
        channel.send();
    }
}
```

内部类是一种非常灵活的定义结构，只要满足语法就可实现需求。很多抽象类和接口是通过内部类定义的



## static定义内部类

![image-20200804160143404](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200804160143404.png)

```java
class Outer {//外部类
    private static final String MSG = "Message"; //static内部类只能访问static属性方法
    static class Inner { 
        public void print() {
            System.out.println(Outer.MSG); //Outer属性。不能直接用this，表示的是Inner
        }
    }
}
```

![image-20200804160535562](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200804160535562.png)

**如果import static内部类时，可以直接引入外部类.内部类，然后直接用new 内部类()  来实例化**

```java
public class JavaDemo {
    public static void main(String[] args) {
        Outer.Inner in = new Outer.Inner(); //实例化内部类对象
        in.print();
    }
}
```

以后开发中如果发现类名称上有“.”，首先应该想到这是一个内部类结构。如果可以直接进行实例化，则应该立即认识到这是一个static定义的内部类。

如果以static定义内部类的形式来讲并不常用，static定义内部接口的形式最为常用

范例：使用static定义内部接口

```java
interface IMessageWrap { //消息包装
    static interface IMessage {
        public String getContent() ;
    }
    static interface IChannel {
        public boolean connect(); //消息的发送通道
    }
    public static void send(IMessage msg,IChannel channel) {
        if(channel.connect()) {
            System.out.println(msg.getContent());
        } else {
            System.out.println("消息通道无法建立，发送失败！");
        }
    }   
}
class DefaultMessage implements IMessageWrap.IMessage {
    public String getContent() {
        return "this is a Message";
    }    
}
class NetChannel implements IMessageWrap.IChannel {
    public boolean connect() {
        return true;
    }
}

public class JavaDemo {
    public static void main(String[] args) {
        IMessageWrap.send(new DefaultMessage(),new NetChannel()) ;
    }
}
```

之所以使用static定义的内部接口，主要是因为这些操作是属于一组相关的定义，有了外部接口之后可以更加明确的描述出这些接口的主要功能。



## 方法中定义内部类

内部类可以在任意的结构中进行定义，包括：类中、方法中、代码块中，但是从实际开发来讲，在方法中定义内部类的形式较多

范例：观察方法中定义内部类

```java
class Outer {//外部类
    private String msg = "Message"; //static内部类只能访问static属性方法
    public void fun(long time) {
        class Inner { 
            public void print() {
                System.out.println(Outer.this.msg); //Outer属性
                System.out.println(time); 
            }
        }
        new Inner().print(); //方法中直接实例化内部对象并执行方法
    }
}

public class JavaDemo {
    public static void main(String[] args) {
        new Outer().fun(12345L); 
    }
}
```

![image-20200804165137067](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200804165137067.png)

**JDK1.8以前的**

```java
class Outer {//外部类
    private String msg = "Message"; //static内部类只能访问static属性方法
    public void fun(final long time) {
        final String info = "我很好";
        class Inner { 
            public void print() {
                System.out.println(Outer.this.msg); //Outer属性
                System.out.println(time);
                System.out.println(info); 
            }
        }
        new Inner().print(); //方法中直接实例化内部对象并执行方法
    }
}
```

在1.8以前如果外部方法中的变量（局部变量）不加final，则内部类中无法访问，1.8引入Lambda表达式，所以自动做了转换

之所以取消这样的校址，是为了其扩展的函数式编程准备的功能



## 匿名内部类

匿名内部类是一种简化的内部类处理形式，主要是在抽象类和接口的子类上使用

范例：观察基本的程序结构

```java
interface IMessage {
    public void send(String str);
}
class MessageImpl implements IMessage {
    public void send(String str) {
        System.out.println(str);
    }
}
public class JavaDemo {
    public static void main(String[] args) {
        IMessage msg = new MessageImpl();
        msg.send("this is a Message");
    }
}
```

如果说IMessage接口中的MessageImpl子类只使用唯一的一次，那么是否还有必要将其定义为单独的类，那么在这样的要求下就发现这个时候定义的子类有些多余了，所以就可以使用匿名内部类的形式来解决此问题

范例：使用匿名内部类

```java
interface IMessage {
    public void send(String str);
}
public class JavaDemo {
    public static void main(String[] args) {
        IMessage msg = new IMessage() {
            public void send(String str) {//匿名内部类
                System.out.println(str);
            }
        };
        msg.send("this is a Message");
    }
}
```

**这样执行后，不会产生新的.java文件，但是会产生.class文件，按数字排号**

![image-20200804170241896](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200804170241896.png)

一般定义在抽象类和接口上，return new需要实现全部抽象方法

有些时候为了更加方便的体现出匿名内部类的使用，往往可以利用静态方法做一个内部的匿名内部类实现

```java
interface IMessage {
    public void send(String str);
    public static IMessage getInstance() {
        return new IMessage() {
            public void send(String str) {//匿名内部类
                System.out.println(str);
            }
        };
    }
}
public class JavaDemo {
    public static void main(String[] args) {
        IMessage msg = IMessage.getInstance();
        msg.send("this is a Message");
    }
}
```

与内部类相比匿名内部类只是一个没有名字的只能够使用一次的，并且结构固定的一个子类。

## 总结

内部类的优势就是方便进行私有属性访问，但是劣势破坏类结构，使程序阅读困难，所以在正常的开发过程之中，内部类不会作为首要的设计选择。



# 第29章：函数式编程

从JDK1.8开始为了简化使用者进行代码的开发，专门提供有lambda表达式的支持，利用此操作形式可以实现函数式的编程，对于函数式编程比较著名的语言：haskell Scala，利用函数时便哼可以避免掉面向对象编程之中一些繁琐的处理问题。

了解函数式编程参考网站：www.haskell.org/documentation

![image-20200804171337862](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200804171337862.png)

面向对象在其长期发展过程之中一直有一部门反对者，这些反对者认为面向对象的设计过于复杂了，并且过于繁琐了

范例：观察传统开发中的问题

```java
interface IMessage {
    public void send(String str);
}
public class JavaDemo {
    public static void main(String[] args) {
        IMessage msg = new IMessage() {
            public void send(String str) {
                System.out.println("消息发送：" + str);
            }
        };
        msg.send("this is a Message");
    }
}
```

![image-20200804171554625](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200804171554625.png)

```java
interface IMessage {
    public void send(String str);
}
public class JavaDemo {
    public static void main(String[] args) {
        IMessage msg = (str) -> {
            System.out.println("消息发送：" + str);
        };
        msg.send("this is a Message");
    }
}
```

![image-20200804171817302](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200804171817302.png)

如果追加了新方法

```java
interface IMessage {
    public void send(String str);
	public void get();
}
```

> JavaDemo.java:7: 错误: 不兼容的类型: IMessage 不是函数接口
>         IMessage msg = (str) -> {
>                        ^
>     在 接口 IMessage 中找到多个非覆盖抽象方法
> 1 个错误

范例：使用函数式接口注解

```java
@FunctionalInterface //函数式接口
interface IMessage {
    public void send(String str);
}
public class JavaDemo {
    public static void main(String[] args) {
        IMessage msg = (str) -> {
            System.out.println("消息发送：" + str);
        };
        msg.send("this is a Message");
    }
}
```

如果多个方法

> JavaDemo.java:1: 错误: 意外的 @FunctionalInterface 注释
> @FunctionalInterface //函数式接口
> ^
>   IMessage 不是函数接口
>
> ​    在 接口 IMessage 中找到多个非覆盖抽象方法

**default static方法不受限制**

```java
@FunctionalInterface //函数式接口
interface IMessage {
    public void send(String str);
    public default void get() {}
    public static void pet() {}
}
public class JavaDemo {
    public static void main(String[] args) {
        IMessage msg = (str) -> {
            System.out.println("消息发送：" + str);
        };
        msg.send("this is a Message");
    }
}
```



![image-20200804172504381](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200804172504381.png)

范例：定义没有参数的方法

```java
@FunctionalInterface //函数式接口
interface IMessage {
    public void send();
}
public class JavaDemo {
    public static void main(String[] args) {
        IMessage msg = () -> {
            System.out.println("消息发送：this is a Message");
        };
        msg.send();
    }
}
```

范例：定义有参数的处理形式

```java
@FunctionalInterface //函数式接口
interface IMath {
    public int add(int x, int y);
}
public class JavaDemo {
    public static void main(String[] args) {
        IMath math = (t1,t2) -> {
            return t1 + t2;
        };
        System.out.println(math.add(10,20));
    }
}
```

如果表达式只有一行语句，可以进一步进行简化。

```java
@FunctionalInterface //函数式接口
interface IMath {
    public int add(int x, int y);
}
public class JavaDemo {
    public static void main(String[] args) {
        IMath math = (t1,t2) ->  t1 + t2;
        System.out.println(math.add(10,20));
    }
}
```

利用lambda表达式的确摆脱传统面向对象之中关于结构的限制，使得代码更加简便。

**可以配合steam流处理一起用**



## 方法引用

引用数据类型最大的特点使可以进行内存的指向处理，但是在传统的开发之中一直所使用的只是对象引用操作，而从JDK1.8以后也提供有方法的引用，即不同的方法名称可以描述同一个方法。如果要进行方法的引用在Java里面提供有如下的四种形式

![image-20200804174259609](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200804174259609.png)

```java
@FunctionalInterface //函数式接口
//P描述的是参数，R描述的是返回值
interface IFunction<P,R> {
    public R 转换(P p);
}
public class JavaDemo {
    public static void main(String[] args) {
        IFunction<Integer,String> fun = String :: valueOf;
        String str =  fun.转换(100);
        System.out.println(str.length());
    }
}
```

![image-20200804221950765](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200804221950765.png)

```java
@FunctionalInterface //函数式接口
//P描述的是参数，R描述的是返回值
interface IFunction<R> {
    public R upper();
}
public class JavaDemo {
    public static void main(String[] args) {
        IFunction<String> fun = "www.123.com" :: toUpperCase;
        System.out.println(fun.upper());
    }
}
```

在进行方法应用的时候，也可以引用特定类中的一些操作方法，再String类里面提供有一个字符串大小关系的比较：

* 比较大小：public int compareTo(String anotherString):

这是一个普通方法，如果要引用普通方法，则往往都需要实例化对象，但是如果现在不想实例化对象，只是想引用这个方法，则就可以使用特定类来进行引用处理。

范例：引用指定类中的方法

```java
@FunctionalInterface //函数式接口
//P描述的是参数
interface IFunction<P> {
    public int compare(P p1,P p2);
}
public class JavaDemo {
    public static void main(String[] args) {
        IFunction<String> fun = String :: compareTo;
        System.out.println(fun.compare("A","a"));
    }
}
```

> -32

在方法引用里最具杀伤力的就是构造方法的引用

范例：观察构造方法的引用

```java
class Person {
    private String name;
    private int age;
    public Person(String name,int age) {
        this.name = name;
        this.age = age;
    }
    public String toString() {
        return "姓名：" + this.name + "、年龄：" + this.age;
    }
}
@FunctionalInterface //函数式接口
//R描述是返回对象
interface IFunction<R> {
    public R creat(String s,int a);
}
public class JavaDemo {
    public static void main(String[] args) {
        IFunction<Person> fun = Person :: new;
        System.out.println(fun.creat("张三",20));
    }
}
```

> 姓名：张三、年龄：20

提供方法引用的概念更多情况下也只是弥补了对于引用的支持功能。

**new ArrayList<>.stream().map(String::toUpperCase).filter(Objects::noNull).collect(Collectors.toList())**



## 内建函数式接口

在JDK1.8之中提供有Lambda表达式也提供有方法引用，但是会发现现在如果由开发者自己定义函数式接口，往往都需要使用@FunctionalInterFace 注解进行大量声明，于是很多情况下如果为了方便则可以直接引用系统中提供的函数式接口。

在系统之中专门提供有一个java.util.function的开发包，里面可以直接使用函数式接口，在这包下有很多接口，主要使用如下几种

![image-20200804225446878](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200804225446878.png)

### 1.功能性函数式接口

* ![image-20200804225653272](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200804225653272.png)
* ![image-20200804225718232](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200804225718232.png)
* 在String类中有一个方法判断是否以指定的字符串开头：public boolean startsWith(String str):

![image-20200804225853634](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200804225853634.png)

```java
import java.util.function.*;
public class JavaDemo {
    public static void main(String[] args) {
        Function<String,Boolean> fun = "**Hello" :: startsWith;
        System.out.println(fun.apply("**"));
    }
}
```

> true

Function是基础接口，还有各种不同的扩充，都是使用apply**类似的方法

### 2.消费型函数式接口：

只能够进行数据的处理操作，而没有任何的返回；

* 在进行系统数据输出的时候使用：System.out.println():
* ![image-20200804230608363](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200804230608363.png)
* ![image-20200804230645107](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200804230645107.png)

![image-20200804230545450](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200804230545450.png)

```java
import java.util.function.*;
public class JavaDemo {
    public static void main(String[] args) {
        Consumer<String> con = System.out :: println;
        con.accept("23333");
    }
}
```

> 23333

### 3.供给型函数式接口：

* 在String类中提供由转小写方法，这个方法没有接收参数，但是又返回值，方法：public String toLowerCase():
* ![image-20200804231219010](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200804231219010.png)
* ![image-20200804231234108](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200804231234108.png)
* 

![image-20200804231207789](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200804231207789.png)

```java
import java.util.function.*;
public class JavaDemo {
    public static void main(String[] args) {
        Supplier<String> sup = "HelloWorld" :: toLowerCase;
        System.out.println(sup.get());
    }
}
```

> helloworld

### 4.断言型函数式接口：

* 进行数据判断处理
* ![image-20200804231602935](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200804231602935.png)
* ![image-20200804231617497](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200804231617497.png)

* 在String类中有一个equalsIgnoreCase()方法

```java
import java.util.function.*;
public class JavaDemo {
    public static void main(String[] args) {
        Predicate<String> pre = "HelloWorld" :: equalsIgnoreCase;
        System.out.println(pre.test("helloworld"));
    }
}
```

> true

以后对于实际项目开发之中，如果JDK本身提供的函数式接口可以被我们所使用，那么就没有必要进行重新定义了



# 第30章：链表的定义与使用

链表本质是一个动态的对象数组，它可以实现若干个对象的存储

## 链表的基本定义

![image-20200805092607727](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200805092607727.png)

![image-20200805092749097](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200805092749097.png)



![image-20200805092938692](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200805092938692.png)

举例，火车车厢前后用挂钩连接，可重组。数据只提供内容，不能实现连接操作

![image-20200805093606678](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200805093606678.png)



![image-20200805093335583](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200805093335583.png)

![image-20200805093830015](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200805093830015.png)

要用泛型，不能用Object，原因前文已讲

![image-20200805093921958](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200805093921958.png)

范例：直接操作Node 很麻烦

```java
class Node<E> {
    private E data;
    private Node next;
    public Node(E data) {
        this.data = data;
    }
    public E getData() {
        return this.data;
    }
    public Node getNext() {
        return this.next;
    }
    public void setNext(Node next) {
        this.next = next;
    }
}

public class JavaDemo {
    public static void main(String[] args) {
        Node<String> n1 = new Node<String>("火车头");
        Node<String> n2 = new Node<String>("车厢1");
        Node<String> n3 = new Node<String>("车厢2");
        Node<String> n4 = new Node<String>("车厢3");
        Node<String> n5 = new Node<String>("车厢4");
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);
        print(n1);
    }
    public static void print(Node<?> node) {
        if(node != null) {//有节点
            System.out.println(node.getData());
            print(node.getNext());//递归调用
        }
    }
}
```

> 火车头
> 车厢1
> 车厢2
> 车厢3
> 车厢4

![image-20200805095619051](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200805095619051.png)

![image-20200805095828447](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200805095828447.png)

## 数据保存：public void add(E e)

通过之前的分析可以发现在进行链表操作的过程之中为了避免转型的异常，应该使用泛型，同时也应该设计一个链表的标准接口，同时具体实现该接口的时候还应该通过Node类做出节点的关系描述

范例：基本结构

```java
interface ILink<E> { //设置泛型避免安全隐患
    public void add(E e);
}

class LinkImpl<E> implements ILink<E> {
    private class Node {//保存节点的数据关系
        private E data; //保存的一个数据
        private Node next; // 保存下一个引用
        public Node(E data) {//有数据时才有意义
            this.data = data;
    }
    //-----------以下未Link类中定义的结构
}
```

在现在所定义的Node类之中并没有setter和getter方法，是因为内部类中私有属性也方便外部类直接访问。

范例：实现数据增加

必须要有入口root。没有数据时为null

![image-20200805112957909](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200805112957909.png)



![image-20200805101158888](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200805101158888.png)

```java
interface ILink<E> { //设置泛型避免安全隐患
    public void add(E e);
}

class LinkImpl<E> implements ILink<E> {
    private class Node {//保存节点的数据关系
        private E data; //保存的一个数据
        private Node next; // 保存下一个引用
        public Node(E data) {//有数据时才有意义
            this.data = data;
    }

        public void addNode(Node newNode) {//保存新的Node数据
            if(this.next == null) {//当前节点的下一个为null
                this.next = newNode;//保存为当前节点
            } else {
                this.next.addNode(newNode);     //迭代调用  
            }
        }
    }
    //-----------以下未Link类中定义的成员------------
    private Node root; //保存根元素
    //-----------以下未Link类中定义的方法------------
    public void add(E e){
        if(e == null) {//保存的数据为空
            return ; //方法调用结束
        }
        //数据本身不具有关联特性，只有Node类有，必须要关联到Node里
        Node newNode = new Node(e); //创建一个新的节点
        if(this.root == null) {//现在没有根节点
            this.root = newNode; //第一个节点作为根节点
        } else {//根节点存在
            this.root.addNode(newNode);//将新节点保存到合适的位置
        }
    }
}


public class JavaDemo {
    public static void main(String[] args) {
        ILink<String> all = new LinkImpl<String>();
        all.add("Hello");
        all.add("World");
        all.add("smile");
    }
}
```

Link类只是负责数据的操作与根节点的处理，而所有后续节点的处理全部都是由Node类负责完成的



## 获取数据长度：public int size()

![image-20200805103841182](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200805103841182.png)

* 1.在LInk接口里面追加一个有获取数据个数的方法：

```java
interface ILink<E> { //设置泛型避免安全隐患
    public void add(E e);
    public int size(); //获取数据的个数
}
```

* 2.在LinkImpl子类里面追加有一个个数统计的属性

```java
private int count; //保存数据个数
```

* 3.在add()方法里面进行数据个数的追加;

```java
this.count ++ ; //计数+1
```

* 4.在LinkImpl子类里面来返回数据的个数

```java
    public int size() {//返回计数值
        return this.count;
    }
```

完整

```java
interface ILink<E> { //设置泛型避免安全隐患
    public void add(E e);
    public int size(); //获取数据的个数
}

class LinkImpl<E> implements ILink<E> {
    private class Node {//保存节点的数据关系
        private E data; //保存的一个数据
        private Node next; // 保存下一个引用
        public Node(E data) {//有数据时才有意义
            this.data = data;
        }

        public void addNode(Node newNode) {//保存新的Node数据
            if(this.next == null) {//当前节点的下一个为null
                this.next = newNode;//保存为当前节点
            } else {
                this.next.addNode(newNode);     //迭代调用  
            }
        }
    }
    //-----------以下未Link类中定义的成员------------
    private Node root; //保存根元素
    private int count; //保存数据个数
    //-----------以下未Link类中定义的方法------------
    public void add(E e){
        if(e == null) {//保存的数据为空
            return ; //方法调用结束
        }
        //数据本身不具有关联特性，只有Node类有，必须要关联到Node里
        Node newNode = new Node(e); //创建一个新的节点
        if(this.root == null) {//现在没有根节点
            this.root = newNode; //第一个节点作为根节点
        } else {//根节点存在
            this.root.addNode(newNode);//将新节点保存到合适的位置
        }
        this.count ++ ; //计数+1
    }
    public int size() {//返回计数值
        return this.count;
    }
}

public class JavaDemo {
    public static void main(String[] args) {
        ILink<String> all = new LinkImpl<String>();
        System.out.println("【增加之前】数据个数： " + all.size());
        all.add("Hello");
        all.add("World");
        all.add("smile");
        System.out.println("【增加之后】数据个数： " + all.size());
    }
}
```

> 【增加之前】数据个数： 0
> 【增加之后】数据个数： 3

只是对于数据保存中的一个辅助功能



## 空集合判断：public boolean isEmpty()

链表里面可以保存若干数据，如果现在链表还没有保存数据，则表示是一个空集合，则应该提供一个空的判断

* 1.在ILink接口里追加判断方法
* ```public boolean isEmpty(); //判断是否空集合```
* 2.在LinkImpl子类里覆写此方法
  * root==null
  * count==0

* ```java
  public boolean isEmpty() {
  	//return this.root == null;
  	return this.count == 0;
  }
  ```

  


## 返回集合数据： publi Object[] toArray()

![image-20200805111626241](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200805111626241.png)

![image-20200805113259196](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200805113259196.png)

![image-20200805210738142](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200805210738142.png)

```java
interface ILink<E> { //设置泛型避免安全隐患
    public void add(E e);
    public int size(); //获取数据的个数
    public boolean isEmpty(); //判断是否为空集合
    public Object [] toArray(); //将集合元素以数组形式返回
}

class LinkImpl<E> implements ILink<E> {
    private class Node {//保存节点的数据关系
        private E data; //保存的一个数据
        private Node next; // 保存下一个引用
        public Node(E data) {//有数据时才有意义
            this.data = data;
        }

        public void addNode(Node newNode) {//保存新的Node数据
            if(this.next == null) {//当前节点的下一个为null
                this.next = newNode;//保存为当前节点
            } else {
                this.next.addNode(newNode);     //迭代调用  
            }
        }
        //第一次调用：this = LinkImpl.root
        //第二次调用：this = LinkImpl.root.next
        //第三次调用：this = LinkImpl.root.next.next
        public void toArrayNode() {
            LinkImpl.this.returnData [LinkImpl.this.foot ++] = this.data;
            if(this.next != null) {//还有下一个数据
                this.next.toArrayNode();
            }
        }
    }
    //-----------以下未Link类中定义的成员------------
    private Node root; //保存根元素
    private int count; //保存数据个数
    private int foot; //操作数组的角标
    private Object [] returnData; //返回的数据保存
    //-----------以下未Link类中定义的方法------------
    public void add(E e){
        if(e == null) {//保存的数据为空
            return ; //方法调用结束
        }
        //数据本身不具有关联特性，只有Node类有，必须要关联到Node里
        Node newNode = new Node(e); //创建一个新的节点
        if(this.root == null) {//现在没有根节点
            this.root = newNode; //第一个节点作为根节点
        } else {//根节点存在
            this.root.addNode(newNode);//将新节点保存到合适的位置
        }
        this.count ++ ; //计数+1
    }
    public int size() {//返回计数值
        return this.count;
    }
    public boolean isEmpty() {
        //return this.root == null;
        return this.count == 0;
    }
    public Object [] toArray() {
        if(this.isEmpty()) { //空集合
            return null;//现在没有数据
        }
        this.foot = 0; //脚标清零
        this.returnData = new Object [this.count]; //根据已有的长度开辟数组
        this.root.toArrayNode(); //利用Node类进行递归数据获取
        return this.returnData;
    }
}

public class JavaDemo {
    public static void main(String[] args) {
        ILink<String> all = new LinkImpl<String>();
        System.out.println("【增加之前】数据个数： " + all.size());
        all.add("Hello");
        all.add("World");
        all.add("smile");
        System.out.println("【增加之后】数据个数： " + all.size());
        Object result [] = all.toArray();
        for (Object obj : result ) {
            System.out.println(obj);
        }
    }
}
```

> 【增加之前】数据个数： 0
> 【增加之后】数据个数： 3
> Hello
> World
> smile



## 获取指定索引数据：public E get(int index)

链表的可以像数一样进行处理，所以也应该可以象数组一样进行索引数据的获取，在这样的情况下就可以继续利用递归形式来完成。

![image-20200805215014111](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200805215014111.png)



![image-20200805215438010](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200805215438010.png)

这一特点和数组是很相似的，但是需要注意的是，数组获取一个数据的时间复杂度为1，而链表获取数据的时间复杂度为n。

```java
interface ILink<E> { //设置泛型避免安全隐患
    public void add(E e);
    public int size(); //获取数据的个数
    public boolean isEmpty(); //判断是否为空集合
    public Object [] toArray(); //将集合元素以数组形式返回
    public E get(int index); //根据索引获取数据
}

class LinkImpl<E> implements ILink<E> {
    private class Node {//保存节点的数据关系
        private E data; //保存的一个数据
        private Node next; // 保存下一个引用
        public Node(E data) {//有数据时才有意义
            this.data = data;
        }

        public void addNode(Node newNode) {//保存新的Node数据
            if(this.next == null) {//当前节点的下一个为null
                this.next = newNode;//保存为当前节点
            } else {
                this.next.addNode(newNode);     //迭代调用  
            }
        }
        //第一次调用：this = LinkImpl.root
        //第二次调用：this = LinkImpl.root.next
        //第三次调用：this = LinkImpl.root.next.next
        public void toArrayNode() {
            LinkImpl.this.returnData [LinkImpl.this.foot ++] = this.data;
            if(this.next != null) {//还有下一个数据
                this.next.toArrayNode();
            }
        }
        public E getNode(int index) {
            if(LinkImpl.this.foot ++ == index) {//索引相同
                return this.data;  //返回当前数据
            } else {
                return this.next.getNode(index);   //寻找下个索引
            }
        }
    }
    //-----------以下未Link类中定义的成员------------
    private Node root; //保存根元素
    private int count; //保存数据个数
    private int foot; //操作数组的角标
    private Object [] returnData; //返回的数据保存
    //-----------以下未Link类中定义的方法------------
    public void add(E e){
        if(e == null) {//保存的数据为空
            return ; //方法调用结束
        }
        //数据本身不具有关联特性，只有Node类有，必须要关联到Node里
        Node newNode = new Node(e); //创建一个新的节点
        if(this.root == null) {//现在没有根节点
            this.root = newNode; //第一个节点作为根节点
        } else {//根节点存在
            this.root.addNode(newNode);//将新节点保存到合适的位置
        }
        this.count ++ ; //计数+1
    }
    public int size() {//返回计数值
        return this.count;
    }
    public boolean isEmpty() {
        //return this.root == null;
        return this.count == 0;
    }
    public Object [] toArray() {
        if(this.isEmpty()) { //空集合
            return null;//现在没有数据
        }
        this.foot = 0; //脚标清零
        this.returnData = new Object [this.count]; //根据已有的长度开辟数组
        this.root.toArrayNode(); //利用Node类进行递归数据获取
        return this.returnData;
    }
    public E get(int index) {
        if(index >= this.count) { //索引应该在指定范围之内
            return null;
        } //索引数据的获取应该由Node类完成
        this.foot = 0; //重置索引下标
        return this.root.getNode(index);
    }
}

public class JavaDemo {
    public static void main(String[] args) {
        ILink<String> all = new LinkImpl<String>();
        System.out.println("【增加之前】数据个数： " + all.size());
        all.add("Hello");
        all.add("World");
        all.add("smile");
        System.out.println("【增加之后】数据个数： " + all.size());
        Object result [] = all.toArray();
        for (Object obj : result ) {
            System.out.println(obj);
        }
        System.out.println("-------数据获取的分割线-------");
        System.out.println(all.get(0));
        System.out.println(all.get(1));
        System.out.println(all.get(4)); 
    }
}
```

> 【增加之前】数据个数： 0
> 【增加之后】数据个数： 3
> Hello
> World
> smile
> -------数据获取的分割线-------
> Hello
> World
> null



## 修改指定索引数据：public void set(int index,E data)

现在已经可以根据索引来获取指定的数据了，但是既然可以获取数据，那么也可以进行数据的修改。

* 1.在ILink接口上追加有新的方法

* ```java
  public void set(int index,E data);//修改索引数据
  ```

* 2.在Node类之中应该提供有数据修改的处理支持

* ```java
  public void setNode(int index,E data) {
  	if(LinkImpl.this.foot ++ == index) {//索引相同
  		this.data = data; //修改数据
  	} else {
  		this.next.setNode(index,data);
  	}
  }
  ```

* 3.在LinkImpl子类里面进行方法覆写

* ```java
  public void set(int index,E data) {
      if(index >= this.count) { //索引应该在指定的范围之内
          return;  //方法结束
      } //索引数据的获取应该由Node类完成
      this.foot = 0; //重置索引的下标
      this.root.setNode(index,data);  //修改数据
  }
  ```

  

```java
interface ILink<E> { //设置泛型避免安全隐患
    public void add(E e);
    public int size(); //获取数据的个数
    public boolean isEmpty(); //判断是否为空集合
    public Object [] toArray(); //将集合元素以数组形式返回
    public E get(int index); //根据索引获取数据
    public void set(int index,E data);//修改索引数据
}

class LinkImpl<E> implements ILink<E> {
    private class Node {//保存节点的数据关系
        private E data; //保存的一个数据
        private Node next; // 保存下一个引用
        public Node(E data) {//有数据时才有意义
            this.data = data;
        }

        public void addNode(Node newNode) {//保存新的Node数据
            if(this.next == null) {//当前节点的下一个为null
                this.next = newNode;//保存为当前节点
            } else {
                this.next.addNode(newNode);     //迭代调用  
            }
        }
        //第一次调用：this = LinkImpl.root
        //第二次调用：this = LinkImpl.root.next
        //第三次调用：this = LinkImpl.root.next.next
        public void toArrayNode() {
            LinkImpl.this.returnData [LinkImpl.this.foot ++] = this.data;
            if(this.next != null) {//还有下一个数据
                this.next.toArrayNode();
            }
        }
        public E getNode(int index) {
            if(LinkImpl.this.foot ++ == index) {//索引相同
                return this.data;  //返回当前数据
            } else {
                return this.next.getNode(index);   //寻找下个索引
            }
        }
        public void setNode(int index,E data) {
            if(LinkImpl.this.foot ++ == index) {//索引相同
                this.data = data; //修改数据
            } else {
                this.next.setNode(index,data);
            }
        }
    }
    //-----------以下未Link类中定义的成员------------
    private Node root; //保存根元素
    private int count; //保存数据个数
    private int foot; //操作数组的角标
    private Object [] returnData; //返回的数据保存
    //-----------以下未Link类中定义的方法------------
    public void add(E e){
        if(e == null) {//保存的数据为空
            return ; //方法调用结束
        }
        //数据本身不具有关联特性，只有Node类有，必须要关联到Node里
        Node newNode = new Node(e); //创建一个新的节点
        if(this.root == null) {//现在没有根节点
            this.root = newNode; //第一个节点作为根节点
        } else {//根节点存在
            this.root.addNode(newNode);//将新节点保存到合适的位置
        }
        this.count ++ ; //计数+1
    }
    public int size() {//返回计数值
        return this.count;
    }
    public boolean isEmpty() {
        //return this.root == null;
        return this.count == 0;
    }
    public Object [] toArray() {
        if(this.isEmpty()) { //空集合
            return null;//现在没有数据
        }
        this.foot = 0; //脚标清零
        this.returnData = new Object [this.count]; //根据已有的长度开辟数组
        this.root.toArrayNode(); //利用Node类进行递归数据获取
        return this.returnData;
    }
    public E get(int index) {
        if(index >= this.count) { //索引应该在指定范围之内
            return null;
        } //索引数据的获取应该由Node类完成
        this.foot = 0; //重置索引下标
        return this.root.getNode(index);
    }
    public void set(int index,E data) {
        if(index >= this.count) { //索引应该在指定的范围之内
            return;  //方法结束
        } //索引数据的获取应该由Node类完成
        this.foot = 0; //重置索引的下标
        this.root.setNode(index,data);  //修改数据
    }
}

public class JavaDemo {
    public static void main(String[] args) {
        ILink<String> all = new LinkImpl<String>();
        System.out.println("【增加之前】数据个数： " + all.size());
        all.add("Hello");
        all.add("World");
        all.add("smile");
        System.out.println("【增加之后】数据个数： " + all.size());
        Object result [] = all.toArray();
        for (Object obj : result ) {
            System.out.println(obj);
        }
        all.set(1,"世界");
        System.out.println("-------数据获取的分割线-------");
        System.out.println(all.get(0));
        System.out.println(all.get(1));
        System.out.println(all.get(4)); 
    }
}
```

> 【增加之前】数据个数： 0
> 【增加之后】数据个数： 3
> Hello
> World
> smile
> -------数据获取的分割线-------
> Hello
> 世界
> null

这种操作的时间复杂度也是n，因为依然需要进行数据的遍历处理



## 判断指定数据是否存在：public boolean contains(E data)

在一个集合里面往往会保存有大量的数据，有些时候需要判断某个数据是否存在，这个时候就可以通过对象比较模式（equals()方法）来完成判断

![image-20200805231015888](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200805231015888.png)

```java
interface ILink<E> { //设置泛型避免安全隐患
    public void add(E e);
    public int size(); //获取数据的个数
    public boolean isEmpty(); //判断是否为空集合
    public Object [] toArray(); //将集合元素以数组形式返回
    public E get(int index); //根据索引获取数据
    public void set(int index,E data);//修改索引数据
    public boolean contains(E data);  //判断数据是否存在
}

class LinkImpl<E> implements ILink<E> {
    private class Node {//保存节点的数据关系
        private E data; //保存的一个数据
        private Node next; // 保存下一个引用
        public Node(E data) {//有数据时才有意义
            this.data = data;
        }

        public void addNode(Node newNode) {//保存新的Node数据
            if(this.next == null) {//当前节点的下一个为null
                this.next = newNode;//保存为当前节点
            } else {
                this.next.addNode(newNode);     //迭代调用  
            }
        }
        //第一次调用：this = LinkImpl.root
        //第二次调用：this = LinkImpl.root.next
        //第三次调用：this = LinkImpl.root.next.next
        public void toArrayNode() {
            LinkImpl.this.returnData [LinkImpl.this.foot ++] = this.data;
            if(this.next != null) {//还有下一个数据
                this.next.toArrayNode();
            }
        }
        public E getNode(int index) {
            if(LinkImpl.this.foot ++ == index) {//索引相同
                return this.data;  //返回当前数据
            } else {
                return this.next.getNode(index);   //寻找下个索引
            }
        }
        public void setNode(int index,E data) {
            if(LinkImpl.this.foot ++ == index) {//索引相同
                this.data = data; //修改数据
            } else {
                this.next.setNode(index,data);
            }
        }
        public boolean containsNode(E data) {
            if(this.data.equals(data)) {//对象比较
                return true;
            } else {
                if(this.next == null) { //没有后续节点了
                    return false;  //找不到
                } else {
                    return this.next.containsNode(data);  //向后继续判断
                }
            }
        }
    }
    //-----------以下未Link类中定义的成员------------
    private Node root; //保存根元素
    private int count; //保存数据个数
    private int foot; //操作数组的角标
    private Object [] returnData; //返回的数据保存
    //-----------以下未Link类中定义的方法------------
    public void add(E e){
        if(e == null) {//保存的数据为空
            return ; //方法调用结束
        }
        //数据本身不具有关联特性，只有Node类有，必须要关联到Node里
        Node newNode = new Node(e); //创建一个新的节点
        if(this.root == null) {//现在没有根节点
            this.root = newNode; //第一个节点作为根节点
        } else {//根节点存在
            this.root.addNode(newNode);//将新节点保存到合适的位置
        }
        this.count ++ ; //计数+1
    }
    public int size() {//返回计数值
        return this.count;
    }
    public boolean isEmpty() {
        //return this.root == null;
        return this.count == 0;
    }
    public Object [] toArray() {
        if(this.isEmpty()) { //空集合
            return null;//现在没有数据
        }
        this.foot = 0; //脚标清零
        this.returnData = new Object [this.count]; //根据已有的长度开辟数组
        this.root.toArrayNode(); //利用Node类进行递归数据获取
        return this.returnData;
    }
    public E get(int index) {
        if(index >= this.count) { //索引应该在指定范围之内
            return null;
        } //索引数据的获取应该由Node类完成
        this.foot = 0; //重置索引下标
        return this.root.getNode(index);
    }
    public void set(int index,E data) {
        if(index >= this.count) { //索引应该在指定的范围之内
            return;  //方法结束
        } //索引数据的获取应该由Node类完成
        this.foot = 0; //重置索引的下标
        this.root.setNode(index,data);  //修改数据
    }
    public boolean contains(E data) {
        if(data == null) {
            return false;  //没有数据
        }
        return this.root.containsNode(data);  //交给Node类判断
    }
}

public class JavaDemo {
    public static void main(String[] args) {
        ILink<String> all = new LinkImpl<String>();
        System.out.println("【增加之前】数据个数： " + all.size());
        all.add("Hello");
        all.add("World");
        all.add("smile");
        System.out.println("【增加之后】数据个数： " + all.size());
        Object result [] = all.toArray();
        for (Object obj : result ) {
            System.out.println(obj);
        }
        all.set(1,"世界");
        System.out.println("-------数据获取的分割线-------");
        System.out.println(all.get(0));
        System.out.println(all.get(1));
        System.out.println(all.get(4)); 
        System.out.println("-------数据判断的分割线-------");
        System.out.println(all.contains("World"));
        System.out.println(all.contains("世界"));
    }
}
```

> 【增加之前】数据个数： 0
> 【增加之后】数据个数： 3
> Hello
> World
> smile
> -------数据获取的分割线-------
> Hello
> 世界
> null
> -------数据判断的分割线-------
> false
> true

由于整个链表没有空数据的存在，所以整体的程序再判断的时候直接使用每一个的节点数据发出equals()方法即可。

一定要保证不会为空再用equals

## 数据删除：public void remove(E data)

数据的删除指的是可以从即合理啊删除掉指定的一个数据内容，也就是说此时传递的是数据内容，那么如果要实现这种删除操作依然需要对象比较的支持，但是对于集合数据的删除需要考虑两种情况

* 要删除的是根节点数据（LinkImpl与根节点有关，所以这个判断由根节点完成）：

  ![image-20200805233237443](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200805233237443.png)

* 要删除的不是根节点数据（由Node类负责）：

  ![image-20200805233431875](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200805233431875.png)

  

![image-20200806161547826](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200806161547826.png)

![image-20200806162756797](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200806162756797.png)

删除逻辑就是靠引用改变完成的

```java
interface ILink<E> { //设置泛型避免安全隐患
    public void add(E e);
    public int size(); //获取数据的个数
    public boolean isEmpty(); //判断是否为空集合
    public Object [] toArray(); //将集合元素以数组形式返回
    public E get(int index); //根据索引获取数据
    public void set(int index,E data);//修改索引数据
    public boolean contains(E data);  //判断数据是否存在
    public void remove(E e);  //数据删除
    public void clean();  //清空链表
}

class LinkImpl<E> implements ILink<E> {
    private class Node {//保存节点的数据关系
        private E data; //保存的一个数据
        private Node next; // 保存下一个引用
        public Node(E data) {//有数据时才有意义
            this.data = data;
        }

        public void addNode(Node newNode) {//保存新的Node数据
            if(this.next == null) {//当前节点的下一个为null
                this.next = newNode;//保存为当前节点
            } else {
                this.next.addNode(newNode);     //迭代调用  
            }
        }
        //第一次调用：this = LinkImpl.root
        //第二次调用：this = LinkImpl.root.next
        //第三次调用：this = LinkImpl.root.next.next
        public void toArrayNode() {
            LinkImpl.this.returnData [LinkImpl.this.foot ++] = this.data;
            if(this.next != null) {//还有下一个数据
                this.next.toArrayNode();
            }
        }
        public E getNode(int index) {
            if(LinkImpl.this.foot ++ == index) {//索引相同
                return this.data;  //返回当前数据
            } else {
                return this.next.getNode(index);   //寻找下个索引
            }
        }
        public void setNode(int index,E data) {
            if(LinkImpl.this.foot ++ == index) {//索引相同
                this.data = data; //修改数据
            } else {
                this.next.setNode(index,data);
            }
        }
        public boolean containsNode(E data) {
            if(this.data.equals(data)) {//对象比较
                return true;
            } else {
                if(this.next == null) { //没有后续节点了
                    return false;  //找不到
                } else {
                    return this.next.containsNode(data);  //向后继续判断
                }
            }
        }
        public void removeNode(Node previous,E data) {
            if(this.data.equals(data)) {
                previous.next = this.next;   //空出当前节点
            } else {
                if(this.next != null) { //有后续节点
                    this.next.removeNode(this,data); //向后继续删除
                }
            }
        }
    }
    //-----------以下为Link类中定义的成员------------
    private Node root; //保存根元素
    private int count; //保存数据个数
    private int foot; //操作数组的角标
    private Object [] returnData; //返回的数据保存
    //-----------以下未Link类中定义的方法------------
    public void add(E e){
        if(e == null) {//保存的数据为空
            return ; //方法调用结束
        }
        //数据本身不具有关联特性，只有Node类有，必须要关联到Node里
        Node newNode = new Node(e); //创建一个新的节点
        if(this.root == null) {//现在没有根节点
            this.root = newNode; //第一个节点作为根节点
        } else {//根节点存在
            this.root.addNode(newNode);//将新节点保存到合适的位置
        }
        this.count ++ ; //计数+1
    }
    public int size() {//返回计数值
        return this.count;
    }
    public boolean isEmpty() {
        //return this.root == null;
        return this.count == 0;
    }
    public Object [] toArray() {
        if(this.isEmpty()) { //空集合
            return null;//现在没有数据
        }
        this.foot = 0; //脚标清零
        this.returnData = new Object [this.count]; //根据已有的长度开辟数组
        this.root.toArrayNode(); //利用Node类进行递归数据获取
        return this.returnData;
    }
    public E get(int index) {
        if(index >= this.count) { //索引应该在指定范围之内
            return null;
        } //索引数据的获取应该由Node类完成
        this.foot = 0; //重置索引下标
        return this.root.getNode(index);
    }
    public void set(int index,E data) {
        if(index >= this.count) { //索引应该在指定的范围之内
            return;  //方法结束
        } //索引数据的获取应该由Node类完成
        this.foot = 0; //重置索引的下标
        this.root.setNode(index,data);  //修改数据
    }
    public boolean contains(E data) {
        if(data == null) {
            return false;  //没有数据
        }
        return this.root.containsNode(data);  //交给Node类判断
    }
    public void remove(E data) {
        if(this.contains(data)) { //判断如果存在就删除
            if(this.root.data.equals(data)) { //是否为根节点
                this.root = this.root.next; //修改根节点为下一个
            } else { //交由Node类负责删除
                this.root.next.removeNode(this.root,data);
            }
            this.count -- ; //计数减少
        }
    }
    public void clean() {
        this.root =null;  //后续的所有节点都没了
        this.count = 0; //个数清零
	}
}

public class JavaDemo {
    public static void main(String[] args) {
        ILink<String> all = new LinkImpl<String>();
        System.out.println("【增加之前】数据个数： " + all.size());
        all.add("Hello");
        all.add("World");
        all.add("smile");
        System.out.println("【增加之后】数据个数： " + all.size());
        Object result [] = all.toArray();
        for (Object obj : result ) {
            System.out.println(obj);
        }
        all.set(1,"世界");
        all.remove("Hello");
        System.out.println("-------数据获取的分割线-------");
        System.out.println(all.get(0));
        System.out.println(all.get(1));
        System.out.println(all.get(4)); 
        System.out.println("-------数据判断的分割线-------");
        System.out.println(all.contains("World"));
        System.out.println(all.contains("世界"));
    }
}
```



## 清空链表：public void clean()

有些时候需要进行链表数据的整体清空处理，这个时候就可以直接根据根元素来控制，只要root设置为null，那么后续的节点就都不存在了

![image-20200806163506219](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200806163506219.png)

这是一个最简单基础的单向链表的实现

![image-20200806163938527](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200806163938527.png)



## 综合实践：宠物商店

现在假设有一个宠物商店，里面可以出售各种宠物，要求可以实现宠物的上架与下架处理，也可以根据关键字查询宠物的信息。

![image-20200806164645489](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200806164645489.png)

* 1.定义宠物标准
* 2.宠物商店应该以宠物的标准为主
* 3.根据宠物的标准来定义宠物信息

* 4.实现宠物商店的操作

```java
interface ILink<E> {}//同上一节
class LinkImpl<E> implements ILink<E> {}//同上一节
interface Pet { //定义宠物标准
    public String getName(); //获得名字
    public String getColor(); //获得颜色
    
}
class PetShop { //宠物商店
    private ILink<Pet> allPets = new LinkImpl<Pet>(); //保存多个宠物信息
    public void add(Pet pet) { //追加宠物，商品上架
        this.allPets.add(pet); //集合中保存对象
    }
    public void delete(Pet pet) {
        this.allPets.remove(pet);
    }
    public ILink<Pet> search(String keyword) {
        ILink<Pet> searchResult = new LinkImpl<Pet> ();//保存查询结果
        Object result [] = this.allPets.toArray(); //获取全部数据
        if(result!=null) {
            for (Object obj : result ) {
                Pet pet = (Pet) obj;
                if(pet.getName().contains(keyword) ||
                    pet.getColor().contains(keyword)) {
                    searchResult.add(pet); //保存查询结果
                }
            }
        }
        return searchResult;
    }
}
class Cat implements Pet {//实现宠物标准
    private String name;
    private String color;
    public Cat(String name,String color){
        this.name = name;
        this.color = color;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setColor(String color){
        this.color = color;
    }
    public String getName() {
        return this.name;
    }
    public String getColor() {
        return this.color;
    }
    public String toString() {
        return "【宠物猫】名字： " + this.name + "、颜色： " +this.color;
    }
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }
        if(!(obj instanceof Cat)) {
            return false;
        }
        if(this == obj) {
            return true;
        }
        Cat cat = (Cat) obj;
        return this.name.equals(cat.name) && this.color.equals(cat.color);
    }
}
class Dog implements Pet {//实现宠物标准
    private String name;
    private String color;
    public Dog(String name,String color){
        this.name = name;
        this.color = color;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setColor(String color){
        this.color = color;
    }
    public String getName() {
        return this.name;
    }
    public String getColor() {
        return this.color;
    }
    public String toString() {
        return "【宠物狗】名字： " + this.name + "、颜色： " +this.color;
    }
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }
        if(!(obj instanceof Dog)) {
            return false;
        }
        if(this == obj) {
            return true;
        }
        Dog dog = (Dog) obj;
        return this.name.equals(dog.name) && this.color.equals(dog.color);
    }
}
public class JavaDemo {
    public static void main(String[] args) {
        PetShop shop = new PetShop(); //开店
        shop.add(new Dog("黄斑狗","绿色"));
        shop.add(new Cat("小强猫","深绿色"));
        shop.add(new Cat("黄猫","深色"));
        shop.add(new Dog("黄狗","黄色"));
        shop.add(new Dog("斑点狗","灰色"));
        Object result [] = shop.search("黄").toArray();
        for (Object obj : result ) {
            System.out.println(obj);
        }

    }
}
```

> 【宠物狗】名字： 黄斑狗、颜色： 绿色
> 【宠物猫】名字： 黄猫、颜色： 深色
> 【宠物狗】名字： 黄狗、颜色： 黄色

所有的程序开发都是以接口为标准进行的，这样在进行后期程序处理的时候就可以非常的灵活，只要符合标准的对象都可以保存。



## 综合实战：超市购物车

使用面向对象的概念表示出下面的生活场景：小明去超市买东西，所有买到的东西都放在了购物车之中，最后到收银台一起结账。

![image-20200806214203494](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200806214203494.png)

避免类耦合，提出标准

![image-20200806214549554](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200806214549554.png)



* 1.定义出一个商品的标准

* ```java
  interface IGoods { //定义商品的标准
      public String getName();
      public double getPrice();
  }
  ```

* 2.定义购物车的处理标准

* ```java
  interface IShopCar { //购物车
      public void add(IGoods goods); //添加商品信息
      public void delete(IGoods goods); //删除商品
      public Object [] getAll(); //获得购物车中全部的商品信息
  }
  ```

* 3.定义购物车的实现类

* ```java
  class ShopCarImpl implements IShopCar {  //购物车的实现
      private ILink<IGoods> allGoods = new LinkImpl<IGoods>();
      public void add(IGoods goods) {
          this.allGoods.add(goods);
      }
      public void delete(IGoods goods) {
          this.allGoods.remove(goods);
      }
      public Object [] getAll() {
          return this.allGoods.toArray();
      }
  }
  ```

* 4.定义收银台（也可定义标准，人工/自助/...收银）

* ```java
  class Cashier { //收银台
      private IShopCar shopCar;
      public Cashier(IShopCar shopCar) {
          this.shopCar = shopCar;
      }
      public double allPrice() { //计算总价
          Object result [] = this.shopcar.getAll();
          double all = 0.0;
          for (Object obj : result ) {
              IGoods goods = (IGoods)obj;
              all += goods.getPrice();
          }
          return all;
      }
      public int allCount() { //商品数量
          return this.shopcar.getAll().length;
      }
  }
  ```

* 5.定义商品信息

  * 图书

  * ```java
    class Book implements IGoods {
        private String name;
        private double price;
        public Book(String name,double price) {
            this.name = name;
            this.price = price;
        }
        public String getName() {
            return this.name;
        }
        public double getPrice() {
            return this.price;
        }
        public boolean equals(Object obj) {
                    if(obj == null) {
                return false;
            }
            if(!(obj instanceof Book)) {
                return false;
            }
            if(this == obj) {
                return true;
            }
            Book book = (Book) obj;
            return this.name.equals(book.name) && this.price==book.price;
        }
        public String toString() {
            return "【图书信息】名称：" + this.name + "、价格：" + this.price;
        }
    }
    ```

  * 背包

  * ```java
    class Bag implements IGoods {
        private String name;
        private double price;
        public Bag(String name,double price) {
            this.name = name;
            this.price = price;
        }
        public String getName() {
            return this.name;
        }
        public double getPrice() {
            return this.price;
        }
        public boolean equals(Object obj) {
                    if(obj == null) {
                return false;
            }
            if(!(obj instanceof Bag)) {
                return false;
            }
            if(this == obj) {
                return true;
            }
            Bag bag = (Bag) obj;
            return this.name.equals(bag.name) && this.price==bag.price;
        }
        public String toString() {
            return "【背包信息】名称：" + this.name + "、价格：" + this.price;
        }
    }
    ```

* 6.编写测试代码

* ```java
  public class JavaDemo {
      public static void main(String[] args) {
          IShopCar car = new ShopCarImpl();
          car.add(new Book("Java开发",79.8));
          car.add(new Book("Oracle",99.9));
          car.add(new Bag("你的背包",788.8));
          Cashier cas = new Cashier(car);
          System.out.println("总价格：" + cas.allPrice() + "、购买数量：" + cas.allCount());
      }
  }
  ```

* > 总价格：968.5、购买数量：3总价格：968.5、购买数量：3

整体的代码都是基于链表实现的，避免频繁操作数组的麻烦

```java
interface ILink<E> { //设置泛型避免安全隐患
}
class LinkImpl<E> implements ILink<E> {
}
interface IGoods { //定义商品的标准
}
interface IShopCar { //购物车
}
class ShopCarImpl implements IShopCar {  //购物车的实现
}
class Cashier { //收银台
 }
class Book implements IGoods {//书
}
class Bag implements IGoods {//背包
}

public class JavaDemo {
    public static void main(String[] args) {
    }
}
```



# 第31章：Eclipse开发工具

Eclipse是现在一个比较大型的开源组织，主要是以推广Java标准以及IDE为主

## Eclipse简介

![image-20200806224145107](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200806224145107.png)

![image-20200806230732061](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200806230732061.png)

* 皇家正规：一套四五十万
* 正规杂牌军：一套二三十万
* 开源风：不要钱

IDEA，考虑版权问题

![image-20200806231502237](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200806231502237.png)

![image-20200806232140067](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200806232140067.png)

选download packages。本课推荐用OXYGEN 3 EE版本

![image-20200806232412238](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200806232412238.png)

![image-20200806232631089](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200806232631089.png)





第一次打开会提示设置工作区，一般所有的开发项目放在一个工作区就可以了。



找不到窗口或者位置错了，下面找回

![image-20200806232938173](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200806232938173.png)

实在找不回，删除工作区，换一个新的工作区再打开便恢复初始。eclipse的配置均根据工作区来设置的



Eclipse本身支持：JDT、Junit、CVS客户端、插件开发等功能。EE版本还支持各种Java EE的技术开发。



## 使用JDT开发Java程序

在Eclipse之中提供有JDT环境可以实现Java程序的开发，下面就通过一些功能进行演示

* 1、如果要进行项目的开啊，首先要创立一个新的项目：FirstProject；

  ![image-20200806235132723](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200806235132723.png)

* 2、随后输入项目的名称，同时会自动帮助用户找到可以使用的JDK版本，如果此处没有相应的JDK配置，需要开发者自己进行JRE配置，在进行jre添加的时候请选择标准的JRE

  ![image-20200806235206240](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200806235206240.png)

  ![image-20200806235254815](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200806235254815.png)

  ![image-20200806235340890](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200806235340890.png)

   ![image-20200806235411726](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200806235411726.png)

  ![image-20200806235451329](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200806235451329.png)

  在以后如果电脑上有多个JDK的清空下，就必须使用这种方式进行配置处理

* ![image-20200806235549180](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200806235549180.png)

  如果不切换

  ![image-20200806235620595](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200806235620595.png)

  ![image-20200806235745264](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200806235745264.png)

* 4、需要注意的是，理论上所有的开发的程序都应该使用一种统一的UTF-8的编码，uoyi严格意义上应该首先修改一下当前的Eclipse支持的文件编码，步骤【window】->【perferences】->【输入encoding搜索】

  ![image-20200806233859213](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200806233859213.png)

  法2，单独修改每个类

  ![image-20200807000137701](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200807000137701.png)

  ![image-20200807000204308](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200807000204308.png)

* ![image-20200806234050882](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200806234050882.png)

  ![image-20200806234106664](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200806234106664.png)

* 6、编写一个基础的程序

  ```java
  package cn.eclipse.demo
  public class Hello {
  	public static void main(String[] args) {
  		System.out.println("Hello World");
  	}
  }
  ```

  ![image-20200806234251595](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200806234251595.png)

* ![image-20200806234317523](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200806234317523.png)

* ![image-20200806234507476](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200806234507476.png)

* ![image-20200806234523867](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200806234523867.png)

* ![image-20200806234544453](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200806234544453.png)

  ```java
  package cn.eclipse.demo
  public class Hello {
  	public static void main(String[] args) {
  		for (String arg : args) {
              System.out.println(arg);
          }
  	}
  }
  ```

  ![image-20200806234653315](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200806234653315.png)

* ![image-20200806234721162](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200806234721162.png)

* ![image-20200806234910519](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200806234910519.png)

  ![image-20200806234924452](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200806234924452.png)



## DEBUG 调试

![image-20200807000313873](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200807000313873.png)

* ![image-20200807000401000](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200807000401000.png)

  ![image-20200807000424439](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200807000424439.png)

* ![image-20200807000511147](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200807000511147.png)
* ![image-20200807000524249](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200807000524249.png)
* ![image-20200807000659417](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200807000659417.png)



## JUNIT 测试工具

![image-20200807000759915](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200807000759915.png)

![image-20200807000831730](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200807000831730.png)

![image-20200807000848716](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200807000848716.png)

junit是一个第三方组建包，所以需要在JavaBuilderPath中配置相应的程序库，使用此种方式主要的原因是它可以帮助开发者来配置*.jar文件的CLASSPATH环境

![image-20200807001131809](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200807001131809.png)

![image-20200807001146578](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200807001146578.png)

![image-20200807002944382](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200807002944382.png)

![image-20200807002920639](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section2/image-20200807002920639.png)

理论上由专门的测试人员编写好测试用例。