package com.first.tripadviser.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Table(name = "tb_user")
public class User extends BaseEntity{
    @Id
    private String userId;
    private String userPw;
    private String userEmail;
}

