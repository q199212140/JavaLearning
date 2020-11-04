package cn.mldn.demo;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;


@FunctionalInterface
//@Deprecated(since="1.0")
interface IMessage4Annotation //有2个annotation
{
    public void send(String msg);
}

@SuppressWarnings("serial")
class MessageImpl4Annotation implements IMessage4Annotation,Serializable
{

    public void send(String msg)
    {
        System.out.println("[消息发送]  " + msg);
        
    }
    
}

public class GetAnnotationViaReflection
{
    public static void main(String[] args) throws NoSuchMethodException, SecurityException
    {
        System.out.println("Lesson 6.120 反射去的annotation信息：");
        
        System.out.println("接口的annotation信息：");
        
        //获取接口上的annotation信息
        {
            Annotation annotations[] = IMessage4Annotation.class.getAnnotations();
            for(Annotation temp : annotations)
            {
                System.out.println(temp);
            }
        }
        
        System.out.println("\n接口的annotation信息：空：无法在运行时获取");
        {
            Annotation annotations[] = MessageImpl4Annotation.class.getAnnotations();
            for(Annotation temp : annotations)
            {
                System.out.println(temp);
            }
        }
        
        System.out.println("\n获取toString方法的annotation信息：空：无法在运行时获取");
        {
            Method method = MessageImpl4Annotation.class.getDeclaredMethod("send", String.class);
            Annotation annotations[] = method.getAnnotations();
            for(Annotation temp : annotations)
            {
                System.out.println(temp);
            }
        }
    }
}
