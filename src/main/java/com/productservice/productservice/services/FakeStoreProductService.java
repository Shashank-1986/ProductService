package com.productservice.productservice.services;


import com.productservice.productservice.dtos.FakeStoreProductDTO;
import com.productservice.productservice.dtos.GenericProductDTO;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakestoreproductservice")
//it tells the spring to create the object
//it comprises of three annotation @Component, @Repository , @Controller.
//These annotations help define the roles of various components in a Spring application
public class FakeStoreProductService implements ProductService {
        private String getProductURL = "https://fakestoreapi.com/products/{id}";

        private String getAllProductURL = "https://fakestoreapi.com/products/";
        private RestTemplateBuilder restTemplateBuilder;

    FakeStoreProductService(RestTemplateBuilder restTemplateBuilder)
    {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    private static GenericProductDTO convertGenericToDto(FakeStoreProductDTO fakeStoreProductDTO)
    {
        GenericProductDTO genericProductDTO =new GenericProductDTO();
        genericProductDTO.setId(fakeStoreProductDTO.getId());
        genericProductDTO.setCategory(fakeStoreProductDTO.getCategory());
        genericProductDTO.setTitle(fakeStoreProductDTO.getTitle());
        genericProductDTO.setPrice(fakeStoreProductDTO.getPrice());
        genericProductDTO.setDescription(fakeStoreProductDTO.getDescription());
        genericProductDTO.setImage(fakeStoreProductDTO.getImage());
        return genericProductDTO;
    }
    @Override
    public GenericProductDTO getProductByID(Long id) {
        //RestTemplate
        //will convert the http request, the object which you get into JSON and Java object back to JSON
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDTO> responseEntity =
                        restTemplate.getForEntity(getProductURL,FakeStoreProductDTO.class, id);

        return convertGenericToDto(responseEntity.getBody());
    }

    @Override
    public List<GenericProductDTO> getAllProducts() {

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<List<FakeStoreProductDTO>> responseEntity =
        restTemplate.getForEntity(getAllProductURL, List<FakeStoreProductDTO>.class);

        List<GenericProductDTO> result = new ArrayList<>();
        List<FakeStoreProductDTO> fakeStoreProductDTOS = responseEntity.getBody();
        for(FakeStoreProductDTO fakeStoreProductDTO : fakeStoreProductDTOS)
        {
            result.add(convertGenericToDto(fakeStoreProductDTO));
        }
        return result;
    }

    @Override
    public void deleteProductByID() {

    }

    @Override
    public void createProduct() {

    }

    @Override
    public void updateProductByID() {

    }
}
