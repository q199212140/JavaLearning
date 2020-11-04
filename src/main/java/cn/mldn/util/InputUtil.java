package cn.mldn.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class InputUtil
{
    private static final BufferedReader INPUT = new  BufferedReader(new InputStreamReader(System.in));
    
    private InputUtil() {}
    
    public static String getString(String prompt)
    {
        String str = null;
        boolean flag = true;
        while(flag)
        {
            System.out.println(prompt);
            try
            {
                str = INPUT.readLine();
                if (!"".equals(str))
                {                
                    flag = false;
                }
                else
                {
                    System.out.println("输入的内容不能为空！重新输入！");
                }           
            } catch (IOException e)
            {
                System.out.println("输入的内容不能为空！重新输入！");
            }
        }
        return str;
    }
    
    /**
     * 实现键盘接收数字的操作
     * @param prompt 提示信息
     * @return 一个可以使用的数字
     */
    public static int getInt(String prompt)
    {
        int num = 0;
        boolean flag = true;
        
        while(flag)
        {           
            System.out.println(prompt);
            String str = null;
            try
            {
                str = INPUT.readLine();
            } catch (IOException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            if (str.matches("\\d+"))
            {                
                num = Integer.parseInt(str);
                flag = false;
            }
            else
            {
                System.out.println("输入的内容不是数字！重新输入！");
            }              
        }
               
        return num;
    }
}
