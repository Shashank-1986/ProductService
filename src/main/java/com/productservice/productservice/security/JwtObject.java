package com.productservice.productservice.security;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class JwtObject {

    private String email;
    private Long userID;

    private Date expiryAt;
    private Date createdAt;

}
