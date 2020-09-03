package cn.mldn.message;

import java.util.Base64;

class StringUtil
{
    private static final String SALT = "helloLeoo";
    private static final int REPEAT = 5;
    
    /**
     * 
     */
    public static String encode(String inputStr)
    {
        String temp = inputStr + "{" + SALT + "}";
        byte data[] = temp.getBytes();
        
        for(int x = 0; x < REPEAT; x ++)
        {
            data = Base64.getEncoder().encode(data);
        }
        return new String(data);       
    }
    
    public static String decode(String inputStr)
    {
        byte data[] = inputStr.getBytes();
        for(int i = 0; i < REPEAT; i++)
        {
            data = Base64.getDecoder().decode(data);
        }
        
        return new String(data).replaceAll("\\{\\w+\\}", "");
    }
}

public class Base64EncryptDemo
{
    public static void main(String[] args)
    {
        System.out.println("Base64加解密：");
        
        String msg = "Hello Leo!!!!";
        String encMsg = new String(Base64.getEncoder().encode(msg.getBytes()));
        System.out.println("encMsg : " + encMsg);
        
        String orgMsg = new String(Base64.getDecoder().decode(encMsg));
        System.out.println("orgMsg : " + orgMsg);
        
        System.out.println("\nBase64公版加解密，安全性低，改进方法是使用盐值进行多次加密操作：");
        
        String saltEncStr = StringUtil.encode("www.baidu.com"); 
        System.out.println("saltEncStr : " + saltEncStr);
        System.out.println("saltOrgStr : " + StringUtil.decode(saltEncStr));
        
    }
}
