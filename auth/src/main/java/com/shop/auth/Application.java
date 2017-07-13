package com.shop.auth;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.sleuth.zipkin.ZipkinSpanReporter;
import org.springframework.context.annotation.Bean;
import zipkin.Span;

/**
 * Created by Hikaru on 17/6/16.
 */

@SpringBootApplication
@EnableDiscoveryClient
public class Application {

  private static Log logger = LogFactory.getLog(Application.class);

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

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
