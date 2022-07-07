package com.reizana.ecommerce.controller;

import com.reizana.ecommerce.Store;
import com.reizana.ecommerce.service.StoreService;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RequestMapping(path = "stores")
@RestController
public class StoreController {

    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping
    public List<Store> storeList() {
        return storeService.findAll();
    }

    @PostMapping
    public void addProduct(@RequestBody Store store) {
        storeService.addProduct(store);
    }
}