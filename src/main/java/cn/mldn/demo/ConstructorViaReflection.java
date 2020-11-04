package cn.mldn.demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ConstructorViaReflection
{
    public static void main(String[] args) throws Exception
    {
        System.out.println("Lesson 6.105 反射调用构造方法：");
        
        Class<?> cls = ClassInfoPerson.class;//获取指定类的Class对象
        
        System.out.println("获取全部构造方法：");
        Constructor<?>[] constructors = cls.getDeclaredConstructors();        
        for(Constructor<?> cons : constructors)
        {
            System.out.println(cons);
        }
        
        System.out.println("通过有参构造实例化方法：");
        Constructor<?> constructor1 = cls.getConstructor(String.class, int.class);        
        Object obj = constructor1.newInstance("leo", 22);
        System.out.println(obj);
        
        System.out.println("\n\nLesson 6.106 反射调用普通方法：");
        System.out.println("获取全部方法(包括父类方法)：");
        Method allMethods[] = cls.getMethods();
        for(Method met : allMethods)
        {
            System.out.println(met);
        }
        
        System.out.println("获取全部方法(包括父类方法)：");
        Method selfMethods[] = cls.getDeclaredMethods();
        for(Method met : selfMethods)
        {
            System.out.println(met);
        }
        
        System.out.println("\n\n模拟实现IDE中的方法提示：方法名，返回值，异常——根据反射获取方法结构：");
        Method selfMethods1[] = cls.getMethods();
        for(Method met : selfMethods1)
        {
            int mod = met.getModifiers();
            System.out.print(Modifier.toString(mod) + " ");
            System.out.print(met.getReturnType().getName() + " ");
            System.out.print(met.getName() + "(");
            Class<?> params[] = met.getParameterTypes();
            //System.out.println("params.lentgh=" + params.length);
            for(int x= 0; x < params.length; x++)
            {
                System.out.print(params[x].getName() + " " + "arg-" + x);
                if(x < params.length - 1)
                {
                    System.out.print(",");
                }
            }
            System.out.print(") ");
            
            Class<?> exp[] = met.getExceptionTypes();
            if(exp.length > 0)
            {
                System.out.print("throws ");
            }
            for(int x = 0; x < exp.length; x++)
            {
                System.out.print(exp[x].getName());
                if(x < exp.length -1)
                {
                    System.out.print(",");
                }
            }
            System.out.println();
        }
        
        System.out.println("\n\n反射机制实现setter、getter方法的调用[通过在不导入开发包的情况下实现属性配置][没有任何一个明确的person对象产生，一切依赖反射，避免和具体的类耦合]：");
        Class<?> clsSetGet = Class.forName("cn.mldn.demo.ClassInfoPerson");//不需要导包的实例化方法
                       
        Object objSetGet = clsSetGet.getDeclaredConstructor().newInstance();
        String setMethodName = "setName";//获取方法名称
        String valueName = "Leooooo";   //字段内容
        Method setMethod = clsSetGet.getDeclaredMethod(setMethodName, String.class);//获取指定的方法
        setMethod.invoke(objSetGet, valueName);//等价于  ClassInfoPerson.setName("Leoooo")
        
        String getMethodName = "getName";
        Method getMethod = clsSetGet.getDeclaredMethod(getMethodName);//获取指定的方法
        System.out.println(getMethod.invoke(objSetGet));//等价于 ClassInfoPerson.getName()
              
        System.out.println("\n\nLesson 107 反射调用成员：");
        System.out.println("获取父类中成员：");
        Field fields[] = clsSetGet.getFields();
        for(Field fie:fields)
        {
            System.out.println(fie);
        }
        System.out.println("获取子类中成员：");
        Field subFields[] = clsSetGet.getDeclaredFields();
        for(Field fie:subFields)
        {
            System.out.println(fie);
        }
        
        System.out.println("获取父类中成员：");
        Object setSbj = clsSetGet.getConstructor().newInstance();
        Field nameField = clsSetGet.getDeclaredField("name");
        nameField.setAccessible(true);//解除封装，否则private属性没法访问
        nameField.set(setSbj, "Leoooooooo");//等效于 ClassInfoPerson.name = "Leoooooooo";
        System.out.println(nameField.get(setSbj));//等效于 ClassInfoPerson.name
        
        System.out.println("获取成员类型[最常用]：");
        System.out.println(nameField.getType().getName());//java.lang.String
        System.out.println(nameField.getType().getSimpleName());//String
    }
}
