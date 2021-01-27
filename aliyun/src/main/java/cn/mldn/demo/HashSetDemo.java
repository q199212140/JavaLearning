package cn.mldn.demo;

import java.util.HashSet;
import java.util.Set;

public class HashSetDemo {

    public static void main(String[] args) {
        System.out.println("Lesson 6.131 Set�ӿڼ�飺");

        //Set�������ݱ��棬�����ظ����� JDK1.9֧��
        Set<String> all = new HashSet<String>();
        all.add("Hello");
        all.add("Hello");
        all.add("World");
        all.add("Leooo");
        all.add("!!!");

        all.forEach(System.out::println);
        
        /*���������ģ����ظ���
         * Lesson 6.130 Set�ӿڼ�飺
        !!!
        Hello
        Leooo
        World
         * */
    }
}
