package com.micro.i113_panda.service;

import com.micro.i113_panda.service.utils.PasswordGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UtilsService {

    private final PasswordGenerator passwordGenerator;

    @Value("${password-generator.pattern}")
    private String pattern;

    public UtilsService(PasswordGenerator passwordGenerator) {
        this.passwordGenerator = passwordGenerator;
    }

    public String generatePassword() {
        return passwordGenerator.generatePassword(pattern);
    }
}
