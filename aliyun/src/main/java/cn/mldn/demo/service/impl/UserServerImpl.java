package cn.mldn.demo.service.impl;

import cn.mldn.demo.service.IUserService;

public class UserServerImpl implements IUserService {

    private int count = 0;//��¼����ͳ��

    @Override
    public boolean isExit() {
        // TODO Auto-generated method stub
        //ִ�е�¼�˳�����
        return this.count >= 3;
    }

    @Override
    public boolean login(String name, String passwd) {
        // TODO Auto-generated method stub
        this.count++;
        return ("hello".equals(name) && "leo".equals(passwd));
    }

}
