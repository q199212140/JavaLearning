package cn.mldn.demo.service.proxy;

import cn.mldn.demo.service.IUserService;
import cn.mldn.util.InputUtil;

public class UserServiceProxy implements IUserService
{
    private IUserService userService;
      
    public UserServiceProxy(IUserService userService)
    {
        this.userService = userService;
    }

    @Override
    public boolean isExit()
    {
        // TODO Auto-generated method stub
        return this.userService.isExit();
    }

    @Override
    public boolean login(String name, String passwd)
    {
        while(!this.isExit())
        {
            String inputData = InputUtil.getString("请输入登录信息：");
            
            if(inputData.contains("/"))
            {
                String temp[] = inputData.split("/");
                if(this.userService.login(temp[0], temp[1]))//登录认证
                {
                    return true;//循环结束
                }
                else
                {
                    System.out.println("登录失败，错误的用户名或密码！");
                }
            }
            else//只有用户名
            {
                String pwd = InputUtil.getString("请输入密码：");
                if(this.userService.login(inputData, pwd))
                {
                    return true;
                }
                else
                {
                    System.out.println("登录失败，错误的用户名或密码！");
                }
            }
        }
 
        return false;
    }

}
