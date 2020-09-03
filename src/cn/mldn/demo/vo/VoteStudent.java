package cn.mldn.demo.vo;

public class VoteStudent implements Comparable<VoteStudent>
{
    private long sid;
    private String name;
    private int vote;
        
    public VoteStudent(long sid, String name, int vote)
    {
        this.sid  = sid;
        this.name = name;
        this.vote = vote;
    }

    public long getSid()
    {
        return sid;
    }

    public void setSid(long sid)
    {
        this.sid = sid;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getVote()
    {
        return vote;
    }

    public void setVote(int vote)
    {
        this.vote = vote;
    }

    @Override
    public String toString()
    {
        return "VoteStudent [sid=" + sid + ", name=" + name + ", vote=" + vote + "]";
    }

    @Override
    public int compareTo(VoteStudent stu)
    {
        // TODO Auto-generated method stub
        return stu.vote - this.vote;
    }

}
