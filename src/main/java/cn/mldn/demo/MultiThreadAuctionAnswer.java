/*
 * 竞拍抢答程序，要求设置3个抢答者线程，同时发出抢答指令，抢答成功者给出提示，未抢答成功的给出失败提示
 * 涉及数据返回，使用Callable较方便*/

package cn.mldn.demo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class AuctionAnswerThread implements Callable<String>
{
    private boolean auctionEnable = false;
    
    @Override
    public String call() throws Exception
    {
        synchronized (this)//数据同步
        {
            if(false == this.auctionEnable)
            {
                this.auctionEnable = true;
                return Thread.currentThread().getName() + "抢答成功！";
            }
            else
            {
                return Thread.currentThread().getName() + "抢答失败！";
            }
        }
    }
}

public class MultiThreadAuctionAnswer
{
    public static void main(String[] args)
    {
        AuctionAnswerThread at = new AuctionAnswerThread();
        FutureTask<String> taskA = new FutureTask<String>(at);
        FutureTask<String> taskB = new FutureTask<String>(at);
        FutureTask<String> taskC = new FutureTask<String>(at);
        new Thread(taskA, "竞拍者A").start();
        new Thread(taskB, "竞拍者B").start();
        new Thread(taskC, "竞拍者C").start();
        try
        {
            System.out.println(taskA.get());//获取线程返回值(抢答结果)并打印
        } catch (InterruptedException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        try
        {
            System.out.println(taskB.get());
        } catch (InterruptedException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        try
        {
            System.out.println(taskC.get());
        } catch (InterruptedException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
