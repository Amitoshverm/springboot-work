package com.dev.demo.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String addressLine;

    @OneToOne(mappedBy = "address")
    private Person person;
}
