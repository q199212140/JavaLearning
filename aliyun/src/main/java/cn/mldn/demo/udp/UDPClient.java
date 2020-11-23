package cn.mldn.demo.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {

    public static void main(String[] args) throws Exception {
        System.out.println("Lesson 5.155.UDP���򡪡�client��");

        DatagramSocket client = new DatagramSocket(9999);
        byte data[] = new byte[1024];

        DatagramPacket packet = new DatagramPacket(data, data.length, InetAddress.getByName("localhost"), 9999);
        System.out.println("�ͻ��˵ȴ�������Ϣ������");

        client.receive(packet);
        System.out.println("���յ�����Ϣ����Ϊ��" + new String(data, 0, packet.getLength()));

        client.close();
    }
}
