package cn.mldn.demo;

import java.util.Enumeration;
import java.util.Vector;

public class EnumerationDemo {

    public static void main(String[] args) {
        System.out.println("Lesson 6.137 Enumerationö�������");

        Vector<String> all = new Vector<String>();
        all.add("Hello");
        all.add("World");
        all.add("!!!!");

        Enumeration<String> enu = all.elements();
        while (enu.hasMoreElements()) {
            String str = enu.nextElement();
            System.out.println(str);
        }

    }
}
