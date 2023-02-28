package com.study.app.controller;

import com.study.app.dto.user.UserDto;
import com.study.app.service.UserService;
import com.study.app.validation.CheckNicknameValidator;
import com.study.app.validation.CheckUsernameValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /* 중복 체크 유효성 검사 */
    private final CheckUsernameValidator checkUsernameValidator;
    private final CheckNicknameValidator checkNicknameValidator;

    /* 커스텀 유효성 검증 */
    @InitBinder
    public void validatorBinder(WebDataBinder binder) {
        binder.addValidators(checkUsernameValidator);
        binder.addValidators(checkNicknameValidator);
    }

    // 로그인 페이지로 이동
    @GetMapping("login")
    public String loginPage() {
        return "user/login";
    }

    // 회원가입 페이지로 이동
    @GetMapping("join")
    public String joinPage(UserDto dto, Model model) {
        model.addAttribute("dto",dto);
        System.out.println(" ======= 회원가입 페이지 GET ======= ");
        return "user/join";
    }

    @PostMapping("join")
    public String join(@Valid UserDto dto, BindingResult bindingResult, Model model) {
        System.out.println(" ======= 회원가입 페이지 POST ======= ");
        /* 검증 */
        if(bindingResult.hasErrors()) {
            /* 회원가입 실패 시 입력 데이터 값 유지 */
            model.addAttribute("dto", dto);

            /* 유효성 검사를 통과하지 못 한 필드와 메시지 핸들링 */
            Map<String, String> validResult = userService.validHandling(bindingResult);

            /* Model에 담아 view resolve */
            for(String key : validResult.keySet()) {
                model.addAttribute(key, validResult.get(key));
            }

            /* 회원가입 페이지로 리턴 */
            return "user/join";
        }

        // 회원가입 성공 시
        userService.createUser(dto);
        System.out.println(" ======= 회원가입 성공 ======= ");
        return "redirect:user/login";
    }
}
