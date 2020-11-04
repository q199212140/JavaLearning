package cn.mldn.demo;

import java.util.Locale;

public class LocaleDemo
{
    public static void main(String[] args)
    {
        System.out.println("\nLesson43:Locale类：");
        Locale loc = new Locale("zh", "CH");
        System.out.println("new zh_CH后的local对象：" + loc);
        
        Locale locDefault = Locale.getDefault();
        System.out.println("获取默认local类：" + locDefault);
        
        //区域常量，优势：避免区域编码信息繁琐
        Locale locChina = Locale.CHINA;
        System.out.println("获取中国local类：" + locChina);
    }
}
