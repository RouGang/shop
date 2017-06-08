package com.hikaru.discovery;

/**
 * Created by Hikaru on 17/6/8.
 */
public class Application {

    @SpringBootApplication
    @EnableEurekaServer
    public class Application {
        public static void main(String[] args) {
            SpringApplication.run(Application.class, args);
        }
    }
}
