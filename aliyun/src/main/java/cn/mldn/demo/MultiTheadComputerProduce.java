/*
 * ���������˵����࣬������һ̨���ԾͰ���һ̨�����û���µ�����������������˹�Ҫ�ȴ��µ���
 * ������������ĵ���û�а��ߣ���Ҫ�ȴ����ߺ�����������ͳ���������ĵ�������*/

package cn.mldn.demo;

class ComputerProducer implements Runnable {

    private ComputerResource resource;

    public ComputerProducer(ComputerResource resource) {
        this.resource = resource;
    }

    public void run() {
        for (int x = 0; x < 50; x++) {
            try {
                this.resource.make();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}

class ComputerConsumer implements Runnable {

    private ComputerResource resource;

    public ComputerConsumer(ComputerResource resource) {
        this.resource = resource;
    }

    public void run() {
        for (int x = 0; x < 50; x++) {
            try {
                this.resource.get();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}

class Computer {

    private static int count = 0;//��������̨��
    private String name;
    private double price;

    public Computer(String name, double price) {
        this.name = name;
        this.price = price;
        count++;
    }

    public String toString() {
        return "����" + count + "̨���ԡ������֣�" + this.name + "���۸�" + this.price;
    }
}

class ComputerResource {

    private Computer computer;//ͨ�����Զ����Ƿ�Ϊ�������������ߺ������ߵ�ͬ��

    public synchronized void make() throws Exception {
        if (this.computer != null)//�Ѿ���������
        {
            super.wait();
        }
        Thread.sleep(100);
        this.computer = new Computer("dell����", 1.1);
        System.out.println("�������ԣ�" + this.computer);
        super.notifyAll();
    }

    public synchronized void get() throws Exception {
        if (null == this.computer)//��δ����
        {
            super.wait();
        }
        Thread.sleep(10);
        System.out.println("���˵��ԣ�" + this.computer);
        this.computer = null;
        super.notifyAll();
    }
}

public class MultiTheadComputerProduce {

    public static void main(String[] args) {
        ComputerResource res = new ComputerResource();

        new Thread(new ComputerProducer(res)).start();
        new Thread(new ComputerConsumer(res)).start();
    }
}
