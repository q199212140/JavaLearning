package cn.mldn.demo.menu;

import cn.mldn.demo.factory.VoteFactory;
import cn.mldn.demo.service.IVoteService;
import cn.mldn.demo.vo.VoteStudent;
import cn.mldn.util.InputUtil;


public class VoteMenu {

    private IVoteService voteService;

    public VoteMenu() {
        this.voteService = VoteFactory.getInstance();
        this.vote();
    }

    public void vote() {
        VoteStudent stu[] = this.voteService.getData();

        for (VoteStudent temp : stu) {
            System.out.println(temp.getSid() + ":" + temp.getName() + "[" + temp.getVote() + "]");
        }

        int num = 10;
        while (num != 0)//ѭ��ͶƱ
        {
            num = InputUtil.getInt("������೤��ѡ�˴���(������0����)");
            if (num != 0) {
                if (!this.voteService.inc(num)) {
                    System.out.println("��ѡƱ��Ч����������ȷ�ĺ�ѡ�˴��ţ�");
                }
            }
        }

        System.out.println("ͶƱ���ս����");
        stu = this.voteService.result();
        System.out.println(stu[0].getName() + "ͬѧ����" + stu[0].getVote() + "Ʊ����ѡ�೤��");
    }
}
