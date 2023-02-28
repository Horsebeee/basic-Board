package com.study.app.validation;



import com.study.app.dto.user.UserDto;
import com.study.app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@RequiredArgsConstructor
@Component
public class CheckUsernameValidator extends AbstractValidator<UserDto>{
    private final UserRepository userRepository;

    @Override
    protected void doValidate(UserDto dto, Errors errors) {
        if (userRepository.existsByUsername(dto.toCreateEntity().getUsername())) {
            /* 중복인 경우 */
            errors.rejectValue("username","아이디 중복 오류", "이미 사용 중인 아이디입니다.");
        }
    }
}
