package cn.mldn.older;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

class MessageUtil {

    public static final int CHINA = 1;
    public static final int USA = 2;

    //private static final String KEY = "info";

    public static Locale getLocale(int num) {
        switch (num) {
            case CHINA:
                return new Locale("zh", "CN");

            case USA:
                return new Locale("en", "US");

            default:
                return null;
        }
    }
}

public class StateCodeCase {

    public static void main(String[] args) {
        System.out.println("Lesson 64 : ���Ҵ��� ��ִ�й��ʻ�Ӧ�ã���������������Ҵ��� 1�й� 2���������ݹ��Ҵ�����ʾ��ͬ��Դ�ļ�");

        if (args.length != 1) {
            System.out.println("invalid input : state code 1-china, 2-usa\n");
            System.exit(1);
            ;
        }

        //���ݲ�ͬ�����Ի�����ʵ��ָ����������ݽ���
        //Locale loc1 = new Locale("en", "US");
        //Locale loc1 = new Locale("cn", "ZH");
        Locale loc = MessageUtil.getLocale(Integer.parseInt(args[0]));

        //�ļ����Ʊ���Ϊ.properties������ʱ�򲻼����ļ���׺
        //��ȡ��Դ����˳��ָ������ > Ĭ�ϱ�����Դ > ������Դ
        ResourceBundle resource4ResourceBundle = ResourceBundle.getBundle("cn.mldn.message.testProperties", loc);
        //��ȡ��Դ����
        String val = resource4ResourceBundle.getString("welcomeStr");
        System.out.println(val);

        //��ռλ������Դ�ļ���ռλ����������ʽ������
        String valInfo = resource4ResourceBundle.getString("info");
        System.out
            .println(MessageFormat.format(valInfo, "mldn", new SimpleDateFormat("yyyy-MM-dd").format(new Date())));

    }
}
