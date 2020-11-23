package kr.pe.kwonnam.researchspringboot23.squiggly.model;

import com.github.bohnman.squiggly.view.FullView;
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
