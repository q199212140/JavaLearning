# 第1章：Java多线程编程

## 2.进程与线程

在Java语言里面最大的特点是支持多线程的开发（也是位数不多支持多线程的编程语言），所以在整个的Java技术的学习里面，如果你不能对多线程的概念有一个全面并且细致的了解，则在日后进行一些项目设计的过程之中尤其是并发访问设计的过程之中就会出现严重的技术缺陷。

![image-20200807112800338](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200807112800338.png)

![image-20200807112951257](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200807112951257.png)

![image-20200807113040590](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200807113040590.png)



## 3.继承Tread类实现多线程

如果想要在Java之中实现多线程的定义，那么就需要有一个专门的线程主体类 进行线程的执行任务的定义，而这个主题类的定义是有要求的，必须实现特定的接口或者继承特定的父类才可以完成

![image-20200807113442588](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200807113442588.png)

```java
class MyThread extends Thread{
    @Override
    public void run(){ // 做为线程的主体
        for(int x=0;x<5;x++){
            System.out.println("x = " + x--) ;
        }
    }
}
```

![image-20200807123350838](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200807123350838.png)

```java
public class ThreadDemo 
{
	public static void main(String[] args) 
	{
		new MyThread("线程A").run();
		new MyThread("线程B").run();
		new MyThread("线程C").run();
	}
}
```

以上的调用结果为abc依次执行，如果要交替（同时）进行，需要用start

```java
public class ThreadDemo 
{
	public static void main(String[] args) 
	{
		new MyThread("线程A").start();
		new MyThread("线程B").start();
		new MyThread("线程C").start();
	}
}
```

> 线程对象B运行：x = 0
> 线程对象B运行：x = 1
> 线程对象B运行：x = 2
> 线程对象B运行：x = 3
> 线程对象B运行：x = 4
> 线程对象B运行：x = 5
> 线程对象B运行：x = 6
> 线程对象A运行：x = 0
> 线程对象C运行：x = 0
> 线程对象A运行：x = 1
> 线程对象B运行：x = 7
> 线程对象A运行：x = 2
> 线程对象C运行：x = 1
> 线程对象A运行：x = 3
> 线程对象B运行：x = 8
> 线程对象A运行：x = 4
> 线程对象C运行：x = 2
> 线程对象A运行：x = 5
> 线程对象B运行：x = 9
> 线程对象A运行：x = 6
> 线程对象A运行：x = 7
> 线程对象A运行：x = 8
> 线程对象A运行：x = 9
> 线程对象C运行：x = 3
> 线程对象C运行：x = 4
> 线程对象C运行：x = 5
> 线程对象C运行：x = 6
> 线程对象C运行：x = 7
> 线程对象C运行：x = 8
> 线程对象C运行：x = 9

![image-20200807125316378](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200807125316378.png)

```java
 public synchronized void start() {
        if (this.threadStatus != 0) { //判断线程状态
            throw new IllegalThreadStateException();  //抛出异常
        } else {
            this.group.add(this);
            boolean started = false;

            try {
                this.start0();  //start调用了start0
                started = true;
            } finally {
                try {
                    if (!started) {
                        this.group.threadStartFailed(this);
                    }
                } catch (Throwable var8) {
                }

            }

        }
    }
    private native void start0();  //只定义了名字
```

![image-20200807125522641](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200807125522641.png)

```java
public class ThreadDemo 
{
	public static void main(String[] args) 
	{
		MyThread mt = new MyThread("线程A");
		mt.start();
		mt.start();
	}
}
```

> Exception in thread "main" java.lang.IllegalThreadStateException
> 	at java.base/java.lang.Thread.start(Thread.java:794)
> 	at cn.mldn.demo.ThreadDemo.main(ThreadDemo.java:28)

![image-20200807125900142](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200807125900142.png)

![image-20200807160625575](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200807160625575.png)

任何情况下，只要定义了多线程，多线程的启动永远只有一种方案：Thread类中的start()方法



## 基于Runnable接口实现多线程

![image-20200807160817238](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200807160817238.png)

![image-20200807160855932](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200807160855932.png)

范例：通过Runnable实现线程主体类

```java
class MyThread2 implements Runnable { //线程主体类
	private String title;
	public MyThread2(String title) {
		this.title = title;
	}

	@Override
	public void run() { //线程主体方法
		for(int i = 0; i < 10; i++) {
			System.out.println(this.title + "运行：x = " + i);
		}
	}
}
```

![image-20200807161221748](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200807161221748.png)

```java
public class ThreadDemo {
	public static void main(String[] args) {
		Thread threadA = new Thread(new MyThread2(("线程对象A")));
		threadA.start(); //启动多线程
		Thread threadB = new Thread(new MyThread2(("线程对象B")));
		threadB.start(); //启动多线程
		Thread threadC = new Thread(new MyThread2(("线程对象C")));
		threadC.start(); //启动多线程
	}
}
```

可以实现多继承

![image-20200807161605033](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200807161605033.png)

范例：利用Lambda实现多线程定义

```java
public class ThreadDemo {
	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) {
			String title = "线程对象-" + i ;
			Runnable run = () -> {
				for (int j = 0; j < 10; j++) {
					System.out.println(title + "运行，y = " + j);
				}
			};
			new Thread(run).start();
		}
	}
}
```

化简方式：

```java
public class ThreadDemo {
	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) {
			String title = "线程对象-" + i ;
			new Thread(() -> {
				for (int j = 0; j < 10; j++) {
					System.out.println(title + "运行，y = " + j);
				}
			}).start();
		}
	}
}
```

以后的开发之中对于多线程的实现，优先考虑Runnable接口实现，并且永恒都是通过Thread类对象启动多线程



## Thread和Runnable的关系

![image-20200807162417232](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200807162417232.png)

![image-20200808105942856](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200808105942856.png)

```java
package cn.mldn.demo;

class MyThread implements Runnable { //线程主体类
	private String title;
	public MyThread(String title) {
		this.title = title;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.println(this.title + "运行：x = " + i);
		}
	}
}

public class ThreadDemo {
	public static void main(String[] args) {
		Thread threadA = new Thread(new MyThread2(("线程对象A")));
		Thread threadB = new Thread(new MyThread2(("线程对象B")));
		Thread threadC = new Thread(new MyThread2(("线程对象C")));
		threadA.start(); //启动多线程
		threadB.start(); //启动多线程
		threadC.start(); //启动多线程
	}
}
```



![image-20200807162915008](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200807162915008.png)

![image-20200808111243537](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200808111243537.png)

![image-20200808111255332](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200808111255332.png)

![image-20200808111529159](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200808111529159.png)

![image-20200808111539560](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200808111539560.png)

![image-20200809101212946](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200809101212946.png)



高并发：n个线程对象。Runnable子类描述的是资源

理论上Thread也可以描述资源

![image-20200808113022226](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200808113022226.png)

范例：利用买票程序实现多个线程的资源并发访问

```java
package cn.mldn.demo;

class MyThread implements Runnable { //线程主体类
	private int ticket = 5;

	@Override
	public void run() {
		for(int i = 0; i < 100; i++) {
			if(this.ticket > 0) {

				System.out.println("卖票.ticket = " + this.ticket--);
			}
		}
	}
}

public class ThreadDemo {
	public static void main(String[] args) {
		MyThread mt = new MyThread();
		new Thread(mt).start();  //第一个线程启动
		new Thread(mt).start();  //第二个线程启动
		new Thread(mt).start();  //第三个线程启动
	}
}
```

三个线程访问了同一个资源，三个线程对象指向了同一个对象

以上如果将

> class MyThread implements Runnable 

更换为

> class MyThread extends Thread

执行也正常，但是不推荐。因为此时MyThread类有自己的start方法，而Thread(mt).start()会使用新的一个Thread对象的start方法

![image-20200809105104538](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200809105104538.png)



## Callable实现多线程

![image-20200809105155559](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200809105155559.png)

并发访问包，juc编程框架

![image-20200809105236372](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200809105236372.png)

**Callable与Thread没关系，怎么实现start？**

![image-20200809105605488](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200809105605488.png)

![image-20200809105643861](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200809105643861.png)

Future的get方法获取返回值

![image-20200809111048522](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200809111048522.png)

把Callable封装到FutureTask提供给Thread管理

![image-20200809111629754](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200809111629754.png)

```java
class MyThread implements Callable<String> {

	@Override
	public String call() throws Exception {
		for (int i = 0; i < 10; i++) {
			System.out.println("********* 线程执行，i= " + i);
		}
		return "线程执行完毕";
	}
}

public class ThreadDemo {

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		FutureTask<String> task = new FutureTask<>(new MyThread());
		new Thread(task).start();
		System.out.println("【线程返回数据：】" + task.get());
	}
}
```

> ********* 线程执行，i= 0
> ********* 线程执行，i= 1
> ********* 线程执行，i= 2
> ********* 线程执行，i= 3
> ********* 线程执行，i= 4
> ********* 线程执行，i= 5
> ********* 线程执行，i= 6
> ********* 线程执行，i= 7
> ********* 线程执行，i= 8
> ********* 线程执行，i= 9
> 【线程返回数据：】线程执行完毕

![image-20200809112315719](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200809112315719.png)

都是抽象接口



## 线程运行状态

![image-20200809112614770](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200809112614770.png)

参考操作系统原理



# 第2章：线程常用操作方法

多线程的主要操作方法都在Thread类中定义了

## 线程的命名与取得

![image-20200809113302331](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200809113302331.png)

![image-20200809114107177](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200809114107177.png)

![image-20200809114149227](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200809114149227.png)

![image-20200809114712855](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200809114712855.png)

```java
class MyThread implements Runnable {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
	}
}

public class ThreadDemo {
	public static void main(String[] args) {
		MyThread mt = new MyThread();
		new Thread(mt,"线程A").start();//设置线程名字
		new Thread(mt).start();//没设置线程名字
		new Thread(mt).start();//没设置线程名字
		new Thread(mt).start();//没设置线程名字
		new Thread(mt).start();//没设置线程名字
		new Thread(mt,"线程B").start();//设置线程名字
	}
}
```

