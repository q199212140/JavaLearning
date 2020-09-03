package cn.mldn.demo;

public class RegularExpressionDemo
{
    public static void main(String[] args)
    {
        System.out.println("\n正则表达式：");
        
        System.out.println("\n数字输入：");
        String strInput = "12a3";
        if(strInput.matches("\\d+"))
        {
            int num = Integer.parseInt(strInput);
            System.out.println(num * 2);
        }
        
        System.out.println("\n正则匹配任意单字母：");
        String strREInput = "a";
        String strRE = "b";
        System.out.println(strREInput.matches(strRE));
        
        System.out.println("\n正则匹配字符集：");
        String strREInput1 = "a";
        String strRE1 = "[abc]";
        String strRE2 = "[^abc]";
        System.out.println(strREInput1.matches(strRE1));
        System.out.println(strREInput1.matches(strRE2));
        
        System.out.println("\n次数匹配：");
        String strREInput3 = "";
        String strRE3 = "\\w+";
        System.out.println(strREInput3.matches(strRE3));
        
        System.out.println("\n长度匹配：");
        String strREInput4 = "a";
        String strRE4 = "\\w{3,}";
        System.out.println(strREInput4.matches(strRE4));
    }
}
