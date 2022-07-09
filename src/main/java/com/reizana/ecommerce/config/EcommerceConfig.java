package com.reizana.ecommerce.config;

import com.reizana.ecommerce.Order;
import com.reizana.ecommerce.Store;
import com.reizana.ecommerce.User;
import com.reizana.ecommerce.repository.OrderRepository;
import com.reizana.ecommerce.repository.StoreRepository;
import com.reizana.ecommerce.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class EcommerceConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository,
                                        OrderRepository orderRepository,
                                        StoreRepository storeRepository) {
        return args -> {
            User reizan = new User(
                    "Reizan",
                    "general lima 500",
                    "visa debit-card",
                    "headset tune710bt"
            );
            Order reizanOrder = new Order(
                    "payed",
                    "headset",
                    "general lima 500",
                    "successful",
                    "delivered, on the way",
                    1
            );
            Store pichau = new Store(
                    "headset",
                    1
            );
            User felipe = new User(
                    "Felipe",
                    "general lima 500",
                    "visa credit-card",
                    "sand-cat"
            );
            Order felipeOrder = new Order(
                    "payed",
                    "sand-cat",
                    "general lima 500",
                    "successful",
                    "delivered, on the way",
                    2

            );
            Store amazon = new Store(
                    "sand-cat",
                    2
            );

            userRepository.saveAll(List.of(reizan,felipe));
            orderRepository.saveAll(List.of(reizanOrder,felipeOrder));
            storeRepository.saveAll(List.of(pichau,amazon));
        };
    }
}
