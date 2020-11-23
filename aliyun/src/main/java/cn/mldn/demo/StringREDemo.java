package cn.mldn.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class StringREDemo {

    public static void main(String[] args) throws ParseException {
        System.out.println("String��������֧�֣�");

        System.out.println("\nɾ���ַ����еķ���ĸ�����֣�");
        String str4StringREDemo = "!@#$QWERTYU123456$RF4r5$R^YUIKO)P{edasd12346";
        String regex4StringREDemo = "[^a-zA-Z0-9]+";//���򣺷���ĸ����
        System.out.println(str4StringREDemo.replaceAll(regex4StringREDemo, ""));

        System.out.println("\n�����ֲ�֣�");
        String str4StringREDemo1 = "a1b22c333d444e55555f666666";
        String regex4StringREDemo1 = "\\d+";//��������
        //"\\d" :a��b����c������d������e����������f��
        //"\\d" :a��b��c��d��e��f��

        String result4StringREDemo[] = str4StringREDemo1.split(regex4StringREDemo1);
        for (int x = 0; x < result4StringREDemo.length; x++) {
            System.out.print(result4StringREDemo[x] + "��");
        }

        System.out.println("\n�ж����봮�Ƿ�ΪС��������ǣ�ת����double��");
        String str4StringREDemo2 = "100.1";
        String regex4StringREDemo2 = "\\d+(\\\\.\\\\d+)?";//����С�����С��Ҫôһ����֣�Ҫô��������
        System.out.println(str4StringREDemo2.matches(regex4StringREDemo2));

        System.out.println("\n�ж��ַ����Ƿ���������ɣ�����ǣ�ת����Date���ͣ�");
        System.out.println("\n�����жϾ��庬�壬ֻ�ܶԸ�ʽ�ж�");
        String str4StringREDemo3 = "1989-12-15";
        String regex4StringREDemo3 = "\\d{4}-\\d{2}-\\d{2}";//����
        if (str4StringREDemo3.matches(regex4StringREDemo3)) {
            System.out.println(new SimpleDateFormat("yyyy-MM-dd").parse(str4StringREDemo3));
        }

        System.out.println("\n�жϸ����绰�Ƿ���ȷ[51283346��01051283346��(010)-51283346]��");
        String str4StringREDemo4 = "(010)-51283346";
        //51283346  \\d{7,8}
        //01051283346  (\\\\d{3,4})?\\d{7,8}
        //(010)-51283346    \\( \\d{3,4} \\)
        String regex4StringREDemo4 = "((\\d{3,4})|(\\(\\d{3,4}\\))-)?\\d{7,8}";//����
        System.out.println(str4StringREDemo4.matches(regex4StringREDemo4));

        System.out.println(
            "\n��֤email��ַ��ʽ[�û�������ĸ�����֡��»��� -  ��������ĸ�������»��� - ��׺��.cn��.com��.net��.com.cn��.gov �����»��߿�ͷ]��");
        // ������ĸ���ֿ�ͷ�� ����Ϊ ��ĸ�����֡��»��� -
        // @
        // ������  ��ĸ�����֡��»��� -
        // .
        //���� cn|com|com.cn|net|gov   
        String str4StringREDemo5 = "648781262@qq.com";
        String regex4StringREDemo5 = "[0-9a-zA-Z]\\w+@\\w+\\.(cn|com|com.cn|net|gov)";//����
        System.out.println(str4StringREDemo5.matches(regex4StringREDemo5));

    }
}
