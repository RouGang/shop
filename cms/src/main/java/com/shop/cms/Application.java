package com.shop.cms;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.sleuth.zipkin.ZipkinSpanReporter;
import org.springframework.context.annotation.Bean;

import zipkin.Span;

/**
 * Created by Hikaru on 17/7/12.
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages="com.shop.cms.invoke")
@EnableCircuitBreaker
@EnableHystrix
public class Application {
		public static void main(String[] args) {
				SpringApplication.run(Application.class, args);
		}
		private static Log logger = LogFactory.getLog(Application.class);

		// Use this for debugging (or if there is no Zipkin server running on port 9411)
		@Bean
		@ConditionalOnProperty(value = "sample.zipkin.enabled", havingValue = "false")
		public ZipkinSpanReporter spanCollector() {
				return new ZipkinSpanReporter() {
						@Override
						public void report(Span span) {
								logger.info(span);
						}
				};
		}
}
