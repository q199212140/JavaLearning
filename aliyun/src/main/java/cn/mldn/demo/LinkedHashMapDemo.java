package cn.mldn.demo;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapDemo {

    public static void main(String[] args) {
        System.out.println("Lesson 5.141 LinkedHashMap���ࣺ�����������");

        Map<String, Integer> map = new LinkedHashMap<String, Integer>();

        map.put("one", 1);
        map.put("one", 11);//key�ظ������Ǿ�key
        map.put("two", 2);
        map.put("three", 3);
        map.put(null, 0);
        map.put("zero", null);

        System.out.println(map.put("four", 4));//key���ظ����ؿ�
        System.out.println(map.put("four", 44));//key�ظ������ؾ�value

        System.out.println(map);
        System.out.println(map.get("one"));
        System.out.println(map.get("ten"));//�����ڵ�key��ѯ
        System.out.println(map.get(null));//���ڵ�key��ѯ
    }
}
