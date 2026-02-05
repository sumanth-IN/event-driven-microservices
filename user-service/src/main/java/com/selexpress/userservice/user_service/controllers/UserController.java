package com.selexpress.userservice.user_service.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping("/users/{name}")
    public String createUser(@PathVariable String name){

        RestTemplate rest = new RestTemplate();

        Map<String, String> userDetails = new HashMap<>();
        userDetails.put("userName", name);

        String forObject = rest.getForObject("http://localhost:9090/sendEmail/{userName}", String.class, userDetails);
        System.out.println("RestTemplate called: "+ forObject);
        return "user created: " + forObject;
    }
}
