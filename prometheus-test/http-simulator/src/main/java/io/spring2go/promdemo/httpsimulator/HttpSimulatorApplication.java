package io.spring2go.promdemo.httpsimulator;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;


//springboot 1.x用
//import io.prometheus.client.spring.boot.EnablePrometheusEndpoint;
//@EnablePrometheusEndpoint

@Controller
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class,
    DataSourceTransactionManagerAutoConfiguration.class, RedisAutoConfiguration.class})
public class HttpSimulatorApplication implements ApplicationListener<ContextClosedEvent> {

    @Autowired
    private SimulatorOpts opts;

    private ActivitySimulator simulator;

    public static void main(String[] args) {

        SpringApplication.run(HttpSimulatorApplication.class, args);
    }


    /**
     * 获取模拟器设置
     *
     * @return
     */
    @RequestMapping(value = "/opts")
    public @ResponseBody
    String getOps() {
        return opts.toString();
    }


    /**
     * 开启spike模式，on/off/random
     *
     * @param mode
     * @return
     */
    @RequestMapping(value = "/spike/{mode}", method = RequestMethod.POST)
    public @ResponseBody
    String setSpikeMode(@PathVariable("mode") String mode) {
        boolean result = simulator.setSpikeMode(mode);
        if (result) {
            return "ok";
        } else {
            return "wrong spike mode " + mode;
        }
    }


    /**
     * 设置模拟的错误率
     *
     * @param errorRate
     * @return
     */
    @RequestMapping(value = "error_rate/{error_rate}", method = RequestMethod.POST)
    public @ResponseBody
    String setErrorRate(@PathVariable("error_rate") int errorRate) {
        simulator.setErrorRate(errorRate);
        return "ok";
    }


    @Bean
    public TaskExecutor taskExecutor() {
        return new SimpleAsyncTaskExecutor();
    }


    /**
     * 启动自动开启模拟器
     *
     * @param executor
     * @return
     */
    @Bean
    public CommandLineRunner schedulingRunner(TaskExecutor executor) {
        return args -> {
            simulator = new ActivitySimulator(opts);
            executor.execute(simulator);
            System.out.println("Simulator thread started...");
        };
    }


    /**
     * 停止模拟器
     *
     * @param event
     */
    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        simulator.shutdown();
        System.out.println("Simulator shutdown...");
    }

    @Bean
    MeterRegistryCustomizer<MeterRegistry> configurer(@Value("${spring.application.name}") String applicationName) {
        return registry -> registry.config().commonTags("application", applicationName);
    }

}
