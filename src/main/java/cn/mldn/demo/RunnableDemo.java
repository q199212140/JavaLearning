package cn.mldn.demo;

class MyRunnableThread implements Runnable//线程主体类
{
	private String title;

	public MyRunnableThread(String title)
	{
		this.title = title;
	}
	
	@Override
	public void run()
	{
		for(int i = 0; i < 10; i++)
		{
			System.out.println(this.title + "运行：x = " + i);
		}
	}
}

public class RunnableDemo 
{
	public static void main(String[] args) 
	{
		///*
		//普通runnable使用
		Thread myRunnableA = new Thread(new MyRunnableThread("线程A"));
		Thread myRunnableB = new Thread(new MyRunnableThread("线程B"));
		Thread myRunnableC = new Thread(new MyRunnableThread("线程C"));
		myRunnableA.start();
		myRunnableB.start();
		myRunnableC.start();
		//*/
		
		/*
		//lambda表达式实现
		for(int x = 0; x < 3; x++)
		{
			String title = "线程对象-" + x;
			Runnable run = ()->
			{
				for(int y = 0; y < 10; y++)
				{
					System.out.println(title + "运行.y=" + y);
				}				
			};
			
			new Thread(run).start();
		}
		*/
		
		/*
		//lambda表达式实现精简版本
		for(int x = 0; x < 3; x++)
		{
			String title = "线程对象-" + x;

			new Thread(()->
			{
				for(int y = 0; y < 10; y++)
				{
					System.out.println(title + "运行.y=" + y);
				}				
			}).start();
		}
		*/
		
	}
}
