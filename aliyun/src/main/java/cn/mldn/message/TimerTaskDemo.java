package cn.mldn.message;

import java.util.Timer;
import java.util.TimerTask;

class TimerTestTask extends TimerTask {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "��ʱ����ִ�У���ǰʱ�䣺" + System.currentTimeMillis());
    }
}

public class TimerTaskDemo {

    public static void main(String[] args) {
        System.out.println("��ʱ���ȣ�");

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTestTask(), 100, 1000);
    }
}
