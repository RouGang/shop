package com.shop.auth.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Hikaru on 17/7/12.
 */
@RestController
public class HelloController {


		@RequestMapping("/hello")
		public String hello(){

				return "hello";
		}
}
