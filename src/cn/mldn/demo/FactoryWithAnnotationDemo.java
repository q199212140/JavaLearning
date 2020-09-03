package cn.mldn.demo;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface IMessage4FactoryWithAnnotation
{
    public void send(String msg);
}

class MessageImpl4FactoryWithAnnotation implements IMessage4FactoryWithAnnotation
{
    public void send(String msg)
    {
        System.out.println("[消息发送]" + msg);
    }
    
}

class NetMessageImpl4FactoryWithAnnotation implements IMessage4FactoryWithAnnotation
{
    public void send(String msg)
    {
        System.out.println("[网络消息发送]" + msg);
    }
    
}
class MessageProxy4FactoryWithAnnotation implements InvocationHandler
{
    private Object target;

    public Object bind(Object target)
    {
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }
    
    public boolean connect()
    {
        System.out.println("[代理操作] 进行消息发送通道连接");
        return true;
    }
    
    public void close()
    {
        System.out.println("[代理操作] 关闭连接通道");
    }
    
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
    {
        // TODO Auto-generated method stub
        try
        {
            if(this.connect())
            {
                return method.invoke(this.target, args);
            }
            else
            {
                throw new Exception("[Error] 消息无法进行发送！");
            }
        }finally
        {
            this.close();
        }        
    }   
}

class Factory4FactoryWithAnnotation
{
    private Factory4FactoryWithAnnotation() {}
    
    public static <T> T getInstance(Class<T> clazz)
    {
        try
        {
            return (T) new MessageProxy4FactoryWithAnnotation().bind(clazz.getDeclaredConstructor().newInstance());
        } catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }
}

//通过注解完成子类的扩展——通过注解控制程序的执行
@Retention(RetentionPolicy.RUNTIME)
@interface UseMessage
{
    public Class<?> clazz();
}

//@UseMessage(clazz=MessageImpl4FactoryWithAnnotation.class)
@UseMessage(clazz=NetMessageImpl4FactoryWithAnnotation.class)

class MessageService4FactoryWithAnnotation
{
    private IMessage4FactoryWithAnnotation message;
    
    public MessageService4FactoryWithAnnotation()
    {
        UseMessage use = MessageService4FactoryWithAnnotation.class.getAnnotation(UseMessage.class);
        this.message = (IMessage4FactoryWithAnnotation) Factory4FactoryWithAnnotation.getInstance(use.clazz());       
    }
    
    public void send(String msg)
    {
        this.message.send(msg);
    }    
}

public class FactoryWithAnnotationDemo
{
    public static void main(String[] args)
    {
        System.out.println("6.122.工厂模式与Annotation整合");
        
        //主方法只需要关注服务对象产生和数据发送，其他的都封装在服务类中
        MessageService4FactoryWithAnnotation messageService = new MessageService4FactoryWithAnnotation();
        messageService.send("Hello Leoooooooooooooooooooo!");
    }
}
