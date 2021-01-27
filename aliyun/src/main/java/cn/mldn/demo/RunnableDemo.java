package cn.mldn.demo;

class MyRunnableThread implements Runnable//�߳�������
{

    private String title;

    public MyRunnableThread(String title) {
        this.title = title;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(this.title + "���У�x = " + i);
        }
    }
}

public class RunnableDemo {

    public static void main(String[] args) {
        ///*
        //��ͨrunnableʹ��
        Thread myRunnableA = new Thread(new MyRunnableThread("�߳�A"));
        Thread myRunnableB = new Thread(new MyRunnableThread("�߳�B"));
        Thread myRunnableC = new Thread(new MyRunnableThread("�߳�C"));
        myRunnableA.start();
        myRunnableB.start();
        myRunnableC.start();
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
