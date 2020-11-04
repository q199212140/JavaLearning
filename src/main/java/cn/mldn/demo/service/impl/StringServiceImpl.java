package cn.mldn.demo.service.impl;

import cn.mldn.demo.service.IStringService;

public class StringServiceImpl implements IStringService
{
    private StringBuffer data = new StringBuffer();
    
    @Override
    public void append(String str)
    {
        // TODO Auto-generated method stub
        this.data.append(str).append("|");
    }

    @Override
    public String[] reverse()
    {
        // TODO Auto-generated method stub
        String result[] = this.data.toString().split("\\|");
        int center = result.length/2;
        int head = 0;
        int tail = result.length - 1;
        
        for(int x = 0; x < center; x++)
        {
            String temp = result[head];
            result[head] = result[tail];
            result[tail] = temp;
        }
        return result;
    }
}
