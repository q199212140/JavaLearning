package cn.mldn.demo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapOutViaIteratorDemo
{
    public static void main(String[] args)
    {
        System.out.println("Lesson 5.144.利用Iterator输出Map集合:");
        
        //生成Map集合
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("one", 1);
        map.put("two", 2);
        
        //将Map集合转化为Set集合
        Set<Map.Entry<String, Integer>> set = map.entrySet();
        
        //利用set中的iterator迭代读取Map.Entry并通过getKey getValue输出键值
        Iterator<Map.Entry<String, Integer>> iter = set.iterator();
        System.out.println("\n利用Iterator迭代输出：");
        while(iter.hasNext())
        {
            Map.Entry<String, Integer> me = iter.next();
            System.out.println(me.getKey() + "--" + me.getValue());
        }
        
        System.out.println("\n利用foreach输出：");
        for(Map.Entry<String, Integer> entry : set)
        {
            System.out.println(entry.getKey() + "--" + entry.getValue());
        }
    }
}
