package com.study.app.dto.user;

import com.study.app.domain.User;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public record UserDto(
        @NotBlank(message = "아이디는 필수 입력값입니다.")
        @Pattern(regexp = "^[a-z0-9]{4,20}$", message = "아이디는 영어 소문자와 숫자만 사용하여 4~20자리여야 합니다.")
        String username,

        @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,16}$", message = "비밀번호는 8~16자리수여야 합니다. 영문 대소문자, 숫자, 특수문자를 1개 이상 포함해야 합니다.")
        String password,

        @NotBlank(message = "닉네임은 필수 입력값입니다.")
        @Pattern(regexp = "^[a-zA-Z0-9]{4,16}$" , message = "닉네임은 특수문자를 포함하지 않은 4~16자리여야 합니다.")
        String nickname,

        @NotBlank(message = "이름은 필수 입력값입니다.")
        String name
) {
    /* DTO -> Entity 회원가입 할 때 */
    public User toCreateEntity() {
        return User.of(
                username,
                password,
                nickname,
                name

        );
    }

    /* DTO -> Entity 회원정보 수정 할 때 */
    public User toModifyEntity(String reg_date) {
        return User.of(
                username,
                password,
                nickname,
                name,
                reg_date
        );
    }
    public static UserDto of(String username, String password, String nickname, String name) {
        return new UserDto( username, password, nickname, name);
    }

    public static UserDto from(User entity) {
        return new UserDto(
                entity.getUsername(),
                entity.getPassword(),
                entity.getNickname(),
                entity.getName()
        );
    }
}