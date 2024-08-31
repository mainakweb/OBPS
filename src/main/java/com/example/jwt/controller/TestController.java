package com.example.jwt.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/hr")
public class TestController {
    @GetMapping("/hrUpload")
    public Map<String, Object> hrUpload(@RequestAttribute("customUserDetails") Map<String, Object> customUserDetails) {
        return customUserDetails;
    }
}
