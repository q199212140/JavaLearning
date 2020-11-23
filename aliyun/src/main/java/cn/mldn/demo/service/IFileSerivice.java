package cn.mldn.demo.service;

import java.io.File;

//�ļ���������ӿ�
public interface IFileSerivice {

    public static final String SAVING_DIR = "D:" + File.separator + "test" + File.separator;

    public boolean save();
}
