package cn.mldn.demo;

import java.util.List;
import java.util.Vector;

public class VectorDemo {

    public static void main(String[] args) {
        System.out.println("Lesson 6.129.Vector���ࣺ");

        System.out.println("�����˳����Ǵ洢˳��List����֧���ظ����ݣ�");
        List<String> all = new Vector<String>();

        System.out.println("����Ƿ�Ϊ�գ�" + all.isEmpty() + "������Ԫ�ظ�����" + all.size());
        all.add("Hello");
        all.add("Hello");//֧���ظ����ݴ洢
        all.add("yyy");//֧���ظ����ݴ洢
        all.add("Leooooo");
        all.add("!!!!!");
        all.add(null);
        all.remove("yyy");

        System.out.println("����Ƿ�Ϊ�գ�" + all.isEmpty() + "������Ԫ�ظ�����" + all.size());

        System.out.println(all);

        System.out.println("get(2) :" + all.get(2));

        all.forEach(System.out::println);//�������ô��������ͽӿ�

    }
}
