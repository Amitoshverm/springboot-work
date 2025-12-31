package com.dev.demo.inherenetance.singletable;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "st_student")
public class Student extends User {
    private String batchName;
    private double psp;
    private double attendance;
}
