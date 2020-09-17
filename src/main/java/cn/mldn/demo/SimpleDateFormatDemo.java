package cn.mldn.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatDemo
{
    public static void main(String[] args)
    {
        System.out.println("SimpleDateFormat£º");
        
        Date date = new Date();
        SimpleDateFormat simpleDateFormatTest = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        String dateStr = simpleDateFormatTest.format(date);
        System.out.println(dateStr);
        
        System.out.println("×Ö·û´®×ªdata£º");
        String birthdayStr = "1846-11-11 11:11:11.111";
        SimpleDateFormat formatStr2Date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        
        Date dateFromStr = null;
        try
        {
            dateFromStr = formatStr2Date.parse(birthdayStr);
        } catch (ParseException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        if(dateFromStr != null)
        {
            System.out.println(dateFromStr);
        }
        
    }
}
