package com.ibm.academia.restapi.fraudes.controllers

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/hello")
class Hello {
    @GetMapping("/world")
    fun getHello (): ResponseEntity<String> {
        return ResponseEntity<String>("Hello", HttpStatus.OK);
    }
}
