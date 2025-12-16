package com.dev.demo.models;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Product extends BaseModel{
    private String title;
    private String description;
    private String category;
    private double price;
}
