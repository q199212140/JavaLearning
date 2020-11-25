package com.sunil.sun.promdemo.httpsimulator;

/**
 * @ClassName SampleBean
 * @Description TODO
 * @Author jian.sun.qd
 * @Date 25/11/2020 10:04
 * @Version 1.0
 **/

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.binder.MeterBinder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import org.springframework.stereotype.Component;

@Component
public class SampleBean implements MeterBinder {

    private Counter job1Counter;
    private Counter job2Counter;
    private MeterRegistry meterRegistry;

    public Map<String, Double> map;

    SampleBean() {
        map = new HashMap<>();
    }

    @Override
    public void bindTo(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
//        this.job1Counter = Counter.builder("http_requests_total")
//            .description("description-Job counter1 execute count").register(meterRegistry);

        this.job2Counter = Counter.builder("counter_builder_job_counter2")
            .tags(new String[]{"name", "tag_job_counter2"})
            .description("description-Job counter2 execute count ").register(meterRegistry);

        Gauge.builder("http_request_duration_milliseconds", map, x -> x.get("x"))
            .tags("name", "tag_job_gauge")
            .description("description-Job gauge")
            .register(meterRegistry);
    }

    /**
     * 获得动态count
     *
     * @param endpoint
     * @param status
     * @return
     */
    public void increment(String endpoint, String status) {
        String[] tags = new String[]{"endpoint", endpoint, "status", status};
        meterRegistry.counter("http_requests_total", tags).increment();
    }

    public Counter getJob2Counter() {
        return this.job2Counter;
    }
}