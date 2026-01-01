package com.dev.demo.inherenetance.tabelperclass;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tpc_ta")
@DiscriminatorValue(value = "3")
public class TA extends User {
    private double avgRating;
}
