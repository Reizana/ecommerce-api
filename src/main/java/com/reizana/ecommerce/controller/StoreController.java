package com.reizana.ecommerce.controller;

import com.reizana.ecommerce.controller.dto.ProductDto;
import com.reizana.ecommerce.controller.dto.StoreDto;
import com.reizana.ecommerce.domain.Product;
import com.reizana.ecommerce.domain.Store;
import com.reizana.ecommerce.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "stores")
@RequiredArgsConstructor
public class StoreController {

    private final StoreService storeService;

    @GetMapping
    public List<Store> storeList() {
        return storeService.findAll();
    }

    @PostMapping
    public ResponseEntity<Store> addStore(@RequestBody StoreDto store) {
        return ResponseEntity.ok(storeService.addStore(store));
    }

    @PostMapping("{idStore}/products")
    public ResponseEntity<Product> addProduct(@PathVariable Integer idStore, @RequestBody ProductDto product) {
        return ResponseEntity.ok(storeService.addProduct(idStore, product));
    }

    @DeleteMapping(path = "{storeId}")
    public void deleteStore(
            @PathVariable("storeId") Integer storeId) {
        storeService.deleteStore(storeId);
    }
}
