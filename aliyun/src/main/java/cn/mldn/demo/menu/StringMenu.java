package cn.mldn.demo.menu;

import java.util.Arrays;

import cn.mldn.demo.factory.StringFactory;
import cn.mldn.demo.service.IStringService;
import cn.mldn.util.InputUtil;

public class StringMenu {

    private IStringService stringService;

    public StringMenu() {
        this.stringService = StringFactory.getInstance();
        this.choose();
    }

    public void choose() {
        show();
        String choose = InputUtil.getString("�����ѡ��");

        switch (choose) {
            case "1"://������������
            {
                String str = InputUtil.getString("�������ַ������ݣ�");
                this.stringService.append(str);
                choose();
            }

            case "2"://������ʾ����
            {
                String result[] = this.stringService.reverse();
                System.out.println(Arrays.toString(result));
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
        System.out.println("[2]������ʾ�ַ�������");
        System.out.println("[0]��������ִ��");
        //System.out.println("\n");
    }
}
