package cn.mldn.demo.service;

import cn.mldn.demo.vo.VoteStudent;

//定义投票处理的业务接口
public interface IVoteService
{
    public boolean inc(long sid);//根据编号进行票数增加
    public VoteStudent[] result();//获取投票结果
    public VoteStudent[] getData();//获取全部数据

}
