package com.first.tripadviser.security.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.time.LocalDateTime;
import java.util.Collection;

@Getter
@Setter
@ToString
public class MemberSecurityDTO extends User {
    private String memberId;
    private String memberName;
    private String memberPw;
    private String memberEmail;
    private LocalDateTime regDate;
    private LocalDateTime updateDate;

    public MemberSecurityDTO(String username , String password , String email , String name ,
                             LocalDateTime regDate , LocalDateTime updateDate , Collection<? extends GrantedAuthority> authorities){
        super(username , password , authorities);
        this.memberId = username;
        this.memberName = name;
        this.memberPw = password;
        this.memberEmail = email;
        this.regDate = regDate;
        this.updateDate = updateDate;


    }


}
