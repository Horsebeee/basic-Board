package com.study.app.config;

import com.study.app.dto.user.UserDto;
import com.study.app.repository.UserRepository;
import com.study.app.security.BoardPrincipal;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        /* HttpSecurity: 세부적인 보안 기능을 설정할 수 있는 api 를 제공.
                        - URL 접근 권한 설정
                        - 커스텀 로그인 페이지 지원
                        - 인증 후 성공/실패 핸들링
                        - 사용자 로그인/로그아웃
                        - CSRF 공격으로부터 보호

        * */

        return http.csrf()
                .ignoringAntMatchers("/api/**")
                .and()
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()// 권한 허용
                        .mvcMatchers(HttpMethod.GET,"/user/join")
                        .permitAll()
                        .mvcMatchers(HttpMethod.POST,"/user/join")
                        .permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin() // 로그인 페이지를 만들어준다.
                .loginPage("/user/login")// 커스텀 로그인 페이지 보여줄 때
                .loginProcessingUrl("/login_proc")
                .defaultSuccessUrl("/board/list",true)
                .permitAll()
            .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout")) /* 로그아웃 경로 */
                .invalidateHttpSession(true).deleteCookies("JSESSIONID") /* 로그아웃 성공 시 세션 제거 */
                .logoutSuccessUrl("/user/login") // 로그아웃을 성공하면 "/login" 이 경로로 이동해 라는뜻
            .and()
                .build();



        /** formLogin() 이후 사용할 수 있는 메서드
         http.formLogin()
         .loginPage("/login.html")       // 커스텀 로그인 페이지 보여줄때
         .defaultSuccessUrl("/index")    // 로그인 성공 후 이동할 페이지 경로
         .failureUrl("/login.html?error=true") // 로그인 실패 후 이동할 페이지
         .usernameParameter("유저네임")      // 아이디 파라미터명 설정

         */

        /** mvcMatchers: 스프링에 패턴 매칭 기능이 들어간 메서드.
         * 컨트롤러에서 맵핑할때 "/articles/** /form" 이런식으로 경로 설정할때도 있는데,
         * 그런 특정 경로를 지정해서 권한을 설정할 수도 있게 하는 메서드임. */
    }
    /* 사용자 정보 가져오는 부분 - 실제 인증 데이터를 가져오는 서비스 로직을 가져온다. */
    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository) { /* DB에 있는 user 정보를 주입 받아야 하니까 매개변수로 userRepository 를 받는다.  */
        return username -> userRepository
                .findById(username)/* username 으로 유저 한명 찾고*/
                .map(UserDto::from)/* 맵핑해서 username 으로 찾은 결과를 dto 로 바꿈 */
                .map(BoardPrincipal::from) /* BoardPrincipal: 사용자 정보를 가져올 수 있는 record. userDetail 을 받아옴 */
                .orElseThrow(() -> new UsernameNotFoundException("유저를 찾을 수 없습니다 - username: " + username)); /* 혹시라도 인증된 사용자를 못찾을 때, 대안으로 UsernameNotFoundException 사용함.*/
    }

    @Bean
    public BCryptPasswordEncoder Encoder() {
        return new BCryptPasswordEncoder();
    }
}
