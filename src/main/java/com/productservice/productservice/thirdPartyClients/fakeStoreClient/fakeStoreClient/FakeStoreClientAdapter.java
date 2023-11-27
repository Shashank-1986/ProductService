package com.productservice.productservice.thirdPartyClients.fakeStoreClient.fakeStoreClient;

import com.productservice.productservice.dtos.FakeStoreProductDTO;
import com.productservice.productservice.dtos.GenericProductDTO;
import com.productservice.productservice.exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
//@Configuration
//@PropertySource("classpath:application.properties")
public class FakeStoreClientAdapter {

//    private String fakeStoreUrl;
//    private String pathForProducts;

//    @Value("${fakestore.api.url}")
//    private  String fakestoreurl;
////
//    @Value("${fakestore.api.path.products}")
//    private String productpath;
    private String specificProductUrl;
    private String genericProductUrl;

    private RestTemplateBuilder restTemplateBuilder;

    @Autowired
    FakeStoreClientAdapter(RestTemplateBuilder restTemplateBuilder,
                           @Value("${fakestore.api.url}") String fakestoreurl,
                           @Value("${fakestore.api.path.products}") String productpath)
    {
        this.restTemplateBuilder = restTemplateBuilder;
        this.specificProductUrl = fakestoreurl + productpath + "/{id}";
        this.genericProductUrl =  fakestoreurl + productpath;
    }


    public FakeStoreProductDTO getProductByID(Long id) throws ProductNotFoundException {
        //RestTemplate
        //will convert the http request, the object which you get into JSON and Java object back to JSON
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDTO> responseEntity =
                restTemplate.getForEntity(specificProductUrl,FakeStoreProductDTO.class, id);

        FakeStoreProductDTO fakeStoreProductDTO = responseEntity.getBody();

        if(fakeStoreProductDTO==null)
        {
            throw new ProductNotFoundException("Product with id: "+ id  +" doesn't exist");
        }

        return fakeStoreProductDTO;
    }


    public List<FakeStoreProductDTO> getAllProducts() {

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDTO[]> responseEntity =
                restTemplate.getForEntity(genericProductUrl, FakeStoreProductDTO[].class);
        // List<GenericProductDTO> result = new ArrayList<>();
        return List.of(responseEntity.getBody());
    }
    public FakeStoreProductDTO createProduct(GenericProductDTO genericProductDTO) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDTO> responseEntity =
                restTemplate.postForEntity(genericProductUrl, genericProductDTO, FakeStoreProductDTO.class);
        //type erasure
        //Generics - For java datatypes of list does not matter at the run time.

        return responseEntity.getBody();
    }
    public FakeStoreProductDTO deleteProductByID(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();

        RequestCallback requestCallback =  restTemplate.acceptHeaderRequestCallback(FakeStoreProductDTO.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDTO>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDTO.class);
        ResponseEntity<FakeStoreProductDTO> responseEntity =
                restTemplate.execute(specificProductUrl, HttpMethod.DELETE, requestCallback, responseExtractor, id);
        //restTemplate.execute(specificProductUrl, HttpMethod.DELETE, requestCallback, responseExtractor, id);
        return responseEntity.getBody();
    }
    public FakeStoreProductDTO updateProductByID(Long id, GenericProductDTO genericProductDTO) {
        RestTemplate restTemplate = restTemplateBuilder.build();

        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDTO.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDTO>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDTO.class);
        ResponseEntity<FakeStoreProductDTO> responseEntity =
                restTemplate.execute(specificProductUrl, HttpMethod.PUT, requestCallback, responseExtractor, id);
        //restTemplate.exchange(specificProductUrl, HttpMethod.PATCH, requestCallback, responseExtractor, id);
        return responseEntity.getBody();
    }
}
