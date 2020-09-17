package cn.mldn.demo;

public class ClassInfoViaReflection
{
    public static void main(String[] args)
    {
        System.out.println("Lesson 6.104 反射获取类结构信息");
        
        Class<?> cls = ClassInfoPerson.class;//获取指定类的Class对象
        
        Package pack = cls.getPackage();
        System.out.println("包名称：" + pack.getName());//cn.mldn.demo
        
        Class<?> parent = cls.getSuperclass();
        System.out.println("父类：" + parent.getName());
        System.out.println("父类的父类：" + parent.getSuperclass().getName());
        
        System.out.println("\n父接口：一个类的对象确定后，可以获取此类中的一切继承结构信息：");
        Class<?> classInterface[] = cls.getInterfaces();
        for(Class<?> temp : classInterface)
        {
            System.out.println(temp.getName());
        }
    }
}
