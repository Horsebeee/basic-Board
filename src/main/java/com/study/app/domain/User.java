package com.study.app.domain;


import lombok.*;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Table(
        name="User",
        indexes = {
                @Index(columnList = "nickname"),
                @Index(columnList = "username"),
        },

        uniqueConstraints={
                @UniqueConstraint(
                        columnNames={"username", "nickname"}
                )
        }
)
@Entity
@Getter
@ToString(callSuper = true)
@DynamicInsert // insert 시 null 인 필드 제외
public class User {
    @Id
    @Column(nullable = false)
    @Comment("아이디: 로그인 할 때 필요한 정보")
    private String username;

    @Setter
    @Column(nullable = false ,length = 2000)
    @Comment("비밀번호: 암호화 기준으로 length 설정")
    private String password;

    @Setter
    @Column(nullable = false, length = 20)
    @Comment("닉네임: 실제 사이트에서 활동하는 이름")
    private String nickname;

    @Setter
    @Column(nullable = false, length = 30)
    @Comment("이름")
    private String name;

    @Column(nullable = false)
    @Comment("가입일")
    private String reg_date;

    protected User() {}

    // 회원가입 할 때
    private User(String username, String password, String nickname, String name,String reg_date) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.name = name;
        this.reg_date =reg_date;
    }

    /* 정적 팩토리 메서드 */
    // 회원가입 할 때
    public static User of(String username, String password, String nickname, String name) {
        return new User(username,password,nickname,name,LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return username.equals(user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }
}
