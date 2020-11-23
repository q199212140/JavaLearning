package cn.mldn.demo;
//
//import java.lang.reflect.Method;
//
//import cn.mldn.util.ClassLoader4ClassLoaderDemo;
//
//class Message4ClassLoaderDemo
//{
//}
//
//public class ClassLoaderDemo
//{
//    public static void main(String[] args) throws Exception
//    {
//        System.out.println("Lesson 6.115 ClassLoader����������:��������ڲ�ͬ�汾֮���в���");
//
//        Class<?> clazz = Message4ClassLoaderDemo.class;
//
//        //��ȡ��ǰ�������
//        System.out.println(clazz.getClassLoader());//sun.misc.Launcher$AppClassLoader@73d16e93   Ӧ�ó��������
//
//        //��ȡ���������
//        System.out.println(clazz.getClassLoader().getParent());//sun.misc.Launcher$ExtClassLoader@15db9742 ƽ̨���������JDK1.8����ǰ��Ϊ��չ���������extĿ¼
//
//        //��ȡ�游�������
//        System.out.println(clazz.getClassLoader().getParent().getParent());//null
//
//
//        System.out.println("\n\nLesson 6.116 �Զ���ClassLoader������");
//        ClassLoader4ClassLoaderDemo selfClassLoader = new ClassLoader4ClassLoaderDemo();
//        Class<?> cls = selfClassLoader.loadData("cn.mldn.util.Message4ClassLoader");
//
//        System.out.println(cls);
//
//        Object obj = cls.getDeclaredConstructor().newInstance();
//        Method method = cls.getDeclaredMethod("send");
//        method.invoke(obj);
//
//    }
//}
