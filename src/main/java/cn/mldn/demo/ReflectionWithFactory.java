package cn.mldn.demo;

import java.lang.reflect.InvocationTargetException;

interface IReflectionMessage
{
    public void send();
}

class ReflectionNetMessage implements IReflectionMessage
{
    public void send()
    {
        System.out.println("网络消息发送：net ：hello world!!!!!");
    }
}

class ReflectionCloudMessage implements IReflectionMessage
{
    public void send()
    {
        System.out.println("云消息发送：cloud：hello world!!!!!");
    }
}


interface IReflectionService
{
    public void reflectionService();
}

class HouseService implements IReflectionService
{
    @Override
    public void reflectionService()
    {
        System.out.println("[service]:为您的住宿提供服务！");
    }
}

/**
 * 一个高可用的工厂，不受限于指定的接口
 * @author Leo123_
 *
 */
class ReflectionFactory
{
    //构造函数私有化，∵没有产生实例化对象的意义
    private ReflectionFactory() {}  
    
    /**
     * 获取接口实例化对象——依赖泛型，实现通用的接口对象返回
     * @param className 接口子类
     * @param classInput 描述的是一个接口的类型
     * @return 如果子类存在则返回指定接口实例化对象
     */
    @SuppressWarnings("unchecked")
    public static <T> T getInstance(String className, Class<T> classInput)
    {
        T instance = null;
        
        try
        {
            instance = (T)Class.forName(className).getDeclaredConstructor().newInstance();
        } catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        /*
        //new方法+if else 创建对象，必须知道对象类型，用newInstance可以把这个代码中的依赖转变为串的依赖
        if("ReflectionNetMessage".equals(className))
        {
            return new ReflectionNetMessage();
        }
        else if("ReflectionCloudMessage".equals(className))
        {
            return new ReflectionCloudMessage();
        }
        */
               
        return instance;
    }
}

public class ReflectionWithFactory
{
    public static void main(String[] args)
    {
        System.out.println("Lesson 6.102 反射与工厂设计模式：");
        
        //IReflectionMessage msg = new ReflectionNetMessage(); //直接实例化，一定有耦合问题，∵一个接口一般不只有一个子类
        
        /*
        //标准工厂设计模式
        IReflectionMessage netMsg = ReflectionFactory.getInstance("ReflectionNetMessage");
        netMsg.send();      
        IReflectionMessage cloudMsg = ReflectionFactory.getInstance("ReflectionCloudMessage");
        cloudMsg.send();
        */
        
        System.out.println("\n利用反射机制实现的工厂，最大的优势子类扩充不影响工程的实现：");
        System.out.println("实际场景中，肯定不止一个接口的，如何让一个工厂负责所有接口的生产：依赖泛型：");
        IReflectionMessage netMsg = ReflectionFactory.getInstance("cn.mldn.demo.ReflectionNetMessage", IReflectionMessage.class);
        netMsg.send();       
        IReflectionMessage cloudMsg = ReflectionFactory.getInstance("cn.mldn.demo.ReflectionCloudMessage", IReflectionMessage.class);
        cloudMsg.send();
        
        IReflectionService service = ReflectionFactory.getInstance("cn.mldn.demo.HouseService", IReflectionService.class);
        service.reflectionService();
    }
}
