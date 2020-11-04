package cn.mldn.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesDemo
{
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        System.out.println("Lesson 5.148. Properties属性操作：");
        
        System.out.println("普通功能：key-value形式存取(like Map)，但仅支持字符串：");
        Properties prop = new Properties();
        
        prop.setProperty("key-hello", "value-world");
        prop.setProperty("key-hello", "value-leo");
        prop.setProperty("key-BeiJing", "value-北京");
        
        System.out.println(prop.getProperty("key-hello"));
        System.out.println(prop.getProperty("sina", "Not-Found"));
        System.out.println(prop.getProperty("sina"));
        
        System.out.println("\n流功能：将属性内容保存在文件中：");
        prop.store(new FileOutputStream(new File("D:" + File.separator + "test" + File.separator + "info.properties")), "中文的注释看不见-English is OK");
    
        System.out.println("\n读取资源(一般读取配置资源)：");
        Properties propLoad = new Properties();
        propLoad.load(new FileInputStream(new File("D:" + File.separator + "test" + File.separator + "info.properties")));
        System.out.println(propLoad.getProperty("key-hello"));
        System.out.println(propLoad.getProperty("key-BeiJing"));
    }
}
