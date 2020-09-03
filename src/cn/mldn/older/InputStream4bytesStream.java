package cn.mldn.older;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;


public class InputStream4bytesStream
{
    public static void main(String[] args) throws Exception
    {
        System.out.println("Lesson 74 : InputStream�ֽ���������");
        
        File inputFile  = new File("d:" + File.separator + "test" + File.separator + "inputStream.txt");
        InputStream input = new FileInputStream(inputFile);
        byte data[] = new byte[1024];
        int retLength = input.read(data);
        System.out.println("read data : [" + new String(data, 0, retLength) + "]");
        
        input.close();     
    }
}