> 线程A
> Thread-1
> Thread-0
> 线程B
> Thread-3
> Thread-2

![image-20200809114915308](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200809114915308.png)

范例：观察下列程序

```java
class MyThread implements Runnable {
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
	}
}
public class ThreadDemo {
	public static void main(String[] args) {
		MyThread mt = new MyThread();
		new Thread(mt,"线程对象").start(); //设置线程
		mt.run();
	}
}
```

> main
> 线程对象

![image-20200809115559063](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200809115559063.png)

范例：子线程处理

错误示范

```java

public class ThreadDemo {
	public static void main(String[] args) {
		System.out.println("1.执行操作任务一。");
		int temp = 0;
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			temp += i;
		}
		System.out.println("2.执行操作任务二。");
		System.out.println("......");
		System.out.println("n.执行操作任务N。");

	}
}
```

耗时的操作不应该放在主流程中进行

```java
public class ThreadDemo {
	public static void main(String[] args) {
		System.out.println("1.执行操作任务一。");
		new Thread( () -> {//子线程处理业务
			int temp = 0;
			for (int i = 0; i < Integer.MAX_VALUE; i++) {
				temp += i;
			}
			System.out.println("1.操作任务一完成。");
		}).start();
		System.out.println("2.执行操作任务二。");
		System.out.println("2.操作任务二完成。");
		System.out.println("n.执行操作任务N。");
		System.out.println("n.操作任务N完成。");
	}
}
```

> 1.执行操作任务一。
> 2.执行操作任务二。
> 2.操作任务二完成。
> n.执行操作任务N。
> n.操作任务N完成。
> 1.操作任务一完成。

主线程处理整体流程，而子流程负责处理耗时操作



## 线程的休眠

![image-20200809122234024](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200809122234024.png)

![image-20200809122336947](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200809122336947.png)

![image-20200809122404686](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200809122404686.png)

```java
public class ThreadDemo {
	public static void main(String[] args) {
		new Thread( ()-> {
			for (int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread().getName() + "、i = " + i);
				try {
					Thread.sleep(1000); //暂缓执行
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		},"线程对象").start();
	}
}
```

![image-20200809123147786](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200809123147786.png)

范例：产生多个线程对象进行休眠处理

```java
public class ThreadDemo {
    public static void main(String[] args) {
        for (int num = 0; num < 5; num++) {
            new Thread(() -> {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + "、i = " + i);
                    try {
                        Thread.sleep(1000); //暂缓执行
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "线程对象"+num).start();
        }
    }
}
```

> 线程对象1、i = 0
> 线程对象2、i = 0
> 线程对象4、i = 0
> 线程对象3、i = 0
> 线程对象0、i = 0
> 线程对象3、i = 1
> 线程对象2、i = 1
> 线程对象4、i = 1
> 线程对象1、i = 1
> 线程对象0、i = 1
> 线程对象2、i = 2
> 线程对象4、i = 2
> 线程对象3、i = 2
> 线程对象1、i = 2
> 线程对象0、i = 2
> 线程对象2、i = 3
> 线程对象4、i = 3
> 线程对象3、i = 3
> 线程对象0、i = 3
> 线程对象1、i = 3
> 线程对象2、i = 4
> 线程对象3、i = 4
> 线程对象4、i = 4
> 线程对象0、i = 4
> 线程对象1、i = 4
> 线程对象2、i = 5
> 线程对象3、i = 5
> 线程对象4、i = 5
> 线程对象0、i = 5
> 线程对象1、i = 5
> 线程对象2、i = 6
> 线程对象4、i = 6
> 线程对象3、i = 6
> 线程对象0、i = 6
> 线程对象1、i = 6
> 线程对象2、i = 7
> 线程对象4、i = 7
> 线程对象3、i = 7
> 线程对象0、i = 7
> 线程对象1、i = 7
> 线程对象2、i = 8
> 线程对象4、i = 8
> 线程对象3、i = 8
> 线程对象0、i = 8
> 线程对象1、i = 8
> 线程对象2、i = 9
> 线程对象4、i = 9
> 线程对象3、i = 9
> 线程对象0、i = 9
> 线程对象1、i = 9

![image-20200809123558620](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200809123558620.png)

所有对象一起将进入到run方法中执行的。但执行会有先后

![image-20200809123801121](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200809123801121.png)

```java
public class ThreadDemo {
    public static void main(String[] args) {
        for (int num = 0; num < 5; num++) {
            new Thread(() -> {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + "、i = " + i);
                    try {
                        Thread.sleep(0,num); //暂缓执行
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "线程对象"+num).start();
        }
    }
}
```

> Error:(193, 40) java: 从lambda 表达式引用的本地变量必须是最终变量或实际上的最终变量

**从lambda 表达式引用的本地变量必须是最终变量或实际上的最终变量**

Lambda表达式规则

- 只能引用标记了 final 的外层局部变量，这就是说不能在 lambda 内部修改定义在域外的局部变量，否则会编译错误。
- 局部变量可以不用声明为 final，但是必须不可被后面的代码修改（即隐性的具有 final 的语义）
- 不允许声明一个与局部变量同名的参数或者局部变量。

jdk8新添加的Effectively final 特性，会帮你把lamda表达式的变量自动转换为final类型

上述代码，传递给lambda的参数num可以被修改，没符合隐形final。所以必须以下修改

```java
public class ThreadDemo {
    public static void main(String[] args) {
        for (int num = 0; num < 5; num++) {
			int finalNum = num;
			new Thread(() -> {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + "、i = " + i);
                    try {
                        Thread.sleep(0, finalNum); //暂缓执行
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "线程对象"+num).start();
        }
    }
}
```

耗时不同，产生了先后差别

> 线程对象2、i = 0
> 线程对象4、i = 0
> 线程对象0、i = 0
> 线程对象1、i = 0
> 线程对象3、i = 0
> 线程对象0、i = 1
> 线程对象2、i = 1
> 线程对象0、i = 2
> 线程对象0、i = 3
> 线程对象4、i = 1
> 线程对象1、i = 1
> 线程对象3、i = 1
> 线程对象0、i = 4
> 线程对象2、i = 2
> 线程对象1、i = 2
> 线程对象3、i = 2
> 线程对象4、i = 2
> 线程对象2、i = 3
> 线程对象0、i = 5
> 线程对象1、i = 3
> 线程对象4、i = 3
> 线程对象3、i = 3
> 线程对象0、i = 6
> 线程对象0、i = 7
> 线程对象2、i = 4
> 线程对象0、i = 8
> 线程对象0、i = 9
> 线程对象4、i = 4
> 线程对象3、i = 4
> 线程对象1、i = 4
> 线程对象2、i = 5
> 线程对象4、i = 5
> 线程对象1、i = 5
> 线程对象3、i = 5
> 线程对象2、i = 6
> 线程对象1、i = 6
> 线程对象3、i = 6
> 线程对象4、i = 6
> 线程对象2、i = 7
> 线程对象1、i = 7
> 线程对象4、i = 7
> 线程对象3、i = 7
> 线程对象2、i = 8
> 线程对象1、i = 8
> 线程对象4、i = 8
> 线程对象3、i = 8
> 线程对象2、i = 9
> 线程对象1、i = 9
> 线程对象4、i = 9
> 线程对象3、i = 9



## 线程中断

![image-20200809125057719](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200809125057719.png)

![image-20200809125153203](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200809125153203.png)

![image-20200809125204656](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200809125204656.png)

范例：观察线程中断处理操作

```java
public class ThreadDemo {
	public static void main(String[] args) throws Exception {
		Thread td = new Thread( () -> {
			System.out.println("---需要睡觉补充体力");
			try {
				Thread.sleep(10000); //预计休眠10秒
				System.out.println("睡足了，又可以出去祸害别人---");
			} catch (InterruptedException e) {
				System.out.println("敢打扰老子睡觉");
			}
		});
		td.start(); //开始睡
		Thread.sleep(1000);
		if(!td.isInterrupted()) {
			System.out.println("偷偷打扰你的睡眠");
			td.interrupt();
		}
	}
}
```

> ---需要睡觉补充体力
> 偷偷打扰你的睡眠
> 敢打扰老子睡觉

如果不执行td.interrupt();

> ---需要睡觉补充体力
> 偷偷打扰你的睡眠
> 睡足了，又可以出去祸害别人---

所有正在执行的线程都是可以被中断的，中断线程必须进行异常处理



## 线程的强制执行

所谓的线程强制执行值得是满足于某些条件之后，某一个线程对象将可以一直独占资源，一直到该线程的程序执行结束

范例：观察一个没有强制执行的程序

```java
public class ThreadDemo {
	public static void main(String[] args) throws Exception{
		Thread thread = new Thread( () -> {
			for (int i = 0; i < 100; i++) {
				System.out.println(Thread.currentThread().getName() + "执行 i = " + i);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		},"玩耍的线程");
		thread.start();
		for (int i = 0; i < 100; i++) {
			System.out.println("【霸道的main线程】number = " + i);
			Thread.sleep(100);
		}
	}
}
```

> 【霸道的main线程】number = 0
> 玩耍的线程执行 i = 0
> 【霸道的main线程】number = 1
> 玩耍的线程执行 i = 1
> 【霸道的main线程】number = 2
> 玩耍的线程执行 i = 2
> 【霸道的main线程】number = 3
> 玩耍的线程执行 i = 3
> 【霸道的main线程】number = 4
> 玩耍的线程执行 i = 4
> 【霸道的main线程】number = 5
> 玩耍的线程执行 i = 5
> 【霸道的main线程】number = 6
> 玩耍的线程执行 i = 6
> 【霸道的main线程】number = 7
> 玩耍的线程执行 i = 7
>
> ......

这个时候主线程和子线程都在交替执行，不断地抢夺cpu。但是如果说希望主线程独占执行，就可以利用Thread类中的方法。

* 强制执行：

  > public final void join() throw InterruptedException;

