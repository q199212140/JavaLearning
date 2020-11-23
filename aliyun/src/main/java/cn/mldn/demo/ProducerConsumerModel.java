package cn.mldn.demo;

/*
 //δͬ����message��д����
class Message
{
    private String title;
    private String content;
    public void setContent(String content)
    {
        this.content = content;
    }
    public void setTitle(String title)
    {
        this.title = title;
    }
    public String getContent()
    {
        return this.content;
    }
    public String getTitle()
    {
        return this.title;
    }
}
*/

//synchronizedͬ��
//�ܽ��ͬ�����⣬��δ����ظ��������� ����������
class Message {

    private String title;
    private String content;

    public synchronized void set(String title, String content) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.title = title;
        this.content = content;
    }

    public synchronized String get() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return this.title + " - " + this.content;
    }
}


class Producer implements Runnable {

    public Message msg;

    public Producer(Message msg) {
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

class Consumer implements Runnable {

    private Message msg;

    public Consumer(Message msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(this.msg.get());
        }
    }
}

public class ProducerConsumerModel {

    public static void main(String[] args) {
        Message msg = new Message();
        new Thread(new Producer(msg)).start();
        new Thread(new Consumer(msg)).start();
    }
}
