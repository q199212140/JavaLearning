package cn.mldn.demo.service.impl;

import cn.mldn.demo.service.INumberService;
import cn.mldn.util.InputUtil;

public class NumberServiceImpl implements INumberService {

    @Override
    public int[] stat(int count) {
        // TODO Auto-generated method stub
        int result[] = new int[2];
        int data[] = new int[count];
        for (int x = 0; x < data.length; x++) {
            data[x] = InputUtil.getInt("������ڡ�" + (x + 1) + "�������֣�");
        }

        result[0] = data[0];//���ֵ
        result[1] = data[1];//��Сֵ

        for (int x = 0; x < data.length; x++) {
            if (data[x] > result[0]) {
                result[0] = data[x];
            }

            if (data[x] < result[1]) {
                result[1] = data[x];
            }
        }

        return result;
    }

    @Override
    public int[] countParity() {
        int numCnt[] = new int[]{0, 0};//ż����������������
        // TODO Auto-generated method stub
        String str = InputUtil.getString("���������ִ���");
        String result[] = str.split("");

        for (int x = 0; x < result.length; x++) {
            if (Integer.parseInt(result[x]) % 2 == 0) {
                numCnt[0]++;
            } else {
                numCnt[1]++;
            }
        }

        return numCnt;
    }

}
