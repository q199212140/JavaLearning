package cn.mldn.demo;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;

class Order {

    private String name;
    private double price;
    private int amount;//��Ʒ����

    public Order(String name, double price, int amount) {
        super();
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


}

public class MapReduceDemo {

    public static void main(String[] args) {
        System.out.println("Lesson 5.151.MapReduce����ģ��:");

        //���ݷ���֮ǰ����Ҫ���������ݱ��浽������
        List<Order> all = new ArrayList<Order>();

        all.add(new Order("Сǿ����", 9.9, 10));
        all.add(new Order("������������", 2994.5, 3));
        all.add(new Order("��ǿ�ʼǱ�����", 9889.9, 8));
        all.add(new Order("��ǿ�豭", 2.9, 500));
        all.add(new Order("��ǿ���", 0.9, 159));

        System.out.println("������ǿ�ֵ���Ʒ���ݣ�������Ʒ���ۺ������Ĵ���");

        //�㷨����������ֱ�ۣ��ɶ��Բ�
        DoubleSummaryStatistics stat = all.stream().filter(ele -> ele.getName().contains("ǿ"))
            .mapToDouble((orderObject) -> orderObject.getPrice() * orderObject.getAmount()).summaryStatistics();

        System.out.println("����������" + stat.getCount());
        System.out.println("�����ܼۣ�" + stat.getSum());
        System.out.println("ƽ�����ѣ�" + stat.getAverage());
        System.out.println("��߻��ѣ�" + stat.getMax());
        System.out.println("��ͻ��ѣ�" + stat.getMin());
    }
}
