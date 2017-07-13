package com.shop.cms.invoke.auth;

import com.shop.cms.invoke.auth.fallback.HelloFeignFallBack;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Hikaru on 17/7/12.
 */
@FeignClient(name = "auth",fallbackFactory = HelloFeignFallBack.class)
public interface HelloFeignController {

  @RequestMapping(value = "/hello",method = RequestMethod.GET)
  public String hello();
}
