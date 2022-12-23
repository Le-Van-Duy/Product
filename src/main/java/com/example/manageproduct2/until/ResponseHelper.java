package com.example.manageproduct2.until;

import lombok.experimental.UtilityClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@Component

public class ResponseHelper {


    public static ResponseEntity<Object> handleErrors(HttpStatus status, MethodArgumentNotValidException ex,String message) {
        Map<String, Object> objectMap = new HashMap<>();
        objectMap.put("timestamp", new Date());
        objectMap.put("status", status.value());
        List<String> errors = ex.getBindingResult()
                .getFieldErrors().stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());
        objectMap.put("errors", errors);
        objectMap.put("success", false);
        objectMap.put("message",message);
        objectMap.put("data",null);
        return new ResponseEntity<Object>(objectMap, status.BAD_REQUEST);

    }
    public static ResponseEntity<Object> getObjectResponseEntity(HttpStatus status,Object obj) {
        Map<String, Object> map = new HashMap<>();
        map.put("timestamp", new Date());
        map.put("status", status.value());
        map.put("message", "");
        map.put("success", true);
        map.put("data",obj);
        return new ResponseEntity<Object>(map, status);

    }
}
