package cn.mldn.demo;

import java.util.List;

public class ListInterfaceIntroductionDemo
{
    public static void main(String[] args)
    {
        System.out.println("Lesson 6.125 List接口简介");
        
        List<String> all = List.of("Hello", "你好", "饿了么", "World", "！");
        System.out.println(all);
        
        Object result[] = all.toArray();
        for(Object temp : result)
        {
            System.out.print(temp + "、");
        }
    }
}
