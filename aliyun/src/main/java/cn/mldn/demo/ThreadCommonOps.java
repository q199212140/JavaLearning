package cn.mldn.demo;

class NameThread implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}


public class ThreadCommonOps {

    public static void main(String[] args) {
        System.out.println("5.8���̵߳�������ȡ��:");

        NameThread testNameThread = new NameThread();

        new Thread(testNameThread, "�߳�A").start();
        new Thread(testNameThread).start();
        new Thread(testNameThread).start();
        new Thread(testNameThread).start();
        new Thread(testNameThread, "�߳�B").start();

        System.out.println("\n\n����ֱ�ӵ���:");
        testNameThread.run();//����ֱ�ӵ��ã�main

        //lambda���ʽ�����̴߳���
        System.out.println("\n\n���߳�Ӧ�þ���:");
        new Thread(
            () -> {
                int tmp = 0;
                for (int i = 0; i < Integer.MAX_VALUE; i++) {
                    tmp += i;
                }
                System.out.println("\n\n���߳��м�����ɡ�");
            }
        ).start();

        System.out.println("\n\n�߳����߲��Կ�ʼ:");
        for (int threadIdx = 0; threadIdx < 5; threadIdx++) {
            new Thread(
                () -> {
                    for (int x = 0; x < 10; x++) {
                        System.out.println(Thread.currentThread().getName() + "��x = " + x);
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        System.out.println("�߳����߲�����ɡ�");
                    }
                }, "���߲��Ե��̶߳���_" + threadIdx).start();
        }

        System.out.println("\n\n�߳��жϲ��Կ�ʼ:");
        Thread interruptThread = new Thread(() ->
        {
            System.out.println("��˯���ˡ�");

            try {
                Thread.sleep(10000);
                System.out.println("˯���ˡ�");
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                System.out.println("������˯��������");
                e.printStackTrace();
            }
        });

        interruptThread.start();//��ʼ˯

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if (!interruptThread.isInterrupted()) {
            System.out.println("͵͵����һ�����˯�ߣ�haha��");
            interruptThread.interrupt();
        }
        System.out.println("�߳��жϲ�����ɡ�");

        System.out.println("\n\n�߳�ǿ��ִ�в��Կ�ʼ��");
        Thread mainThread = Thread.currentThread();

        Thread forceThread = new Thread(() ->
        {
            for (int i = 0; i < 100; i++) {
                if (i == 3) {
                    try {
                        mainThread.join();//���߳���ִ��
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " : ����������ִ�У�i = " + i);
            }
        }, "����������");
        forceThread.start();

        for (int i = 0; i < 100; i++) {
            System.out.println("����������ִ�У�i = " + i);
        }

        System.out.println("�߳�ǿ��ִ�в�����ɡ�");

        System.out.println("\n\n�߳����ò��Կ�ʼ��");
        Thread mainThread1 = Thread.currentThread();

        Thread forceThread1 = new Thread(() ->
        {
            for (int i = 0; i < 100; i++) {
                if (i % 3 == 0) {
                    mainThread1.yield();//���߳���ִ��
                    System.out.println("���߳�����ִ�С�");
                }
                System.out.println(Thread.currentThread().getName() + " : ����������ִ�У�i = " + i);
            }
        }, "����������");
        forceThread1.start();

        for (int i = 0; i < 100; i++) {
            System.out.println("����������ִ�У�i = " + i);
        }

        System.out.println("�߳����ò�����ɡ�");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("\n\n�߳����ȼ����Կ�ʼ");
        System.out.println("\n\n���߳����ȼ� = " + Thread.currentThread().getPriority());
        System.out.println("\n\nĬ�����߳����ȼ� = " + new Thread().getPriority());
        Runnable run = () ->
        {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " ִ�С�");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        };
        Thread threadA = new Thread(run, "���ȼ��̶߳���A");
        Thread threadB = new Thread(run, "���ȼ��̶߳���B");
        Thread threadC = new Thread(run, "���ȼ��̶߳���C");

        threadA.setPriority(Thread.MIN_PRIORITY);
        threadB.setPriority(Thread.MIN_PRIORITY);
        threadC.setPriority(Thread.MAX_PRIORITY);
        threadA.start();
        threadB.start();
        threadC.start();

        System.out.println("�߳����ȼ�������ɡ�");
    }
}
