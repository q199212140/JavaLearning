package cn.mldn.demo;

import java.math.BigInteger;

public class BigNumberDemo
{
    public static void main(String[] args)
    {
        BigInteger bigA = new BigInteger("9339339393939393939393939");
        BigInteger bigB = new BigInteger("9339939");
        
        System.out.println("\n大数操作：");
        System.out.println("大数加法：" + bigA.add(bigB));
        System.out.println("大数减法：" + bigA.subtract(bigB));
        System.out.println("大数乘法：" + bigA.multiply(bigB));
        System.out.println("大数除法：" + bigA.add(bigB));
        
        BigInteger result [] = bigA.divideAndRemainder(bigB);
        System.out.println("大数求余： 商=" + result[0] + "、 余数=" +result[1]);
    }
}
