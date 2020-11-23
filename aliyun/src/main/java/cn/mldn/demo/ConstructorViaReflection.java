package cn.mldn.demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ConstructorViaReflection {

    public static void main(String[] args) throws Exception {
        System.out.println("Lesson 6.105 ������ù��췽����");

        Class<?> cls = ClassInfoPerson.class;//��ȡָ�����Class����

        System.out.println("��ȡȫ�����췽����");
        Constructor<?>[] constructors = cls.getDeclaredConstructors();
        for (Constructor<?> cons : constructors) {
            System.out.println(cons);
        }

        System.out.println("ͨ���вι���ʵ����������");
        Constructor<?> constructor1 = cls.getConstructor(String.class, int.class);
        Object obj = constructor1.newInstance("leo", 22);
        System.out.println(obj);

        System.out.println("\n\nLesson 6.106 ���������ͨ������");
        System.out.println("��ȡȫ������(�������෽��)��");
        Method allMethods[] = cls.getMethods();
        for (Method met : allMethods) {
            System.out.println(met);
        }

        System.out.println("��ȡȫ������(�������෽��)��");
        Method selfMethods[] = cls.getDeclaredMethods();
        for (Method met : selfMethods) {
            System.out.println(met);
        }

        System.out.println("\n\nģ��ʵ��IDE�еķ�����ʾ��������������ֵ���쳣�������ݷ����ȡ�����ṹ��");
        Method selfMethods1[] = cls.getMethods();
        for (Method met : selfMethods1) {
            int mod = met.getModifiers();
            System.out.print(Modifier.toString(mod) + " ");
            System.out.print(met.getReturnType().getName() + " ");
            System.out.print(met.getName() + "(");
            Class<?> params[] = met.getParameterTypes();
            //System.out.println("params.lentgh=" + params.length);
            for (int x = 0; x < params.length; x++) {
                System.out.print(params[x].getName() + " " + "arg-" + x);
                if (x < params.length - 1) {
                    System.out.print(",");
                }
            }
            System.out.print(") ");

            Class<?> exp[] = met.getExceptionTypes();
            if (exp.length > 0) {
                System.out.print("throws ");
            }
            for (int x = 0; x < exp.length; x++) {
                System.out.print(exp[x].getName());
                if (x < exp.length - 1) {
                    System.out.print(",");
                }
            }
            System.out.println();
        }

        System.out.println(
            "\n\n�������ʵ��setter��getter�����ĵ���[ͨ���ڲ����뿪�����������ʵ����������][û���κ�һ����ȷ��person���������һ���������䣬����;���������]��");
        Class<?> clsSetGet = Class.forName("cn.mldn.demo.ClassInfoPerson");//����Ҫ������ʵ��������

        Object objSetGet = clsSetGet.getDeclaredConstructor().newInstance();
        String setMethodName = "setName";//��ȡ��������
        String valueName = "Leooooo";   //�ֶ�����
        Method setMethod = clsSetGet.getDeclaredMethod(setMethodName, String.class);//��ȡָ���ķ���
        setMethod.invoke(objSetGet, valueName);//�ȼ���  ClassInfoPerson.setName("Leoooo")

        String getMethodName = "getName";
        Method getMethod = clsSetGet.getDeclaredMethod(getMethodName);//��ȡָ���ķ���
        System.out.println(getMethod.invoke(objSetGet));//�ȼ��� ClassInfoPerson.getName()

        System.out.println("\n\nLesson 107 ������ó�Ա��");
        System.out.println("��ȡ�����г�Ա��");
        Field fields[] = clsSetGet.getFields();
        for (Field fie : fields) {
            System.out.println(fie);
        }
        System.out.println("��ȡ�����г�Ա��");
        Field subFields[] = clsSetGet.getDeclaredFields();
        for (Field fie : subFields) {
            System.out.println(fie);
        }

        System.out.println("��ȡ�����г�Ա��");
        Object setSbj = clsSetGet.getConstructor().newInstance();
        Field nameField = clsSetGet.getDeclaredField("name");
        nameField.setAccessible(true);//�����װ������private����û������
        nameField.set(setSbj, "Leoooooooo");//��Ч�� ClassInfoPerson.name = "Leoooooooo";
        System.out.println(nameField.get(setSbj));//��Ч�� ClassInfoPerson.name

        System.out.println("��ȡ��Ա����[���]��");
        System.out.println(nameField.getType().getName());//java.lang.String
        System.out.println(nameField.getType().getSimpleName());//String
    }
}
