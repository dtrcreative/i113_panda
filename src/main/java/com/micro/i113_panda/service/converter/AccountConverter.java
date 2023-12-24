package com.micro.i113_panda.service.converter;

import com.micro.i113_panda.model.dto.AccountDto;
import com.micro.i113_panda.model.entity.AccountEntity;
import com.micro.i113_panda.service.UserService;
import com.micro.i113_panda.service.utils.PasswordGenerator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class AccountConverter {

    private UserService userService;
    private PasswordGenerator passwordGenerator;

    public List<AccountDto> convertEntitiesToDto(List<AccountEntity> entitiesList) {
        return entitiesList.stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    public List<AccountEntity> convertDtoToEntities(List<AccountDto> dtoList) {
        return dtoList.stream()
                .map(this::convertDtoToEntity)
                .collect(Collectors.toList());
    }

    public AccountDto convertEntityToDto(AccountEntity inputEntity) {
        return AccountDto.builder()
                .id(inputEntity.getId())
                .userId(inputEntity.getUserEntity().getUserId())
                .name(inputEntity.getName())
                .account(inputEntity.getAccount())
                .password(inputEntity.getPassword())
                .link(inputEntity.getLink())
                .description(inputEntity.getDescription())
                .mail(inputEntity.getMail())
                .type(inputEntity.getType())
                .build();
    }

    public AccountEntity convertDtoToEntity(AccountDto inputDto) {
        return AccountEntity.builder()
                .userEntity(userService.findOrCreateUser(inputDto.getUserId()))
                .name(inputDto.getName())
                .account(inputDto.getAccount())
                .password(inputDto.getPassword())
                .link(inputDto.getLink())
                .description(inputDto.getDescription())
                .mail(inputDto.getMail())
                .type(inputDto.getType())
                .build();
    }

}
