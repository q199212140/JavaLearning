package cn.mldn.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorDemo {

    public static void main(String[] args) {
        System.out.println("Lesson 6.136 ListIterator˫����������");

        List<String> all = new ArrayList<String>();
        all.add("Hello");
        all.add("World");
        all.add("!!!!");

        ListIterator<String> iter = all.listIterator();
        System.out.println("��ǰ��������");
        while (iter.hasNext()) {
            System.out.println(iter.next() + "��");
        }

        System.out.println("�ɺ���ǰ�����");
        while (iter.hasPrevious()) {
            System.out.println(iter.previous() + "��");
        }
    }
}
