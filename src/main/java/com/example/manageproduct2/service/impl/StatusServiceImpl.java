package com.example.manageproduct2.service.impl;

import com.example.manageproduct2.dto.StatusDTO;
import com.example.manageproduct2.model.Status;
import com.example.manageproduct2.repository.StatusRepository;
import com.example.manageproduct2.service.StatusService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StatusServiceImpl implements StatusService {
    @Autowired
    StatusRepository statusRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<StatusDTO> getAll() {
        List<Status> statusList = statusRepository.findAll();
        List<StatusDTO> statusDTOS = new ArrayList<>();
        for (Status st : statusList) {
            statusDTOS.add(modelMapper.map(st, StatusDTO.class));
        }
        return statusDTOS;
    }
}
