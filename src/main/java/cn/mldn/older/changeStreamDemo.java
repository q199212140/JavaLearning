package cn.mldn.older;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class changeStreamDemo
{
    public static void main(String[] args) throws Exception
    {
        System.out.println("Lesson 6.78 ת������");
        
        File file  = new File("d:" + File.separator + "test" + File.separator + "changeTest.txt");
        if(!file.getParentFile().exists())
        {
            file.getParentFile().mkdirs();
        }
        
        OutputStream output = new FileOutputStream(file);
        Writer out = new OutputStreamWriter(output);
        out.write("Helloooooooooooooo!");
        out.close();
    }
}
