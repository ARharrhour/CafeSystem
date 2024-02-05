package com.abdo.coffeesystem.serviceImpl;

import com.abdo.coffeesystem.constants.CoffeeConstants;
import com.abdo.coffeesystem.dao.CategoryDAO;
import com.abdo.coffeesystem.entites.Category;
import com.abdo.coffeesystem.service.CategoryService;
import com.abdo.coffeesystem.utils.CoffeeUtils;
import com.google.common.base.Strings;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Service
@Slf4j
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private CategoryDAO categoryDAO;

    @Override
    public ResponseEntity<String> addNewCategory(Map<String, String> requestMap) {

        log.info("Inside addNewCategory{}", requestMap);
        try {
            if(true){
                if(validateCategoryMap(requestMap, false)){
                    categoryDAO.save(getCategoryFromMap(requestMap , false));
                    return CoffeeUtils.getResponseEntity("Category Added Successfully", HttpStatus.OK);
                }
            }else{
                return CoffeeUtils.getResponseEntity(CoffeeConstants.UNAUTHORIZED_ACCESS, HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return CoffeeUtils.getResponseEntity(CoffeeConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);


    }

    @Override
    public ResponseEntity<List<Category>> getAllCategory(String Value) {
        try {
            if(!Strings.isNullOrEmpty(Value) && Value.equalsIgnoreCase("true")) {
                return new ResponseEntity<List<Category>>(new ArrayList<Category>(), HttpStatus.OK);
            }
            return new ResponseEntity<>(categoryDAO.findAll(), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<List<Category>>(new ArrayList<Category>(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> update(Map<String, String> requestMap) {
        try {
            if (true) {
                if (validateCategoryMap(requestMap , true)) {

                    Optional<Category> optional = categoryDAO.findById(Integer.parseInt(requestMap.get("id")));

                    if (optional.isPresent()) {
                        categoryDAO.save(getCategoryFromMap(requestMap,true));
                        return CoffeeUtils.getResponseEntity("Category is updated successfully", HttpStatus.OK);

                    } else {
                        return CoffeeUtils.getResponseEntity("Category id doesn't exist", HttpStatus.OK);
                    }

                }
                return CoffeeUtils.getResponseEntity(CoffeeConstants.INVALID_DATA, HttpStatus.BAD_REQUEST);
            } else {
                return CoffeeUtils.getResponseEntity(CoffeeConstants.UNAUTHORIZED_ACCESS, HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return CoffeeUtils.getResponseEntity(CoffeeConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    private Category getCategoryFromMap(Map<String, String> requestMap, boolean isAdd) {
        Category category = new Category();
        if(isAdd){
            category.setId(Integer.parseInt(requestMap.get("id")));
        }
        category.setName(requestMap.get("name"));
        return category;
    }
    private boolean validateCategoryMap(Map<String, String> requestMap, boolean validateId) {
        if (requestMap.containsKey("name")) {
            if(requestMap.containsKey("id") && validateId){
                return true;
            }else if(!validateId){
                return true;
            }
        }
        return false;
    }

}
