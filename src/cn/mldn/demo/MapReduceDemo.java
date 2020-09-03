package cn.mldn.demo;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;

class Order
{
    private String name;
    private double price;
    private int amount;//商品数量
    
    public Order(String name, double price, int amount)
    {
        super();
        this.name   = name;
        this.price  = price;
        this.amount = amount;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public int getAmount()
    {
        return amount;
    }

    public void setAmount(int amount)
    {
        this.amount = amount;
    }
    
    
    
}

public class MapReduceDemo
{
    public static void main(String[] args)
    {
        System.out.println("Lesson 5.151.MapReduce基础模型:");
        
        //数据分析之前，需要把所有数据保存到集合中
        List<Order> all = new ArrayList<Order>();
        
        all.add(new Order("小强娃娃", 9.9, 10));
        all.add(new Order("林弱充气娃娃", 2994.5, 3));
        all.add(new Order("不强笔记本电脑", 9889.9, 8));
        all.add(new Order("若强茶杯", 2.9, 500));
        all.add(new Order("阿强煎饼", 0.9, 159));
        
        System.out.println("分析带强字的商品数据：进行商品单价和数量的处理：");
        
        //算法代码描述不直观，可读性差
        DoubleSummaryStatistics stat =  all.stream().filter(ele->ele.getName().contains("强"))
        .mapToDouble((orderObject)->orderObject.getPrice() * orderObject.getAmount()).summaryStatistics();
        
        System.out.println("购买数量：" + stat.getCount());
        System.out.println("购买总价：" + stat.getSum());
        System.out.println("平均花费：" + stat.getAverage());
        System.out.println("最高花费：" + stat.getMax());
        System.out.println("最低花费：" + stat.getMin());
    }
}
