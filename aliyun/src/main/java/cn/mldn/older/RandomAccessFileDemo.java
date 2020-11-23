package cn.mldn.older;

import java.io.File;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo {

    public static void main(String[] args) throws Exception {
        System.out.println("Lesson 6.83 RandomAccessFile �� ");

        File rafFile = new File("d:" + File.separator + "test" + File.separator + "randomAccessFileTest.txt");
        RandomAccessFile raf = new RandomAccessFile(rafFile, "rw");

        //д
        String names[] = {"zhangsan", "wangwu  ", "lisi    "};
        int ages[] = new int[]{30, 20, 16};
        for (int i = 0; i < names.length; i++) {
            raf.write(names[i].getBytes());
            raf.writeInt(ages[i]);
        }
        raf.close();

        //��
        {
            raf = new RandomAccessFile(rafFile, "rw");
            raf.skipBytes(24);//�ڶ�������ĩβ������������
            byte[] data = new byte[8];
            int len = raf.read(data);
            System.out.println("������" + new String(data, 0, len).trim() + "���䣺 " + raf.readInt());
        }

        {
            raf.seek(12);//��һ������ĩβ����������
            byte[] data = new byte[8];
            int len = raf.read(data);
            System.out.println("������" + new String(data, 0, len).trim() + "���䣺 " + raf.readInt());
        }

        {
            raf.seek(0);//��ָ�������ͷ������һ����
            byte[] data = new byte[8];
            int len = raf.read(data);
            System.out.println("������" + new String(data, 0, len).trim() + "���䣺 " + raf.readInt());
        }

        raf.close();
    }
}
