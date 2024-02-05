package com.abdo.coffeesystem.dao;

import com.abdo.coffeesystem.entites.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryDAO extends JpaRepository<Category, Integer> {
    List<Category> getAllCategory();

}