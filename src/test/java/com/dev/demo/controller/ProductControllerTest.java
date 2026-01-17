package com.dev.demo.controller;

import com.dev.demo.controllers.ProductController;
import com.dev.demo.dtos.GenericProductDto;
import com.dev.demo.exceptions.NotFoundException;
import com.dev.demo.services.ProductService;
import com.dev.demo.services.SelfProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.junit.jupiter.api.Assertions.*;

public class ProductControllerTest {

    @Autowired
    private ProductController productController;

    @MockitoBean
    private ProductService productService;


    @Test
    void testForGetProductById () throws NotFoundException {
        GenericProductDto genericProductDto = productController.getProductById(121L);

        assertNull(genericProductDto);
    }

    @Test
    @DisplayName("Addition of 1 + 1 should equal 2")
    void testAdditionOnePlusOneEqualsTwo() {
        assert 1 + 1 == 2;
        assertEquals(2, 1 + 1, "1 + 1 should equal 2");
    }

    @Test
    void testMultipleAdditionValues () {
        assertTrue( 3 + 3 == 6, "3 + 3 should equal 6");
        assert -3 + 3 == 0;
        assert -3 + (-3) == -6;
        assert 0 + 3 == 3;

    }
}
