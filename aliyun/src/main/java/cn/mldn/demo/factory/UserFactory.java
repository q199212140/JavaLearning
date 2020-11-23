package cn.mldn.demo.factory;

import cn.mldn.demo.service.IUserService;
import cn.mldn.demo.service.impl.UserServerImpl;
import cn.mldn.demo.service.proxy.UserServiceProxy;

public class UserFactory {

    private UserFactory() {
    }

    public static IUserService getInstance() {
        return new UserServiceProxy(new UserServerImpl());
    }
}