```java
public class ThreadDemo {
	public static void main(String[] args) throws Exception{
		Thread mainThread = Thread.currentThread(); //获得主线程
		Thread thread = new Thread( () -> {
			for (int i = 0; i < 100; i++) {
				if(i == 3) { //现在霸道的线程来了
					try {
						mainThread.join();//霸道的线程先执行
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				try{
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + "执行 i = " + i);
			}
		},"玩耍的线程");
		thread.start();
		for (int i = 0; i < 100; i++) {
			Thread.sleep(100);
			System.out.println("【霸道的main线程】number = " + i);
		}
	}
}
```

> 【霸道的main线程】number = 0
> 玩耍的线程执行 i = 0
> 【霸道的main线程】number = 1
> 玩耍的线程执行 i = 1
> 【霸道的main线程】number = 2
> 玩耍的线程执行 i = 2
> 【霸道的main线程】number = 3
> 【霸道的main线程】number = 4
>
> ...
>
> 【霸道的main线程】number = 99
>
> 玩耍的线程执行 i = 3
> 玩耍的线程执行 i = 4
>
> ...
>
> 玩耍的线程执行 i = 99

在进行线程强制执行的时候一定要获取强制执行线程对象之后才可以执行join调用



## 线程的礼让

线程的礼让指的是先将资源让出去，让别的线程先执行。线程的礼让可以使用Thread中提供的方法：

* 礼让：

> public static void yield()

范例：使用礼让操作

```java
public class ThreadDemo {
	public static void main(String[] args) throws Exception {
		Thread mainThread = Thread.currentThread(); //获得主线程
		Thread thread = new Thread(() -> {
			for (int i = 0; i < 100; i++) {
				if (i % 3 == 0) {
					Thread.yield(); //线程礼让
					System.out.println("##### 玩耍的线程礼让执行 #####");
				}

				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + "执行 i = " + i);
			}
		}, "玩耍的线程");
		thread.start();

		for (int i = 0; i < 100; i++) {
			Thread.sleep(1);
			System.out.println("【霸道的main线程】number = " + i);
		}
	}
}
```

> ...
>
> 玩耍的线程执行 i = 5
>
> ##### 玩耍的线程礼让执行 #####
> 【霸道的main线程】number = 14
> 玩耍的线程执行 i = 6
> 玩耍的线程执行 i = 7
> 【霸道的main线程】number = 15
> 玩耍的线程执行 i = 8
> 【霸道的main线程】number = 16
> ##### 玩耍的线程礼让执行 #####
> 【霸道的main线程】number = 17
> 玩耍的线程执行 i = 9
>
> ...

线程的礼让执行时每一次调用yield方法都只会礼让一次当前资源



## 线程优先级

![image-20200810150543013](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200810150543013.png)

范例：观察优先级

```java
public class ThreadDemo {
    public static void main(String[] args) {
        Runnable run = () -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + "执行。");
            }
        };
        Thread threadA = new Thread(run, "线程对象A");
        Thread threadB = new Thread(run, "线程对象B");
        Thread threadC = new Thread(run, "线程对象C");
        threadA.setPriority(Thread.MIN_PRIORITY);
		threadB.setPriority(Thread.NORM_PRIORITY);
		threadC.setPriority(Thread.MAX_PRIORITY);
        threadA.start();
        threadB.start();
        threadC.start();
    }
}
```

> 线程对象C执行。
> 线程对象B执行。
> 线程对象A执行。
> 线程对象C执行。
> 线程对象B执行。
> 线程对象A执行。

**有可能先执行，不是绝对先执行！！！**

主方法是一个主线程，主线程的优先级？

```java
public class ThreadDemo {
	public static void main(String[] args) {
		System.out.println("主线程优先级：" + Thread.currentThread().getPriority());
		System.out.println("默认线程优先级：" + new Thread().getPriority());
	}
}
```

> 主线程优先级：5
> 默认线程优先级：5

主线程是属于中等优先级，而默认创建的线程也是中等优先级



# 第3章：线程的同步与死锁

在多线程的处理之中，可以利用Runnable描述多个线程操作的资源，而Thread描述每一个线程对象，于是当多个线程防蚊虫同一资源的时候如果处理不当就会产生数据的错误操作

##　同步问题的引出

下面写一个简单的卖票程序,将创建若干个线程对象实现卖票的处理操作

范例：实现卖票操作

```java
class MyThread implements Runnable {
	private int ticket = 10 ;  //总票数10张
	@Override
	public void run() {
		while(true) {
			if(this.ticket > 0) {
				System.out.println(Thread.currentThread().getName() + "卖票.ticket = " + this.ticket--);
			} else {
				System.out.println("--------票已卖光--------");
				break;
			}
		}
	}
}

public class ThreadDemo {
	public static void main(String[] args) {
		MyThread mt = new MyThread();
		new Thread(mt,"票贩子A").start();
		new Thread(mt,"票贩子B").start();
		new Thread(mt,"票贩子C").start();
	}
}
```

> 票贩子A卖票.ticket = 10
> 票贩子A卖票.ticket = 7
> 票贩子A卖票.ticket = 6
> 票贩子A卖票.ticket = 5
> 票贩子A卖票.ticket = 4
> 票贩子A卖票.ticket = 3
> 票贩子A卖票.ticket = 2
> 票贩子A卖票.ticket = 1
> --------票已卖光--------
> 票贩子C卖票.ticket = 8
> --------票已卖光--------
> 票贩子B卖票.ticket = 9
> --------票已卖光--------

![image-20200810165022557](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200810165022557.png)

```java
class MyThread implements Runnable {
	private int ticket = 10 ;  //总票数10张
	@Override
	public void run() {
		while(true) {
			if(this.ticket > 0) {
				try {
					Thread.sleep(100); //模拟网络延迟
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + "卖票.ticket = " + this.ticket--);
			} else {
				System.out.println("--------票已卖光--------");
				break;
			}
		}
	}
}

public class ThreadDemo {
	public static void main(String[] args) {
		MyThread mt = new MyThread();
		new Thread(mt,"票贩子A").start();
		new Thread(mt,"票贩子B").start();
		new Thread(mt,"票贩子C").start();
	}
}
```

> 票贩子B卖票.ticket = 9
> 票贩子A卖票.ticket = 8
> 票贩子C卖票.ticket = 10
> 票贩子C卖票.ticket = 7
> 票贩子A卖票.ticket = 6
> 票贩子B卖票.ticket = 5
> 票贩子B卖票.ticket = 4
> 票贩子A卖票.ticket = 3
> 票贩子C卖票.ticket = 2
> 票贩子A卖票.ticket = 1
> 票贩子B卖票.ticket = 0
> --------票已卖光--------
> --------票已卖光--------
> 票贩子C卖票.ticket = -1
> --------票已卖光--------

这时追加了延迟，问题就暴露出来了，而实际上这个问题一直都在

![image-20200810165503242](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200810165503242.png)





## 线程同步

![image-20200810165558379](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200810165558379.png)

![image-20200810165632386](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200810165632386.png)

如果要在程序之中实现这把锁的功能，就可以使用synchronized关键字来实现，利用此关键字可以定义同步方法或同步代码块，再同步代码块的操作里面的代码只允许一个线程执行。



### 1.利用同步代码块进行处理

![image-20200810170201361](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200810170201361.png)

范例：利用同步代码块解决数据同步访问问题

```java
class MyThread implements Runnable {
	private int ticket = 10 ;  //总票数10张
	@Override
	public void run() {
		while(true) {
			synchronized (this) { //每一次只允许一个线程进行访问
				if(this.ticket > 0) {
					try {
						Thread.sleep(100); //模拟网络延迟
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + "卖票.ticket = " + this.ticket--);
				} else {
					System.out.println("--------票已卖光--------");
					break;
				}
			}
		}
	}
}

public class ThreadDemo {
	public static void main(String[] args) {
		MyThread mt = new MyThread();
		new Thread(mt,"票贩子A").start();
		new Thread(mt,"票贩子B").start();
		new Thread(mt,"票贩子C").start();
	}
}
```

> 票贩子A卖票.ticket = 10
> 票贩子A卖票.ticket = 9
> 票贩子C卖票.ticket = 8
> 票贩子B卖票.ticket = 7
> 票贩子B卖票.ticket = 6
> 票贩子B卖票.ticket = 5
> 票贩子B卖票.ticket = 4
> 票贩子B卖票.ticket = 3
> 票贩子C卖票.ticket = 2
> 票贩子A卖票.ticket = 1
> --------票已卖光--------
> --------票已卖光--------
> --------票已卖光--------

加入同步处理之后，程序的整体的性能下降了。同步实际上会造成性能的降低。

### 2.利用同步方法解决：

只需要再方法定义上使用synchronized关键字即可

```java
class MyThread implements Runnable {
	private int ticket = 10 ;  //总票数10张
	public synchronized boolean sale() {
		if(this.ticket > 0) {
			try {
				Thread.sleep(100); //模拟网络延迟
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "卖票.ticket = " + this.ticket--);
			return true;
		} else {
			System.out.println("--------票已卖光--------");
			return false;
		}
	}
	@Override
	public void run() {
		while(this.sale()){};
	}
}

public class ThreadDemo {
	public static void main(String[] args) {
		MyThread mt = new MyThread();
		new Thread(mt,"票贩子A").start();
		new Thread(mt,"票贩子B").start();
		new Thread(mt,"票贩子C").start();
	}
}
```

日后学习Java类库时候会发现，系统中许多的类上使用的同步处理采用的都是同步方法



## 死锁

![image-20200810170745826](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200810170745826.png)

范例：死锁的展示

![image-20200810171437883](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200810171437883.png)

![image-20200810171513455](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200810171513455.png)

![image-20200810171533833](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200810171533833.png)



# 第4章：综合案例-生产者与消费者

![image-20200812082749932](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200812082749932.png)

## 程序的基本实现

![image-20200812082824586](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200812082824586.png)

![image-20200812082842814](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200812082842814.png)

