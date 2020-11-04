package com.sunil.sun.lesson;

//class MyThread implements Runnable { //线程主体类
//	private String title;
//	public MyThread(String title) {
//		this.title = title;
//	}
//
//	@Override
//	public void run() { //线程主体方法
//		for(int i = 0; i < 10; i++) {
//			System.out.println(this.title + "运行：x = " + i);
//		}
//	}
//}

//class MyThread implements Runnable { //线程主体类
//	private String title;
//	public MyThread(String title) {
//		this.title = title;
//	}
//
//	@Override
//	public void run() { //线程主体方法
//		for(int i = 0; i < 10; i++) {
//			System.out.println(this.title + "运行：x = " + i);
//		}
//	}
//}

//class MyThread implements Runnable { //线程主体类
//	private int ticket = 5;
//
//	@Override
//	public void run() {
//		for(int i = 0; i < 100; i++) {
//			if(this.ticket > 0) {
//
//				System.out.println("卖票.ticket = " + this.ticket--);
//			}
//		}
//	}
//}

//public class ThreadDemo {
//	public static void main(String[] args) {
//		new MyThread("线程A").start();
//		new MyThread("线程B").start();
//		new MyThread("线程C").start();

//		MyThread mt = new MyThread("线程A");
//		mt.start();
//		mt.start();

//		Thread threadA = new Thread(new MyThread2(("线程对象A")));
//		Thread threadB = new Thread(new MyThread2(("线程对象B")));
//		Thread threadC = new Thread(new MyThread2(("线程对象C")));
//		threadA.start(); //启动多线程
//		threadB.start(); //启动多线程
//		threadC.start(); //启动多线程

//		for (int i = 0; i < 3; i++) {
//			String title = "线程对象-" + i ;
//			Runnable run = () -> {
//				for (int j = 0; j < 10; j++) {
//					System.out.println(title + "运行，y = " + j);
//				}
//			};
//			new Thread(run).start();
//		}
//		MyThread mt = new MyThread();
//		new Thread(mt).start();  //第一个线程启动
//		new Thread(mt).start();  //第二个线程启动
//		new Thread(mt).start();  //第三个线程启动
//	}
//}

///**
// 1.6 Callable
// */
//import java.util.concurrent.Callable;
//import java.util.concurrent.ExecutionException;
//import java.util.concurrent.FutureTask;
//
//class MyThread implements Callable<String> {
//
//	@Override
//	public String call() throws Exception {
//		for (int i = 0; i < 10; i++) {
//			System.out.println("********* 线程执行，i= " + i);
//		}
//		return "线程执行完毕";
//	}
//}
//
//public class ThreadDemo {
//
//	public static void main(String[] args) throws ExecutionException, InterruptedException {
//		FutureTask<String> task = new FutureTask<>(new MyThread());
//		new Thread(task).start();
//		System.out.println("【线程返回数据：】" + task.get());
//	}
//}

/**
 * 2.8 线程命名
 */
//class MyThread implements Runnable {
//	@Override
//	public void run() {
//		System.out.println(Thread.currentThread().getName());
//	}
//}

//public class ThreadDemo {
//	public static void main(String[] args) {
//		MyThread mt = new MyThread();
//		new Thread(mt,"线程A").start();//设置线程名字
//		new Thread(mt).start();//没设置线程名字
//		new Thread(mt).start();//没设置线程名字
//		new Thread(mt).start();//没设置线程名字
//		new Thread(mt).start();//没设置线程名字
//		new Thread(mt,"线程B").start();//设置线程名字
//	}
//}

//public class ThreadDemo {
//	public static void main(String[] args) {
//		MyThread mt = new MyThread();
//		new Thread(mt,"线程对象").start(); //设置线程
//		mt.run();
//	}
//}

