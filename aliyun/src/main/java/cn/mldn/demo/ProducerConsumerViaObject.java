package cn.mldn.demo;

//synchronizedͬ��
//�ܽ��ͬ�����⣬��δ����ظ��������� ����������
class ObjectMessage {

    private String title;
    private String content;
    private boolean flag = true;//true �����������������ѣ� false�������ѣ���������

    public synchronized void set(String title, String content) {
        if (!this.flag) {
            try//�޷��������ȴ�������
            {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.title = title;
        this.content = content;

        this.flag = false;
        super.notify();//���ѵȴ����߳�
    }

    public synchronized String get() {
        if (true == this.flag)//��δ�����������ȴ�
        {
            try//�޷��������ȴ�������
            {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            return this.title + " - " + this.content;
        } finally//������Σ���Ҫִ��
        {
            this.flag = true;//��������
            super.notify();
        }
    }
}


class ObjectProducer implements Runnable {

    public ObjectMessage msg;

    public ObjectProducer(ObjectMessage msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                this.msg.set("����", "�����˧��");
            } else {
                this.msg.set("С��", "�����һ�ˣ�һֱһֱһֱһֱ");
            }
        }
    }
}

class ObjectConsumer implements Runnable {

    private ObjectMessage msg;

    public ObjectConsumer(ObjectMessage msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(this.msg.get());
        }
    }
}

public class ProducerConsumerViaObject {

    public static void main(String[] args) {
        ObjectMessage msg = new ObjectMessage();
        new Thread(new ObjectProducer(msg)).start();
        new Thread(new ObjectConsumer(msg)).start();
    }
}
