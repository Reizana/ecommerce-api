package com.reizana.ecommerce.service;

import com.reizana.ecommerce.controller.dto.ProductDto;
import com.reizana.ecommerce.controller.dto.StoreDto;
import com.reizana.ecommerce.domain.Product;
import com.reizana.ecommerce.domain.Store;
import com.reizana.ecommerce.repository.ProductRepository;
import com.reizana.ecommerce.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;
    private final ProductRepository productRepository;

    public List<Store> findAll() {
        return storeRepository.findAll();
    }

//    public void addProduct(Store store) {
//        Optional<String> product = storeRepository.
//                findAllProducts(store.getProduct());
//        if (product.isPresent()) {
//            throw new IllegalStateException("Product already exist");
//        }
//        storeRepository.save(store);
//    }

    public void deleteStore(Integer storeId) {
        storeRepository.deleteById(storeId);
    }

    public Store addStore(StoreDto store) {
        Store newStore = Store.builder()
                .name(store.getName())
                .description(store.getDescription())
                .address(store.getAddress())
                .build();
        return storeRepository.save(newStore);
    }

    public Product addProduct(Integer idStore, ProductDto product) {
        Product newProduct = Product.builder()
                .name(product.getName())
                .description(product.getDescription())
                .imageUrl(product.getImageUrl())
                .price(product.getPrice())
                .build();
        Optional<Store> optionalStore = storeRepository.findById(idStore);
        if (optionalStore.isEmpty()) {
            throw new RuntimeException("Store nao existe");
        }
        Store store = optionalStore.get();
        store.setProducts(null);
        newProduct.setStore(store);
        newProduct.setId(UUID.randomUUID().toString());
        Product savedProduct = productRepository.save(newProduct);

        return savedProduct;
    }
}