////子线程
//public class ThreadDemo {
//	public static void main(String[] args) throws InterruptedException {
//		System.out.println("1.执行操作任务一。");
//		int temp = 0;
//		for (int i = 0; i < Integer.MAX_VALUE; i++) {
//			temp += i;
//			Thread.sleep(1);
//		}
//		System.out.println("2.执行操作任务二。");
//		System.out.println("......");
//		System.out.println("n.执行操作任务N。");
//
//	}
//}

//public class ThreadDemo {
//	public static void main(String[] args) {
//		System.out.println("1.执行操作任务一。");
//		new Thread( () -> {//子线程处理业务
//			int temp = 0;
//			for (int i = 0; i < Integer.MAX_VALUE; i++) {
//				temp += i;
//			}
//			System.out.println("1.操作任务一完成。");
//		}).start();
//		System.out.println("2.执行操作任务二。");
//		System.out.println("2.操作任务二完成。");
//		System.out.println("n.执行操作任务N。");
//		System.out.println("n.操作任务N完成。");
//	}
//}

/**
 * 2.9 线程休眠
 */
//public class ThreadDemo {
//	public static void main(String[] args) {
//		new Thread( ()-> {
//			for (int i = 0; i < 10; i++) {
//				System.out.println(Thread.currentThread().getName() + "、i = " + i);
//				try {
//					Thread.sleep(1000); //暂缓执行
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//		},"线程对象").start();
//	}
//}

//public class ThreadDemo {
//    public static void main(String[] args) {
//        for (int num = 0; num < 5; num++) {
//			int finalNum = num;
//			new Thread(() -> {
//                for (int i = 0; i < 10; i++) {
//                    System.out.println(Thread.currentThread().getName() + "、i = " + i);
//                    try {
//                        Thread.sleep(0, finalNum); //暂缓执行
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }, "线程对象"+num).start();
//        }
//    }
//}

///*
//2.10 线程中断
// */
//public class ThreadDemo {
//	public static void main(String[] args) throws Exception {
//		Thread td = new Thread( () -> {
//			System.out.println("---需要睡觉补充体力");
//			try {
//				Thread.sleep(10000); //预计休眠10秒
//				System.out.println("睡足了，又可以出去祸害别人---");
//			} catch (InterruptedException e) {
//				System.out.println("敢打扰老子睡觉");
//			}
//		});
//		td.start(); //开始睡
//		Thread.sleep(1000);
//		if(!td.isInterrupted()) {
//			System.out.println("偷偷打扰你的睡眠");
//			//td.interrupt();
//		}
//	}
//}

/*
2.11 线程强制执行
 */
//public class ThreadDemo {
//	public static void main(String[] args) throws Exception{
//		Thread thread = new Thread( () -> {
//			for (int i = 0; i < 100; i++) {
//				System.out.println(Thread.currentThread().getName() + "执行 i = " + i);
//				try {
//					Thread.sleep(100);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//		},"玩耍的线程");
//		thread.start();
//		for (int i = 0; i < 100; i++) {
//			System.out.println("【霸道的main线程】number = " + i);
//			Thread.sleep(100);
//		}
//	}
//}

//public class ThreadDemo {
//	public static void main(String[] args) throws Exception{
//		Thread mainThread = Thread.currentThread(); //获得主线程
//		Thread thread = new Thread( () -> {
//			for (int i = 0; i < 100; i++) {
//				if(i == 3) { //现在霸道的线程来了
//					try {
//						mainThread.join();//霸道的线程先执行
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
//
//				try{
//					Thread.sleep(100);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//				System.out.println(Thread.currentThread().getName() + "执行 i = " + i);
//			}
//		},"玩耍的线程");
//		thread.start();
//		for (int i = 0; i < 100; i++) {
//			Thread.sleep(100);
//			System.out.println("【霸道的main线程】number = " + i);
//		}
//	}
//}

/*
3.12 线程礼让
 */