```java
public class ThreadDemo {

    public static void main(String[] args) {
        Message msg = new Message();
        new Thread(new Producer(msg)).start();    //启动生产者线程
        new Thread(new Consumer(msg)).start();    //启动消费者线程
    }
}

class Producer implements Runnable {

    private Message msg;

    public Producer(Message msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                this.msg.setTitle("王健");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.msg.setContent("宇宙大帅哥");
            } else {
                this.msg.setTitle("小高");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.msg.setContent("猥琐第一人");
            }
        }
    }
}

class Consumer implements Runnable {

    private Message msg;

    public Consumer(Message msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.msg.getTitle() + " - " + this.msg.getContent());
        }
    }
}

class Message {

    private String title;
    private String content;

    public void setContent(String content) {
        this.content = content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public String getTitle() {
        return title;
    }
}

```

> 小高 - 宇宙大帅哥
> 小高 - 宇宙大帅哥
> 王健 - 猥琐第一人
> 小高 - 宇宙大帅哥
> 王健 - 猥琐第一人
> 小高 - 宇宙大帅哥
> 小高 - 宇宙大帅哥
>
> ...

![image-20200812092227749](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200812092227749.png)



## 解决数据同步

![image-20200812092437381](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200812092437381.png)

```java
public class ThreadDemo {

    public static void main(String[] args) {
        Message msg = new Message();
        new Thread(new Producer(msg)).start();    //启动生产者线程
        new Thread(new Consumer(msg)).start();    //启动消费者线程
    }
}

class Producer implements Runnable {

    private Message msg;

    public Producer(Message msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                this.msg.set("王健","宇宙大帅哥");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                this.msg.set("小高","猥琐第一人");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class Consumer implements Runnable {

    private Message msg;

    public Consumer(Message msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
			System.out.println(this.msg.get());
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Message {

    private String title;
    private String content;

    public synchronized void set(String title,String content) {
		this.content = content;
		this.title = title;
	}

    public synchronized String get() {
		return this.title + " - " + this.content;
	}
}
```

> 王健 - 宇宙大帅哥
> 王健 - 宇宙大帅哥
> 小高 - 猥琐第一人
> 王健 - 宇宙大帅哥
> 小高 - 猥琐第一人
> 王健 - 宇宙大帅哥
> 小高 - 猥琐第一人
> 王健 - 宇宙大帅哥
> 小高 - 猥琐第一人
> 王健 - 宇宙大帅哥
> 小高 - 猥琐第一人
> 王健 - 宇宙大帅哥
>
> ...

![image-20200812093747532](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200812093747532.png)



## 线程等待与唤醒



绿灯-生产

![image-20200812093911361](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200812093911361.png)

红灯-消费者取走

![image-20200812093939079](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200812093939079.png)

绿灯-生产者继续生产

![image-20200812094020896](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200812094020896.png)

红灯-消费者没消费，有一个产品要生产---等待！！！

![image-20200812094106986](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200812094106986.png)

![image-20200812094331746](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200812094331746.png)

如果此时又若干个等待线程的话，那么notify()表示的是唤醒第一个等待的，而其他的线程继续等待，而notifyAll()表示唤醒所有的等待线程，哪个线程优先级高可能先执行。

对于当前的问题主要的解决应该通过Message类完成处理

范例：修改Message类

```java
public class ThreadDemo {

    public static void main(String[] args) {
        Message msg = new Message();
        new Thread(new Producer(msg)).start();    //启动生产者线程
        new Thread(new Consumer(msg)).start();    //启动消费者线程
    }
}

class Producer implements Runnable {

    private Message msg;

    public Producer(Message msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                this.msg.set("王健", "宇宙大帅哥");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                this.msg.set("小高", "猥琐第一人");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class Consumer implements Runnable {

    private Message msg;

    public Consumer(Message msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(this.msg.get());
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Message {

    private String title;
    private String content;
    private boolean flag = true;  //表示生产或消费的形式
    //flag == ture 可以生产，不可用消费
    //flag == fallse 可以消费，不可用生产

    public synchronized void set(String title, String content) {
        if (this.flag == false) { //无法进行生产，等待被消费
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.title = title;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.content = content;
        this.flag = false; // 已经生产过了
        super.notify(); //生产完了，唤醒等待的消费线程
    }

    public synchronized String get() {
        if (this.flag == true) {//还需要生产，需要等待
			try {
				super.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        }
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try{
			return this.title + " - " + this.content;
		} finally { // b不管怎么样都要执行
			this.flag = true; //继续生产
			super.notify(); //唤醒等待线程
		}
    }
}
```

> 王健 - 宇宙大帅哥
> 小高 - 猥琐第一人
> 王健 - 宇宙大帅哥
> 小高 - 猥琐第一人
> 王健 - 宇宙大帅哥
> 小高 - 猥琐第一人
> 王健 - 宇宙大帅哥
>
> ...

![image-20200812095837799](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200812095837799.png)



# 第5章：多线程深入话题

## 优雅的停止线程

![image-20200812100614025](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200812100614025.png)



![image-20200812100644492](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200812100644492.png)

![image-20200812100723010](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200812100723010.png)

![image-20200812100937347](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200812100937347.png)

![image-20200812100950269](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200812100950269.png)



范例：实现线程柔和的停止

```java
public class ThreadDemo {
	public static boolean flag = true;

	public static void main(String[] args) throws Exception{
		//如果不处理，将一直执行
		new Thread( () -> {
			long num = 0;
			while (flag) {
				try{
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + "正在运行、num = " + num++);
			}
		},"执行线程").start();

		Thread.sleep(200);  //运行200ms
		flag = false; //停止线程
	}
}
```

> 执行线程正在运行、num = 0
> 执行线程正在运行、num = 1
> 执行线程正在运行、num = 2
> 执行线程正在运行、num = 3

![image-20200812101646423](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200812101646423.png)



## 守护线程

先假设有一个人并且这个人有一个保镖，那么这个报表一定是在这个人活着时候进行守护，如果这个人已经死了，保镖没用了。所以在多线程里面可以进行守护线程的定义，也就是说如果现在主线程的程序或者其他的线程还在执行的时候，那么守护线程将一直存在，并且运行在后台状态

![image-20200812102228525](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200812102228525.png)



范例：使用守护线程

```java
public class ThreadDemo {
	public static boolean flag = true;

	public static void main(String[] args) throws Exception {
		Thread userThread = new Thread( () -> {
			for (int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread().getName() + "正在运行、i = " + i);
				try{
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		},"用户线程"); //完成核心的业务

		Thread daemonThread = new Thread( () -> {
			for (int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread().getName() + "正在运行、i = " + i);
				try{
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		},"守护线程"); //完成守护业务
		daemonThread.setDaemon(true); //设置为守护线程
		userThread.start();
		daemonThread.start();
	}
}
```

> 守护线程正在运行、i = 0
> 用户线程正在运行、i = 0
> 用户线程正在运行、i = 1
> 守护线程正在运行、i = 1
> 用户线程正在运行、i = 2
> 用户线程正在运行、i = 3
> 守护线程正在运行、i = 2
> 用户线程正在运行、i = 4
> 用户线程正在运行、i = 5
> 守护线程正在运行、i = 3
> 用户线程正在运行、i = 6
> 用户线程正在运行、i = 7
> 守护线程正在运行、i = 4
> 用户线程正在运行、i = 8
> 用户线程正在运行、i = 9
> 守护线程正在运行、i = 5

![image-20200812103420367](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200812103420367.png)

只要当前JVM实例中尚存在任何一个非守护线程没有结束，守护线程就全部工作；只有当最后一个非守护线程结束时，守护线程随着JVM一同结束工作。
Daemon的作用是为其他线程的运行提供便利服务，守护线程最典型的应用就是 GC (垃圾回收器)，它就是一个很称职的守护者。

User和Daemon两者几乎没有区别，唯一的不同之处就在于虚拟机的离开：如果 User Thread已经全部退出运行了，只剩下Daemon Thread存在了，虚拟机也就退出了。 因为没有了被守护者，Daemon也就没有工作可做了，也就没有继续运行程序的必要了。

**这里有几点需要注意：**

> (1) thread.setDaemon(true)必须在thread.start()之前设置，否则会跑出一个IllegalThreadStateException异常。你不能把正在运行的常规线程设置为守护线程。
> (2) 在Daemon线程中产生的新线程也是Daemon的。
> (3) 不要认为所有的应用都可以分配给Daemon来进行服务，比如读写操作或者计算逻辑。

**为什么要使用守护线程**

> 我们知道静态变量是ClassLoader级别的，如果Web应用程序停止，这些静态变量也会从JVM中清除。但是线程则是JVM级别的，如果你在Web 应用中启动一个线程，这个线程的生命周期并不会和Web应用程序保持同步。也就是说，即使你停止了Web应用，这个线程依旧是活跃的。正是因为这个很隐晦 的问题，所以很多有经验的开发者不太赞成在Web应用中私自启动线程。
>
> 如果我们手工使用JDK Timer（Quartz的Scheduler），在Web容器启动时启动Timer，当Web容器关闭时，除非你手工关闭这个Timer，否则Timer中的任务还会继续运行！

**典型案例：**

> Spring为JDK Timer和Quartz Scheduler所提供的TimerFactoryBean和SchedulerFactoryBean能够和Spring容器的生命周期关联，在 Spring容器启动时启动调度器，而在Spring容器关闭时，停止调度器。所以在Spring中通过这两个FactoryBean配置调度器，再从 Spring IoC中获取调度器引用进行任务调度将不会出现这种Web容器关闭而任务依然运行的问题。而如果你在程序中直接使用Timer或Scheduler，如不 进行额外的处理，将会出现这一问题。 



## volatile关键字

在多线程的定义之中，volatile管家你主要是在属性定义上使用的，表示此属性为直接数据操作，而不进行副本的拷贝处理，这样在一些书上就将其错误的理解为同步属性了



旧的，有风险的程序

