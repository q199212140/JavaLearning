package cn.mldn.demo;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleDemo
{
    public static void main(String[] args)
    {
        System.out.println("课时44 ResourceBundle读取资源文件:");
        
        //根据不同的语言环境，实现指定区域的内容接收
        //Locale loc1 = new Locale("en", "US");
        Locale loc1 = new Locale("cn", "ZH");
        //文件名称必须为.properties，读的时候不加入文件后缀
        //获取资源对象：顺序：指定区域 > 默认本地资源 > 公共资源
        ResourceBundle resource4ResourceBundle = ResourceBundle.getBundle("cn.mldn.message.testProperties", loc1);
        //读取资源内容
        String val =  resource4ResourceBundle.getString("welcomeStr");
        System.out.println(val);
        
        //带占位符的资源文件，占位符必须做格式化处理
        String valInfo =  resource4ResourceBundle.getString("info"); 
        System.out.println(MessageFormat.format(valInfo, "mldn", new SimpleDateFormat("yyyy-MM-dd").format(new Date())));
        
    }
}
