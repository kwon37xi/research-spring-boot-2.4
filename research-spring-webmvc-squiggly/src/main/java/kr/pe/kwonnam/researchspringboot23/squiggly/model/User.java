package kr.pe.kwonnam.researchspringboot23.squiggly.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@Builder
public class User {
    private Long id;
    private String name;
    private String email;
    private LocalDate birthday; // format 변경 적용 확인을 위한 고의적 java.util.Date
    private String phoneNumber;
    private int friendNum;
    private List<Hobby> hobbies;
}
