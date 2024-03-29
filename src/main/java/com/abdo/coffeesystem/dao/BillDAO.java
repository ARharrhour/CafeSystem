package com.abdo.coffeesystem.dao;

import com.abdo.coffeesystem.entites.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BillDAO extends JpaRepository<Bill, Integer> {
        List<Bill> getAllBills();
        List<Bill> getBillByUserName(@Param("username") String username);
        }