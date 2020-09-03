package cn.mldn.demo;

class VolatileThread implements Runnable
{
    private volatile int ticket = 10;
    
    @Override
    public void run()
    {
        synchronized(this)
        {
            while(this.ticket > 0)
            {
                try
                {
                    Thread.sleep(50);
                } catch (InterruptedException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "， 卖票处理， ticket = " + this.ticket--);
            }
        }
    }
}

public class VolatileDeam
{
    public static void main(String[] args)
    {
        VolatileThread vt = new VolatileThread();
        new Thread(vt, "票贩子A").start();
        new Thread(vt, "票贩子B").start();
        new Thread(vt, "票贩子C").start();
    }
}
