package com.apigateway.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class FallbackController {

    @GetMapping("/farmerServiceFallback")
    public String farmerServiceFallback() {
        return "Farmer Service is down at this time !!";
    }


    @GetMapping("/productServiceFallback")
    public String productServiceFallback() {
        return "Product Service is down at this time !!";
    }


    @GetMapping("/dealerServiceFallback")
    public String dealerServiceFallback() {
        return "Dealer Service is down at this time !!";
    }
}
