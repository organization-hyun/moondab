package com.hyun.moondab.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/convenience")
class ConvenienceController {

    @GetMapping("/hello")
    fun hello(): String{
        return "hello kotlin"
    }

}