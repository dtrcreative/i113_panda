package com.micro.i113_panda.contoller;

import com.micro.i113_panda.model.Type;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/panda/data/")
public class DataController {

    @GetMapping("/types")
    public List<Type> collectData() {
        return Arrays.stream(Type.values()).collect(Collectors.toList());
    }
}
