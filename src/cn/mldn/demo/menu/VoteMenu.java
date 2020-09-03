package cn.mldn.demo.menu;

import cn.mldn.demo.factory.VoteFactory;
import cn.mldn.demo.service.IVoteService;
import cn.mldn.demo.vo.VoteStudent;
import cn.mldn.util.InputUtil;


public class VoteMenu
{
    private IVoteService voteService;
    
    public VoteMenu()
    {       
        this.voteService = VoteFactory.getInstance();
        this.vote();
    }
    
    public void vote()
    {
        VoteStudent stu[] = this.voteService.getData();
        
        for(VoteStudent temp : stu)
        {
            System.out.println(temp.getSid() + ":" + temp.getName() + "[" + temp.getVote() +"]");
        }
        
        int num = 10;
        while(num != 0)//循环投票
        {
            num = InputUtil.getInt("请输入班长侯选人代号(以数字0结束)");
            if(num != 0)
            {
                if(!this.voteService.inc(num))
                {
                    System.out.println("此选票无效，请输入正确的侯选人代号！");
                }
            }
        }
        
        System.out.println("投票最终结果：");
        stu = this.voteService.result();
        System.out.println(stu[0].getName() + "同学，以" + stu[0].getVote() + "票数单选班长！");
    }   
}
