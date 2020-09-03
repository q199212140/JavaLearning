package cn.mldn.demo;

import cn.mldn.demo.factory.UserFactory;

public class UserLoginDemo
{ 
    public static void main(String[] args)
    {
        System.out.println("Lesson 6.97 ÓÃ»§µÇÂ¼£º");
        
        System.out.println(UserFactory.getInstance().login(null,  null));
    }
}
