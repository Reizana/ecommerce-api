package com.reizana.ecommerce.service;

import com.reizana.ecommerce.Store;
import com.reizana.ecommerce.repository.StoreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StoreService {

    private final StoreRepository storeRepository;

    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }


    public List<Store> findAll() {
        return storeRepository.findAll();
    }

    public void addProduct(Store store) {
        Optional<String> product = storeRepository.
                findAllProducts(store.getProduct());
        if (product.isPresent()) {
            throw new IllegalStateException("Product already exist");
        }
        storeRepository.save(store);
    }
}
