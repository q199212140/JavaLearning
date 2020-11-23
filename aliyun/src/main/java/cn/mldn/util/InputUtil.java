package cn.mldn.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class InputUtil {

    private static final BufferedReader INPUT = new BufferedReader(new InputStreamReader(System.in));

    private InputUtil() {
    }

    public static String getString(String prompt) {
        String str = null;
        boolean flag = true;
        while (flag) {
            System.out.println(prompt);
            try {
                str = INPUT.readLine();
                if (!"".equals(str)) {
                    flag = false;
                } else {
                    System.out.println("��������ݲ���Ϊ�գ��������룡");
                }
            } catch (IOException e) {
                System.out.println("��������ݲ���Ϊ�գ��������룡");
            }
        }
        return str;
    }

    /**
     * ʵ�ּ��̽������ֵĲ���
     *
     * @param prompt ��ʾ��Ϣ
     * @return һ������ʹ�õ�����
     */
    public static int getInt(String prompt) {
        int num = 0;
        boolean flag = true;

        while (flag) {
            System.out.println(prompt);
            String str = null;
            try {
                str = INPUT.readLine();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            if (str.matches("\\d+")) {
                num = Integer.parseInt(str);
                flag = false;
            } else {
                System.out.println("��������ݲ������֣��������룡");
            }
        }

        return num;
    }
}
