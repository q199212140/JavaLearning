package cn.mldn.older;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OutputStream4bytesStream {

    public static void main(String[] args) throws Exception {
        System.out.println("Lesson 73 : OutputStream�ֽ��������");
        File outputFile = new File("d:" + File.separator + "test" + File.separator + "outputStream.txt");

        if (!outputFile.getParentFile().exists()) {
            //��Ŀ¼�����ڣ��򴴽�
            outputFile.getParentFile().mkdirs();
        }

        //����try catch�Զ��رմ������Ƿ�ֻ���Զ��رմ���ȡ������Ŀ����ṹ
        try (OutputStream outputStream = new FileOutputStream(outputFile, true))//true�� ׷��
        {
            String str = "Hello Leooooooooooo!\r\n";
            outputStream.write(str.getBytes());//���ַ�����Ϊֱ������
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
