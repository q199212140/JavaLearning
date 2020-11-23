package cn.mldn.demo.echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {

    private static final BufferedReader KEYBOARD_INPUT = new BufferedReader(new InputStreamReader(System.in));

    public static String getString(String prompt) throws IOException {
        System.out.print(prompt);
        String str = KEYBOARD_INPUT.readLine();
        return str;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Lesson 5.153.Echo����ģ��:EchoClient:");

        Socket client = new Socket("localhost", 9999);

        //���롢���֧��  Scanner PrintWriter
        //���շ������˵���������
        Scanner scan = new Scanner(client.getInputStream());
        scan.useDelimiter("\n");

        //��������˷�������
        PrintStream out = new PrintStream(client.getOutputStream());

        boolean flag = true;
        while (flag) {
            String input = getString("�����Ҫ���͵����ݣ�").trim();
            out.println(input);

            if (scan.hasNext()) {
                System.out.println(scan.next());
            }

            if ("byebye".equalsIgnoreCase(input)) {
                flag = false;
            }
        }

        scan.close();
        out.close();
        client.close();
    }
}
