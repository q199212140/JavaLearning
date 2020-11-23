/*
 * �����������Ҫ������3���������̣߳�ͬʱ��������ָ�����ɹ��߸�����ʾ��δ����ɹ��ĸ���ʧ����ʾ
 * �漰���ݷ��أ�ʹ��Callable�Ϸ���*/

package cn.mldn.demo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class AuctionAnswerThread implements Callable<String> {

    private boolean auctionEnable = false;

    @Override
    public String call() throws Exception {
        synchronized (this)//����ͬ��
        {
            if (false == this.auctionEnable) {
                this.auctionEnable = true;
                return Thread.currentThread().getName() + "����ɹ���";
            } else {
                return Thread.currentThread().getName() + "����ʧ�ܣ�";
            }
        }
    }
}

public class MultiThreadAuctionAnswer {

    public static void main(String[] args) {
        AuctionAnswerThread at = new AuctionAnswerThread();
        FutureTask<String> taskA = new FutureTask<String>(at);
        FutureTask<String> taskB = new FutureTask<String>(at);
        FutureTask<String> taskC = new FutureTask<String>(at);
        new Thread(taskA, "������A").start();
        new Thread(taskB, "������B").start();
        new Thread(taskC, "������C").start();
        try {
            System.out.println(taskA.get());//��ȡ�̷߳���ֵ(������)����ӡ
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            System.out.println(taskB.get());
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            System.out.println(taskC.get());
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
