package cn.mldn.demo;

import java.util.Random;

public class RandomDemo {

    public static void main(String[] args) {
        Random rand = new Random();
        System.out.println("Random����ԣ�");
        for (int i = 0; i < 10; i++) {
            System.out.print(rand.nextInt(100) + "��");
        }

        /*������0�������ظ�*/
        System.out.println("\n\n������ɲ�Ʊ��[36ѡ7]��");
        int data[] = new int[7];
        int foot = 0;

        while (foot < 7) {
            int num = rand.nextInt(37);
            if (isAvailable(num, data)) {
                data[foot++] = num;
            }
        }

        java.util.Arrays.sort(data);
        for (int idx = 0; idx < data.length; idx++) {
            System.out.print(data[idx] + "��");
        }
    }

    /**
     * �жϴ���������Ƿ����ʹ��=����������֮��
     *
     * @param num
     * @param tmp
     * @return
     */
    public static boolean isAvailable(int num, int tmp[]) {
        if (0 == num) {
            return false;
        }
        for (int x = 0; x < tmp.length; x++) {
            if (num == tmp[x]) {
                return false;
            }
        }
        return true;
    }
}
