package cn.mldn.demo.factory;

import cn.mldn.demo.service.IStudentService;
import cn.mldn.demo.service.impl.StudentServiceImpl;

public class StudentFactory
{
    private StudentFactory() {}
    
    public static IStudentService getInstance()
    {
        return new StudentServiceImpl();
    }
}
