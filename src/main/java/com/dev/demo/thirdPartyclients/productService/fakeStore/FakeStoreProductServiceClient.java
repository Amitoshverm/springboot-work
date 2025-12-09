package com.dev.demo.thirdPartyclients.productService.fakeStore;

import com.dev.demo.dtos.GenericProductDto;
import com.dev.demo.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductServiceClient  {

    private RestTemplateBuilder restTemplateBuilder;

    @Value("${fake.store.url}")
    private String fakeStoreApiBaseUrl;
    @Value("${fake.store.products.path}")
    private String productEndpoint;

    private final String specificProductUrl = fakeStoreApiBaseUrl + productEndpoint + "/{id}";
    private final String productBaseUrl = fakeStoreApiBaseUrl + productEndpoint;

    public FakeStoreProductServiceClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    private GenericProductDto convertToGenericProductDto(FakeStoreProductDto fakeStoreProductDto) {
        GenericProductDto product = new GenericProductDto();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setCategory(fakeStoreProductDto.getCategory());
        product.setImage(fakeStoreProductDto.getImage());
        return product;
    }

    public FakeStoreProductDto getProductById(Long id) throws NotFoundException {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response= restTemplate.getForEntity(specificProductUrl, FakeStoreProductDto.class, id);
//        response.getStatusCode();
        FakeStoreProductDto fakeStoreProductDto = response.getBody();
        if (fakeStoreProductDto == null) {
            throw new NotFoundException("Product with id " + id + " not found.");
        }
        return fakeStoreProductDto;
    }

    public FakeStoreProductDto createProduct(GenericProductDto productDto) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response= restTemplate.postForEntity(productBaseUrl, productDto, FakeStoreProductDto.class);
        return response.getBody();
    }

    public FakeStoreProductDto deleteProductById(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();

        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor =
                restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
        ResponseEntity<FakeStoreProductDto> response =
                restTemplate.execute(specificProductUrl, HttpMethod.DELETE, requestCallback, responseExtractor, id);

        return response.getBody();
    }

    public List<FakeStoreProductDto> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> response = restTemplate.getForEntity(productBaseUrl, FakeStoreProductDto[].class);

        List<FakeStoreProductDto> products = new ArrayList<>();

        for (FakeStoreProductDto dto : response.getBody()) {
            products.add(dto);
        }
        return products;
    }

    public FakeStoreProductDto updateProductById(Long id, GenericProductDto productDto) throws NotFoundException{
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response = restTemplate.getForEntity(specificProductUrl, FakeStoreProductDto.class, id);
        FakeStoreProductDto fakeStoreProductData = response.getBody();

        if (fakeStoreProductData == null) {
            throw new NotFoundException("Product with id " + id + " not found.");
        }
        FakeStoreProductDto updatedProduct = new FakeStoreProductDto();
        updatedProduct.setId(productDto.getId());
        updatedProduct.setTitle(productDto.getTitle());
        updatedProduct.setDescription(productDto.getDescription());
        updatedProduct.setPrice(productDto.getPrice());
        updatedProduct.setCategory(productDto.getCategory());
        updatedProduct.setImage(productDto.getImage());

        return updatedProduct;
    }
}
