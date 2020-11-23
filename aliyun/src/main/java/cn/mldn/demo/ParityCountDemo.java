package cn.mldn.demo;

import java.util.Arrays;

import cn.mldn.demo.factory.Factory;

public class ParityCountDemo {

    public static void main(String[] args) {
        System.out.println("Lesson 6.96 ��ż��ͳ��");

        System.out.println(Arrays.toString(Factory.getInstance().countParity()));

    }
}
