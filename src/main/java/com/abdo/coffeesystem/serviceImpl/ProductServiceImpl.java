package com.abdo.coffeesystem.serviceImpl;

import com.abdo.coffeesystem.constants.CoffeeConstants;
import com.abdo.coffeesystem.dao.ProductDAO;
import com.abdo.coffeesystem.entites.Category;
import com.abdo.coffeesystem.entites.Product;
import com.abdo.coffeesystem.service.ProductService;
import com.abdo.coffeesystem.utils.CoffeeUtils;
import com.abdo.coffeesystem.wrapper.ProductWrapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Service
@Slf4j
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private ProductDAO productDAO;

    @Override
    public ResponseEntity<String> addNewProduct(Map<String, String> requestMap) {
        log.info("Inside addNewProduct{}", requestMap);
        try {
            if (true) {
                if (validateProductMap(requestMap, false)) {
                    productDAO.save(getProductFromMap(requestMap, false));
                    return CoffeeUtils.getResponseEntity("Product Added Successfully", HttpStatus.OK);
                }
            } else {
                return CoffeeUtils.getResponseEntity(CoffeeConstants.UNAUTHORIZED_ACCESS, HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return CoffeeUtils.getResponseEntity(CoffeeConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<List<ProductWrapper>> getAllProduct() {
        try {
            return new ResponseEntity<>(productDAO.getAllProduct(), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> update(Map<String, String> requestMap) {
        try {
            if (true) {
                if (validateProductMap(requestMap, true)) {
                    Optional<Product> optional = productDAO.findById(Integer.parseInt(requestMap.get("id")));
                    if (optional.isPresent()) {
                        productDAO.save(getProductFromMap(requestMap, true));
                        return CoffeeUtils.getResponseEntity("Product is updated successfully", HttpStatus.OK);

                    } else {
                        return CoffeeUtils.getResponseEntity("Product id doesn't exist", HttpStatus.OK);
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

    @Override
    public ResponseEntity<String> delete(Integer id) {
        try {
            if (true) {
                Optional<Product> optional = productDAO.findById(id);
                if (optional.isPresent()) {
                    productDAO.deleteById(id);
                    return CoffeeUtils.getResponseEntity("Product is deleted successfully", HttpStatus.OK);
                }
                return CoffeeUtils.getResponseEntity("Product id doesn't exist", HttpStatus.OK);
            } else {
                return CoffeeUtils.getResponseEntity(CoffeeConstants.UNAUTHORIZED_ACCESS, HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return CoffeeUtils.getResponseEntity(CoffeeConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<List<ProductWrapper>> getByCategory(Integer id) {
        try {
            return new ResponseEntity<>(productDAO.getByCategory(id), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<ProductWrapper> getProductById(Integer id) {
        try {
            return new ResponseEntity<>(productDAO.getProductById(id), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<>(new ProductWrapper(), HttpStatus.INTERNAL_SERVER_ERROR);

    }


    @Modifying
    @Transactional
    @Override
    public ResponseEntity<String> updateProductStatus(Map<String, String> requestMap) {
        try {
            if (true) {
                Optional<Product> optional = productDAO.findById(Integer.parseInt(requestMap.get("id")));
                if (optional.isPresent()) {
                    productDAO.updateProductStatus(requestMap.get("status"), Integer.parseInt(requestMap.get("id")));
                    return CoffeeUtils.getResponseEntity("Product status is updated successfully", HttpStatus.OK);
                }
                return CoffeeUtils.getResponseEntity("Product id doesn't exist", HttpStatus.OK);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return CoffeeUtils.getResponseEntity(CoffeeConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    private boolean validateProductMap(Map<String, String> requestMap, boolean validateId) {
        if (requestMap.containsKey("name")) {
            if (requestMap.containsKey("id") && validateId) {
                return true;
            } else if (!validateId) {
                return true;
            }
        }
        return false;
    }
    private Product getProductFromMap(Map<String, String> requestMap, boolean isAdd) {
        Product product = new Product();
        Category category = new Category();
        category.setId(Integer.parseInt(requestMap.get("categoryId")));

        if (isAdd) {
            product.setId(Integer.parseInt(requestMap.get("id")));
        } else {
            product.setStatus("true");
        }
        product.setCategory(category);
        product.setName(requestMap.get("name"));
        product.setDescription(requestMap.get("description"));
        product.setPrice(Integer.parseInt(requestMap.get("price")));
        product.setStatus(String.valueOf(isAdd));

        return product;
    }
}
