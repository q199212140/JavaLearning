package cn.mldn.demo;

import java.math.BigInteger;

public class BigNumberDemo {

    public static void main(String[] args) {
        BigInteger bigA = new BigInteger("9339339393939393939393939");
        BigInteger bigB = new BigInteger("9339939");

        System.out.println("\n����������");
        System.out.println("�����ӷ���" + bigA.add(bigB));
        System.out.println("����������" + bigA.subtract(bigB));
        System.out.println("�����˷���" + bigA.multiply(bigB));
        System.out.println("����������" + bigA.add(bigB));

        BigInteger result[] = bigA.divideAndRemainder(bigB);
        System.out.println("�������ࣺ ��=" + result[0] + "�� ����=" + result[1]);
    }
}
