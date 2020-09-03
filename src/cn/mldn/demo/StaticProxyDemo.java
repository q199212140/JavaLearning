package cn.mldn.demo;

interface IMessage4StaticProxyDemo
{
    public void send();
    
}

class MessageReal4StaticProxyDemo implements IMessage4StaticProxyDemo
{
    public void send()
    {
        System.out.println("[发送消息]Hello world!!!!!!!");
    }
}

/**
 * 消息代理类
 * @author Leo123_
 *
 */
class MessageProxy4StaticProxyDemo implements IMessage4StaticProxyDemo
{
    //消息代理类一定要为代理对象而存在
    private IMessage4StaticProxyDemo message;
    
    public MessageProxy4StaticProxyDemo(IMessage4StaticProxyDemo message)
    {
        this.message = message;
    }
    
    //调用真实业务子类的接口，在动态代理情况下，需要跨越多个接口存在
    public void send()
    {
        // TODO Auto-generated method stub
        if(this.connect())
        {
            this.message.send();
            this.close();
        }
    }
     
    public boolean connect()
    {
        System.out.println("[消息代理]消息发送通道连接");
        return true;
    }

    public void close()
    {
        System.out.println("[消息代理]关闭发送通道");
    }
    
}
 
public class StaticProxyDemo
{
    public static void main(String[] args)
    {
        System.out.println("Lesson 6.117 静态代理设计模式");
        
        IMessage4StaticProxyDemo msg = new MessageProxy4StaticProxyDemo(new MessageReal4StaticProxyDemo());
        msg.send();
    }
}
