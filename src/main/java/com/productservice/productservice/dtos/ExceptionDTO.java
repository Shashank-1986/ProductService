package com.productservice.productservice.dtos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ExceptionDTO {

    private HttpStatus httpStatus;
    private String message;
}
