package com.example.demo.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloSpringController {

    // @Autowired
    // public HelloSpringController restTemplate(RestTemplateBuilder builder) {
		// return builder.build();
    // }
    
    @GetMapping("/hello")    
    public HelloSpring hello(@RequestParam(value = "name", defaultValue = "World") String name){

        //
        HelloSpring helloSpring = new HelloSpring(name);
        return helloSpring;
    }
}