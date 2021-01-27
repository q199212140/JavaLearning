package cn.mldn.demo;

import java.util.ArrayList;
import java.util.List;

public class ForeachDemo {

    public static void main(String[] args) {
        System.out.println("Lesson 6.138 foreach�����");

        List<String> all = new ArrayList<String>();
        all.add("Hello");
        all.add("World");
        all.add("!!!!");

        for (String str : all) {
            System.out.println(str + "��");
        }
    }
}
