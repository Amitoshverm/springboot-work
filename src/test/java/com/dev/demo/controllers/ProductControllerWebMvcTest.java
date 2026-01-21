package com.dev.demo.controllers;

import com.dev.demo.dtos.GenericProductDto;
import com.dev.demo.services.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


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



}