//public class ThreadDemo {
//	public static void main(String[] args) throws Exception {
//		Thread mainThread = Thread.currentThread(); //获得主线程
//		Thread thread = new Thread(() -> {
//			for (int i = 0; i < 100; i++) {
//				if (i % 3 == 0) {
//					Thread.yield(); //线程礼让
//					System.out.println("##### 玩耍的线程礼让执行 #####");
//				}
//
//				try {
//					Thread.sleep(1);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//				System.out.println(Thread.currentThread().getName() + "执行 i = " + i);
//			}
//		}, "玩耍的线程");
//		thread.start();
//
//		for (int i = 0; i < 100; i++) {
//			Thread.sleep(1);
//			System.out.println("【霸道的main线程】number = " + i);
//		}
//	}
//}

/*
3.13 线程优先级
 */
//public class ThreadDemo {
//    public static void main(String[] args) {
//        Runnable run = () -> {
//            for (int i = 0; i < 10; i++) {
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//				System.out.println(Thread.currentThread().getName() + "执行。");
//            }
//        };
//        Thread threadA = new Thread(run, "线程对象A");
//        Thread threadB = new Thread(run, "线程对象B");
//        Thread threadC = new Thread(run, "线程对象C");
//        threadA.setPriority(Thread.MIN_PRIORITY);
//		threadB.setPriority(Thread.NORM_PRIORITY);
//		threadC.setPriority(Thread.MAX_PRIORITY);
//        threadA.start();
//        threadB.start();
//        threadC.start();
//    }
//}
//
//public class ThreadDemo {
//	public static void main(String[] args) {
//		System.out.println("主线程优先级：" + Thread.currentThread().getPriority());
//		System.out.println("默认线程优先级：" + new Thread().getPriority());
//	}
//}

/*
3.14 同步问题引出
 */
//class MyThread implements Runnable {
//	private int ticket = 10 ;  //总票数10张
//	@Override
//	public void run() {
//		while(true) {
//			if(this.ticket > 0) {
//				try {
//					Thread.sleep(100); //模拟网络延迟
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//				System.out.println(Thread.currentThread().getName() + "卖票.ticket = " + this.ticket--);
//			} else {
//				System.out.println("--------票已卖光--------");
//				break;
//			}
//		}
//	}
//}
//
//public class ThreadDemo {
//	public static void main(String[] args) {
//		MyThread mt = new MyThread();
//		new Thread(mt,"票贩子A").start();
//		new Thread(mt,"票贩子B").start();
//		new Thread(mt,"票贩子C").start();
//	}
//}

/*
3.15 线程同步
 */
//class MyThread implements Runnable {
//	private int ticket = 10 ;  //总票数10张
//	@Override
//	public void run() {
//		while(true) {
//			synchronized (this) { //每一次只允许一个线程进行访问
//				if(this.ticket > 0) {
//					try {
//						Thread.sleep(100); //模拟网络延迟
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//					System.out.println(Thread.currentThread().getName() + "卖票.ticket = " + this.ticket--);
//				} else {
//					System.out.println("--------票已卖光--------");
//					break;
//				}
//			}
//		}
//	}
//}
//
//public class ThreadDemo {
//	public static void main(String[] args) {
//		MyThread mt = new MyThread();
//		new Thread(mt,"票贩子A").start();
//		new Thread(mt,"票贩子B").start();
//		new Thread(mt,"票贩子C").start();
//	}
//}

//class MyThread implements Runnable {
//	private int ticket = 10 ;  //总票数10张
//	public synchronized boolean sale() {
//		if(this.ticket > 0) {
//			try {
//				Thread.sleep(100); //模拟网络延迟
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			System.out.println(Thread.currentThread().getName() + "卖票.ticket = " + this.ticket--);
//			return true;
//		} else {
//			System.out.println("--------票已卖光--------");
//			return false;
//		}
//	}
//	@Override
//	public void run() {
//		while(this.sale()){};
//	}
//}
//
//public class ThreadDemo {
//	public static void main(String[] args) {
//		MyThread mt = new MyThread();
//		new Thread(mt,"票贩子A").start();
//		new Thread(mt,"票贩子B").start();
//		new Thread(mt,"票贩子C").start();
//	}
//}

/*
4.17 生产者消费者实现
 */
