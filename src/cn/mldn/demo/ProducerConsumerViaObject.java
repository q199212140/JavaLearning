package cn.mldn.demo;

//synchronized同步
//能解决同步问题，但未解决重复操作问题 并发不起来
class ObjectMessage
{
    private String title;
    private String content;
    private boolean flag = true;//true 可以生产，不能消费， false可以消费，不能生产
 
    public synchronized void set(String title, String content)
    {
        if(!this.flag) 
        {
            try//无法生产，等待被消费
            {
                super.wait();
            }catch(InterruptedException e)
            {
                e.printStackTrace();
            } 
        }
              
        try
        {
            Thread.sleep(100);
        } catch (InterruptedException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.title = title;
        this.content = content;
        
        this.flag = false;
        super.notify();//唤醒等待的线程
    }
    
    public synchronized String get()
    {
        if(true == this.flag)//还未生产，继续等待
        {
            try//无法生产，等待被消费
            {
                super.wait();
            }catch(InterruptedException e)
            {
                e.printStackTrace();
            } 
        }
        try
        {
            Thread.sleep(100);
        } catch (InterruptedException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try
        {
            return this.title + " - " + this.content;
        }finally//不管如何，都要执行
        {
            this.flag = true;//继续生产
            super.notify();
        }
    }
}


class ObjectProducer implements Runnable
{
    public ObjectMessage msg;
    
    public ObjectProducer(ObjectMessage msg)
    {
        this.msg = msg;
    }
    
    @Override
    public void run()
    {
        for(int i = 0; i < 100; i++)
        {
            if(i % 2 == 0)
            {
                this.msg.set("王健", "宇宙大帅锅");
            }
            else
            {
                this.msg.set("小高", "猥琐第一人，一直一直一直一直");
            }
        }
    }
}

class ObjectConsumer implements Runnable
{
    private ObjectMessage msg;
    public ObjectConsumer(ObjectMessage msg)
    {
        this.msg = msg;
    }
    @Override
    public void run()
    {
        for(int i = 0; i < 100; i++)
        {
            System.out.println(this.msg.get());
        }
    }
}

public class ProducerConsumerViaObject
{
    public static void main(String[] args)
    {
        ObjectMessage msg = new ObjectMessage();
        new Thread(new ObjectProducer(msg)).start();
        new Thread(new ObjectConsumer(msg)).start();
    }
}
