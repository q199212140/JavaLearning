package cn.mldn.older;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class ScannerDemo
{
    public static void main(String[] args) throws ParseException, FileNotFoundException
    {
        System.out.println("Lesson 6.87 Scannerɨ����������������������");
        
        Scanner scan = new Scanner(System.in);
        System.out.println("���������䣺");
        if(scan.hasNextInt())
        {
            int age = scan.nextInt();
            System.out.println("���䣺" + age);
        }
        else
        {
            System.out.println("��������ȷ�����䣡");
        }
        
        System.out.println("��������Ϣ��");
        if(scan.hasNext())
        {
            String msg = scan.next();
            System.out.println("�������Ϣ��" + msg);
        }
        
        System.out.println("���������գ�yyyy-MM-dd");
        if(scan.hasNext("\\d{4}-\\d{2}-\\d{2}"))
        {
            String birthStr = scan.next("\\d{4}-\\d{2}-\\d{2}");
            System.out.println("�������Ϣ��" + new SimpleDateFormat("yyyy-MM-dd").parse(birthStr));
        }
        
        scan.close();
        
        scan = new Scanner(new File("d:" + File.separator + "test" + File.separator + "scannerTest.txt"));
        scan.useDelimiter("\n");//���ö�ȡ�ָ���
        while(scan.hasNext())
        {
            System.out.println(scan.next());
        }
        
        scan.close();
    }
}
