package com.abdo.coffeesystem.restImpl;

import com.abdo.coffeesystem.constants.CoffeeConstants;
import com.abdo.coffeesystem.dao.CategoryDAO;
import com.abdo.coffeesystem.entites.Category;
import com.abdo.coffeesystem.rest.CategoryRest;
import com.abdo.coffeesystem.service.CategoryService;
import com.abdo.coffeesystem.utils.CoffeeUtils;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
public class CategoryRestImpl implements CategoryRest {

    private CategoryService categoryService;

    private CategoryDAO categoryDAO;

    @Override
    public ResponseEntity<String> addNewCategory(Map<String, String> requestMap) {
        try {

            return categoryService.addNewCategory(requestMap);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //System.out.println("Before return");
        return CoffeeUtils.getResponseEntity(CoffeeConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<List<Category>> getAllCategory(String Value) {
        try {
            return categoryService.getAllCategory(Value);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> update(Map<String, String> requestMap) {
        try {
            return categoryService.update(requestMap);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return CoffeeUtils.getResponseEntity(CoffeeConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}