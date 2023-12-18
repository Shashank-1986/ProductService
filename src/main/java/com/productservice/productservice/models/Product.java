package com.productservice.productservice.models;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel{
    private String title;
    private int price;
    //category is not a primitive attribute, its a relation
    @ManyToOne
    private Category category;
    private String description;
    private String image;
}
