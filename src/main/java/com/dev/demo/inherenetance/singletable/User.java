package com.dev.demo.inherenetance.singletable;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@MappedSuperclass
public class User {
    @Id
    private Long id;
    private String name;
}
