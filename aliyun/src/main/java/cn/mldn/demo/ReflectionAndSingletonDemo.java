package cn.mldn.demo;

class ReflectionSingleton {

    //volatile ����ʵ������Ӧ���������ڴ��е����ݶ������ͬ��
    private static volatile ReflectionSingleton instance = null;

    private ReflectionSingleton() {
        System.out.println("[" + Thread.currentThread().getName() + "]" + "ʵ���� ReflectionSingleton����");
    }

    //public static synchronized ReflectionSingleton getInstance()�ᵼ�������������л������ܽ���
    public static ReflectionSingleton getInstance() {
        if (null == instance) {
            //ֻ��Ҫinstance�������ʱ����Ҫ��ͬ��
            synchronized (ReflectionSingleton.class) {
                if (null == instance) {
                    instance = new ReflectionSingleton();
                }
            }
        }

        return instance;
    }

    public void print() {
        System.out.println("[����] Hello world!");
    }
}

public class ReflectionAndSingletonDemo {

    public static void main(String[] args) {
        System.out.println("Lesson 6.103 �����뵥�����ģʽ");

        for (int x = 0; x < 3; x++) {
            new Thread(() -> {
                ReflectionSingleton.getInstance().print();
            }, "�������Ѷ�-" + x).start();
            ;
        }
    }
}
