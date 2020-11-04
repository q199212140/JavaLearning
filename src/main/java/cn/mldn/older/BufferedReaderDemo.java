package cn.mldn.older;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedReaderDemo
{
    public static void main(String[] args) throws IOException 
    {
        System.out.println("Lesson 6.86 BufferedReader缓冲输入流，实现键盘数据输入");
        
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入信息：");
        String msg = input.readLine();
        System.out.println(msg);
                
        System.out.println("请输入年龄：");
        //String接收输入内容，可以进行方便的后续操作
        msg = input.readLine();
        if(msg.matches("\\d{1,3}"))
        {
            int age = Integer.parseInt(msg);
            System.out.println("输入的年龄为：" + age);
        }
        else
        {
            System.out.println("请输入正确的年龄！");
        }
    }
}
