/*
 * 设计4个线程，2个线程执行减操作，2个线程执行加操作*/
package cn.mldn.demo;

class AddThread implements Runnable
{
    private Resource resource;
    public AddThread(Resource resource)
    {
        this.resource = resource;
    }
    
    @Override
    public void run()
    {
        for(int x = 0 ; x < 50; x++)
        {
            try
            {
                this.resource.add();
            } catch (Exception e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}

class SubThread implements Runnable
{
    private Resource resource;
    public SubThread(Resource resource)
    {
        this.resource = resource;
    }
    
    @Override
    public void run()
    {
        for(int x = 0 ; x < 50; x++)
        {
            try
            {
                this.resource.sub();
            } catch (Exception e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}

class Resource
{
    private int num = 0;
    private boolean addEnable = true;
    
    public synchronized void add() throws Exception
    {
        while(false == this.addEnable)//教程中是if，无法真正实现加减法的互斥等待，不会出现0 1 的严格交替
        {
            super.wait();
        }
        
        Thread.sleep(100);
        this.num++;
        System.out.println("加法操作 - " + Thread.currentThread().getName() + "，num = " + this.num);
        
        this.addEnable = false;
        super.notifyAll();
    }
    
    public synchronized void sub() throws Exception
    {
        while(true == this.addEnable)
        {
            super.wait();
        }
        
        Thread.sleep(200);
        this.num--;
        System.out.println("减法操作 - " + Thread.currentThread().getName() + "，num = " + this.num);
        
        this.addEnable = true;
        super.notifyAll();
    }
}

public class MultiThreadAddSub
{
    public static void main(String[] args)
    {
        System.out.println("\n\n多线程案例：多线程加减法：");
        
        Resource res = new Resource();
        AddThread at = new AddThread(res);
        SubThread st = new SubThread(res);
        
        new Thread(at, "加法线程 - A").start();
        new Thread(at, "加法线程 - B").start();
        new Thread(st, "减法线程 - X").start();
        new Thread(st, "减法线程 - Y").start();
    }
}