//public class ThreadDemo {
//
//    public static void main(String[] args) {
//        Message msg = new Message();
//        new Thread(new Producer(msg)).start();    //启动生产者线程
//        new Thread(new Consumer(msg)).start();    //启动消费者线程
//    }
//}
//
//class Producer implements Runnable {
//
//    private Message msg;
//
//    public Producer(Message msg) {
//        this.msg = msg;
//    }
//
//    @Override
//    public void run() {
//        for (int i = 0; i < 100; i++) {
//            if (i % 2 == 0) {
//                this.msg.setTitle("王健");
//                try {
//                    Thread.sleep(10);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                this.msg.setContent("宇宙大帅哥");
//            } else {
//                this.msg.setTitle("小高");
//                try {
//                    Thread.sleep(10);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                this.msg.setContent("猥琐第一人");
//            }
//        }
//    }
//}
//
//class Consumer implements Runnable {
//
//    private Message msg;
//
//    public Consumer(Message msg) {
//        this.msg = msg;
//    }
//
//    @Override
//    public void run() {
//        for (int i = 0; i < 100; i++) {
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(this.msg.getTitle() + " - " + this.msg.getContent());
//        }
//    }
//}
//
//class Message {
//
//    private String title;
//    private String content;
//
//    public void setContent(String content) {
//        this.content = content;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getContent() {
//        return content;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//}

/*
4.18解决生产消费数据同步问题
 */
//public class ThreadDemo {
//
//    public static void main(String[] args) {
//        Message msg = new Message();
//        new Thread(new Producer(msg)).start();    //启动生产者线程
//        new Thread(new Consumer(msg)).start();    //启动消费者线程
//    }
//}
//
//class Producer implements Runnable {
//
//    private Message msg;
//
//    public Producer(Message msg) {
//        this.msg = msg;
//    }
//
//    @Override
//    public void run() {
//        for (int i = 0; i < 100; i++) {
//            if (i % 2 == 0) {
//                this.msg.set("王健","宇宙大帅哥");
//                try {
//                    Thread.sleep(10);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            } else {
//                this.msg.set("小高","猥琐第一人");
//                try {
//                    Thread.sleep(10);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//}
//
//class Consumer implements Runnable {
//
//    private Message msg;
//
//    public Consumer(Message msg) {
//        this.msg = msg;
//    }
//
//    @Override
//    public void run() {
//        for (int i = 0; i < 100; i++) {
//			System.out.println(this.msg.get());
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}
//
//class Message {
//
//    private String title;
//    private String content;
//
//    public synchronized void set(String title,String content) {
//		this.content = content;
//		this.title = title;
//	}
//
//    public synchronized String get() {
//		return this.title + " - " + this.content;
//	}
//}


/*
4.19 解决重复操作
 */
//public class ThreadDemo {
//
//    public static void main(String[] args) {
//        Message msg = new Message();
//        new Thread(new Producer(msg)).start();    //启动生产者线程
//        new Thread(new Consumer(msg)).start();    //启动消费者线程
//    }
//}
//
//class Producer implements Runnable {
//
//    private Message msg;
//
//    public Producer(Message msg) {
//        this.msg = msg;
//    }
//
//    @Override
//    public void run() {
//        for (int i = 0; i < 100; i++) {
//            if (i % 2 == 0) {
//                this.msg.set("王健", "宇宙大帅哥");
//                try {
//                    Thread.sleep(10);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            } else {
//                this.msg.set("小高", "猥琐第一人");
//                try {
//                    Thread.sleep(10);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//}
//
//class Consumer implements Runnable {
//
//    private Message msg;
//
//    public Consumer(Message msg) {
//        this.msg = msg;
//    }
//
//    @Override
//    public void run() {
//        for (int i = 0; i < 100; i++) {
//            System.out.println(this.msg.get());
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}
//
//class Message {
//
//    private String title;
//    private String content;
//    private boolean flag = true;  //表示生产或消费的形式
//    //flag == ture 可以生产，不可用消费
//    //flag == fallse 可以消费，不可用生产
//
//    public synchronized void set(String title, String content) {
//        if (this.flag == false) { //无法进行生产，等待被消费
//            try {
//                super.wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        this.title = title;
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        this.content = content;
//        this.flag = false; // 已经生产过了
//        super.notify(); //生产完了，唤醒等待的消费线程
//    }
//
//    public synchronized String get() {
//        if (this.flag == true) {//还需要生产，需要等待
//			try {
//				super.wait();
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//        }
//		try {
//			Thread.sleep(100);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		try{
//			return this.title + " - " + this.content;
//		} finally { // b不管怎么样都要执行
//			this.flag = true; //继续生产
//			super.notify(); //唤醒等待线程
//		}
//    }
//}

