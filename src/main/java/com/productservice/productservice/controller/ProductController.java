package com.productservice.productservice.controller;


import com.productservice.productservice.dtos.ExceptionDTO;
import com.productservice.productservice.dtos.FakeStoreProductDTO;
import com.productservice.productservice.dtos.GenericProductDTO;
import com.productservice.productservice.exceptions.ProductNotFoundException;
import com.productservice.productservice.services.FakeStoreProductService;
import com.productservice.productservice.services.ProductService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public GenericProductDTO getProductByID(@PathVariable("id") Long id) throws ProductNotFoundException {
        return productService.getProductByID(id);
        //return "Product fetched with id: " + id;
    }

    @GetMapping
    public List<GenericProductDTO> getAllProducts() {
        return productService.getAllProducts();
    }

    @DeleteMapping("/{id}")
    public GenericProductDTO deleteProductByID(@PathVariable("id") Long id) {
        return productService.deleteProductByID(id);
    }

    @PostMapping
    public GenericProductDTO createProduct(@RequestBody  GenericProductDTO genericProductDTO) {
        return productService.createProduct(genericProductDTO);
    }

    @PatchMapping("/{id}")
    public GenericProductDTO updateProductByID(@PathVariable("id") Long id, @RequestBody GenericProductDTO genericProductDTO){
        return productService.updateProductByID(id, genericProductDTO);
    }

//    @ExceptionHandler(ProductNotFoundException.class)
//    //@ResponseStatus(HttpStatus.NOT_FOUND)
//    //Automatic exception handler. Whenever there is any exception of ProductNotFound in the ProductController
//    //this method will be called automatically
//    private ResponseEntity handleProductNotFoundException(ProductNotFoundException productNotFoundException)
//    {
//        ExceptionDTO exceptionDTO = new ExceptionDTO();
//        exceptionDTO.setHttpStatus(HttpStatus.NOT_FOUND);
//        exceptionDTO.setMessage(productNotFoundException.getMessage());
//
//        ResponseEntity responseEntity = new ResponseEntity( exceptionDTO, HttpStatus.NOT_FOUND);
//        return responseEntity;
//        //return exceptionDTO;
//        //System.out.println("Product not found");
//    }
}
