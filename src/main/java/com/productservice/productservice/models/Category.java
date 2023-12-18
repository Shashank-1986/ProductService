package com.productservice.productservice.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Category extends BaseModel {
    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "category")
    //below relation is mapped in other class with category relation
    private List<Product> products;
}
