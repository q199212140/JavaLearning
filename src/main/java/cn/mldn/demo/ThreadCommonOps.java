package cn.mldn.demo;

class NameThread implements Runnable
{
    @Override
    public void run()
    {
        System.out.println(Thread.currentThread().getName());
    }
}


public class ThreadCommonOps
{
	public static void main(String[] args)
	{
	    System.out.println("5.8：线程的命名和取得:");
	    
	    NameThread testNameThread = new NameThread();
	    
	    new Thread(testNameThread, "线程A").start();
	    new Thread(testNameThread).start();
	    new Thread(testNameThread).start();
	    new Thread(testNameThread).start();
	    new Thread(testNameThread, "线程B").start();
	    
	    System.out.println("\n\n对象直接调用:");
	    testNameThread.run();//对象直接调用：main
	    
	    //lambda表达式起子线程处理
	    System.out.println("\n\n子线程应用举例:");
	    new Thread(
	            ()->{
	                int tmp = 0;
	                for(int i = 0; i < Integer.MAX_VALUE; i++)
	                {
	                    tmp += i;
	                }
	                System.out.println("\n\n子线程中计算完成。");
	            }
	            ).start();

	    System.out.println("\n\n线程休眠测试开始:");
	    for (int threadIdx = 0; threadIdx < 5; threadIdx ++)
	    {
	        new Thread(
	                ()->{
	                    for(int x = 0; x < 10; x++)
	                    {
	                        System.out.println(Thread.currentThread().getName() + "、x = " + x);
	                        try
	                        {
	                            Thread.sleep(50);
	                        } catch (InterruptedException e)
	                        {
	                            // TODO Auto-generated catch block
	                            e.printStackTrace();
	                        }
	                        System.out.println("线程休眠测试完成。");
	                    }
	                }, "休眠测试的线程对象_" + threadIdx).start();
	    }
	    
	    System.out.println("\n\n线程中断测试开始:");
	    Thread interruptThread = new Thread(()-> 
	    {
	        System.out.println("该睡觉了。");
	        
	        try
            {
                Thread.sleep(10000);
                System.out.println("睡足了。");
            } catch (InterruptedException e)
            {
                // TODO Auto-generated catch block
                System.out.println("打扰我睡觉？！！");
                e.printStackTrace();
            }	        	           
	    });
	    
	    interruptThread.start();//开始睡
	    
	    try
        {
            Thread.sleep(1000);
        } catch (InterruptedException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	    
	    if(!interruptThread.isInterrupted())
	    {
	        System.out.println("偷偷打扰一下你的睡眠，haha。");
	        interruptThread.interrupt();
	    }
	    System.out.println("线程中断测试完成。");
	    
	    System.out.println("\n\n线程强制执行测试开始：");
	    Thread mainThread = Thread.currentThread();
	    
	    Thread forceThread = new Thread(()-> 
        {
            for(int i = 0; i < 100; i++)
            {
                if(i == 3)
                {
                    try
                    {
                        mainThread.join();//主线程先执行
                    } catch (InterruptedException e)
                    {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " : 测试子任务执行：i = " + i);
            }          
        }, "测试子任务");
	    forceThread.start();
	    
        for (int i = 0; i < 100; i++)
        {
            System.out.println("测试主任务执行：i = " + i);
        } 
        
	    System.out.println("线程强制执行测试完成。");
	    
	    System.out.println("\n\n线程礼让测试开始：");
	       Thread mainThread1 = Thread.currentThread();
	        
	        Thread forceThread1 = new Thread(()-> 
	        {
	            for(int i = 0; i < 100; i++)
	            {
	                if(i % 3 == 0)
	                {
	                    mainThread1.yield();//主线程先执行
	                    System.out.println("子线程礼让执行。");
	                }
	                System.out.println(Thread.currentThread().getName() + " : 测试子任务执行：i = " + i);
	            }          
	        }, "测试子任务");
	        forceThread1.start();
	        
	        for (int i = 0; i < 100; i++)
	        {
	            System.out.println("测试主任务执行：i = " + i);
	        } 
	        
	    System.out.println("线程礼让测试完成。");
	    
	    try
        {
            Thread.sleep(5000);
        } catch (InterruptedException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	    
	    System.out.println("\n\n线程优先级测试开始");
	    System.out.println("\n\n主线程优先级 = " + Thread.currentThread().getPriority());
	    System.out.println("\n\n默认子线程优先级 = " + new Thread().getPriority());
	    Runnable run = ()->
	    {
	        for(int i = 0; i < 10; i++)
	        {
	            System.out.println(Thread.currentThread().getName() + " 执行。");
	            try
	            {
	                Thread.sleep(1000);
	            } catch (InterruptedException e)
	            {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	        }
	    };
	    Thread threadA = new Thread(run, "优先级线程对象A");
	    Thread threadB = new Thread(run, "优先级线程对象B");
	    Thread threadC = new Thread(run, "优先级线程对象C");
	    
	    threadA.setPriority(Thread.MIN_PRIORITY);
	    threadB.setPriority(Thread.MIN_PRIORITY);
	    threadC.setPriority(Thread.MAX_PRIORITY);
	    threadA.start();
	    threadB.start();
	    threadC.start();
	    
	    System.out.println("线程优先级测试完成。");
	}
}
