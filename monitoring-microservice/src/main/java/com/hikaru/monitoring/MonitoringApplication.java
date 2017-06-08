package com.hikaru.monitoring;

/**
 * Created by Hikaru on 17/6/8.
 */

@SpringBootApplication
@EnableTurbineStream
@EnableHystrixDashboard
public class MonitoringApplication {

    public static void main(String[] args) {
        SpringApplication.run(MonitoringApplication.class, args);
    }
}