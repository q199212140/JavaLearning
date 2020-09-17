package cn.mldn.demo;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

class Person{}

public class ReflectionDemo
{
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException
    {
        System.out.println("Lesson 6.99 反射机制：");
        
        System.out.println("通过子类实例化对象获取对象类型：");       
        Date date = new Date();
        System.out.println(date.getClass());//根据实例化对象找到对象所属类型
        
        System.out.println("方法一：object getName接口，依赖于已经实例化的对象：");
        Person per = new Person();
        Class<? extends Person> cls1 = per.getClass();
        System.out.println(cls1);//class cn.mldn.demo.Person
        System.out.println(cls1.getName());//cn.mldn.demo.Person 类完整名称
        
        System.out.println("\n 方法二：采用 类.class 形式实例化[JVM支持的机制，不需要提前对象实例化，但需要导入对应的包]：");
        Class<? extends Person> cls2 = Person.class;
        System.out.println(cls2.getName());//
        
        System.out.println("\n方法三：采用 class类支持：依赖字符串定义要使用的类，程序中不需要import过程：");
        Class<?> cls3 = Class.forName("cn.mldn.demo.testPerson.Person");
        System.out.println(cls3.getName());//
        
        System.out.println("\n通过newInstance方法实例化对象[JDK1.9后被废除]：把 new 类机制 替换为  字符串+newInstance");
        //Object obj = cls3.newInstance();//通过反射实现的对象实例化处理，依然要调用类中的无参构造方法
        Object obj = cls3.getDeclaredConstructor().newInstance();//JDK1.9之后
        System.out.println(obj);
    }
}
