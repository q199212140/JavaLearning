package cn.mldn.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

//文件处理类，实现文件加载，追加
public class FileUtil
{
    public static String load(File file)
    {
        Scanner scan = null;
        try
        {
            scan = new Scanner(file);
            if(scan.hasNext())
            {
                String str = scan.next();
                return str;
            }
            return null;
        }catch (Exception e)
        {
            return null;
        }finally
        {
            if(scan != null)
            {
                scan.close();
            }
        }
    }
    
    public static boolean append(File file, String content)
    {
        PrintStream out = null;
        try
        {
            out = new PrintStream(new FileOutputStream(file, true));
            out.print(content);//内容追加
            return true;
        } catch (Exception e)
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
    }
}
