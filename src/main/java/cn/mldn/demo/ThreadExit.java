package cn.mldn.demo;

public class ThreadExit
{
    public static boolean flag = true;
    public static void main(String[] args)
    {  
        new Thread(()->
                {
                    long n = 0;
                    while(flag)
                    {
                        try
                        {
                            Thread.sleep(50);
                        } catch (InterruptedException e)
                        {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + "�������У�num = " + n++);
                    }
                }, "��������ֹͣ���߳�").start();
        
        try
        {
            Thread.sleep(200);
        } catch (InterruptedException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        flag = false;
    }
}
