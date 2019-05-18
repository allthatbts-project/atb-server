package com.allthatBTS.atbserver.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/main")
public class MainController {
    @GetMapping
    public ResponseEntity<?> getMainInfo(@CookieValue(value = "jwtToken") String loginToken){

        ResponseEntity result = new ResponseEntity(HttpStatus.OK);
        return result;
    }
}
