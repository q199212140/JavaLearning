/*
 * ����Callableʵ���߳�
 * */

package cn.mldn.demo;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

class MyCallableThread implements Callable<String> {

    @Override
    public String call() throws Exception {
        for (int i = 0; i < 10; i++) {
            System.out.println("�߳�ִ�У�x = " + i);
        }
        return "�߳�ִ�����";
    }
}

public class CallableDemo {

    public static void main(String[] args) throws Exception {
        FutureTask<String> task = new FutureTask<>(new MyCallableThread());
        new Thread(task).start();
        System.out.println("����̷߳��ؽ�����ݣ� " + task.get());
    }
}
