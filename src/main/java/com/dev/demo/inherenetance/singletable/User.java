package com.dev.demo.inherenetance.singletable;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name = "st_user")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "st_user", discriminatorType = DiscriminatorType.INTEGER)
@DiscriminatorValue(value="0")
public class User {
    @Id
    private Long id;
    private String name;
}
