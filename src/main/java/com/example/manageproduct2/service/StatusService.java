package com.example.manageproduct2.service;

import com.example.manageproduct2.dto.ProductDTO;
import com.example.manageproduct2.dto.StatusDTO;

import java.util.List;

public interface StatusService {
    List<StatusDTO> getAll();
}
