package cn.mldn.demo;

class TicketThread implements Runnable {

    private int ticket = 10;

    public synchronized boolean sale() {
        if (this.ticket > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "��Ʊ��ticket = " + this.ticket--);
            return true;
        } else {
            System.out.println("Ʊ�Ѿ����⡣");
            return false;
        }
    }

    @Override
    public void run() {
        while (this.sale()) {
            ;
            /*
            //ͬ������鷽��ʵ��ͬ��
            synchronized(this)//��ÿһ��ֻ����һ���̷߳���
            {
                if(this.ticket > 0)
                {
                    try
                    {
                        Thread.sleep(100);
                    } catch (InterruptedException e)
                    {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "��Ʊ��ticket = " + this.ticket--);
                }
                else
                {
                    System.out.println("Ʊ�Ѿ����⡣");
                    break;
                }
            }
            */
        }
    }
}

public class ThreadSyncAndDeadLock {

    public static void main(String[] args) {
        TicketThread tt = new TicketThread();
        new Thread(tt, "Ʊ����A").start();
        new Thread(tt, "Ʊ����B").start();
        new Thread(tt, "Ʊ����C").start();
    }
}
