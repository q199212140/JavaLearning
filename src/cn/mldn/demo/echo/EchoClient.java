package cn.mldn.demo.echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient
{
    private static final BufferedReader KEYBOARD_INPUT = new BufferedReader(new InputStreamReader(System.in));
    
    public static String getString(String prompt) throws IOException
    {
        System.out.print(prompt);
        String str = KEYBOARD_INPUT.readLine();
        return str;
    }
    
    public static void main(String[] args) throws Exception
    {
        System.out.println("Lesson 5.153.Echo程序模型:EchoClient:");
        
        Socket client = new Socket("localhost", 9999);
        
        //输入、输出支持  Scanner PrintWriter
        //接收服务器端的输入内容
        Scanner scan = new Scanner(client.getInputStream());
        scan.useDelimiter("\n");
        
        //向服务器端发送内容
        PrintStream out = new PrintStream(client.getOutputStream());
        
        boolean flag = true;
        while(flag)
        {
            String input = getString("请输出要发送的内容：").trim();
            out.println(input);
            
            if(scan.hasNext())
            {
                System.out.println(scan.next());
            }
            
            if("byebye".equalsIgnoreCase(input))
            {
                flag = false;
            }
        }
        
        scan.close();
        out.close();
        client.close();
    }
}
