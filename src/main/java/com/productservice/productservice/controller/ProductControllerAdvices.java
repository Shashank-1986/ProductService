package com.productservice.productservice.controller;

import com.productservice.productservice.dtos.ExceptionDTO;
import com.productservice.productservice.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
//Control will reach to this class if any exception is being thrown from any Controller
public class ProductControllerAdvices {

//    @ExceptionHandler(ProductNotFoundException.class)
//    private ResponseEntity<ExceptionDTO> handleProductNotFoundException(ProductNotFoundException productNotFoundException)
//    {
//        ExceptionDTO exceptionDTO = new ExceptionDTO();
//        exceptionDTO.setHttpStatus(HttpStatus.NOT_FOUND);
//        exceptionDTO.setMessage(productNotFoundException.getMessage());
//
//        return new ResponseEntity<>(exceptionDTO, HttpStatus.NOT_FOUND);
//    }
    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody()
    private ExceptionDTO handleProductNotFoundException(ProductNotFoundException productNotFoundException)
    {
        ExceptionDTO exceptionDTO = new ExceptionDTO();
        exceptionDTO.setHttpStatus(HttpStatus.NOT_FOUND);
        exceptionDTO.setMessage(productNotFoundException.getMessage());
        return exceptionDTO;
    }
    //we can as many as exception which can arise from any Controller and can be handled here

    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    private ResponseEntity<ExceptionDTO> handleArrayOutOfBoundException(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException){
        return null;
    }
}
