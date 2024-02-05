package com.abdo.coffeesystem.rest;

import com.abdo.coffeesystem.wrapper.ProductWrapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RequestMapping("/api/products")
public interface ProductRest {

    @PostMapping(path = "/add")
    ResponseEntity<String> addNewProduct(@RequestBody Map<String, String> requestMap);

    @GetMapping(path = "/get")
    ResponseEntity<List<ProductWrapper>> getAllProduct();

    @PostMapping(path = "/update")
    ResponseEntity<String> update(@RequestBody Map<String, String> requestMap);

    @PostMapping(path = "/delete/{id}")
    ResponseEntity<String> delete(@PathVariable Integer id);

    @GetMapping(path = "/getByCategory/{id}")
    ResponseEntity<List<ProductWrapper>> getByCategory(@PathVariable Integer id);

    @GetMapping(path = "/getProductById/{id}")
    ResponseEntity<ProductWrapper> getProductById(@PathVariable Integer id);

    @PostMapping(path = "/updateProductStatus")
    ResponseEntity<String> updateProductStatus(@RequestBody Map<String, String> requestMap);


}