package com.micro.i113_panda.model.dto;

import com.micro.i113_panda.model.Type;
import com.micro.i113_panda.model.entity.MailEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class DataDto {

    private List<Type> types;
    private List<MailEntity> mails;

}
