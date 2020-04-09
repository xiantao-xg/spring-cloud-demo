package com.cloud.client.fein;

import com.cloud.client.hystrix.UserFeignClientFallback;
import com.library.entity.User;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@FeignClient(name = "cloud-provider", fallback = UserFeignClientFallback.class)
public interface UserFeignClient {

    @RequestMapping(value = "/getAllUser", method = RequestMethod.GET)
    List<User> getAllUser();
}