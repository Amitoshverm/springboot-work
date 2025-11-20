package com.dev.demo.models;

import lombok.Data;

@Data
public class Product extends BaseModel{
    private String title;
    private String description;
    private String category;
    private double price;
}
