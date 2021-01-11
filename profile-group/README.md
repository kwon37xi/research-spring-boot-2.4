# Spring Boot 2.4 multi module properties & profile-group
* [Spring Boot Config Data Migration Guide · spring-projects/spring-boot Wiki](https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-Config-Data-Migration-Guide)

## 말단 모듈의 프라퍼티 override
어떤 전략이든 말단 모듈(배포 모듈, web,batch,integration test 등)은 import 한
다른 모듈의 프라퍼티를 자신의 프라퍼티 설정에서 오버라이드 할 수 있다.

말단 모듈의 설정이 최종으로 선택된다. (명시적 명령행 오버라이드를 안한다면)

## 의존 모듈의 default 값
첫 yml 구분자 ```---``` 가 나오기 전에 미리 프라퍼티를 선언해두면, 기본값으로 모든 프로필에 적용되며,
각 프로필 혹은 말단 모듈에서 오버라이드 할 수 있다.

## 전략 1 - 모든 properties yml 에서 profile 을 일관성있게 `local,develop,prod` 형태로 맞춘다.
이 경우 말단 모듈(배포 모듈) 에서는 다른 모듈의 yml 파일을 import 만 해주면 된다.

### 의존 모듈 application.yml
```
# 이 부분은 프로필 혹은 말단 모듈에서 오버라이드 하지 않으면 적용되는 프라퍼티들
profile-group:
    module1:
        name: "ProfileGroup Module1 - default"
        target: default-module1
        pre-override: pgm1-ov-default
---
spring:
    config:
      activate:
        on-profile: local # 이 프로필은 말단 모듈의 배포 프로필과 일치시킨다.
profile-group:
    module1:
        name: "ProfileGroup Module1 - local"
        target: local-module1
        pre-override: pgm1-ov-local
```

### 말단 모듈 application.yml
```
spring:
    config:
        import: "classpath:/module1.yml,classpath:/module2.yml"
# profile group 설정이 불필요하다.

---
spring:
  config:
      activate:
          on-profile: local

profile-group:
    module1:
        pre-override: web-override-mod1-local # 모듈의 프라퍼티를 오버라이드 한다.
    module2:
        pre-override: web-override-mod2-local
```

## 전략 2 - module 별로 프로필 이름을 `module-name-[profile]` 형태 등으로 하고서, profile group 사용
말단 모듈(배포 모듈) 에서는 다른 모듈의 yml 파일을 import 해 준 뒤에 최종 profile 에
profile-group 을 지정해준다.

이 경우 말단 모듈이 종류별로 의존 모듈의 프로필을 선택가능해 진다.

예) batch 말단 모듈에서는 m1-batch-local, web 말단 모듈에서는 m1-web-local 형태로 선택 가능. (그러나 이는 충분히 override 기법으로 대체 가능함.)

### 의존 모듈 application.yml
```
---
spring:
    config:
      activate:
        on-profile: m1-local # profile 이름.
profile-group:
    module1:
        name: "ProfileGroup Module1 - local"
        target: local-module1
        pre-override: pgm1-ov-local
```

### 말단 모듈 application.yml
```
spring:
    config:
        import: "classpath:/module1.yml,classpath:/module2.yml"
    profiles:
        group:
            local: "m1-local,m2-local"
            prod: "m1-prod,m2-prod"
```
