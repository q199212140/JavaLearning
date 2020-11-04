package cn.mldn.demo;

import java.io.File;

import cn.mldn.demo.factory.FileFactory;
import cn.mldn.demo.service.IFileSerivice;

public class FileSaveDemo
{
    //项目启动时，首先创建该目录
    static
    {
        File file = new File(IFileSerivice.SAVING_DIR);
        if(!file.exists())
        {
            file.mkdirs();
        }
    }
    
    public static void main(String[] args)
    {
        IFileSerivice fileService = FileFactory.getInstance();
        System.out.println(fileService.save());
    }
}
