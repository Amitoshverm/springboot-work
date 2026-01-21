package com.dev.demo.controllers;

import com.dev.demo.dtos.GenericProductDto;
import com.dev.demo.services.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;



@WebMvcTest(ProductController.class)
public class ProductControllerWebMvcTest {

    @Autowired
    private MockMvc mockMvc;

//    @Autowired
//    private ProductController productController;

    @MockitoBean(name = "selfProductService")
    private ProductService productService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getAllProductsReturnEmptyList() throws Exception {

        when(productService.getAllProducts()).thenReturn(new ArrayList<>());

        mockMvc.perform(get("/products"))
                .andExpect(status().is(404))
                .andExpect(content().string("[]"));
    }

    @Test
    void returnListOfProductsWhenProductsAreFound() throws Exception {
        List<GenericProductDto> products = new ArrayList<>();
        products.add(new GenericProductDto());
        products.add(new GenericProductDto());
        products.add(new GenericProductDto());

        when(productService.getAllProducts())
                .thenReturn(products);

        mockMvc.perform(get("/products"))
                .andExpect(status().is(200))
                .andExpect(content().string(objectMapper.writeValueAsString(products)));
    }

    @Test
    void returnCreatedProduct() throws Exception {
        GenericProductDto productToCreate = new GenericProductDto();
        productToCreate.setTitle("iphone");
        productToCreate.setDescription("This is iphone");
        productToCreate.setImage("iphone image");
        productToCreate.setCategory("smartphone");
        productToCreate.setPrice(100000);

        GenericProductDto createdProduct = new GenericProductDto();
        createdProduct.setId(100L);
        createdProduct.setTitle("iphone");
        createdProduct.setDescription("This is iphone");
        createdProduct.setImage("iphone image");
        createdProduct.setCategory("smartphone");
        createdProduct.setPrice(100000);

        when(productService.createProduct(any()))
                .thenReturn(createdProduct);

        mockMvc.perform(post("/products")
                        .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(productToCreate))
        ).andExpect(content().string(objectMapper.writeValueAsString(createdProduct)))
                .andExpect((jsonPath("$.title", is("iphone"))))
        .andExpect((jsonPath("$.description", is("This is iphone"))));
        ;
    }


}


