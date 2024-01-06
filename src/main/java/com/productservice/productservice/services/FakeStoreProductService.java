package com.productservice.productservice.services;


import com.productservice.productservice.dtos.FakeStoreProductDTO;
import com.productservice.productservice.dtos.GenericProductDTO;
import com.productservice.productservice.exceptions.ProductNotFoundException;
import com.productservice.productservice.thirdPartyClients.fakeStoreClient.fakeStoreClient.FakeStoreClientAdapter;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Primary
@Service
//it tells the spring to create the object
//it comprises of three annotation @Component, @Repository , @Controller.
//These annotations help define the roles of various components in a Spring application
public class FakeStoreProductService implements ProductService {
        private FakeStoreClientAdapter fakeStoreClientAdapter;

        FakeStoreProductService(FakeStoreClientAdapter fakeStoreClientAdapter)
        {
            this.fakeStoreClientAdapter = fakeStoreClientAdapter;
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
    public GenericProductDTO getProductByID(Long id) throws ProductNotFoundException {
        return convertGenericToDto(fakeStoreClientAdapter.getProductByID(id));
    }

    public List<GenericProductDTO> getAllProducts() {
        List<GenericProductDTO> result = new ArrayList<>();
        List<FakeStoreProductDTO> fakeStoreProductDTOS = fakeStoreClientAdapter.getAllProducts();
        for(FakeStoreProductDTO fakeStoreProductDTO : fakeStoreProductDTOS)
        {
            result.add(convertGenericToDto(fakeStoreProductDTO));
        }
        return result;
    }

    public GenericProductDTO deleteProductByID(Long id) {
        return convertGenericToDto(fakeStoreClientAdapter.deleteProductByID(id));
    }
    @Override
    public GenericProductDTO createProduct(GenericProductDTO genericProductDTO) {
        return convertGenericToDto(fakeStoreClientAdapter.createProduct(genericProductDTO));
    }

    public GenericProductDTO updateProductByID(Long id, GenericProductDTO genericProductDTO) {
        return convertGenericToDto(fakeStoreClientAdapter.updateProductByID(id, genericProductDTO));
    }
}
