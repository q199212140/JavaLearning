package cn.mldn.demo;

class Member implements Cloneable
{
    private String name;
    private int age;
    
    public Member(String name, int age)
    {
        this.name = name;
        this.age = age;
    }
    
    @Override
    public String toString()
    {
        return "[" + super.toString() + "], name = " + this.name + ", age = " + this.age; 
    }
    
    //覆写克隆方法，其中调用父类中的克隆方法
    @Override
    protected Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }
}

public class ObjectCloneDemo
{
    public static void main(String[] args)
    {
        Member memberA = new Member("leo", 29);
        Member memberB = null;
        try
        {
            memberB = (Member)memberA.clone();
        } catch (CloneNotSupportedException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        System.out.println(memberA);
        if(memberB != null)
        {
            System.out.println(memberB);
        } 
    }
}
