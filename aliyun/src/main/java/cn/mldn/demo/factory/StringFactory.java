package cn.mldn.demo.factory;

import cn.mldn.demo.service.IStringService;
import cn.mldn.demo.service.impl.StringServiceImpl;

public class StringFactory {

    private StringFactory() {
    }

    public static IStringService getInstance() {
        return new StringServiceImpl();
    }
}