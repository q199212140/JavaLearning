package cn.mldn.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorDemo
{
    public static void main(String[] args)
    {
        System.out.println("Lesson 6.136 ListIterator双向迭代输出：");
        
        List<String> all = new ArrayList<String>();
        all.add("Hello");
        all.add("World");
        all.add("!!!!");
        
        ListIterator<String> iter = all.listIterator();
        System.out.println("由前向后输出：");
        while(iter.hasNext())
        {
            System.out.println(iter.next() + "、");
        }
        
        System.out.println("由后向前输出：");
        while(iter.hasPrevious())
        {
            System.out.println(iter.previous() + "、");
        }
    }
}
