package cn.mldn.demo;

public class StringVSStringBuffer
{
    public static void main(String[] args)
    {
        String str4String = "Hello";
        changeString(str4String);
        System.out.println("string类无法修改串：" + str4String);
        
        StringBuffer buf = new StringBuffer("Hello");
        changeStringBuffer(buf);
        System.out.println("StringBuffer串可以被修改：" + buf);
    }
    
    public static void changeString(String tmp)
    {
        tmp += " World!";
    }
    
    public static void changeStringBuffer(StringBuffer tmp)
    {
        tmp.append(" World!");
    }
    
}
