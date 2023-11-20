package com.first.tripadviser.entity;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(value = {AuditingEntityListener.class})
abstract class BaseEntity {
    @CreatedDate
    @Column(name = "regdate" , updatable = false)
    private LocalDateTime regDate;

    @LastModifiedDate
    @Column(name = "updatedate")
    private LocalDateTime updateDate;

}
