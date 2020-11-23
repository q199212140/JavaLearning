package cn.mldn.demo.echo;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {

    private static class ClientThread implements Runnable {

        //������ͬ�Ŀͻ���
        private Socket client = null;
        private Scanner scan = null;
        private PrintStream out = null;
        boolean flag = true;

        public ClientThread(Socket client) throws Exception {
            super();
            this.client = client;

            //�ͻ���������
            this.scan = new Scanner(client.getInputStream());

            //���÷ָ���
            this.scan.useDelimiter("\n");

            //�ͻ���������
            this.out = new PrintStream(client.getOutputStream());
        }

        public void run() {
            while (this.flag) {
                if (this.scan.hasNext()) {
                    String val = this.scan.next().trim();
                    if ("byebye".equalsIgnoreCase(val)) {
                        out.println("ByeByeBye...");
                        this.flag = false;
                    } else {
                        out.println("[ECHO]" + val);
                    }
                }
            }

            try {
                scan.close();
                client.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Lesson 5.153.Echo����ģ��:EchoServer:");

        ServerSocket server = new ServerSocket(9999);
        System.out.println("��9999�˿ڵȴ��ͻ������� ... ");

        //ѭ�����տͻ�������
        boolean flag = true;
        while (flag) {
            Socket client = server.accept();
            new Thread(new ClientThread(client)).start();

        }

        server.close();
    }
}
