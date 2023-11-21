package com.first.tripadviser.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Builder
@AllArgsConstructor
@Getter
@ToString
@Table(name = "tb_userdest")
public class UserDest {
    @Id
    private String userId;
    private Long destId;



}
