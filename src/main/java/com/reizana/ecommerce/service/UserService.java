package com.reizana.ecommerce.service;

import com.reizana.ecommerce.User;
import com.reizana.ecommerce.View;
import com.reizana.ecommerce.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public List<View> findUsersInfoById(Integer userId) {
        List<View> view = userRepository.findUsersInfoById(userId);
        return view;
    }

    public void addUsersInfo(User user) {
        userRepository.save(user);
    }

    @Transactional
    public void updateUser(Integer userId, String username, String password, String adress,
                           String paymentMethod, String userOrders) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException(
                        "user with id " + userId + " already exists"));
        if (username != null &&
            username.length() > 0 &&
            !Objects.equals(user.getUsername(), username)) {
            user.setUsername(username);
        }
        if (password != null &&
                password.length() > 0 &&
                !Objects.equals(user.getPassword(), password)) {
            user.setPassword(password);
        }
        if (adress != null &&
                adress.length() > 0 &&
                !Objects.equals(user.getAdress(), adress)) {
            user.setAdress(adress);
        }
        if (paymentMethod != null &&
                paymentMethod.length() > 0 &&
                !Objects.equals(user.getPaymentMethod(), paymentMethod)) {
            user.setPaymentMethod(paymentMethod);
        }
        if (userOrders != null &&
                userOrders.length() > 0 &&
                !Objects.equals(user.getUserOrders(), userOrders)) {
            user.setUserOrders(userOrders);
        }
    }

    public void deleteUserById(Integer userId) {
        userRepository.deleteById(userId);
    }

}
