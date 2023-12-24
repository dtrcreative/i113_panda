package com.micro.i113_panda.repository;

import com.micro.i113_panda.model.entity.MailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MailRepository extends JpaRepository<MailEntity, Integer> {

    List<MailEntity> findAll();
}
