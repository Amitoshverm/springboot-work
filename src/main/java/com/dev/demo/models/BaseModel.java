package com.dev.demo.models;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@MappedSuperclass
public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @GenericGenerator(name="amitosh", strategy = "uuid2")
//    @Column(name="id", length = 36, nullable = false)
    private Long id;
}
