package cn.mldn.demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaUtilRegexDemo
{
    public static void main(String[] args)
    {
        System.out.println("java.util.regex包支持[拆分、替换、匹配，不需要java.util.regex开发包，String已满足，regex独有功能如分组]：");
        //去除#{目标串}标记中的所有内容——依赖分组功能
        String DbStr = "INSERT INTO dept(deptno,dname,loc) VALUE (#{DEPTNO},#{dname},#{loc})";
        String DbRex = "#\\{\\w+\\}";
        Pattern pat = Pattern.compile(DbRex);
        Matcher mat = pat.matcher(DbStr);
        while(mat.find())
        {
            System.out.println(mat.group(0).replaceAll("#|\\{|\\}", ""));
        }     
    }
}
