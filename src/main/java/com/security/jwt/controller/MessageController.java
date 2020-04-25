package com.security.jwt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class MessageController {

    @GetMapping
    public ResponseEntity getMessage() {

        return new ResponseEntity("Hellow World ", HttpStatus.ACCEPTED);
    }
}
