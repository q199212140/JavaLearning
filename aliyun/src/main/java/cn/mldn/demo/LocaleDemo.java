package cn.mldn.demo;

import java.util.Locale;

public class LocaleDemo {

    public static void main(String[] args) {
        System.out.println("\nLesson43:Locale�ࣺ");
        Locale loc = new Locale("zh", "CH");
        System.out.println("new zh_CH���local����" + loc);

        Locale locDefault = Locale.getDefault();
        System.out.println("��ȡĬ��local�ࣺ" + locDefault);

        //�����������ƣ��������������Ϣ����
        Locale locChina = Locale.CHINA;
        System.out.println("��ȡ�й�local�ࣺ" + locChina);
    }
}
