package cn.mldn.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesDemo {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        System.out.println("Lesson 5.148. Properties���Բ�����");

        System.out.println("��ͨ���ܣ�key-value��ʽ��ȡ(like Map)������֧���ַ�����");
        Properties prop = new Properties();

        prop.setProperty("key-hello", "value-world");
        prop.setProperty("key-hello", "value-leo");
        prop.setProperty("key-BeiJing", "value-����");

        System.out.println(prop.getProperty("key-hello"));
        System.out.println(prop.getProperty("sina", "Not-Found"));
        System.out.println(prop.getProperty("sina"));

        System.out.println("\n�����ܣ����������ݱ������ļ��У�");
        prop.store(new FileOutputStream(new File("D:" + File.separator + "test" + File.separator + "info.properties")),
            "���ĵ�ע�Ϳ�����-English is OK");

        System.out.println("\n��ȡ��Դ(һ���ȡ������Դ)��");
        Properties propLoad = new Properties();
        propLoad
            .load(new FileInputStream(new File("D:" + File.separator + "test" + File.separator + "info.properties")));
        System.out.println(propLoad.getProperty("key-hello"));
        System.out.println(propLoad.getProperty("key-BeiJing"));
    }
}
