package com.cloud.client.fein;

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

@FeignClient(name = "cloud-provider", fallbackFactory = FeignClientFallbackFactory.class)
public interface UserFeignClient {

    @RequestMapping(value = "/getAllUser", method = RequestMethod.GET)
    List<User> getAllUser();
}

/**
 * UserFeignClient的fallbackFactory类，该类需实现FallbackFactory接口，并覆写create方法
 */
@Component
class FeignClientFallbackFactory implements FallbackFactory<UserFeignClient> {
    private static final Logger LOGGER = LoggerFactory.getLogger(FeignClientFallbackFactory.class);

    @Override
    public UserFeignClient create(Throwable cause) {
        UserFeignClient client =  new UserFeignClient() {
            @Override
            public List<User> getAllUser() {
                FeignClientFallbackFactory.LOGGER.info("fallback; reason was:", cause);
                List<User> users = new ArrayList<>();
                return users;
            }
        };
//        UserFeignClient client =  new UserFeignClient() {
//            @Override
//            public List<User> getAllUser() {
//                FeignClientFallbackFactory.LOGGER.info("fallback; reason was:", cause);
//                List<User> users = new ArrayList<>();
//                return users;
//            }
//        };
        return client;
    }
}