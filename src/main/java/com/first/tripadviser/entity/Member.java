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
    private boolean active;
    @ElementCollection(fetch = FetchType.LAZY)
    @Builder.Default
    private Set<MemberRole> roleSet = new HashSet<>();

    @OneToMany(mappedBy = "member" , cascade = CascadeType.ALL , orphanRemoval = true)
    private List<Plan> planList;

    @OneToMany(mappedBy = "member" , cascade = CascadeType.ALL , orphanRemoval = true)
    private List<Review> reviewList;



    public void changeEmail(String email){
        memberEmail = email;
    }
    public void changePw(String pw) {
        memberPw = pw;
    }

    public void addRole(MemberRole memberRole){
        this.roleSet.add(memberRole);
    }

    public void delAdmin(){
        this.roleSet.clear();
        this.roleSet.add(MemberRole.MEMBER);
    }
    public void claerRole(){
        this.roleSet.clear();
    }
    public void block(){
        this.active = false;
    }

    public void active(){
        this.active = true;
    }


}

