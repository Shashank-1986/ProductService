package com.productservice.productservice.services;

import com.productservice.productservice.dtos.FakeStoreProductDTO;
import com.productservice.productservice.dtos.GenericProductDTO;
import com.productservice.productservice.exceptions.ProductNotFoundException;

import java.util.List;

public interface ProductService {

    GenericProductDTO getProductByID(Long id) throws ProductNotFoundException;

    List<GenericProductDTO> getAllProducts();

    GenericProductDTO deleteProductByID(Long id);

    GenericProductDTO createProduct(GenericProductDTO genericProductDTO);

    GenericProductDTO updateProductByID(Long id, GenericProductDTO genericProductDTO);
}
