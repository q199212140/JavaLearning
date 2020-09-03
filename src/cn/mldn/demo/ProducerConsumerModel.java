package cn.mldn.demo;

/*
 //未同步的message读写操作
class Message
{
    private String title;
    private String content;
    public void setContent(String content)
    {
        this.content = content;
    }
    public void setTitle(String title)
    {
        this.title = title;
    }
    public String getContent()
    {
        return this.content;
    }
    public String getTitle()
    {
        return this.title;
    }
}
*/

//synchronized同步
//能解决同步问题，但未解决重复操作问题 并发不起来
class Message
{
    private String title;
    private String content;
 
    public synchronized void set(String title, String content)
    {
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
    }
    
    public synchronized String get()
    {
        try
        {
            Thread.sleep(100);
        } catch (InterruptedException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return this.title + " - " + this.content;
    }
}


class Producer implements Runnable
{
    public Message msg;
    
    public Producer(Message msg)
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

class Consumer implements Runnable
{
    private Message msg;
    public Consumer(Message msg)
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

public class ProducerConsumerModel
{
    public static void main(String[] args)
    {
        Message msg = new Message();
        new Thread(new Producer(msg)).start();
        new Thread(new Consumer(msg)).start();
    }
}