```java
class MyThread implements Runnable {

    private volatile int ticket = 5;

    @Override
    public void run() {
        while (this.ticket > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out
                .println(Thread.currentThread().getName() + "卖票处理， ticket = " + this.ticket--);
        }
    }
}

public class ThreadDemo {

    public static void main(String[] args) {
        MyThread mt = new MyThread();
        new Thread(mt, "票贩子A").start();
        new Thread(mt, "票贩子B").start();
        new Thread(mt, "票贩子C").start();
    }
}

```

> 票贩子B卖票处理， ticket = 4
> 票贩子A卖票处理， ticket = 5
> 票贩子C卖票处理， ticket = 3
> 票贩子B卖票处理， ticket = 2
> 票贩子C卖票处理， ticket = 1
> 票贩子A卖票处理， ticket = 0
> 票贩子B卖票处理， ticket = -1

定义参数时加volatile，    private volatile int ticket = 5;

问题依然存在，略微减轻

![image-20200812123213870](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200812123213870.png)

![image-20200812123228397](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200812123228397.png)

![image-20200812122333069](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200812122333069.png)



![image-20200812123423214](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200812123423214.png)



# 第6章：多线程综合案例

## 多线程案例分析一：数字加减

设计4个线程对象，两个执行减操作，两个执行加操作

![img](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/2615789-08f16aeac7e0977d.webp)

```java
public class ThreadDemo {
    public static void main(String[] args) {
        Resource res = new Resource();
        SubThread st = new SubThread(res);
        AddThread at = new AddThread(res);
        new Thread(at, "加法线程 - A").start();
        new Thread(at, "加法线程 - B").start();
        new Thread(st, "减法线程 - A").start();
        new Thread(st, "减法线程 - B").start();
    }
}

class AddThread implements Runnable {
    private Resource resource;
    public AddThread(Resource resource) {
        this.resource = resource;
    }
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            try {
                this.resource.add();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class SubThread implements Runnable {
    private Resource resource;
    public SubThread(Resource resource) {
        this.resource = resource;
    }
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            try {
                this.resource.sub();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Resource { //定义一个操作的资源
    private int num = 0; //这个要进行加减操作的数据
    private boolean flag  = true; //加减切换
    //flag = true 进行加法
    //falg = false 进行减法
    public synchronized void add() throws InterruptedException { //进行加法操作
        while (this.flag == false) { //现在需要做减法，加法等待
            super.wait();
        }
        Thread.sleep(100);
        this.num ++ ;
        System.out.println("【加法操作 - " + Thread.currentThread().getName() + "】num = " + this.num);
        this.flag = false;//激发操作完毕，需要执行减法
        super.notifyAll();//唤醒等待线程

    }

    public synchronized void sub() throws InterruptedException { //进行减法操作
        while (this.flag == true) {
            super.wait();
        }
        Thread.sleep(200);
        this.num -- ;
        System.out.println("【减法操作 - " + Thread.currentThread().getName() + "】num = " + this.num);
        this.flag = true;
        super.notifyAll();
    }
}

```

![image-20200821230035067](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200821230035067.png)

> 如果if(this.flag == true) ，会出现-1 0 1之外的值

如果进入wait以后，在notify时随机唤醒了该线程，且此时依然不符合，但已执行过判断，会继续往后执行

如果只有一个加法一个减法 ，交替唤醒则不会





## 多线程案例分析二：电脑生产

![image-20200821230202651](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200821230202651.png)

```java
public class ThreadDemo {

    public static void main(String[] args) {
        Resource res = new Resource();
        new Thread(new Producer(res),"生产者A").start();
        //new Thread(new Producer(res),"生产者B").start();
        new Thread(new Consumer(res),"消费者A").start();
        //new Thread(new Consumer(res),"消费者B").start();

    }
}
class Producer implements Runnable {
    private Resource resource;
    public Producer(Resource resource) {
        this.resource = resource;
    }
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            try{
                this.resource.make();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
class Consumer implements Runnable {
    private Resource resource;
    public Consumer(Resource resource) {
        this.resource = resource;
    }
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            try{
                this.resource.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
class Resource {
    private Computer computer;
    public synchronized void make() throws Exception {
        if(this.computer != null) { //已经生产过了
            super.wait();
        }
        Thread.sleep(10);
        this.computer = new Computer("XXX牌电脑",111.1);
        System.out.println(Thread.currentThread().getName() + "-【生产电脑】" + this.computer);
        super.notify();
    }
    public synchronized void get() throws Exception {
        if(this.computer == null) { //没有生产过
            super.wait();
        }
        Thread.sleep(20);
        System.out.println(Thread.currentThread().getName() + "-【取走电脑】" + this.computer);
        this.computer = null;  //已经取走了
        super.notify();
    }
}

class Computer {
    private static int count = 0;
    private String name;
    private double price;
    public Computer(String name,double price) {
        this.name = name;
        this.price = price;
        count ++ ;
    }
    @Override
    public String toString() {
        return "【第" + count + "台电脑】电脑名字：" + this.name +"、价值：" +this.price;
    }
}
```

> 以上运行正常
>
> 生产者A-【生产电脑】【第1台电脑】电脑名字：XXX牌电脑、价值：111.1
> 消费者A-【取走电脑】【第1台电脑】电脑名字：XXX牌电脑、价值：111.1
> 生产者A-【生产电脑】【第2台电脑】电脑名字：XXX牌电脑、价值：111.1
> 消费者A-【取走电脑】【第2台电脑】电脑名字：XXX牌电脑、价值：111.1
> 生产者A-【生产电脑】【第3台电脑】电脑名字：XXX牌电脑、价值：111.1
> 消费者A-【取走电脑】【第3台电脑】电脑名字：XXX牌电脑、价值：111.1
> 生产者A-【生产电脑】【第4台电脑】电脑名字：XXX牌电脑、价值：111.1
> 消费者A-【取走电脑】【第4台电脑】电脑名字：XXX牌电脑、价值：111.1
> 生产者A-【生产电脑】【第5台电脑】电脑名字：XXX牌电脑、价值：111.1
> 消费者A-【取走电脑】【第5台电脑】电脑名字：XXX牌电脑、价值：111.1
> 生产者A-【生产电脑】【第6台电脑】电脑名字：XXX牌电脑、价值：111.1
> 消费者A-【取走电脑】【第6台电脑】电脑名字：XXX牌电脑、价值：111.1

如果两个生产，两个消费？ 

> 生产者A-【生产电脑】【第1台电脑】电脑名字：XXX牌电脑、价值：111.1
> 消费者B-【取走电脑】【第1台电脑】电脑名字：XXX牌电脑、价值：111.1
> 生产者B-【生产电脑】【第2台电脑】电脑名字：XXX牌电脑、价值：111.1
> 消费者B-【取走电脑】【第2台电脑】电脑名字：XXX牌电脑、价值：111.1
> 消费者A-【取走电脑】null
> 生产者B-【生产电脑】【第3台电脑】电脑名字：XXX牌电脑、价值：111.1
> 消费者B-【取走电脑】【第3台电脑】电脑名字：XXX牌电脑、价值：111.1
> 消费者A-【取走电脑】null
> 生产者B-【生产电脑】【第4台电脑】电脑名字：XXX牌电脑、价值：111.1

出现上一节同样问题，需要改成while

但是改成while后会死锁

> 生产者A-【生产电脑】【第1台电脑】电脑名字：XXX牌电脑、价值：111.1
> 消费者A-【取走电脑】【第1台电脑】电脑名字：XXX牌电脑、价值：111.1
> 生产者B-【生产电脑】【第2台电脑】电脑名字：XXX牌电脑、价值：111.1
> 消费者A-【取走电脑】【第2台电脑】电脑名字：XXX牌电脑、价值：111.1
> 生产者A-【生产电脑】【第3台电脑】电脑名字：XXX牌电脑、价值：111.1

相当于生产以后唤醒了另一个生产线程，此时所有线程都在等待状态

应该改成notifyAll()，唤醒所有线程，检查是否符合条件

```java
public class ThreadDemo {

    public static void main(String[] args) {
        Resource res = new Resource();
        new Thread(new Producer(res),"生产者A").start();
        new Thread(new Producer(res),"生产者B").start();
        new Thread(new Consumer(res),"消费者A").start();
        new Thread(new Consumer(res),"消费者B").start();

    }
}
class Producer implements Runnable {
    private Resource resource;
    public Producer(Resource resource) {
        this.resource = resource;
    }
    @Override
    public void run() {
        for (int i = 0; i < 5000; i++) {
            try{
                this.resource.make();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
class Consumer implements Runnable {
    private Resource resource;
    public Consumer(Resource resource) {
        this.resource = resource;
    }
    @Override
    public void run() {
        for (int i = 0; i < 5000; i++) {
            try{
                this.resource.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
class Resource {
    private Computer computer;
    public synchronized void make() throws Exception {
        while(this.computer != null) { //已经生产过了
            super.wait();
        }
        Thread.sleep(10);
        this.computer = new Computer("XXX牌电脑",111.1);
        System.out.println(Thread.currentThread().getName() + "-【生产电脑】" + this.computer);
        super.notifyAll();
    }
    public synchronized void get() throws Exception {
        while(this.computer == null) { //没有生产过
            super.wait();
        }
        Thread.sleep(20);
        System.out.println(Thread.currentThread().getName() + "-【取走电脑】" + this.computer);
        this.computer = null;  //已经取走了
        super.notifyAll();
    }
}

class Computer {
    private static int count = 0;
    private String name;
    private double price;
    public Computer(String name,double price) {
        this.name = name;
        this.price = price;
        count ++ ;
    }
    @Override
    public String toString() {
        return "【第" + count + "台电脑】电脑名字：" + this.name +"、价值：" +this.price;
    }
}
```



## 多线程案例分析三：竞争抢答

![image-20200826101440581](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200826101440581.png)

