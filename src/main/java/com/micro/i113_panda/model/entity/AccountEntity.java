package com.micro.i113_panda.model.entity;

import com.micro.i113_panda.model.Type;
import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "accounts")
public class AccountEntity implements Comparable<AccountEntity> {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    private String name;

    private String account;

    @NonNull
    private String password;

    private String link;

    private String description;

    @Enumerated(EnumType.STRING)
    private Type type;

    @ManyToOne
    @JoinColumn(name = "mail")
    private MailEntity mail;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @Override
    public int compareTo(AccountEntity o) {
        if (password.equals(o.getPassword())) {
            return 0;
        } else {
            return 1;
        }
    }

}
