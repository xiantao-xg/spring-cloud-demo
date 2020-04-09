package com.cloud.client.controller;

import com.cloud.client.fein.UserFeignClient;
import com.library.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/getAllUser")
    public List<User> getAllUser() {
        return userFeignClient.getAllUser();
    }
}
