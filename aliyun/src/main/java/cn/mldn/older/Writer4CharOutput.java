package cn.mldn.older;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;

public class Writer4CharOutput {

    public static void main(String[] args) throws Exception {
        System.out.println("Lesson 75 : Writer�ַ��������");

        File writerFile = new File("d:" + File.separator + "test" + File.separator + "WriterTest.txt");

        if (!writerFile.getParentFile().exists()) {
            writerFile.getParentFile().mkdirs();
        }

        Writer out = new FileWriter(writerFile, true);
        String str = "Hello Leooooooooooooo!!!\r\n";
        out.write(str);
        out.append("���ݺ��䰡��");//׷���������

        out.close();

        //out.flush();
    }
}
