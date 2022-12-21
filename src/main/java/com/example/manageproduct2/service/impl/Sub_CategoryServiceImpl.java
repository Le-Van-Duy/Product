package com.example.manageproduct2.service.impl;

import com.example.manageproduct2.dto.Sub_CategoryDTO;
import com.example.manageproduct2.model.Sub_Category;
import com.example.manageproduct2.repository.Sub_CategoryRepository;
import com.example.manageproduct2.service.Sub_CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Sub_CategoryServiceImpl implements Sub_CategoryService {
    @Autowired
    Sub_CategoryRepository subCategoryRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<Sub_CategoryDTO> getAll() {
        List<Sub_Category> sub_categories = subCategoryRepository.findAll();
        List<Sub_CategoryDTO> sub_categoryDTOS = new ArrayList<>();
        for (Sub_Category sc : sub_categories) {
            sub_categoryDTOS.add(modelMapper.map(sc, Sub_CategoryDTO.class));
        }
        return sub_categoryDTOS;
    }
}
