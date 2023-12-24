package com.micro.i113_panda.service;

import com.micro.i113_panda.exception.PandaException;
import com.micro.i113_panda.model.dto.AccountDto;
import com.micro.i113_panda.model.entity.AccountEntity;
import com.micro.i113_panda.model.entity.UserEntity;
import com.micro.i113_panda.repository.AccountRepository;
import com.micro.i113_panda.service.converter.AccountConverter;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AccountService {

    private AccountRepository repository;
    private AccountConverter converter;
    private UserService userService;

    public List<AccountDto> selectAll(String userId){
        UserEntity userEntity = userService.findOrCreateUser(userId);
        List<AccountEntity> entitiesList = repository.findAllByUserEntity(userEntity);
        if (entitiesList.size() > 0) {
            return converter.convertEntitiesToDto(entitiesList);
        }
        return new ArrayList<>();
    }

    public AccountDto create(AccountDto accountDto){
        AccountEntity entity = repository.save(converter.convertDtoToEntity(accountDto));
        return converter.convertEntityToDto(entity);
    }

    public int createByListAndCountSuccessful(List<AccountDto> inputDtoList){
        UserEntity userEntity = userService.findOrCreateUser(inputDtoList.get(0).getUserId());
        List<AccountEntity> baseEntities = repository.findAllByUserEntity(userEntity);
        List<AccountEntity> inputList = converter.convertDtoToEntities(inputDtoList);
        int counter = 0;
        for (AccountEntity inputEntity : inputList) {
            if(!isExist(baseEntities, inputEntity)){
                repository.save(inputEntity);
                counter++;
            }
        }
        return counter;
    }

    public void replaceAllbyList(List<AccountDto> inputDtoList){
        deleteAllUserRelated(inputDtoList.get(0).getUserId());
        repository.saveAllAndFlush(converter.convertDtoToEntities(inputDtoList));
    }

    public AccountDto update(AccountDto inputDto){
        Optional<AccountEntity> entity = repository.findById(inputDto.getId());
        if (entity.isPresent()) {
            AccountEntity updatedEntity = converter.convertDtoToEntity(inputDto);
            updatedEntity.setId(entity.get().getId());
            updatedEntity = repository.save(updatedEntity);
            return converter.convertEntityToDto(updatedEntity);
        }
        throw new PandaException("Update error", HttpStatus.BAD_REQUEST);
    }

    public void delete(int id){
        Optional<AccountEntity> entity = repository.findById(id);
        entity.ifPresent(foundedEntity -> repository.delete(foundedEntity));
    }

    public void deleteSelected(List<Integer> selected) {
        repository.deleteAllById(selected);
    }

    public void deleteAllUserRelated(String username){
        UserEntity user = userService.findOrCreateUser(username);
        List<AccountEntity> entityList = repository.findAllByUserEntity(user);
        if (entityList.size() > 0) {
            repository.deleteAll(entityList);
        }
    }

    private boolean isExist(List<AccountEntity> inputAccountsList, AccountEntity inputAccountEntity){
        for(AccountEntity entity: inputAccountsList){
            if(entity.compareTo(inputAccountEntity) == 0){
                return true;
            }
        }
        return false;
    }


}
