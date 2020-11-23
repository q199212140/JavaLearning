package cn.mldn.demo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapOutViaIteratorDemo {

    public static void main(String[] args) {
        System.out.println("Lesson 5.144.����Iterator���Map����:");

        //����Map����
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("one", 1);
        map.put("two", 2);

        //��Map����ת��ΪSet����
        Set<Map.Entry<String, Integer>> set = map.entrySet();

        //����set�е�iterator������ȡMap.Entry��ͨ��getKey getValue�����ֵ
        Iterator<Map.Entry<String, Integer>> iter = set.iterator();
        System.out.println("\n����Iterator���������");
        while (iter.hasNext()) {
            Map.Entry<String, Integer> me = iter.next();
            System.out.println(me.getKey() + "--" + me.getValue());
        }

        System.out.println("\n����foreach�����");
        for (Map.Entry<String, Integer> entry : set) {
            System.out.println(entry.getKey() + "--" + entry.getValue());
        }
    }
}
