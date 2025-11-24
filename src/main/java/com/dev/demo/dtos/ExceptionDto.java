package com.dev.demo.dtos;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ExceptionDto {
    private HttpStatus status;
    private String message;

    public ExceptionDto(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }
}
