package cn.mldn.demo;

/*
class Member implements Runnable
{
    public Member()
    {
        System.out.println("������");
    }
    
    @Override
    public void run()
    {
        System.out.println("����");
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
        this.cleanableDemo.clean();//�������߳�
    }
}
*/
public class CleanerDemo {

    public static void main(String[] args) {
        System.out.println("JDK1.9��֧�֣�ѧϰ������JDK1.8�ģ�pass");
    }
}
