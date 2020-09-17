package cn.mldn.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class StringREDemo
{
    public static void main(String[] args) throws ParseException
    {
        System.out.println("String类对正则的支持：");
        
        System.out.println("\n删除字符串中的非字母和数字：");
        String str4StringREDemo = "!@#$QWERTYU123456$RF4r5$R^YUIKO)P{edasd12346";
        String regex4StringREDemo = "[^a-zA-Z0-9]+";//正则：非字母数字
        System.out.println(str4StringREDemo.replaceAll(regex4StringREDemo, ""));
        
        System.out.println("\n按数字拆分：");
        String str4StringREDemo1 = "a1b22c333d444e55555f666666";
        String regex4StringREDemo1 = "\\d+";//正则：数字
        //"\\d" :a、b、、c、、、d、、、e、、、、、f、
        //"\\d" :a、b、c、d、e、f、
        
        String result4StringREDemo[] = str4StringREDemo1.split(regex4StringREDemo1);
        for(int x = 0; x < result4StringREDemo.length; x++)
        {
            System.out.print(result4StringREDemo[x] + "、");
        }
        
        System.out.println("\n判断输入串是否为小数，如果是，转换成double：");
        String str4StringREDemo2 = "100.1";
        String regex4StringREDemo2 = "\\d+(\\\\.\\\\d+)?";//正则：小数点和小数要么一起出现，要么都不出现
        System.out.println(str4StringREDemo2.matches(regex4StringREDemo2));
        
        System.out.println("\n判断字符串是否由日期组成，如果是，转换成Date类型：");
        System.out.println("\n正则不判断具体含义，只能对格式判断");
        String str4StringREDemo3 = "1989-12-15";
        String regex4StringREDemo3 = "\\d{4}-\\d{2}-\\d{2}";//正则
        if(str4StringREDemo3.matches(regex4StringREDemo3))
        {
            System.out.println(new SimpleDateFormat("yyyy-MM-dd").parse(str4StringREDemo3));
        }
        
        System.out.println("\n判断给定电话是否正确[51283346、01051283346、(010)-51283346]：");
        String str4StringREDemo4 = "(010)-51283346";
        //51283346  \\d{7,8}
        //01051283346  (\\\\d{3,4})?\\d{7,8}
        //(010)-51283346    \\( \\d{3,4} \\)
        String regex4StringREDemo4 = "((\\d{3,4})|(\\(\\d{3,4}\\))-)?\\d{7,8}";//正则
        System.out.println(str4StringREDemo4.matches(regex4StringREDemo4));
        
        System.out.println("\n验证email地址格式[用户名：字母、数字、下划线 -  域名：字母、数字下划线 - 后缀：.cn、.com、.net、.com.cn、.gov 不以下划线开头]：");
        // 名称字母数字开头， 主体为 字母、数字、下划线 -
        // @
        // 邮箱名  字母、数字、下划线 -
        // .
        //域名 cn|com|com.cn|net|gov   
        String str4StringREDemo5 = "648781262@qq.com";
        String regex4StringREDemo5 = "[0-9a-zA-Z]\\w+@\\w+\\.(cn|com|com.cn|net|gov)";//正则
        System.out.println(str4StringREDemo5.matches(regex4StringREDemo5));
        
    }
}
