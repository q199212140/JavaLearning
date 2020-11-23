package cn.mldn.demo;

import cn.mldn.demo.service.IChannelService;
import cn.mldn.demo.service.IMessageService;

public class ClassInfoPerson extends AbstractBase implements IChannelService, IMessageService {

    private String name;
    private int age;

    public ClassInfoPerson() {
    }

    public ClassInfoPerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ClassInfoPerson [name=" + name + ", age=" + age + "]";
    }

    @Override
    public void send() {
        // TODO Auto-generated method stub
        if (this.connect()) {
            System.out.println("[��Ϣ����]Hello World!");
        }
    }

    @Override
    public boolean connect() {
        // TODO Auto-generated method stub
        return true;
    }

}
