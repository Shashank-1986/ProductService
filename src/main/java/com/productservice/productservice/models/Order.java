package com.productservice.productservice.models;


import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name ="orders")
public class Order extends BaseModel {

    @ManyToMany
    @JoinTable(name = "products_orders",
            inverseJoinColumns = @JoinColumn(name = "product_id"),
            joinColumns = @JoinColumn(name = "order_id"))
    private List<Product> products;
}
