package com.reizana.ecommerce.controller;

import com.reizana.ecommerce.User;
import com.reizana.ecommerce.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "users")
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> userList() {
        return userService.findAll();
    }

    @PostMapping
    public void addUsersInfo(User user) {
        userService.addUsersInfo(user);
    }

}
