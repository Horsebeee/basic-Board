# 🔍 basic-Board
스프링부트 Gradle 방식을 기반으로 한 게시판 프로젝트

* ERD 설계 : [링크](https://www.erdcloud.com/p/R9fje8mNE5AXvtyFu)

#### * 주요 기술
- Spring Security 를 이용한 로그인 및 회원가입 구현
- validation 을 이용한 정규식 유효성 검사
- custom validator 를 이용한 중복 검사
- Bcrypt Password Encoder 를 이용한 비밀번호 암호화
- 게시판 CRUD 구현을 REST 방식으로 구현
- record 를 이용한 dto 

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

![erd](https://user-images.githubusercontent.com/107667158/221791848-6b16d2a1-3a9e-422a-b6e9-7ed9b60bb0c4.png)

**1. Login(로그인 화면)**
![1 login](https://user-images.githubusercontent.com/107667158/221791413-6e5e6eae-43b4-47e5-9569-0dd6293d760b.png)
* 주요 기능
  - Spring Security를 이용한 로그인 인증

**2. 회원가입(회원가입 화면)**
![2 회원가입 validChk](https://user-images.githubusercontent.com/107667158/221791417-7b1fb9a5-7815-4239-8a50-cc1981faf06e.png)
* 주요 기능
  - Spring Security를 이용한 회원가입
  - validation 디펜던시를 이용한 정규식 유효성 검사

![3 회원가입 중복확인](https://user-images.githubusercontent.com/107667158/221791424-b07ad881-3344-474c-a5ce-5c7afb9263a3.png)
* 주요 기능
  - validator 추상클래스를 이용한 중복 검사
  
**3. 게시판 리스트**
![4 게시판 리스트](https://user-images.githubusercontent.com/107667158/221791433-875aded1-f788-4bd7-a615-df0ca1aa441e.png)
* 주요 기능
  - 게시글 리스트 구현
  
**4. 게시글**
![5 남의 게시물](https://user-images.githubusercontent.com/107667158/221791439-5513617e-11a9-4397-ac42-0b0f03cf4932.png)
* 주요 기능
  - 로그인 한 아이디와 작성자가 다르면 수정 못하게 처리
  
![6 내 게시글](https://user-images.githubusercontent.com/107667158/221791447-80b5e2b1-e77e-46b0-aac1-687a19760063.png)
* 주요 기능
  - 로그인 한 아이디와 작성자가 같으면 수정/삭제 버튼 나오게하기
  - 삭제 누르면 게시글 삭제 
  
![7 게시글 수정](https://user-images.githubusercontent.com/107667158/221791458-20befc91-5136-4199-a2f5-88948ae5bc33.png)
* 주요 기능
  - 게시글 수정후 수정 버튼 누르면 수정
  
 ## 🛠 현 시점 추가 및 수정사항
  - 회원 정보 수정 api 구현
  - 댓글 CRUD 구현
  - 검색 api 구현


