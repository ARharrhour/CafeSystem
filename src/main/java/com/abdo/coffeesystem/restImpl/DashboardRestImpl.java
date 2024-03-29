package com.abdo.coffeesystem.restImpl;

import com.abdo.coffeesystem.rest.DashboardRest;
import com.abdo.coffeesystem.service.DashboardService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@AllArgsConstructor
public class DashboardRestImpl implements DashboardRest {


    private DashboardService dashboardService;
    @Override
    public ResponseEntity<Map<String, Object>> getCount() {
        return dashboardService.getCount();
    }
}