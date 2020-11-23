package cn.mldn.demo;

import java.lang.reflect.Field;
//import sun.misc.Unsafe;

class UnsafeSingleton {

    private UnsafeSingleton() {
        System.out.println("˽�л��Ĺ��췽����");
    }

    public void print() {
        System.out.println("hello world from singleton!");
    }
}

public class UnsafeDemo {

    public static void main(String[] args)
        throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, InstantiationException {
        System.out.println("Lesson 6.108 Unsafe������:����Unsafe���ƹ�JVM������ƣ�����û��ʵ�������������»�ȡ����ʵ��������");

//        Field field = Unsafe.class.getDeclaredField("theUnsafe");
//        field.setAccessible(true);
//        Unsafe unsafeObject = (Unsafe)field.get(null);
//        UnsafeSingleton instance = (UnsafeSingleton) unsafeObject.allocateInstance(UnsafeSingleton.class);
//        instance.print();
    }
}
