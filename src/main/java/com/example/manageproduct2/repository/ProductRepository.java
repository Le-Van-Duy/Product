package com.example.manageproduct2.repository;

import com.example.manageproduct2.dto.ProductDTO;
import com.example.manageproduct2.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("select p from Product p  where p.produce_name like ?1 or p.origin_price = ?2")
    List<Product> searchByName(String searchByName,Double searchByPrice);

}
