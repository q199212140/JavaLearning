package cn.mldn.demo.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

import cn.mldn.demo.service.IFileSerivice;
import cn.mldn.util.InputUtil;

public class FileServiceImpl implements IFileSerivice
{
    private String name;
    private String content;
    
    public FileServiceImpl()
    {
        this.name = InputUtil.getString("请输入保存文件名称：");
        this.content = InputUtil.getString("请输入保存文件的内容：");
    }
    
    @Override
    public boolean save()
    {
        File file = new File(IFileSerivice.SAVING_DIR + this.name);
        PrintWriter out = null;
        try
        {
            out = new PrintWriter(new FileOutputStream(file));
            out.print(this.content);
            out.close();
        } catch (FileNotFoundException e)
        {
            // TODO Auto-generated catch block
            return false;
        }finally
        {
            if(out != null)
            {
                out.close();
            }
        }
     
        return true;
    }
}
