package com.lta.cursoapis.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @GetMapping("/saludo/{name}")
    public String greeting(@PathVariable String name){
        return "Hola " + name;
    }
}
