package cn.mldn.demo.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {

    public static void main(String[] args) throws Exception {
        System.out.println("Lesson 5.155.UDP���򡪡�server��");

        DatagramSocket server = new DatagramSocket(9000);

        String str = "Hello world world leo leo!!!";

        DatagramPacket packet = new DatagramPacket(str.getBytes(), 0, str.length(), InetAddress.getByName("localhost"),
            9999);
        server.send(packet);

        System.out.println("��Ϣ������ɡ�");

    }
}
