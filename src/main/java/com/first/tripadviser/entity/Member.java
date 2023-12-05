package com.first.tripadviser.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = "roleSet")
@Table(name = "tb_member")
public class Member extends BaseEntity{
    @Id
    private String memberId;
    private String memberName;
    private String memberPw;
    private String memberEmail;
    @ElementCollection(fetch = FetchType.EAGER)
    @Builder.Default
    private Set<MemberRole> roleSet = new HashSet<>();



    public void changeEmail(String email){
        memberEmail = email;
    }
    public void changePw(String pw) {
        memberPw = pw;
    }

    public void addRole(MemberRole memberRole){
        this.roleSet.add(memberRole);
    }
    public void claerRole(){
        this.roleSet.clear();
    }

}

