package com.micro.i113_panda.service;

import com.micro.i113_panda.exception.PandaException;
import com.micro.i113_panda.model.entity.MailEntity;
import com.micro.i113_panda.repository.MailRepository;
import org.springframework.http.HttpStatus;

import java.util.Optional;

public class MailService {

    private MailRepository repository;

    public MailEntity findOrCreateMail(String mail) {
        if (Optional.ofNullable(mail).isPresent()) {
            return repository.findMailEntityByMail(mail).orElseGet(() -> repository.save(new MailEntity(mail)));
        }
        throw new PandaException("Missing mail", HttpStatus.BAD_REQUEST);
    }
}
