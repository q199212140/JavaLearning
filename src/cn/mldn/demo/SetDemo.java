package cn.mldn.demo;

import java.util.Set;

public class SetDemo
{
    public static void main(String[] args)
    {
        System.out.println("Lesson 6.130 Set接口简介：");
        
        //Set集合数据保存，设置重复内容 JDK1.9支持
        Set<String> all = Set.of("Hello", "Hello1", "world", "!", "!!");
    }
}
