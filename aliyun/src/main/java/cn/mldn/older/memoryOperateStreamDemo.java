package cn.mldn.older;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;


public class memoryOperateStreamDemo {

    public static void main(String[] args) throws Exception {
        System.out.println("Lesson 6.81 �ڴ������");
        String str = "Hello leooooooooooooooo!";

        InputStream input = new ByteArrayInputStream(str.getBytes());
        OutputStream output = new ByteArrayOutputStream();

        int data = 0;
        while ((data = input.read()) != -1) {
            output.write(Character.toUpperCase(data));
        }
        System.out.println(output);

        input.close();
        output.close();
    }
}
