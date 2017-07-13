package com.shop.cms.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.cms.invoke.auth.HelloFeignController;

/**
 * Created by Hikaru on 17/7/12.
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

  @Autowired
  private HelloFeignController helloFeignController;

  @RequestMapping("/test")
  public String hello() {
		  String str = "";
		  long begTime = System.currentTimeMillis();

		  try{
				   str = this.helloFeignController.hello();
		  }catch(Exception e){
				  e.printStackTrace();
		  }finally {
				System.out.println(System.currentTimeMillis() - begTime);
		  }

    return str;
  }
		@RequestMapping("test2")
		public String hello2(){
				return "hello2";
		}
}
