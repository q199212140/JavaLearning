package cn.mldn.demo.factory;

import cn.mldn.demo.service.INumberService;
import cn.mldn.demo.service.impl.NumberServiceImpl;

public class Factory
{
    private Factory() {}
    public static INumberService getInstance()
    {
        return new NumberServiceImpl();
    }
}
