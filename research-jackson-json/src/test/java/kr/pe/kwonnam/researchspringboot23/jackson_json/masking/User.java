package kr.pe.kwonnam.researchspringboot23.jackson_json.masking;

import kr.pe.kwonnam.researchspringboot23.jackson_json.masking.annotationdetector.Maskable;
import kr.pe.kwonnam.researchspringboot23.jackson_json.masking.maskers.BankAccountMasker;
import kr.pe.kwonnam.researchspringboot23.jackson_json.masking.maskers.EmailMasker;
import kr.pe.kwonnam.researchspringboot23.jackson_json.masking.maskers.PhoneNumberMasker;
import kr.pe.kwonnam.researchspringboot23.jackson_json.masking.maskers.ToStringLastHalfMasker;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class User {
    private String name;

    @Maskable(value = EmailMasker.class)
    private String email;

    @Maskable(value = PhoneNumberMasker.class)
    private String phoneNumber;

    @Maskable
    private String favouriteThing;

    @Maskable(BankAccountMasker.class)
    private String bankAccount;

    @Maskable
    private LocalDate birthday;

    @Maskable
    private int friendCount;

    @Maskable(ToStringLastHalfMasker.class)
    private String address;
}
