package com.micro.i113_panda.service;

import com.micro.i113_panda.repository.AccountRepository;
import com.micro.i113_panda.repository.UserRepository;
import com.micro.i113_panda.service.utils.PasswordGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UtilsService {

    private final PasswordGenerator passwordGenerator;
    private final AccountRepository accountRepository;
    private final UserRepository userRepository;

    @Value("${password-generator.pattern}")
    private String pattern;

    public UtilsService(PasswordGenerator passwordGenerator, AccountRepository accountRepository, UserRepository userRepository) {
        this.passwordGenerator = passwordGenerator;
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
    }

    public String generatePassword(String userID) {
        //TODO uniqueness password if it needs
        return passwordGenerator.generatePassword(pattern);
    }
}
