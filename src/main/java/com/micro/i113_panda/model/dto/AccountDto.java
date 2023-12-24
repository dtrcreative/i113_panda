package com.micro.i113_panda.model.dto;

import com.micro.i113_panda.model.Type;
import com.micro.i113_panda.model.entity.MailEntity;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AccountDto{

    private Integer id;

    @NonNull
    private String userId;

    @NonNull
    private String name;

    private String account;
    @NonNull
    private String password;

    private String link;

    private String description;

    private Type type;

    private String mail;

}
