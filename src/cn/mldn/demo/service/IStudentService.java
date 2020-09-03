package cn.mldn.demo.service;

import cn.mldn.demo.vo.Student;

public interface IStudentService
{
    public void append(String str);//追加数据保存到文件
    public Student[] getData();
}
