package com.abdo.coffeesystem.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;


@RequestMapping("/api/dashboard")
public interface DashboardRest {
    @GetMapping(path = "/details")
    ResponseEntity<Map<String , Object>> getCount();

}