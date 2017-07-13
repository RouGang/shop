package com.hikaru.trubine;

/**
 * Created by Hikaru on 17/7/12.
 */
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * 通过@EnableTurbine接口，激活对Turbine的支持。
 * @author eacdy
 */
@SpringBootApplication
@EnableTurbine
public class Application {
		public static void main(String[] args) {
				new SpringApplicationBuilder(Application.class).web(true).run(args);
		}
}
