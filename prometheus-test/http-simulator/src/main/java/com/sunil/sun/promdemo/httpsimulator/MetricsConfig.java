//package io.spring2go.promdemo.httpsimulator;
//
//import io.micrometer.core.instrument.Clock;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * @ClassName MetricsConfig
// * @Description TODO
// * @Author jian.sun.qd
// * @Date 24/11/2020 17:55
// * @Version 1.0
// **/
//@Configuration
//public class MetricsConfig {
//
//    @Bean
//    public CustomRegistryConfig customRegistryConfig() {
//        return CustomRegistryConfig.DEFAULT;
//    }
//
//    @Bean
//    public CustomMeterRegistry customMeterRegistry(CustomRegistryConfig customRegistryConfig, Clock clock) {
//        return new CustomMeterRegistry(customRegistryConfig, clock);
//    }
//
//}