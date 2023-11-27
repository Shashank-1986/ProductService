package com.productservice.productservice.services;


import com.productservice.productservice.dtos.FakeStoreProductDTO;
import com.productservice.productservice.dtos.GenericProductDTO;
import com.productservice.productservice.exceptions.ProductNotFoundException;
import com.productservice.productservice.thirdPartyClients.fakeStoreClient.fakeStoreClient.FakeStoreClientAdapter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("fakestoreproductservice")
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
        //RestTemplate
        //will convert the http request, the object which you get into JSON and Java object back to JSON
//        RestTemplate restTemplate = restTemplateBuilder.build();
//        ResponseEntity<FakeStoreProductDTO> responseEntity =
//                        restTemplate.getForEntity(specificProductUrl,FakeStoreProductDTO.class, id);
//
//        FakeStoreProductDTO fakeStoreProductDTO = responseEntity.getBody();
//
//        if(fakeStoreProductDTO==null)
//        {
//            throw new ProductNotFoundException("Product with id: "+ id  +" doesn't exist");
//        }
//
//        return convertGenericToDto(responseEntity.getBody());

        return convertGenericToDto(fakeStoreClientAdapter.getProductByID(id));
    }

    public List<GenericProductDTO> getAllProducts() {

//        RestTemplate restTemplate = restTemplateBuilder.build();
//        ResponseEntity<FakeStoreProductDTO[]> responseEntity =
//                restTemplate.getForEntity(genericProductUrl, FakeStoreProductDTO[].class);
        List<GenericProductDTO> result = new ArrayList<>();
//        List<FakeStoreProductDTO> fakeStoreProductDTOS = List.of(responseEntity.getBody());
//        for(FakeStoreProductDTO fakeStoreProductDTO : fakeStoreProductDTOS)
//        {
//            result.add(convertGenericToDto(fakeStoreProductDTO));
//        }
        List<FakeStoreProductDTO> fakeStoreProductDTOS = fakeStoreClientAdapter.getAllProducts();
        for(FakeStoreProductDTO fakeStoreProductDTO : fakeStoreProductDTOS)
        {
            result.add(convertGenericToDto(fakeStoreProductDTO));
        }
//        return convertGenericToDto(thirdPartyInterface.getAllProducts());
        return result;
    }

    public GenericProductDTO deleteProductByID(Long id) {
//        RestTemplate restTemplate = restTemplateBuilder.build();
//
//        RequestCallback requestCallback =  restTemplate.acceptHeaderRequestCallback(FakeStoreProductDTO.class);
//        ResponseExtractor<ResponseEntity<FakeStoreProductDTO>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDTO.class);
//        ResponseEntity<FakeStoreProductDTO> responseEntity =
//                restTemplate.execute(specificProductUrl, HttpMethod.DELETE, requestCallback, responseExtractor, id);
//                //restTemplate.execute(specificProductUrl, HttpMethod.DELETE, requestCallback, responseExtractor, id);
        return convertGenericToDto(fakeStoreClientAdapter.deleteProductByID(id));
    }
    @Override
    public GenericProductDTO createProduct(GenericProductDTO genericProductDTO) {
//        RestTemplate restTemplate = restTemplateBuilder.build();
//        ResponseEntity<FakeStoreProductDTO> responseEntity =
//            restTemplate.postForEntity(genericProductUrl, genericProductDTO, FakeStoreProductDTO.class);
        //type erasure
        //Generics - For java datatypes of list does not matter at the run time.

        return convertGenericToDto(fakeStoreClientAdapter.createProduct(genericProductDTO));
    }

    public GenericProductDTO updateProductByID(Long id, GenericProductDTO genericProductDTO) {
//        RestTemplate restTemplate = restTemplateBuilder.build();
//
//        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDTO.class);
//        ResponseExtractor<ResponseEntity<FakeStoreProductDTO>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDTO.class);
//        ResponseEntity<FakeStoreProductDTO> responseEntity =
//                restTemplate.execute(specificProductUrl, HttpMethod.PUT, requestCallback, responseExtractor, id);
//                //restTemplate.exchange(specificProductUrl, HttpMethod.PATCH, requestCallback, responseExtractor, id);

        return convertGenericToDto(fakeStoreClientAdapter.updateProductByID(id, genericProductDTO));
    }
}
