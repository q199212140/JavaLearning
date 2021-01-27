package cn.mldn.demo.service;

//�ӿ���ĺô�������һ����׼
public interface INumberService {

    /**
     * �������ݲ������������ݵ����ֵ����Сֵ
     *
     * @param count ��ʾҪ�������ݵĸ���
     * @return ������2�����ݣ����ֵ+ ��Сֵ
     */
    public int[] stat(int count);

    /**
     * ͳ����ż��
     *
     * @return
     */
    public int[] countParity();
}
