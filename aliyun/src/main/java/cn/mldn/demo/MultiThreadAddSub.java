/*
 * ���4���̣߳�2���߳�ִ�м�������2���߳�ִ�мӲ���*/
package cn.mldn.demo;

class AddThread implements Runnable {

    private Resource resource;

    public AddThread(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int x = 0; x < 50; x++) {
            try {
                this.resource.add();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}

class SubThread implements Runnable {

    private Resource resource;

    public SubThread(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int x = 0; x < 50; x++) {
            try {
                this.resource.sub();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}

class Resource {

    private int num = 0;
    private boolean addEnable = true;

    public synchronized void add() throws Exception {
        while (false == this.addEnable)//�̳�����if���޷�����ʵ�ּӼ����Ļ���ȴ����������0 1 ���ϸ���
        {
            super.wait();
        }

        Thread.sleep(100);
        this.num++;
        System.out.println("�ӷ����� - " + Thread.currentThread().getName() + "��num = " + this.num);

        this.addEnable = false;
        super.notifyAll();
    }

    public synchronized void sub() throws Exception {
        while (true == this.addEnable) {
            super.wait();
        }

        Thread.sleep(200);
        this.num--;
        System.out.println("�������� - " + Thread.currentThread().getName() + "��num = " + this.num);

        this.addEnable = true;
        super.notifyAll();
    }
}

public class MultiThreadAddSub {

    public static void main(String[] args) {
        System.out.println("\n\n���̰߳��������̼߳Ӽ�����");

        Resource res = new Resource();
        AddThread at = new AddThread(res);
        SubThread st = new SubThread(res);

        new Thread(at, "�ӷ��߳� - A").start();
        new Thread(at, "�ӷ��߳� - B").start();
        new Thread(st, "�����߳� - X").start();
        new Thread(st, "�����߳� - Y").start();
    }
}