```java
public class ThreadDemo {

    public static void main(String[] args) throws Exception {
        MyThread mt = new MyThread();
        FutureTask<String> task = new FutureTask<String>(mt);
        new Thread(task,"竞赛者A").start();
        new Thread(task,"竞赛者B").start();
        new Thread(task,"竞赛者C").start();
        System.out.println(task.get());
    }
}

class MyThread implements Callable<String> {
    private boolean flag = false; //抢答处理
    @Override
    public String call() throws Exception {
        synchronized (this) { //数据同步
            if(this.flag == false ) { //抢答成功
                this.flag = true;
                return Thread.currentThread().getName() +"抢答成功！";
            } else {
                return Thread.currentThread().getName() +"抢答失败！";

            }
        }
    }
}
```

循环执行发现几乎全是A，因为先start的

```java
public class ThreadDemo {

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 1000 ; i++) {
            MyThread mt = new MyThread();
            FutureTask<String> task = new FutureTask<String>(mt);
            new Thread(task,"竞赛者A").start();
            new Thread(task,"竞赛者B").start();
            new Thread(task,"竞赛者C").start();
            System.out.println(task.get());
        }
    }
}

class MyThread implements Callable<String> {
    private boolean flag = false; //抢答处理
    @Override
    public String call() throws Exception {
        Thread.sleep(100);
        synchronized (this) { //数据同步
            if(this.flag == false ) { //抢答成功
                this.flag = true;
                return Thread.currentThread().getName() +"抢答成功！";
            } else {
                return Thread.currentThread().getName() +"抢答失败！";

            }
        }
    }
}
```

打印三个task

```java
public class ThreadDemo {
    public static void main(String[] args) throws Exception {
        MyThread mt = new MyThread();
        FutureTask<String> taskA = new FutureTask<String>(mt);
        FutureTask<String> taskB = new FutureTask<String>(mt);
        FutureTask<String> taskC = new FutureTask<String>(mt);

        new Thread(taskA,"竞赛者A").start();
        new Thread(taskB,"竞赛者B").start();
        new Thread(taskC,"竞赛者C").start();
        System.out.println(taskA.get());
        System.out.println(taskB.get());
        System.out.println(taskC.get());
    }
}

class MyThread implements Callable<String> {
    private boolean flag = false; //抢答处理
    @Override
    public String call() throws Exception {
        synchronized (this) { //数据同步
            if(this.flag == false ) { //抢答成功
                this.flag = true;
                return Thread.currentThread().getName() +"抢答成功！";
            } else {
                return Thread.currentThread().getName() +"抢答失败！";

            }
        }
    }
}
```



# 第7章：Java常用类库

## StringBuffer类

![image-20200826102959137](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200826102959137.png)

范例：观察String与StringBuffer类的对比

```java
public class JavaApiDemo {
    public static void main(String[] args) {
        String str = "Hello ";
        change(str);
        System.out.println(str);
    }
    public static void change(String temp) { 
        temp += "World !"; //内容未改变
    }
}
```

> Hello 

StringBuffer 线程安全的？？

```java
public class JavaApiDemo {
    public static void main(String[] args) {
        //StringBuffer sb = new StringBuffer("Hello ");
        StringBuffer sb = new StringBuffer();
        sb.append("Hello ");
        change(sb);
        System.out.println(sb);
    }
    public static void change(StringBuffer temp) {
        temp.append("World ！"); //内容改变
    }
}
```

这个时候的strB对象的内容并不算是改变，或者更加严格的意义上来讲，对于现在的strB当程序编译之后会变成如下的形式

> String strB = "www." + "faw" +"s"

> StringBuffer buf = new StringBuffer();
>
> buf.append("www").append("faw").append(".com")

所有的"+"在编译之后都变为了SrinagBuffer中的append()方法，并且在程序之中StringBuffer与String类对象之间本来就可以直接互相转换

![image-20200826105714655](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200826105714655.png)



![image-20200826111910467](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200826111910467.png)

```java
public class JavaApiDemo {
    public static void main(String[] args) {
        StringBuffer buf = new StringBuffer();
        buf.append(".com").insert(0,"www.").insert(4,"faw");
        System.out.println(buf);
    }
}
```

> www.faw.com

![image-20200826111853519](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200826111853519.png)

```java
public class JavaApiDemo {
    public static void main(String[] args) {
        StringBuffer buf = new StringBuffer();
        buf.append("Hello World !").delete(6,12).insert(6, "VW");
        System.out.println(buf);
    }
}
```

> Hello VW!

![image-20200826112646445](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200826112646445.png)

```java
public class JavaApiDemo {
    public static void main(String[] args) {
        StringBuffer buf = new StringBuffer();
        buf.append("Hello World !");
        System.out.println(buf.reverse());
    }
}
```

> ! dlroW olleH

![image-20200826112819962](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200826112819962.png)



## CharSequence接口

![image-20200826113930937](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200826113930937.png)

![image-20200826113945741](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200826113945741.png)

attend insert都可以传参CharSequence

```java
public class JavaApiDemo {
    public static void main(String[] args) {
        CharSequence str = "www.faw.com";  //子类实例向父接口转型
    }
}
```

jdk1.4抽象出的CharSequence接口

![image-20200826114624182](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200826114624182.png)

范例：字符串截取

```java
public class JavaApiDemo {
    public static void main(String[] args) {
        CharSequence str = "www.faw.com";
        CharSequence sub = str.subSequence(4,7);
        System.out.println(sub);
    }
}
```

> faw

以后只要看见了CharSequence描述的就是一个字符串



## AutoCloseable接口

主要是用于日后进行资源开发的处理上，以实现资源的自动关闭（释放资源），例如：在以后进行文件、网络、数据库开发的过程志宏由于服务器的资源优先，所以使用之后一定要贯标资源，这样才可以被更多的使用者所使用。

下面为了更好的说明资源问题，将通过一个消息的发送处理来完成。

范例：手动实现资源处理

```java
public class JavaApiDemo{

    public static void main(String[] args) {
        NetMessage nm = new NetMessage("www.faw.com");  //定义要发送的处理
        nm.send();    //消息发送
        nm.close();  //关闭连接
    }
}
interface IMessage {
    public void send(); //消息发送
}
class NetMessage implements IMessage { //实现消息的处理机制
    private String msg;
    public NetMessage(String msg) {
        this.msg = msg;
    }
    public boolean open() { //获取资源连接处
        System.out.println("【OPEN】获取消息发送连接资源");
        return true;
    }
    @Override
    public void send() {
        if(this.open()) {
            System.out.println("【*** 发送消息 ***】" + this.msg);
        }
    }
    public void close() {
        System.out.println("【CLOSE】关闭消息发送通道");
    }
}
```

> 【OPEN】获取消息发送连接资源
> 【******* 发送消息 ***】www.faw.com
> 【CLOSE】关闭消息发送通道

![image-20200826134221634](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200826134221634.png)

抛的各种关闭的异常

```java
public class JavaApiDemo{
    public static void main(String[] args) {
        NetMessage nm = new NetMessage("www.faw.com");  //定义要发送的处理
        nm.send();    //消息发送
    }
}
interface IMessage {
    public void send(); //消息发送
}
class NetMessage implements IMessage,AutoCloseable { //实现消息的处理机制
}
```

未捕获不会关闭

范例：实现自动关闭

```java
public class JavaApiDemo{
    public static void main(String[] args) {
        try(IMessage nm = new NetMessage("www.faw.com")){
            nm.send();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
interface IMessage extends AutoCloseable{
    public void send(); //消息发送
}
class NetMessage implements IMessage { //实现消息的处理机制
    private String msg;
    public NetMessage(String msg) {
        this.msg = msg;
    }
    public boolean open() { //获取资源连接处
        System.out.println("【OPEN】获取消息发送连接资源");
        return true;
    }
    @Override
    public void send() {
        if(this.open()) {
            System.out.println("【*** 发送消息 ***】" + this.msg);
        }
    }
    @Override
    public void close() {
        System.out.println("【CLOSE】关闭消息发送通道");
    }
}
```

在以后的章节之中会接触到资源的关闭问题，往往都会见到AutoCloseable接口的使用

## Runtime类

Runtime描述的是运行时的状态，也就是说整个的JVM之中，Runtime类是唯一一个与JVM运行状态有关的类，并且都会默认提供有一个该类的实例化对象。

![image-20200826135353737](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200826135353737.png)

![image-20200826135409935](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200826135409935.png)

范例：获取Runtime类对象

```java
public class JavaApiDemo{
    public static void main(String[]args){
        Runtime run = Runtime.getRuntime(); //获取实例化对象
        System.out.println(run.availableProcessors());  //获取内核数
    }
}
```

![image-20200826140221861](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200826140221861.png)

用于对内存调优的

范例：观察内存状态

```java
public class JavaApiDemo{
    public static void main(String[] args) {
        Runtime run = Runtime.getRuntime();
        System.out.println("【1】MAX_MEMORY：   " + run.maxMemory());
        System.out.println("【1】TOTAL_MEMORY： " + run.totalMemory());
        System.out.println("【1】FREE_MEMORY：  " + run.freeMemory());
        String str = "";
        for (int i = 0; i < 30000; i++) {
            str += i;     //产生大量垃圾空间
        }
        System.out.println("【2】MAX_MEMORY：   " + run.maxMemory());
        System.out.println("【2】TOTAL_MEMORY： " + run.totalMemory());
        System.out.println("【2】FREE_MEMORY：  " + run.freeMemory());
        run.gc();
        System.out.println("【3】MAX_MEMORY：   " + run.maxMemory());
        System.out.println("【3】TOTAL_MEMORY： " + run.totalMemory());
        System.out.println("【3】FREE_MEMORY：  " + run.freeMemory());
    }
}
```

> 【1】MAX_MEMORY：    8432648192
> 【1】TOTAL_MEMORY： 528482304
> 【1】FREE_MEMORY：    524873064
> 【2】MAX_MEMORY：     8432648192
> 【2】TOTAL_MEMORY：  635437056
> 【2】FREE_MEMORY：     277809920
> 【3】MAX_MEMORY：     8432648192
> 【3】TOTAL_MEMORY：  20971520
> 【3】FREE_MEMORY：    19468944

以上显示的字节

1： 8G  MAX

