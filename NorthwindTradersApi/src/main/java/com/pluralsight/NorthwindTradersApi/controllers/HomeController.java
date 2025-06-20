package com.pluralsight.NorthwindTradersApi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomeController {

    @GetMapping("/home")
    public String index() {
        return "Hello World!";
    }

    @GetMapping("/home/")
    public String indexName(@RequestParam(defaultValue = "") String name) {
        return "Hello " + name + "!";
    }
}
