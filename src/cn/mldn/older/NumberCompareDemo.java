package cn.mldn.older;

import cn.mldn.demo.factory.Factory;
import cn.mldn.demo.service.INumberService;

public class NumberCompareDemo
{
    public static void main(String[] args)
    {
        System.out.println("Lesson 6.91 ���ִ�С�Ƚϣ�����3��������3���������Сֵ���������ʱ������������");
        
        INumberService numberService = Factory.getInstance();
        int result [] =  numberService.stat(5);
        System.out.println("���ֵ��" + result[0] + "��" + "��Сֵ" + result[1]);
    }
}
