package com.dev.demo.inherenetance.tabelperclass;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tpc_student")
public class Student extends User {
    private String batchName;
    private double psp;
    private double attendance;
}