2： 0.5G TOTAL

JDK1.9后开始改total，之前不会变的

![image-20200826141802120](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200826141802120.png)



## System类

System类是一直陪伴着我们学习的程序类，之前使用的系统输出采用的就是System类中的方法，而后在System类里面也定义有一些其他的处理方法：

![image-20200826142012801](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200826142012801.png)

jdk1.0开始有的

范例：操作耗时的统计

```java
public class JavaApiDemo{
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        String str = "";
        for (int i = 0; i < 30000; i++) {
            str += i;     //产生大量垃圾空间
        }
        long end = System.currentTimeMillis();
        System.out.println("操作耗时：" + (end - start));
    }
}
```

> 600

![image-20200826142449892](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200826142449892.png)

> ```java
> public static void gc() {
>     Runtime.getRuntime().gc();
> }
> ```



## Cleaner类

Cleaner是在JDK1.9之后提供的一个对象清理操作，其主要的功能是进行finalize()方法的替代。在C++语言里面有两种特殊的函数：构造函数、析构函数（对象手工回收），在Java里面所有的垃圾空间都是通过GC自动回收的，所以很多情况下是不需要使用这类析构函数的，也正是因为如此，所以java并没有提供这方面的支持。

![image-20200826142907899](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200826142907899.png)

出现了异常也不影响回收

范例：观察传统回收

```java
class Member {
    public Member() {
        System.out.println("【构造】在一个雷电交加的日子里面，林XX诞生了");
    }
    @Override
    protected void finalize() throws Throwable {
        System.out.println("【回收】最终你一定要死的。");
        throw new Exception("我还要再活500年。。。");
    }
}

public class JavaApiDemo{
    public static void main(String[] args) {
        Member mem = new Member();  //诞生
        mem = null; //成为垃圾
        Runtime.getRuntime().gc();
        System.out.println("太阳照样升起，地球照样转动。");
    }
}
```

> 【构造】在一个雷电交加的日子里面，林XX诞生了
> 【回收】最终你一定要死的。
> 太阳照样升起，地球照样转动。

![image-20200826143842261](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200826143842261.png)

![image-20200826144021402](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200826144021402.png)



