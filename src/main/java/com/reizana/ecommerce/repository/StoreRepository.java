package com.reizana.ecommerce.repository;

import com.reizana.ecommerce.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StoreRepository extends JpaRepository<Store, Integer> {

    @Query(value = "SELECT s.product FROM stores s WHERE s.product = ?1", nativeQuery = true)
    Optional<String> findAllProducts(String product);

}
