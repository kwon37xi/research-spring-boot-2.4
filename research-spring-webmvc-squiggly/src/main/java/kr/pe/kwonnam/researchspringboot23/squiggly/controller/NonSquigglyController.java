package kr.pe.kwonnam.researchspringboot23.squiggly.controller;

import kr.pe.kwonnam.researchspringboot23.squiggly.model.Hobby;
import kr.pe.kwonnam.researchspringboot23.squiggly.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

@RestController
public class NonSquigglyController {
    @GetMapping("/hello")
    public User hello() {
        return User.builder()
            .id(100L)
            .name("HelloWorld")
            .email("helloworld@mymail.com")
            .friendNum(11)
            .phoneNumber("010-1234-9999")
            .birthday(LocalDate.now())
            .hobbies(List.of(Hobby.builder().name("취미하나").price(BigInteger.valueOf(30)).build(),
                Hobby.builder().name("취미둘").price(BigInteger.valueOf(50)).build()))
            .build();
    }
}
