package com.example.manageproduct2.service.impl;

import com.example.manageproduct2.dto.BrandDTO;
import com.example.manageproduct2.model.Brand;
import com.example.manageproduct2.repository.BrandRepository;
import com.example.manageproduct2.service.BrandService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    BrandRepository brandRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<BrandDTO> getAll() {
        List<Brand> brands = brandRepository.findAll();
        List<BrandDTO> brandDTOS = new ArrayList<>();
        for (Brand br : brands) {
            brandDTOS.add(modelMapper.map(br, BrandDTO.class));

        }
        return brandDTOS;
    }
}
