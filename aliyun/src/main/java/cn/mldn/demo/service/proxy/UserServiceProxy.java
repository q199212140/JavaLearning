package cn.mldn.demo.service.proxy;

import cn.mldn.demo.service.IUserService;
import cn.mldn.util.InputUtil;

public class UserServiceProxy implements IUserService {

    private IUserService userService;

    public UserServiceProxy(IUserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean isExit() {
        // TODO Auto-generated method stub
        return this.userService.isExit();
    }

    @Override
    public boolean login(String name, String passwd) {
        while (!this.isExit()) {
            String inputData = InputUtil.getString("�������¼��Ϣ��");

            if (inputData.contains("/")) {
                String temp[] = inputData.split("/");
                if (this.userService.login(temp[0], temp[1]))//��¼��֤
                {
                    return true;//ѭ������
                } else {
                    System.out.println("��¼ʧ�ܣ�������û��������룡");
                }
            } else//ֻ���û���
            {
                String pwd = InputUtil.getString("���������룺");
                if (this.userService.login(inputData, pwd)) {
                    return true;
                } else {
                    System.out.println("��¼ʧ�ܣ�������û��������룡");
                }
            }
        }

        return false;
    }

}
