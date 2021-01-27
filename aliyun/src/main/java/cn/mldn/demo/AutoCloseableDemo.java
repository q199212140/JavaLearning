/*
 * ��Դ����ʱʵ����Դ�Զ��ر�/�ͷš����ļ������硢���ݿ⿪��
 * */

package cn.mldn.demo;

interface IMessage {

    public void send();
}

class ManualNetMessage implements IMessage {

    private String msg;

    public ManualNetMessage(String msg) {
        this.msg = msg;
    }

    public boolean open() {
        System.out.println("[OPEN]��ȡ��Ϣ����������Դ");
        return true;
    }

    @Override
    public void send() {
        if (this.open()) {
            System.out.println("*** ������Ϣ ***" + this.msg);
        }
    }

    public void close() throws Exception {
        System.out.println("[CLOSE]�ر���Ϣ����������Դ");
    }
}

//����쳣������ʵ��
class AutoNetMessage implements IMessage, AutoCloseable {

    private String msg;

    public AutoNetMessage(String msg) {
        this.msg = msg;
    }

    public boolean open() {
        System.out.println("[OPEN]��ȡ��Ϣ����������Դ");
        return true;
    }

    @Override
    public void send() {
        if (this.open()) {
            System.out.println("*** ������Ϣ ***" + this.msg);
        }
    }

    @Override
    public void close() {
        System.out.println("[CLOSE]�ر���Ϣ����������Դ");
    }
}

public class AutoCloseableDemo {

    public static void main(String[] args) throws Exception {
        System.out.println("\n\n�ֶ�������Դ��");
        ManualNetMessage nm = new ManualNetMessage("Hello World!");

        nm.send();
        nm.close();

        System.out.println("\n\nAutoCloseable�Զ�������Դ��");
        //AutoCloseable������Ҫ���try catch����һ��ʹ��
        try (AutoNetMessage autoMsg = new AutoNetMessage("Auto Hello World!")) {
            autoMsg.send();
        } catch (Exception e) {
            ;
        }
        Runtime e;
    }
}
