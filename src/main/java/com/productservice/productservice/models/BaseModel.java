package com.productservice.productservice.models;


import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
//dont create table for base model but pass the attribute to inherited class
public class BaseModel {
    @Id
    @GeneratedValue(generator = "uuidgenerator")
    //This annotation is generally used in conjunction with @Id annotation to automatically generate unique values for primary key columns within our database tables.
    @GenericGenerator(name = "uuidgenerator", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "binary(16)", nullable = false, updatable = false)
    private UUID id;
}
