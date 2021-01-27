package cn.mldn.demo;

public class DaemonThread {

    public static boolean flag = true;

    public static void main(String[] args) {
        Thread userThread = new Thread(() ->
        {
            for (int x = 0; x < 10; x++) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "�������У�num = " + x);
            }
        }, "�û��߳�");

        Thread daemonThread = new Thread(() ->
        {
            for (int x = 0; x < Integer.MAX_VALUE; x++) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "�������У�num = " + x);
            }
        }, "�ػ��߳�");

        userThread.start();
        //�ػ����������̣߳����߳��˳����ػ��߳�Ҳ�˳���JVM�������ػ��߳�GC
        daemonThread.setDaemon(true);
        daemonThread.start();
    }
}
