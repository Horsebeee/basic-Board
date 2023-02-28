package com.study.app.service;

import com.study.app.domain.User;
import com.study.app.dto.user.UserDto;
import com.study.app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
    private final UserRepository userRepository;

    private final BCryptPasswordEncoder encoder;

    // validHandling
    @Transactional
    public Map<String, String> validHandling(Errors errors) {
        Map<String, String> validResult = new HashMap<>();

        for(FieldError error : errors.getFieldErrors()) {
            validResult.put("valid_"+error.getField(), error.getDefaultMessage());
        }
        return validResult;
    }

    // 회원 가입
    @Transactional
    public void createUser(UserDto dto) {
        //public String createUser(RequestUserDto dto) {
        /* 비밀번호 암호화 */
        System.out.println("암호화전 비밀번호 dto : "+dto.password());
        System.out.println("암호화된 비밀번호 dto : "+ encoder.encode(dto.password()));

        UserDto userDto = new UserDto(
                            dto.username(),
                            encoder.encode(dto.password()),
                            dto.nickname(),
                            dto.name()
        );

        User user = userDto.toCreateEntity();
        System.out.println("암호화된 비밀번호 user : "+user.getPassword());
        System.out.println("엔티티로 변형된 user : "+user);
        userRepository.save(user);
        System.out.println("DB에 회원 저장 성공");
    }
}
