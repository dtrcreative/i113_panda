package com.micro.i113_panda.contoller;

import com.micro.i113_panda.model.dto.AccountDto;
import com.micro.i113_panda.service.AccountService;
import com.micro.i113_panda.service.UtilsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/panda/utils")
@AllArgsConstructor
public class UtilsController {

    private UtilsService utilService;
    private AccountService accountService;

    @GetMapping("/passgen")
    public String generatePassword() {
        return utilService.generatePassword();
    }

    @PostMapping("/upload-add")
    public int uploadAndAddJson(@RequestBody List<AccountDto> unitsDtoList) {
        return accountService.createByListAndCountSuccessful(unitsDtoList);
    }

    @PostMapping("/upload-replace")
    public int uploadWithReplaceJson(@RequestBody List<AccountDto> unitsDtoList) {
        return accountService.replaceAllByListAndCount(unitsDtoList);
    }
}
