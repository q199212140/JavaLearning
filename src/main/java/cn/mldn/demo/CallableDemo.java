/*
 * 利用Callable实现线程
 * */

package cn.mldn.demo;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

class MyCallableThread implements Callable<String>
{
	@Override
	public String call() throws Exception
	{
		for (int i = 0; i < 10; i++)
		{
			System.out.println("线程执行：x = " + i);
		}
		return "线程执行完毕";
	}
}

public class CallableDemo {
	public static void main(String[] args) throws Exception
	{
		FutureTask<String> task = new FutureTask<>(new MyCallableThread());
		new Thread(task).start();
		System.out.println("获得线程返回结果数据： " + task.get());
	}	
}
