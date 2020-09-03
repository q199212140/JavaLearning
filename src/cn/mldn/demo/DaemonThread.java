package cn.mldn.demo;

public class DaemonThread
{
    public static boolean flag = true;
    public static void main(String[] args)
    {  
        Thread userThread = new Thread(()->
                {
                    for(int x = 0; x < 10; x++)
                    {
                        try
                        {
                            Thread.sleep(50);
                        } catch (InterruptedException e)
                        {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + "正在运行，num = " + x);
                    }
                }, "用户线程");
        
        Thread daemonThread = new Thread(()->
        {
            for(int x = 0; x < Integer.MAX_VALUE; x++)
            {
                try
                {
                    Thread.sleep(50);
                } catch (InterruptedException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "正在运行，num = " + x);
            }
        }, "守护线程");
               
        userThread.start();
        //守护：伴随主线程，主线程退出，守护线程也退出，JVM中最大的守护线程GC
        daemonThread.setDaemon(true);
        daemonThread.start();
    }
}
