package cn.mldn.demo.menu;

import java.util.Arrays;

import cn.mldn.demo.factory.StudentFactory;
import cn.mldn.demo.service.IStudentService;
import cn.mldn.util.InputUtil;

public class DataRankMenu {

    public DataRankMenu() {
        this.choose();
    }

    public void choose() {
        show();
        String choose = InputUtil.getString("�����ѡ��");

        switch (choose) {
            case "1"://������������
            {
                String str = InputUtil.getString("������Ҫ׷�ӵ����ݣ�");
                IStudentService studentService = StudentFactory.getInstance();
                studentService.append(str);
                choose();
            }

            case "2"://��ʾ����
            {
                IStudentService studentService = StudentFactory.getInstance();
                ;
                System.out.println(Arrays.toString(studentService.getData()));
                choose();
            }

            case "0"://��������ִ��
            {
                System.out.println("��������ִ�С�");
                System.exit(1);
            }

            default: {
                System.out.println("����Ƿ���ȷ�Ϻ��������룡");
                choose();
            }
        }
    }

    public void show() {
        System.out.println("[1]׷���ַ�������");
        System.out.println("[2]������ʾѧ������");
        System.out.println("[0]��������ִ��");
        //System.out.println("\n");
    }
}
