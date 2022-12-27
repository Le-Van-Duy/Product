package com.example.manageproduct2.until;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
public class ResponseHelper {

    public static ResponseEntity<Object> handleErrors(HttpStatus status, String message) {
        Map<String, Object> objectMap = new HashMap<>();
        objectMap.put("hasErrors", true);
        objectMap.put("timestamp", new Date());
        objectMap.put("status", status.value());
        objectMap.put("success", false);
        objectMap.put("message", message);
        objectMap.put("data", null);
        return new ResponseEntity<Object>(objectMap, status.BAD_REQUEST);

    }

    public static ResponseEntity<Object> getObjectResponseEntity(HttpStatus status, Object obj) {
        Map<String, Object> map = new HashMap<>();
        map.put("hasErrors", false);
        map.put("timestamp", new Date());
        map.put("status", status.value());
        map.put("message", "");
        map.put("success", true);
        map.put("data", obj);
        return new ResponseEntity<Object>(map, status);

    }
}
