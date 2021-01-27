//package io.spring2go.promdemo.httpsimulator;
//
//import io.micrometer.core.instrument.Clock;
//import io.micrometer.core.instrument.step.StepMeterRegistry;
//import io.micrometer.core.instrument.util.NamedThreadFactory;
//import java.util.concurrent.TimeUnit;
//
///**
// * @ClassName CustomMeterRegistry
// * @Description TODO
// * @Author jian.sun.qd
// * @Date 24/11/2020 17:54
// * @Version 1.0
// **/
//public class CustomMeterRegistry extends StepMeterRegistry {
//
//    public CustomMeterRegistry(CustomRegistryConfig config, Clock clock) {
//        super(config, clock);
//
//        start(new NamedThreadFactory("custom-metrics-publisher"));
//    }
//
//    @Override
//    protected void publish() {
//        getMeters().stream().forEach(meter -> System.out.println("Publishing " + meter.getId()));
//    }
//
//    @Override
//    protected TimeUnit getBaseTimeUnit() {
//        return TimeUnit.MILLISECONDS;
//    }
//
//}