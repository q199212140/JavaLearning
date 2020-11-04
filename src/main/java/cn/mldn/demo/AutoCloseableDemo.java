/*
 * 资源开发时实现资源自动关闭/释放——文件、网络、数据库开发
 * */

package cn.mldn.demo;

interface IMessage
{
    public void send();
}

class ManualNetMessage implements IMessage
{
    private String msg;
    
    public ManualNetMessage(String msg)
    {
        this.msg = msg;
    }
    
    public boolean open()
    {
        System.out.println("[OPEN]获取消息发送连接资源");
        return true;
    }
    
    @Override
    public void send()
    {
        if(this.open())
        {
            System.out.println("*** 发送消息 ***" + this.msg);
        }
    }
    
    public void close() throws Exception
    {
        System.out.println("[CLOSE]关闭消息发送连接资源");
    }
}

//结合异常处理方可实现
class AutoNetMessage implements IMessage, AutoCloseable
{
    private String msg;
    
    public AutoNetMessage(String msg)
    {
        this.msg = msg;
    }
    
    public boolean open()
    {
        System.out.println("[OPEN]获取消息发送连接资源");
        return true;
    }
    
    @Override
    public void send()
    {
        if(this.open())
        {
            System.out.println("*** 发送消息 ***" + this.msg);
        }
    }
    
    @Override
    public void close()
    {
        System.out.println("[CLOSE]关闭消息发送连接资源");
    }
}

public class AutoCloseableDemo
{
    public static void main(String[] args) throws Exception
    {
        System.out.println("\n\n手动管理资源：");
        ManualNetMessage nm = new ManualNetMessage("Hello World!");
        
        nm.send();
        nm.close();
        
        System.out.println("\n\nAutoCloseable自动管理资源：");
        //AutoCloseable机制需要结合try catch机制一起使用
        try(AutoNetMessage autoMsg = new AutoNetMessage("Auto Hello World!"))
        {
            autoMsg.send();
        }catch(Exception e)
        {
            ;
        }
        Runtime e;
    }
}
