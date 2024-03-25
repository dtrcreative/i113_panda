package com.micro.i113_panda.contoller;

import com.micro.i113_panda.model.dto.AccountDto;
import com.micro.i113_panda.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/panda/")
public class PandaController {

    private final AccountService accountService;

    public PandaController(AccountService service) {
        this.accountService = service;
    }

    @GetMapping("/all")
    public List<AccountDto> getAllUnits(@RequestHeader(value = "UserId") String userId) {
        return accountService.selectAll(userId);
    }

    @PostMapping("/")
    public AccountDto createUnit(@RequestBody AccountDto unitDto) {
        return accountService.create(unitDto);
    }

    @PutMapping("/")
    public AccountDto updateUnit(@RequestBody AccountDto unitDto) {
        return accountService.update(unitDto);
    }

    @DeleteMapping("/{id}")
    public void deleteUnit(@PathVariable("id") int id) {
        accountService.delete(id);
    }

    @PostMapping("/selected")
    public void deleteSelected(@RequestBody List<Integer> values) {
        accountService.deleteSelected(values);
    }

    @DeleteMapping("/")
    public void deleteAllUnit(@RequestHeader(value = "UserId") String userId) {
        accountService.deleteAllUserRelated(userId);
    }

}
