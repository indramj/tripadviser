package com.first.tripadviser.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Table(name = "tb_member")
public class Member extends BaseEntity{
    @Id
    private String memberId;
    private String memberName;
    private String memberPw;
    private String memberEmail;

    public void changeEmail(String email){
        memberEmail = email;
    }
    public void changePw(String pw) {
        memberPw = pw;
    }

}

