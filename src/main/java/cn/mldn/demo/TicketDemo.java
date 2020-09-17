package cn.mldn.demo;

class MyTicketThread implements Runnable//线程主体类
{
	private String title;
	private int ticket = 5;

	@Override
	public void run()
	{
		for(int i = 0; i < 100; i++)
		{
			if(this.ticket > 0)
			{
				System.out.println(this.title + "卖票：ticket = " + this.ticket --);
			}
		}
	}
}

public class TicketDemo 
{
	public static void main(String[] args) 
	{
		///*
		//普通runnable使用
		MyTicketThread ticket = new MyTicketThread();

		new Thread(ticket).start();
		new Thread(ticket).start();
		new Thread(ticket).start();
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
