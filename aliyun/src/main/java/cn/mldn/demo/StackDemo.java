package cn.mldn.demo;

import java.util.Stack;

public class StackDemo {

    public static void main(String[] args) {
        System.out.println("Lesson 5.146 Stackջ�������Ƚ������");

        Stack<String> all = new Stack<String>();

        all.push("A");
        all.push("B");
        all.push("C");

        System.out.println(all.pop());
        System.out.println(all.pop());
        System.out.println(all.pop());
        //System.out.println(all.pop());//Exception in thread "main" java.util.EmptyStackException
    }
}
