package com.reizana.ecommerce.service;

import com.reizana.ecommerce.User;
import com.reizana.ecommerce.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void addUsersInfo(@RequestBody User user) {
        //FIXME: Corrigir post não esta funcionando da maneira que deveria
        userRepository.save(user);
    }
}
