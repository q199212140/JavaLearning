package cn.mldn.demo.service.impl;

import java.util.Arrays;

import cn.mldn.demo.service.IVoteService;
import cn.mldn.demo.vo.VoteStudent;

public class VoteServiceImpl implements IVoteService
{
    private VoteStudent[] voteStudents = new VoteStudent[]
            {
                new VoteStudent(1, "张三", 0),
                new VoteStudent(2, "李四", 0),
                new VoteStudent(3, "王五", 0),
                new VoteStudent(4, "赵六", 0),
            };
    
    @Override
    public boolean inc(long sid)
    {
        // TODO Auto-generated method stub
        for(int x = 0; x < voteStudents.length; x++)
        {
            if(sid == this.voteStudents[x].getSid())
            {
                this.voteStudents[x].setVote(this.voteStudents[x].getVote() + 1);
                return true;
            }
        }
        return false;
    }

    @Override
    public VoteStudent[] result()
    {
        // TODO Auto-generated method stub
        Arrays.sort(this.voteStudents);
        return this.voteStudents;
    }

    @Override
    public VoteStudent[] getData()
    {
        // TODO Auto-generated method stub
        return this.voteStudents;
    }

}
