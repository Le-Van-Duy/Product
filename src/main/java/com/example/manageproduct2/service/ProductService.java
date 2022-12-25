package com.example.manageproduct2.service;

import com.example.manageproduct2.dto.ProductDTO;
import com.example.manageproduct2.model.Product;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getAll(String searchByName,Double searchByPrice);

    ProductDTO save(ProductDTO productDTO);

    ProductDTO update(Long id, ProductDTO productDTO);

    ProductDTO getById(Long id);

    void delete(Long id);
}
