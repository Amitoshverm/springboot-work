//package com.dev.demo.controllers;
//
//import com.dev.demo.dtos.GenericProductDto;
//import com.dev.demo.exceptions.NotFoundException;
//import com.dev.demo.services.ProductService;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.mockito.ArgumentCaptor;
//import org.mockito.Captor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.bean.override.mockito.MockitoBean;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//@SpringBootTest
//public class ProductControllerTest {
//
//    @Autowired
//    private ProductController productController;
//
//    @MockitoBean
//    private ProductService productService;
//
//    @Captor
//    private ArgumentCaptor<Long> idCaptor;
//
//    @Test
//    void testForGetProductById () throws NotFoundException {
////        GenericProductDto genericProductDto = productController.getProductById(12L);
//
//        when(productService.getProductById(any(Long.class))).thenReturn(null);
//
//        assertThrows(NotFoundException.class, () -> productController.getProductById(12L));
//    }
//
//    @Test
//    void testForNameOfTheProduct () throws NotFoundException {
//        GenericProductDto productDto = new GenericProductDto();
//        productDto.setTitle("test");
//        when(productService.getProductById(1L)).thenReturn(productDto);
//
//        GenericProductDto genericProductDto = productController.getProductById(1L);
//        assertEquals("test", genericProductDto.getTitle());
//    }
//
//    @Test
//    void testForNotFoundException() throws NotFoundException {
//        when(productService.getProductById(any(Long.class))).thenReturn(null);
//        assertThrows(NotFoundException.class, ()-> productController.getProductById(11L));
//    }
//
//    @Test
//    void returnSameProductAsServiceTest() throws NotFoundException {
//        GenericProductDto productDto = new GenericProductDto();
//        when(productService.getProductById(any(Long.class))).thenReturn(productDto);
//        assertEquals(productDto, productController.getProductById(1L));
//    }
//
//    @Test
//    @DisplayName("Addition of 1 + 1 should equal 2")
//    void testAdditionOnePlusOneEqualsTwo() {
//        assert 1 + 1 == 2;
//        assertEquals(2, 1 + 1, "1 + 1 should equal 2");
//    }
//
//    @Test
//    void testMultipleAdditionValues () {
//        assertTrue( 3 + 3 == 6, "3 + 3 should equal 6");
//        assert -3 + 3 == 0;
//        assert -3 + (-3) == -6;
//        assert 0 + 3 == 3;
//
//    }
//
//    @Test
//    void checkForIdAreGivingMeCorrectProduct() throws NotFoundException {
//        Long id = 101L;
//        when(productService.getProductById(any()))
//                .thenReturn(new GenericProductDto());
//
//        productController.getProductById(id);
//
//        verify(productService).getProductById(idCaptor.capture());
//
//        assertEquals(id, idCaptor.getValue());
//    }
//}
