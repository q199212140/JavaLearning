package cn.mldn.older;

//����չ����
class Validator
{
    private Validator() {};
    
    public static boolean isEmail(String email)
    {
        if ((null == email) || ("".equals(email)))
        {
            return false;
        }
        
        String regex = "\\w+@\\w+\\.\\w+";
        return email.matches(regex);
    }
}

public class emailVarifyCase
{
    public static void main(String[] args)
    {
        System.out.println("lesson 61 email ��֤��");
        
        if(args.length != 1)
        {
            System.out.println("������δ���java emailVarifyCase email");
            System.exit(1); 
        }
        
        String email = args[0];
        if(Validator.isEmail(email))
        {
            System.out.println("email��ַ��ȷ");
        }
        else
        {
            System.out.println("email��ַ����");
        }
    }
}
