package com.example.manageproduct2.repository;

import com.example.manageproduct2.model.Sub_Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Sub_CategoryRepository extends JpaRepository<Sub_Category,Long> {
}
