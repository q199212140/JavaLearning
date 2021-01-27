//package io.spring2go.promdemo.httpsimulator;
//
//import io.micrometer.core.instrument.step.StepRegistryConfig;
//
///**
// * @ClassName CustomRegistryConfig
// * @Description TODO
// * @Author jian.sun.qd
// * @Date 24/11/2020 17:54
// * @Version 1.0
// **/
//public interface CustomRegistryConfig extends StepRegistryConfig {
//
//    CustomRegistryConfig DEFAULT = k -> null;
//
//    @Override
//    default String prefix() {
//        return "custom";
//    }
//
//}