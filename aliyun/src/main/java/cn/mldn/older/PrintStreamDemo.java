package cn.mldn.older;

import java.io.File;
import java.io.PrintWriter;

public class PrintStreamDemo {

    public static void main(String[] args) throws Exception {
        System.out.println("Lesson 6.84 ��ӡ�� ���Ժ�������ȫ��ʹ�ô�ӡ�� ");

        File file = new File("d:" + File.separator + "test" + File.separator + "printStreamTest.txt");
        PrintWriter pwtr = new PrintWriter(file);

        pwtr.println("������Сǿ��");
        pwtr.print("���䣺");
        pwtr.println(78);

        //��ʽ�����--������linux��ʽ�����
        String name = "Leo";
        int age = 30;
        double salary = 19999.424355;
        pwtr.printf("������%s, ���䣺%d, ���룺%9.2f", name, age, salary);

        pwtr.close();
    }
}
