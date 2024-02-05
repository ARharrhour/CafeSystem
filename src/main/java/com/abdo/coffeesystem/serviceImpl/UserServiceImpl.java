package com.abdo.coffeesystem.serviceImpl;

import com.abdo.coffeesystem.service.UserService;
import com.abdo.coffeesystem.wrapper.UserWrapper;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    @Override
    public ResponseEntity<String> signUp(Map<String, String> requestMap) {
        return null;
    }

    @Override
    public ResponseEntity<String> login(Map<String, String> requestMap) {
        return null;
    }

    @Override
    public ResponseEntity<List<UserWrapper>> getAllUser() {
        return null;
    }

    @Override
    public ResponseEntity<String> update(Map<String, String> requestMap) {
        return null;
    }

    @Override
    public ResponseEntity<String> checkToken() {
        return null;
    }

    @Override
    public ResponseEntity<String> changePassword(Map<String, String> requestMap) {
        return null;
    }

    @Override
    public ResponseEntity<String> forgetPassword(Map<String, String> requestMap) {
        return null;
    }
}
