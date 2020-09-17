package cn.mldn.demo;

class TicketThread implements Runnable
{
    private int ticket = 10;
    
    public synchronized boolean sale()
    {
        if(this.ticket > 0)
        {
            try
            {
                Thread.sleep(100);
            } catch (InterruptedException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "卖票，ticket = " + this.ticket--);
            return true;
        }
        else
        {
            System.out.println("票已经卖光。");
            return false;
        }
    }
    
    @Override
    public void run()
    {
        while(this.sale())
        {
            ;
            /*
            //同步代码块方法实现同步
            synchronized(this)//，每一次只允许一个线程访问
            {
                if(this.ticket > 0)
                {
                    try
                    {
                        Thread.sleep(100);
                    } catch (InterruptedException e)
                    {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "卖票，ticket = " + this.ticket--);
                }
                else
                {
                    System.out.println("票已经卖光。");
                    break;
                }
            }
            */
        }
    }
}

public class ThreadSyncAndDeadLock
{
    public static void main(String[] args)
    {
        TicketThread tt = new TicketThread();
        new Thread(tt, "票贩子A").start();
        new Thread(tt, "票贩子B").start();
        new Thread(tt, "票贩子C").start();
    }
}
