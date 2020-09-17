package cn.mldn.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface IMessage4DynamicProxyDemo
{
    public void send();
    
}

class MessageReal4DynamicProxyDemo implements IMessage4DynamicProxyDemo
{
    public void send()
    {
        System.out.println("[发送消息]Hello world!!!!!!!");
    }
}

class MLDNProxy implements InvocationHandler
{
    private Object target;//保存真实业务对象
    /**
     * 运行真实业务对象与代理对象之间的绑定处理
     * @param targect 真实业务对象
     * @return Proxy生成的代理业务对象
     */
    public Object bind(Object target)
    {
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
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
    
    /**
     * 代理主题类里面执行的方法最终都是此方法
     */
    public Object invoke(Object pro, Method method, Object[] args) throws Throwable
    {
        Object returnData = null;
        
        System.out.println("******执行方法********");
        
        if(this.connect())
        {
            returnData = method.invoke(this.target, args);
            this.close();
        }
        return returnData;
    }
}

public class DynamicProxyDemo
{
    public static void main(String[] args)
    {
        System.out.println("Lesson 118 : 动态代理设计模式：");
        
        IMessage4DynamicProxyDemo msg = (IMessage4DynamicProxyDemo)new MLDNProxy().bind(new MessageReal4DynamicProxyDemo());
        msg.send();
    }
}
