package cn.mldn.demo.service.impl;

import java.io.File;
import java.util.Arrays;

import cn.mldn.demo.service.IStudentService;
import cn.mldn.demo.vo.Student;
import cn.mldn.util.FileUtil;

public class StudentServiceImpl implements IStudentService
{
    private String content;
    private Student students[];
    private static final File STUDENT_DATA_SAVE_FILE = new File("D:" + File.separator + "test" + File.separator + "student.txt" + File.separator);

    public StudentServiceImpl()
    {
        super();
        this.content = FileUtil.load(STUDENT_DATA_SAVE_FILE);
        this.studentGen();
    }
    
    @Override
    public void append(String str)
    {
        if(str.startsWith("|"))//前面有竖线，截取竖线后面部分
        {
            str = str.substring(1);
        }
        
        if(!str.endsWith("|"))//数据合理，可以直接追加
        {
            str = str + "|";//数据末尾无竖线，追加竖线
        }
        
        //进行文件数据追加
        FileUtil.append(STUDENT_DATA_SAVE_FILE, str);
    }
    
    private void studentGen()//字符串数据处理操作,生成学生
    {
        if((null == this.content) || "".equals(this.content))
        {
            return;//没有数据可以处理
        }
        
        String result[] = this.content.split("\\|");
        
        this.students = new Student[result.length];
        
        for(int x = 0; x < result.length; x++)
        {
            String temp[] = result[x].split(":");
            this.students[x] = new Student(temp[0], Double.parseDouble(temp[1]));
        }
    }
    
    @Override
    public Student[] getData()
    {
        // TODO Auto-generated method stub
        Arrays.sort(this.students);
        return this.students;
    }

}