/*
5.20 优雅的停止线程
 */
//public class ThreadDemo {
//	public static boolean flag = true;
//
//	public static void main(String[] args) throws Exception{
//		//如果不处理，将一直执行
//		new Thread( () -> {
//			long num = 0;
//			while (flag) {
//				try{
//					Thread.sleep(50);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//				System.out.println(Thread.currentThread().getName() + "正在运行、num = " + num++);
//			}
//		},"执行线程").start();
//
//		Thread.sleep(200);  //运行200ms
//		flag = false; //停止线程
//	}
//}

/*
5.21 后台守护线程
 */
//public class ThreadDemo {
//	public static boolean flag = true;
//
//	public static void main(String[] args) throws Exception {
//		Thread userThread = new Thread( () -> {
//			for (int i = 0; i < 10; i++) {
//				System.out.println(Thread.currentThread().getName() + "正在运行、i = " + i);
//				try{
//					Thread.sleep(100);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//		},"用户线程"); //完成核心的业务
//
//		Thread daemonThread = new Thread( () -> {
//			for (int i = 0; i < 10; i++) {
//				System.out.println(Thread.currentThread().getName() + "正在运行、i = " + i);
//				try{
//					Thread.sleep(200);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//		},"守护线程"); //完成守护业务
//		daemonThread.setDaemon(true); //设置为守护线程
//		userThread.start();
//		daemonThread.start();
//	}
//}

/*
5.22 volatile关键字
 */
//class MyThread implements Runnable {
//
//    private int ticket = 5;
//
//    @Override
//    public void run() {
//        while (this.ticket > 0) {
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out
//                .println(Thread.currentThread().getName() + "卖票处理， ticket = " + this.ticket--);
//        }
//    }
//}
//
//public class ThreadDemo {
//
//    public static void main(String[] args) {
//        MyThread mt = new MyThread();
//        new Thread(mt, "票贩子A").start();
//        new Thread(mt, "票贩子B").start();
//        new Thread(mt, "票贩子C").start();
//    }
//}

/*
6.23 数字加减
 */
//public class ThreadDemo {
//    public static void main(String[] args) {
//        Resource res = new Resource();
//        SubThread st = new SubThread(res);
//        AddThread at = new AddThread(res);
//        new Thread(at, "加法线程 - A").start();
//        new Thread(at, "加法线程 - B").start();
//        new Thread(st, "减法线程 - A").start();
//        new Thread(st, "减法线程 - B").start();
//    }
//}
//
//class AddThread implements Runnable {
//    private Resource resource;
//    public AddThread(Resource resource) {
//        this.resource = resource;
//    }
//    @Override
//    public void run() {
//        for (int i = 0; i < 1250; i++) {
//            try {
//                this.resource.add();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}
//class SubThread implements Runnable {
//    private Resource resource;
//    public SubThread(Resource resource) {
//        this.resource = resource;
//    }
//    @Override
//    public void run() {
//        for (int i = 0; i < 1250; i++) {
//            try {
//                this.resource.sub();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}
//
//class Resource { //定义一个操作的资源
//    private int num = 0; //这个要进行加减操作的数据
//    private boolean flag  = true; //加减切换
//    //flag = true 进行加法
//    //falg = false 进行减法
//    public synchronized void add() throws InterruptedException { //进行加法操作
//        while (this.flag == false) { //现在需要做减法，加法等待
//            super.wait();
//        }
//        //Thread.sleep(100);
//        this.num ++ ;
//        System.out.println("【加法操作 - " + Thread.currentThread().getName() + "】num = " + this.num);
//        this.flag = false;//激发操作完毕，需要执行减法
//        super.notifyAll();//唤醒等待线程
//
//    }
//
//    public synchronized void sub() throws InterruptedException { //进行减法操作
//        while (this.flag == true) {
//            super.wait();
//        }
//        //Thread.sleep(200);
//        this.num -- ;
//        System.out.println("【减法操作 - " + Thread.currentThread().getName() + "】num = " + this.num);
//        this.flag = true;
//        super.notifyAll();
//    }
//}



