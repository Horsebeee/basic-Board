package com.study.app.controller.api;

import com.study.app.dto.user.UserDto;
import com.study.app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserApiController {
    private final UserService userService;

    private final AuthenticationManager authenticationManager;

    @PutMapping("/api/modify/{username}")
    public ResponseEntity<String> updateUser(@RequestBody UserDto dto) {
        System.out.println(" ===== 회원 수정 PUT ===== : " + dto );
        userService.updateUser(dto);

        // 1. 새로운 UsernamePasswordAuthenticationToken 생성하여 AuthenticationManager을 이용해 등록
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(dto.username(), dto.password()));

        // 2. SecurityContextHolder 안에 있는 Context를 호출해 변경된 Authentication으로 설정
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return ResponseEntity.ok().body("회원정보 수정");
    }
}
