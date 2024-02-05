package com.abdo.coffeesystem.rest;


import com.abdo.coffeesystem.entites.Category;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/api/categories")
public interface CategoryRest {
    @PostMapping(path = "/add")
    ResponseEntity<String> addNewCategory(@RequestBody Map<String, String> requestMap);

    @GetMapping(path = "/get")
    ResponseEntity<List<Category>> getAllCategory(@RequestParam(required = false) String Value);

    @PostMapping(path = "/update")
    ResponseEntity<String> update(@RequestBody Map<String, String> requestMap);

}