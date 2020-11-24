package kr.pe.kwonnam.researchspringboot23.squiggly.controller;

import kr.pe.kwonnam.researchspringboot23.squiggly.model.ErrorResponse;
import kr.pe.kwonnam.researchspringboot23.squiggly.model.Hobby;
import kr.pe.kwonnam.researchspringboot23.squiggly.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/squiggly")
public class SquigglyController {

    @GetMapping("/users/{id}")
    public User findUser(@PathVariable("id") Long userId) {
        return generateUser(userId);
    }

    private User generateUser(Long userId) {
        return User.builder()
            .id(userId)
            .name("Name " + userId)
            .email("email-" + userId + "@mymail.com")
            .friendNum(Math.toIntExact(userId * 3))
            .phoneNumber("010-1234-567" + userId)
            .birthday(LocalDate.now())
            .hobbies(List.of(Hobby.builder().name("취미하나").price(BigInteger.valueOf(userId * 1000)).build(),
                Hobby.builder().name("취미둘").price(BigInteger.valueOf(userId * 1500)).build(),
                Hobby.builder().name("취미셋").price(BigInteger.valueOf(userId * 2000)).build()))
            .build();
    }


    @GetMapping("/users")
    public List<User> findUsers() {
        return List.of(generateUser(1L), generateUser(2L), generateUser(3L));
    }

    @GetMapping("/error")
    public ErrorResponse error() {
        throw new IllegalArgumentException("내맘대로 내보는 에러!!");
    }

}
