package cn.mldn.demo;

import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo
{
    public static void main(String[] args)
    {
        System.out.println("Lesson 6.126.ArrayList子类：");
        
        System.out.println("保存的顺序就是存储顺序，List集合支持重复数据：");
        List<String> all = new ArrayList<String>();
        
        System.out.println("结合是否为空：" + all.isEmpty() + "、集合元素个数：" + all.size());
        all.add("Hello");
        all.add("Hello");//支持重复数据存储
        all.add("yyy");//支持重复数据存储
        all.add("Leooooo");
        all.add("!!!!!");
        all.remove("yyy");
        
        System.out.println("结合是否为空：" + all.isEmpty() + "、集合元素个数：" + all.size());
        
        System.out.println(all);

        System.out.println("\n一种非主流的输出：");
        all.forEach((str)->{
            System.out.print(str + "、");
        });
    }
}
