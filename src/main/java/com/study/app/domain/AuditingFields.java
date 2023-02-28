package com.study.app.domain;

import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@ToString
@EntityListeners(AuditingEntityListener.class) // 이거 없으면 테스트 할때 createdAt 때문에 에러남
@MappedSuperclass
public class AuditingFields {

    //메타데이터

    @Column(updatable = false)
    @CreatedDate
    private String createdDate; // 생성

    @LastModifiedDate
    private String modifiedDate; // 수정

    @PrePersist
    public void onPrePersist() {
        this.createdDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        this.modifiedDate = this.createdDate;
    }

    @PreUpdate
    public void onPreUpdate() {
        this.modifiedDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }
    /*
        @PrePersist : 엔티티 insert 이전 실행
        @PreUpdate : 엔티티 update 이전 실행
    */
}