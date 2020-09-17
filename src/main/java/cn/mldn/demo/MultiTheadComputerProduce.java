/*
 * 生产、搬运电脑类，生产出一台电脑就搬走一台，如果没有新电脑生产出来，则搬运工要等待新电脑
 * 如果生产出来的电脑没有搬走，则要等待搬走后再生产，并统计生产出的电脑数量*/

package cn.mldn.demo;

class ComputerProducer implements Runnable
{
    private ComputerResource resource;
    
    public ComputerProducer(ComputerResource resource)
    {
        this.resource = resource;
    }
    
    public void run()
    {
        for(int x = 0; x < 50; x++)
        {
            try
            {
                this.resource.make();
            } catch (Exception e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}

class ComputerConsumer implements Runnable
{
    private ComputerResource resource;
    
    public ComputerConsumer(ComputerResource resource)
    {
        this.resource = resource;
    }
    
    public void run()
    {
        for(int x = 0; x < 50; x++)
        {
            try
            {
                this.resource.get();
            } catch (Exception e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}

class Computer
{
    private static int count = 0;//生产电脑台数
    private String name;
    private double price;
    
    public Computer(String name, double price)
    {
        this.name = name;
        this.price = price;
        count++;
    }
    
    public String toString()
    {
        return "【第" + count + "台电脑】，名字：" + this.name + "、价格：" + this.price; 
    }
}

class ComputerResource
{
    private Computer computer;//通过电脑对象是否为空来进行生产者和消费者的同步
    
    public synchronized void make() throws Exception
    {
        if(this.computer != null)//已经生产过了
        {
            super.wait();
        }
        Thread.sleep(100);
        this.computer = new Computer("dell电脑", 1.1);
        System.out.println("生产电脑：" + this.computer);
        super.notifyAll();
    }
    
    public synchronized void get() throws Exception
    {
        if(null == this.computer)//还未生产
        {
            super.wait();
        }
        Thread.sleep(10);
        System.out.println("搬运电脑：" + this.computer);
        this.computer = null;
        super.notifyAll();
    }
}

public class MultiTheadComputerProduce
{
    public static void main(String[] args)
    {
        ComputerResource res = new ComputerResource();
        
        new Thread(new ComputerProducer(res)).start();
        new Thread(new ComputerConsumer(res)).start();
    }
}
