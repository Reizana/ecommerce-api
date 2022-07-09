package com.reizana.ecommerce.controller;

import com.reizana.ecommerce.User;
import com.reizana.ecommerce.View;
import com.reizana.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "users")
@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> userList() {
        return userService.findAll();
    }

    @GetMapping("{userId}")
    public List<View> findAllOrdersById(@PathVariable("userId") Integer userId) {
        return userService.findUsersInfoById(userId);
    }

    @PostMapping
    public void addUsersInfo(User user) {
        userService.addUsersInfo(user);
    }

    @PutMapping(path = "{userId}")
    public void updateUser(
            @PathVariable("userId") Integer userId,
            @RequestParam(required = false) String username,
            @RequestParam(required = false) String password,
            @RequestParam(required = false) String adress,
            @RequestParam(required = false) String paymentMethod,
            @RequestParam(required = false) String userOrders) {
                userService.updateUser(userId, username, password, adress, paymentMethod, userOrders);
    }

    @DeleteMapping(path = "{userId}")
    public void deleteUserById(
            @PathVariable("userId") Integer userId) {
        userService.deleteUserById(userId);
    }
}
