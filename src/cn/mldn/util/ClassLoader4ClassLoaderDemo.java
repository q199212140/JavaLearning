package cn.mldn.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class ClassLoader4ClassLoaderDemo extends ClassLoader
{
    private static final String MESSAGE_CLASS_PATH_6_116 = "D:" + File.separator + "test" + File.separator  + "Message4ClassLoader.class";
    /**
     * 进行指定类的加载
     * @param className 完整名称  包.类名称
     * @return 指定的类对象
     * @throws Exception 如果类文件不存在，则无法加载
     */
    public Class<?> loadData(String className) throws Exception
    {
        byte [] data = this.loadClassData();
        
        if(data != null)
        {
            return super.defineClass(className, data, 0, data.length);
        }
        
        return null;
    }
    
    /**
     * 通过文件进行类加载
     * @return
     * @throws Exception
     */
    private byte [] loadClassData() throws Exception
    {
        InputStream input = null;
        ByteArrayOutputStream bos = null;//将数据加载到内存中
        byte data[] = null;
        
        try
        {
            //实例化内存流
            bos = new ByteArrayOutputStream();
            
            //文件流加载
            System.out.println("FileInputStream:" + MESSAGE_CLASS_PATH_6_116);
            input = new FileInputStream(new File(MESSAGE_CLASS_PATH_6_116));
            input.transferTo(bos);
            
            data = bos.toByteArray();
        }catch(Exception e)
        {
            e.printStackTrace();
        }finally
        {
            if(input != null)
            {
                input.close();
            }
            if(bos != null)
            {
                bos.close();
            }
            
        }
        System.out.println("return data:");
        return data;
    }
}
