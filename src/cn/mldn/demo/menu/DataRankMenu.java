package cn.mldn.demo.menu;

import java.util.Arrays;

import cn.mldn.demo.factory.StudentFactory;
import cn.mldn.demo.service.IStudentService;
import cn.mldn.util.InputUtil;

public class DataRankMenu
{
    public DataRankMenu()
    {       
        this.choose();
    }
    
    public void choose()
    {
        show();
        String choose = InputUtil.getString("请进行选择：");
        
        switch(choose)
        {
            case "1"://接收输入数据
            {
                String str = InputUtil.getString("请输入要追加的数据：");
                IStudentService studentService = StudentFactory.getInstance();
                studentService.append(str);
                choose();
            }
                
            case "2"://显示数据
            {
                IStudentService studentService = StudentFactory.getInstance();;
                System.out.println(Arrays.toString(studentService.getData()));
                choose();
            }
    
            case "0"://结束程序执行
            {
                System.out.println("结束程序执行。");
                System.exit(1);
            }
            
            default:
            {
                System.out.println("输入非法，确认后重新输入！");
                choose();
            }
        }
    }
    
    public void show()
    {
        System.out.println("[1]追加字符串数据");
        System.out.println("[2]逆序显示学生数据");
        System.out.println("[0]结束程序执行");
        //System.out.println("\n");
    }
}
