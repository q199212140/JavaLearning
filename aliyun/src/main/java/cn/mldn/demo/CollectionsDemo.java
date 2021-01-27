package cn.mldn.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsDemo {

    public static void main(String[] args) {
        System.out.println("Lesson 5.149.Collections������:");

        List<String> all = new ArrayList<String>();

        System.out.println("���ArrayList��");
        Collections.addAll(all, "Hello", "World", "!!!");
        System.out.println(all);

        System.out.println("\n���ݷ�ת��");
        Collections.reverse(all);
        System.out.println(all);

        System.out.println("\n���ֲ��ң�");
        Collections.sort(all);
        System.out.println(all);
        System.out.println(Collections.binarySearch(all, "Hello"));
    }
}
