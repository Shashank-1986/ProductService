package com.productservice.productservice.controller;

import com.productservice.productservice.dtos.GenericProductDTO;
import com.productservice.productservice.exceptions.ProductNotFoundException;
import com.productservice.productservice.services.ProductService;
import com.productservice.productservice.thirdPartyClients.fakeStoreClient.fakeStoreClient.FakeStoreClientAdapter;
import jakarta.inject.Inject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductControllerTests {

    @Inject
    private ProductController productController;

    @Inject
    private FakeStoreClientAdapter fakeStoreClientAdapter;

    @MockBean
    private ProductService productService;

    @Test
    @DisplayName("testoneplus")
    void testOnePlusOneIsTwoOrNot()
    {
       //assert(2 == 1+1);
        //assertEquals(2, 1+1, "result should be 2");
        assertTrue(2==2, "result should be 2");
    }

    @Test
    void testGetProductById() throws ProductNotFoundException {
        //assertThrows(ProductNotFoundException.class, () ->fakeStoreClientAdapter.getProductByID(10L));
        assertNull(fakeStoreClientAdapter.getProductByID(1000L));

    }
    @Test
    void testGetProductByIdMock() throws ProductNotFoundException {
        GenericProductDTO genericProductDTO = new GenericProductDTO();
        when(productService.getProductByID(100L)).thenReturn(genericProductDTO);

        GenericProductDTO genericProductDTO1 = productController.getProductByID(100L);
        assertEquals(genericProductDTO1, genericProductDTO);
        //assertEquals(genericProductDTO, productController.getProductByID(100L));
        //assertNull(productController.getProductByID(100L));
    }

    @Test
    void testGetProductByIdMockException() throws ProductNotFoundException {
        when(productService.getProductByID(1L)). thenThrow(ProductNotFoundException.class);
        assertThrows(ProductNotFoundException.class, () ->productController.getProductByID(1L));
    }
}
