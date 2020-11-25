package com.sunil.sun.promdemo.httpsimulator;

import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;

public class ActivitySimulator implements Runnable {

    private SimulatorOpts opts;

    private Random rand = new Random();

    private boolean spikeMode = false;

    private volatile boolean shutdown = false;

    @Autowired
    SampleBean sampleBean;

    /**
     * 产生用于计数的数据
     */
//    private final Counter httpRequestsTotal = Counter.build()
//        .name("http_requests_total")
//        .help("Total number of http requests by response status code")
//        .labelNames("endpoint", "status")
//        .register();

    /**
     * 产生用于画直方图的数据
     */
//    private final Histogram httpRequestDurationMs = Histogram.build()
//        .name("http_request_duration_milliseconds")
//        .help("Http request latency histogram")
//        .exponentialBuckets(25, 2, 7)
//        .labelNames("endpoint", "status")
//        .register();

    /**
     * 有参模拟器构造方法
     *
     * @param opts
     */
    public ActivitySimulator(SimulatorOpts opts) {
        this.opts = opts;
        System.out.println(opts);
    }


    /**
     * 停止模拟器
     */
    public void shutdown() {
        this.shutdown = true;
    }

    public void updateOpts(SimulatorOpts opts) {
        this.opts = opts;
    }

    /**
     * 设置模式
     *
     * @param mode
     * @return
     */
    public boolean setSpikeMode(String mode) {
        boolean result = true;
        switch (mode) {
            case "on":
                opts.setSpikeMode(SpikeMode.ON);
                System.out.println("Spike mode is set to " + mode);
                break;
            case "off":
                opts.setSpikeMode(SpikeMode.OFF);
                System.out.println("Spike mode is set to " + mode);
                break;
            case "random":
                opts.setSpikeMode(SpikeMode.RANDOM);
                System.out.println("Spike mode is set to " + mode);
                break;
            default:
                result = false;
                System.out.println("Can't recognize spike mode " + mode);
        }
        return result;
    }

    /**
     * 设置错误率
     *
     * @param rate
     */
    public void setErrorRate(int rate) {
        if (rate > 100) {
            rate = 100;
        }
        if (rate < 0) {
            rate = 0;
        }
        opts.setErrorRate(rate);
        System.out.println("Error rate is set to " + rate);
    }

    public SimulatorOpts getOpts() {
        return this.opts;
    }

    public void simulateActivity(SampleBean sampleBean) {
        //取当前设置
        int requestRate = this.opts.getRequestRate();

        //如果开启随机，则请求率设置为当前设置乘以(5-15)
        if (this.giveSpikeMode()) {
            requestRate *= (5 + this.rand.nextInt(10));
        }

        //   (请求率,70)  获得波动后数值
        int nbRequests = this.giveWithUncertainty(requestRate, this.opts.getRequestRateUncertainty());
        for (int i = 0; i < nbRequests; i++) {
            String statusCode = this.giveStatusCode();
            String endpoint = this.giveEndpoint();
            sampleBean.increment(endpoint, statusCode);

            int latency = this.giveLatency(statusCode);
            if (this.spikeMode) {
                latency *= 2;
            }
            //this.httpRequestDurationMs.labels(endpoint, statusCode).observe(latency);

        }
    }

    /**
     * 根据模式设置 开关
     *
     * @return
     */
    public boolean giveSpikeMode() {
        switch (this.opts.getSpikeMode()) {
            case ON:
                this.spikeMode = true;
                break;
            case OFF:
                this.spikeMode = false;
                break;
            case RANDOM:
                int n = rand.nextInt(100);
                /**
                 * 随机在0 - start 之间开启； start - 100 之间关闭
                 * opts.spike_start_chance=5
                 * opts.spike_end_chance=30
                 */
                if (!this.spikeMode && n < this.opts.getSpikeStartChance()) {
                    this.spikeMode = true;
                } else if (this.spikeMode && n < this.opts.getSpikeEndChance()) {
                    this.spikeMode = false;
                }
                break;
        }

        return this.spikeMode;
    }

    /**
     * 获得波动值，默认   n  + (  -7n ~ 7n  )
     *
     * @param n
     * @param u
     * @return
     */
    public int giveWithUncertainty(int n, int u) {
        int delta = this.rand.nextInt(n * u / 50) - (n * u / 100);
        return n + delta;
    }

    /**
     * 获取错误率，默认1%
     *
     * @return
     */
    public String giveStatusCode() {
        if (this.rand.nextInt(100) < this.opts.getErrorRate()) {
            return "500";
        } else {
            return "200";
        }
    }

    /**
     * 获取接口路径，列表中随机取
     *
     * @return
     */
    public String giveEndpoint() {
        int n = this.rand.nextInt(this.opts.getEndopints().length);
        return this.opts.getEndopints()[n];
    }

    /**
     * 模拟延迟
     *
     * @param statusCode
     * @return
     */
    public int giveLatency(String statusCode) {
        //如果返回错误，返回5-55
        if (!"200".equals(statusCode)) {
            return 5 + this.rand.nextInt(50);
        }

        //随机0-99
        int p = this.rand.nextInt(100);

        if (p < 50) {
            // (10~25 ， 70)波动数值
            return this.giveWithUncertainty(
                this.opts.getLatencyMin() + this.rand.nextInt(this.opts.getLatencyP50() - this.opts.getLatencyMin()),
                this.opts.getLatencyUncertainty());
        }
        if (p < 90) {
            // (25~150 ， 70)波动数值
            return this.giveWithUncertainty(
                this.opts.getLatencyP50() + this.rand.nextInt(this.opts.getLatencyP90() - this.opts.getLatencyP50()),
                this.opts.getLatencyUncertainty());
        }
        if (p < 99) {
            // (150~750 ， 70)波动数值
            return this.giveWithUncertainty(
                this.opts.getLatencyP90() + this.rand.nextInt(this.opts.getLatencyP99() - this.opts.getLatencyP90()),
                this.opts.getLatencyUncertainty());
        }

        // (750-10000 ， 70)波动数值
        return this.giveWithUncertainty(
            this.opts.getLatencyP99() + this.rand.nextInt(this.opts.getLatencyMax() - this.opts.getLatencyP99()),
            this.opts.getLatencyUncertainty());
    }


    /**
     * 循环产生数据
     */
    @Override
    public void run() {
        while (!shutdown) {
            SampleBean sampleBean = ApplicationContextProvider.getBean(SampleBean.class);

            System.out.println("Simulator is running...");
            try {
                this.simulateActivity(sampleBean);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

//    private void addCount(String endpoint, String statusCode, int num) {
//        Counter counter = this.customMeterRegistry.counter("test.server.counter", endpoint, statusCode);
//        counter.increment(num);
//        System.out.println(counter.measure());
//    }
}
