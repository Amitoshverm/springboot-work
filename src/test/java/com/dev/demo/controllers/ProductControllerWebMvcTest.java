//package com.dev.demo.controllers;
//
//import com.dev.demo.services.ProductService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.test.context.bean.override.mockito.MockitoBean;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.util.ArrayList;
//
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//
//    @WebMvcTest(ProductController.class)
//    @AutoConfigureMockMvc(addFilters = false)
//    public class ProductControllerWebMvcTest {
//
//        @Autowired
//        private MockMvc mockMvc;
//
//        @MockitoBean
//        private ProductService productService;
//
//        @Test
//        void getAllProductsReturnEmptyList() throws Exception {
//
//            when(productService.getAllProducts()).thenReturn(new ArrayList<>());
//
//            mockMvc.perform(get("/products"))
//                    .andExpect(status().is(200))
//                    .andExpect(content().string("[]"));
//        }
//    }
//
//
