package cn.mldn.older;

import java.io.File;
import java.text.SimpleDateFormat;

public class FileDemo {

    //���ļ���׺
    public static final String FILE_TYPE = ".jpg";

    public static void listDir(File file) {
        if (file.isDirectory()) {
            File result[] = file.listFiles();

            if (result != null) {
                for (int i = 0; i < result.length; i++) {
                    listDir(result[i]);
                }
            }
        }

        //�������·��
        System.out.println(file);
    }

    public static void renameDir(File file) {
        if (file.isDirectory()) {
            File results[] = file.listFiles();
            if (results != null) {
                //��Ŀ¼�������ļ�����������
                for (int i = 0; i < results.length; i++) {
                    renameDir(results[i]);
                }
            }
        } else {
            //������ļ���������
            if (file.isFile()) {
                //File newFile = new File(file.getParentFile(file.getName().lastIndexOf(".")));
                String fileName = null;
                if (file.getName().contains(".")) {
                    fileName = file.getName().substring(0, file.getName().lastIndexOf(".")) + FILE_TYPE;
                } else {
                    fileName = file.getName() + FILE_TYPE;
                }

                File newFileName = new File(file.getParentFile(), fileName);

                file.renameTo(newFileName);
                //System.out.println(fileName);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("6.67 6.68 File�ļ��ࣺ");

        //File newFile = new File("d:\\JavaFileTest.txt");
        //File newFile = new File("d:/JavaFileTest.txt");//linux����·���ָ�����ĿǰҲ��֧�ֵ�
        File newFile = new File("d:" + File.separator + "hello" + File.separator + "world" + File.separator
            + "JavaFileTest.txt"); //File���еľɰ汾·���ָ���,�Ƽ�

        //�ݹ鴴�������ڵĸ�·��
        if (!newFile.getParentFile().exists()) {
            newFile.getParentFile().mkdirs();
        }

        if (newFile.exists()) {
            System.out.println(newFile.length());
            newFile.delete();
        } else {
            System.out.println(newFile.createNewFile());
            System.out.println(newFile.canRead());
            System.out.println(newFile.canWrite());
            System.out.println(newFile.canExecute());
            System.out.println(newFile.length());
        }

        System.out.println("\n�ļ����Զ�ȡ��");
        File picFile = new File("d:\\test.jpg");
        System.out.println("fileLength:" + picFile.length());
        System.out
            .println("lastModified:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(picFile.lastModified()));
        System.out.println("isFile:" + picFile.isFile());
        System.out.println("isDirectory:" + picFile.isDirectory());

        System.out.println("\n����Ŀ¼");
        File dirFile = new File("d:" + File.separator);
        if (dirFile.isDirectory()) {
            File result[] = dirFile.listFiles();
            for (int i = 0; i < result.length; i++) {
                System.out.println(result[i]);
            }
        }

        System.out.println("\n�г�Ŀ¼�ṹ��[�ݹ�ʵ��]");
        File baofengFile = new File("d:" + File.separator + "����Ӱ��" + File.separator);
        listDir(baofengFile);

        System.out.println("\n�����޸��ļ����ƣ��������û�к�׺��׷�ӣ�����к�׺�������һ������н�ȡ");
        File changeTypeFile = new File("d:" + File.separator + "test" + File.separator);
        listDir(changeTypeFile);

        long startTime = System.currentTimeMillis();
        renameDir(changeTypeFile);
        long stopTime = System.currentTimeMillis();
        System.out.println("������ʱ[ms]��" + (stopTime - startTime));

        listDir(changeTypeFile);
    }
}
