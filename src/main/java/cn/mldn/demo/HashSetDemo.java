package cn.mldn.demo;

import java.util.HashSet;
import java.util.Set;

public class HashSetDemo
{
    public static void main(String[] args)
    {
        System.out.println("Lesson 6.131 Set接口简介：");
        
        //Set集合数据保存，设置重复内容 JDK1.9支持
        Set<String> all = new HashSet<String>();
        all.add("Hello");
        all.add("Hello");
        all.add("World");
        all.add("Leooo");
        all.add("!!!");
        
        all.forEach(System.out::println);
        
        /*结果：无序的，无重复的
         * Lesson 6.130 Set接口简介：
        !!!
        Hello
        Leooo
        World
         * */
    }
}
