package com.productservice.productservice.models;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel{
    private String title;
    //category is not a primitive attribute, its a relation
    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private Category category;
    private String description;
    private String image;

    @OneToOne(cascade = {CascadeType.REMOVE})
    @JoinColumn(nullable = false)
    private Price price;
}
