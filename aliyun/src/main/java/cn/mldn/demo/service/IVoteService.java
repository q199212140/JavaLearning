package cn.mldn.demo.service;

import cn.mldn.demo.vo.VoteStudent;

//����ͶƱ�����ҵ��ӿ�
public interface IVoteService {

    public boolean inc(long sid);//���ݱ�Ž���Ʊ������

    public VoteStudent[] result();//��ȡͶƱ���

    public VoteStudent[] getData();//��ȡȫ������

}
