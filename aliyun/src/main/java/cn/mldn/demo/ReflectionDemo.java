package cn.mldn.demo;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

class Person {

}

public class ReflectionDemo {

    public static void main(String[] args)
        throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
        System.out.println("Lesson 6.99 ������ƣ�");

        System.out.println("ͨ������ʵ���������ȡ�������ͣ�");
        Date date = new Date();
        System.out.println(date.getClass());//����ʵ���������ҵ�������������

        System.out.println("����һ��object getName�ӿڣ��������Ѿ�ʵ�����Ķ���");
        Person per = new Person();
        Class<? extends Person> cls1 = per.getClass();
        System.out.println(cls1);//class cn.mldn.demo.Person
        System.out.println(cls1.getName());//cn.mldn.demo.Person ����������

        System.out.println("\n ������������ ��.class ��ʽʵ����[JVM֧�ֵĻ��ƣ�����Ҫ��ǰ����ʵ����������Ҫ�����Ӧ�İ�]��");
        Class<? extends Person> cls2 = Person.class;
        System.out.println(cls2.getName());//

        System.out.println("\n������������ class��֧�֣������ַ�������Ҫʹ�õ��࣬�����в���Ҫimport���̣�");
        Class<?> cls3 = Class.forName("cn.mldn.demo.testPerson.Person");
        System.out.println(cls3.getName());//

        System.out.println("\nͨ��newInstance����ʵ��������[JDK1.9�󱻷ϳ�]���� new ����� �滻Ϊ  �ַ���+newInstance");
        //Object obj = cls3.newInstance();//ͨ������ʵ�ֵĶ���ʵ����������ȻҪ�������е��޲ι��췽��
        Object obj = cls3.getDeclaredConstructor().newInstance();//JDK1.9֮��
        System.out.println(obj);
    }
}
