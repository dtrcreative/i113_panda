package com.micro.i113_panda.repository;

import com.micro.i113_panda.model.entity.AccountEntity;
import com.micro.i113_panda.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<AccountEntity, Integer> {

    List<AccountEntity> findAll();

    List<AccountEntity> findAllByUserEntity(UserEntity userEntity);

    void deleteAllByUserEntity(UserEntity userEntity);

    void deleteById(int id);
}
