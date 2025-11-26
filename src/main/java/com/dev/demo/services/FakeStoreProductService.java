package com.dev.demo.services;
import com.dev.demo.dtos.GenericProductDto;
import com.dev.demo.exceptions.NotFoundException;
import com.dev.demo.thirdPartyclients.productService.fakeStore.FakeStoreProductServiceClient;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{

    private FakeStoreProductServiceClient fakeStoreProductServiceClient;

    public FakeStoreProductService(FakeStoreProductServiceClient fakeStoreProductServiceClient) {
        this.fakeStoreProductServiceClient = fakeStoreProductServiceClient;
    }

    @Override
    public GenericProductDto getProductById(Long id) throws NotFoundException {
        return fakeStoreProductServiceClient.getProductById(id);
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto productDto) {
        return fakeStoreProductServiceClient.createProduct(productDto);
    }

    @Override
    public GenericProductDto deleteProductById(Long id) {
        return fakeStoreProductServiceClient.deleteProductById(id);
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        return fakeStoreProductServiceClient.getAllProducts();
    }

    @Override
    public GenericProductDto updateProductById(Long id, GenericProductDto productDto) throws NotFoundException{
        return fakeStoreProductServiceClient.updateProductById(id, productDto);
    }
}
