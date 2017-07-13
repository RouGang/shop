package com.shop.cms.invoke.auth.fallback;

import com.shop.cms.invoke.auth.HelloFeignController;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * Created by Hikaru on 17/7/12.
 */
@Component
public class HelloFeignFallBack implements FallbackFactory<HelloFeignController> {

		@Override public HelloFeignController create(Throwable throwable) {
				return new HelloFeignController() {
						@Override public String hello() {
								System.out.println(throwable.getMessage());
								return "失败";
						}
				};
		}
}
