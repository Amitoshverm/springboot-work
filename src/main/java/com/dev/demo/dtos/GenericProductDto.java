package com.dev.demo.dtos;

import lombok.Data;

@Data
public class GenericProductDto {
    private Long id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String image;

}
