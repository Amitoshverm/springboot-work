package com.dev.demo.services;

import com.dev.demo.dtos.FakeStoreProductDto;
import com.dev.demo.dtos.GenericProductDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{

    private RestTemplateBuilder restTemplateBuilder;
    private String getRequestUrl = "https://fakestoreapi.com/products/{id}";
    private String postRquestUrl = "https://fakestoreapi.com/products";

    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @Override
    public GenericProductDto getProductById(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response= restTemplate.getForEntity(getRequestUrl, FakeStoreProductDto.class, id);
//        response.getStatusCode();
        FakeStoreProductDto fakeStoreProductDto = response.getBody();

        GenericProductDto product = new GenericProductDto();
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setCategory(fakeStoreProductDto.getCategory());
        product.setImage(fakeStoreProductDto.getImage());
        return product;
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto productDto) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<GenericProductDto> response= restTemplate.postForEntity(postRquestUrl, productDto, GenericProductDto.class);
        return response.getBody();
    }

    @Override
    public String deleteProductById(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<GenericProductDto> response = restTemplate.getForEntity(getRequestUrl, GenericProductDto.class, id);
        GenericProductDto data = response.getBody();
        if(data == null){
            return "data with id: "+id+" not found";
        }
        restTemplate.delete(getRequestUrl,id);
//        response.getStatusCode();
        return "data with id: "+id+" has been deleted";
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<List<GenericProductDto>> response = restTemplate.exchange(postRquestUrl, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<GenericProductDto>>() {
        });
        List<GenericProductDto> fakeProducts = response.getBody();
        if (fakeProducts == null) {
            return List.of();
        }
        return fakeProducts.stream().map(f -> {
            GenericProductDto product = new GenericProductDto();
            product.setTitle(f.getTitle());
            product.setPrice(f.getPrice());
            product.setDescription(f.getDescription());
            product.setCategory(f.getCategory());
            product.setImage(f.getImage());
            return product;
        }).collect(Collectors.toList());
    }

    @Override
    public GenericProductDto updateProductById(Long id, GenericProductDto productDto) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<GenericProductDto> response = restTemplate.getForEntity(getRequestUrl, GenericProductDto.class, id);
        GenericProductDto data = response.getBody();


        return null;
    }
}
