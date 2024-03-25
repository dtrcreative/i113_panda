package com.micro.i113_panda.repository;

import com.micro.i113_panda.model.entity.MailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MailRepository extends JpaRepository<MailEntity, Integer> {

    Optional<MailEntity> findMailEntityByMail(String mail);
}
