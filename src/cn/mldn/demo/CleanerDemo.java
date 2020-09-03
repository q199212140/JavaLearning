package cn.mldn.demo;
/*
class Member implements Runnable
{
    public Member()
    {
        System.out.println("对象构造");
    }
    
    @Override
    public void run()
    {
        System.out.println("回收");
    }
}

class MemberCleaning implements AutoCloseable
{
    private static final Cleaner cleanerDemo = Cleaner.create();
    private Member member;
    private Cleaner.Cleanable cleanableDemo;
    
    public MemberCleaning()
    {
        this.member = new Member();
        this.cleanerDemo.register(this, this.member);
    }
    @Override
    public void close() throws Exception
    {
        this.cleanableDemo.clean();//启动多线程
    }
}
*/
public class CleanerDemo
{
    public static void main(String[] args)
    {
        System.out.println("JDK1.9才支持，学习环境是JDK1.8的，pass");
    }
}
