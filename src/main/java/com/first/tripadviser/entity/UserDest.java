package com.first.tripadviser.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Table(name = "tb_userdest")
public class UserDest {

}
