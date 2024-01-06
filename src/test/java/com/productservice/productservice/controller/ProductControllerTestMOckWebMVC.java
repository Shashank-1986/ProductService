package com.productservice.productservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.productservice.productservice.dtos.GenericProductDTO;
import com.productservice.productservice.repositories.ProductRepository;
import com.productservice.productservice.services.ProductService;
import jakarta.inject.Inject;
import org.hibernate.mapping.Any;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//hamcrest allows you to compare json data and also give multiple options of Matchers.
import static  org.hamcrest.Matchers.is;

@WebMvcTest(ProductController.class)
public class ProductControllerTestMOckWebMVC {

    @MockBean
    private ProductService productService;

    @Inject
    private MockMvc mockMvc;

    @Inject
    private ObjectMapper objectMapper;
//    @Autowired
//    private ProductRepository productRepository;

    @Test
    void testGetAllProductReturnsEmptyList() throws Exception {
        when(productService.getAllProducts()).thenReturn(new ArrayList<>());

        mockMvc.perform(MockMvcRequestBuilders.get("/products"))
                .andExpect(status().is(400))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    void testGetAllProductReturnsValidList() throws Exception {
        List<GenericProductDTO> genericProductDTOS = new ArrayList<>();
        genericProductDTOS.add(new GenericProductDTO());
        genericProductDTOS.add(new GenericProductDTO());
        genericProductDTOS.add(new GenericProductDTO());

        when(productService.getAllProducts()).thenReturn(genericProductDTOS);

        mockMvc.perform(MockMvcRequestBuilders.get("/products"))
                .andExpect(status().is(200))
//                .andExpect(MockMvcResultMatchers.content().string("[]"));
                //objectmapper is class which helps in conversion of Java objects into string so that it can be compared again JSON Strings
                .andExpect(MockMvcResultMatchers.content().string(objectMapper.writeValueAsString(genericProductDTOS)));
    }

    @Test
    void testCreateProductShouldCreateValidProduct() throws Exception {
        GenericProductDTO generateCreateProductDto =new GenericProductDTO();
        generateCreateProductDto.setTitle("MacBook");
        generateCreateProductDto.setPrice(100000);
        generateCreateProductDto.setDescription("Fastest Mac Ever");
        generateCreateProductDto.setCategory("Laptop");

        GenericProductDTO outputProductDto = new GenericProductDTO();
        outputProductDto.setTitle(generateCreateProductDto.getTitle());
        //outputProductDto.setTitle("iPhone");
        outputProductDto.setPrice(generateCreateProductDto.getPrice());
        outputProductDto.setDescription(generateCreateProductDto.getDescription());
        outputProductDto.setCategory(generateCreateProductDto.getCategory());
        outputProductDto.setId(1000L);

        when(productService.createProduct(any())).thenReturn(outputProductDto);

        mockMvc.perform(MockMvcRequestBuilders.post("/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(generateCreateProductDto))
        )
                .andExpect(MockMvcResultMatchers.content().string(objectMapper.writeValueAsString(outputProductDto))
                )
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.title", is("iPhone")));
    }
}
