package com.amirkenesbay.spring.rest.entity;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "name is required field")
    private String name;

    @Column(name = "max_salary")
    @Min(value = 500, message = "must be greater than 499")
    @Max(value = 1000, message = "must be less than 1001")
    @NotNull(message = "Max salary is required field")
    private Integer maxSalary;

    @Column(name = "min_salary")
    @Min(value = 500, message = "must be greater than 499")
    @Max(value = 1000, message = "must be less than 1001")
    @NotNull(message = "Min salary is required field")
    private Integer minSalary;

    public Department() {
    }

    public Department(String name, Integer maxSalary, Integer minSalary) {
        this.name = name;
        this.maxSalary = maxSalary;
        this.minSalary = minSalary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(Integer maxSalary) {
        this.maxSalary = maxSalary;
    }

    public Integer getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(Integer minSalary) {
        this.minSalary = minSalary;
    }
}
