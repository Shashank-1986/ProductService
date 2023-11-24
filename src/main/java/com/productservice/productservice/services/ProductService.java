package com.productservice.productservice.services;

import com.productservice.productservice.dtos.FakeStoreProductDTO;
import com.productservice.productservice.dtos.GenericProductDTO;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public interface ProductService {

    GenericProductDTO getProductByID(Long id);

    List<GenericProductDTO> getAllProducts();

    void deleteProductByID();

    GenericProductDTO createProduct(GenericProductDTO genericProductDTO);

    void updateProductByID();
}
