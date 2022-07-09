package com.reizana.ecommerce.repository;

import com.reizana.ecommerce.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {


}
