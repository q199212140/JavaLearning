package cn.mldn.demo;

import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo {

    public static void main(String[] args) {
        System.out.println("Lesson 6.126.ArrayList���ࣺ");

        System.out.println("�����˳����Ǵ洢˳��List����֧���ظ����ݣ�");
        List<String> all = new ArrayList<String>();

        System.out.println("����Ƿ�Ϊ�գ�" + all.isEmpty() + "������Ԫ�ظ�����" + all.size());
        all.add("Hello");
        all.add("Hello");//֧���ظ����ݴ洢
        all.add("yyy");//֧���ظ����ݴ洢
        all.add("Leooooo");
        all.add("!!!!!");
        all.remove("yyy");

        System.out.println("����Ƿ�Ϊ�գ�" + all.isEmpty() + "������Ԫ�ظ�����" + all.size());

        System.out.println(all);

        System.out.println("\nһ�ַ������������");
        all.forEach((str) -> {
            System.out.print(str + "��");
        });
    }
}
