package com.example.manageproduct2.service.impl;

import com.example.manageproduct2.repository.CategoryRepository;
import com.example.manageproduct2.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

}
