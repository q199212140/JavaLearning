package cn.mldn.demo;

import java.util.LinkedList;
import java.util.List;

public class LinkedListDemo
{
    public static void main(String[] args)
    {        
        System.out.println("Lesson 6.128.ArrayList子类：");
        
        System.out.println("保存的顺序就是存储顺序，List集合支持重复数据：");
        List<String> all = new LinkedList<String>();
        
        System.out.println("结合是否为空：" + all.isEmpty() + "、集合元素个数：" + all.size());
        all.add("Hello");
        all.add("Hello");//支持重复数据存储
        all.add("yyy");//支持重复数据存储
        all.add("Leooooo");
        all.add("!!!!!");
        all.add(null);
        all.remove("yyy");
       
        System.out.println("结合是否为空：" + all.isEmpty() + "、集合元素个数：" + all.size());
        
        System.out.println(all);

        System.out.println("get(2) :" + all.get(2));
        
        all.forEach(System.out::println);//方法引用代替消费型接口
        
    }
}
