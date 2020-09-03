package cn.mldn.demo.factory;

import cn.mldn.demo.service.IFileSerivice;
import cn.mldn.demo.service.impl.FileServiceImpl;

public class FileFactory
{
    private FileFactory() {}
    public static IFileSerivice getInstance()
    {
        return new FileServiceImpl();
    }
}
