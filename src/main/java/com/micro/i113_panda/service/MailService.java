package com.micro.i113_panda.service;

import com.micro.i113_panda.exception.PandaException;
import com.micro.i113_panda.model.entity.MailEntity;
import com.micro.i113_panda.repository.MailRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class MailService {

    private MailRepository repository;

    public MailEntity findOrCreateMail(String mail) {
        if (Optional.ofNullable(mail).isPresent()) {
            return repository.findMailEntityByMail(mail).orElseGet(() -> repository.save(new MailEntity(mail)));
        }
        throw new PandaException("Missing mail", HttpStatus.BAD_REQUEST);
    }
}
