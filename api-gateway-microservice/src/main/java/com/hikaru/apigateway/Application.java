package com.hikaru.apigateway;

import com.hikaru.apigateway.filter.AccessFilter;

/**
 * Created by Hikaru on 17/6/8.
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public AccessFilter accessFilter() {
        return new AccessFilter();
    }

}