package cn.mldn.demo;
import java.lang.reflect.Field;
//import sun.misc.Unsafe;

class UnsafeSingleton
{
    private UnsafeSingleton()
    {
        System.out.println("私有化的构造方法！");
    }
    
    public void print()
    {
        System.out.println("hello world from singleton!");
    }
}

public class UnsafeDemo
{
    public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, InstantiationException
    {
        System.out.println("Lesson 6.108 Unsafe工具类:利用Unsafe类绕过JVM管理机制，可在没有实例化对象的情况下获取单例实例化对象");
        
//        Field field = Unsafe.class.getDeclaredField("theUnsafe");
//        field.setAccessible(true);
//        Unsafe unsafeObject = (Unsafe)field.get(null);
//        UnsafeSingleton instance = (UnsafeSingleton) unsafeObject.allocateInstance(UnsafeSingleton.class);
//        instance.print();
    }
}