/*
6.24 电脑生产
 */
//public class ThreadDemo {
//
//    public static void main(String[] args) {
//        Resource res = new Resource();
//        new Thread(new Producer(res),"生产者A").start();
//        new Thread(new Producer(res),"生产者B").start();
//        new Thread(new Consumer(res),"消费者A").start();
//        new Thread(new Consumer(res),"消费者B").start();
//
//    }
//}
//class Producer implements Runnable {
//    private Resource resource;
//    public Producer(Resource resource) {
//        this.resource = resource;
//    }
//    @Override
//    public void run() {
//        for (int i = 0; i < 5000; i++) {
//            try{
//                this.resource.make();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}
//class Consumer implements Runnable {
//    private Resource resource;
//    public Consumer(Resource resource) {
//        this.resource = resource;
//    }
//    @Override
//    public void run() {
//        for (int i = 0; i < 5000; i++) {
//            try{
//                this.resource.get();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}
//class Resource {
//    private Computer computer;
//    public synchronized void make() throws Exception {
//        while(this.computer != null) { //已经生产过了
//            super.wait();
//        }
//        Thread.sleep(10);
//        this.computer = new Computer("XXX牌电脑",111.1);
//        System.out.println(Thread.currentThread().getName() + "-【生产电脑】" + this.computer);
//        super.notifyAll();
//    }
//    public synchronized void get() throws Exception {
//        while(this.computer == null) { //没有生产过
//            super.wait();
//        }
//        Thread.sleep(20);
//        System.out.println(Thread.currentThread().getName() + "-【取走电脑】" + this.computer);
//        this.computer = null;  //已经取走了
//        super.notifyAll();
//    }
//}
//
//class Computer {
//    private static int count = 0;
//    private String name;
//    private double price;
//    public Computer(String name,double price) {
//        this.name = name;
//        this.price = price;
//        count ++ ;
//    }
//    @Override
//    public String toString() {
//        return "【第" + count + "台电脑】电脑名字：" + this.name +"、价值：" +this.price;
//    }
//}

/*
6.25:竞争抢答
 */
//public class ThreadDemo {
//    public static void main(String[] args) throws Exception {
//        MyThread mt = new MyThread();
//        FutureTask<String> taskA = new FutureTask<String>(mt);
//        FutureTask<String> taskB = new FutureTask<String>(mt);
//        FutureTask<String> taskC = new FutureTask<String>(mt);
//
//        new Thread(taskA,"竞赛者A").start();
//        new Thread(taskB,"竞赛者B").start();
//        new Thread(taskC,"竞赛者C").start();
//        System.out.println(taskA.get());
//        System.out.println(taskB.get());
//        System.out.println(taskC.get());
//    }
//}
//
//class MyThread implements Callable<String> {
//    private boolean flag = false; //抢答处理
//    @Override
//    public String call() throws Exception {
//        synchronized (this) { //数据同步
//            if(this.flag == false ) { //抢答成功
//                this.flag = true;
//                return Thread.currentThread().getName() +"抢答成功！";
//            } else {
//                return Thread.currentThread().getName() +"抢答失败！";
//
//            }
//        }
//    }
//}