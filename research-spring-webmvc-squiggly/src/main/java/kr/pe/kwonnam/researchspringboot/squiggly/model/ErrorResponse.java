package kr.pe.kwonnam.researchspringboot.squiggly.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class ErrorResponse {
    private String code;
    private String desc;
    private String ref;
}
