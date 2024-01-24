package com.productservice.productservice.security;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class TokenValidator {

    private RestTemplateBuilder restTemplateBuilder;

    TokenValidator(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder = restTemplateBuilder;
    }
    /*
    this method will be used to call user service and validate token.
    If the token is valid then return the corresponding object else return null
     */

    public Optional<JwtObject> validateToken(String token)
    {
        RestTemplate restTemplate = restTemplateBuilder.build();
        //make a call to user service to validate token
        return Optional.empty();
    }
}
