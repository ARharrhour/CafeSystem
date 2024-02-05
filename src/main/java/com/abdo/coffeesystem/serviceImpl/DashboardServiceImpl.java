package com.abdo.coffeesystem.serviceImpl;

import com.abdo.coffeesystem.dao.BillDAO;
import com.abdo.coffeesystem.dao.CategoryDAO;
import com.abdo.coffeesystem.dao.ProductDAO;
import com.abdo.coffeesystem.service.DashboardService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@Service
@Slf4j
public class DashboardServiceImpl implements DashboardService {

    private CategoryDAO categoryDAO;
    private ProductDAO productDAO;
    private BillDAO billDAO;
    @Override
    public ResponseEntity<Map<String, Object>> getCount() {

        log.info("inside getCount {}");
        Map<String,Object> map=new HashMap<>();
        map.put("category",categoryDAO.count());
        map.put("product",productDAO.count());
        map.put("bill",billDAO.count());

        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}
