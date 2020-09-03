package cn.mldn.demo;

import java.util.Date;

public class DateProcessDemo
{
    public static void main(String[] args)
    {
        System.out.println("\n日期处理类：");
        Date date = new Date();
        System.out.println(date);
        
        long current = date.getTime();
        current += 864000 *1000;//10天的时间秒数
        System.out.println(new Date(current));
    }
}
