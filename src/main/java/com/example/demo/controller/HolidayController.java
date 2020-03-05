package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolidayController {
    @GetMapping("/read")
    public String print()
    {
        return "Hello";
    }
}
