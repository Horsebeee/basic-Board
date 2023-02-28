package com.study.app.validation;



import com.study.app.dto.user.UserDto;
import com.study.app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@RequiredArgsConstructor
@Component
public class CheckNicknameValidator extends AbstractValidator<UserDto>{
    private final UserRepository userRepository;

    @Override
    protected void doValidate(UserDto dto, Errors errors) {
        if (userRepository.existsByNickname(dto.toCreateEntity().getNickname())) {
            /* 중복인 경우 */
            errors.rejectValue("nickname","닉네임 중복 오류", "이미 사용 중인 닉네임입니다.");
        }
    }
}
