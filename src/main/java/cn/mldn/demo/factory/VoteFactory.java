package cn.mldn.demo.factory;

import cn.mldn.demo.service.IVoteService;
import cn.mldn.demo.service.impl.VoteServiceImpl;

public class VoteFactory
{
    private VoteFactory() {}
    
    public static IVoteService getInstance()
    {
        return new VoteServiceImpl();
    }
}
