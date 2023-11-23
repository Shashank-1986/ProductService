package com.productservice.productservice.dtos;

import com.productservice.productservice.models.Category;
import lombok.Getter;
import lombok.Setter;
//DTO stands for Data Transfer Object

@Getter
@Setter
public class FakeStoreProductDTO {
    private Long id;
    private String title;
    private int price;
    private String category;
    private String description;
    private String image;
}
