package com.hikaru.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import zipkin.server.EnableZipkinServer;

/**
 * Created by Hikaru on 17/7/12.
 */
@SpringBootApplication
@EnableZipkinServer
public class Application {

		public static void main(String[] args) {
				SpringApplication.run(Application.class, args);
		}
}
