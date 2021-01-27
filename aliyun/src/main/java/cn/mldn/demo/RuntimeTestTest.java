package cn.mldn.demo;

public class RuntimeTestTest {

    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        System.out.println("\n\nruntime test��");

        System.out.print("availableProcessors = ");
        System.out.println(runtime.availableProcessors());

        System.out.print("totalMemory = ");
        System.out.println(runtime.totalMemory() / 1024 / 1024);

        System.out.print("maxMemory = ");
        System.out.println(runtime.maxMemory() / 1024 / 1024);

        System.out.print("freeMemory = ");
        System.out.println(runtime.freeMemory() / 1024 / 1024);

        //��ʱͳ��
        long startT = 0;
        startT = System.currentTimeMillis();

        String str = "";
        for (int i = 0; i < 30000; i++) {
            str += i;
        }

        long endT = 0;
        endT = System.currentTimeMillis();

        System.out.println("\n t for while : " + (endT - startT));

        System.out.println("\nmemory comsumering ..........");
        System.out.print("totalMemory = ");
        System.out.println(runtime.totalMemory() / 1024 / 1024);

        System.out.print("maxMemory = ");
        System.out.println(runtime.maxMemory() / 1024 / 1024);

        System.out.print("freeMemory = ");
        System.out.println(runtime.freeMemory() / 1024 / 1024);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        runtime.gc();

        System.out.println("\ngc ..........");
        System.out.print("totalMemory = ");
        System.out.println(runtime.totalMemory() / 1024 / 1024);

        System.out.print("maxMemory = ");
        System.out.println(runtime.maxMemory() / 1024 / 1024);

        System.out.print("freeMemory = ");
        System.out.println(runtime.freeMemory() / 1024 / 1024);
    }
}
