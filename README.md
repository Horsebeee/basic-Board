# 🔍 basic-Board
스프링부트 Gradle 방식을 기반으로 한 게시판 프로젝트

* ERD 설계 : [링크](https://www.erdcloud.com/p/R9fje8mNE5AXvtyFu)

#### * 주요 기술
- Spring Security 를 이용한 로그인 및 회원가입 구현
- validation 을 이용한 정규식 유효성 검사
- custom validator 를 이용한 중복 검사
- Bcrypt Password Encoder 를 이용한 비밀번호 암호화
- 게시판 CRUD 구현을 REST 방식으로 구현
- record 를 이용한 dto 구현

#### * 기간
2023/02/20 ~

## 개발 환경
* IntelliJ IDEA 2022.2.3 (Ultimate Edition)
* Java 17
* Gradle 7.4.1
* Spring Boot 2.7.8

##  🔨  기술 세부 스택
Spring Boot
* Spring Web
* Lombok

* Spring Data JPA
* MySQL Driver

* JDBC api
* Log4j2

* Spring Security
* Thymeleaf
* Validation

#### 그 외
* Bootstrap 5.3.0

## 🖨 Contents

**ERD**
![1 login](https://user-images.githubusercontent.com/107667158/222337704-6d7ddc21-ed48-4219-9239-96a0b5a97384.png)
![1 login png -수정](https://user-images.githubusercontent.com/107667158/222337706-1d8228b0-e8d3-41d5-b48b-cc2e6fed4dca.png)
![2 회원가입 validChk](https://user-images.githubusercontent.com/107667158/222337707-f2a52119-12db-4e57-b2f5-68d955fa8992.png)
![3 회원가입 중복확인](https://user-images.githubusercontent.com/107667158/222337709-0f609862-1cd7-4bcf-bcce-6b0c06bd87ac.png)
![4 게시판 리스트](https://user-images.githubusercontent.com/107667158/222337712-11f86c7a-b513-4f7b-92bd-c1b8fe75b190.png)
![5 남의 게시물](https://user-images.githubusercontent.com/107667158/222337714-9e500aa4-833b-428e-8461-fe02717041ea.png)
![6 내 게시글](https://user-images.githubusercontent.com/107667158/222337715-bfa32276-3997-4f8b-9be4-19a0a728d82d.png)
![7 게시글 수정](https://user-images.githubusercontent.com/107667158/222337717-63dc829c-3f03-46a2-a075-0d30fcd40412.png)
![8 회원정보 수정](https://user-images.githubusercontent.com/107667158/222337719-7e1c8f57-7e31-4bae-a6fa-cafca61f7bf8.png)

![erd](https://user-images.githubusercontent.com/107667158/221791848-6b16d2a1-3a9e-422a-b6e9-7ed9b60bb0c4.png)

**1. Login(로그인 화면)**
![1 login](https://user-images.githubusercontent.com/107667158/222337704-6d7ddc21-ed48-4219-9239-96a0b5a97384.png)
* 주요 기능
  - Spring Security를 이용한 로그인 인증

**2. 회원가입(회원가입 화면)**
![2 회원가입 validChk](https://user-images.githubusercontent.com/107667158/222337707-f2a52119-12db-4e57-b2f5-68d955fa8992.png)
* 주요 기능
  - Spring Security를 이용한 회원가입
  - validation 디펜던시를 이용한 정규식 유효성 검사

![3 회원가입 중복확인](https://user-images.githubusercontent.com/107667158/222337709-0f609862-1cd7-4bcf-bcce-6b0c06bd87ac.png)
* 주요 기능
  - validator 추상클래스를 이용한 중복 검사
  
**3. 게시판 리스트**
![4 게시판 리스트](https://user-images.githubusercontent.com/107667158/222337712-11f86c7a-b513-4f7b-92bd-c1b8fe75b190.png)
* 주요 기능
  - 게시글 리스트 구현
  
**4. 게시글**
![5 남의 게시물](https://user-images.githubusercontent.com/107667158/222337714-9e500aa4-833b-428e-8461-fe02717041ea.png)
* 주요 기능
  - 로그인 한 아이디와 작성자가 다르면 수정 못하게 처리
  
![6 내 게시글](https://user-images.githubusercontent.com/107667158/222337715-bfa32276-3997-4f8b-9be4-19a0a728d82d.png)
* 주요 기능
  - 로그인 한 아이디와 작성자가 같으면 수정/삭제 버튼 나오게하기
  - 삭제 누르면 게시글 삭제 
  
![7 게시글 수정](https://user-images.githubusercontent.com/107667158/222337717-63dc829c-3f03-46a2-a075-0d30fcd40412.png)
* 주요 기능
  - 게시글 수정후 수정 버튼 누르면 수정
  
**5. 회원 정보 수정**    
![8 회원정보 수정](https://user-images.githubusercontent.com/107667158/222337719-7e1c8f57-7e31-4bae-a6fa-cafca61f7bf8.png)
* 주요 기능
  - 비밀번호, 닉네임, 이름 수정
  - 수정 후 재로그인 하지 않아도 사용자 화면에 수정된 정보 보여주기 (세션 변경)

  
 ## 🛠 현 시점 추가 및 수정사항
  - 회원 정보 수정 api 구현 ok
  - 댓글 CRUD 구현
  - 검색 api 구현


