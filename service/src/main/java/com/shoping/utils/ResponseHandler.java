package com.shoping.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;

public class ResponseHandler {
    public ResponseHandler(){
    }
    public static ResponseEntity<Object> generateResponse(HttpStatus status, String mes, Object resObject){
        HashMap mapData = new HashMap();
        mapData.put("result", resObject);
        return new ResponseEntity(mapData, status);
    }
}

