package com.micro.i113_panda.contoller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/panda/")
public class PandaController {

    @GetMapping("/")
    public String getTestString(@RequestHeader(value = "Authorization") String authorization) {
        System.out.println(authorization);
        return "Test Success String";
    }
}
