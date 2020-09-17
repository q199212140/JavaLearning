package cn.mldn.older;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

class SendThread implements Runnable
{
    private PipedOutputStream output;//�ܵ������
    
    public SendThread()
    {
        this.output = new PipedOutputStream();//ʵ�����ܵ������
    }
    
    @Override
    public void run()
    {
        for (int i = 0; i < 10; i++)
        {
            try
            {
                this.output.write(("��" + (i + 1) + "����Ϣ����-" + Thread.currentThread().getName() +  ":hello world��\n").getBytes());
            } catch (IOException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        try
        {
            this.output.close();
        } catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public PipedOutputStream getOutput()
    {
        return output;
    }
}

class ReceiveThread implements Runnable
{
    private PipedInputStream input;
    
    public ReceiveThread()
    {
        this.input = new PipedInputStream();
    }
    
    @Override
    public void run()
    {       
        byte data[] = new byte[1024];
        int len = 0;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();//�������ݱ��浽�ڴ������
        
        try
        {
            while((len = this.input.read(data)) != -1)
            {
                bos.write(data, 0, len);
            }
            System.out.println("[" + Thread.currentThread().getName() + "] ������Ϣ\n" + new String(bos.toByteArray()));
            bos.close();
        } catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
               
        try
        {
            this.input.close();
        } catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public PipedInputStream getInput()
    {
        return input;
    }
}

public class PipedStreamDemo
{
    public static void main(String[] args) throws Exception
    {
        System.out.println("Lesson 6.82 �ܵ��� : ͨ���ܵ�ʵ���̼߳�ͨ��");
        
        SendThread send = new SendThread();
        ReceiveThread receive = new ReceiveThread();
        
        send.getOutput().connect(receive.getInput());
        new Thread(send, "��Ϣ�����߳�").start();
        new Thread(receive, "��Ϣ�����߳�").start();
        
    }
}
