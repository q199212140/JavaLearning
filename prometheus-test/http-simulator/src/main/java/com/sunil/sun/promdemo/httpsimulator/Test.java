package com.sunil.sun.promdemo.httpsimulator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @ClassName Test
 * @Description TODO
 * @Author jian.sun.qd
 * @Date 25/11/2020 10:17
 * @Version 1.0
 **/
@Component
@EnableScheduling
public class Test {

    private Integer count1 = 0;

    @Autowired
    private SampleBean jobMetrics;


    /**
     * 定时任务触发
     */
    @Scheduled(cron = "0/1 * * * * *")
    private void test() {
        count1++;
        jobMetrics.getJob2Counter().increment();
        jobMetrics.map.put("x", Double.valueOf(count1));
        System.out.println("task1 count:" + count1);
        if(count1%2==0){
            System.out.println("%5==0");
            jobMetrics.map.put("x", Double.valueOf(1));
        }
    }

}
