package com.dev.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Product extends BaseModel{
    private String title;
    private String description;

    @ManyToOne
    @JoinColumn(name = "category")
    private Category category;

    private double price;
}
