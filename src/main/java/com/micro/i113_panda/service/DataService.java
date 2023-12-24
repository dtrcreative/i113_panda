package com.micro.i113_panda.service;

import com.micro.i113_panda.model.Type;
import com.micro.i113_panda.model.dto.DataDto;
import com.micro.i113_panda.repository.MailRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DataService {

    private MailRepository mailRepository;

    public DataDto collectData(){
        return DataDto.builder()
                .types(Arrays.stream(Type.values()).collect(Collectors.toList()))
                .mails(mailRepository.findAll())
                .build();
    }

}
