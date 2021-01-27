package cn.mldn.demo;

import java.util.Arrays;

import cn.mldn.demo.factory.StudentFactory;
import cn.mldn.demo.menu.DataRankMenu;

public class DataRankDemo {

    public static void main(String[] args) {
        System.out.println("Lesson 6.94 ����������");

        //System.out.println(Arrays.toString(StudentFactory.getInstance().getData()));
        new DataRankMenu();
    }
}
