package com.productservice.productservice.controller;


import com.productservice.productservice.dtos.FakeStoreProductDTO;
import com.productservice.productservice.dtos.GenericProductDTO;
import com.productservice.productservice.services.FakeStoreProductService;
import com.productservice.productservice.services.ProductService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@Getter
@Setter
//this is the way to tell Spring that it is not a normal controller, rather its containing a Rest API
public class ProductController {
    //@Autowired//Field Injection is not recommended
    private ProductService productService;

    //@Autowired//optional in new Spring Version
    //constructor Injection
    public ProductController(@Qualifier("fakestoreproductservice") ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/{id}")
    public GenericProductDTO getProductByID(@PathVariable("id") Long id) {
        return productService.getProductByID(id);
        //return "Product fetched with id: " + id;
    }

    @GetMapping
    public List<GenericProductDTO> getAllProducts() {
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteProductByID() {

    }

    @PostMapping
    public void createProduct() {

    }

    public void updateProductByID(){

    }
}
