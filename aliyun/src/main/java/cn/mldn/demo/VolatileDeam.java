package cn.mldn.demo;

class VolatileThread implements Runnable {

    private volatile int ticket = 10;

    @Override
    public void run() {
        synchronized (this) {
            while (this.ticket > 0) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "�� ��Ʊ���� ticket = " + this.ticket--);
            }
        }
    }
}

public class VolatileDeam {

    public static void main(String[] args) {
        VolatileThread vt = new VolatileThread();
        new Thread(vt, "Ʊ����A").start();
        new Thread(vt, "Ʊ����B").start();
        new Thread(vt, "Ʊ����C").start();
    }
}
