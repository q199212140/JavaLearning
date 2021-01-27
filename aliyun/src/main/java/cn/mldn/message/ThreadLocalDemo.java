package cn.mldn.message;

class Message {

    private String info;

    public void setInfo(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }
}

class Channel {

    //thread local �洢�ռ������̲߳�������staticȫ���ڴ�
    private static final ThreadLocal<Message> THREAD_LOCAL = new ThreadLocal<Message>();

    public static void setMessage(Message m) {
        THREAD_LOCAL.set(m);
    }

    public static void send() {
        System.out.println(Thread.currentThread().getName() + "--��Ϣ���ͣ�" + THREAD_LOCAL.get().getInfo());
    }
}

public class ThreadLocalDemo {

    public static void main(String[] args) {
        System.out.println("ThreadLocal Demo : ");
        new Thread(() ->
        {
            Message msg = new Message();
            msg.setInfo("��һ���̷߳��͵���Ϣ!");
            Channel.setMessage(msg);
            Channel.send();
        }, "��Ϣ������A").start();
        new Thread(() ->
        {
            Message msg = new Message();
            msg.setInfo("�ڶ����̷߳��͵���Ϣ!");
            Channel.setMessage(msg);
            Channel.send();
        }, "��Ϣ������B").start();
        new Thread(() ->
        {
            Message msg = new Message();
            msg.setInfo("�������̷߳��͵���Ϣ!");
            Channel.setMessage(msg);
            Channel.send();
        }, "��Ϣ������C").start();
    }
}
