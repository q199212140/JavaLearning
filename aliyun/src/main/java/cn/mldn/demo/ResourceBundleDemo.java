package cn.mldn.demo;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleDemo {

    public static void main(String[] args) {
        System.out.println("��ʱ44 ResourceBundle��ȡ��Դ�ļ�:");

        //���ݲ�ͬ�����Ի�����ʵ��ָ����������ݽ���
        //Locale loc1 = new Locale("en", "US");
        Locale loc1 = new Locale("cn", "ZH");
        //�ļ����Ʊ���Ϊ.properties������ʱ�򲻼����ļ���׺
        //��ȡ��Դ����˳��ָ������ > Ĭ�ϱ�����Դ > ������Դ
        ResourceBundle resource4ResourceBundle = ResourceBundle.getBundle("cn.mldn.message.testProperties", loc1);
        //��ȡ��Դ����
        String val = resource4ResourceBundle.getString("welcomeStr");
        System.out.println(val);

        //��ռλ������Դ�ļ���ռλ����������ʽ������
        String valInfo = resource4ResourceBundle.getString("info");
        System.out
            .println(MessageFormat.format(valInfo, "mldn", new SimpleDateFormat("yyyy-MM-dd").format(new Date())));

    }
}
