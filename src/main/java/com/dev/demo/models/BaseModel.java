package com.dev.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@MappedSuperclass
public class BaseModel {
    @Id
    @GeneratedValue(generator = "amitosh")
    @GenericGenerator(name="amitosh", strategy = "uuid2")
    @Column(name="id", length = 36, nullable = false)
    private UUID id;
}
