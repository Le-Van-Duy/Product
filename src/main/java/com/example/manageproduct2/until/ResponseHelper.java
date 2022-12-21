package com.example.manageproduct2.until;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResponseHelper {
    public ResponseEntity<Object> handleErrors(HttpStatus status, MethodArgumentNotValidException ex) {
        Map<String, Object> objectMap = new HashMap<>();
        objectMap.put("timestamp", new Date());
        objectMap.put("status", status.value());
        List<String> errors = ex.getBindingResult()
                .getFieldErrors().stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());
        objectMap.put("errors", errors);
        return new ResponseEntity<Object>(objectMap, status);

    }
}
