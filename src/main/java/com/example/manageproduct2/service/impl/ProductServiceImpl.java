package com.example.manageproduct2.service.impl;

import com.example.manageproduct2.dto.ProductDTO;
import com.example.manageproduct2.model.Brand;
import com.example.manageproduct2.model.Product;
import com.example.manageproduct2.repository.ProductRepository;
import com.example.manageproduct2.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<ProductDTO> getAll(String searchByName, Double searchByPrice) {
        List<Product> product = productRepository.findAll();
        List<ProductDTO> productDTO = new ArrayList<>();
        if (searchByName != null || searchByPrice != null) {
            List<Product> listSearch = productRepository.searchByName(searchByName, searchByPrice);
            for (Product sp : listSearch) {
                productDTO.add(modelMapper.map(sp, ProductDTO.class));
            }
            return productDTO;
        }
        for (Product sp : product) {
            productDTO.add(modelMapper.map(sp, ProductDTO.class));
        }
        return productDTO;
    }

    @Override
    public ProductDTO save(ProductDTO productDTO) {
        Product product = modelMapper.map(productDTO, Product.class);
        for (Brand br : productDTO.getBrands()) {
            product.addBrand(br);
        }
        productRepository.save(product);
        return modelMapper.map(product, ProductDTO.class);
    }

    @Override
    public ProductDTO update(Long id, ProductDTO productDTO) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setProduce_name(productDTO.getProduce_name());
            if (!(product.getBrands().equals(productDTO.getBrands()))) {
                for (Brand brand : product.getBrands()) {
                    product.removeBrand(brand);
                }
                for (Brand brand : productDTO.getBrands()) {
                    product.addBrand(brand);
                }
            }
            product.setColor(productDTO.getColor());
            product.setQuantity(productDTO.getQuantity());
            product.setOrigin_price(productDTO.getOrigin_price());
            product.setSell_price(productDTO.getSell_price());
            product.setSub_category(productDTO.getSub_category());
            product.setStatus(productDTO.getStatus());
            productRepository.save(product);
            return modelMapper.map(product, ProductDTO.class);
        }
        return null;
    }

    @Override
    public ProductDTO getById(Long id) {
        Optional<Product> optional = productRepository.findById(id);
        Product product;
        if (optional.isPresent()) {
            product = optional.get();
        } else {
            throw new RuntimeException("Product not found for Id !" + id);
        }
        return modelMapper.map(product, ProductDTO.class);
    }

    @Override
    public void delete(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            for (Brand br : product.getBrands()) {
                product.removeBrand(br);
            }
            productRepository.delete(product);
        }
    }


}
