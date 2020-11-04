package cn.mldn.message;

class Message
{
    private String info;
    public void setInfo(String info)
    {
        this.info = info;
    }
    public String getInfo()
    {
        return info;
    }
}

class Channel
{
    
    //thread local 存储空间解决多线程并发访问static全局内存
    private static final ThreadLocal<Message> THREAD_LOCAL = new ThreadLocal<Message>();
    public static void setMessage(Message m)
    {
        THREAD_LOCAL.set(m);
    }
    
    public static void send()
    {
        System.out.println(Thread.currentThread().getName() + "--消息发送：" + THREAD_LOCAL.get().getInfo());
    }
}

public class ThreadLocalDemo
{
    public static void main(String[] args)
    {
        System.out.println("ThreadLocal Demo : ");
        new Thread(()->
        {
            Message msg = new Message();
            msg.setInfo("第一个线程发送的消息!");    
            Channel.setMessage(msg);
            Channel.send();  
        }, "消息发送者A").start();
        new Thread(()->
        {
            Message msg = new Message();
            msg.setInfo("第二个线程发送的消息!");    
            Channel.setMessage(msg);
            Channel.send();  
        }, "消息发送者B").start();
        new Thread(()->
        {
            Message msg = new Message();
            msg.setInfo("第三个线程发送的消息!");    
            Channel.setMessage(msg);
            Channel.send();  
        }, "消息发送者C").start();
    }
}
