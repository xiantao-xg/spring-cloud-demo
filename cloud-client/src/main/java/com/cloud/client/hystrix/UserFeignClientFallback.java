package com.cloud.client.hystrix;

import com.cloud.client.fein.UserFeignClient;
import com.library.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserFeignClientFallback implements UserFeignClient {
    @Override
    public List<User> getAllUser() {
        List<User> users = new ArrayList<>();
        User user = new User();
        user.setName("this is the fallback user name");
        users.add(user);
        return users;
    }
}
