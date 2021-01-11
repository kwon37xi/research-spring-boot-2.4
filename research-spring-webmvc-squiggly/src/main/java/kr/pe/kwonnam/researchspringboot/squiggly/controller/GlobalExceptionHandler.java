package kr.pe.kwonnam.researchspringboot.squiggly.controller;

import kr.pe.kwonnam.researchspringboot.squiggly.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> runtimeException(RuntimeException runtimeException) {
        return new ResponseEntity(ErrorResponse.builder()
            .ref("https://error/ref/...")
            .code("RE0000")
            .desc(String.format("오류 발생 - %s", runtimeException.getMessage()))
            .build(), HttpStatus.BAD_REQUEST);
    }
}
