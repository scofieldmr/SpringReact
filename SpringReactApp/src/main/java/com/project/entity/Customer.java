package com.project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name="customer1")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id",length = 50)
    private long customerid;

    @Column(name = "customer_name",length = 60)
    private String customername;

    @Column(name = "age",length = 5)
    private int age;

    @Column(name = "city",length = 60)
    private String city;

    @Column(name = "mobile",length = 15)
    private String mobile;


    public Customer(String customername, int age, String city, String mobile) {
        this.customername = customername;
        this.age = age;
        this.city = city;
        this.mobile = mobile;
    }
}
