package cn.mldn.older;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class IOSupportOfSystemDemo
{
    public static void main(String[] args) throws Exception
    {
        System.out.println("Lesson 6.85:System���IO��֧�֣�\n");
        
        System.setErr(new PrintStream(new FileOutputStream(new File("d:" + File.separator + "test" + File.separator + "erroutRedirectTest.txt"))));
        System.err.println("Hello Leooooooo!");
    }
}
