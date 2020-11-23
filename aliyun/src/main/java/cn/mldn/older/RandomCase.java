package cn.mldn.older;

import java.util.Arrays;
import java.util.Random;

class NumberFactory {

    private static Random random = new Random();

    /**
     * ͨ�����������ָ�����������飬������0
     *
     * @param len ���鳤��
     * @return �������
     */
    public static int[] create(int len) {
        int data[] = new int[len];
        int foot = 0;
        while (foot < data.length) {
            int num = random.nextInt(30);
            if (num != 0) {
                data[foot++] = num;
            }
        }

        return data;
    }
}

public class RandomCase {

    public static void main(String[] args) {
        System.out.println("lesson 60 ������飺");

        int retult[] = NumberFactory.create(5);
        System.out.println(Arrays.toString(retult));
    }
}
