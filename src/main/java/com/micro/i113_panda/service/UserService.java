package com.micro.i113_panda.service;

import com.micro.i113_panda.exception.PandaException;
import com.micro.i113_panda.model.entity.UserEntity;
import com.micro.i113_panda.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository repository;

    public UserEntity findOrCreateUser(String userId) {
        if (Optional.ofNullable(userId).isPresent()) {
            return repository.findUserEntityByUserId(userId).orElseGet(() -> repository.save(new UserEntity(userId)));
        }
        throw new PandaException("Missing user id", HttpStatus.BAD_REQUEST);
    }
}
