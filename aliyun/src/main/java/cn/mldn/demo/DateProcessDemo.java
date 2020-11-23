package cn.mldn.demo;

import java.util.Date;

public class DateProcessDemo {

    public static void main(String[] args) {
        System.out.println("\n���ڴ����ࣺ");
        Date date = new Date();
        System.out.println(date);

        long current = date.getTime();
        current += 864000 * 1000;//10���ʱ������
        System.out.println(new Date(current));
    }
}
