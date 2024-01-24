package com.productservice.productservice.services;


import com.productservice.productservice.dtos.FakeStoreProductDTO;
import com.productservice.productservice.dtos.GenericProductDTO;
import com.productservice.productservice.exceptions.ProductNotFoundException;
import com.productservice.productservice.security.JwtObject;
import com.productservice.productservice.security.TokenValidator;
import com.productservice.productservice.thirdPartyClients.fakeStoreClient.fakeStoreClient.FakeStoreClientAdapter;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Primary
@Service
//it tells the spring to create the object
//it comprises of three annotation @Component, @Repository , @Controller.
//These annotations help define the roles of various components in a Spring application
public class FakeStoreProductService implements ProductService {
        private FakeStoreClientAdapter fakeStoreClientAdapter;

        private TokenValidator tokenValidator;

        //private RuleEngine ruleEngine;

        FakeStoreProductService(FakeStoreClientAdapter fakeStoreClientAdapter, TokenValidator tokenValidator)
        {
            this.fakeStoreClientAdapter = fakeStoreClientAdapter;
            this.tokenValidator = tokenValidator;
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
    public GenericProductDTO getProductByID(String authToken, Long id) throws ProductNotFoundException {

        System.out.println(authToken);
        Optional<JwtObject> jwtObjectOptional = tokenValidator.validateToken(authToken);
        if(jwtObjectOptional.isEmpty())
        {
           return null;
        }

        JwtObject jwtObject = jwtObjectOptional.get();
        Long userId = jwtObject.getUserID();
        //validation at API level can be implemented
//        if(specialIDs.isPresent(id) && userId== 10)
//        {
//
//        }
            return convertGenericToDto(fakeStoreClientAdapter.getProductByID(id));
    }

    @Override
    public List<GenericProductDTO> getAllProducts() {
        List<GenericProductDTO> result = new ArrayList<>();
        List<FakeStoreProductDTO> fakeStoreProductDTOS = fakeStoreClientAdapter.getAllProducts();
        for(FakeStoreProductDTO fakeStoreProductDTO : fakeStoreProductDTOS)
        {
            result.add(convertGenericToDto(fakeStoreProductDTO));
        }
        return result;
    }

    @Override
    public GenericProductDTO deleteProductByID(Long id) {
        return convertGenericToDto(fakeStoreClientAdapter.deleteProductByID(id));
    }
    @Override
    public GenericProductDTO createProduct(GenericProductDTO genericProductDTO) {
        return convertGenericToDto(fakeStoreClientAdapter.createProduct(genericProductDTO));
    }

    @Override
    public GenericProductDTO updateProductByID(Long id, GenericProductDTO genericProductDTO) {
        return convertGenericToDto(fakeStoreClientAdapter.updateProductByID(id, genericProductDTO));
    }
}
