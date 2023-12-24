package com.micro.i113_panda.contoller;

import com.micro.i113_panda.model.dto.DataDto;
import com.micro.i113_panda.service.DataService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/panda/data/")
public class DataController {

    private DataService dataService;

    @GetMapping("/")
    public DataDto collectData() {
        return dataService.collectData();
    }
}
