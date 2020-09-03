package cn.mldn.demo.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient
{
    public static void main(String[] args) throws Exception
    {
        System.out.println("Lesson 5.155.UDP程序——client：");
        
        DatagramSocket client = new DatagramSocket(9999);
        byte data[] = new byte[1024];
        
        DatagramPacket packet = new DatagramPacket(data, data.length, InetAddress.getByName("localhost"), 9999);
        System.out.println("客户端等待接收消息。。。");
        
        client.receive(packet);
        System.out.println("接收到的消息内容为：" + new String(data, 0, packet.getLength()));
        
        client.close();
    }
}
