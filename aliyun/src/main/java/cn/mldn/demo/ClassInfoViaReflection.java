package cn.mldn.demo;

public class ClassInfoViaReflection {

    public static void main(String[] args) {
        System.out.println("Lesson 6.104 �����ȡ��ṹ��Ϣ");

        Class<?> cls = ClassInfoPerson.class;//��ȡָ�����Class����

        Package pack = cls.getPackage();
        System.out.println("�����ƣ�" + pack.getName());//cn.mldn.demo

        Class<?> parent = cls.getSuperclass();
        System.out.println("���ࣺ" + parent.getName());
        System.out.println("����ĸ��ࣺ" + parent.getSuperclass().getName());

        System.out.println("\n���ӿڣ�һ����Ķ���ȷ���󣬿��Ի�ȡ�����е�һ�м̳нṹ��Ϣ��");
        Class<?> classInterface[] = cls.getInterfaces();
        for (Class<?> temp : classInterface) {
            System.out.println(temp.getName());
        }
    }
}
