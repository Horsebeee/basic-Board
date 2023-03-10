# ๐ basic-Board
์คํ๋ง๋ถํธ Gradle ๋ฐฉ์์ ๊ธฐ๋ฐ์ผ๋ก ํ ๊ฒ์ํ ํ๋ก์ ํธ

* ERD ์ค๊ณ : [๋งํฌ](https://www.erdcloud.com/p/R9fje8mNE5AXvtyFu)

#### * ์ฃผ์ ๊ธฐ์ 
- Spring Security ๋ฅผ ์ด์ฉํ ๋ก๊ทธ์ธ ๋ฐ ํ์๊ฐ์ ๊ตฌํ
- validation ์ ์ด์ฉํ ์ ๊ท์ ์ ํจ์ฑ ๊ฒ์ฌ
- custom validator ๋ฅผ ์ด์ฉํ ์ค๋ณต ๊ฒ์ฌ
- Bcrypt Password Encoder ๋ฅผ ์ด์ฉํ ๋น๋ฐ๋ฒํธ ์ํธํ
- ๊ฒ์ํ CRUD ๊ตฌํ์ REST ๋ฐฉ์์ผ๋ก ๊ตฌํ
- record ๋ฅผ ์ด์ฉํ dto ๊ตฌํ

#### * ๊ธฐ๊ฐ
2023/02/20 ~

## ๊ฐ๋ฐ ํ๊ฒฝ
* IntelliJ IDEA 2022.2.3 (Ultimate Edition)
* Java 17
* Gradle 7.4.1
* Spring Boot 2.7.8

##  ๐จ  ๊ธฐ์  ์ธ๋ถ ์คํ
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

#### ๊ทธ ์ธ
* Bootstrap 5.3.0

## ๐จ Contents

**ERD**

![erd](https://user-images.githubusercontent.com/107667158/221791848-6b16d2a1-3a9e-422a-b6e9-7ed9b60bb0c4.png)

**1. Login(๋ก๊ทธ์ธ ํ๋ฉด)**

![1 login](https://user-images.githubusercontent.com/107667158/222337704-6d7ddc21-ed48-4219-9239-96a0b5a97384.png)
* ์ฃผ์ ๊ธฐ๋ฅ
  - Spring Security๋ฅผ ์ด์ฉํ ๋ก๊ทธ์ธ ์ธ์ฆ

**2. ํ์๊ฐ์(ํ์๊ฐ์ ํ๋ฉด)**

![2 ํ์๊ฐ์ validChk](https://user-images.githubusercontent.com/107667158/222337707-f2a52119-12db-4e57-b2f5-68d955fa8992.png)
* ์ฃผ์ ๊ธฐ๋ฅ
  - Spring Security๋ฅผ ์ด์ฉํ ํ์๊ฐ์
  - validation ๋ํ๋์๋ฅผ ์ด์ฉํ ์ ๊ท์ ์ ํจ์ฑ ๊ฒ์ฌ

![3 ํ์๊ฐ์ ์ค๋ณตํ์ธ](https://user-images.githubusercontent.com/107667158/222337709-0f609862-1cd7-4bcf-bcce-6b0c06bd87ac.png)
* ์ฃผ์ ๊ธฐ๋ฅ
  - validator ์ถ์ํด๋์ค๋ฅผ ์ด์ฉํ ์ค๋ณต ๊ฒ์ฌ
  
**3. ๊ฒ์ํ ๋ฆฌ์คํธ**

![4 ๊ฒ์ํ ๋ฆฌ์คํธ](https://user-images.githubusercontent.com/107667158/222337712-11f86c7a-b513-4f7b-92bd-c1b8fe75b190.png)
* ์ฃผ์ ๊ธฐ๋ฅ
  - ๊ฒ์๊ธ ๋ฆฌ์คํธ ๊ตฌํ
  
**4. ๊ฒ์๊ธ**
![5 ๋จ์ ๊ฒ์๋ฌผ](https://user-images.githubusercontent.com/107667158/222337714-9e500aa4-833b-428e-8461-fe02717041ea.png)
* ์ฃผ์ ๊ธฐ๋ฅ
  - ๋ก๊ทธ์ธ ํ ์์ด๋์ ์์ฑ์๊ฐ ๋ค๋ฅด๋ฉด ์์  ๋ชปํ๊ฒ ์ฒ๋ฆฌ
  
![6 ๋ด ๊ฒ์๊ธ](https://user-images.githubusercontent.com/107667158/222337715-bfa32276-3997-4f8b-9be4-19a0a728d82d.png)
* ์ฃผ์ ๊ธฐ๋ฅ
  - ๋ก๊ทธ์ธ ํ ์์ด๋์ ์์ฑ์๊ฐ ๊ฐ์ผ๋ฉด ์์ /์ญ์  ๋ฒํผ ๋์ค๊ฒํ๊ธฐ
  - ์ญ์  ๋๋ฅด๋ฉด ๊ฒ์๊ธ ์ญ์  
  
![7 ๊ฒ์๊ธ ์์ ](https://user-images.githubusercontent.com/107667158/222337717-63dc829c-3f03-46a2-a075-0d30fcd40412.png)
* ์ฃผ์ ๊ธฐ๋ฅ
  - ๊ฒ์๊ธ ์์ ํ ์์  ๋ฒํผ ๋๋ฅด๋ฉด ์์ 
  
**5. ํ์ ์ ๋ณด ์์ **    
![8 ํ์์ ๋ณด ์์ ](https://user-images.githubusercontent.com/107667158/222337719-7e1c8f57-7e31-4bae-a6fa-cafca61f7bf8.png)
* ์ฃผ์ ๊ธฐ๋ฅ
  - ๋น๋ฐ๋ฒํธ, ๋๋ค์, ์ด๋ฆ ์์ 
  - ์์  ํ ์ฌ๋ก๊ทธ์ธ ํ์ง ์์๋ ์ฌ์ฉ์ ํ๋ฉด์ ์์ ๋ ์ ๋ณด ๋ณด์ฌ์ฃผ๊ธฐ (์ธ์ ๋ณ๊ฒฝ)

  
 ## ๐  ํ ์์  ์ถ๊ฐ ๋ฐ ์์ ์ฌํญ
  - ๋๊ธ CRUD ๊ตฌํ
  - ๊ฒ์ api ๊ตฌํ


