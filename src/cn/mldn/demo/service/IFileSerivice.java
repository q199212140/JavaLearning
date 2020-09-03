package cn.mldn.demo.service;

import java.io.File;

//文件操作服务接口
public interface IFileSerivice
{
    public static final String SAVING_DIR = "D:" + File.separator + "test" + File.separator;
    
    public boolean save(); 
}
