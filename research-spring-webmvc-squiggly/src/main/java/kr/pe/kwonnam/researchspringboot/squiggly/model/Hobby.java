package kr.pe.kwonnam.researchspringboot.squiggly.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigInteger;

@Getter
@Setter
@ToString
@Builder
public class Hobby {
    private String name;
    private int daysPerMonth;
    private BigInteger price;
}
