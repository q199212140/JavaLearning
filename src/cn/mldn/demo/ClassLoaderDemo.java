package cn.mldn.demo;

import java.lang.reflect.Method;

import cn.mldn.util.ClassLoader4ClassLoaderDemo;

class Message4ClassLoaderDemo
{
}

public class ClassLoaderDemo
{
    public static void main(String[] args) throws Exception
    {
        System.out.println("Lesson 6.115 ClassLoader类加载器简介:类加载器在不同版本之间有差异");
        
        Class<?> clazz = Message4ClassLoaderDemo.class;
                
        //获取当前类加载器
        System.out.println(clazz.getClassLoader());//sun.misc.Launcher$AppClassLoader@73d16e93   应用程序加载器
        
        //获取父类加载器
        System.out.println(clazz.getClassLoader().getParent());//sun.misc.Launcher$ExtClassLoader@15db9742 平台类加载器；JDK1.8及以前称为扩展类加载器，ext目录
               
        //获取祖父类加载器
        System.out.println(clazz.getClassLoader().getParent().getParent());//null
        
        
        System.out.println("\n\nLesson 6.116 自定义ClassLoader处理类");
        ClassLoader4ClassLoaderDemo selfClassLoader = new ClassLoader4ClassLoaderDemo();
        Class<?> cls = selfClassLoader.loadData("cn.mldn.util.Message4ClassLoader");
        
        System.out.println(cls);
        
        Object obj = cls.getDeclaredConstructor().newInstance();
        Method method = cls.getDeclaredMethod("send");
        method.invoke(obj);
        
    }
}
