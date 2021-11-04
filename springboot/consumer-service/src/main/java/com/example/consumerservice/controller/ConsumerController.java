package com.example.consumerservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.consumerservice.service.ConsumerService;

@RestController
public class ConsumerController {

    @Autowired
    private ConsumerService service;

    @GetMapping("/events/{id}")
    public ResponseEntity<?> getEventById(@PathVariable("id") float id) {
        try {
            return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new Exception(e.getMessage()), HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping("/events")
    public ResponseEntity<?> getEventDtls() {
        try {
            return new ResponseEntity<>(service.getEventDetails(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new Exception(e.getMessage()), HttpStatus.EXPECTATION_FAILED);
        }
    }

}