```java
class Member implements Runnable {

    public Member() {
        System.out.println("【构造】在一个雷电交加的日子里面，林XX诞生了");
    }

    @Override
    public void run() {
        System.out.println("【回收】最终你一定要死的。");
    }
}

class MemberCleaning implements AutoCloseable { //实现清除的处理

    private static final Cleaner cleaner = Cleaner.create();
    private Member member;
    private Cleaner.Cleanable cleanable;

    public MemberCleaning() {
        this.member = new Member(); //创建新对象
        this.cleanable = this.cleaner.register(this, this.member); //注册使用的对象
    }

    @Override
    public void close() throws Exception {
        this.cleanable.clean();  //启动多线程清除
    }
}

public class JavaApiDemo {
    public static void main(String[] args) {
        try (MemberCleaning mc = new MemberCleaning()) {
            //中间可以执行一些相关的代码
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

> 【构造】在一个雷电交加的日子里面，林XX诞生了
> 【回收】最终你一定要死的。

![image-20200826145253562](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200826145253562.png)

![image-20200826145516324](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200826145516324.png)



## 对象克隆

所谓的对象克隆指的就是对象的赋值，而且属于全新的赋值。即：使用已有对象内容创建一个新的对象，如果要想进行对象克隆，需要使用到Object类中提供的clone方法：

> protected Object clone() throw CloneNotSupportedException;

![image-20200826145725758](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200826145725758.png)

范例：实现对象克隆

```java
public class JavaApiDemo {
    public static void main(String[] args) throws Exception{
        Memeber memeberA = new Memeber("林强",30);
        Memeber memeberB = (Memeber) memeberA.clone();
        System.out.println(memeberA);
        System.out.println(memeberB);
    }
}
class Memeber implements Cloneable{
    private String name;
    private int age;
    public Memeber(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString() {
        return "【" + super.toString() + "】name = " + this.name + "、age = " + this.age;
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();  //调用父类中提供的clone方法
    }
}
```

> 【cn.mldn.lesson.Memeber@6d03e736】name = 林强、age = 30
> 【cn.mldn.lesson.Memeber@49097b5d】name = 林强、age = 30

如果在开发之中不是非常特别的需求下，很少会出现有对象克隆的需求。

Cloneable没有方法，是一种能力的标识



# 第8章：数字操作类

程序就是一个数学的处理过程，所以在Java语言本身也提供有相应的数字处理的类库支持。

## Math类

![image-20200826164313516](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200826164313516.png)

![image-20200826164235322](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200826164235322.png)

```java
public class JavaApiDemo {
    public static void main(String[] args) {
        System.out.println(Math.abs(-10.1));
        System.out.println(Math.max(10.2, 20.3));
        System.out.println(Math.log(5));
        System.out.println(Math.round(15.1));
        System.out.println(Math.round(-15.5));
        System.out.println(Math.round(-15.51));
        System.out.println(Math.pow(10.2, 20.2));
    }
}
```

> 10.1
> 20.3
> 1.6094379124341003
> 15
> -15
> -16
> 2.364413713591828E20

![image-20200826165336909](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200826165336909.png)

范例：自定义四舍五入功能

```java
public class JavaApiDemo {
    public static void main(String[] args) {
        System.out.println(MathUtil.round(19.86273, 2));
    }
}
class MathUtil {
    private MathUtil() { }
    /**
     * 实现数据的四舍五入操作
     *
     * @param num   要进行四舍五入的数字
     * @param scale 四舍五入保留小数位数
     * @return 四舍五入处理后的结果
     */
    public static double round(double num, int scale) {
        return Math.round(num * Math.pow(10, scale)) / Math.pow(10, scale);
    }
}
```

> 19.86

Math类里面提供的基本上都是基础的数学公式，需要的时候要自己重新整合。



## Random类

![image-20200826170015517](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200826170015517.png)

范例：产生随机数

```java
public class JavaApiDemo {
    public static void main(String[] args) {
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.print(rand.nextInt(100) + "、");
        }
    }
}
```

> 30、69、69、34、35、59、41、55、47、0、

范例：随机生成36选7的彩票

这里数字肯定不能有0，不能够重复

```java
public class JavaApiDemo{
    public static void main(String[] args) {
        int data [] = new int [7];  //开辟七个中奖号的空间
        Random rand = new Random();
        int foot = 0; //操作data脚标
        while(foot < 7) { //选择7个数字
            int num = rand.nextInt(37);  //生成一个数字
            if(isUse(num,data)) { //该数字现在可以使用
                data[foot ++] = num; //保存数据
            }
        }
        //Arrays.sort(data);
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + "、");
        }
    }

    public static boolean isUse(int num, int temp[]) {
        if(num == 0) {
            return false;
        }
        for (int i = 0; i < temp.length; i++) {
            if(num == temp[i]) {
                return false;
            }
        }
        return true;
    }
}
```

> 18、14、1、35、33、7、28、

可用sort排序



## 大数字处理类

![image-20200826173024859](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200826173024859.png)

![image-20200826173051833](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200826173051833.png)

![image-20200826173158874](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200826173158874.png)

![image-20200826173227022](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200826173227022.png)

![image-20200826173114187](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200826173114187.png)

可以实现拆箱处理

BigInteger不能用int构造。BigDecimal可以接收double\BigInteger

范例：shi先四则运算

```java
public class JavaApiDemo {
    public static void main(String[] args) {
        BigInteger bigA = new BigInteger("234234234234234234234");
        BigInteger bigB = new BigInteger("234234234");
        System.out.println("加法操作：" + bigA.add(bigB));
        System.out.println("减法操作：" + bigB.subtract(bigA));
        System.out.println("乘法操作：" + bigA.multiply(bigB));
        System.out.println("除法操作：" + bigA.divide(bigB));
    }
}
```

需要注意的是，虽然提供有大数字操作类，但是整体之中还是需要考虑到一个性能问题。

范例：观察性能问题

```java
public class JavaApiDemo {
    public static void main(String[] args) throws Exception{
        BigInteger bigA = new BigInteger("234234234234234234");
        System.out.println(bigA.pow(Integer.MAX_VALUE));
    }
}
```

> Exception in thread "main" java.lang.ArithmeticException: BigInteger would overflow supported range
> 	at java.base/java.math.BigInteger.reportOverflow(BigInteger.java:1151)
> 	at java.base/java.math.BigInteger.pow(BigInteger.java:2482)
> 	at cn.mldn.lesson.JavaApiDemo.main(JavaApiDemo.java:376)

![image-20200829135247360](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200829135247360.png)

范例：求余除法

```java
public class JavaApiDemo {
    public static void main(String[] args) {
        BigInteger bigA = new BigInteger("234234234234234234234");
        BigInteger bigB = new BigInteger("234234234");
        BigInteger result [] = bigA.divideAndRemainder(bigB);
        System.out.println("商：" + result[0] + "、余数：" + result[1]);
    }
}
```

> 商：1000000001000、余数：234

![image-20200829135609697](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200829135609697.png)



范例：使用BigDecimal计算

```java
public class JavaApiDemo {
    public static void main(String[] args) {
        BigDecimal bigA = new BigDecimal("3289757092842");
        BigDecimal bigB = new BigDecimal("1892039");
        System.out.println("加法操作：" + bigA.add(bigB));
        BigDecimal result [] = bigA.divideAndRemainder(bigB);
        System.out.println("商：" + result[0] + "、余数：" + result[1]);
    }
}
```

> 加法操作：3289758984881
> 商：1738736、余数：770138

但是在使用BigDeimal时候有一个数据进位的问题，在这个类里面定义有如下的除法计算

* 除法计算： public BigDecimal divide(BigDecimal divisor,it scale , RoundingMode roundingMode);

范例：使用BIgDecimal实现四舍五入处理

![image-20200829140219152](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200829140219152.png)

![image-20200829140233687](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200829140233687.png)

![image-20200829140303345](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200829140303345.png)



# 第9章：日期操作类

从整体的java来讲一直在强调简单java类的主要设计来自于数据表的结构，那么在数据表的结构里面常用的类别：数字、字符串、日期，所以现在的程序之中只差日期了

## Date日期类

![image-20200829143143212](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200829143143212.png)

```java
public class JavaApiDemo {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);
    }
}
```

>  Sat Aug 29 14:33:10 CST 2020

![image-20200829143402927](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200829143402927.png)

![image-20200829143418126](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200829143418126.png)

![image-20200829143519370](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200829143519370.png)

```java
public class JavaApiDemo {
    public static void main(String[] args) {
        Date date = new Date();
        long current = date.getTime();
        current += 864000000;  //10天的毫秒数
        System.out.println(new Date(current));
    }
}
```

> Tue Sep 08 14:37:52 CST 2020

long之中可以保存毫秒的数据级，方便程序处理



## 日期格式化

素日Date可以获取当前的日期时间，但是默认情况下Date类输出的日期时间结构并不能呗国人所习惯，那么就需要对显示的格式进行格式化的处理，为了可以格式化日期，在java.text包中提供有SimpleDateFormat程序类，该类是DateFormat的子类

![image-20200829144202656](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200829144202656.png)

DateFormat是抽象类

![image-20200829145105623](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200829145105623.png)

在该类提供有如下方法：

![image-20200829144053734](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200829144053734.png)

![image-20200829144457978](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200829144457978.png)

![image-20200829144522481](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200829144522481.png)

```java
public class JavaApiDemo {
    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        String str = sdf.format(date);
        System.out.println(str);
    }
}
```

> 2020-08-29 14:47:18.645

![image-20200829144752550](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200829144752550.png)

```java
public class JavaApiDemo {
    public static void main(String[] args) throws ParseException {
        String birthday = "2011-11-11 11:11:11.111";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date date = sdf.parse(birthday);
        System.out.println(date);
    }
}
```

> Fri Nov 11 11:11:11 CST 2011

![image-20200829145018943](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200829145018943.png)

![image-20200829145231272](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200829145231272.png)



# 第10章：正则表达式

通过之前一系列的分析可以发现，String是一个非常万能的类型，因为String不仅仅可以支持有各种字符串的处理操作，也支持有向各个数据的转换功能，所以在项目的开发之中，只要是用户输入的信息基本上都可以用String标识，于是在向其他数据类型转换的时候，为了保证转换的正确性，往往需要对其进行一些复杂的验证处理，那么这种情况下如果只是单纯的依靠String类中的方法是非常麻烦的。

## 认识正则表达式

现在假设有一个字符串要求判断字符串是否由数字所组成，如果是则变为数字进行乘法计算。

![image-20200829145613759](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200829145613759.png)

![image-20200829150121569](../image-20200829150121569.png)

```java
public class JavaApiDemo {
    public static void main(String[] args) {
        String str = "12a3";
        if(str.matches("\\d+")) {
            int num = Integer.parseInt(str);
            System.out.println(num * 2);
        }
    }
}
```

正则表达式最早是从Perl语言里面发展而来的，而后在JDK1.4一千如果需要使用到正则表达式的相关定义，则需要单独引入其他的*.jar文件。单从JDK1.4之后，正则已经默认被JDK所支持，并且提供有java.until.regex开发包，同时针对于String类也进行一些修改，使其可以由方法直接支持正则处理。

使用正则最大的特点在于方便进行验证处理，以及方便进行复杂字符串的修改处理。

复杂用法比如代码生成器。



## 常用正则标记（背）

![image-20200829150849530](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200829150849530.png)

![image-20200829150904576](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200829150904576.png)

![image-20200829151036168](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200829151036168.png)

![image-20200829151134283](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200829151134283.png)



![image-20200829151325306](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200829151325306.png)

![image-20200829151433926](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200829151433926.png)

![image-20200829151658568](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200829151658568.png)

匹配1位以上

![image-20200829152021377](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200829152021377.png)

![image-20200829152034065](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200829152034065.png)



![image-20200829152140506](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200829152140506.png)





## String类对正则的支持

在进行正则表达式大部分处理情况下，都会基于String类来完成，并且在String类里面提供有如下与正则有关的操作方法。

![image-20200829154711938](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200829154711938.png)



范例：实现字符串替换（删除掉非字母与数字）

```java
public class JavaApiDemo {
    public static void main(String[] args) {
        String str = "LILI*)JDN)IS*21&*(CX#$%^&*A124PSPL#@IJS";
        String regex = "[^a-zA-Z0-9]+";    //正则表达式
        System.out.println(str.replaceAll(regex,""));
    }
}
```

范例：实现字符串的拆分

```java
public class JavaApiDemo {
    public static void main(String[] args) {
        String str = "a1b22c333d4444e55555f666666g";
        String regex = "\\d";    //正则表达式
        String[] result = str.split(regex);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + "、");
        }
    }
}
```

> a、b、、c、、、d、、、、e、、、、、f、、、、、、g、

如果用\\\d+

> a、b、c、d、e、f、g、

![image-20200902173326536](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200902173326536.png)

错误示范

```java
public class JavaApiDemo {
    public static void main(String[] args) {
        String str = "100.32"; //要判断的数据
        String regex = "\\d+\\.\\d+";    //正则表达式
        System.out.println(str.matches(regex));
    }
}
```

> true

100.  应该错误

> false

100    应该正确

> false

```java
public class JavaApiDemo {
    public static void main(String[] args) {
        String str = "100.32"; //要判断的数据
        String regex = "\\d+(\\.\\d+)?";    //正则表达式
        System.out.println(str.matches(regex));
        System.out.println("100".matches(regex));
        System.out.println("100.".matches(regex));
    }
}
```

![image-20200902173755883](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200902173755883.png)

```java
public class JavaApiDemo {
    public static void main(String[] args) throws ParseException {
        String str = "1999-12-31"; //要判断的数据
        String regex = "\\d{4}-\\d{2}-\\d{2}";    //正则表达式
        if(str.matches(regex)) {
            System.out.println(new SimpleDateFormat("yyyy-MM-dd").parse(str));
            System.out.println(new SimpleDateFormat("yyyy-MM-dd").parse("2222-22-22"));
        }
    }
}
```

> Fri Dec 31 00:00:00 CST 1999
> Wed Oct 22 00:00:00 CST 2223

![image-20200902174203521](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200902174203521.png)

```java
public class JavaApiDemo {
    public static void main(String[] args) throws ParseException {
        String str = "(010)-55535397"; //要判断的数据
        String regex = "((\\d{3,4})|(\\(\\d{3,4}\\)-))?\\d{7,8}";    //正则表达式
        System.out.println(str.matches(regex));
    }
}
```

010 或(010)- 或无

![image-20200902174928002](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200902174928002.png)



```java
public class JavaApiDemo {
    public static void main(String[] args) throws ParseException {
        String str = "xxx123@faw.com"; //要判断的数据
        String regex = "[a-zA-Z0-9]\\w+@\\w+\\.(cn|com|com.cn|gov)";    //正则表达式
        System.out.println(str.matches(regex));
    }
}
```

> true



## java.til.regex开发包

虽然再大部分的情况下都可以利用String类实现正则的曹祖，但是也有一些情况下需要使用到java.util.regex开发包中提供的正则处理类，在这个包中一共定义两个类：Pattern（正则表达式编译），Matcher（匹配）

![image-20200902175631338](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200902175631338.png)

```java
public class JavaApiDemo {
    public static void main(String[] args) throws ParseException {
        String str = "LILI*)JDN)IS*21&*(CX#$%^&*A124PSPL#@IJS"; //要判断的数据
        String regex = "[^a-zA-z]+";    //正则表达式
        Pattern pat = Pattern.compile(regex);  //编译正则表达式
        String[] result = pat.split(str);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + "、");
        }
    }
}
```

> LILI、JDN、IS、CX、^、A、PSPL、IJS、

???怎么把^去除掉

![image-20200902180216376](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200902180216376.png)

范例：字符串匹配

```java
public class JavaApiDemo {
    public static void main(String[] args) throws ParseException {
        String str = "101"; //要判断的数据
        String regex = "\\d+";    //正则表达式
        Pattern pat = Pattern.compile(regex);  //编译正则表达式
        Matcher mat = pat.matcher(str);
        System.out.println(mat.matches());
    }
}
```

范例：字符串替换

![image-20200902180535534](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200902180535534.png)

![image-20200902180550544](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200902180550544.png)

```java
public class JavaApiDemo {
    public static void main(String[] args) throws ParseException {
        //要求取出“#{内容}"标记中的所有内容
        String str = "INSERT INTO dept(deptno,dname) VALUES (#{deptno},#{dname})"; //要判断的数据
        String regex = "#\\{\\w+\\}";    //正则表达式
        Pattern pat = Pattern.compile(regex);  //编译正则表达式
        Matcher mat = pat.matcher(str);
        while(mat.find()) { //是否有 匹配成功的内容
            System.out.println(mat.group(0).replaceAll("#|\\{|\\}",""));
        }
    }
}
```

> deptno
> dname

java.util.regex开发包，如果不是进行一些更为复杂的正则处理是很难使用到的，而String类所提供的功能只适合于正则的基本操作。









# 第11章：





# 第12章：开发支持类库

## UUID类

UUIID是一种生成无重复字符串的一种程序类，这种程序类的主要功能是根据时间戳实现一个自动的无重复的字符串定义。

！！不是绝对的无重复，有极小的概率产生重复，曾经Intel因连续发生重复差点破产

![image-20200902183152966](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200902183152966.png)

![image-20200902183254557](https://github.com/q199212140/JavaLearning/blob/master/notebook/Section3/image-20200902183254557.png)

```java
public class JavaApiDemo {
    public static void main(String[] args) throws ParseException {
        UUID uid = UUID.randomUUID();
        System.out.println(uid.toString());
    }
}
```

> fdc061ae-fb06-4580-baf7-256df324a595

在对一些文件进行自动命名处理的情况下，UUID类型非常好用。





