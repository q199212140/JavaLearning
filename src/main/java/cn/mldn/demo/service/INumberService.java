package cn.mldn.demo.service;

//接口类的好处——有一个标准
public interface INumberService
{
    /**
     * 输入数据并返回输入数据的最大值与最小值
     * @param count 表示要输入数据的个数
     * @return 包含有2个内容，最大值+ 最小值
     */
    public int[] stat(int count);
    
    /**
     * 统计奇偶数
     * @return
     */
    public int[] countParity();
}
