package cn.mldn.demo;

class MyTicketThread implements Runnable//�߳�������
{

    private String title;
    private int ticket = 5;

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (this.ticket > 0) {
                System.out.println(this.title + "��Ʊ��ticket = " + this.ticket--);
            }
        }
    }
}

public class TicketDemo {

    public static void main(String[] args) {
        ///*
        //��ͨrunnableʹ��
        MyTicketThread ticket = new MyTicketThread();

        new Thread(ticket).start();
        new Thread(ticket).start();
        new Thread(ticket).start();
        //*/
		
		/*
		//lambda���ʽʵ��
		for(int x = 0; x < 3; x++)
		{
			String title = "�̶߳���-" + x;
			Runnable run = ()->
			{
				for(int y = 0; y < 10; y++)
				{
					System.out.println(title + "����.y=" + y);
				}				
			};
			
			new Thread(run).start();
		}
		*/
		
		/*
		//lambda���ʽʵ�־���汾
		for(int x = 0; x < 3; x++)
		{
			String title = "�̶߳���-" + x;

			new Thread(()->
			{
				for(int y = 0; y < 10; y++)
				{
					System.out.println(title + "����.y=" + y);
				}				
			}).start();
		}
		*/

    }
}
